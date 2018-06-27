package com.cyandragon.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.cyandragon.dynamicprogramming.*;

public class Playboard {

	public static void main(String args[]) {
//		TwoKeysKeyboard.minSteps();
//		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
//		numMap.put(0, -6);
//		numMap.put(1, 10);
//		numMap.put(2, 188);
//		System.out.println((Set<Integer>)numMap.values());
		int a = 0x80000000;
		System.out.println(a);
		
	}
	
	public static int[] randomArray(int length) {
		Random random = new Random();
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = Math.abs(random.nextInt(1000000));
		}
		
		return result;
	}

	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		int count = 0;
		System.out.println(new Date().getTime());
		int result = 0;
		int start = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < k) {
				result++;
			}
			for (int j = start; j < i; j++) {
				int product = nums[j] * nums[i];
				nums[j] = product < k && product > 0 ? product : k;
				if (nums[j] < k) {
					result++;
				} else {
					start++;
				}
				count++;
			}
		}
		System.out.println(count + " : " + new Date().getTime());

		return result;
	}

	public static int numSubarrayProductLessThanK1(int[] nums, int k) {
		System.out.println(new Date().getTime());
		int count = 0;
		int n = nums.length;
		long p = 1l;
		int i = 0;
		int j = 0;
		int total = 0;
		while (j < n) {
			p *= nums[j];
			while (i <= j && p >= k) {
				p /= nums[i];
				i++;
				count++;
				System.out.println(i + " : " + j);
			}
			total += (j - i + 1);
			j++;
		}
		System.out.println(count + " : " + new Date().getTime());

		return total;
	}

	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, List<List<String>>> accountMap = new HashMap();
		List<List<String>> result = new ArrayList();
		for (List<String> acc : accounts) {
			if (accountMap.get(acc.get(0)) == null) {
				accountMap.put(acc.get(0), new ArrayList());
			}
			accountMap.get(acc.get(0)).add(acc);
		}

		for (String name : accountMap.keySet()) {
			accountsSubMerge(accountMap.get(name));
			result.addAll(accountMap.get(name));
		}

		return result;
	}

	public static List<List<String>> accountsSubMerge(List<List<String>> accounts) {
		int i = 0;
		while (i < accounts.size() - 1) {
			int j = i + 1;
			Set<String> acci = new HashSet<String>(accounts.get(i));
			accounts.set(i, new ArrayList<String>(acci));
			boolean removed = false;
			while (j < accounts.size()) {
				Set<String> accj = new HashSet<String>(accounts.get(j));
				int sizej = accj.size();
				accj.addAll(acci);
				if (acci.size() + sizej > accj.size() + 1) {
					List<String> merge = new ArrayList<String>(accj);
					accounts.set(j, merge);
					accounts.remove(i);
					removed = true;
					acci = new HashSet<String>(accounts.get(i));
				} else {
					j++;
				}
			}
			Collections.sort(accounts.get(i));
			if (!removed) {
				i++;
			}
		}
		i = accounts.size() - 1;
		accounts.set(i, new ArrayList<String>(new HashSet<String>(accounts.get(i))));
		Collections.sort(accounts.get(i));
		return accounts;
	}

	public static int[] countBits(int num) {
		int[] result = new int[num + 1];
		int bit = 1;
		for (int i = 1; i <= num; i++) {
			if (bit * 2 == i) {
				bit *= 2;
			}

			result[i] = result[(bit - 1) & i] + 1;
			System.out.println("bit: " + bit + " i: " + i + " index:" + ((bit - 1) & i) + " i>> " + (i >> 1)
					+ " num[i]: " + result[i] + " i&i-1: " + (i & (i - 1)));

		}

		return result;
	}
}
