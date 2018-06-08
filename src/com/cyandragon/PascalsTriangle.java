package com.cyandragon;
import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [      
 *        [1], 
 *       [1,1], 
 *      [1,2,1], 
 *     [1,3,3,1], 
 *    [1,4,6,4,1] 
 * ]
 */
public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascals = new ArrayList<List<Integer>>();
		if (numRows == 0)
			return pascals;

		pascals.add(nextRow(null));

		for (int i = 1; i < numRows; i++) {
			pascals.add(nextRow(pascals.get(i - 1)));
		}

		return pascals;
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
