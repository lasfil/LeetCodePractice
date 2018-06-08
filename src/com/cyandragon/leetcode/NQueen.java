package com.cyandragon.leetcode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NQueen {
	public List<String[]> solveNQueens(int n) {
		List<String[]> result = new ArrayList<String[]>();
		if (n == 0) {
			result.add(new String[] { "" });
			return result;
		}
		if (n == 1) {
			result.add(new String[] { "Q" });
			return result;
		}
		List<String[]> pre = solveNQueens(n - 1);

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < n - 1; i++)
			sb.append(".");
		sb.append("Q");

		for (String[] strCom : pre) {
			String[] newStrCom = new String[n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (j < i) {
						newStrCom[j] = strCom[j] + ".";
					} else if (j == i) {
						newStrCom[j] = sb.toString();
					} else {
						newStrCom[j] = strCom[j - 1] + ".";
					}
				}
				result.add(newStrCom);

			}
		}

		// List<String> numCom = numCombination(n);
		// StringBuffer sb = new StringBuffer();
		//
		// for (String numStr : numCom) {
		// String[] strCom = new String[n];
		// for (int i = 0; i < numStr.length(); i++) {
		// int num = Character.digit(numStr.charAt(i), 10);
		// sb.setLength(0);
		// for (int j = 0; j < n; j++) {
		// if (j == num)
		// sb.append("Q");
		// else
		// sb.append(".");
		// }
		// strCom[i] = sb.toString();
		// }
		// result.add(strCom);
		// }

		return result;
	}

	public List<String[]> solveNQueens3(int n) {
		List<String[]> result = new ArrayList<String[]>();
		if (n == 0) {
			result.add(new String[] { "" });
			return result;
		}
		if (n == 1) {
			result.add(new String[] { "Q" });
			return result;
		}
		// List<String[]> pre = solveNQueens(n - 1);
		//
		// StringBuffer sb = new StringBuffer();
		//
		// for (int i = 0; i < n-1; i++)
		// sb.append(".");
		// sb.append("Q");
		//
		//
		// for (String[] strCom : pre) {
		// String[] newStrCom = new String[n];
		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < n; j++) {
		// if (j < i) {
		// newStrCom[j] = strCom[j] + ".";
		// } else if (j == i) {
		// newStrCom[j] = sb.toString();
		// } else {
		// newStrCom[j] = strCom[j - 1] + ".";
		// }
		// }
		// result.add(newStrCom);
		//
		// }
		// }

		List<String> numCom = numCombination(n);
		StringBuffer sb = new StringBuffer();

		for (String numStr : numCom) {
			String[] strCom = new String[n];
			for (int i = 0; i < numStr.length(); i++) {
				int num = Character.digit(numStr.charAt(i), 10);
				sb.setLength(0);
				for (int j = 0; j < n; j++) {
					if (j == num)
						sb.append("Q");
					else
						sb.append(".");
				}
				strCom[i] = sb.toString();
			}
			result.add(strCom);
		}

		return result;
	}

	public List<String> numCombination(int n) {
		List<String> result = new ArrayList<String>();
		if (n == 0) {
			return null;
		}
		if (n == 1) {
			result.add("1");
			return result;
		}

		List<String> pre = numCombination(n - 1);
		StringBuffer sb = new StringBuffer();
		for (String com : pre) {
			int len = com.length();
			for (int i = 0; i < len; i++) {
				sb.append(com.substring(0, i));
				sb.append(n);
				sb.append(com.substring(i));
				result.add(sb.toString());
				sb.setLength(0);
			}
		}

		return result;
	}

	public ArrayList<String[]> solveNQueens1(int n) {
		ArrayList<String[]> ret = new ArrayList<String[]>();
		if (n == 0)
			return ret;
		StringBuffer line = new StringBuffer();
		for (int i = 0; i < n; i++) {
			line.append('.');
		}
		StringBuffer[] sol = new StringBuffer[n];
		for (int i = 0; i < n; i++) {
			sol[i] = new StringBuffer(line.toString());
		}
		boolean[] cols = new boolean[n];
		int[] row = new int[n];
		findSolutions(n, 0, ret, sol, row, cols);
		for (String[] s : ret)
			System.out.println(s);
		return ret;
	}

	private void findSolutions(int n, int start, ArrayList<String[]> ret,
			StringBuffer[] sol, int[] row, boolean[] cols) {
		if (start == n) {
			String[] newSol = new String[n];
			for (int i = 0; i < n; i++) {
				newSol[i] = sol[i].toString();
			}
			ret.add(newSol);
		} else {
			for (int i = 0; i < n; i++) {
				if (cols[i])
					continue;
				boolean ok = true;
				for (int j = 0; j < start; j++) {
					if (Math.abs(start - j) == Math.abs(i - row[j])) {
						ok = false;
						break;
					}
				}
				if (ok) {
					cols[i] = true;
					sol[start].setCharAt(i, 'Q');
					row[start] = i;
					findSolutions(n, start + 1, ret, sol, row, cols);
					row[start] = 0;
					sol[start].setCharAt(i, '.');
					cols[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
    	System.out.println(Calendar.getInstance().getTimeInMillis());
    	new NQueen().solveNQueens1(10);
    	System.out.println(Calendar.getInstance().getTimeInMillis());
    	new NQueen().solveNQueens(10);
    	System.out.println(Calendar.getInstance().getTimeInMillis());
    	new NQueen().solveNQueens3(10);
    	System.out.println(Calendar.getInstance().getTimeInMillis());

    }
}
