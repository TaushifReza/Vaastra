package com.vaastra.DBConnection;

import java.sql.*;

public class DatabaseConnection {

	private static Connection con;

	public static Connection getConnection() {
		try {

			if (con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");

				String url = "jdbc:mysql://localhost:3306/vaastra";
				String user = "root";
				String pass = "";

				con = DriverManager.getConnection(url, user, pass);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
