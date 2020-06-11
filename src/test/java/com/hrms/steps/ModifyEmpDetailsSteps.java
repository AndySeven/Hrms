package com.hrms.steps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ModifyEmpDetailsSteps extends CommonMethods {
	List<String> listData = new ArrayList<>();
	List<Map<String, String>> empDetails;

	@When("user clicks on Employee id and")
	public void user_clicks_on_Employee_id_and() {
		List<WebElement> listRows = viewEmp.resultTable;

		boolean flag = false;
		while (!flag) {
			for (int i = 0; i < listRows.size(); i++) {
				if (listRows.get(i).getText().contains(AddEmployeeSteps.expextedID)) {
					driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr[" + (i + 1) + "]/td[2]")).click();
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
	
	@When("SERVICE STEP getting data from dataTable")
	public void service_STEP_getting_data_from_dataTable(DataTable dataTable) {
		listData = dataTable.asList();
	}

	@When("user enters Employee Details data")
	public void user_enters_Employee_Details_data() {

		Iterator<String> it = listData.iterator();
		while (it.hasNext()) {
			sendText(pDetails.licenseNO, it.next());
			String[] arr = it.next().split("-");
			List<String> data = new ArrayList<>();
			for (String a : arr) {
				String noLeadingZero = a.replaceAll("^0+(?!$)", "");
				data.add(noLeadingZero);
			}
			Iterator<String> iter = data.iterator();
			while (iter.hasNext()) {
				click(pDetails.licenseDateCalendar);
				pDetails.pickDate(pDetails.licenseYearDD, pDetails.licenseMonthDD, pDetails.dayPicker, iter.next(),
						iter.next(), iter.next());
			}
			sendText(pDetails.ssnNumber, it.next());
			sendText(pDetails.sinNumber, it.next());
			
			double d = Double.parseDouble(it.next());
			String removeDecimal = String.format("%.0f",d);
			clickRadioOrCheckBox(pDetails.sexRadio,removeDecimal);
			
			
			selectDDValue(pDetails.maritalDD, it.next());
			selectDDValue(pDetails.nationalityDD, it.next());
			String[] arr2 = it.next().split("-");
			List<String> data2 = new ArrayList<>();
			for (String a : arr2) {
				String noLeadingZero = a.replaceAll("^0+(?!$)", "");
				data2.add(noLeadingZero);
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

	@Then("checks all data modified {string}")
	public void checks_all_data_modified(String nationality) {
		List<WebElement> actualListWeb = driver.findElements(By.cssSelector(".editable"));
		actualListWeb.remove(0);
		actualListWeb.remove(0);
		actualListWeb.remove(0);
		actualListWeb.remove(0);
		actualListWeb.remove(0);
		actualListWeb.remove(4);
		actualListWeb.remove(4);
		actualListWeb.remove(5);
		actualListWeb.remove(7);

		List<String> actualList = new ArrayList<>();
		for (WebElement el : actualListWeb) {
			actualList.add(el.getAttribute("value"));
		}
		List<String> expectedList = new ArrayList<>(listData);
		expectedList.remove(4);
		expectedList.remove(5);
		Assert.assertEquals("Employee Details are NOT Madified", expectedList, actualList);

		// checking nationality is selected
		Select select = new Select(pDetails.nationalityDD);
		List<WebElement> opt = select.getOptions();
		for (WebElement o : opt) {
			if (o.getText().equals(nationality)) {
				Assert.assertTrue("Nationality is NOT Selected", o.isSelected());
			}
		}
		// checking is radio button properly selected
		List<WebElement> radio = pDetails.sexRadio;
		for (WebElement r : radio) {
			if (r.getAttribute("value").equals("1")) {
				Assert.assertTrue("Gender radio buttun is NOT Selected", r.isSelected());
			}
		}

		// checking is Smoker check Box selected
		Assert.assertTrue("Smoker check box is NOT Selected", pDetails.smokerCheckBox.isSelected());

	}

	@When("SERVICE STEP geting data from excel sheet {string}")
	public void service_STEP_geting_data_from_excel_sheet(String sheetName) {
		List<Map<String, String>> empDetails = ExcelUtility.excelIntoListOfMaps(Constants.TESTDATA_FILEPATH, sheetName);
		//List<String>listData = new ArrayList<>();
		for(Map<String, String> data: empDetails){
			Collection<String> values = data.values();
			for(String value: values) {
				listData.add(value);
			}
			
		}
	}

}
