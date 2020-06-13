package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(    								// configuration for our tests
		features = "@target/faild.txt",  			// specify feature file to run. or pkg to run all features in pkg
		glue = "com/hrms/steps",  					// implementation code for Gherkin steps
		monochrome = true				  			// false - run as usual
		,plugin= {
						"pretty"  // prints Gherkin steps in console
						,"html:target/cucumber-default-report"  // creates basic html report in specified location
						}
		)
public class FailerRunner {

}
