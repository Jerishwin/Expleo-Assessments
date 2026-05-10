package com.JavaFundamentals;
import java.util.*;

public class Problem1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("No of Participants: ");
		int n = sc.nextInt();
		
		int[] tokenNumbers = new int[n];
		
		System.out.print("Enter the Token Numbers: ");
		for(int i=0;i<n;i++) {
			tokenNumbers[i]= sc.nextInt();
		}
		
		int[] winners = new int[3];
		
		for(int i=0;i<n;i++) {
			
			int sum = 0,temp=tokenNumbers[i];
			while(temp>10) { // runs until the number is single digit
	
				while(temp!=0) { //sum of the digits
					int a = temp%10;
					temp/=10;
					sum+=a;
				}
				temp=sum;
				sum=0;
			}
			
			if(temp==7) { // checking for winner
				winners[0]=tokenNumbers[i];
			}else if(temp==5) {
				winners[1]=tokenNumbers[i];
			}else if(temp==3) {
				winners[2]=tokenNumbers[i];
			}
		}
		
		System.out.println("First Prize is to token: "+winners[0]
				+ "\nSecond Prize is to token: "+winners[1]
				+ "\nThird Prize is to token: "+winners[2]);
		
		sc.close();
	}

}
