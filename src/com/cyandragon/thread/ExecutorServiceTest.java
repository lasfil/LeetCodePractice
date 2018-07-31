package com.cyandragon.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {
	private static int count;

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(4);
		//ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < 50; i++) {
			pool.submit(() -> {
				int id = count++;
				System.out.println("Thread: " + id);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("finish Thread: " + id);
			});
		}
		pool.shutdown();
	}
}
