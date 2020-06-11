package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class PersonalDetailsPageElements extends CommonMethods {

	// Gender Radio Buttons
	@FindBy(name = "personal[optGender]")
	public List<WebElement> nationality;
	
	@FindBy(xpath="//div[@id='profile-pic']//h1")
	public WebElement fullNameHeader;
	
	@FindBy(id="empPic")
	public WebElement photo;

	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logout;
	
	@FindBy(id="personal_txtEmployeeId")
	public WebElement id;
	
	@FindBy(id="personal_txtEmpFirstName")
	public WebElement firstName;
	@FindBy(id="personal_txtEmpMiddleName")
	public WebElement middleName;
	@FindBy(id="personal_txtEmpLastName")
	public WebElement lastName;
	
	@FindBy(xpath="//div[@id='pdMainContainer']//h1")
	public WebElement headerPersonalDetails;
	
	@FindBy(css="input#btnSave")
	public WebElement btnEdit;
	
	
	//Elements for modifying details feature
	@FindBy(id="personal_txtLicenNo")
	public WebElement licenseNO;
	@FindBy(xpath="//input[@id='personal_txtLicExpDate']")
	public WebElement licenseDateCalendar;
	@FindBy(xpath="//input[@id='personal_txtNICNo']")
	public WebElement ssnNumber;
	@FindBy(xpath="//input[@id='personal_txtSINNo']")
	public WebElement sinNumber;
	@FindBy(name = "personal[optGender]")
	public List<WebElement> sexRadio;
	@FindBy(xpath="//select[@id='personal_cmbMarital']")
	public WebElement maritalDD;
	@FindBy(id="personal_cmbNation")
	public WebElement nationalityDD;
	@FindBy(id="personal_txtEmpNickName")
	public WebElement nickName;
	@FindBy(xpath="//input[@id='personal_DOB']")
	public WebElement birthDayCalendar;
	@FindBy(id="personal_chkSmokeFlag")
	public WebElement smokerCheckBox;
	@FindBy(id="personal_txtMilitarySer")
	public WebElement militaryService;
	@FindBy(id="btnSave")
	public WebElement btnSave;
	
	
	// driver licence date DD Calendar
	@FindBy(xpath="//div[@class='ui-datepicker-title']//select[1]")
	public WebElement licenseMonthDD;
	@FindBy(xpath="//div[@class='ui-datepicker-title']//select[2]")
	public WebElement licenseYearDD;
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//tbody/tr/td")
	public List<WebElement> dayPicker;
	
	// driver birth day DD Calendar
	@FindBy(css="select.ui-datepicker-month")
	public WebElement birthMonthDD;
	@FindBy(css="select.ui-datepicker-year")
	public WebElement birthYearDD;
	@FindBy(css="table.ui-datepicker-calendar tbody tr td")
	public List<WebElement> birthDayPicker;
	
	
	
	
	public void pickDate(WebElement year, WebElement month, List<WebElement> days, 
			String y, String m, String d) {
		selectDDValue(year, y);
		selectDDValue(month, m);
		//List<WebElement> days = day;
		for(WebElement day: days) {
			if(day.getText().equalsIgnoreCase(d)) {
				day.click();
				break;
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Initializing all elements at once
	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public String getActualID() {
		return waitForVisibility(id).getAttribute("value");
	}
	
}
