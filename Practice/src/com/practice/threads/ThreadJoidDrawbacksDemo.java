package com.practice.threads;

public class ThreadJoidDrawbacksDemo extends Thread {
	
	Thread mainThread;

	public void run() {
		
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread state is ::: "+mainThread.getState());
		System.out.println("Completed t1 thread");
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadJoidDrawbacksDemo t1 = new ThreadJoidDrawbacksDemo();
		t1.mainThread = Thread.currentThread();
		t1.start();
		
		ThreadDemo2 t2 = new ThreadDemo2();
		t2.t1 = t1;
		t2.start();
		
		Thread.sleep(100l);
		System.out.println("Main thread calling join()");
		t1.join();
		System.out.println("I'm out of join");
	}
	
}

class ThreadDemo2 extends Thread {
	
	ThreadJoidDrawbacksDemo t1 = null;
	
	public void run() {
		m();
	}
	
	public void m() {
		synchronized (t1) {
			System.out.println("I'm t2 and executing inside m() by locking t1 object");
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("I'm t2 and relasing lock and end of m() of t2");
		}
	}
	
}
