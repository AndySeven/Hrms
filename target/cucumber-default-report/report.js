$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/ModifyEmpDetails.feature");
formatter.feature({
  "name": "Personal Details",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Progress"
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
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_is_logged_in_with_valid_admin_credentials()"
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
formatter.step({
  "name": "user enters First Name \"Alfredo\" and Last Name \"Pitbullterierro\"",
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
  "name": "user navigate to employee list page",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_navigate_to_employee_list_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters valid employee name \"Alfredo Pitbullterierro\"",
  "keyword": "And "
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
  "name": "user clicks on Employee id and",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.user_clicks_on_Employee_id_and()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user lands on Personal Details page",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.user_lands_on_Personal_Details_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on button edit",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.user_clicks_on_button_edit()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "As Admin user modifies personal details using dataTable",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Progress"
    }
  ]
});
formatter.step({
  "name": "SERVICE STEP getting data from dataTable",
  "rows": [
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.service_STEP_getting_data_from_dataTable(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters Employee Details data",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.user_enters_Employee_Details_data()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user checks smoker singlr check box",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.user_checks_smoker_singlr_check_box()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks save button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.user_clicks_save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "checks all data modified \"Sri Lankan\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.checks_all_data_modified(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "As Admin user modifies personal details using dataTable");
formatter.after({
  "status": "passed"
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
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_is_logged_in_with_valid_admin_credentials()"
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
formatter.step({
  "name": "user enters First Name \"Alfredo\" and Last Name \"Pitbullterierro\"",
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
  "name": "user navigate to employee list page",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_navigate_to_employee_list_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters valid employee name \"Alfredo Pitbullterierro\"",
  "keyword": "And "
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
  "name": "user clicks on Employee id and",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.user_clicks_on_Employee_id_and()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user lands on Personal Details page",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.user_lands_on_Personal_Details_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on button edit",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.user_clicks_on_button_edit()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "As Admin user modifies personal details using Excel",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Progress"
    }
  ]
});
formatter.step({
  "name": "SERVICE STEP geting data from excel sheet \"PersonalDetails\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.service_STEP_geting_data_from_excel_sheet(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters Employee Details data",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.user_enters_Employee_Details_data()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user checks smoker singlr check box",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.user_checks_smoker_singlr_check_box()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks save button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.user_clicks_save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "checks all data modified \"Sri Lankan\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.ModifyEmpDetailsSteps.checks_all_data_modified(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png", "As Admin user modifies personal details using Excel");
formatter.after({
  "status": "passed"
});
});