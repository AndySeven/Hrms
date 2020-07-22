#Author: your.email@your.domain.com
Feature: Login

  
  Scenario Outline: 
    When user enter valid "<Username>" and "<Password>" and clicks on login button
    Then "<FirstName>" is successfully logged in

    Examples: 
      | Username    | Password         | FirstName |
      | Admin       | Hum@nhrm123      | Admin     |
      | Alfredo3001 | Gladiator7820$90 | Alfredo   |

  @Smoke
  Scenario Outline: Error message validation while invalid login
    #invalid credentials
    When user enter valid "<Username>" and "<Password>" and clicks on login button
    Then user sees "<errorMessage>" is displayed

    Examples: 
      | Username | Password    | errorMessage             |
      | invalid  | Hum@nhrm123 | Invalid credentials      |
      | Admin    | invalid     | Invalid credentials      |
      |          | Hum@nhrm123 | Username cannot be empty |
      | Admin    |             | Password cannot be empty |
      |          |             | Username cannot be empty |
