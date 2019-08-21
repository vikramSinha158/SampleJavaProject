package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources/features/R1Access/Service2.0.feature" }, 
//dryRun=true,
tags = { "@391646"}, 
glue = "r1.steps.definitions")

public class Service2Test {

}