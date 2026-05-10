package com.assessment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Problem3 extends Exception {

	private static final String URL = "jdbc:mysql://localhost:3306/problem1";
	private static final String USER = "root";
	private static final String PASSWORD = "JeriJose.1";

	public static void main(String[] args) {

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

			String sql = "Select*from books";

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int bookId = resultSet.getInt("book_id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				int publishedYear = resultSet.getInt("published_year");
				String genre = resultSet.getString("genre");
				int copies = resultSet.getInt("copies_available");

				System.out.println("Book ID: " + bookId);
				System.out.println("Title: " + title);
				System.out.println("Author: " + author);
				System.out.println("Published Year: " + publishedYear);
				System.out.println("Genre: " + genre);
				System.out.println("Copies Avail: " + copies);
				System.out.println();
			}
			
			resultSet.close();
			statement.close();
			connection.close();
			
			
		} catch (SQLException e) {
			System.out.print(e);
		}

	}

}
