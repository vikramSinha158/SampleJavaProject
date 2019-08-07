package r1.steps.definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import r1.pages.FCCPage;

public class FCCStepDef {
	
	FCCPage fccPage;
	
	
	@Given("^user is on FCC worklist$")
	public void user_is_on_FCC_worklist(){
		fccPage.verifyFCCWorkListPage();
	}
	
	
	@When("^user should be able to verify the patient details above the tabs$")
	public void user_should_be_able_to_verify_the_patient_details_above_the_tabs(){
		fccPage.verifyPatientDetailsLabel();
	}
	
	@And("^user clicks on the right VCR > button$")
	public void user_clicks_on_the_right_VCR_button(){
		fccPage.clickRightVCRButton();
	}
	
	@And("^user should be able to view the next account FCC Tab$")
	public void user_should_be_able_to_view_the_next_account_FCC_Tab(){
		fccPage.clickRightVCRButton();
	}
	
	
}
