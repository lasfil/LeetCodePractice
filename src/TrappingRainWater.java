public class TrappingRainWater {
	public int trap(int[] A) {
		if (A == null)
			return 0;
		if (A.length < 3)
			return 0;
		// 先从左向右找到最高的left，left左边的都比它低，肯定存不了水，不考虑
		int left = 0;
		while (left < A.length - 1 && A[left] <= A[left + 1]) {
			left++;
		}
		// 同理找到自右向左最高的end，end右边不考虑
		int end = A.length - 1;
		while (end > 0 && A[end - 1] > A[end])
			end--;

		if (end - left < 2)
			return 0;
		// 这个序列存放第i个元素右边里最高的值；
		int[] rightMaxHeight = new int[A.length];
		rightMaxHeight[end] = A[end];

		for (int i = end - 1; i > left; i--) {
			rightMaxHeight[i] = Math.max(A[i], rightMaxHeight[i + 1]);
		}

		int sum = 0;
		while (left < end - 1) {

			int right = left + 1;
			for (int i = right + 1; i <= end; i++) {
				// left是一个碗的左边，右边只有两种情况：1. 比左边高，2. 是右边剩下的里最高的
				// 第二种情况存在是因为有可能left太高，剩下的没有比left里更高的
				if (A[i] >= A[left] || A[i] == rightMaxHeight[i]) {
					right = i;
					break;
				}
			}

			int ceil = Math.min(A[left], A[right]);
			for (int j = left + 1; j < right; j++) {
				sum += ((ceil - A[j]) > 0 ? (ceil - A[j]) : 0);
			}
			left = right;
			// 从right向右找到最高作为新的左边
			while (left < A.length - 1 && A[left] <= A[left + 1]) {
				left++;
			}
		}

		return sum;

	}

	public int trap1(int A[]) {
		int n = A.length;
		if (n <= 2)
			return 0;

		int[] lmh = new int[n];
		lmh[0] = 0;
		int maxh = A[0];
		for (int i = 1; i < n; ++i) {
			lmh[i] = maxh;
			if (maxh < A[i])
				maxh = A[i];
		}
		int trapped = 0;
		maxh = A[n - 1];
		for (int i = n - 2; i > 0; --i) {
			int left = lmh[i];
			int right = maxh;
			int container = Math.min(left, right);
			if (container > A[i]) {
				trapped += container - A[i];
			}
			if (maxh < A[i])
				maxh = A[i];
		}
		return trapped;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 5, 5, 1, 7, 1, 1, 5, 2, 7, 6 };
		new TrappingRainWater().trap1(a);
	}
}
