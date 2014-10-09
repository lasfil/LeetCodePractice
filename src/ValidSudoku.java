import java.util.HashSet;
import java.util.Set;


public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        if (m % 3 != 0)
            return false;
        int n = board[0].length;
        if (n % 3 != 0)
            return false;
        
        for (int i = 0; i < m; i++) {
            if(!validRow(board, i))
                return false;
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (!validCol(board, j))
                        return false;
                }
                  
                
                if (i % 3 == 0 && j % 3 == 0) {
                    if (!validPart(board, i, j))
                        return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean validRow(char[][] board, int row) {
        int n = board[row].length;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < n; i++) {
            char c = board[row][i];
            if (c != '.' && (c < '0' || c > '9'))
                return false;
            if (c != '.' && set.contains(c))
                return false;
            else
                set.add(c);
        }
        
        return true;
    }
    
    public boolean validCol(char[][] board, int col) {
        int m = board.length;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < m; i++) {
            char c = board[i][col];
            if (c != '.' && (c < '0' || c > '9'))
                return false;
            if (c != '.' && set.contains(c))
                return false;
            else
                set.add(c);
        }
        
        return true;
    }
    
    public boolean validPart(char[][] board, int row, int col) {
        Set<Character> set = new HashSet<Character>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char c = board[i][j];
                if (c != '.' && (c < '0' || c > '9'))
                    return false;
                if (c != '.' && set.contains(c))
                    return false;
                else
                    set.add(c);
            }
        }
        
        return true;
    }
}
