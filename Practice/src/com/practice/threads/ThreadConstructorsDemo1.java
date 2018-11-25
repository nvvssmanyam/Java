package com.practice.threads;

public class ThreadConstructorsDemo1 extends Thread {
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println("I'm in run() by "+Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getId());
		
		// Thread(Runnable target)
		// Thread t1 = new Thread(new ThreadConstructorsDemo1());
		// t1.setName("VVS Thread);
		 
		// Thread(Runnable target, String threadName)
		// Thread t1 = new Thread(new ThreadConstructorsDemo1(), "VVS Thread");
		
		Thread t1 = new Thread("Thread-0");
		
		t1.start();
	}
	
}
