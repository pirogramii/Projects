package com.jspiders.multithreading.threads;

public class MyThread2 implements Runnable{
	
	@Override
		public void run() {
			for(int i = 1 ; i <= 5 ; i++) {
				System.out.println("Name of Thread "+Thread.currentThread().getName() 
						+ " , Priority of Thread "+Thread.currentThread().getPriority());
			}
	}
}
