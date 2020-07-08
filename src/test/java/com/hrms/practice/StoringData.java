package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class StoringData {

	String user = "syntax_hrm";
	String password = "syntaxhrm123";
	// jdbc:drivertype:hostname:port/db name
	String url = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void storingInMap() throws SQLException {
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select id, name, country_code from ohrm_location;");
		ResultSetMetaData rsmd = rs.getMetaData();
		List<Map<String, String>> list = new ArrayList<>();

		while (rs.next()) {
			Map<String, String> map = new LinkedHashMap<>();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				String key = rsmd.getColumnName(i);
				String value = rs.getObject(i).toString();
				map.put(key, value);
			}
			list.add(map);
		}
		
		
		for(Map<String, String> m: list) {
			Set<Entry<String, String>> entry = m.entrySet();
			System.out.println(entry+"\n");
		}
		
		
		System.out.println("----------------------------------------------------------");
		

		ResultSet rs2 = st.executeQuery("select id, name, country_code from ohrm_location;");
		List<Map<String, String>> list2 = new ArrayList<>();
		Map<String, String> map2 = null;
		while (rs2.next()) {
			
			map2 = new LinkedHashMap<>();
			map2.put("id", rs2.getString("id"));
			map2.put("name", rs2.getString("name"));
			map2.put("country_code", rs2.getString("country_code"));
			list2.add(map2);
		}
		
		for(Map<String, String> m: list2) {
			System.out.println(m+"\n");
		}
	}
}
