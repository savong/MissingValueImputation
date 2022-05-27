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



public class LikelihoodPair {
	private double likelihood;
	private int index;

	public LikelihoodPair(double likelihood, int index) {
		setLikelihood(likelihood);
		setIndex(index);
	}

	public double getLikelihood() {
		return likelihood;
	}

	public void setLikelihood(double likelihood) {
		this.likelihood = likelihood;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
