package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources/features/R1Access/Service2.0" }, 
//tags = { "@391775 or @391776 or @391779 or @392057"}, 
//dryRun = true,
glue = "r1.steps.definitions")

public class Service2Test {

}

