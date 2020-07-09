package com.hrms.steps;

import java.util.List;
import java.util.Map;

import com.hrms.utils.DBUtils;
import com.hrms.utils.DBUtils2;

import io.cucumber.java.en.When;

public class DBsteps {
	public  static List<Map<String, String>> dbNames;



	@When("get first name from DB")
	public void get_first_name_from_DB() {
		
		String sqlQuery = "select emp_firstname from hs_hr_employees where employee_id = 14260;"; 
		dbNames = DBUtils.storeDataFromDB(sqlQuery);
		System.out.println(dbNames);
	}
	
	@When("user gets data from db {string}")
	public void user_gets_data_from_db(String query) {
	   String sqlQuery = query+AddEmployeeSteps.expextedID;
	   dbNames = DBUtils2.getDBData(sqlQuery);
	   
	}



}
