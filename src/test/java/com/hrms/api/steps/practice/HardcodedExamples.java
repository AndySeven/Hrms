package com.hrms.api.steps.practice;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// manually import for given() method
/*
 * Rest Assured static packages
 */
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 * import JUnit packages
 */
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/*
 * 
 */
import org.junit.*;
//import org.apache.hc.core5.http.ContentType;

/**
 * Rest Assured
 * 
 * given - prepare your request 
 * when - you are making the call to the endpoint
 * then - validating
 * 
 * @param args
 *
 */
// will execute @Test annotation in ascending alphabetical order
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class HardcodedExamples {

	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	static String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9."
			+ "eyJpYXQiOjE1OTUxNjk2MjEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMjgyMSwidXNlcklkIjoiNjY1In0.1KH5Uupr-JWWndslLCz9wKsw12_jr5AX7R3SkNMMw50";
	static String empID;
	static String firstNameCreated;
	static String middleNameCreated;
	static String lastNameCreated;
	static String birtdayCreated;
	static String genderCreated;
	static String jobTitleCreated;
	static String statusCreated;
	
	
	static String idUpdated;
	static String firstNameUpdated;
	static String middleNameUpdated;
	static String lastNameUpdated;
	static String birthdayUpdated;
	static String genderUpdated;
	static String jobTitleUpdated;
	static String statusUpdated;
	
	static String idPath = "employee[0].employee_id";
	static String firstNamePath = "employee[0].emp_firstname";
	static String middleNamePath = "employee[0].emp_middle_name";
	static String lastNamePath = "employee[0].emp_lastname";
	static String birtdayPath = "employee[0].emp_birthday";
	static String genderPath = "employee[0].emp_gender";
	static String jobTitlePath = "employee[0].emp_job_title";
	static String statusPath = "employee[0].emp_status";
	
	
	
	
	static String contType = "Content-Type";
	static String appJSON = "application/json";
	static String auth = "Authorization";
	
	static String putEndpoint = "/updateEmployee.php";
	static String getAllEmployeesEndpoint = "/getAllEmployees.php";
	static String getOneEmployee = "/getOneEmployee.php";
	static String postCreateEmployee = "/createEmployee.php";
	
	public void sampleTestNotes() {
		/*
		 * BaseURI for all calls
		 */
		String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
		
		/*
		 * JWT required for all calls - expires every 12 hours
		 */
		String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUwOTQ4NjUsIml"
				+ "zcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTEzODA2NSwidXNlcklkIjoiNjY1In0.c1zl40PMslsw5Ttt_9IB82FCaL6ERQmRakrnGq_lsvU";
		/*
		 * preparing /getOneEmployee.php request. returns request specification
		 * log().all() - 
		 */
		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json").
				header("Authorization", token).queryParam("employee_id", "16531A").log().all();
		
		/*
		 * Storing response
		 */
		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");
		
		/*
		 * Two ways to print result
		 */
		// prettyPrint() JSON obj to String and prints no need SOP
		getOneEmployeeResponse.prettyPrint();
		
		// String response = getOneEmployeeResponse.body().asString();
		// System.out.println(response);
		
		/*
		 * Verifying response status code is 200
		 */
		getOneEmployeeResponse.then().assertThat().statusCode(200);
	}
	
	@Test
	public void aPOSTcreateEmployee() {
		System.out.println("------------------------------------------POST Create Employee-------------------------------------------");
		/*
		 * Preparing request for /createEmployee.php
		 */
		RequestSpecification createEmployeeRequest = given()
				.header("Content-Type", "application/json")
				.header("Authorization", token)
				.body("{\n" + 
				"  \"emp_firstname\": \"Henry\",\n" + 
				"  \"emp_lastname\": \"Hippo\",\n" + 
				"  \"emp_middle_name\": \"Orange\",\n" + 
				"  \"emp_gender\": \"M\",\n" + 
				"  \"emp_birthday\": \"2000-03-28\",\n" + 
				"  \"emp_status\": \"Worker\",\n" + 
				"  \"emp_job_title\": \"Developer\"\n" + 
				"}")
				.log().all();
		/*
		 * Storing response into ref variable createEmployeeResponse
		 */
		Response createEmployeeResponse = createEmployeeRequest
				.when()
				.post("/createEmployee.php");
		
		/*
		 * Printing response using prettyPrint() method
		 */
		createEmployeeResponse.prettyPrint();
		createEmployeeResponse
		.then()
		.assertThat()
		.statusCode(201);
		
		//createEmployeeResponse.then().assertThat().body("emp_status", equalTo("Ali"));
		
		/*
		 * jsonPath() to view response body which lets us get employee_id 
		 */
		empID = createEmployeeResponse.body().jsonPath().getString("Employee[0].employee_id");
		firstNameCreated = createEmployeeResponse.body().jsonPath().getString("Employee[0].emp_firstname");
		middleNameCreated = createEmployeeResponse.body().jsonPath().getString("Employee[0].emp_middle_name");
		lastNameCreated = createEmployeeResponse.body().jsonPath().getString("Employee[0].emp_lastname");
		birtdayCreated = createEmployeeResponse.body().jsonPath().getString("Employee[0].emp_birthday");
		genderCreated = createEmployeeResponse.body().jsonPath().getString("Employee[0].emp_gender");
		jobTitleCreated = createEmployeeResponse.body().jsonPath().getString("Employee[0].emp_job_title");
		statusCreated = createEmployeeResponse.body().jsonPath().getString("Employee[0].emp_status");
		
		
		/*
		 * Verifying message using equalTo() manually import static package
		 * import static org.hamcrest.Matchers.*;
		 */
		createEmployeeResponse
		.then()
		.assertThat()
		.body("Message", equalTo("Entry Created"));
		
		/*
		 * Verifying response body contains actual first name of employee
		 */
		createEmployeeResponse
		.then()
		.assertThat()
		.body("Employee[0].emp_firstname", equalTo("Henry"));
		
		/*
		 * Don't use assert to check header of response
		 */
		createEmployeeResponse
		.then()
		.header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
		
		/*
		 * Verifying the content-type in response header
		 */
		createEmployeeResponse
		.then()
		.assertThat()
		.header("Content-Type", "application/json");
		//createEmployeeResponse.then().header("Content-Length", "385");
	}
	
	@Test
	public void bGETcreatedEmployee() {
		System.out.println("------------------------------------------GET Created Employee-------------------------------------------");
		
		/*
		 * Preparing request for /getOneEmployee.php
		 * Using log().all() to see all info deing sent with request
		 */
		RequestSpecification getCreatedEmployeeRequest = given()
				.header(contType, appJSON)
				.header(auth, token)
				.queryParams("employee_id", empID)
				.log().all();
		
		/*
		 * Making call to retrieve created employee
		 */
		
		Response getCreatedEmployeeResponse = getCreatedEmployeeRequest
				.when()
				.get("/getOneEmployee.php");
		
		
		String response = getCreatedEmployeeResponse.prettyPrint();
		
		/*
		 * Getting actual employee id from response body
		 */
		String empIDActual = getCreatedEmployeeResponse
				.body()
				.jsonPath()
				.getString("employee[0].employee_id");
		
		boolean verifyEmployeeIdMatch = empID.equalsIgnoreCase(empIDActual);
		System.out.println("Employee ID is matced --> "+verifyEmployeeIdMatch);
		Assert.assertTrue(verifyEmployeeIdMatch);
		
		getCreatedEmployeeResponse.then().assertThat().statusCode(200);
		
		/*
		 * Getting response body values
		 */
		JsonPath js = new JsonPath(response);
	
		String empIDActual2 = js.getString("employee[0].employee_id");
		
		String FirstNameActual = js.getString("employee[0].emp_firstname");
		
		String MiddleNameActual = js.getString("employee[0].emp_middle_name");
	
		String LastNameActual = js.getString("employee[0].emp_lastname");
		
		String BirthDayActual = js.getString("employee[0].emp_birthday");
		
		String GenderActual = js.getString("employee[0].emp_gender");
		
		String JibTitleActual = js.getString("employee[0].emp_job_title");
		
		String StatusActual = js.getString("employee[0].emp_status");
		
		/*
		 * Verifying employee ID's match --> contentEquals
		 */
		Assert.assertTrue(empIDActual2.contentEquals(empID));
		//or
		Assert.assertEquals(empID, empIDActual2);
		/*Verifying expected first name  matches actual first name */
		Assert.assertEquals(firstNameCreated, FirstNameActual);
		/*Verifying expected middle name matches actual middle name */
		Assert.assertEquals(middleNameCreated, MiddleNameActual);
		/*Verifying expected last name matches actual last name */
		Assert.assertEquals(lastNameCreated, LastNameActual);
		/*Verifying expected birthday matches actual birthday */
		Assert.assertEquals(birtdayCreated, BirthDayActual);
		/*Verifying expected gender matches actual gender */
		Assert.assertEquals(genderCreated, GenderActual);
		/*Verifying expected job itle matches actual job title */
		Assert.assertEquals(jobTitleCreated, JibTitleActual);
		/*Verifying expected status matches actual status */
		Assert.assertEquals(statusCreated, StatusActual);
		System.out.println("Employee ID is matced--> "+empIDActual2.contentEquals(empID));
	}
	
	@Test
	public void cGETallEmployees() {
		System.out.println("------------------------------------------GET All Employees-------------------------------------------");
		
		/*
		 * Preparing /getAllEmployees.php request
		 */
		RequestSpecification getAllEmploeesRequest = given()
				.header(contType,appJSON)
				.header(auth,token)
				.log()
				.all();
		
		/*
		 * performing /getAllEmployees.php request and storing in reference variable Rsponse
		 */
		Response getAllEmployeesResponse = getAllEmploeesRequest.when().get(getAllEmployeesEndpoint);
		
		/*
		 * printing all employees
		 */
		//String response = getAllEmployeesResponse.prettyPrint();
		
		String response = getAllEmployeesResponse.body().asString();
		
		
		/*
		 * Will pas but incoreect
		 */
		//Assert.assertTrue(response.contains(empID));
		
		/*
		 * DO research
		 */
		//Assert.assertTrue(response.matches(empID));
		
		JsonPath jp = new JsonPath(response);
		
		/*
		 * Getting a size of list
		 */
		int sizeOfList = jp.getInt("Employees.size()");
		System.out.println("Size of List Employees -->"+sizeOfList);
		
		/*
		 * Print all employees ID
		 */
//		for (int i = 0; i < sizeOfList; i++) {
//			String id = jp.getString("Employees["+i+"].employee_id");
//			if(empID.contentEquals(id)) {
//				System.out.println("ID is presented -->"+id);
//				String firstName = jp.getString("Employees["+i+"].emp_firstname");
//				System.out.println(firstName);
//				break;
//			}
//		}
		getAllEmployeesResponse.then().assertThat().statusCode(200);
	}
	
	@Test
	public void dPUTupdateEmployee() {
		System.out.println("------------------------------------------PUT Update Employee-------------------------------------------");
	
		/*
		 * Preparing request for updateEmployee.php
		 * return RequestSpecification
		 */
		RequestSpecification updateEmployeeRequest = given()
				.header(contType,appJSON)
				.header(auth,token)
				.body(HardcodedConstants.updateCreatedEmpBody())
				.log().all();
		/*
		 * Implementing request, storing into ref var Response type
		 */
		Response updateEmployeeResponse = updateEmployeeRequest
				.when()
				.put(putEndpoint);
		
		/*
		 * Converting JSON object to String and printing response
		 */
		String response = updateEmployeeResponse.prettyPrint();
				
		/*
		 * Validating the status code is 201		
		 */
		updateEmployeeResponse.then().assertThat().statusCode(201);
		
		
		/*
		 * Storing updated values (employee details) into variables
		 */
		idUpdated =  updateEmployeeResponse.jsonPath().getString(idPath);
		firstNameUpdated =  updateEmployeeResponse.jsonPath().getString(firstNamePath);
		middleNameUpdated =  updateEmployeeResponse.jsonPath().getString(middleNamePath);
		lastNameUpdated =  updateEmployeeResponse.jsonPath().getString(lastNamePath);
		birthdayUpdated =  updateEmployeeResponse.jsonPath().getString(birtdayPath);
		genderUpdated =  updateEmployeeResponse.jsonPath().getString(genderPath);
		jobTitleUpdated =  updateEmployeeResponse.jsonPath().getString(jobTitlePath);
		statusUpdated =  updateEmployeeResponse.jsonPath().getString(statusPath);
		
		
		
	}
	
	@Test
	public void eGETupdatedEmployee() {
		System.out.println("------------------------------------------GET Updated Employee-------------------------------------------");
		
		/*
		 * Preparing /getOneEmployee.php request
		 */
		RequestSpecification getUpdatedEmployeeRequest = given()
				.header(contType,appJSON)
				.header(auth,token)
				.queryParam("employee_id", empID);
		
		/*
		 * Making call 
		 */
		Response getUpdatedEmployeeResponse = getUpdatedEmployeeRequest.when().get(getOneEmployee);
		
		getUpdatedEmployeeResponse.prettyPrint();
		
		getUpdatedEmployeeResponse.then().assertThat().statusCode(200);
		
		
		
	}
}
