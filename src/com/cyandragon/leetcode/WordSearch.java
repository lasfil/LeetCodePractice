package com.cyandragon.leetcode;
/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [ ["ABCE"], ["SFCS"], ["ADEE"] ]
 * 
 * word = "ABCCED", -> returns true, word = "SEE", -> returns true, word =
 * "ABCB", -> returns false.
 */

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0)
			return true;
		if (board == null || board.length == 0)
			return false;
		boolean[][] marked = new boolean[board.length][board[0].length];

		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(0)) {
					marked[i][j] = true;
					boolean result = dfs(board, word, 1, marked, i, j);
					if (result)
						return true;
					else
						marked[i][j] = false;
				}

			}
		}
		return false;

	}

	private boolean dfs(char[][] board, String word, int index,
			boolean[][] marked, int row, int col) {
		if (index == word.length())
			return true;
		int m = board.length;
		int n = board[0].length;
		boolean result = false;
		if (row > 0 && !marked[row - 1][col]
				&& board[row - 1][col] == word.charAt(index)) {
			marked[row - 1][col] = true;
			result = dfs(board, word, index + 1, marked, row - 1, col);
			if (result)
				return true;
			else
				marked[row - 1][col] = false;
		}

		if (row < m - 1 && !marked[row + 1][col]
				&& board[row + 1][col] == word.charAt(index)) {
			marked[row + 1][col] = true;
			result = dfs(board, word, index + 1, marked, row + 1, col);
			if (result)
				return true;
			else
				marked[row + 1][col] = false;
		}

		if (col < n - 1 && !marked[row][col + 1]
				&& board[row][col + 1] == word.charAt(index)) {
			marked[row][col + 1] = true;
			result = dfs(board, word, index + 1, marked, row, col + 1);
			if (result)
				return true;
			else
				marked[row][col + 1] = false;
		}

		if (col > 0 && !marked[row][col - 1]
				&& board[row][col - 1] == word.charAt(index)) {
			marked[row][col - 1] = true;
			result = dfs(board, word, index + 1, marked, row, col - 1);
			if (result)
				return true;
			else
				marked[row][col - 1] = false;
		}

		return false;
	}
}
