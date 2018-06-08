package com.cyandragon;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 */

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null)
            return result;
        int len = s.length();
        
        if (len == 0) {
            result.add(new ArrayList<String>());
            return result;
        }
        List<Integer>[] strMap = new List[len + 1];
        strMap[0] = new ArrayList<Integer>();
        
        for (int i = 1; i <= len; i++) {
            strMap[i] = new ArrayList<Integer>();
            strMap[i].add(i - 1);
            for (int j = 0; j < i - 1;j++) {
                if (isPalindrome(s, j, i))
                    strMap[i].add(j);
            }
        }
        List<String> buffer = new ArrayList<String>();
        dfs(result, len, strMap, buffer, s);
        
        return result;    
    }
    
    private void dfs(List<List<String>> result, int start, List<Integer>[] strMap, 
                    List<String> buffer, String s) {
        List<Integer> next = strMap[start];
        List<String> temp = null;
        for (int i :next) {
        	 temp = new ArrayList<String>(buffer);
             temp.add(0, s.substring(i, start));
            if (i == 0) {               
                result.add(temp);
            } else {
                dfs(result, i, strMap, temp, s);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
    	
        while (start < end) {
            if (s.charAt(start++) != s.charAt(--end))
                return false;
        }
        
        return true;
    }
    
    public ArrayList<ArrayList<String>> partition1(String s) {
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		ArrayList<String> r = new ArrayList<String>();
		int length = s.length();
		boolean[][] map = new boolean[length][length];
		findPartition(s, 0, ret, r, map);
		return ret;
	}

	private void findPartition(String s, int start,
			ArrayList<ArrayList<String>> ret, ArrayList<String> r,
			boolean[][] map) {
		int length = s.length();
		if (start == length && r.size() != 0) {
			ArrayList<String> clone = new ArrayList<String>(r);
			ret.add(clone);
		} else {
			for (int j = start; j < length; j++) {
				if (start == j
						|| (j - start > 1 && s.charAt(start) == s.charAt(j) && map[start + 1][j - 1])
						|| (j - start == 1 && s.charAt(start) == s.charAt(j))) {
					map[start][j] = true;
					r.add(s.substring(start, j + 1));
					findPartition(s, j + 1, ret, r, map);
					r.remove(r.size() - 1);
				}
			}
		}
	}
    
    public static void main(String[] args) {
		String s = "seeslaveidemonstrateyetartsnomedievalsees";
		System.out.println(new PalindromePartitioning().partition1(s));

	}
}
