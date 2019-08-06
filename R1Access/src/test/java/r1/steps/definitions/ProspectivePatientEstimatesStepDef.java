package r1.steps.definitions;

import java.io.IOException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.pages.Navigation;
import r1.pages.ProspectivePatientEstimatesPage;
import r1.pages.UserLogin;

public class ProspectivePatientEstimatesStepDef extends BasePage{
	
	
	ProspectivePatientEstimatesPage prospectivePatientEstimatesPage;
	R1AccessCommonMethods commonMethodsR1Access;
	Navigation navigation;
	UserLogin userLogin;
	
    @When("^user Clicks On \"([^\"]*)\"$")
	public void user_Clicks_On(String item) {
		prospectivePatientEstimatesPage.clickProspectivepatientEstimatesLink(item);
	}
	
	@When("^user click \"([^\"]*)\" link$")
	public void user_click_link(String newTab) {
		prospectivePatientEstimatesPage.clickNewLink(newTab); 
	}

	@Given("^User is on Prospective Patient Estimates Page$")
	public void user_is_on_Prospective_Patient_Estimates_Page() {
		prospectivePatientEstimatesPage.prospectivePatientEstimates_Page();
	}

	@Then("^user should be able to view controls in patient section$")
	public void user_should_be_able_to_view_controls_in_patient_section() {
		prospectivePatientEstimatesPage.verifyPateintDetailLable();
	}

	@When("^user clicks on add button$")
	public void user_clicks_on_add_button() {
		prospectivePatientEstimatesPage.clickAddButton();
	}

	@Then("^validation messages should display for empty fields$")
	public void validation_messages_should_display_for_empty_fields() {
		prospectivePatientEstimatesPage.validationMessagesRequiredFields();
    }

	@When("^user enter first name \"([^\"]*)\" and last name \"([^\"]*)\"$")
	public void user_enter_first_name_and_last_name(String firstName, String lastName) {
		prospectivePatientEstimatesPage.enterPatientName(firstName, lastName);
	}
	
	@When("^user enter values in DOB \"([^\"]*)\" and Gender \"([^\"]*)\" and Phone \"([^\"]*)\" no fields$")
	public void user_enter_values_in_DOB_and_Gender_and_Phone_no_fields(String dob, String gender, String phoneNo) {
		prospectivePatientEstimatesPage.enterPatientDetailBelowEighteen(dob,gender,phoneNo);
	}
	
	@When("^user fill values in DOB \"([^\"]*)\" and Gender \"([^\"]*)\" and Phone \"([^\"]*)\" no fields$")
	public void user_fill_values_in_DOB_and_Gender_and_Phone_no_fields(String dob, String gender, String phoneNo) {
		prospectivePatientEstimatesPage.enterPatientDetailAboveEighteen(dob,gender,phoneNo);
    } 
	
    @Then("^verify message as \"([^\"]*)\"$")
	public void verify_message_as(String message) {
		prospectivePatientEstimatesPage.verifyMessageBelowEighteen(message);
	}
	
	@Then("^request should be submitted with success message \"([^\"]*)\"$")
	public void request_should_be_submitted_with_success_message(String message) {
		prospectivePatientEstimatesPage.verifyMessageAboveEighteen(message);
	}
	
	@Then("^account should be present in the \"([^\"]*)\"$")
	public void account_should_be_present_in_the(String worklist) {
		prospectivePatientEstimatesPage.clickWorklistLink(worklist);
		prospectivePatientEstimatesPage.workListFilter("F Name", "=");
		commonMethodsR1Access.verifyWorklistExists();
	}
	
    @When("^user select a value \"([^\"]*)\" from patient type dropdown$")
	public void user_select_a_value_from_patient_type_dropdown(String patientType) {
    	prospectivePatientEstimatesPage.selectPatientType(patientType);
	}
    
    @When("^user enter date of birth in \"([^\"]*)\" field$")
    public void user_enter_date_of_birth_in_field(String dob) {
    	prospectivePatientEstimatesPage.enterguarantorDOB(dob);
    }
    
    @When("^user enter guarantor information first name \"([^\"]*)\" and last name \"([^\"]*)\"$")
   	public void user_enter_guarantor_information_first_name_and_last_name(String firstName, String lastName) {
    	prospectivePatientEstimatesPage.enterGuarantorName(firstName, lastName);
   	}
	
    @When("^user clicked Unassigned Account$")
	public void user_clicked_Unassigned_Account() {
    	commonMethodsR1Access.clickOnUnassignedAccount();
	}
    
    @When("^user select a value from payor \"([^\"]*)\" and plan \"([^\"]*)\" dropdown and enter subscriber ID \"([^\"]*)\" in text box$")
	public void user_select_a_value_from_payor_and_plan_dropdown_and_enter_subscriber_ID_in_text_box(String payorCode, String planCode, String subscriberID) throws InterruptedException {
	    prospectivePatientEstimatesPage.DelAllCoverage();
		prospectivePatientEstimatesPage.enterCoverageDetail(payorCode, planCode,subscriberID);
	}

	@When("^user clicks on Add Coverage button$")
	public void user_clicks_on_Add_Coverage_button() {
		prospectivePatientEstimatesPage.clickAddCoverageButton();
	}

	@When("^user click on Check Eligibility button$")
	public void user_click_on_Check_Eligibility_button() {
		prospectivePatientEstimatesPage.clickCheckEligibilityButton();
	}

    @When("^user input a values in copay \"([^\"]*)\" ,coinsurance \"([^\"]*)\" , deductible \"([^\"]*)\" and MAXOOP \"([^\"]*)\" fields$")
	public void user_input_a_values_in_copay_coinsurance_deductible_and_MAXOOP_fields(String copay, String coinsurance, String deductible, String oop) {
    	prospectivePatientEstimatesPage.enterCoverageDetail(copay, coinsurance, deductible, oop);
	}

	@When("^user select a value \"([^\"]*)\" from the Status dropdown$")
	public void user_select_a_value_from_the_Status_dropdown(String status) {
		prospectivePatientEstimatesPage.selectStatus(status);
	}

	@When("^user clicks on update coverage button$")
	public void user_clicks_on_update_coverage_button() {
		prospectivePatientEstimatesPage.clickUpdateCoverageButton();
	}

	@Then("^user should be able to view updated value at Columns in Coverage Grid$")
	public void user_should_be_able_to_view_updated_value_at_Columns_in_Coverage_Grid() {
		prospectivePatientEstimatesPage.verifyPayorCode();
		prospectivePatientEstimatesPage.verifyPlanCode();
		prospectivePatientEstimatesPage.verifySubscriberID();
		prospectivePatientEstimatesPage.verifyCopay();
		prospectivePatientEstimatesPage.verifyCoIns();
		prospectivePatientEstimatesPage.verifyDeduct();
		prospectivePatientEstimatesPage.verifyOOPRemaining();
		prospectivePatientEstimatesPage.verifyPayorStatus();
	}
	
	@When("^user clicked on update button$")
    public void user_clicked_on_update_button() {
    	prospectivePatientEstimatesPage.clickAddButton();
    }
	
	@When("^user enters the DRG code \"([^\"]*)\" and pass into search text box$")
    public void user_enters_the_DRG_code_and_pass_into_search_text_box(String drgCode) {
		prospectivePatientEstimatesPage.selectRadioExactOrContains();
    	prospectivePatientEstimatesPage.enterDRGCode(drgCode);
    }
	
	@When("^user clicks on search button$")
	public void user_clicks_on_search_button() {
    	prospectivePatientEstimatesPage.clickServiceSearchButton();
	}
	
	@When("^user clicks on add button from search result grid inorder to add the DRG$")
	public void user_clicks_on_add_button_from_search_result_grid_inorder_to_add_the_DRG() {
		prospectivePatientEstimatesPage.clickAddDRGServiceButton();
	}
	
	@When("^user select Unassigned emergency \"([^\"]*)\" Account$")
	public void user_select_Unassigned_emergency_Account(String patientType) {
		prospectivePatientEstimatesPage.selectPatientType(patientType);
	    
	}

    @Then("^user enter \"([^\"]*)\" in search text box$")
    public void user_enter_in_search_text_box(String arg1) {
       
    }

    @When("^user run the query and get \"([^\"]*)\"$")
    public void user_run_the_query_and_get(String arg1) {
      
    }

    @When("^user enters the CPT code \"([^\"]*)\" and pass into search text box$")
    public void user_enters_the_CPT_code_and_pass_into_search_text_box(String cptCode) {
    	prospectivePatientEstimatesPage.selectRadioExactOrContains();
    	prospectivePatientEstimatesPage.enterCPTCode(cptCode);
    }
    
    @When("^user clicks on add button from search result grid inorder to add the CPT$")
    public void user_clicks_on_add_button_from_search_result_grid_inorder_to_add_the_CPT() {
    	prospectivePatientEstimatesPage.clickAddCPTServiceButton();
    }

	@Then("^user should able to view added service in service selected grid$")
	public void user_should_able_to_view_added_service_in_service_selected_grid() {
		prospectivePatientEstimatesPage.verifyGrdDRGSelected();
		prospectivePatientEstimatesPage.clickCalculateButton();
	}
	
	@Then("^user should able to view added HCPC service in service selected grid$")
	public void user_should_able_to_view_added_HCPC_service_in_service_selected_grid() {
		prospectivePatientEstimatesPage.verifyGrdHCPCSelected();
		prospectivePatientEstimatesPage.clickCalculateButton();
	    
	}

   @Then("^exceptions messages for the Coverage displayed on UI should match with query results$")
	public void exceptions_messages_for_the_Coverage_displayed_on_UI_should_match_with_query_results() {
	    
	    
	}

	@Then("^AHtonecessity and Authorization exception message should not display$")
	public void ahtonecessity_and_Authorization_exception_message_should_not_display() {
	    
	    
	}

	@Then("^user should be able to view patient portion panel with controls$")
	public void user_should_be_able_to_view_patient_portion_panel_with_controls() {
	    
	    
	}

	@Then("^patient portion value should match with coverage grid$")
	public void patient_portion_value_should_match_with_coverage_grid() {
		prospectivePatientEstimatesPage.verifyPatientPortion();
	    
	}


	

	@Then("^user should able to view Estimated Patient Responsibility value$")
	public void user_should_able_to_view_Estimated_Patient_Responsibility_value() {
	    
	    
	}

	@When("^user add services in services section$")
	public void user_add_services_in_services_section() {
	    
	    
	}

	@Then("^user run the query and verify benefits under coverage tab are same as mentioned in PST in database table$")
	public void user_run_the_query_and_verify_benefits_under_coverage_tab_are_same_as_mentioned_in_PST_in_database_table() {
	    
	    
	}


	


}
