package com.cyandragon;
public class SearchInRotatedSortedList2 {
	public boolean search(int[] A, int target) {
		if (A.length == 0)
			return false;

		int h = A.length - 1;
		int l = 0;

		while (l <= h) {
			if (h - l < 2) {
				if (target == A[l] || target == A[h])
					return true;
				else
					return false;
			}

			while (l < h && A[l] == A[l + 1])
				l++;
			while (l < h && A[h] == A[h - 1])
				h--;
			while (l < h && A[l] == A[h]) {
				l++;
				h--;
			}

			int mid = (h + l) / 2;
			if (target == A[mid] || target == A[l] || target == A[h])
				return true;
			if (A[mid] > A[l]) {
				if (target > A[l] && target < A[mid]) {
					h = mid - 1;
					l = l + 1;
				} else {
					l = mid + 1;
					h = h - 1;
				}
			} else if (A[mid] < A[h]) {
				if (target > A[mid] && target < A[h]) {
					l = mid + 1;
					h = h - 1;
				} else {
					h = mid - 1;
					l = l + 1;
				}
			}

		}

		return false;
	}
	
	public boolean search1(int[] A, int target) {
		int low = 0;
		int high = A.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (A[mid] == target)
				return true;
			else if (A[low] != A[high]) {
				if (A[low] <= A[mid]) {
					if (target >= A[low] && target < A[mid]) {
						high = mid - 1;
					} else {
						low = mid + 1;
					}
				} else {
					if (target <= A[high] && target > A[mid]) {
						low = mid + 1;
					} else {
						high = mid - 1;
					}
				}
			} else {
				for (int k = low; k < high; k++) {
					if (A[k] == target)
						return true;
				}
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 2, 2, 0, 0, 1 };
		System.out.println(new SearchInRotatedSortedList2().search(a, 0));
	}
}
