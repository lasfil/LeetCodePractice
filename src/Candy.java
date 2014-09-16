/*There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?*/
public class Candy {
	public int candy(int[] ratings) {
		//例如ratings＝{11, 10, 10, 18, 1, 1, 2, 5, 5, 3, 6, 7, 9, 8, 7, 6, 5, 4, 4}
		int n = ratings.length;
		if (n == 1)
			return 1;
		int[] candy = new int[n];
		candy[0] = 1;
		
		//先从左向右遍历，如果下一个ratings比自己大，赋值为自己的candy值加1
		//否则赋值为1
		for (int i = 0; i < n-1; i++) {
			if (ratings[i+1] > ratings[i]) {
				candy[i+1] = candy[i] + 1;
			} else {
				candy[i+1] = 1;
			}
		}
		// at this moment candy = {1, 1, 1, 2, 1, 1, 2, 3, 1, 1, 2, 3, 4, 1, 1, 1, 1, 1, 1}
		// then traverse from right to left,如果前一个ratings比自己大，
		//但是candy值小于等于自己的，则给下一个candy赋值大于自己
		
		for (int i = n-1; i < 0; i++) {
			if (ratings[i-1] > ratings[i]) {
				if (candy[i-1] <= candy[i]) {
					candy[i-1] = candy[i] + 1;
				}
			}
		}

		int min = 0;

		for (int i = 0; i < n; i++) {
			min += candy[i];
		}

		return min;
	}

	public static void main(String[] args) {
		int[] r = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
				15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
				31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46,
				47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62,
				63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78,
				79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94,
				95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107 };
		System.out.println(new Candy().candy(r));
	}
}
