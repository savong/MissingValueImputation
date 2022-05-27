/*
Source code for the paper "Missing Value Imputation by Density-based Distance Likelihood" 
(https://github.com/savong/MissingValueImputation). 
This implementation is on top of the publicly released code (https://github.com/DLMImputation/DLM) of the method in the paper: 
Shaoxu Song and Yu Sun, "Imputing Various Incomplete Attributes via Distance likelihood," 
the 26th ACM SIGKDD Conference on Knowledge Discovery and Data Mining, p. 535-545, 
Virtual Event, CA, USA, August 23-27, 2020.
*/



import java.util.Comparator;


public class ComparatorLikelihoodPair implements Comparator<LikelihoodPair> {
	@Override
	public int compare(LikelihoodPair lp1, LikelihoodPair lp2) {
		// TODO Auto-generated method stub
		double likelihood1 = lp1.getLikelihood();
		double likelihood2 = lp2.getLikelihood();
		if (likelihood1 < likelihood2) {
			return 1;
		} else if (likelihood1 > likelihood2) {
			return -1;
		}

		return 0;
	}

}
