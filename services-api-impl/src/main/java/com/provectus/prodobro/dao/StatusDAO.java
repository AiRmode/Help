package com.provectus.prodobro.dao;

import com.provectus.prodobro.shared.status.StatusEnumNew;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatusDAO {

	private String URL;
	private String userName;
	private String pass;

	public StatusDAO(String driver, String URL, String userName, String pass) {
		System.setProperty("jdbc.drivers", driver);
		this.URL = URL;
		this.userName = userName;
		this.pass = pass;
	}

	public void pushStatusEnumToDB() throws SQLException {
		Connection connection = getConnection();
		connection.setAutoCommit(false);

		Statement statement1 = connection.createStatement();
		String SQL1 = "CREATE TABLE IF NOT EXISTS status (code INTEGER NOT NULL, title VARCHAR(255) NOT NULL, PRIMARY KEY (code));";
		statement1.execute(SQL1);
		connection.commit();


		String SQL = "INSERT INTO status (code, title) VALUES (?, ?) ON CONFLICT (code) \n" +
				"DO UPDATE SET title = EXCLUDED.title;";
		PreparedStatement statement = connection.prepareStatement(SQL);
		StatusEnumNew[] values = StatusEnumNew.values();
		List<StatusEnumNew> myList = new ArrayList<>();
		Collections.addAll(myList, values);
		myList.forEach((status) -> {
			try {
				statement.setInt(1, status.getCode());
				statement.setString(2, status.name());
				statement.addBatch();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		statement.executeBatch();
		connection.commit();
	}

//	public void deleteIfNotInUse() {}

	private Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, userName, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	private void closeConnection(Connection connection) {
		if (connection == null) {
			return;
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
