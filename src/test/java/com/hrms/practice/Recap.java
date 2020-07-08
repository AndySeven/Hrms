package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Recap {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc:drivertype:hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void getConnection() throws SQLException {
		// reasons of exception:
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		DatabaseMetaData dbMetaData = con.getMetaData();
		String dbName = dbMetaData.getDatabaseProductName();
		System.out.println(dbName); // --> MySQL

		Statement st = con.createStatement();

		// look at the table in the MySQL WorkBanch first
		ResultSet rs = st.executeQuery("select * from ohrm_skill;");

		ResultSetMetaData rsmd = rs.getMetaData();
		int cols = rsmd.getColumnCount();
		System.out.println(cols);

		// database starts from 1, not from 0
		for (int i = 1; i <= cols; i++) {
			String colName = rsmd.getColumnName(i);
			System.out.println("column name: " + colName);
		}

		while (rs.next()) {
			String id = rs.getObject("id").toString();
			String name = rs.getString("name");
			System.out.println(id + "    -- " + name);
		}
		rs.close();
		st.close();
		con.close();

	}
}
