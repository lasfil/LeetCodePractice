package com.cyandragon.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInTurnWithoutLock {
	Integer status = 0;

	public static void main(String[] args) {
		PrintInTurnWithoutLock test = new PrintInTurnWithoutLock();
		Thread A = new Thread(() -> {
			int count = 10;
			while (count > 0) {
				//Lock lock = new ReentrantLock();
				//lock.lock();
				//System.out.println("A status" + test.status);
				try {
					while (test.status % 3 == 0) {
						System.out.print("Thread A: " + count);
						count--;
						Thread.sleep(3000);
						test.status++;
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					//lock.unlock();
				}
			}
		});
		Thread B = new Thread(() -> {
			int count = 10;
			while (count > 0) {
				//synchronized (test.status) {
				//System.out.println("B status" + test.status);
					while (test.status % 3 == 1) {
						System.out.print("Thread B: " + count);
						test.status++;
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						count--;
					}
				//}
			}
		});
		Thread C = new Thread(() -> {
			int count = 10;
			while (count > 0) {
				//synchronized (test.status) {
				//System.out.println("C status" + test.status);
					while (test.status % 3 == 2) {
						System.out.println("Thread C: " + count);
						test.status++;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						count--;
					}
				//}
			}
		});

		B.start();
		C.start();
		A.start();
		Thread D = new Thread(() -> {
			System.out.println("Thread D ");
			test.status++;
		});
		D.start();
	}
}
