package com.zinkirin;
import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n. For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k == 0 || n == 0)
            return result;
            
        if (n == k) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            result.add(list);
            return result;
        }
        
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                result.add(list);
            }
            return result;
        }
        
        List<List<Integer>> pre = combine(n, k -1);
        
        for (List<Integer> list : pre) {
            for (int i = list.get(list.size() - 1) + 1; i <= n; i++) {
                List<Integer> newlist = new ArrayList<Integer>();
                newlist.addAll(list);
                newlist.add(i);
                result.add(newlist);
            }
        }
        
        return result;
    }
	
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();  
	public ArrayList<ArrayList<Integer>> combine1(int n,int k){  
	    if(n < 0 || k < 0 || n < k){  
	        return result;  
	    }  
	    for(int i = 1; i <= n - k + 1;i++){  
	        ArrayList<Integer> list = new ArrayList<Integer>();  
	        dfs(i,k,n,list);  
	    }  
	    return result;  
	}//begin表示现在遍历到的数组元素，holdNum表示list.size()  
	private void dfs(int begin,int k,int n,ArrayList<Integer> list){  
	    list.add(begin);  
	    if(list.size() == k ){//已经达到k个之后，将数组压入result  
	        ArrayList<Integer> copyList = new ArrayList<Integer>(list);  
	        result.add(copyList);  
	        return;  
	    }//否则就一直往下遍历各种可能  
	    for(int j = begin + 1; j <= n; j++){  
	        dfs(j, k, n, list);  
	        list.remove(list.get(list.size()-1));//回溯  
	    }  
	}  

	
	public static void main(String[] args) {
		new Combinations().combine1(5,  4);
	}
}
