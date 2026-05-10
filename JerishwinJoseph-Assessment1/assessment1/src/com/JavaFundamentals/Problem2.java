package com.JavaFundamentals;

import java.util.*;

public class Problem2 {

	static int min(int a, int b, int c) {
		if (a < b) {
			if (a < c) {
				return a;
			} else {
				return c;
			}
		} else if (b < c) {
			return b;
		} else {
			return c;
		}
	}

	static int max(int a, int b, int c) {
		if (a > b) {
			if (a > c) {
				return a;
			} else {
				return c;
			}
		} else if (b > c) {
			return b;
		} else {
			return c;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the Three Numbers (a b c): ");
		int input1 = sc.nextInt();
		int input2 = sc.nextInt();
		int input3 = sc.nextInt();

		// Extract hundreds digits
		int h1 = input1 / 100;
		int h2 = input2 / 100;
		int h3 = input3 / 100;

		// Extract tens digits
		int t1 = (input1 / 10) % 10;
		int t2 = (input2 / 10) % 10;
		int t3 = (input3 / 10) % 10;

		// Extract unit digits
		int u1 = input1 % 10;
		int u2 = input2 % 10;
		int u3 = input3 % 10;

		int unit = min(u1, u2, u3);
		int tens = min(t1, t2, t3);
		int hundreds = min(h1, h2, h3);

		int maxNum = max(u1, u2, u3);
		maxNum = max(maxNum, t1, t2);
		maxNum = max(maxNum, t3, h1);
		maxNum = max(maxNum, h3, h2);

		maxNum *= 1000;

		int sum = (hundreds * 100) + (tens * 10) + unit;
		System.out.print("pin: " + (maxNum + sum));

		sc.close();

	}

}
