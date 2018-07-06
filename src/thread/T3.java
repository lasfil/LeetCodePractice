package thread;

public class T3 {
	
	
	public static void main(String[] args) {
		
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		new Thread( new Runnable(){
			
			public void run() {
				int i = 0;
				while(i < 10) {
					i++;
					
					try {
						synchronized(c) {
							c.wait();
						}
						
						System.out.println("A");
						synchronized(a) {
							a.notify();
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
		new Thread( new Runnable(){
			
			public void run() {
				int i = 0;
				while(i < 10) {
					i++;
					try {
						synchronized (a) {
							a.wait();
						}
						System.out.println("B");
						
						synchronized (b) {
							b.notify();
						}
						
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
				}
				
			}
		}).start();
		
		new Thread( new Runnable(){
			
			public void run() {
				int i = 0;
				while(i < 10) {
					i++;
					try {
						synchronized (b){
							b.wait();
						}
						
						System.out.println("C");
						
						synchronized(c) {
							c.notify();
						}
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
		synchronized(c) {
			c.notify();
		}
		
	}

}
