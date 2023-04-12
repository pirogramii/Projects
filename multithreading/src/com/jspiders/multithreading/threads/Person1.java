package com.jspiders.multithreading.threads;

import com.jspiders.multithreading.resource.Account;

public class Person1 extends Thread {
	
	Account account;
	
	public Person1(Account account) {
		this.account = account;
	}
	
	@Override
	public void run() {

		account.depositMoney(5000);
		account.withdrawMoney(3000);
	}
}
