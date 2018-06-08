package com.cyandragon.leetcode;
import java.util.ArrayList;
import java.util.List;
/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note:
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class Pascals2 {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> pascalsRow = null;

		for (int i = 0; i <= rowIndex; i++) {
			pascalsRow = nextRow(pascalsRow);
		}

		return pascalsRow;
	}

	public List<Integer> nextRow(List<Integer> current) {
		List<Integer> row = new ArrayList<Integer>();
		row.add(1);
		if (current == null)
			return row;
		for (int j = 1; j < current.size(); j++) {
			row.add(current.get(j - 1) + current.get(j));
		}
		row.add(1);
		return row;
	}
}
