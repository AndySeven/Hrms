#Author: syntaxteam
Feature: Add employee

  Background: 
    Given user logged in into HRMS
    And user navigates to Add Employee page
	@Smoke
  Scenario: Add new Employee
    When user enters First Name "Alfredo" and Last Name "Pitbullterierro"
    And user sees ID
    And user clicks on save button
    Then employee is added successfully

  Scenario: Add Employee without employee id 
    When user enters First Name "Alfredo" and Last Name "Pitbullterierro"
    And user delete ID
    And user clicks on save button
    Then employee is added successfully no ID

  
  Scenario: AddEmployee and create Login Credentials
    When user enters First Name "Alfredo" and Last Name "Pitbullterierro"
    And user sees ID
    And user clicks on create login checkbox 
    And user enters User Name "Alfredo3001" and password "Gladiator7820$90"
    And user clicks on save button
    Then employee is added successfully

  #to perform DDT in cucumber we use Scenario Outline with Examples keyword
  Scenario Outline: Adding multiple employees
    When user enters employee "<FirstName>", "<MiddleName>" and "<LastName>"
    And user clicks on save button
    Then user sees employee "<FirstName>", "<MiddleName>" and "<LastName>" added successfully

    Examples: #data works for spec scenarion whole, all steps
      | FirstName | MiddleName | LastName        |
      | Alfredo   | J          | Pitbullterierro |
      | Gustavo   | J          | Agassi          |
      | Tob       | J          | Brees           |
      | Jessica   | J          | Tomphson        |

  # Adding multiple employees usin Cucumber DataTable
  @Regression
  Scenario: Adding multiple employees
    #data works fo spec one step
    When user enters employee details and click on save
      | FirstName | MiddleName | LastName |
      | Joshua    | J          | Jackson  |
      | Julia     | J          | Jackson  |
    Then employee is added successfully using dataTable

  Scenario: Adding multiple employees from excel
    When user enters employee data from "EmployeeLoginCredentials" excel sheet
