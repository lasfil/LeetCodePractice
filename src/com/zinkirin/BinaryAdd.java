package com.zinkirin;

public class BinaryAdd {
	 public String addBinary(String a, String b) {
	        if (a.equals(""))
	            return b;
	        if (b.equals(""))
	            return a;
	        int add = 0;
	        
	        String result = a;
	        String temp = b;
	        StringBuffer sb = new StringBuffer();
	        if (a.length() < b.length()) {
	            result = b;
	            temp = a;
	        }
	        int m = result.length();
	        int n = temp.length();
	        for (int i = 0; i < m; i++) {
	            int ia = Character.digit(result.charAt(m - 1 - i), 2);
	            int ib = i < n ? Character.digit(temp.charAt(n - 1 - i), 2) : 0;
	            sb.insert(0,ia ^ ib ^ add);
	            if (ia == 1 && ib == 1 || ia == 1 && add == 1 || add == 1 && ib == 1)
	                add = 1;
	            else
	            	add = 0;
	        }
	        if (add == 1)
	            sb.insert(0,1);
	        return sb.toString();
	    }
	 
	 public static void main(String[] args) {
		 System.out.println(new BinaryAdd().addBinary("1010", "1011"));
	 }
}
