package com.Assessment3;

import java.util.*;

class Product implements Comparable<Product> {
	int id;
	String name;
	String category;
	double price;
	double discount;
	int quantity;

	Product(int id, String name, String category, double price, double discount, int quantity) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
	}

	public String toString() {
		return id + " | " + name + " | " + category + " | " + price + " | " + discount + " | " + quantity;
	}

	@Override
	public int compareTo(Product o) {
		if (this.id < o.id)
			return -1;
		if (this.id > o.id)
			return 1;
		return 0;
	}
}

public class Problem4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();

		products.add(new Product(101, "iPhone 10", "Mobile", 20000.0, 0.2, 2));
		products.add(new Product(102, "Dell", "Laptop", 20000.0, 0.3, 4));
		products.add(new Product(103, "iPhone 13", "Mobile", 10000.0, 0.5, 1));
		products.add(new Product(104, "Lenovo", "Laptop", 70000.0, 0.8, 3));
		products.add(new Product(105, "iPhone12", "Mobile", 50000.0, 0.5, 6));

		while (true) {
			System.out.println("1. Sort by Id\n" + "2. List Mobiles with price more than 40000\n" + "3. Exit\n"
					+ "Enter the option for sorting: ");
			int option = sc.nextInt();

			switch (option) {
			
			case 1:// Sort the products by id and print them
				Collections.sort(products);
				for (Product p : products) {
					System.out.println(p);
				}
				break;

			case 2:// List the products which are in the category "Mobile" and have price more than 40000
				for (Product p : products) {
					if (p.category.equals("Mobile") && p.price > 40000) {
						System.out.println(p);
					}
				}
				break;

			case 3:// Exit the program
				System.out.println("Thank you!!!");
				sc.close();
				return;
			}
		}
	}

}
