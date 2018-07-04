package com.cyandragon.thread;

public class JoinTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("t1 start");
				try {
					Thread.sleep(2000);
					System.out.println("t1 sleep 1");
					Thread.sleep(2000);
					System.out.println("t1 sleep 2");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t1 end");
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("t2 start");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t2 end");
				
			}
			
		});
		
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("t3 start");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t3 end");
				
			}
			
		});
		
		t1.start();
		System.out.println("t1 join+");
		t1.join(20000);
		System.out.println("t1 join-");
		t2.start();
		//t2.join();
		t3.start();
		//t3.join();
	}
}
