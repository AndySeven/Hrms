package com.hrms.steps;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

	@Before
	public void start(Scenario scenario) {
		System.out.println("Starting Test: " + scenario.getName());
		setUp();
	}

	@After
	public void end(Scenario scenario) {
		System.out.println("Ending Test: " + scenario.getName());

		byte[] pic;
		if (scenario.isFailed()) {
			pic = takeScreenshotBytes("faild/" + scenario.getName());
		} else {
			pic = takeScreenshotBytes("passed/" + scenario.getName());
		}

		scenario.attach(pic, "image/png", scenario.getName());

		tearDown();
	}
}
