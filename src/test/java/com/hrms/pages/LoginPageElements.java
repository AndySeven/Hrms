package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class LoginPageElements extends CommonMethods{

	@FindBy(id="txtUsername")
	public WebElement userName;
	
	@FindBy(name="txtPassword")
	public WebElement password;

	@FindBy(css="input#btnLogin")
	public WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='divLogo']/img")
	public WebElement logo;
	
	@FindBy(id="spanMessage")
	public WebElement errorMsg;
	
	
	
	public LoginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
	
	// if we would be keping elements as private
	// then we will need to create public getters
	// and setters so we can access page elements from test classes
	
	// setter
	public void sendUsername(String uid) {
		sendText(userName, uid);
	}
	// getter
	public WebElement getUserName() {
		return userName;
	}
	
	public void login(String uid, String pwd) {
		sendText(userName, uid);
		sendText(password, pwd);
		click(loginBtn);
	}
	public void loginAdmin() {
		sendText(userName, ConfigsReader.getValueOfProperty("username"));
		sendText(password, ConfigsReader.getValueOfProperty("password"));
		click(loginBtn);
	}
	
	public String adminUsername = ConfigsReader.getValueOfProperty("username");
	public String adminPassword = ConfigsReader.getValueOfProperty("password");
	
	public String essUsername = ExcelUtility.getExcelCellValue(Constants.TESTDATA_FILEPATH, "Employees", 1, 2);
	public String essPassword = ExcelUtility.getExcelCellValue(Constants.TESTDATA_FILEPATH, "Employees", 1, 3);
	public String essName = ExcelUtility.getExcelCellValue(Constants.TESTDATA_FILEPATH, "Employees", 1, 0);
	
}
