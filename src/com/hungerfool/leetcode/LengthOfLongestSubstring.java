package com.hungerfool.leetcode;

import java.util.HashMap;

import org.junit.Test;

import junit.framework.Assert;

public class LengthOfLongestSubstring {
	@Test
	public void test() {
		System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring("abba"));
	}
	public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        
        s = s.trim();
        int m = s.length();
        if (m < 2) {
            return m;
        }
        HashMap<Character, Integer> cnt = new HashMap<Character, Integer>();
        int start = 0;
        char c;
        int max = 0;
        int i = 0;
        while (i < m) {
            c = s.charAt(i);
            if (cnt.containsKey(c)) {
                max = Math.max(max, i - start);
                start = Math.max(start,cnt.get(c) + 1);
                //start = cnt.get(c) + 1;
            }
            cnt.put(c, i);
            i++;
        }
        
        return Math.max(max, i - start);
    }
}
