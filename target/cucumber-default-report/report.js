$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/SearchEmployee.feature");
formatter.feature({
  "name": "Employee Search",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@serachemployee"
    },
    {
      "name": "@sprint13"
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
  "name": "user is logged in with valid admin credentials",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_is_logged_in_with_valid_admin_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigate to employee list page",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_navigate_to_employee_list_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Search employee by name",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@serachemployee"
    },
    {
      "name": "@sprint13"
    },
    {
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "name": "user enters valid employee name \"Alfredo Pitbullterierro\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_enters_valid_employee_name(java.lang.String)"
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
  "name": "user see employee information is displayed \"14112\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_see_employee_information_is_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "Search employee by name");
formatter.after({
  "status": "passed"
});
});