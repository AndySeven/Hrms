package com.hrms.api.steps.practice;

public class HardcodedConstants {

	public static String updateCreatedEmpBody() {
		
		String updateBody = "{\n" + 
				"  \"employee_id\": \""+HardcodedExamples.empID+"\",\n" + 
				"  \"emp_firstname\": \"Arturo\",\n" + 
				"  \"emp_lastname\": \"Albertini\",\n" + 
				"  \"emp_middle_name\": \"Jr\",\n" + 
				"  \"emp_gender\": \"M\",\n" + 
				"  \"emp_birthday\": \"1966-03-28\",\n" + 
				"  \"emp_status\": \"Worker\",\n" + 
				"  \"emp_job_title\": \"QA Tester\"\n" + 
				"}";
		return updateBody;
	}
}
