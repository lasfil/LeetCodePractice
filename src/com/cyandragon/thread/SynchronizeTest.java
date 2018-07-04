package com.cyandragon.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizeTest {

	public static void main(String[] args) {
		QueueStock stock = new QueueStock();
		Runnable producer = () -> {

			while (true) {
				try {
					stock.addStock();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				Thread.yield();
			}

		};

		Runnable consumer = new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {

						stock.removeStock();
					} catch (Exception e) {
						e.printStackTrace();
					}
					Thread.yield();
				}
			}

		};
		new Thread(producer).start();
		new Thread(consumer).start();
		new Thread(producer).start();
		new Thread(consumer).start();
		new Thread(producer).start();

	}
}

class Stock {
	final private int MAX_STOCK = 10;
	LinkedList<Character> stock = new LinkedList<Character>();

	synchronized public void addStock() throws InterruptedException {

		while (stock.size() == MAX_STOCK) {
			System.out.println("Stock MAX size " + Thread.currentThread().getName() + " wait");
			wait();
		}

		System.out.println(Thread.currentThread().getName() + " produce to size " + stock.size());
		stock.add('s');
		notifyAll();
	}

	synchronized public void removeStock() throws InterruptedException {
		while (stock.size() == 0) {
			System.out.println("NO Stock " + Thread.currentThread().getName() + " wait");
			wait();
		}

		System.out.println(Thread.currentThread().getName() + " remove to size " + stock.size());
		stock.remove();
		notifyAll();
	}

}

class LockStock {
	final private int MAX_STOCK = 10;
	LinkedList<Character> stock = new LinkedList<Character>();
	Lock stockLock = new ReentrantLock();
	Condition fullStock = stockLock.newCondition();
	Condition emptyStock = stockLock.newCondition();

	public void addStock() {

		stockLock.lock();
		try {
			while (stock.size() == MAX_STOCK) {
				System.out.println("LockStock MAX size " + Thread.currentThread().getName() + " wait");
				fullStock.await();
			}

			System.out.println(Thread.currentThread().getName() + " produce to size " + stock.size());
			stock.add('s');
			emptyStock.signalAll();
		} catch (Exception e) {

		} finally {
			stockLock.unlock();
		}

	}
	public void removeStock() {
		stockLock.lock();
		try {
			while (stock.size() == 0) {
				System.out.println("NO LockStock " + Thread.currentThread().getName() + " wait");
				emptyStock.await();
			}

			System.out.println(Thread.currentThread().getName() + " remove to size " + stock.size());
			stock.remove();
			fullStock.signalAll();
		} catch (Exception e) {

		} finally {
			stockLock.unlock();
		}
	}

}

class QueueStock {
	final private int MAX_STOCK = 10;
	BlockingQueue<Character> stock = new LinkedBlockingQueue<Character>(MAX_STOCK);

	public void addStock() throws InterruptedException {
		// SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
		ThreadLocal<SimpleDateFormat> localsdf = ThreadLocal
				.withInitial(() -> new SimpleDateFormat("hh:mm:ss dd/MM/yyyy"));
		System.out.println(localsdf.get().format(new Date()));
		if (stock.size() == MAX_STOCK) {
			System.out.println("QueueStock MAX size " + Thread.currentThread().getName() + " wait");
		}

		stock.put('s');
		System.out.println(Thread.currentThread().getName() + " produce to size " + stock.size());
	}

	public void removeStock() throws InterruptedException {
		if (stock.size() == 0) {
			System.out.println("NO QueueStock " + Thread.currentThread().getName() + " wait");
		}
		stock.take();
		System.out.println(Thread.currentThread().getName() + " consume to size " + stock.size());
	}
}
