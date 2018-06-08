package com.cyandragon;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

public class ZigZagConversation {
	  public String convert(String s, int nRows) {
	        if (s == null || s.equals(""))
	            return null;
	        int len = s.length();
	        if (nRows >= len || len < 2 || nRows == 1) 
	            return s;
	        StringBuffer[] sbArr = new StringBuffer[nRows];
	        for (int i = 0; i < nRows; i++)
	            sbArr[i] = new StringBuffer();
	        int count = 0;
	        int col = 0;
	        while (count < len) {
	            if (col % 2 == 0) {
	                for (int i = 0; i < nRows; i++) {
	                    if (count == len)
	                        break;
	                    sbArr[i].append(s.charAt(count++));
	                }
	            } else {
	                for (int i = nRows - 2; i > 0; i--) {
	                    if (count == len)
	                        break;
	                    sbArr[i].append(s.charAt(count++));
	                }
	            }
	            col++;
	        }
	        StringBuffer result = new StringBuffer();
	        for (StringBuffer sb : sbArr) {
	            result.append(sb);
	        }
	        return result.toString();
	    }
}
