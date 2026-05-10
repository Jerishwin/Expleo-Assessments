package com.JavaFundamentals;
import java.util.*;

public class Problem5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int marks[]= new int[100];
		
		int i=0;
		do {
			int a=sc.nextInt();
			
			if(a<0) {
				break;
			}
			marks[i]=a;
			
			i++;
		}while(true);
		
		int[] finals=marks;
		
		for(int j=0;j<finals.length;j++) {
			if(finals[j]%9==0) {
				finals[j]=4;
			}else if(finals[j]%3==0) {
				finals[j]=3;
			}else if(finals[j]%8==0) {
				finals[j]=2;
			}else if(finals[j]%2==0) {
				finals[j]=0;
			}else  {
				finals[j]=1;
			}
		}
		
		for(int j:finals) {
			System.out.print(j+" ");
		}
		
		sc.close();
	}

}
