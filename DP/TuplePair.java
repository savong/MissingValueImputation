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


public class TuplePair {

	private int rowIndex1;
	private int rowIndex2;

	public TuplePair(int rowIndex1, int rowIndex2) {
		setRowIndex1(rowIndex1);
		setRowIndex2(rowIndex2);
	}

	public int getRowIndex1() {
		return rowIndex1;
	}

	public void setRowIndex1(int rowIndex1) {
		this.rowIndex1 = rowIndex1;
	}

	public int getRowIndex2() {
		return rowIndex2;
	}

	public void setRowIndex2(int rowIndex2) {
		this.rowIndex2 = rowIndex2;
	}

	@Override
	public int hashCode() {
		final int prime = 101;
		int result = 1;
		result = prime * result + rowIndex1;
		result = prime * result + rowIndex2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TuplePair other = (TuplePair) obj;
		if (rowIndex1 != other.rowIndex1)
			return false;
		if (rowIndex2 != other.rowIndex2)
			return false;
		return true;
	}
}
