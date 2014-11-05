import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int m = height.length;
		int max = 0;

		for (int i = 0; i < m; i++) {
			int left = i - 1;
			while (left >= 0 && height[left] >= height[i]) {
				left--;
			}

			int right = i + 1;
			while (right < m && height[right] >= height[i]) {
				right++;
			}

			max = Math.max(max, (right - left - 1) * height[i]);
		}

		return max;
	}

	public int largestRectangleArea1(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		int[] h = new int[height.length + 1];
		h = Arrays.copyOf(height, height.length + 1);
		while (i < h.length) {
			if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
				stack.push(i);
				i++;
			} else {
				int t = stack.pop();
				maxArea = Math.max(maxArea, h[t]
						* (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		return maxArea;
	}

	public int largestRectangleArea2(int[] height) {
		if (height == null || height.length == 0)
			return 0;

		int m = height.length;
		if (m == 1)
			return height[0];

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(0);
		int i = 1;
		int max = height[0];
		while (i < m) {
			max = Math.max(max, height[i]);
			if (height[i] < height[stack.peek()]) {
				// 如果第i个高度比栈顶低要向前计算面积，同时把比i高的都弹出
				max = calArea(stack, height, i, height[i], max);
			}
			stack.push(i);
			i++;
		}
		max = calArea(stack, height, i, 0, max);

		return max;
	}

	private int calArea(Stack<Integer> stack, int[] height, int index,
			int refer, int max) {
		// 只要栈顶元素比i处的高就弹出并计算面积
		while (!stack.isEmpty() && height[stack.peek()] > refer) {
			int h = stack.pop();
			// 计算面积时候就是看height[h]能延续的宽度
			// 如果弹出后栈空了，证明这个高度是最小的，宽度就是，这种情况只会发生在index ＝＝ m的时候最后一次
			// 其余的情况宽度就是index减去栈顶的值减yi，因为栈顶是h最左边比它小的，index是最右边第一个比它小的
			max = Math.max(max, height[h]
					* (stack.isEmpty() ? index : index - stack.peek() - 1));
		}
		return max;
	}

	public static void main(String[] args) {
		// int[] height = new int[] { 2, 1, 4, 5, 6, 8, 6, 2, 4, 5 };
		int[] height = new int[] { 4, 2, 0, 3, 2, 5 };
		System.out.println(new LargestRectangleinHistogram()
				.largestRectangleArea2(height));
		System.out.println(new LargestRectangleinHistogram()
				.largestRectangleArea1(height));
	}
}
