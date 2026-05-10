package com.Assessment2;
//this program updates the salary of the employee
class Employee{
	
	int id;
	String name;
	String designation;
	double salary;
	
	
	public Employee(int id, String name, String designation, double salary) {
		
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	
	
	public double getSalary() {
		return salary;
	}


	public void displayinfo() {
		System.out.println("Employee Id "+id+"\nEmployee Name "+name+"\nDesignation "+designation+"\nSalary "+salary);
	}
	
	public void increseSalary(double percentage) { //initial method
		
		salary+=(salary*(percentage/100));
		
		System.out.println("Updated Salary "+getSalary());
	}
	
	public void increseSalary(double percentage,double bonus) { // method overloading
		increseSalary(percentage);
		salary+=bonus;
		
	}
	
}

public class Problem3 {

	public static void main(String[] args) {
		
		Employee emp = new Employee(12,"Jack","Tester",30000.0);
		
		emp.displayinfo();
		emp.increseSalary(12);
		emp.increseSalary(40, 5000);
	}

}
