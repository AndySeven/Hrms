#Author: Andrei Shelekhov
Feature: Name validations against DB

  Scenario: First Name validations against DB
    Given user logged in into HRMS
    And user navigate to employee list page
    And user enters valid employee id "14260"
    And click on search button
    Then verify table is displayed
    And get first name from table
    When get first name from DB
    Then validate first name from ui against db
