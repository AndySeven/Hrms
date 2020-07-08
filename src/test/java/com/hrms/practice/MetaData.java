package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaData {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc:drivertype:hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void abc() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		DatabaseMetaData dbMetaData = conn.getMetaData();
		String driverName = dbMetaData.getDriverName();
		String dbVersion = dbMetaData.getDatabaseProductVersion();
		System.out.println(driverName);
		System.out.println(dbVersion);
	}

	// query - display all info about employee whose emp_number is 14688
	@Test
	public void rsMetaData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees where emp_number=14688");
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int colNum = rsMetaData.getColumnCount();
		String colName1 = rsMetaData.getColumnName(1);
		System.out.println(colNum+" "+colName1);
		
		for(int i=1; i<=colNum; i++) {
			System.out.println(rsMetaData.getColumnName(i));
		}	
	}
}
