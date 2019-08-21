package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources/features/R1Access" }, 
//tags = { " @391785 or @391787 or @391788 or @391789 or @391790 },
tags= {" @391789"},
monochrome=true,
glue = "r1.steps.definitions",
dryRun=false)
public class RunnerTest {

}