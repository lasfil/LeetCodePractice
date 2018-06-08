package com.cyandragon;
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {

		int n = gas.length;

		int[] div = new int[n];
		int totalCost = 0;
		int totalGas = 0;
		for (int i = 0; i < n; i++) {
			totalCost += cost[i];
			totalGas += gas[i];

			div[i] = gas[i] - cost[i];
		}
		if (totalCost > totalGas) {
			return -1;
		}

		int max = 0;
		//这种情况表明肯定存在一个出发点，从0开始排除
		//如果走到第i个点，sum div为负数，表示无法开到第i个点
		//此时重置i+1为出发点，重新计算sum div
		int start = 0;
		
		for (int i = 0; i < n; i++) {
			max += div[i];
			if (max < 0) {
				max = 0;
				start = i+1;
			}
		}

		return start;

	}

	public int canCompleteCircuit2(int[] gas, int[] cost) {
		int sum = 0, total = 0, len = gas.length, index = -1;
		for (int i = 0; i < len; i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (sum < 0) {
				index = i;
				sum = 0;
			}
		}
		return total >= 0 ? index + 1 : -1;
	}

	public static void main(String[] args) {
		// int[] gas = new int[] { 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77,
		// 78,
		// 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94,
		// 95, 96, 97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
		// 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
		// 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44,
		// 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
		// 61, 62, 63, 64, 65, 66 };
		// int[] cost = new int[] { 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37,
		// 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53,
		// 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69,
		// 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85,
		// 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 1,
		// 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
		// 20, 21, 22, 23, 24, 25, 26 };
		int[] gas = new int[] { 2, 10, 3, 7, 2, 12, 3 };
		int[] cost = new int[] { 11, 2, 12, 1, 5, 2, 6 };

		System.out.println(new GasStation().canCompleteCircuit(gas, cost));
	}
}
