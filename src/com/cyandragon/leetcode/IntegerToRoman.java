package com.cyandragon.leetcode;
/**
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {
	public String intToRoman(int num) {
        if (num == 0)
            return "";
        StringBuffer sb = new StringBuffer();
        
        sb = romanMapping(num, "I", "V", "X", sb);
         num /=10;
        sb = romanMapping(num, "X", "L", "C", sb);
          num /=10;
        sb = romanMapping(num, "C", "D", "M", sb);
          num /=10;
        sb = romanMapping(num, "M", "M", "M", sb);
        
        return sb.toString();
    }
    
    public StringBuffer romanMapping(int num, String one, String five, String ten, StringBuffer sb) {
        StringBuffer result = new StringBuffer();
        int digit = num - num / 10 * 10;
        if (digit == 0)
            return sb;
        if (digit == 4) {
            return result.append(one + five).append(sb);
        } 
        if (digit == 9){
            return result.append(one + ten).append(sb);
        }
        
        if (digit >= 5) {
            result.append(five);
            digit -= 5;
        }
        while (digit-- > 0) {
            result.append(one);
        }
        
        result.append(sb);
        return result;
    }
    
    public static void main(String[] args) {
    	System.out.println(new IntegerToRoman().intToRoman(41));
    }
}
