package com.cyandragon.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PascalTriangle2 {
	@Test
	public void test() {
		System.out.println(getRow(3));
	}
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            int mid = i / 2;
            for (int j = 1; j <= mid; j++) {
                int val = ret.get(j) + ret.get(i  - j);
                ret.set(j, val);
            }
            for (int j = mid + 1; j < i; j++) {
                ret.set(j, ret.get(i - j));
            }
            ret.add(1);
        }
        
        return ret;
    }
}
