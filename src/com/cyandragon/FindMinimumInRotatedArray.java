package com.cyandragon;
/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.*/
public class FindMinimumInRotatedArray {
	public int findMin(int[] num) {
        if (num.length == 0)
            return Integer.MIN_VALUE;
       
        int min =  num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i - 1] > num[i])
            min = num[i];
        }
        
        return min;
    }
	
	public int findMin1(int[] num) {
        if (num.length == 0)
            return Integer.MIN_VALUE;
        int l = 0;
        int h = num.length - 1;
        if (num[l] < num[h])
            return num[0];
            
        while (h - l > 1) {
            int mid = (h + l) / 2;
            
            if (num[mid - 1] > num [mid] && num[mid] < num[mid + 1]) {
                return num[mid];
            }
            
            if (num[mid - 1] < num [mid] && num[mid] > num[mid + 1]) 
                return num[mid + 1];
                
            if (num[mid] < num[h])
                h = mid - 1;
            if (num[mid] > num[l])
                l = mid + 1;
        } 
        
        return Math.min(num[l], num[h]);
    }
}
