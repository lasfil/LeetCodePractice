package com.zinkirin;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. 
 * 
 * Each step you may move to adjacent numbers on the row below. 
 * 
 * For example, given the following triangle 
 * [   
 *     [2], 
 *    [3,4], 
 *   [6,5,7], 
 *  [4,1,8,3] 
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: 
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */

public class Triangle {
   public int minimumTotal(List<List<Integer>> triangle) { 
        if (triangle == null)
            return 0;
        List<Integer> temp  = triangle.get(triangle.size()-1);
        List<Integer> row = null;
        
        for (int i = triangle.size()-2; i >= 0; i--) {
            
            row = triangle.get(i);
            //从底部向上计算出自己和下一行相邻左右的最小值的和，在下次循环时供上一行调用
            //每次对于temp里的值，相当于第i行下面所有行的最短路径，
            //所以对于row(j), 将temp(j)和temp(j+1)里的最小值加进去，赋值给temp(j)
            //在row(j+1)处，需要的是temp(j+1),temp(j+2)，所以可以更新temp(j)
            for (int j = 0; j < row.size(); j++ ) {
                temp.set(j,row.get(j) + Math.min(temp.get(j), temp.get(j+1)));
            }        
           
        }
          
        return temp.get(0);  
    }  
}