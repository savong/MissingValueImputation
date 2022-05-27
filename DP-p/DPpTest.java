/*
Source code for the paper "Missing Value Imputation by Density-based Distance Likelihood" 
(https://github.com/savong/MissingValueImputation). 
This implementation is on top of the publicly released code (https://github.com/DLMImputation/DLM) of the method in the paper: 
Shaoxu Song and Yu Sun, "Imputing Various Incomplete Attributes via Distance likelihood," 
the 26th ACM SIGKDD Conference on Knowledge Discovery and Data Mining, p. 535-545, 
Virtual Event, CA, USA, August 23-27, 2020.
*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DLMTest {

	public static void main(String[] agrs) {
		String dataset = "res";
		String fileName = dataset + "-dirty.data";
                String fileName_answer = dataset + "-answer.data";

		FileHandler fh = new FileHandler();
		//Database db = fh.readData(fileName);
                Db_Miss db_miss = fh.readData(fileName);
                Database db = db_miss.getDB();
                Map<Integer, ArrayList<Integer>> tup_with_missAtt = db_miss.getMissAtt();

                //Added by savong
                FileHandler_Answer ans = new FileHandler_Answer();
                Map<Integer, Map<Integer, String>> db_answer = ans.readData(fileName_answer, tup_with_missAtt);
                //Ended addition by savong
                
		final int K = 10;
		final int L = 10;
		final int Can = 10;

		DPp dlm = new DPp(db);
		dlm.setParams(K, L, Can);
		HashMap<Position, Cell> cellMap = dlm.mainDLM();
                
                double TF=0;
                double T=0;
                double F=0;
                double rme = 0;
		for (Position pos : cellMap.keySet()) {
			Cell cell = cellMap.get(pos);
			System.out.println(cell.getPosition().getRowIndex() + "," + cell.getPosition().getAttrIndex() + ","
					+ cell.getModify());
                        
                         //edded by savong
                        System.out.println("Correct Result");
                        String g_truth = db_answer.get(cell.getPosition().getRowIndex()).get(cell.getPosition().getAttrIndex());
                        System.out.println(cell.getPosition().getRowIndex() + "," + cell.getPosition().getAttrIndex() + ","
					+ g_truth);

                        //Computing score-----------
                        //1. Categorical value: accuracy = |truth, found|/|truth|
                        //2. Numerical value: RMS = sqrt[((x1-x2)^2)/n]
                        if(Assist.isNumber(cell.getModify()))
                        {
                            double truth = 0;
                            double predict = 0;
                            if(g_truth.length()==0)
                                truth=0;
                            else
                                truth = 10;
                                //truth = Double.parseDouble(g_truth);
                            if(cell.getModify().length() ==0)
                                predict = 0;
                            else
                                predict = Double.parseDouble(cell.getModify());
                            rme += Math.pow(truth - predict, 2);
                            //rme += Math.pow(Double.parseDouble(g_truth) - Double.parseDouble(cell.getModify()), 2);
                        }
                        else
                        {
                            if(cell.getModify() != "")
                                F++;
                            if(g_truth != "")
                                T++;

                            if(cell.getModify().equals(g_truth))
                                TF++;
                        }
		}
                System.out.println("Numerical Accuracy: "+ Math.sqrt(rme));
                System.out.println("Categorical Accuracy: "+ TF/T);
	}
}
