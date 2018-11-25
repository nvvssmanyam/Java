package com.practice.threads;

public class ThreadPriorityDemo extends Thread {
	
	public void run() {
		
		if("Second Thread t2".equals(this.getName().toString())) {
			Thread.yield();
		}
		
		System.out.println("I'm in run "+this.getName());
		System.out.println(this.getName()+"'s priority ::: "+this.getPriority());
	}
	
	public static void main(String[] args) {
		
		ThreadPriorityDemo t1 = new ThreadPriorityDemo();
		t1.setName("First Thread t1");
		t1.setPriority(MAX_PRIORITY);
		
		ThreadPriorityDemo t2 = new ThreadPriorityDemo();
		t2.setName("Second Thread t2");
		t2.setPriority(MIN_PRIORITY);
		
		t1.start();
		t2.start();
		
		/*
		 *   Yield method will give the chance to high priority thread if any
		 *   If not it won't give a chance to low priority threads 
		 */
		Thread.yield();
		
		System.out.println("I'm in run "+Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName()+"'s priority ::: "+Thread.currentThread().getPriority());
		
	}
	
	/*
	 * Most of the senarios the output will be like below,
	 * Second Thread t2 will give a chance to First Thrad t1
	 * 
	 * I'm in run main
	 * main's priority ::: 5
	 * I'm in run Second Thread t2
	 * I'm in run First Thread t1
	 * First Thread t1's priority ::: 10
	 * Second Thread t2's priority ::: 1
	 */
	
}
