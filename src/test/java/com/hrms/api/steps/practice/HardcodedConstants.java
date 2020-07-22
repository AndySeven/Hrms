package com.hrms.api.steps.practice;

public class HardcodedConstants {
	
	public static String firstNameForCreate = "Jack";
	public static String middleNameForCreate = "Apple";
	public static String lastNameForCreate = "Cook";
	public static String birthdayForCreate = "1998-02-03";
	public static String genderForCreate = "M";
	public static String jobTitleForCreate = "CEO";
	public static String statusForCreate = "Freelance";
	
	public static String firstNameForUpdate = "Arturo";
	public static String middleNameForUpdate = "Orange";
	
	public static String firstNameForPartialUpdate = "Willy";
	public static String jobTitleForPartialUpdate = "Developer";
	
	public static String generateTokenBody(String email, String password) {
		
		
		String genToken = "{\n" + 
				"  \"email\": \""+email+"\",\n" + 
				"  \"password\": \""+password+"\"\n" + 
				"}";
		return genToken;
	}
	
	public static String createUserBody(String userName, String password, String email) {
		
		String createUser = "{\n" + 
				"  \"name\": \""+userName+"\",\n" + 
				"  \"email\": \""+email+"\",\n" + 
				"  \"password\": \""+password+"\"\n" + 
				"}";
		return createUser;
	}

public static String createdEmpBody(String empID) {
		
		String updateBody = "{\n" + "  \"employee_id\": \"" + empID + "\",\n"
				+ "  \"emp_firstname\": \""+firstNameForCreate+"\",\n" + "  \"emp_lastname\": \""+lastNameForCreate+"\",\n"
				+ "  \"emp_middle_name\": \""+middleNameForCreate+"\",\n" + "  \"emp_gender\": \""+genderForCreate+"\",\n"
				+ "  \"emp_birthday\": \""+birthdayForCreate+"\",\n" + "  \"emp_status\": \""+statusForCreate+"\",\n"
				+ "  \"emp_job_title\": \""+jobTitleForCreate+"\"\n" + "}";
		return updateBody;
	}
	
	
	
	public static String updateCreatedEmpBody(String empID) {
		
		String updateBody = "{\n" + "  \"employee_id\": \"" + empID + "\",\n"
				+ "  \"emp_firstname\": \"Arturo\",\n" + "  \"emp_lastname\": \"Albertini\",\n"
				+ "  \"emp_middle_name\": \"Jr\",\n" + "  \"emp_gender\": \"M\",\n"
				+ "  \"emp_birthday\": \"1966-03-28\",\n" + "  \"emp_status\": \"Worker\",\n"
				+ "  \"emp_job_title\": \"QA Tester\"\n" + "}";
		return updateBody;
	}
	
public static String partuallyUpdateEmpBody(String empID) {
		
		String partUpdateBody = "{\n" + 
				"  \"employee_id\": \""+empID+"\",\n" + 
				"  \"emp_firstname\": \"Bilbo\",\n" + 
//				"  \"emp_lastname\": \"string\",\n" + 
//				"  \"emp_middle_name\": \"string\",\n" + 
//				"  \"emp_gender\": \"Enter M for male or F for female\",\n" + 
//				"  \"emp_birthday\": \"2020-07-19\",\n" + 
//				"  \"emp_status\": \"string\",\n" + 
				"  \"emp_job_title\": \"Developer\"\n" + 
				"}";
		return partUpdateBody;
	}

	static String getAlphaNumericString(int n) {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}
}
