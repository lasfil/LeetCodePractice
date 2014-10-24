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
				markLive(board, i, 0, live);
			if (board[i][n - 1] == 'O')
				markLive(board, i, n - 1, live);
		}
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O')
				markLive(board, 0, j, live);
			if (board[m - 1][j] == 'O')
				markLive(board, m - 1, j, live);
		}

		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (board[i][j] == 'O'
						&& (live[i][j] || live[i - 1][j] || live[i + 1][j]
								|| live[i][j - 1] || live[i][j + 1]))
					markLive(board, i, j, live);
			}
		}
		for (int i = m - 2; i > 0; i--) {
			for (int j = n - 2; j > 0; j--) {
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
		return;
	}

	private void markLive(char[][] board, int i, int j, boolean[][] live) {

		live[i][j] = true;
		int k = i - 1;
		while (k > 0 && board[k][j] == 'O' && !live[k][j]) {
			live[k--][j] = true;
			// markLive(board, i - 1, j, live);
		}
		k = j - 1;
		while (k > 0 && board[i][k] == 'O' && !live[i][k]) {
			live[i][k--] = true;
			// markLive(board, i, j - 1, live);
		}
		k = i + 1;
		while (k < board.length - 1 && board[k][j] == 'O' && !live[k][j]) {
			live[k++][j] = true;
			// markLive(board, i + 1, j, live);
		}
		k = j + 1;
		while (k < board[0].length - 1 && board[i][k] == 'O' && !live[i][k]) {
			live[i][k++] = true;
			// markLive(board, i, j + 1, live);
		}
	}
	public void solve1(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        
        if (m < 3 || n < 3)
            return;
        
        boolean[][] live = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                markLive1(board, i, 0, live);
            if (board[i][n - 1] == 'O')
                markLive1(board, i, n - 1, live);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                markLive1(board, 0, j, live);
            if (board[m - 1][j] == 'O')
                markLive1(board, m - 1, j, live);
        }
        
        for (int i = 1; i < m -1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !live[i][j])
                    board[i][j] = 'X';
            }
        }
        return;
    }
    
    private void markLive1(char[][] board, int i, int j, boolean[][] live) {
        if (live[i][j])
            return;
        live[i][j] = true;
        if (i > 0 && board[i - 1][j] == 'O' && !live[i - 1][j]) {
            //live[i - 1][j] = true;
            markLive(board, i - 1, j, live);
        }
        if (j > 0 && board[i][j - 1] == 'O' && !live[i][j - 1]) {
            //live[i][j - 1] = true;
            markLive(board, i, j - 1, live);
        }
        if (i < board.length - 1 && board[i + 1][j] == 'O' && !live[i + 1][j]) {
            //live[i + 1][j] = true;
            markLive(board, i + 1, j, live);
        }
        if (j < board[0].length - 1 && board[i][j + 1] == 'O' && !live[i][j + 1]) {
            //live[i][j - 1] = true;
            markLive(board, i, j + 1, live);
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
