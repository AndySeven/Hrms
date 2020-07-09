package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class EnhancedDataStoring {
	String user = "syntax_hrm";
	String password = "syntaxhrm123";
	// jdbc:drivertype:hostname:port/db name
	String url = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	String query = "select * from ohrm_language;";

	@Test
	public void storeData() throws SQLException {
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		ResultSetMetaData rsmt = rs.getMetaData();

		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map;
		while (rs.next()) {
			map = new LinkedHashMap<>();
			for (int i = 1; i <= rsmt.getColumnCount(); i++) {
				map.put(rsmt.getColumnName(i), rs.getObject(i).toString());
			}
			list.add(map);
		}
		
		
		for (Map<String, String> m : list) {
			System.out.println(m.values());
			System.out.println(m.keySet());
			System.out.println(m.entrySet());
			System.out.println();
		}
	}

}
