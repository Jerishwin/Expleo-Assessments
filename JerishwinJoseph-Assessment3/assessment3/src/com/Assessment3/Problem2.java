package com.Assessment3;

import java.util.*;

public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a string:");
		String input = sc.nextLine();

		if (input.length() >= 2) {// If the input has 2 or more characters, print the first 2 characters
			System.out.println(input.substring(0, 2));
		} else {
			for (int i = input.length(); i < 2; i++) {// If the input has less than 2 characters, append @ till it has 2 characters
				input += "@";
			}
			System.out.println(input);
		}

		sc.close();
	}

}
