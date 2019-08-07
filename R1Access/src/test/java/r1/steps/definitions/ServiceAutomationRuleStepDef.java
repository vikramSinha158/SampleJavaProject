package r1.steps.definitions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.pages.Navigation;
import r1.pages.ServiceAutomationRulePage;
import r1.pages.UserLogin;

public class ServiceAutomationRuleStepDef extends BasePage {
	
	
	UserLogin userLogin;
	Navigation navigation;
	ServiceAutomationRulePage serviceAutomationRulePage;
	
	
	
	@When("^user clicks on Zero-Touch-Residual-Configuration$")
	public void user_clicks_on_Zero_Touch_Residual_Configuration() {
		navigation.clickZeroTouchResidualConfiguration();
	}

	@Given("^User is on Zero-Touch-Residual-Configuration Page$")
	public void user_is_on_Zero_Touch_Residual_Configuration_Page() {
		serviceAutomationRulePage.serviceAutomationRule_Page();
	}
	
	@When("^user add service automation rule by click on add button$")
	public void user_add_service_automation_rule_by_click_on_add_button() {
		serviceAutomationRulePage.clickAddButton();
    }

	
	@Then("^user enters rule name \"([^\"]*)\" ,Patient Type \"([^\"]*)\" ,Facility Patient Type \"([^\"]*)\" ,and Rule Accuracy \"([^\"]*)\"$")
	public void user_enters_rule_name_Patient_Type_Facility_Patient_Type_and_Rule_Accuracy(String ruleName, String patientType, String facilityPatientType, String ruleAccuracy) {
		serviceAutomationRulePage.addServiceAutomationRule(ruleName, patientType, facilityPatientType, ruleAccuracy);
	}

	@Then("^enter CPT Code \"([^\"]*)\"$")
	public void enter_CPT_Code(String cptCode) {
    	serviceAutomationRulePage.enterCPTCode(cptCode);
	}

	@Then("^user click on check boxes for Is Enabled and Complete Service Task$")
	public void user_click_on_check_boxes_for_Is_Enabled_and_Complete_Service_Task() {
		serviceAutomationRulePage.selectIsEnabledCheckBox();
		serviceAutomationRulePage.selectCompleteServicesTaskCheckBox();
	}

	@Then("^user click on save button$")
	public void user_click_on_save_button() {
		serviceAutomationRulePage.clickSaveButton();
	}

	@Then("^user should able to view newly created rule in Service Automation Rule worklist$")
	public void user_should_able_to_view_newly_created_rule_in_Service_Automation_Rule_worklist() {
		serviceAutomationRulePage.verifyServiceAutomationRuleAdded();
	}

	@When("^user clicks on Service Bus Monitor$")
	public void user_clicks_on_Service_Bus_Monitor() {
		navigation.clickServiceBusMonitor();
	}

	@When("^user click on Message Publish plus button$")
	public void user_click_on_Message_Publish_plus_button() {
		serviceAutomationRulePage.clickMessagePublishButton();
	}

	@When("^user enters Facility code \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_Facility_code_and(String facilityCode, String taskId) {
		serviceAutomationRulePage.enterFacilityCode(facilityCode);
		
	}

	@When("^user clicks on publish button$")
	public void user_clicks_on_publish_button() {
		serviceAutomationRulePage.clickPublishButton();
	}
	
	@When("^user clicks on show all button$")
	public void user_clicks_on_show_all_button() {
		serviceAutomationRulePage.clickShowAllButton();
	   
	}

	@Then("^verify Service associated with automation rule should get added to account and service tab should get completed$")
	public void verify_Service_associated_with_automation_rule_should_get_added_to_account_and_service_tab_should_get_completed() {
	   
	    
	}


	
	
	
	
	

}
