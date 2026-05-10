package com.Assessment3;

import java.io.*;
import java.util.*;

public class Problem1 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("src/com/Assessment3/word.txt"));
			Map<String, Integer> map = new TreeMap<>();

			while (sc.hasNext()) {
				String word = sc.next();

				if (map.containsKey(word)) {// If the word is already in the map, increment total count
					map.put(word, map.get(word) + 1);
				} else {
					map.put(word, 1);// If the word is not in the map, add it with count 1
				}
			}

			for (String key : map.keySet()) {
				System.out.println(key + ": " + map.get(key));// Print the word and its count
			}
			System.out.println("Unique words: " + map.size());// Print the total number of unique words
			
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error: word.txt not found");
		}
	}

}
