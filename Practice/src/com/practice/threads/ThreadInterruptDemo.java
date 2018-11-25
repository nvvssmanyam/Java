package com.practice.threads;  

public class ThreadInterruptDemo extends Thread {
	
	public void run() {
		try {
			Thread.sleep(2000l);
			System.out.println(this.getName()+ " running.");
		} catch (InterruptedException e) {
			// Any exception in run method should with try-catch we can't throw
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		ThreadInterruptDemo t1 = new ThreadInterruptDemo();
		Thread.currentThread().interrupt();
		System.out.println(Thread.currentThread().getName()+" status :: "+Thread.currentThread().isInterrupted());
		
		//Thread.interrrupted will give the current thread status as well make the interrupt status flag false
		System.out.println(Thread.interrupted());
		System.out.println(Thread.interrupted());
		
		t1.start();
		
		System.out.println("Before interrupt method called "+t1.getName()+" status :: "+t1.isInterrupted());
		t1.interrupt();
		System.out.println("After interrupt method called "+t1.getName()+" status :: "+t1.isInterrupted());
	}
	
}
