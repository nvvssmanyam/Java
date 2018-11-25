package com.practice.threads;

public class ThreadSleepDemo extends Thread {
	
	public void run() {
		
		System.out.println("Thread "+this.getName() + " state ::: "+this.getState());
		
		for(int i=1; i<=10; i++) {
			try {
				// this.sleep also same as Thread.seleep beacuse sleep method is static method
				Thread.sleep(1000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("count is ::: "+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadSleepDemo t1 = new ThreadSleepDemo();
		ThreadSleepDemo t2 = new ThreadSleepDemo();
		
		System.out.println("Thread "+t1.getName() + " state ::: "+t1.getState());
		System.out.println("Thread "+t2.getName() + " state ::: "+t2.getState());		
		
		t1.start();
		t2.start();
		
		Thread.sleep(500l);
		

		System.out.println("Thread "+t1.getName() + " state ::: "+t1.getState());
		System.out.println("Thread "+t2.getName() + " state ::: "+t2.getState());
		
	}

}
