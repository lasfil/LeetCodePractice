package com.zinkirin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 */
public class Anagrams {
	public List<String> anagrams(String[] strs) {
		if (strs == null)
			return null;
		List<String> result = new ArrayList<String>();
		if (strs.length == 0)
			return result;
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] charset = strs[i].toCharArray();
			Arrays.sort(charset);
			String sortstr = new String(charset);
			if (map.containsKey(sortstr)) {
				map.get(sortstr).add(strs[i]);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(sortstr, list);
			}
		}
		for (String key : map.keySet()) {
			if (map.get(key).size() > 1)
				result.addAll(map.get(key));
		}

		return result;

	}
}
