package Searcha2DMatrixII_240;

public class Solution {
	private int[][] matrix;
	private int target;
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		this.matrix = matrix;
		int m = matrix.length;
		int n = matrix[0].length;
		this.target = target;
		return binarySearchHelper(0, 0, m-1, n-1);
	}
	
	private boolean binarySearchHelper(int stRow, int stCol, int endRow, int endCol) {
		if (stRow > endRow || stCol > endCol) return false;
		if (stRow == endRow && stCol == endCol) {
    		if (matrix[stRow][stCol] == target) return true;
    		else return false;
    	}
    	int midRow = stRow + (endRow - stRow) / 2; 
    	int midCol = stCol + (endCol - stCol) / 2;
    	if (matrix[midRow][midCol] == target) {
    		return true;
    	} else if (matrix[midRow][midCol] < target) {
    		// search the right side and bottom side!
    		return (binarySearchHelper(stRow, midCol+1, endRow, endCol) || 
    				binarySearchHelper(midRow+1, stCol, endRow, midCol));
    	} else {
    		// search the left side and bottom side!
    		return (binarySearchHelper(stRow, stCol, endRow, midCol-1) || 
    				binarySearchHelper(stRow, midCol, midRow-1, endCol));
    	}
	}
}
