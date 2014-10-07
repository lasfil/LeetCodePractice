/** 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		if (m == 0)
			return false;
		return searchMatrix(matrix, target, 0, m - 1);

	}

	public boolean searchMatrix(int[][] matrix, int target, int start, int end) {
		if (start == end) {
			return searchMatrix(matrix[start], target, 0,
					matrix[start].length - 1);
		}

		if (start == end)
			return searchMatrix(matrix[0], target, 0, matrix[0].length);
		boolean result = false;
		int mid = (end - start + 1) / 2 + start;
		if (matrix[mid][0] == target)
			return true;
		else if (matrix[mid][0] > target)
			result = searchMatrix(matrix, target, start, mid - 1);
		else if (matrix[mid][0] < target)
			result = searchMatrix(matrix, target, mid, end);
		return result;

	}

	public boolean searchMatrix(int[] row, int target, int start, int end) {
		if (start >= end) {
			if (row[start] == target)
				return true;
			else
				return false;
		}
		boolean result = false;
		int mid = (end - start) / 2 + start;
		if (row[mid] == target)
			return true;
		else if (row[mid] > target)
			result = searchMatrix(row, target, start, mid - 1);
		else if (row[mid] < target)
			result = searchMatrix(row, target, mid + 1, end);
		return result;
	}
	
	public static void main(String[] args) {
		int[][] m = new int[][]{{1, 1}};
		System.out.println(new SearchMatrix().searchMatrix(m, 0));
	}
}
