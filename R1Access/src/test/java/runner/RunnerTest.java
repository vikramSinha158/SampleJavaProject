package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources/features/R1Access" }, 
//tags = { " @391785 or @391787 or @391788 or @391789 or @391790 or @391787""},
tags= {" @391787"},
monochrome=true,
glue = "r1.steps.definitions")
//dryRun=true)
public class RunnerTest {

}