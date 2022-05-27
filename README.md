# MissingValueImputation
Source code for the paper "Missing Value Imputation by Density-based Distance Likelihood". This implementation is on top of the publicly released [code](https://github.com/DLMImputation/DLM) of the method in the paper: Shaoxu Song and Yu Sun, "[Imputing Various Incomplete Attributes via Distance likelihood](https://dl.acm.org/doi/10.1145/3394486.3403096)," the 26th ACM SIGKDD Conference on Knowledge Discovery and Data Mining, p. 535-545, Virtual Event, CA, USA, August 23-27, 2020.



## Input
The directory for the input data:
* "/data"
  * dirty data file
  * correct data file


## Output
* There are four output data:
  * The predicted value
  * The correct value
  * The overall RMS for missed attribute values that are numerical
  * The overal accuracy for the missed attribute values that are categorical.

* Each predicted value of the missed attribute values of the incomplete records consist of:
  * Index of the incomplete record
  * Index of the missed attribute value
  * The predicted value

## Parameter
### Method

#### setParams(K, L, Can);
* K: the number of considered largest likelihoods 
* L: the number of learning neighbors for distance models
* Can: the number of candidates for imputation

## Library
[jama.jar](https://math.nist.gov/javanumerics/jama/) is needed to run the code.


