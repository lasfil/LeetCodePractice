import java.util.Set;
import java.util.HashSet;

public class SetMatrixZeros {

	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			return;
		int n = matrix[0].length;
		Set<Integer> zerocol = new HashSet<Integer>();
		Set<Integer> zerorow = new HashSet<Integer>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					zerocol.add(j);
					zerorow.add(i);
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (zerocol.contains(j) || zerorow.contains(i)) {
					matrix[i][j] = 0;
				}
			}
		}

	}

	public void setZeroes1(int[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			return;
		int n = matrix[0].length;
		boolean firstzerorow = false;
		boolean firstzerocol = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0)
						firstzerorow = true;
					if (j == 0)
						firstzerocol = true;
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (firstzerocol) {
			for (int i = 1; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
		if (firstzerorow) {
			for (int j = 1; j < n; j++) {
				matrix[0][j] = 0;
			}
		}

	}

	public static void main(String[] args) {
		// int[][] m = new int[][] { { 0, 0, 0, 5 }, { 4, 3, 1, 4 },
		// { 0, 1, 1, 4 }, { 1, 2, 1, 3 }, { 0, 0, 1, 1 } };
		int[][] m = new int[][] { { 1, 0, 3 } };
		new SetMatrixZeros().setZeroes1(m);
		System.out.println(m);
	}
}
