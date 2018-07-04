package com.cyandragon.thread;

public class YieldTest {
	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("+++Producer number:" + i);
					Thread.yield();
				}
				
			}
			
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("---Consumer number:" + i);
					Thread.yield();
				}
				
			}
			
		}).start();
	}
}
