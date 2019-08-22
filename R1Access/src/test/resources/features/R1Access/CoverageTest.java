package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources/features/R1Access/Coverage" }, 
tags = { "@392270"}, 
//dryRun = true,
glue = "r1.steps.definitions")

public class CoverageTest {

}
