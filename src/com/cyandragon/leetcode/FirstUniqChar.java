package com.cyandragon.leetcode;

import org.junit.Test;

public class FirstUniqChar {
	@Test
	public void test() {
		firstUniqChar("loveleetcode");
	}
	public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        int[] count = new int[26];
        int[] index = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count[chars[i] - 'a']++;
            index[chars[i] - 'a'] = i;
        }
        
        for (int i : count) {
            if (i == 1) {
                return index[i];
            }
        }
        return -1;
    }
}
