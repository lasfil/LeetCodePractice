package com.cyandragon.thread;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandlerTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			System.out.println("t1 sleep+++");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("t1 sleep--");
			System.out.println(3/0);
			System.out.println(6/3);
		});
		t1.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("exception handled");
				//e.printStackTrace();
				
			}
			
		});
		
		t1.start();

	}
}
