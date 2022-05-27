# MissingValueImputation
Source code for the paper "Savong Bou, Toshiyuki Amagasa, Hiroyuki Kitagawa, Salman Ahmed Shaikh, Akiyoshi Matono, "Missing Value Imputation by Density-based Distance Likelihood"". This implementation is on top of the publicly released [code](https://github.com/DLMImputation/DLM) of the method in the paper: Shaoxu Song and Yu Sun, "[Imputing Various Incomplete Attributes via Distance likelihood](https://dl.acm.org/doi/10.1145/3394486.3403096)," the 26th ACM SIGKDD Conference on Knowledge Discovery and Data Mining, p. 535-545, Virtual Event, CA, USA, August 23-27, 2020.

## Contact
savong-hashimoto@cs.tsukuba.ac.jp

## Input
The directory for the input data:
* "/data"
  * dirty data file
  * correct data file
### Dataset:
All datasets used in the paper can be download from:
* [ASF](http://archive.ics.uci.edu/ml/datasets/Airfoil+Self-Noise)
* [Letter](https://archive.ics.uci.edu/ml/datasets/letter+recognition)
* [MAM](https://sci2s.ugr.es/keel/dataset.php?cod=86)
* [Restaurant](http://www.cs.utexas.edu/users/ml/riddle/data.html)
* [Solar-Flare](http://archive.ics.uci.edu/ml/datasets/solar+flare)
* [Mushroom](https://sci2s.ugr.es/keel/dataset.php?cod=178)
* [Adult](https://sci2s.ugr.es/keel/dataset.php?cod=192)

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

## Reference
* Shaoxu Song and Yu Sun. 2020. Imputing Various Incomplete Attributes via Distance Likelihood Maximization. In KDD 20: The 26th ACM SIGKDD Conference on Knowledge Discovery and Data Mining, Virtual Event, CA, USA, August 23-27, 2020, Rajesh Gupta, Yan Liu, Jiliang Tang, and B. Aditya Prakash (Eds.). ACM, 535–545. https://doi.org/10.1145/3394486.3403096
