@ValidationDB
Feature: lastname validation against DB

  Background: 
    Given user logged in into HRMS

  Scenario: lastname validation against DB
  	When user navigates to Add Employee page
  	
  	And user enters First Name "Gennaro" and Last Name "Guttuso"
    And user sees ID
    And user clicks on save button
    Then employee is added successfully
    
    When user navigate to employee list page
    And user enters valid employee id
    And click on search button	
    Then verify table is displayed
    
    When user gets "emp_lastname" from the table
    And user gets data from db "select emp_lastname from hs_hr_employees where employee_id = "
    Then user validates data against db
    
    
