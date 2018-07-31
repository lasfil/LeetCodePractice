package com.cyandragon.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	private Semaphore a = new Semaphore(1);
	private Semaphore b = new Semaphore(0);
	private Semaphore c = new Semaphore(0);

	class PrintA implements Runnable {
		int count = 10;

		@Override
		public void run() {
			while (count > 0) {
				try {
					a.acquire();
					System.out.print("A" + count);
					b.release();
					count--;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	class PrintB implements Runnable {
		int count = 10;

		@Override
		public void run() {
			while (count > 0) {
				try {
					b.acquire();
					System.out.print("B" + count);
					c.release();
					count--;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	class PrintC implements Runnable {
		int count = 10;

		@Override
		public void run() {
			while (count > 0) {
				try {
					c.acquire();
					System.out.println("C" + count);
					a.release();
					count--;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		SemaphoreTest test = new SemaphoreTest();
		new Thread(test.new PrintB()).start();
		new Thread(test.new PrintA()).start();
		
		new Thread(test.new PrintC()).start();
	}
}
