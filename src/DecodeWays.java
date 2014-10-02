/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 */

public class DecodeWays {
	public int numDecodings(String s) {
		// 空串和0开头的数字都返回0
		if (s == null || s.length() == 0 || s.charAt(0) == '0')
			return 0;

		int len = s.length();
		int[] result = new int[len + 1];

		result[0] = 1;
		result[1] = 1;

		for (int i = 1; i < len; i++) {
			// 从第2位开始遍历，如果第i位不为0那么
			// 相当于i-1时的组合增加一个有效字母，i位组合数等于i-1的组合数
			if (s.charAt(i) != '0')
				result[i + 1] = result[i];
			// 如果跟前一位组合出10-26的数，则相当于i-2时的组合数也加进来
			// 如果i位是0，当前组合数为0，但是跟i-1位组合出10或者20，组合数等于0加上i-2的组合数
			if (s.charAt(i - 1) != '0'
					&& Integer.valueOf(s.substring(i - 1, i + 1)) < 26) {
				result[i + 1] += result[i - 1];
			}

		}

		return result[len];
	}

	public static void main(String[] args) {
		System.out.println(new DecodeWays().numDecodings("1212121212"));
	}
}
