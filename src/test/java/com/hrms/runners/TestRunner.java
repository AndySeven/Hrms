package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(    								// configuration for our tests
		features = "src/test/resources/features",  	// specify feature file to run. or pkg to run all features in pkg
		glue = "com/hrms/steps",  					// implementation code for Gherkin steps
		dryRun = false,    							// true - scan that all Gherkin steps has implementation
		monochrome = true,				  			// false - run as usual
		strict = false								// will fail your Scenario if there is one unimplemented step
		//,tags= "@HWAddEmp"
		//,tags="@Progress"
		//,tags="@Regression"
		,plugin= {
						"pretty",  // prints Gherkin steps in console
						"html:target/cucumber-default-report",  // creates basic html report in specified location
						"json:target/cucumber.json",
						"rerun:target/faild.txt"
						}
		)
public class TestRunner {
	
}
