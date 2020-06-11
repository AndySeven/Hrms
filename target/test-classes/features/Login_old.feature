@NoExecute
Feature: login to HRMS

  Scenario: user login to HRMS using Admin credentials
    When user enters valid Admin credentials and clicks on login button
    Then Admin sees welcome message containing username

  Scenario: user login to HRMS using ESS credentials
    When user enters valid ESS credentials and clicks on login button
    Then user sees welcome message containing username

  Scenario Outline: 
    When user enter valid "<Username>" and "<Password>" and clicks on login button
    Then "<FirstName>" is successfully logged in

    Examples: 
      | Username    | Password         | FirstName |
      | Admin       | Hum@nhrm123      | Admin     |
      | Alfredo0253 | Gladiator7820$90 | Alfredo   |

  Scenario: Login with invalid credentials
    When user enter invalid credentials and see error message
      | username | password    | errorMessage             |
      | invalid  | Hum@nhrm123 | Invalid credentials      |
      | Admin    | invalid     | Invalid credentials      |
      |          | Hum@nhrm123 | Username cannot be empty |
      | Admin    |             | Password cannot be empty |
      |          |             | Username cannot be empty |
