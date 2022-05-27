/*
Source code for the paper "Missing Value Imputation by Density-based Distance Likelihood" 
(https://github.com/savong/MissingValueImputation). 
This implementation is on top of the publicly released code (https://github.com/DLMImputation/DLM) of the method in the paper: 
Shaoxu Song and Yu Sun, "Imputing Various Incomplete Attributes via Distance likelihood," 
the 26th ACM SIGKDD Conference on Knowledge Discovery and Data Mining, p. 535-545, 
Virtual Event, CA, USA, August 23-27, 2020.
*/


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class FileHandler {

	private String PATH = "./data/";

	public Db_Miss readData(String input) {
		Database db = new Database();
		ArrayList<Cell> cells = new ArrayList<>();
                Map<Integer, ArrayList<Integer>> tup_with_missAtt = new HashMap<>();
		try {
			FileReader fr = new FileReader(PATH + input);
			BufferedReader br = new BufferedReader(fr);

			String line = null;
			String[] vals = null;

			String title = br.readLine();
			int attrNum = title.split(",").length;
			db.setAttrNum(attrNum);
			boolean[] isNumerical = new boolean[attrNum];
			double[] minVals = new double[attrNum];
			double[] maxVals = new double[attrNum];
			for (int attri = 0; attri < attrNum; attri++) {
				isNumerical[attri] = true;
				minVals[attri] = Double.MAX_VALUE;
				maxVals[attri] = -Double.MAX_VALUE;
			}

			int rowIndex = 0;
			while ((line = br.readLine()) != null) {
                                ArrayList<Integer> missAtt = new ArrayList<>();
				vals = line.split(",");
				String[] data = new String[attrNum];
				for (int i = 0; i < attrNum; ++i) {
					if (i >= vals.length || vals[i].equals("")) {
                                                missAtt.add(i);
						Position pos = new Position(rowIndex, i);
						Cell cell = new Cell(pos);
						cells.add(cell);
					} else {
						data[i] = vals[i].trim();
                                                //added by savong 2021511
                                                //if (vals[i].trim() != null)
                                                //    data[i] = vals[i].trim()+" savong";
                                                //ended addition by savong 2021511
						if (!Assist.isNumber(data[i])) {
							isNumerical[i] = false;
						} else {
							double tmpVal = Double.parseDouble(data[i]);
							if (tmpVal < minVals[i]) {
								minVals[i] = tmpVal;
							}
							if (tmpVal > maxVals[i]) {
								maxVals[i] = tmpVal;
							}
						}
					}
				}
                                if (missAtt.size()>0)
                                    tup_with_missAtt.put(rowIndex, missAtt);
				Tuple tp = new Tuple(attrNum);
				tp.buildTuple(rowIndex, data);
				db.addTuple(tp);
				rowIndex++;
			}
			db.setIsNumerical(isNumerical);
			db.setMaxVals(maxVals);
			db.setMinVals(minVals);
			int size = db.getLength();
			db.setFlags(new int[size][attrNum]);
			db.setCells(cells);
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.clear();
                return new Db_Miss(db, tup_with_missAtt);
		//return db;
	}

}
