/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint:
 * 
 * Carefully consider all possible input cases. If you want a challenge, please
 * do not see below and ask yourself what are the possible input cases.
 * 
 * Notes:
 * 
 * It is intended for this problem to be specified vaguely (ie, no given input
 * specs). You are responsible to gather all the input requirements up front.
 * 
 * Requirements for atoi: The function first discards as many whitespace
 * characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus
 * sign followed by as many numerical digits as possible, and interprets them as
 * a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 */

public class StringToInteger {
	public int atoi(String str) {
		// 去掉两头的空格
		str = str.trim();
		int n = str.length();
		if (n == 0)
			return 0;
		StringBuffer sb = new StringBuffer();
		int neg = 1;
		// 判断第一个字是否正负号
		// 是字母的话直接返回0
		// 是1-9的数字话加进sb
		char first = str.charAt(0);
		if (first == '-') {
			neg = -1;
		} else if (first > '0' && first <= '9') {
			sb.append(first);
		} else if (first != '+' && first != '0')
			return 0;
		// 从前向后遍历有效数字，字母的话直接跳出，后边的字符全部无效
		for (int i = 1; i < n; i++) {
			char c = str.charAt(i);
			if (c == '0') {
				if (sb.length() > 0)
					sb.append(c);
			} else if (c > '0' && c <= '9')
				sb.append(c);
			else
				break;
		}
		// 新生成的str全部只包含有效数字
		str = sb.toString();
		n = str.length();
		int result = 0;
		int k = 1;
		for (int i = n - 1; i >= 0; i--) {
			char c = str.charAt(i);

			if (c >= '0' && c <= '9') {
				int digit = Character.digit(c, 10);
				if (k > 1000000000)
					return Integer.MAX_VALUE;
				if (k == 1000000000) {
					if (i > 0
							&& (str.charAt(i - 1) > 0 || str.charAt(i - 1) <= 9)) {
						if (neg == 1)
							return Integer.MAX_VALUE;
						if (neg == -1)
							return Integer.MIN_VALUE;
					}

					if (c > '3')
						return Integer.MAX_VALUE;
					else if (digit == 2) {
						if (neg == 1 && result > 147483647)
							return Integer.MAX_VALUE;
						if (neg == -1 && result > 147483648)
							return Integer.MIN_VALUE;
					}
				}
				result += digit * k;
			} // else if (c == ' ')
				// continue;
			else {
				result = 0;
				k = 1;
				continue;
			}
			k *= 10;
		}

		return result * neg;
	}
}
