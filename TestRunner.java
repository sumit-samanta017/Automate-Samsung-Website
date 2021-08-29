package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = {"StepDefinitions", "hooks"}, monochrome = true,
tags = "@Integration",
plugin = {"pretty", "html:target/reports.html"})

public class TestRunner {

}
