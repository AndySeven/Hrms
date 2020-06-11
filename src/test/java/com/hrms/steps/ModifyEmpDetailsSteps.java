package com.hrms.steps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ModifyEmpDetailsSteps extends CommonMethods {
	List<String> listData;
	@When("user clicks on Employee id and")
	public void user_clicks_on_Employee_id_and() {
		List<WebElement> listRows = viewEmp.resultTable;
	
		boolean flag = false;
		while (!flag) {
			for (int i = 0; i < listRows.size(); i++) {
				if (listRows.get(i).getText().contains(AddEmployeeSteps.expextedID)) {
					driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr[" + (i+1) + "]/td[2]")).click();
					flag = true;
					break;
				}
			}
			if (!flag) {
				click(viewEmp.nextTablePageBtn);
			}
		}
	}

	@When("user lands on Personal Details page")
	public void user_lands_on_Personal_Details_page() {
		Assert.assertEquals("User is NOT on the Personal Details Page", "Personal Details",
				
				waitForVisibility(pDetails.headerPersonalDetails).getText());
	}

	@When("user clicks on button edit")
	public void user_clicks_on_button_edit() {
		click(pDetails.btnEdit);
	}

	@When("user enters Employee Details data from dataTable")
	public void user_enters_Employee_Details_data_from_dataTable(DataTable dataTable) {
		listData = dataTable.asList();
		Iterator<String> it = listData.iterator();
		while (it.hasNext()) {
			sendText(pDetails.licenseNO, it.next());
			String[] arr = it.next().split("-");
			List<String> data = new ArrayList<>();
			for (String a : arr) {
				data.add(a);
			}
			Iterator<String> iter = data.iterator();
			while (iter.hasNext()) {
				click(pDetails.licenseDateCalendar);
				pDetails.pickDate(pDetails.licenseYearDD, pDetails.licenseMonthDD, pDetails.dayPicker, iter.next(),
						iter.next(), iter.next());
			}
			sendText(pDetails.ssnNumber, it.next());
			sendText(pDetails.sinNumber, it.next());
			clickRadioOrCheckBox(pDetails.sexRadio, it.next());
			selectDDValue(pDetails.maritalDD, it.next());
			selectDDValue(pDetails.nationalityDD, it.next());
			String[] arr2 = it.next().split("-");
			List<String> data2 = new ArrayList<>();
			for (String a : arr2) {
				data2.add(a);
			}
			Iterator<String> iterat = data2.iterator();
			while (iterat.hasNext()) {
				click(pDetails.birthDayCalendar);
				pDetails.pickDate(pDetails.birthYearDD, pDetails.birthMonthDD, pDetails.birthDayPicker, iterat.next(),
						iterat.next(), iterat.next());
			}
			sendText(pDetails.nickName, it.next());
			sendText(pDetails.militaryService, it.next());
		}
	}

	@When("user checks smoker singlr check box")
	public void user_checks_smoker_singlr_check_box() {
		clickSingleCheckBox(pDetails.smokerCheckBox);
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
		click(pDetails.btnSave);
	}

	@Then("checks all data modified")
	public void checks_all_data_modified() {
		List<WebElement> actualListWeb =  driver.findElements(By.cssSelector(".editable"));
//		for(int i=0; i<actualListWeb.size(); i++) {
//			String value = actualListWeb.get(i).getAttribute("value");
//			if(value.equals("") || value.equals("1") || value.equals("Alfredo") || value.equals("Pitbullterierro") || value.equals(AddEmployeeSteps.expextedID) || value.equals("2") ) {
//				actualListWeb.remove(i);
//			}
		
		actualListWeb.remove(0);
		actualListWeb.remove(0);
		actualListWeb.remove(0);
		actualListWeb.remove(0);
		actualListWeb.remove(0);
		actualListWeb.remove(4);
		actualListWeb.remove(4);
		actualListWeb.remove(5);
		actualListWeb.remove(7);
		

		
		List<String>actualList = new ArrayList<>();
		for(WebElement el: actualListWeb) {
			actualList.add(el.getAttribute("value"));
		}
		List<String>expectedList = new ArrayList<>(listData);
		expectedList.remove(4);
		expectedList.remove(5);
		System.out.println("actual --> "+actualList);
		System.out.println(actualList.size());
		System.out.println("expected --> "+expectedList);
		Assert.assertEquals("Employee Details are NOT Madified", expectedList, actualList);
		
		Select select = new Select(driver.findElement(By.id("personal_cmbNation")));
		System.out.println("-------------------------------------");
		System.out.println(select.getAllSelectedOptions());
		System.out.println("-------------------------------------");
	}

	@When("user enters Employee Details data from {string}")
	public void user_enters_Employee_Details_data_from(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
