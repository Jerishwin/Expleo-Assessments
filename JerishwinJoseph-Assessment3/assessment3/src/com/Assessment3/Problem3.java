package com.Assessment3;

import java.util.*;

abstract class BankTransactionException extends Exception {
	int errorCode;

	BankTransactionException(String msg, int code) {
		super(msg);
		errorCode = code;
	}
}

class InvalidAccountException extends BankTransactionException {
	String accountId;

	InvalidAccountException(String id) {
		super("Account ID cannot be empty", 1001);
		accountId = id;
	}
}

class InsufficientFundsException extends BankTransactionException {
	double shortfall;

	InsufficientFundsException(double s) {
		super("Shortfall: " + s, 1002);
		shortfall = s;
	}
}

class TransactionLimitException extends BankTransactionException {
	double limit;

	TransactionLimitException(double l) {
		super("Limit: " + l, 1003);
		limit = l;
	}
}

class TransactionValidator {
	static void validateTransaction(String id, double balance, double amount, double limit)
			throws BankTransactionException {
		if (id == null || id.isEmpty())
			throw new InvalidAccountException(id);
		if (amount > balance)
			throw new InsufficientFundsException(amount - balance);
		if (amount > limit)
			throw new TransactionLimitException(limit);
	}
}

public class Problem3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account ID:");
		String id = sc.nextLine();
		System.out.println("Enter balance:");
		double balance = sc.nextDouble();
		System.out.println("Enter transaction amount:");
		double amount = sc.nextDouble();
		System.out.println("Enter transaction limit:");
		double limit = sc.nextDouble();

		try {// Validate the transaction and catch any exceptions that occur
			TransactionValidator.validateTransaction(id, balance, amount, limit);
		} catch (InvalidAccountException e) {
			
			System.out.println("InvalidAccountException: " + e.getMessage() + " [Code: " + e.errorCode + "]");
		} catch (InsufficientFundsException e) {
			
			System.out.println("InsufficientFundsException: " + e.getMessage() + " [Code: " + e.errorCode + "]");
		} catch (TransactionLimitException e) {
			
			System.out.println("TransactionLimitException: " + e.getMessage() + " [Code: " + e.errorCode + "]");
		} catch (BankTransactionException e) {
			
			System.out.println("Error: " + e.getMessage());
		} finally {
			
			System.out.println("Validation complete.");
		}
	}

}
