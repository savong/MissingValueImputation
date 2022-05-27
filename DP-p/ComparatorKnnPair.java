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



import java.util.Comparator;



public class ComparatorKnnPair implements Comparator<KnnPair>{
  @Override
  public int compare(KnnPair kp1, KnnPair kp2) {
    // TODO Auto-generated method stub
    double distance1 = kp1.getDistance();
    double distance2 = kp2.getDistance();
    
    if (distance1 > distance2) {
      return 1;
    } else if (distance1 < distance2) {
      return -1;
    }
    
    return 0;
  }

}
