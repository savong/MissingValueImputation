
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
