@serachemployee @sprint13
Feature: Employee Search

  Background: 
    And user is logged in with valid admin credentials
    And user navigate to employee list page


 
  Scenario: Search employee by id
    #Given user is navigated to HRMS we have hooks							 we have hooks for entire project
    #And user is logged in with valid admin credentials          we have background for spec feature
    #And user navigate to employee list page										 we have background for spec feature
    When user enters valid employee id "14112"
    And click on search button
    Then user see employee information is displayed "14112"

  @Regression
  Scenario: Search employee by name
    #Given user is navigated to HRMS  													 we have hooks for entire project
    #And user is logged in with valid admin credentials					 we have background for spec feature
    #And user navigate to employee list page										 we have background for spec feature
    When user enters valid employee name "Alfredo Pitbullterierro"
    And click on search button
    Then user see employee information is displayed "14112"
