$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/LastNameValidationDB.feature");
formatter.feature({
  "name": "lastname validation against DB",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@ValidationDB"
    }
  ]
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
formatter.scenario({
  "name": "lastname validation against DB",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ValidationDB"
    }
  ]
});
formatter.step({
  "name": "user navigates to Add Employee page",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.AddEmployeeSteps.user_navigates_to_Add_Employee_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters First Name \"Gennaro\" and Last Name \"Guttuso\"",
  "keyword": "And "
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
formatter.step({
  "name": "user navigate to employee list page",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_navigate_to_employee_list_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters valid employee id",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_enters_valid_employee_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on search button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.click_on_search_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify table is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.verify_table_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user gets data from the table",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_gets_lastname_from_the_table()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user gets data from db \"select emp_lastname from hs_hr_employees where employee_id \u003d \"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.DBsteps.user_gets_data_from_db(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user validates data against db",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_validates_data_against_db()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "lastname validation against DB");
formatter.after({
  "status": "passed"
});
});