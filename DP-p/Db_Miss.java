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


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author savong.hashimoto
 */
final class Db_Miss {
    Database db = new Database();
    Map<Integer, ArrayList<Integer>> tup_with_missAtt = new HashMap<>();
    
    public Db_Miss(Database db, Map<Integer, ArrayList<Integer>> tup_with_missAtt) {
        this.db = db;
        this.tup_with_missAtt = tup_with_missAtt;
    }
    
    public Database getDB() {
        return db;
    }

    public Map<Integer, ArrayList<Integer>> getMissAtt() {
        return tup_with_missAtt;
    }

}
