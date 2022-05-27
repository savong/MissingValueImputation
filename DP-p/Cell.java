/*
Source code for the paper "Missing Value Imputation by Density-based Distance Likelihood" 
(https://github.com/savong/MissingValueImputation). 
This implementation is on top of the publicly released code (https://github.com/DLMImputation/DLM) of the method in the paper: 
Shaoxu Song and Yu Sun, "Imputing Various Incomplete Attributes via Distance likelihood," 
the 26th ACM SIGKDD Conference on Knowledge Discovery and Data Mining, p. 535-545, 
Virtual Event, CA, USA, August 23-27, 2020.
*/


public class Cell {
	private Position position;
	private String truth;
	private String modify;

	public Cell(Position position) {
		setPosition(position);
		setModify("0");
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getTruth() {
		return truth;
	}

	public void setTruth(String truth) {
		this.truth = truth;
	}

	public String getModify() {
		return modify;
	}

	public void setModify(String modify) {
		this.modify = modify;
	}
}
