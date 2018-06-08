package com.cyandragon.leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 */

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int len = height.length, low = 0, high = len - 1;
		int maxArea = 0;
		// 先计算出最远两根之间的面积，然后向中间靠拢
		// 宽度减少的情况下还能有更大面积，就应该提升高度，所以应该将更短的一根向中间靠拢
		while (low < high) {
			maxArea = Math.max(maxArea,
					(high - low) * Math.min(height[low], height[high]));
			if (height[low] < height[high]) {
				low++;
			} else {
				high--;
			}
		}
		return maxArea;
	}
}