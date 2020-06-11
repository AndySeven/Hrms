package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeLoginSteps extends CommonMethods {

	@When("user enters valid Admin credentials and clicks on login button")
	public void user_enters_valid_Admin_credentials_and_clicks_on_login_button() {
		login.loginAdmin();
	}

	@Then("Admin sees welcome message containing username")
	public void admin_sees_welcome_message_containing_username() {
		Assert.assertTrue("Admin username is NOT displayed", dash.welcome.getText().contains(login.adminUsername));
	}

	@When("user enters valid ESS credentials and clicks on login button")
	public void user_enters_valid_ESS_credentials_and_clicks_on_login_button() {
		login.login(login.essUsername, login.essPassword);
	}

	@Then("user sees welcome message containing username")
	public void user_sees_welcome_message_containing_username() {
		Assert.assertTrue("ESS username is NOT displayed", dash.welcome.getText().contains(login.essName));
	}
	@When("user enter valid {string} and {string} and clicks on login button")
	public void user_enter_valid_and_and_clicks_on_login_button(String Username, String Password) {
	    sendText(login.userName, Username);
	    sendText(login.password, Password);
	    click(login.loginBtn);
	
	}

	@Then("{string} is successfully logged in")
	public void is_successfully_logged_in(String FirstName) {
		wait(1);
		Assert.assertTrue("ESS username is NOT displayed", dash.welcome.getText().contains(FirstName));
	}
	
	@When("user enter invalid credentials and see error message")
	public void user_enter_invalid_credentials_and_see_error_message(DataTable dataTable) {
		String username;
		String password;
		List<Map<String, String>> log = dataTable.asMaps();
		System.out.println(log);
		for (Map<String, String> l : log) {
			if (l.get("username") == null) {
				username = "";
			} else {
				username = l.get("username").toString();
			}
			if (l.get("password") == null) {
				password = "";
			} else {
				password = l.get("password").toString();
			}

			String errMsg = l.get("errorMessage").toString();

			sendText(login.userName, username);
			sendText(login.password, password);
			click(login.loginBtn);
			String actualErrMsg = login.errorMsg.getText();
			takeScreenshot("InvalidLogin");
			Assert.assertEquals("Message is Not Matching", errMsg, actualErrMsg);
		}
	}
	
	@Then("user sees {string} is displayed")
	public void user_sees_is_displayed(String errorMsg) {
		String actualErrMsg = login.errorMsg.getText();
		Assert.assertEquals("Message is Not Matching", errorMsg, actualErrMsg);

		
	}

}
