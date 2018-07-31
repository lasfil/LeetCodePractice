package com.cyandragon.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

	Lock lock = new ReentrantLock();
	Condition a = lock.newCondition();
	Condition b = lock.newCondition();
	Condition c = lock.newCondition();

	private int status = 1;

	public static void main(String[] args) {
		ConditionTest test = new ConditionTest();
		Thread A = new Thread(() -> {
			test.lock.lock();
			try {
				for (int i = 0; i < 10; i++) {
					System.out.println("A status" + test.status);
					while (test.status != 0) {
						test.a.await();
					}
					System.out.println("A" + i);
					test.status = 1;
					test.b.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				test.lock.unlock();
			}

		});
		Thread B = new Thread(() -> {
			test.lock.lock();
			try {
				for (int i = 0; i < 10; i++) {
					System.out.println("B status" + test.status);

					while (test.status != 1) {
						test.b.await();
					}
					System.out.println("B" + i);
					test.status = 2;
					test.c.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				test.lock.unlock();
			}

		});

		Thread C = new Thread(() -> {
			test.lock.lock();
			try {
				for (int i = 0; i < 10; i++) {
					System.out.println("C status" + test.status);

					while (test.status != 2) {
						test.c.await();
					}
					System.out.println("C" + i);
					test.status = 0;
					test.a.signal();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				test.lock.unlock();
			}

		});

		
		C.start();
		A.start();
		B.start();
		

	}
}
