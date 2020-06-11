package com.hrms.steps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommonMethods {
	static public String expextedID;
	public String expNameCombination;
	public List<String> act = new ArrayList<>();
	public List<String> exp = new ArrayList<>();

	@Given("user logged in into HRMS")
	public void user_logged_in_into_HRMS() {
		login.loginAdmin();
	}

	@Given("user navigates to Add Employee page")
	public void user_navigates_to_Add_Employee_page() {
		jsClick(dash.btnPim);
		jsClick(dash.btnAddEmp);
	}

	@When("user enters First Name {string} and Last Name {string}")
	public void user_enters_First_Name_and_Last_Name(String string, String string2) {
		sendText(addEmp.firstName, string);
		sendText(addEmp.lastName, string2);
	}

	@When("user sees ID")
	public void user_sees_ID() {
		expextedID = addEmp.getExpectedID();
	}

	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		click(addEmp.btnSave);
	}

	@Then("employee is added successfully")
	public void employee_is_added_successfully() {
		Assert.assertEquals("ID is NOT displayed", expextedID, pDetails.getActualID());
	}

	@When("user delete ID")
	public void user_delete_ID() {
		addEmp.clearID();
	}

	@Then("employee is added successfully no ID")
	public void employee_is_added_successfully_no_ID() {
		Assert.assertEquals("ID is presented", "", pDetails.getActualID());
	}

	@When("user clicks on create login checkbox ")
	public void user_clicks_on_create_login_checkbox() {
		clickSingleCheckBox(addEmp.singleCheckBox);
	}

	@When("user enters User Name {string} and password {string}")
	public void user_enters_User_Name_and_password(String string, String string2) {
		sendText(addEmp.nickName, string);
		sendText(addEmp.userPassword, string2);
		sendText(addEmp.rePassword, string2);
	}

	@When("user enters employee {string}, {string} and {string}")
	public void user_enters_employee_and(String FirstName, String MiddleName, String LastName) {
		sendText(addEmp.firstName, FirstName);
		sendText(addEmp.lastName, LastName);
		sendText(addEmp.middleName, MiddleName);

	}

	@Then("user sees employee {string}, {string} and {string} added successfully")
	public void user_sees_employee_and_added_successfully(String FirstName, String MiddleName, String LastName) {
		exp.add(FirstName);
		exp.add(MiddleName);
		exp.add(LastName);
		wait(2);
		act.add(pDetails.firstName.getAttribute("value"));
		act.add(pDetails.middleName.getAttribute("value"));
		act.add(pDetails.lastName.getAttribute("value"));

		Assert.assertEquals("User with first last middle names is NOT presented", exp, act);

	}

	@When("user enters employee details and click on save")
	public void user_enters_employee_details_and_click_on_save_data_works_fo_spec_one_step(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps();

		for (Map<String, String> map : data) {
			String firstName = map.get("FirstName");
			wait(2);
			sendText(waitForVisibility(addEmp.firstName), firstName);
			exp.add(firstName);

			String middleName = map.get("MiddleName");
			sendText(addEmp.middleName, middleName);
			exp.add(middleName);

			String lastName = map.get("LastName");
			sendText(addEmp.lastName, lastName);
			exp.add(lastName);

			click(addEmp.btnSave);
			wait(2);
			WebElement web = waitForPresenceOfElLocated(By.id("personal_txtEmpFirstName"));
			act.add(web.getAttribute("value"));
			act.add(pDetails.middleName.getAttribute("value"));
			act.add(pDetails.lastName.getAttribute("value"));

			Assert.assertEquals("User with first last middle names is NOT presented", exp, act);

			exp.clear();
			act.clear();

			jsClick(dash.btnAddEmp);

		}

	}

	@Then("employee is added successfully using dataTable")
	public void employee_is_added_successfully_using_dataTable() {
		System.out.println("Successfully added using DataTable");
	}

	@When("user enters employee data from {string} excel sheet")
	public void user_enters_employee_data_from_excel_sheet(String sheetName) {
		List<Map<String, String>> listMaps = ExcelUtility.excelIntoListOfMaps(Constants.TESTDATA_FILEPATH, sheetName);
		// HW
		List<String> expectedList = new ArrayList<>();
		for (Map<String, String> userData : listMaps) {
			Set<String> keys = userData.keySet();
			Iterator<String> it = keys.iterator();
			while (it.hasNext()) {
				String expName = userData.get(it.next());
				expectedList.add(expName);
				String expLast = userData.get(it.next());
				expectedList.add(expLast);
				String un = userData.get(it.next());
				String pwd = userData.get(it.next());
				String expID = addEmp.getExpectedID();
				expectedList.add(expID);
				wait(2);
				sendText(waitForVisibility(addEmp.firstName), expName);
				sendText(waitForVisibility(addEmp.lastName), expLast);
				clickSingleCheckBox(addEmp.singleCheckBox);
				sendText(waitForVisibility(addEmp.nickName), un);
				sendText(waitForVisibility(addEmp.userPassword), pwd);
				sendText(waitForVisibility(addEmp.rePassword), pwd);
				click(addEmp.btnSave);

				wait(2);
				List<String> actualList = new ArrayList<>();
				WebElement web = waitForPresenceOfElLocated(By.id("personal_txtEmpFirstName"));
				actualList.add(web.getAttribute("value"));
				actualList.add(pDetails.lastName.getAttribute("value"));
				actualList.add(pDetails.getActualID());

				Assert.assertEquals("Adding User by Excel is NOT Successfull", expectedList, actualList);

				expectedList.clear();
				actualList.clear();

				jsClick(dash.btnAddEmp);

			}

		}

	}

}
