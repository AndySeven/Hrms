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

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Random;

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

	static String userName;
	static String password = "Qwerty@123";
	static String email;
	
	
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
	static String postCreateUser = "/createUser.php";
	static String postGenerateToken = "/generateToken.php";
	static String patchPartiallyUpdateEmployee = "/updatePartialEmplyeesDetails.php";
	static String getJobTitlesEndpoint = "/jobTitle.php";
	static String getStatusesEndpoint = "/employeeStatus.php";
	static String deleteEmployeeEndpoint = "/deleteEmployee.php";
	
	
	static Map<Object, Object> updatedBodyMap;
	
	
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
	
	
	public void a1POSTcreateUser() {
		System.out.println("------------------------------------------POST Create User-------------------------------------------");
		    userName = HardcodedConstants.getAlphaNumericString(8);
		    email = userName+"@gmail.com";
		    
		    System.out.println(userName+" "+password+" "+email);
		 
		RequestSpecification createUserRequest = given()
				.header(contType, appJSON)
				.body(HardcodedConstants.createUserBody(userName, password, email));
	
		Response createUserResponse = createUserRequest
				.when()
				.post(postCreateUser);

		createUserResponse.prettyPrint();
	}
	
	public void a2POSTgenerateToken() {
		System.out.println("------------------------------------------POST Generate Token-------------------------------------------");		
//		if(email == null) {
//		    userName = HardcodedConstants.getAlphaNumericString(8);
//		    email = userName+"@gmail.com";
//		}
		RequestSpecification generateTokenRequest = given()
				.header(contType,appJSON)
				.body(HardcodedConstants
				.generateTokenBody(email, password));
		
		System.out.println(email+" "+password);
		
		Response generateTokenResponse = generateTokenRequest.when().post(postGenerateToken);
		
		String response = generateTokenResponse.prettyPrint();
		
		token = generateTokenResponse.body().jsonPath().getString("token");
		
		JsonPath jp = new JsonPath(response);
		//token = jp.getString("token");
		
	}
	
	
	
	
	@Test
	public void aPOSTcreateEmployee() {
		System.out.println("------------------------------------------POST Create Employee-------------------------------------------");
		/*
		 * Preparing request for /createEmployee.php
		 */
		System.out.println(token);
		RequestSpecification createEmployeeRequest = given()
				.header("Content-Type", "application/json")
				.header("Authorization", token)
				.body(HardcodedConstants.createdEmpBody(empID))
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
		.body("Employee[0].emp_firstname", equalTo("Jack"));
		
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
		
		
		
		// --------------------------------Validation and Asserts---------------------------------
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
		
		
		// --------------------------------Validation and Asserts---------------------------------
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
				.body(HardcodedConstants.updateCreatedEmpBody(empID))
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
				
		
		// --------------------------------Validation and Asserts---------------------------------
		/*
		 * Validating the status code is 201		
		 */
		updateEmployeeResponse.then().assertThat().statusCode(201);
		
		JsonPath jp = new JsonPath(response);
		String message = jp.getString("Message");
		Assert.assertTrue(message.contentEquals("Entry updated"));
		
		/*
		 * Storing updated values (employee details) into variables
		 */
//		idUpdated =  updateEmployeeResponse.jsonPath().getString(idPath);
//		firstNameUpdated =  updateEmployeeResponse.jsonPath().getString(firstNamePath);
//		middleNameUpdated =  updateEmployeeResponse.jsonPath().getString(middleNamePath);
//		lastNameUpdated =  updateEmployeeResponse.jsonPath().getString(lastNamePath);
//		birthdayUpdated =  updateEmployeeResponse.jsonPath().getString(birtdayPath);
//		genderUpdated =  updateEmployeeResponse.jsonPath().getString(genderPath);
//		jobTitleUpdated =  updateEmployeeResponse.jsonPath().getString(jobTitlePath);
//		statusUpdated =  updateEmployeeResponse.jsonPath().getString(statusPath);
		
		updatedBodyMap = jp.getMap("employee[0]");
		
		
		
		
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
		
		/*
		 * printing response in console and storing in string
		 */
		String response = getUpdatedEmployeeResponse.prettyPrint();
		
		
		// --------------------------------Validation and Asserts---------------------------------
		
		getUpdatedEmployeeResponse.then().assertThat().statusCode(200);
		
		/*
		 * Verifying the the body contains expected updated employee details 
		 */
		JsonPath jp = new JsonPath(response);
		Map<String, String> updatedBodyMapActual = jp.getMap("employee[0]"); 
		Assert.assertEquals(updatedBodyMap, updatedBodyMapActual);
	}
	
	@Test
	public void fPATCHpartiallyUpdateEmployee() {
		System.out.println("------------------------------------------PATCH Partially Update Employee-------------------------------------------");
		/*
		 * Preparing /updatePartialEmplyeesDetails.php request
		 */
		
		RequestSpecification partiallyUpdateEmployeeRequest = given()
				.header(contType, appJSON)
				.header(auth, token)
				.body(HardcodedConstants.partuallyUpdateEmpBody(empID));
		
		Response partiallyUpdateEmployeeResponse = partiallyUpdateEmployeeRequest.when().patch(patchPartiallyUpdateEmployee);
		String response = partiallyUpdateEmployeeResponse.prettyPrint();
		
		partiallyUpdateEmployeeResponse.then().assertThat().statusCode(201);
		partiallyUpdateEmployeeResponse.then().assertThat().header(contType, appJSON);
		partiallyUpdateEmployeeResponse.then().assertThat().header("Access-Control-Allow-Methods", "PATCH");
		partiallyUpdateEmployeeResponse.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
		partiallyUpdateEmployeeResponse.then().assertThat().header("X-Powered-By", "PHP/7.2.18");
		
		partiallyUpdateEmployeeResponse.then().assertThat().body(idPath, equalTo(empID));
		partiallyUpdateEmployeeResponse.then().assertThat().body(firstNamePath, equalTo("Bilbo"));
		partiallyUpdateEmployeeResponse.then().assertThat().body(jobTitlePath, equalTo("Developer"));
		
		partiallyUpdateEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
		
		/*
		 * get all employee details and storing in map
		 */
		updatedBodyMap = new JsonPath(response).getMap("employee[0]");
		
	}
	
	@Test
	public void gGETpartiallyUpdatedEmployee() {
		System.out.println("------------------------------------------GET Partially Updated Employee-------------------------------------------");
		/*
		 * Preparing /getOneEmployee.php request
		 */
		
		RequestSpecification getPartiallyUpdatedEmployeeRequest = given()
				.header(contType,appJSON)
				.header(auth,token)
				.queryParam("employee_id", empID);
		
		Response getPartiallyUpdatedEmployeeResponse = getPartiallyUpdatedEmployeeRequest
				.when()
				.get(getOneEmployee);
		
		String response = getPartiallyUpdatedEmployeeResponse.prettyPrint();
		
		//String response = getPartiallyUpdatedEmployeeResponse.body().asString();
		//String response2 = getPartiallyUpdatedEmployeeResponse.toString();
		
		getPartiallyUpdatedEmployeeResponse.then().assertThat().statusCode(200);
		
		JsonPath jp = new JsonPath(response);
		Map<String, String> partiallyUpdatedMapActual = jp.getMap("employee[0]");
		
		Assert.assertEquals(updatedBodyMap, partiallyUpdatedMapActual);
		
	}
	@Test
	public void hDELETEemployee() {
		System.out.println("------------------------------------------DELETE Employee-------------------------------------------");
		RequestSpecification deleteEmployeeRequest = given()
				.header(contType,appJSON)
				.header(auth,token)
				.queryParam("employee_id", empID);
		Response deleteEmployeeResponse = deleteEmployeeRequest
				.when()
				.delete(deleteEmployeeEndpoint);
		String response = deleteEmployeeResponse.prettyPrint();

		JsonPath jp = new JsonPath(response);
	
		deleteEmployeeResponse.then().assertThat().statusCode(201);
		deleteEmployeeResponse.then().assertThat().body("message", equalTo("Entry deleted"));
		// OR
		Assert.assertEquals("Entri is not deleted", "Entry deleted", jp.getString("message"));
		
	}
	
	@Test
	public void iGETjobTitles() {
		System.out.println("------------------------------------------GET Job Titles-------------------------------------------");
		RequestSpecification getJobTitlesRequest = given()
				.header(contType,appJSON)
				.header(auth,token);
		Response getJobTitlesResponse = getJobTitlesRequest
				.when()
				.get(getJobTitlesEndpoint);
		String response = getJobTitlesResponse.prettyPrint();
		getJobTitlesResponse.then().assertThat().statusCode(200);
		
	}
	
	@Test
	public void jGETstatuses() {
		System.out.println("------------------------------------------GET Statuses-------------------------------------------");
		RequestSpecification getSatusesRequest = given()
				.header(contType,appJSON)
				.header(auth,token);
		
		Response getStatusesResponse = getSatusesRequest
				.when()
				.get(getStatusesEndpoint);
		String response = getStatusesResponse.prettyPrint();
		getStatusesResponse.then().assertThat().statusCode(200);
	}
}
