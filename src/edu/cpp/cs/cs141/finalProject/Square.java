/**
 * 
 */
package edu.cpp.cs.cs141.finalProject;

/**
 * The Square class has a superclass constructor. It has symbol and position,
 * the row and column.
 * 
 */
public class Square {
	public Square(String symbol, int row, int col) {
		super();
	}

	/**
	 * 
	 */
	String symbol = "X";

	/**
	 * 
	 */
	int row;

	/**
	 * 
	 */
	int col;

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol
	 *            the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row
	 *            the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col
	 *            the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}

}
