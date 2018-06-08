package com.zinkirin.sort;

public class ArraySort {
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}

		partition(arr, 0, arr.length - 1);
	}

	private static void partition(int[] arr, int i, int j) {
		if (i >= j) {
			return;
		}

		if (j - i == 1) {
			if (arr[i] > arr[j]) {
				swap(arr, i, j);
			}
			return;
		}
		int low = i;
		int high = j;
		
		while (low < high) {
			if (arr[low] < arr[i]) {
				low++;
			} else if(arr[high] < arr[i]) {
				high--;
			} else if (arr[low] > arr[high]) {
				swap(arr, low, high);
				low++;
				high--;
			}
		}
		swap(arr, i, high);
		partition(arr, i, high - 1);
		partition(arr, high + 1, j);

	}

	private static void swap(int[] arr, int i, int j) {
		if (arr == null || i >= arr.length || j >= arr.length || i == j) {
			return;
		}
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
