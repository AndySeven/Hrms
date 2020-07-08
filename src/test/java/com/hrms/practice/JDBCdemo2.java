package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class JDBCdemo2 {

	String dbName = "syntaxhrm_mysql";
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbPort = "3306";
	String dbIP = "166.62.36.207";

	// jdbc:mysql://hostname:port/db_name
	String dbURL = "jdbc:mysql://" + dbIP + ":" + dbPort + "/" + dbName;

	@Test
	public void db() throws SQLException {

		Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		System.out.println("Connection sucessfull");

		// Get info about DB
		System.out.println("----------Data BAse Info-----------------");
		DatabaseMetaData dbmt = con.getMetaData();
		System.out.println("drivre name -->" + dbmt.getDriverName());
		System.out.println("drivre version -->" + dbmt.getDriverVersion());
		System.out.println("catalog term -->" + dbmt.getCatalogTerm());
		System.out.println("catalog separator -->" + dbmt.getCatalogSeparator());
		System.out.println("product name -->" + dbmt.getDatabaseProductName());
		System.out.println("product version -->" + dbmt.getDatabaseProductVersion());

		// creating Statement obj to using create Statement method
		Statement st = con.createStatement();
		// using statement obj executing Query
		ResultSet rs = st.executeQuery("select employee_id, emp_firstname, emp_lastname from hs_hr_employees;");

		ResultSetMetaData rsmd = rs.getMetaData();
		// Getting info about result table
//		String key1 = rsmd.getColumnName(4);
//		String key2 = rsmd.getColumnName(3);
//		System.out.println(rsmd.getColumnType(3));
//		System.out.println(rsmd.getColumnType(4));
//		System.out.println(rsmd.getColumnTypeName(3));
//		System.out.println(rsmd.getColumnTypeName(4));
//		System.out.println(rsmd.getTableName(3));
//		System.out.println(rsmd.getTableName(4));

		System.out.println("-----------------Getting All colomn namees and storing in Array List--------------");

		ArrayList<String> list = new ArrayList<>();

		for (int i = 1; i <=rsmd.getColumnCount(); i++) {
			list.add(rsmd.getColumnName(i));
		}

		for (String l : list) {
			 System.out.println("name of colounm --> " +l);
		}

		System.out.println("------------store in map table data--------------");
		Set<Map<String, String>> listMap = new LinkedHashSet<>();

		HashMap<String, String> map = null;
		while (rs.next()) {
			map = new HashMap<>();
			for (int j = 1; j <= rsmd.getColumnCount(); j++) {
				
				// System.out.print(rs.getString(j)+" ");
				String key = rsmd.getColumnName(j);
				String value = rs.getString(j);
				map.put(key, value);

			}
			// System.out.println(map);
			listMap.add(map);

		}
		//System.out.println(listMap);
		for (Map<String, String> m : listMap) {
			System.out.println(m);
		}

		rs.close();
		st.close();
		con.close();
	}

}
