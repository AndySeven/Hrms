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

public class DBUtils {

	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;
	private static ResultSetMetaData rsmd;
	private static List<Map<String, String>> list;

	/*
	 * this method will establish a connection with db
	 */
	public static void getConnection() {
		
		try {
			conn = DriverManager.getConnection(ConfigsReader.getValueOfProperty("dbURL"),
					ConfigsReader.getValueOfProperty("dbUsername"), ConfigsReader.getValueOfProperty("dbPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method will execute  the query and store the data into List of Maps
	 * by the given sql query
	 * @param sqlQuery
	 * @return <-- List<Map<String, String>>
	 */
	public static List<Map<String, String>> storeDataFromDB(String sqlQuery) {
		getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sqlQuery);
			ResultSetMetaData rsmd = rs.getMetaData();
			list = new ArrayList<>();
			Map<String, String> map;
			while (rs.next()) {
				map = new LinkedHashMap<>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					map.put(rsmd.getColumnName(i), rs.getObject(i).toString());
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 */
	public static void closeConnection() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
