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
