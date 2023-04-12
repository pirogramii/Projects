package com.jspiders.multithreading.threads;

public class MyThread1 extends Thread{
	
	@Override
	public void run() {
		for(int i = 1 ; i <= 5 ; i++) {
			
			System.out.println("Name of Thread "+this.getName()+" Priority of Thread "+this.getPriority());
		}
}
}
