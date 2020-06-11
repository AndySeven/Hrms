
Feature: Login with negative data
Scenario: Login with valid username and invalid password
When user enters valid username and invalid password
Then user see “Invalid credentials” error message
Scenario: Login with valid username and without password
When user enters valid username and empty password
Then user see “Password can not be empty” error message

Scenario: Login without username and valid password
When user leaves empty username and valid password
Then user see “Username can not be empty” error message