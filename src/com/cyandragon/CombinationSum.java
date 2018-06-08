package com.cyandragon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers.
 * 
 * Elements in a combination (a1, a2, ... , ak) must be in non-descending order.
 * (ie, a1 <= a2 <= ... <= ak).
 * 
 * The solution set must not contain duplicate combinations. For example, given
 * candidate set 2,3,6,7 and target 7, A solution set is: [7] [2, 2, 3]
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        if (candidates.length == 0) {
             result.add(new ArrayList<Integer>());
             return result;
        }
        List<Integer> temp = new ArrayList<Integer>();
        dfsSum(candidates, target, 0, temp, result);
        return result;
    }
    
    private void dfsSum(int[] arr,int target, int index, 
                                        List<Integer> list, List<List<Integer>> result) {
        for (int i = index; i < arr.length; i++) {
            if (target >= arr[i]) {
                List<Integer> newList = new ArrayList<Integer>(list);
                newList.add(arr[i]);
                if (target == arr[i])
                    result.add(newList);
                else
                    dfsSum(arr, target - arr[i], i, newList, result);
            }
        }
    }
}
