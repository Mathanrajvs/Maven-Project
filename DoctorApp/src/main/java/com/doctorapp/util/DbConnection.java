package com.doctorapp.util;

import java.sql.*;

public class DbConnection {
	static Connection connection;

	public static Connection openConnection() {
		//String drivername = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/doctordb";
		String username = "root";
		String password = "root";
		
		Connection connection = null;
		try {
			//Class.forName(drivername);
			connection = DriverManager.getConnection(url, username, password);
			//ps=connection.prepareStatement(Queries.CREATEQUERY);
			//ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

	public static void closeConnection() {
		try {
			if (connection != null)
				connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
