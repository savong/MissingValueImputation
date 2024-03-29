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


import java.util.Arrays;

public class RegModel {
  private int[] attrXs;
  private int attrY;
  private double[] beta;
  
  public RegModel(int[] attrXs, int attrY) {
    setAttrXs(attrXs);
    setAttrY(attrY);
  }
  
  public int[] getAttrXs() {
    return attrXs;
  }

  public void setAttrXs(int[] attrXs) {
    this.attrXs = attrXs;
    Arrays.sort(this.attrXs);
  }
  
  public int getAttrY() {
    return attrY;
  }

  public void setAttrY(int attrY) {
    this.attrY = attrY;
  }

  public double[] getBeta() {
    return beta;
  }

  public void setBeta(double[] beta) {
    this.beta = beta;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    
    for (int attrX : attrXs) {
      result = prime * result + attrX;
    }
    result = prime * result + attrY;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    RegModel other = (RegModel) obj;
    if (attrY != other.getAttrY()) {
      return false;
    }
    if (attrXs.length != other.getAttrXs().length) {
      return false;
    }
    
    for (int i = 0; i < attrXs.length; ++i) {
      if (attrXs[i] != other.getAttrXs()[i]) {
        return false;
      }
    }
    return true;
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    
    sb.append("[");
    for (int attrX : attrXs) {
      sb.append(attrX + ",");
    }
    sb.deleteCharAt(sb.length() - 1);
    sb.append("]");
    sb.append("->");
    sb.append(attrY);
    
    return sb.toString();
  }
  
}
