package com.cyandragon.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static int count;

	public static void main(String[] args) {
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
		ThreadPoolExecutor threadpool = new ThreadPoolExecutor(2, 5, 60L, TimeUnit.SECONDS, workQueue);

		for (int i = 0; i < 100; i++) {
			threadpool.execute(() -> {
				int id = count++;
				System.out.println("Thread: " + id);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("workQueue size: " + workQueue.size());
				System.out.println("finish Thread: " + id);
			});
		}
	}
}
