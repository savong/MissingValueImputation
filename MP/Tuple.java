/*
Source code for the paper "Missing Value Imputation by Density-based Distance Likelihood" 
(https://github.com/savong/MissingValueImputation). 
This implementation is on top of the publicly released code (https://github.com/DLMImputation/DLM) of the method in the paper: 
Shaoxu Song and Yu Sun, "Imputing Various Incomplete Attributes via Distance likelihood," 
the 26th ACM SIGKDD Conference on Knowledge Discovery and Data Mining, p. 535-545, 
Virtual Event, CA, USA, August 23-27, 2020.
*/


public class Tuple {
	private int rowIndex;
	private int attrNum;
	private String[] args;
	private int[] status;

	public Tuple(int attrNum) {
		setAttrNum(attrNum);
		args = new String[attrNum];
		status = new int[attrNum];
	}

	public void buildTuple(int rowIndex, String[] vals) {
		setRowIndex(rowIndex);

		if (vals.length != attrNum) {
			System.out.println("Inconsistent attrNum !");
		}

		for (int i = 0; i < attrNum; ++i) {
			args[i] = vals[i];
		}
	}

	public void setAttrNum(int attrNum) {
		this.attrNum = attrNum;
	}


	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public void setStatusbyIndex(int attrIndex, int state) {
		this.status[attrIndex] = state;
	}

	public int[] getStatus() {
		return status;
	}

	public String[] getAllData() {
		return args;
	}

	public String getDataByIndex(int attrIndex) {
		return args[attrIndex];
	}

	public void clear() {
		for (int i = 0; i < attrNum; ++i) {
			status[i] = 1;
		}
	}
}
