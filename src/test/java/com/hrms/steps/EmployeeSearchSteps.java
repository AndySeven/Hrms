package com.hrms.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.hrms.practice.GlobalVariables;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.DBUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchSteps extends CommonMethods {
	public  static List<Map<String, String>> uiNames;
	public  static List<Map<String, String>> uiLastNames;
	
	@Given("user is logged in with valid admin credentials")
	public void user_is_logged_in_with_valid_admin_credentials() {
		login.login(ConfigsReader.getValueOfProperty("username"), ConfigsReader.getValueOfProperty("password"));
	}

	@Given("user navigate to employee list page")
	public void user_navigate_to_employee_list_page() {
		jsClick(dash.pim);
		jsClick(dash.empList);
	}

	@When("user enters valid employee id {string}")
	public void user_enters_valid_employee_id(String empID) {
		GlobalVariables.empID = empID;
		sendText(viewEmp.EmpID, empID);
	}

	@When("click on search button")
	public void click_on_search_button() {
		jsClick(viewEmp.searchBtn);
	}

	@Then("user see employee information is displayed {string}")
	public void user_see_employee_information_is_displayed(String empID) {
		wait(2);
		assertTrue("emp info is NOT displayed", presenseTextInTable(empID, viewEmp.resultTable));
		wait(2);
	}

	@When("user enters valid employee name {string}")
	public void user_enters_valid_employee_name(String name) {
		wait(2);
		sendText(viewEmp.empName, name);
		viewEmp.empName.sendKeys(Keys.RETURN);
	}
	@When("user enters valid employee id")
	public void user_enters_valid_employee_id() {
		sendText(viewEmp.EmpID, AddEmployeeSteps.expextedID);
	}
	
	@Then("verify table is displayed")
	public void verify_table_is_displayed() {
		Assert.assertEquals(true, viewEmp.isTableDisplayed());
	}
	
	@Then("get first name from table")
	public void get_first_name_from_table() {
		uiNames = viewEmp.getFirstNamesFromTable();
		System.out.println(uiNames);
	}

	@Then("validate first name from ui against db")
	public void validate_first_name_from_ui_against_db() {
		Assert.assertEquals("NO GOOD", uiNames, DBsteps.dbNames);
	
	}
	
	
	@When("user gets {string} from the table")
	public void user_gets_from_the_table(String columnName) {
		uiLastNames = viewEmp.getLastNameFromTable(columnName);
	}
	
	@Then("user validates data against db")
	public void user_validates_data_against_db() {
		System.out.println(uiLastNames);
		System.out.println(DBsteps.dbNames);
	   Assert.assertEquals("data doesn't match", uiLastNames, DBsteps.dbNames);
		
	}

}
