package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources/features/R1Access" }, 
tags = { "@FCC"}, 
glue = "r1.steps.definitions")

public class RunnerTest {

}
