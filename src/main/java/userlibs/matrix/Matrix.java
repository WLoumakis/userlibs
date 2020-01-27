package userlibs.matrix;

import userlibs.exceptions.matrix.ElementTypeException;
import userlibs.exceptions.matrix.MatrixDimensionMismatchException;

import static java.lang.Math.log;

public class Matrix implements Element {

	private Element[/*Rows*/][/*Columns*/] elements;

	public Matrix() {
		elements = null;
	}

	public Matrix(Element[][] elements) {
		this.elements = elements;
	}

	/**
	 * Adds two matrices together.
	 *
	 * @param A the first matrix
	 * @param B the second matrix
	 * @return the resultant sum matrix
	 * @throws MatrixDimensionMismatchException if the two matrices' dimensions are not the same
	 * @throws ElementTypeException if the two matrices' elements are not the same type
	 */
	public static Matrix plus(Matrix A, Matrix B) throws MatrixDimensionMismatchException, ElementTypeException {
		if (!haveSameDimension(A, B))
			throw new MatrixDimensionMismatchException("Matrices must have the same dimensions when adding!");
		if (A.get(0, 0).getClass() != B.get(0, 0).getClass())
			throw new ElementTypeException("Cannot add matrices with different types of Elements!");
		int numRows = getNumRows(A);
		int numCols = getNumColumns(A);

		Element[][] newElements = new Element[numRows][numCols];

		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numCols; j++)
				newElements[i][j] = A.get(0,0).getClass().plus(A.get(i, j), B.get(i, j)); //TODO: Figure out how to use the runtime static method based on runtime types

		return new Matrix(newElements);
	}

	/**
	 * Gets the element at row i, column j.
	 *
	 * @param i the row
	 * @param j the column
	 * @return the Element at (i, j) | null if an error occurred
	 */
	public Element get(int i, int j) {
		Element ret = null;
		try {
			ret = elements[i][j];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * Multiplies two Matrices using the Strassen Algorithm.
	 *
	 * @param A The first Matrix
	 * @param B The second Matrix
	 * @return A Matrix representing the result of multiplying A and B
	 * @throws MatrixDimensionMismatchException If the number of columns in A does not match the number of rows in B.
	 */
	public static Matrix multiply(Matrix A, Matrix B) throws MatrixDimensionMismatchException {
		int numColsA = getNumColumns(A);
		int numRowsB = getNumRows(B);
		if (numColsA != numRowsB)
			throw new MatrixDimensionMismatchException("The number of columns in Matrix A must match the number of rows in Matrix B in order to multiply!");
		int numRowsA = getNumRows(A);
		int numColsB = getNumColumns(B);

		Element[][] newElements = new Element[numRowsA][numColsB];

		Matrix APadded = pad(A);
		Matrix BPadded = pad(B);

		//TODO: implement Strassen's Algorithm
		return null;
	}

	public Element[][] getElements() {
		return elements;
	}

	public void setElements(Element[][] elements) {
		this.elements = elements;
	}

	public static boolean haveSameDimension(Matrix A, Matrix B) {
		return (getNumRows(A) == getNumRows(B)) && (getNumColumns(A) == getNumColumns(B));
	}

	public static int getNumRows(Matrix A) {
		return A.elements != null ? A.elements.length : 0;
	}

	public static int getNumColumns(Matrix A) {
		return A.elements != null ? A.elements[0].length : 0;
	}

	/**
	 * Pads a Matrix by adding rows/columns with identity Elements such that the number of rows and columns are powers of two.
	 * If both the number of rows and columns of the input Matrix are powers of two, the input Matrix is returned.
	 *
	 * @param A The matrix to be padded
	 * @return The padded matrix
	 */
	public static Matrix pad(Matrix A) {
		if (isPowerOfTwo(getNumRows(A)) && isPowerOfTwo(getNumColumns(A)))
			return A;

		if (!isPowerOfTwo(getNumRows(A))) {
			//TODO: implement padding of rows
		}

		//TODO: return a padded Matrix
		return null;
	}

	private double log2(int a) {
		return (log(a) / log(2));
	}

	private static boolean isPowerOfTwo(int n) {
		return n > 0 && (n & n - 1) == 0;
	}

	@Override
	public boolean equals(Element e) {
		if (!(e instanceof Matrix))
			return false;

		Matrix A = (Matrix) e;
		if (getNumRows(this) != getNumRows(A) && getNumColumns(this) != getNumColumns(A))
			return false;

		for (int i = 0; i < getNumRows(this); i++)
			for (int j = 0; j < getNumColumns(this); i++)
				if (!this.get(i, j).equals(A.get(i, j)))
					return false;
		return true;
	}

}
