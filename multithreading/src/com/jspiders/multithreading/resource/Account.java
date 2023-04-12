package com.jspiders.multithreading.resource;

public class Account {
	
	int accountBalance;
	
	public Account(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public void checkBalance() {
		System.out.println("Current Balance is "+accountBalance+"rs.");
	}
	
	//Not Synchronized Methods
	
//	public void depositMoney(int amount) {
//		System.out.println("Depositing Money in Account");
//		accountBalance += amount ;
//		checkBalance();
//	}
//	
//	public void withdrawMoney(int amount) {
//		System.out.println("Withdrawing Money From Account");
//		if(amount > accountBalance) {
//			System.out.println("Insufficient Balance..!!");
//		}
//		accountBalance -= amount ;
//		checkBalance();
//	}
	
	
	
	//Synchronized Methods
	
	public synchronized void depositMoney(int amount) {
		accountBalance += amount ;
		System.out.println(amount+" rs deposited in account");
		checkBalance();
	}
	
	public synchronized void withdrawMoney(int amount) {
		if(amount <= accountBalance) {
			accountBalance -= amount;
		}
		else {
			System.out.println("Insufficient Balance..!!");
		}
		checkBalance();
	}
}
