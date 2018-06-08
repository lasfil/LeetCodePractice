package com.zinkirin;
import java.util.ArrayList;
/**
 * Distinct SubsequencesOct 19 '12 Given a string S and a string T, count the
 * number of distinct subsequences of T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * f(i, j) = f(i - 1, j) + S[i] == T[j]? f(i - 1, j - 1) : 0 Where f(i, j) is
 * the number of distinct sub-sequence for T[0:j] in S[0:i].
 */


public class DistinctSubSequence {
	public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        if (m == 0 || n == 0) {
            return 0;
        }
        
        ArrayList<ArrayList<Integer>> appear = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++)
            appear.add(new ArrayList<Integer>());
            
        for (int i = 0; i < m; i++) {
            char s = S.charAt(i);
            for (int j = 0; j < n; j++) {
                if (s == T.charAt(j))
                    appear.get(j).add(i);
            }
        }
        
        ArrayList<ArrayList<Integer>> com = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++)
            com.add(new ArrayList<Integer>());
        
        for (int i = 0; i < appear.get(n - 1).size(); i++) 
            com.get(n - 1).add(1);
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < appear.get(i).size(); j++) {
                com.get(i).add(0);
                for (int k = 0; k < appear.get(i + 1).size(); k++){
                    if (appear.get(i).get(j) < appear.get(i + 1).get(k))
                        com.get(i).set(j, com.get(i).get(j) + com.get(i + 1).get(k));
                }
            }
        }    
        
        int result = 0;
        for (int i = 0; i < com.get(0).size(); i++) {
            result += com.get(0).get(i);
        }
        
        return result;
    }
    
	public int numDistinct1(String S, String T) {
		int[][] f = new int[S.length() + 1][T.length() + 1];
		for (int k = 0; k < S.length(); k++)
			f[k][0] = 1;
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					f[i][j] += f[i - 1][j] + f[i - 1][j - 1];
				} else {
					f[i][j] += f[i - 1][j];
				}
			}
		}
		return f[S.length()][T.length()];
	}
    
}
