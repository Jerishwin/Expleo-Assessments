package com.JavaFundamentals;
import java.util.*;

public class Problem4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Starting Number: ");
		int a=sc.nextInt();
		System.out.print("Enter Ending Number: ");
		int b=sc.nextInt();
		
		
		System.out.print("Output: ");
		for(int i=a;i<=b;i++) {
			
			if(i%10==0) {
				System.out.print("dong ");
			}else if(i%5==0) {
				System.out.print("ding ");
			}else {
				System.out.print(i+" ");
			}
		}
		
		sc.close();
	}

}
