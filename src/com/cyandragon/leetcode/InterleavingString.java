package com.cyandragon.leetcode;
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null && s2 == null)
			return s3 == null;
		if (s1 == null)
			return s2.equals(s3);
		if (s2 == null)
			return s1.equals(s1);

		return isInterleave(s1, 0, s2, 0, s3, 0);

	}

	private boolean isInterleave(String sb1, int i1, String sb2, int i2,
			String sb3, int i3) {
		System.out.println("------");
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb3);
		if (sb1.length() == i1)
			return sb2.substring(i2).equals(sb3.substring(i3));
		if (sb2.length() == i2)
			return sb1.substring(i1).equals(sb3.substring(i3));

		if (sb1.length() - i1 + sb2.length() - i2 != sb3.length() - i3)
			return false;

		char c1 = sb1.charAt(i1);
		char c2 = sb2.charAt(i2);
		char c3 = sb3.charAt(i3);
		if (c1 == c3 && c2 == c3) {
			return isInterleave(sb1, i1 + 1, sb2, i2, sb3, i3 + 1)
					|| isInterleave(sb1, i1, sb2, i2 + 1, sb3, i3 + 1);
		}

		if (c1 == c3)
			return isInterleave(sb1, i1 + 1, sb2, i2, sb3, i3 + 1);
		if (c2 == c3)
			return isInterleave(sb1, i1, sb2, i2 + 1, sb3, i3 + 1);

		return false;
	}

	public boolean isInterleave1(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		boolean[][] mat = new boolean[s1.length() + 1][s2.length() + 1];
		mat[0][0] = true;
		for (int i = 1; i <= s1.length(); ++i)
			mat[i][0] = mat[i - 1][0] && (s3.charAt(i - 1) == s1.charAt(i - 1));
		for (int i = 1; i <= s2.length(); ++i)
			mat[0][i] = mat[0][i - 1] && (s3.charAt(i - 1) == s2.charAt(i - 1));
		for (int i = 1; i <= s1.length(); ++i)
			for (int j = 1; j <= s2.length(); ++j)
				mat[i][j] = (mat[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i
						+ j - 1))
						|| (mat[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i
								+ j - 1));
		return mat[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		String s1 = "aabbddccddee";
		String s2 = "aabbaaccddee";
		String s3 = "aabaabbdbdaaccdccddedeee";
		System.out.println(new InterleavingString().isInterleave1(s1, s2, s3));
	}
}
