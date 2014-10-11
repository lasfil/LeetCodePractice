import java.util.Calendar;

public class Test {
	public static void main(String[] args) {

		int[] a = new int[] { 2, 2, 2, 3, 3, 3, 4, 4, 4, 0, 0, 1, 2, 2, 2, 2 };
		System.out.println(Calendar.getInstance().getTimeInMillis());
		System.out.println(new SearchInRotatedSortedList2().search(a, 0));
		System.out.println(Calendar.getInstance().getTimeInMillis());
		System.out.println(new SearchInRotatedSortedList2().search1(a, 0));
		System.out.println(Calendar.getInstance().getTimeInMillis());
	}
}
