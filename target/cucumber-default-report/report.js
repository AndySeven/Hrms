$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/AddEmployee.feature");
formatter.feature({
  "name": "Add employee",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user logged in into HRMS",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_logged_in_into_HRMS()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigates to Add Employee page",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_navigates_to_Add_Employee_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add new Employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "name": "user enters First Name \"Alfredo\" and Last Name \"Pitbullterierro\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_enters_First_Name_and_Last_Name(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees ID",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_sees_ID()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on save button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_clicks_on_save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "employee is added successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.employee_is_added_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "Add new Employee");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/Login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Error message validation while invalid login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "name": "user enter valid \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\" and clicks on login button",
  "keyword": "When "
});
formatter.step({
  "name": "user sees \"\u003cerrorMessage\u003e\" is displayed",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "errorMessage"
      ]
    },
    {
      "cells": [
        "invalid",
        "Hum@nhrm123",
        "Invalid credentials"
      ]
    },
    {
      "cells": [
        "Admin",
        "invalid",
        "Invalid credentials"
      ]
    },
    {
      "cells": [
        "",
        "Hum@nhrm123",
        "Username cannot be empty"
      ]
    },
    {
      "cells": [
        "Admin",
        "",
        "Password cannot be empty"
      ]
    },
    {
      "cells": [
        "",
        "",
        "Username cannot be empty"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Error message validation while invalid login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enter valid \"invalid\" and \"Hum@nhrm123\" and clicks on login button",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeLoginSteps.user_enter_valid_and_and_clicks_on_login_button(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees \"Invalid credentials\" is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeLoginSteps.user_sees_is_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png", "Error message validation while invalid login");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Error message validation while invalid login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enter valid \"Admin\" and \"invalid\" and clicks on login button",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeLoginSteps.user_enter_valid_and_and_clicks_on_login_button(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees \"Invalid credentials\" is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeLoginSteps.user_sees_is_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded2.png", "Error message validation while invalid login");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Error message validation while invalid login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enter valid \"\" and \"Hum@nhrm123\" and clicks on login button",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeLoginSteps.user_enter_valid_and_and_clicks_on_login_button(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees \"Username cannot be empty\" is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeLoginSteps.user_sees_is_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded3.png", "Error message validation while invalid login");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Error message validation while invalid login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enter valid \"Admin\" and \"\" and clicks on login button",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeLoginSteps.user_enter_valid_and_and_clicks_on_login_button(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees \"Password cannot be empty\" is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeLoginSteps.user_sees_is_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded4.png", "Error message validation while invalid login");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Error message validation while invalid login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enter valid \"\" and \"\" and clicks on login button",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeLoginSteps.user_enter_valid_and_and_clicks_on_login_button(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees \"Username cannot be empty\" is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeLoginSteps.user_sees_is_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded5.png", "Error message validation while invalid login");
formatter.after({
  "status": "passed"
});
});