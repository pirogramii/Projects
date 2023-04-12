package com.jspiders.multithreading.threads;

import com.jspiders.multithreading.resource.Account;

public class Person2 extends Thread {
	
	Account account;
	
	public Person2(Account account) {
		this.account = account ;
	}
	@Override
	public void run() {
		
		account.depositMoney(3000);
		account.withdrawMoney(1500);
	}
}
