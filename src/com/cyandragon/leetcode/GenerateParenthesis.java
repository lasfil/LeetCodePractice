package com.cyandragon.leetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GenerateParenthesis {
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0)
            return result;
        String par = "()";    
        
        if (n == 1) {
        	result.add(par);
        	  return result;
        }
          
        
        List<String> pre = generateParenthesis(n-1);
        Set<String> set = new HashSet<String>();
        String tmp = null;
        for (String s : pre) {
            //if (!result.contains(par + s))
            	set.add(par + s);
            //if (!result.contains(s + par))
            	set.add(s + par);
            for (int i = 1; i < s.length(); i++) {
                tmp = s.substring(0,i) + par + s.substring(i, s.length());
                //if (!result.contains(tmp))
                set.add(tmp);
            }
        }
        result.addAll(set);
        
        return result;
    }
	
	 public ArrayList<String> generateParenthesis1(int n) {  
	        ArrayList<String> ret = new ArrayList<String>();  
	        rec(n, n, "", ret);  
	        return ret;  
	    }  
	      
	    public void rec(int left, int right, String s, ArrayList<String> ret){  
	        if(left==0 && right==0){  
	            ret.add(s);  
	            return;  
	        }  
	        if(left==0){  
	            rec(left, right-1, s+")", ret);  
	            return;  
	        }  
	        if(right==0){  
	            return;  
	        }  
	        if(left > right){  
	            return;  
	        }  
	        rec(left-1, right, s+"(", ret);  
	        rec(left, right-1, s+")", ret);  
	    }  
	
	public static void main(String[] args) {
		System.out.println(new GenerateParenthesis().generateParenthesis(5));
	}
}
