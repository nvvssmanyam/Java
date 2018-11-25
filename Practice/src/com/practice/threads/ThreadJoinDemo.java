package com.practice.threads;

public class ThreadJoinDemo extends Thread {

	public void run() {
		for(int i=1; i<=5; i++) {
			try {
				sleep(2000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " :: "+i);
		}
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new ThreadJoinDemo(), "ThreadJoinDemo thread");
		
		t1.start();
		for(int i=1; i<=5; i++) {
			try {
				// t1.join ran by Main thread, so main thread till wait t1 will complete
				t1.join();
				// If we ran current thread.join it will go to deadlock situation
				// Thread.currentThread().join();
				sleep(2000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " :: "+i);
		}
		
	}
	
}
