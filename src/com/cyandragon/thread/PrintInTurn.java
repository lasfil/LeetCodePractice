package com.cyandragon.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInTurn {
	public static Integer status = 0;

	class B extends Thread {
		@Override
		public void run() {
			int count = 10;
			synchronized (this) {
				while (count > 0) {
					if (status == 1) {
						System.out.println("Thread B: " + count);
						status = 2;
						count--;
					}
				}
			}
		}
	}

	public static void main(String[] args) {

		Thread A = new Thread(() -> {
			int count = 10;
			Lock lock = new ReentrantLock();
			lock.lock();
			try {
				while (count > 0) {
					if (status == 0) {
						System.out.println("Thread A: " + count);
						count--;
						status = 1;
					}

				}
			} finally {
				lock.unlock();
			}

		});

		Thread C = new Thread(() -> {
			int count = 10;
			synchronized (status) {
				while (count > 0) {
					if (status == 2) {
						System.out.println("Thread C: " + count);
						status = 3;
						count--;
					}
				}
			}
		});

		Lock eLock = new ReentrantLock();
		Condition ePrint = eLock.newCondition();
		Condition dPrint = eLock.newCondition();
		Thread D = new Thread(() -> {
			int count = 10;
			eLock.lock();
			try {
				while (count > 0) {
					while (status != 3) {
						dPrint.await();
					}
					System.out.println("Thread D: " + count);
					status = 4;
					count--;
					ePrint.signal();

				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				eLock.unlock();
			}
		});
		Thread E = new Thread(() -> {
			int count = 10;
			eLock.lock();
			try {
				while (count > 0) {
					while (status != 4) {
						ePrint.await();
					}
					System.out.println("Thread C: " + count);
					status = 0;
					count--;
					dPrint.signal();

				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				eLock.unlock();
			}
		});
		
		A.start();
		new PrintInTurn().new B().start();
		C.start();
		D.start();
		E.start();
	}
}
