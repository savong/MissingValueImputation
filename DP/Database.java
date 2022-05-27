/*
Source code for the paper "Missing Value Imputation by Density-based Distance Likelihood" 
(https://github.com/savong/MissingValueImputation). 
This implementation is on top of the publicly released code (https://github.com/DLMImputation/DLM) of the method in the paper: 
Shaoxu Song and Yu Sun, "Imputing Various Incomplete Attributes via Distance likelihood," 
the 26th ACM SIGKDD Conference on Knowledge Discovery and Data Mining, p. 535-545, 
Virtual Event, CA, USA, August 23-27, 2020.
*/


import java.util.ArrayList;

public class Database {

	private int attrNum;
	private ArrayList<Tuple> tpList;
	private int[][] flags;
	private ArrayList<Integer> compRowIndexList;
	private ArrayList<Integer> misRowIndexList;
	private ArrayList<Cell> cells;

	private boolean[] isNumerical;
	private double[] minVals;
	private double[] maxVals;

	public Database() {
		setTpList(new ArrayList<Tuple>());
	}

	public Database(int attrNum, ArrayList<Tuple> tpList) {
		setAttrNum(attrNum);
		setTpList(tpList);
		setFlags(new int[tpList.size()][attrNum]);
		setCompRowIndexList(new ArrayList<Integer>());
		setMisRowIndexList(new ArrayList<Integer>());
		setCells(new ArrayList<Cell>());
		setIsNumerical(new boolean[attrNum]);
		setMinVals(new double[attrNum]);
		setMaxVals(new double[attrNum]);
	}

	public void addTuple(Tuple tp) {
		this.tpList.add(tp);
	}

	public Tuple getTupleByRowIndex(int rowIndex) {
		for (Tuple tp : tpList) {
			if (tp.getRowIndex() == rowIndex) {
				return tp;
			}
		}
		return null;
	}

	public int getLength() {
		return tpList.size();
	}

	public void clear() {
		for (Tuple tp : tpList) {
			tp.clear();
		}
		int size = tpList.size();
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < attrNum; ++j) {
				flags[i][j] = 1;
			}
		}
	}

	public int getAttrNum() {
		return attrNum;
	}

	public void setAttrNum(int attrNum) {
		this.attrNum = attrNum;
	}

	public ArrayList<Tuple> getTpList() {
		return tpList;
	}

	public void setTpList(ArrayList<Tuple> tpList) {
		this.tpList = tpList;
	}

	public int[][] getFlags() {
		return flags;
	}

	public void setFlags(int[][] flags) {
		this.flags = flags;
	}

	public ArrayList<Integer> getCompRowIndexList() {
		return compRowIndexList;
	}

	public void setCompRowIndexList(ArrayList<Integer> compRowIndexList) {
		this.compRowIndexList = compRowIndexList;
	}

	public ArrayList<Integer> getMisRowIndexList() {
		return misRowIndexList;
	}

	public void setMisRowIndexList(ArrayList<Integer> misRowIndexList) {
		this.misRowIndexList = misRowIndexList;
	}

	public ArrayList<Cell> getCells() {
		return cells;
	}

	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	public boolean[] getIsNumerical() {
		return isNumerical;
	}

	public void setIsNumerical(boolean[] isNumerical) {
		this.isNumerical = isNumerical;
	}

	public double[] getMinVals() {
		return minVals;
	}

	public void setMinVals(double[] minVals) {
		this.minVals = minVals;
	}

	public double[] getMaxVals() {
		return maxVals;
	}

	public void setMaxVals(double[] maxVals) {
		this.maxVals = maxVals;
	}

}
