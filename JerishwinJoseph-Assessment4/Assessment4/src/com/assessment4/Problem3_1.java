package com.assessment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Problem3_1 {

	private static final String URL = "jdbc:mysql://localhost:3306/problem1";
	private static final String USER = "root";
	private static final String PASSWORD = "JeriJose.1";

	public static void main(String[] args) {

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

			String sql = "";

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			
			resultSet.close();
			statement.close();
			connection.close();
			
			
		} catch (SQLException e) {
			System.out.print(e);
		}

}}
