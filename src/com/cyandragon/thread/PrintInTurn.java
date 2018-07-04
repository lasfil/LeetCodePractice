package com.cyandragon.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInTurn {
	public static Integer status = 0;

	public static void main(String[] args) {

		Thread A = new Thread(() -> {
			int count = 10;
			Lock lock = new ReentrantLock();
			lock.lock();
			try {
				while (count > 0) {
					if (status == 0) {
						System.out.println("Thread A print" + count);
						count--;
						status = 1;
					}

				}
			} finally {
				lock.unlock();
			}

		});

		Thread B = new Thread(() -> {
			int count = 10;
			Lock lock = new ReentrantLock();
			lock.lock();
			try {
				while (count > 0) {
					if (status == 1) {
						System.out.println("Thread B print" + count);
						status = 2;
						count--;
					}
				}
			} finally {
				lock.unlock();
			}
		});
		Thread C = new Thread(() -> {
			int count = 10;
			synchronized(status) {
				while (count > 0) {
					if (status == 2) {
						System.out.println("Thread C print" + count);
						status = 0;
						count--;
					}
				}
			} 
		});

		A.start();
		B.start();
		C.start();
	}
}
