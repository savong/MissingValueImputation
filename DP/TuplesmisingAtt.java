/*
Source code for the paper "Missing Value Imputation by Density-based Distance Likelihood" 
by Savong Bou (University of Tsukuba), Toshiyuki Amagasa (University of Tsukuba), 
Hiroyuki Kitagawa (University of Tsukuba), Salman Ahmed Shaikh (AIST), and Akiyoshi Matono (AIST). 
This implementation is on top of the publicly released code of the method in the paper: 
Shaoxu Song and Yu Sun, "Imputing Various Incomplete Attributes via Distance likelihood," 
the 26th ACM SIGKDD Conference on Knowledge Discovery and Data Mining, p. 535-545, 
Virtual Event, CA, USA, August 23-27, 2020.

Contact: savong-hashimoto@cs.tsukuba.ac.jp
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author savong.hashimoto
 */
public class TuplesmisingAtt {
    private String PATH = "./data/";
    public Map<Integer, ArrayList<Integer>> readData1(String input) {
        ArrayList<Integer> missAtt = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> tup_with_missAtt = new HashMap<>();
        try {
            FileReader fr = new FileReader(PATH + input);
            BufferedReader br = new BufferedReader(fr);

            String line = null;
            String[] vals = null;

            String title = br.readLine();
            int attrNum = title.split(",").length;
            
            int rowIndex = 0;
            while ((line = br.readLine()) != null) {
                    vals = line.split(",");
                    String[] data = new String[attrNum];
                    for (int i = 0; i < attrNum; ++i) {
                            if (i >= vals.length || vals[i].equals("")) {
                                missAtt.add(i);
                            }
                    }
                    if (missAtt.size()>0)
                        tup_with_missAtt.put(rowIndex, missAtt);
            }
                                        
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return tup_with_missAtt;
    }
}
