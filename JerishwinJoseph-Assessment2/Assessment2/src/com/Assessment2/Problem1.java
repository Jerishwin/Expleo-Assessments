package com.Assessment2;
import java.util.*;

/* This Program Implements Customer and account class
 * for a basic banking transactions 
*/

class Customer{ // This is the customer class
	
	private int id;
	private String name;
	private char gender;
	
	public Customer(int id, String name, char gender) {
		
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Customer id=" + id + ", name=" + name;
	}
	
}

class Account {
	
	private int id;
	private Customer customer;
	private double balance = 0.0;
	
	public Account(int id, Customer customer, double balance) {

		this.id = id;
		this.customer = customer;
		this.balance = balance;
	}

	public Account(int id, Customer customer) {
		
		this.id = id;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	} 
	
	public Customer getCustomerName() {
		return customer;
	}
	
	public Account deposit(double amount) {
		
		balance+=amount;
		System.out.println("The Money is deposited");
		return this;
	}
	
	public Account withdraw(double amount) {
		
		if(balance>=amount) {
			balance-=amount;
			System.out.println("The Money is withdrawn");
			
		}else {
			System.out.println("Amount withdrawn exceeds the curent balance");
		}
		return this; // return to the class object
	}
	
	
}

public class Problem1 {

	public static void main(String[] args) {

		Customer A1 = new Customer(01,"Jack",'m');
		Account B1 = new Account(011,A1,30000);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ACCOUNT DETAILS: ");
		System.out.println("ACCOUNT_ID: "+B1.getId());
		System.out.println("CUSTOMER_ID: "+B1.getCustomer().getId());
		System.out.println("CUSTOMER_NAME: "+B1.getCustomerName());
		System.out.println("CUSTOMER_GENDER: "+B1.getCustomer().getGender());
		System.out.println("ACCOUNT_BALANCE: "+B1.getBalance());
		
		do {
			System.out.println("PLEASE SELECT ONE OPTION FROM BELOW\r\n"
					+ "1.WITHDRAW\n"
					+ "2. DEPOSIT\n"
					+ "3. CHECK BALANCE\n"
					+ "4. EXIT\n"
					+ "OPTION:");
			
			int option = sc.nextInt();
			double amount;
			
			switch(option) {
			
			case 1:
				System.out.println("ENTER AMOUNT TO WITHDRAW: ");
				amount = sc.nextDouble();
				B1.withdraw(amount);
				break;
				
			case 2:
				System.out.println("ENTER AMOUNT TO DEPOSIT: ");
				amount = sc.nextDouble();
				B1.deposit(amount);
				break;
			
			case 3:
				System.out.println(B1.getBalance());
				break;
				
			case 4:
				System.out.println("THANK YOU FOR BANKING WITH US!!");
				sc.close();
				return;
			}
		}while(true);
		
	}

}
