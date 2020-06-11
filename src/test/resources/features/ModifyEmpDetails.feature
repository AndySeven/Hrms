Feature: Personal Details

  Background: 
    Given user is logged in with valid admin credentials
    And user navigates to Add Employee page
    And user enters First Name "Alfredo" and Last Name "Pitbullterierro"
    And user sees ID
    And user clicks on save button
    And user navigate to employee list page
    And user enters valid employee name "Alfredo Pitbullterierro"
    And click on search button
    When user clicks on Employee id and
    And user lands on Personal Details page
    And user clicks on button edit

  Scenario: As Admin user modifies personal details using dataTable
    When user enters Employee Details data from dataTable
      | 888-888-888 | 2019-Apr-18 | 555-23-5555 | 123-127 | 1 | Married | Sri Lankan | 1990-Aug-2 | AlfredoNick | No |
    And user checks smoker singlr check box
    And user clicks save button
    Then checks all data modified

  #Scenario: As Admin user modifies personal details using Excel
    #When user enters Employee Details data from "PersonalDetails"
    #And user checks smoker singlr check box
    #And user clicks save button
    #Then checks all data modified
