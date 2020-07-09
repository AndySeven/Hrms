package com.hrms.utils;

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

public class DBUtils2 {
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	private static ResultSetMetaData rsmd;
	static String url = ConfigsReader.getValueOfProperty("dbURL");
	static String user = ConfigsReader.getValueOfProperty("dbUsername");
	static String password = ConfigsReader.getValueOfProperty("dbPassword");
	static List<Map<String, String>> list = new ArrayList<>();

	public static void getConnection() {
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Map<String, String>> getDBData(String sqlQuery) {
			getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sqlQuery);
			rsmd = rs.getMetaData();
			Map<String, String> map;
			while (rs.next()) {
				map = new LinkedHashMap<>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String key = rsmd.getColumnName(i);
					String value = rs.getObject(i).toString();
					map.put(key, value);
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void closeConnection() {
		try {
			if (con != null) {
				con.close();
			}
			if (st != null) {
				st.close();
			}
			if (rs != null) {

				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

}
