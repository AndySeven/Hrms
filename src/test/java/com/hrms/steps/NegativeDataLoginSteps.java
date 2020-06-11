package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeDataLoginSteps extends CommonMethods{

	@When("user enters valid username and invalid password")
	public void user_enters_valid_username_and_invalid_password() {
		login.login(login.adminUsername, "qwqwqwqw");
	}

	@Then("user see “Invalid credentials” error message")
	public void user_see_Invalid_credentials_error_message() {
		Assert.assertTrue("Message Invalid credentials is NOT Displayed", login.errorMsg.getText().contains("Invalid credentials"));
	}

	@When("user enters valid username and empty password")
	public void user_enters_valid_username_and_empty_password() {
		login.login(login.adminUsername, "");
	}

	@Then("user see “Password can not be empty” error message")
	public void user_see_Password_can_not_be_empty_error_message() {
		Assert.assertTrue("Message Invalid credentials is NOT Displayed", login.errorMsg.getText().contains("Password cannot be empty"));
	}
	
	@When("user leaves empty username and valid password")
	public void user_leaves_empty_username_and_valid_password() {
		login.login("", login.adminPassword);
	}

	@Then("user see “Username can not be empty” error message")
	public void user_see_Username_can_not_be_empty_error_message() {
		Assert.assertTrue("Message Invalid credentials is NOT Displayed", login.errorMsg.getText().contains("Username cannot be empty"));
	}

	
}
