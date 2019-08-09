package r1.steps.definitions;
import java.io.IOException;

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

	@When("^user enters rule name \"([^\"]*)\" ,Patient Type \"([^\"]*)\" ,Facility Patient Type \"([^\"]*)\"$")
	public void user_enters_rule_name_Patient_Type_Facility_Patient_Type_and_rule_Accuracy(String ruleName, String patientType, String facilityPatientType) {
		serviceAutomationRulePage.addServiceAutomationRule(ruleName, patientType, facilityPatientType);
	}
	
	@When("^user should able to view rule Accuracy is \"([^\"]*)\"$")
	public void user_should_able_to_view_rule_Accuracy_is(String accuracyValue) {
		serviceAutomationRulePage.verifyRuleAccuracy(accuracyValue);
	    
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

	@When("^user enters Facility code \"([^\"]*)\"$")
	public void user_enters_Facility_code_and(String facilityCode) {
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
		serviceAutomationRulePage.clickServiceAutomationRule();
		serviceAutomationRulePage.verifyMatchingRule();
		serviceAutomationRulePage.clickServiceAutomationRule();
	}
	
	@When("^user select any service automation rule and clicks on edit button$")
	public void user_select_any_exisiting_service_automation_rule_and_clicks_on_edit_button() {
		serviceAutomationRulePage.verifyAccuracyUnabled();
	}  
	
    @Then("^user should not able to edit accuracy value$")
	public void user_should_not_able_to_edit_accuracy_value() {
		serviceAutomationRulePage.verifyRuleAccuracyDisable();
	}
	
	
    @Then("^user should able to view Add Service Automation Rule window$")
	public void user_should_able_to_view_Add_Service_Automation_Rule_window() {
    	serviceAutomationRulePage.addServiceAutomationRulePopUp();
	}

	@When("^user clicks on cancel button$")
	public void user_clicks_on_cancel_button() {
		serviceAutomationRulePage.clickCancelButton();
	}

    @Then("^Add Service Automation Rule window should disappear$")
	public void add_Service_Automation_Rule_window_should_disappear() {
		serviceAutomationRulePage.addServiceAutomationRulePopUpDisappear();
	   
	    
	}
    
    @Then("^user should able to view updated value in Service Automation Rule panel$")
    public void user_should_able_to_view_updated_value_in_Service_Automation_Rule_panel() {
    	serviceAutomationRulePage.verifyServiceAutomationRuleEdit();
    }

    @When("^user select any existing service automation rule having Is Enable as True$")
    public void user_select_any_existing_service_automation_rule_having_Is_Enable_as_True() {
    	serviceAutomationRulePage.verifyIsEnabledColumnValueTrue();
        
    }

    @When("^user clicks on Deactivate button$")
    public void user_clicks_on_Deactivate_button() {
    	serviceAutomationRulePage.verifyRuleDeactivate();
        
    }

    @Then("^value of Is Enabled should be updated as False$")
    public void value_of_Is_Enabled_should_be_updated_as_False() {
    	serviceAutomationRulePage.verifyIsEnabledColumnValueFalse();
        
    }
    
    @Then("^verify No service should get added from the audit and tab should not be completed$")
    public void verify_No_service_should_get_added_from_the_audit_and_tab_should_not_be_completed() {
    	serviceAutomationRulePage.clickServiceAutomationRule();
    	serviceAutomationRulePage.verifyNoServiceAdded();
    	serviceAutomationRulePage.clickServiceAutomationRule();
        
    }
    
    @When("^user select any existing service automation rule having Is Enable as False$")
    public void user_select_any_existing_service_automation_rule_having_Is_Enable_as_False() {
    	serviceAutomationRulePage.clickIsEnabledColumnValueFalse();
        
    }

    @When("^user clicks on Activate button$")
    public void user_clicks_on_Activate_button() {
    	serviceAutomationRulePage.verifyRuleActivate();
        
    }

    @Then("^value of Is Enabled should be updated as True$")
    public void value_of_Is_Enabled_should_be_updated_as_True() {
    	serviceAutomationRulePage.verifyIsEnabledColumnValueTrue();
        
    }

    @Then("^verify service should get added from the audit and tab should be completed$")
    public void verify_service_should_get_added_from_the_audit_and_tab_should_be_completed() {
    	serviceAutomationRulePage.clickServiceAutomationRule();
    	serviceAutomationRulePage.verifyMatchingRule();
    	serviceAutomationRulePage.clickServiceAutomationRule();
        
    }
    
    @When("^user select any existing service automation rule$")
    public void user_select_any_existing_service_automation_rule() {
    	serviceAutomationRulePage.verifyIsEnabledColumnValueTrue();
    	
       
    }

    @When("^user Clicks on delete button$")
    public void user_Clicks_on_delete_button() {
    	serviceAutomationRulePage.verifyDeleteButton();
       
    }

    @Then("^selected Service Automation rule should get deleted successfully$")
    public void selected_Service_Automation_rule_should_get_deleted_successfully() {
    	serviceAutomationRulePage.verifyNoServiceAdded();
        
    }

    @When("^user clicks on Export button$")
	public void user_clicks_on_Export_button() {
		serviceAutomationRulePage.clickExport();
	}


	@Then("^user should able to view exported excel in system$")
	public void user_should_able_to_view_exported_excel_in_system() throws IOException {
		serviceAutomationRulePage.verifyExport();
	}









	
	
	
	
	

}
