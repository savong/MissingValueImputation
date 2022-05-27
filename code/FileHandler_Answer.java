/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author savong.hashimoto
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class FileHandler_Answer {
    
	private String PATH = "./data/";

	public Map<Integer, Map<Integer, String>> readData(String input, Map<Integer, ArrayList<Integer>> tup_with_missAtt) {
            Map<Integer, Map<Integer, String>> tup_missAtt_Answer = new HashMap<>();
            try {
                    FileReader fr = new FileReader(PATH + input);
                    BufferedReader br = new BufferedReader(fr);

                    String line = null;
                    String[] vals = null;

                    String title = br.readLine();
                    int attrNum = title.split(",").length;

                    int rowIndex = 0;
                    while ((line = br.readLine()) != null) {
                        if (tup_with_missAtt.containsKey(rowIndex))
                        {
                            vals = line.split(",");
                            Map<Integer, String> Ans_ele = new HashMap<>();
                            for (int i = 0; i < attrNum; ++i) {
                                if(tup_with_missAtt.get(rowIndex).contains(i))
                                {
                                    if (i >= vals.length)
                                        Ans_ele.put(i, "");
                                    else
                                        Ans_ele.put(i, vals[i]);
                                }
                            }
                            if(!Ans_ele.isEmpty())
                                tup_missAtt_Answer.put(rowIndex, Ans_ele);
                        }
                        rowIndex++;
                    }
                    br.close();
                    fr.close();
            } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            return tup_missAtt_Answer;
	}
}
