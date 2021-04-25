package com.e2eTests.canal;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.junit.Cucumber;

import cucumber.api.SnippetType;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = { "src/specs/features" }, plugin = { "pretty", "html:target/cucumber-html-report",
				"json:target/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/canal-plus-report.html" }, snippets = SnippetType.CAMELCASE, tags = {
						("@bouletcorp") },

		monochrome = true)

public class TestRunner {

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("src/test/resources/configs/extent-config.xml"));
	}
}
