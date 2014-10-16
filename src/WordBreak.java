import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || dict == null)
			return false;

		int len = s.length();
		int size = dict.size();
		if (len == 0 || size == 0)
			return false;

		ArrayList<List<String>> index = new ArrayList<List<String>>();
		for (int i = 0; i < len; i++)
			index.add(new ArrayList<String>());
		// 建立一个字典，index是s中字母的位置，在index下的list中存的是dict中以该字母开头的element
		for (String str : dict) {
			int pos = s.indexOf(str);
			while (pos != -1) {
				index.get(pos).add(str);
				// 有的词不止一次出现，所以在这个位置之后的substring中再找，直到全部找到
				int nextPos = s.substring(pos + 1, len).indexOf(str);
				pos = nextPos == -1 ? -1 : pos + nextPos + 1;
			}

		}
		// index中有空的list，证明以该字母开头的string不存在在dict中，此时需检验如果dict中每一个元素都不含该字母，直接返回false
		for (int i = 0; i < index.size(); i++) {
			if (index.get(i).size() == 0) {
				int appear = 0;
				for (String str : dict) {
					appear += str.indexOf(s.charAt(i));
				}
				if (appear == -1 * dict.size())
					return false;
			}
		}

		return dfs(index, len, 0);
	}

	public boolean dfs(List<List<String>> list, int len, int start) {
		if (start >= len)
			return false;
		boolean result = false;
		// start的位置上字母开头的dict元素遍历
		for (String str : list.get(start)) {
			int n = str.length();
			// 如果该词刚好是最后一个词返回true
			if (len - start == str.length())
				return true;
			else
				// 如果长度不匹配继续向后寻找
				result |= dfs(list, len, start + n);
		}

		return result;
	}

	public boolean wordBreak1(String s, Set<String> dict) {
		int max = 0;
		for (String w : dict) {
			max = Math.max(w.length(), max);
		}
		int len = s.length();
		boolean[] strMap = new boolean[len + 1];
		strMap[0] = true;
		for (int i = 1; i <= len; i++) {
			for (int j = i - max > 0 ? i - max : 0; j < i; j++) {
				if (strMap[j] && dict.contains(s.substring(j, i))) {
					strMap[i] = true;
				}
			}
		}
		return strMap[len];
	}

	public static void main(String[] args) {
		String[] A = new String[] { "a", "aa", "aaa", "aaaa", "aaaaa",
				"aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa" };
		Set<String> dict = new HashSet<String>();
		for (String s : A)
			dict.add(s);
		System.out.println(new WordBreak().wordBreak1(
		// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
		// + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict));

	}
}
