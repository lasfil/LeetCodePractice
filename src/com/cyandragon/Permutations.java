package com.cyandragon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//Given a collection of numbers, return all possible permutations.
//
//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

public class Permutations {
	public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = num.length;
        if (len == 0)
            return result;
        if (len == 1) {
            List<Integer> list= new ArrayList<Integer>();
            list.add(num[0]);
            result.add(list);
            return result;
        }
        
            
        List<List<Integer>> pre = permute(Arrays.copyOfRange(num, 0, len-1));
        Set<List<Integer>> tmp = new HashSet<List<Integer>>();
        for (List<Integer> list : pre) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> newList = new ArrayList<Integer>();
                newList.addAll(list);
                newList.add(i, num[len-1]);
                tmp.add(newList);
            }
        }
        
        result.addAll(tmp);
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] num = new int[]{0, 1, 2, 3, 4, 5};
		List<List<Integer>> list= new Permutations().permute(num);
		for (List<Integer> l : list) {
			for (int i : l)
				System.out.print(i + " ");
			System.out.println();
		}
	}
}
