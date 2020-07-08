package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

public class JDBCDemo {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc:drivertype:hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void abc() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		// if code goes here it will print
		System.out.println("DB Connection is successfull");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees;");
		rs.next();
		String firstname = rs.getString("emp_firstname");
		System.out.println(firstname);
		rs.next();
		String firstname2 = rs.getObject("emp_firstname").toString();
		System.out.println(firstname2);

		while (rs.next()) {
			String fname = rs.getString("emp_firstname");
			// System.out.println(name);
			String lname = rs.getString("emp_lastname");
			if (fname.equals("Alfredo")) {
				System.out.println(fname + "\t\t" + lname);
			}
		}
//		rs.beforeFirst();
//		
//		while (rs.next()) {
//			String fname = rs.getString("emp_firstname");
//			// System.out.println(name);
//			String lname = rs.getString("emp_lastname");
//			if (fname.equals("Alfredo")) {
//				System.out.println(fname +"\t"+lname);
//			}
//		}
		rs.close();
		st.close();
		conn.close();
	}

	// retrieve all the job titles and store them in arraylist
	// and show it in console
	@Test
	public void def() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB Connection is successfull");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_job_title;");
		rs.next();
		ArrayList<String> titles = new ArrayList<>();
		while (rs.next()) {
			String title = rs.getString("job_title");
			titles.add(title);
		}
		System.out.println(titles + "\n");

		for (String t : titles) {
			System.out.println(t);
		}
		rs.close();
		st.close();
		conn.close();
	}
}
