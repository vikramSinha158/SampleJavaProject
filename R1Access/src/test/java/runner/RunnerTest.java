package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources/features/R1Access/ServiceAutomationRule.feature" }, 
//tags = { "@Clearance or @CorrectAddress or @Notes or @PASupervisorDisable or @Patient or @PatientPASupervisorRole or @PCP or @ProspectivePatientEstimates or @R1Neccessity"}, 
tags = { "@ServiceAutomationRule"},
//dryRun = true,
//@Clearance or @CorrectAddress or @Notes or @PASupervisorDisable or @Patient or @PatientPASupervisorRole or @PCP or @ProspectivePatientEstimates or @R1Neccessity
glue = "r1.steps.definitions")

public class RunnerTest {

}
