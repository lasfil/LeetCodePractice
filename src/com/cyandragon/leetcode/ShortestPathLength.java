package com.cyandragon.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathLength {
	public static void main(String[] args) {
		// shortestPathLength(new int[][] { { 1, 2, 3 }, { 0 }, { 3 }, { 2 } });
		int[][] graph = new int[][] { { 1 }, { 0, 2, 4 }, { 1, 3, 4 }, { 2 }, { 1, 2 } };
//		int[][] graph = new int[][] { { 2, 3 }, { 7 }, { 0, 6 }, { 0, 4, 7 }, { 3, 8 }, { 7 }, { 2 }, { 5, 3, 1 },
//				{ 4 } };
		// {{1,2,3},{0},{0},{0}};
		System.out.println(shortestPathLength(graph));
	}

	public static int shortestPathLength1(int[][] graph) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < graph.length; i++) {
			LinkedList<Integer> route = new LinkedList<Integer>();
			route.add(i);
			min = Math.min(bfs(graph, route), min);
		}
		return min == Integer.MAX_VALUE ? 0 : min - 1;
	}

	private static int bfs(int[][] graph, LinkedList<Integer> route) {
		int min = Integer.MAX_VALUE;
		int current = route.getLast();
		for (Integer next : graph[current]) {
			route.addFirst(next);
			if (route.stream().distinct().count() == graph.length) {
				System.out.println(route);
				min = Math.min(min, route.size());
			}
			route.removeFirst();
		}

		for (Integer next : graph[current]) {
			if (graph[current].length == 1 || !route.contains(next)) {
				route.addFirst(next);
				if (route.stream().distinct().count() != graph.length) {
					min = Math.min(min, bfs(graph, route));
				}
				route.removeFirst();
			}
		}
		return min;
	}

	public static int shortestPathLength(int[][] graph) {
		int N = graph.length;
		Queue<State> queue = new LinkedList();
		int[][] dist = new int[1 << N][N];
		for (int[] row : dist)
			Arrays.fill(row, N * N);

		for (int x = 0; x < N; ++x) {
			queue.offer(new State(1 << x, x));
			dist[1 << x][x] = 0;
		}

		while (!queue.isEmpty()) {
			State node = queue.poll();
			int d = dist[node.cover][node.head];
			if (node.cover == (1 << N) - 1)
				return d;

			for (int child : graph[node.head]) {
				int cover2 = node.cover | (1 << child);
				if (d + 1 < dist[cover2][child]) {
					dist[cover2][child] = d + 1;
					queue.offer(new State(cover2, child));

				}
			}
		}

		throw null;
	}
}

class State {
	int cover, head;

	State(int c, int h) {
		cover = c;
		head = h;

	}

	public String toString() {
		return "cover: " + cover + " head: " + head;
	}
}
