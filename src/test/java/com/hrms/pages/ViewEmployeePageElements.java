package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class ViewEmployeePageElements {

	@FindBy(id="empsearch_employee_name_empName")
	public WebElement empName;
	@FindBy(id="empsearch_id")
	public WebElement EmpID;
	@FindBy(id="searchBtn")
	public WebElement searchBtn;
	@FindBy(xpath="//table[@id='resultTable']//tbody/tr")
	public List<WebElement> resultTable;
	
	@FindBy(css="li.next a")
	public WebElement nextTablePageBtn;
	
	
	
	
	public ViewEmployeePageElements(){
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
	
}
