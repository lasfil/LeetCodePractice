package com.cyandragon;
/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        int len = s.length();
        if (len == 0)
            return 0;
        if (!s.contains(" "))
            return s.length();
            
        int end = len - 1;
        while (end >=0 && s.charAt(end) == 32)
            end--;
        
        int l = 0;
        int h = 0;
        while (h <= end) {
            if (s.charAt(h) == 32) {
                l = h + 1;
            }
                h++;
        }
        
        return h - l;
    }
	
	public int lengthOfLastWord1(String s) {
		int i = s.length() - 1;
		while (i >= 0 && s.charAt(i) == ' ') {
			i--;
		}
		if (i < 0)
			return 0;
		int j = i;
		while (j - 1 >= 0 && s.charAt(j - 1) != ' ') {
			j--;
		}
		return i - j + 1;
	}
	
	public static void main(String[] args) {
		System.out.println(new LengthOfLastWord().lengthOfLastWord("a "));
	}
}
