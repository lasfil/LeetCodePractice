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

			int mid = (h - l) / 2 + l;
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

	public static void main(String[] args) {
		int[] a = new int[] { 2, 2, 2, 0, 0, 1 };
		System.out.println(new SearchInRotatedSortedList2().search(a, 0));
	}
}
