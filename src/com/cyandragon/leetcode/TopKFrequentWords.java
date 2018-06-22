package com.cyandragon.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopKFrequentWords {
	@org.junit.Test
	public void test() {
		new TopKFrequentWords().topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2);
	}

	public List<String> topKFrequent(String[] words, int k) {
		if (words == null) {
			return null;
		}
		List<String> result = new ArrayList<String>();
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			countMap.put(words[i], countMap.getOrDefault(words[i], 0) + 1);
		}

		List<String>[] bucket = new List[words.length];
		for (String word : countMap.keySet()) {
			if (bucket[countMap.get(word)] == null) {
				bucket[countMap.get(word)] = new ArrayList<String>();
			}
			bucket[countMap.get(word)].add(word);
			Collections.sort(bucket[countMap.get(word)]);
		}
		for (int i = words.length - 1; i > 0 && bucket[i] != null; i--) {
			int j = 0;
			while (j < bucket[i].size() && result.size() < k) {
				result.add(bucket[i].get(j));
			}
		}

		return result;
	}
}
