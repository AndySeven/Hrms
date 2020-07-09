package com.hrms.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class ViewEmployeePageElements extends CommonMethods{

	@FindBy(id = "empsearch_employee_name_empName")
	public WebElement empName;
	@FindBy(id = "empsearch_id")
	public WebElement EmpID;
	@FindBy(id = "searchBtn")
	public WebElement searchBtn;
	@FindBy(xpath = "//table[@id='resultTable']//tbody/tr")
	public List<WebElement> resultTable;
	@FindBy(xpath = "//table[@id='resultTable']")
	public WebElement empTable;
	@FindBy(xpath = "//table[@id='resultTable']//tbody/tr/td[3]")
	public List<WebElement> firstNamesTable;
	@FindBy(xpath = "//table[@id='resultTable']//tbody/tr/td[4]")
	public List<WebElement> lastNamesTable;

	@FindBy(css = "li.next a")
	public WebElement nextTablePageBtn;

	public ViewEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	public boolean isTableDisplayed() {
		return empTable.isDisplayed();
	}

//	public String firstNameFromTable(List<WebElement> resultTable, String id) {
//
//		for (int i = 0; i < resultTable.size(); i++) {
//			String row = resultTable.get(i).getText();
//			if (row.contains(id)) {
//
//				return true;
//			}
//
//		}
//		return false;
//	}

	public List<Map<String, String>> getFirstNamesFromTable() {
		List<Map<String, String>> listMaps = new ArrayList<>();
		Map<String, String> map = null;
		for (WebElement row : firstNamesTable) {
			map = new LinkedHashMap<>();
			String name = row.getText();
			map.put("emp_firstname", name);
			listMaps.add(map);
		}
		return listMaps;
	}
	
	public List<Map<String, String>> getLastNameFromTable() {
		return getlistOfMapsFromTableOneColumn("emp_lastname", lastNamesTable);
	}
	
}
