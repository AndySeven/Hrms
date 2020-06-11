package com.hrms.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Keys;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchSteps extends CommonMethods {


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
		sendText(viewEmp.EmpID, empID);
	}

	@When("click on search button")
	public void click_on_search_button() {
		jsClick(viewEmp.searchBtn);
	}

	@Then("user see employee information is displayed {string}")
	public void user_see_employee_information_is_displayed(String empID) {
		wait(1);
		assertTrue("emp info is NOT displayed", presenseTextInTable(empID, viewEmp.resultTable));
		wait(1);
	}

	@When("user enters valid employee name {string}")
	public void user_enters_valid_employee_name(String name) {
		wait(2);
		sendText(viewEmp.empName, name);
		viewEmp.empName.sendKeys(Keys.RETURN);
	}

}
