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



public class RegModelParams {
  private double[] betas;
  private double sigma2;
  
  public RegModelParams(){
    
  }

  public double[] getBetas() {
    return betas;
  }

  public void setBetas(double[] betas) {
    this.betas = betas;
  }

  public double getSigma2() {
    return sigma2;
  }

  public void setSigma2(double sigma2) {
    this.sigma2 = sigma2;
  }
  
}
