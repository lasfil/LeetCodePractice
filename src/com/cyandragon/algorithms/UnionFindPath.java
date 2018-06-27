package com.cyandragon.algorithms;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UnionFindPath {
	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	@Test
	public void test() {
		
		new UnionFindPath().unionFindPath(5);
	}
int count = 0;
	public void unionFindPath(int N) {
		if (N < 2) {
			return;
		}
		int[][] matrix = new int[N-1][N-1];
		// List<List<Point>> route = new ArrayList<List<Point>>();
		// List<Point> root = new ArrayList<Point>();
		// root.add(new Point(0, 0));
		// route.add(root);
		unionFindPath(new int[] { 0, 0 }, N, new StringBuilder("From"));
	}

	private void unionFindPath(List<List<Point>> route, int n) {
		// TODO Auto-generated method stub

	}

	private void unionFindPath(int[] point, int n, StringBuilder sb) {
		
		sb.append("(" + point[0] + "," + point[1] + ") to");
		if (point[0] == n - 1 && point[1] == n - 1) {
			count++;
			System.out.println(sb + "count: " + count);
			return;
		}
		
		if (point[0] < n - 1) {
			point[0]++;
			unionFindPath(point, n, new StringBuilder(sb));
			point[0]--;
		}
		if (point[1] < n - 1) {

			point[1]++;
			unionFindPath(point, n,  new StringBuilder(sb));
			point[1]--;
		}

	}
}
