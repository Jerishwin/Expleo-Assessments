package com.Assessment2;

abstract class Product{ //Super class
	
	private int id;
	private String name;
	private double price;
	
	public Product(int id, String name, double price) {
		
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	abstract void displayinfo();
	
}

class ElectronicProduct extends Product{ // Sub class 1
	int warrantyPeriod;

	public ElectronicProduct(int id, String name, double price, int warrantyPeriod) {
		super(id, name, price);
		this.warrantyPeriod = warrantyPeriod;
	}

	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}

	@Override
	void displayinfo() { //method override
		System.out.println("\nElectronicProduct:");
		System.out.println("Productid "+getId()+"\nProductName "+getName()+"\nPrice "+getPrice()+"\nWarranty Period "+warrantyPeriod+" months");
	}
}

class ClothingProduct extends Product{ // Subclass 2
	String size;
	String material;
	
	
	public ClothingProduct(int id, String name, double price, String size, String material) {
		super(id, name, price);
		this.size = size;
		this.material = material;
	}

	public String getSize() {
		return size;
	}

	public String getMaterial() {
		return material;
	}

	@Override
	void displayinfo() { // method override
		System.out.println("\nClothingProduct:");
		System.out.println("Productid "+getId()+"\nProductName "+getName()+"\nPrice "+getPrice()+"\nSize "+size+"\nMaterial "+material);
	}
	
}

public class Problem2 {

	public static void main(String[] args) {
		
		Product A1 = new ElectronicProduct(12,"Laptop",1200.0,12);
		Product A2 = new ElectronicProduct(145,"Phone",200.0,24);
		
		Product B1 = new ClothingProduct(17,"T-shirt",200.0,"M","cotton");
		Product B2 = new ClothingProduct(15,"Pants",200.0,"XL","cotton");
		
		A1.displayinfo();
		A2.displayinfo();
		
		B2.displayinfo();
		B1.displayinfo();
	}

}
