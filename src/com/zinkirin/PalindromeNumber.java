package com.zinkirin;
/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * Some hints: Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 */
public class PalindromeNumber {
	 public boolean isPalindrome(int x) {
	        if (Math.abs(x) < 10)
	            return true;
	        boolean result = true;   
	        String num = String.valueOf(Math.abs(x));
	        int i = 0;
	        int j = num.length() - 1;
	        
	        while( i <= j) {
	            if (num.charAt(i) == num.charAt(j))
	                result &= true;
	            else
	                result &= false;
	            i++;
	            j--;
	        }
	        
	        return result;
	    }
	 public boolean isPalindrome1(int x) {
			if (x < 0)
				return false;
			int k = 1;
			while (x / k >= 10) {
				k *= 10;
			}
			while (x >= 10) {
				int left = x / k;
				int right = x - x / 10 * 10;
				if (left != right)
					return false;
				x = (x - x / k * k) / 10;
				k /= 100;
			}
			return true;
		}
	 public static void main(String[] args) {
		 System.out.println(Math.abs(-2147483647));
		 System.out.println(Integer.MAX_VALUE );
		 System.out.println(new PalindromeNumber().isPalindrome1(2147447412));
	 }
}
