package com.hrms.steps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class DashboardSteps extends CommonMethods {

	// the same @When user is logged in with valid admin credentials
	// we use in other feature

	@Then("user sees dashboard menu is displayed")
	public void user_sees_dashboard_menu_is_displayed(DataTable dashboardMenu) {
		List<String> expectedMenu = dashboardMenu.asList();
		List<String> actualMenu = new ArrayList<>();
		List<WebElement> actualMenuWeb = dash.firstLevelMenu;
		for (WebElement act : actualMenuWeb) {
			actualMenu.add(act.getText());
		}

		Assert.assertEquals("Menu is NOT matched", expectedMenu, actualMenu);
	}

	@Then("user sees dashboard menu is displayed step by step")
	public void user_sees_dashboard_menu_is_displayed_step_by_step(DataTable dashboardMenu) {

		List<String> expectedMenu = dashboardMenu.asList();
		List<WebElement> actualMenuWeb = dash.firstLevelMenu;

		Iterator<String> it = expectedMenu.iterator();
		while (it.hasNext()) {
			Iterator<WebElement> itw = actualMenuWeb.iterator();
			while (itw.hasNext()) {
				String expectedTab = it.next();
				String actualTab= itw.next().getText();
				Assert.assertEquals("Menu Tab is NOT matched", expectedTab, actualTab);
			}
		}
	}
}
