package com.JavaFundamentals;
import java.util.*;

public class Problem3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a positive integer: ");
		int n = sc.nextInt();
		
		int sum=0;
		if(n%2!=0) {
			System.out.print("The given number is not perfect");
		}else {
			
			for(int i=1;i<=n/2;i++) {
				if(n%i==0) {
					sum+=i;
				}
			}
		}
		
		if(sum==n) {
			System.out.print("The given number is perfect");
		}else {
			System.out.print("The given number is not perfect");
		}
		
		sc.close();

	}

}
