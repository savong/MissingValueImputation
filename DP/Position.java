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


public class Position {
	private int rowIndex;
	private int attrIndex;

	public Position(int rowIndex, int attrIndex) {
		setRowIndex(rowIndex);
		setAttrIndex(attrIndex);
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public int getAttrIndex() {
		return attrIndex;
	}

	public void setAttrIndex(int attrIndex) {
		this.attrIndex = attrIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 101;
		int result = 1;
		result = prime * result + attrIndex;
		result = prime * result + rowIndex;
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
		Position other = (Position) obj;
		if (attrIndex != other.attrIndex)
			return false;
		if (rowIndex != other.rowIndex)
			return false;
		return true;
	}
}
