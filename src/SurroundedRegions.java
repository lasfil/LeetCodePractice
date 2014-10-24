import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
		int m = board.length;
		int n = board[0].length;

		if (m < 3 || n < 3)
			return;

		boolean[][] live = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O')
				live[i][0] = true;
			if (board[i][n - 1] == 'O')
				live[i][n - 1] = true;
		}
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O')
				live[0][j] = true;
			if (board[m - 1][j] == 'O')
				live[m - 1][j] = true;
		}

		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (board[i][j] == 'O'
						&& (live[i][j] || live[i - 1][j] || live[i + 1][j]
								|| live[i][j - 1] || live[i][j + 1]))
					markLive(board, i, j, live);
			}
		}

		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (board[i][j] == 'O' && !live[i][j])
					board[i][j] = 'X';
			}
		}
	}

	private void markLive(char[][] board, int i, int j, boolean[][] live) {

		live[i][j] = true;
		int k = i - 1;
		while (k > 0 && board[k][j] == 'O' && !live[k][j]) {
			//live[k--][j] = true;
			markLive(board, k--, j, live);
		}
		k = j - 1;
		while (k > 0 && board[i][k] == 'O' && !live[i][k]) {
			//live[i][k--] = true;
			markLive(board, i, k--, live);
		}
		k = i + 1;
		while (k < board.length - 1 && board[k][j] == 'O' && !live[k][j]) {
			//live[k++][j] = true;
			markLive(board, k++, j, live);
		}
		k = j + 1;
		while (k < board[0].length - 1 && board[i][k] == 'O' && !live[i][k]) {
			//live[i][k++] = true;
			markLive(board, i, k++, live);
		}
	}
	
    public void solve2(char[][] board) {
		int row = board.length;
		if (row == 0)
			return;
		int col = board[0].length;
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if ((i == 0 || i == row - 1 || j == 0 || j == col - 1)
						&& board[i][j] == 'O') {
					qx.add(i);
					qy.add(j);
				}
			}
		}
		while (!qx.isEmpty()) {
			int x = qx.remove();
			int y = qy.remove();
			board[x][y] = '@';
			if (x > 0 && board[x - 1][y] == 'O') {
				qx.add(x - 1);
				qy.add(y);
			}
			if (x < row - 1 && board[x + 1][y] == 'O') {
				qx.add(x + 1);
				qy.add(y);
			}
			if (y > 0 && board[x][y - 1] == 'O') {
				qx.add(x);
				qy.add(y - 1);
			}
			if (y < col - 1 && board[x][y + 1] == 'O') {
				qx.add(x);
				qy.add(y + 1);
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == '@') {
					board[i][j] = 'O';
				} else {
					board[i][j] = 'X';
				}
			}
		}
		return;
	}
	public static void main(String[] args) {
		String[] s = new String[] { "OOXOOXOOOOOOOOXXOXOO",
									"OXOOOOXXOOOXOOXXOOOO", 
									"XOXXOOOOOXOOOXOXXXXO",
									"XXOOOOOOOOXOOXXXXXXX", 
									"OOOOOXOOOXXXXOXOOOOO",
									"OXXXOOOXOXOXOOXOXXOO", 
									"OOOOOOOOXXXOOXXOOOOO",
									"OXXOOOOOXOXXOXXOOXOO", 
									"OOXXXOOXOOOOOOOXXXOX",
									"XXOOOXOXOOOXXOOXOXXO", 
									"OOOOOOXOXXOOXOXXXXOX",
									"OOXXOOXOXOOXOOXOOXOX", 
									"OXOOOOOXOOOOOOXXXOOO",
									"OOXOXOOXXOXXXOOXXOOX", 
									"XOXOXOXOOOOOOOXOOXXO",
									"XOXXXOXOOOOOOXOOOOXX", 
									"XOOOOXOOOOOOXOOOOOXX",
									"OOOOOOXOOOXOXOXXOXOX", 
									"XOOXOOOOOOXOOOOOXXXX",
									"OOOXXOOOOOOOOXOOOXOO" };

		char[][] board = new char[s.length][];
		for (int i = 0; i < s.length; i++) {
			board[i] = s[i].toCharArray();
		}
		new SurroundedRegions().solve2(board);

	}
}
