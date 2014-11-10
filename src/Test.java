
public class Test {
	public static void main(String[] args) {
		char[][] board = new char[][]{{'a','a'}};
		char[][] board1 = new char[][]{{'a','a'}};
		System.out.println(new Anagrams().anagrams(new String[]{"abcde","bcdae","abbde", "babde", "abc", "def"}));
		System.out.println(board.equals(board1));
	}
}
