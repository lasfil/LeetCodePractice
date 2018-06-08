package com.cyandragon;
import java.util.ArrayList;

public class MaxLinePoints {
	public static class Point {
		int x;
		int y;

		public Point() {
			x = 0;
			y = 0;
		}

		public Point(int a, int b) {
			x = a;
			y = b;
		}

		public String toString() {
			return "p(" + x + "," + y + ")";
		}
	}
	public static int maxPoints(Point[] points) {
		if (points == null)
			return 0;
		int max = 0;

		int n = points.length;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		

		@SuppressWarnings("unchecked")
		ArrayList<Point>[][] lines = new ArrayList[n][n];
		int pNum;
		int[] repeatIndex = new int[n];
		for (int i = 0; i < n; i++)
			repeatIndex[i] = -1;

		for (int i = 0; i < n; i++) {

			for (int j = i + 1; j < n; j++) {

				lines[i][j] = new ArrayList<Point>();

				lines[i][j].add(points[i]);
				lines[i][j].add(points[j]);
				int rIndex = i;
				while (repeatIndex[rIndex] != -1) {
					lines[i][j].add(points[repeatIndex[rIndex]]);
					rIndex = repeatIndex[rIndex];
				}
				if (!samePoint(points[i], points[j])) {
					for (int k = j + 1; k < n; k++) {

						if (isLine(points[i], points[j], points[k])) {
							lines[i][j].add(points[k]);

						}

					}
				} else {
					repeatIndex[j] = i;
				}

				pNum = lines[i][j].size();
				max = pNum > max ? pNum : max;

			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (lines[i][j] != null && lines[i][j].size() == max) {
					System.out.print("line[" + i + "][" + j + "] "
							+ lines[i][j].size());
					for (Point p : lines[i][j])
						System.out.print(p);
					// pNum = lines[i][j].size();
					// max = pNum > max ? pNum : max;
					System.out.println();
				}

			}
		}

		return max;
	}

	public static boolean isLine(Point p1, Point p2, Point p3) {
		if (p2.y == p1.y && p3.y == p1.y)
			return true;
		else if (p2.x == p1.x && p3.x == p1.x)
			return true;
		else if ((p2.y - p1.y) * (p3.x - p1.x) == (p2.x - p1.x) * (p3.y - p1.y))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Point[] points = new Point[] {
				// new Point(0, 0), new Point(0, 0),
				// new Point(1, 1), new Point(1, 1)

				new Point(40, -23), new Point(9, 138), new Point(429, 115),
				new Point(50, -17), new Point(-3, 80), new Point(-10, 33),
				new Point(5, -21),

				new Point(-3, 80), new Point(-6, -65), new Point(-18, 26),
				new Point(-18, 26), new Point(-6, -65), new Point(5, 72),
				new Point(0, 77), new Point(-9, 86), new Point(10, -2),
				new Point(-8, 85), new Point(21, 130), new Point(18, -6),
				new Point(-18, 26), new Point(-1, -15), new Point(10, -2),
				new Point(8, 69), new Point(-4, 63), new Point(0, 3),
				new Point(-4, 40), new Point(-7, 84), new Point(-8, 7),
				new Point(30, 154), new Point(16, -5), new Point(6, 90),
				new Point(18, -6), new Point(5, 77), new Point(-4, 77),
				new Point(7, -13), new Point(-1, -45), new Point(16, -5),
				new Point(-9, 86), new Point(-16, 11), new Point(-7, 84),
				new Point(1, 76), new Point(3, 77), new Point(10, 67),
				new Point(1, -37), new Point(-10, -81), new Point(4, -11),
				new Point(-20, 13), new Point(-10, 77), new Point(6, -17),
				new Point(-27, 2), new Point(-10, -81), new Point(10, -1),
				new Point(-9, 1), new Point(-8, 43), new Point(2, 2),
				new Point(2, -21), new Point(3, 82), new Point(8, -1),
				new Point(10, -1), new Point(-9, 1), new Point(-12, 42),
				new Point(16, -5), new Point(-5, -61), new Point(20, -7),
				new Point(9, -35), new Point(10, 6), new Point(12, 106),
				new Point(5, -21), new Point(-5, 82), new Point(6, 71),
				new Point(-15, 34), new Point(-10, 87), new Point(-14, -12),
				new Point(12, 106), new Point(-5, 82), new Point(-46, -45),
				new Point(-4, 63), new Point(16, -5), new Point(4, 1),
				new Point(-3, -53), new Point(0, -17), new Point(9, 98)

		// new Point(-9,86),
		// new Point(2,77),
		/*
		 * new Point(-2,-49),new Point(1,76),new Point(-3,-38),new
		 * Point(-8,7),new Point(-17,-37) ,new Point(5,72),new Point(10,-37),new
		 * Point(-4,-57),new Point(-3,-53),new Point(3,74),new Point(-3,-11),
		 * new Point(-8,7),new Point(1,88),new Point(-12,42),new
		 * Point(1,-37),new Point(2,77) ,new Point(-6,77),new Point(5,72),new
		 * Point(-4,-57),new Point(-18,-33),new Point(-12,42),new Point(-9,86),
		 * new Point(2,77),new Point(-8,77),new Point(-3,77),new
		 * Point(9,-42),new Point(16,41) ,new Point(-29,-37),new
		 * Point(0,-41),new Point(-21,18),new Point(-27,-34),new Point(0,77),new
		 * Point(3,74), new Point(-7,-69),new Point(-21,18),new
		 * Point(27,146),new Point(-20,13) ,new Point(21,130),new
		 * Point(-6,-65),new Point(14,-4),new Point(0,3),new Point(9,-5),new
		 * Point(6,-29), new Point(-2,73),new Point(-1,-15),new Point(1,76),new
		 * Point(-4,77),new Point(6,-29)
		 */
		/*
		 * new Point(0, 9), new Point(138, 429),
		 * 
		 * new Point(115, 359), new Point(115, 359), new Point(-30, -102), new
		 * Point(230, 709), new Point(-150, -686), new Point(-135, -613), new
		 * Point(-60, -248), new Point(-161, -481), new Point(207, 639), new
		 * Point(23, 79), new Point(-230, -691), new Point(-115, -341), new
		 * Point(92, 289), new Point(60, 336), new Point(-105, -467), new
		 * Point(135, 701), new Point(-90, -394), new Point(-184, -551), new
		 * Point(150, 774)
		 */

		};
		System.out.println(MaxLinePoints.maxPoints(points));

	}

	public static boolean samePoint(Point p1, Point p2) {
		if (p1.x == p2.x && p1.y == p2.y)
			return true;
		else
			return false;
	}

}
