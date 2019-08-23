package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources/features/R1Access/Patient.feature" }, 
tags = { "@419179"}, 
glue = "r1.steps.definitions")

public class RunnerTest {

}