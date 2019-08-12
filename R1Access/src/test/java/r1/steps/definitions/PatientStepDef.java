package r1.steps.definitions;

import java.io.IOException;
import java.sql.SQLException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.pages.Navigation;
import r1.pages.NotesPage;
import r1.pages.UserLogin;
import r1.pages.PatientPage;
import r1.serenity.steps.NotesSteps;
import r1.serenity.steps.PatientSteps;
import r1.commons.R1AccessCommonMethods;
import r1.commons.BasePage;
import r1.commons.databaseconnection.QueryConstants;

public class PatientStepDef extends BasePage {
	
	Navigation navigation;
	UserLogin userLogin;	
	PatientPage patientPage;	
	R1AccessCommonMethods r1AccessCommonMethod;
	
	PatientSteps patientSteps;
	@When("^user clicks on Patient Access link$")
	public void user_clicks_on_Patient_Access_link() {
	 r1AccessCommonMethod.clickR1HubModulesMenuLink("Patient Access");		   	   
	}

	@When("^user clicks on Pre-Registration$")
	public void user_clicks_on_Pre_Registration() {
		r1AccessCommonMethod.clickSubSideR1HubModulesMenuLink("Pre-Registration");
	}

	@Then("^user should be able to view Account Worklist Grid$")
	public void user_should_be_able_to_view_Account_Worklist_Grid() {
		 //r1AccessCommonMethod.verifyWorklistExists();
	}
	

	@When("^user run the query and fetch the encounteridOne$")
	public void user_run_the_query_and_fetch_the_encounteridOne() throws ClassNotFoundException, IOException, SQLException {
		patientPage.getPatientGuranorAccount();
	   
	}

	@When("^user clicks on search button of menu$")
	public void user_clicks_on_search_button_of_menu() {
		patientPage.clickOnSearch();
	    
	}

	@When("^user enter encounterid in search textbox$")
	public void user_enter_encounterid_in_search_textbox() {
		patientPage.entersSearchText();
	    
	}

	@When("^user clicks on submit button$")
	public void user_clicks_on_submit_button() {
		patientPage.clickOnSearchButton();	  
	}

	@Then("^user should be able to view on Account Level Details Page$")
	public void user_should_be_able_to_view_on_Account_Level_Details_Page() {
		patientPage.clickPatientTab();
	}

	@When("^user clicks on Patient tab$")
	public void user_clicks_on_Patient_tab() {
		patientPage.clickPatientTab();
	}

	@When("^user clicks on checkout button$")
	public void user_clicks_on_checkout_button() {	
		r1AccessCommonMethod.checkOut();			   
	}

	@When("^user clicks on edit button$")
	public void user_clicks_on_edit_button() {
		patientPage.clickOnGurantorEditLinkButton();
		patientPage.updateGurantorFirstName();	   
	}

	@Then("^user should be able to modify fields$")
	public void user_should_be_able_to_modify_fields() {
		patientPage.updateGurantorLastName();
	}
	
	@When("^user clicks on gurantorupdate button$")
	public void user_clicks_on_gurantorupdate_button() {
		patientPage.clickOngurantorUpdate();
	}

	@When("^user clicks on update button$")
	public void user_clicks_on_update_button() {
		patientPage.clickOnPatientUpdate();   
	}

	@Then("^user should be able to view the popup containing message \"([^\"]*)\" with ok and cancel button$")
	public void user_should_be_able_to_view_the_popup_containing_message_with_ok_and_cancel_button(String arg1) {
		//patientPage.verifyGurantorConfirmMessage();
		patientPage.AlertMessage();
		patientPage.clickPatientTab();
		r1AccessCommonMethod.checkOut();
		
		//patientPage.clickOngurantorCancel();
	}

	@When("^user clicks on ok button$")
	public void user_clicks_on_ok_button() {
		//patientPage.clickOngurantorOK();
		//patientPage.clickPatientTab();
	  //  r1AccessCommonMethod.clickOnCheckOut();
		patientPage.clickOnGurantorEditLinkButton();		
	}

	@Then("^user should be able to view updated values$")
	public void user_should_be_able_to_view_updated_values() {
		patientPage.verifyGurantorUpdatedFirstNameLastName();
	}

	@When("^user clicks on delete button$")
	public void user_clicks_on_delete_button() {
		patientPage.clickOnGurantorDeleteLinkButton();
	}

	@When("^user run the query and fetch the encounteridTwo$")
	public void user_run_the_query_and_fetch_the_encounteridTwo() throws ClassNotFoundException, IOException, SQLException {
		patientPage.getPatientCritical();
	}

	@Then("^user should be able to view and clear the fields Address City Zip\\.$")
	public void user_should_be_able_to_view_and_clear_the_fields_Address_City_Zip() {
		patientPage.ClearAddressCityZip();
	}

	@Then("^user should be able to view Update Patient Record\\? checkbox with unchecked state$")
	public void user_should_be_able_to_view_Update_Patient_Record_checkbox_with_unchecked_state() {
		r1AccessCommonMethod.checkOut();
	}

	@When("^user checked on checkbox$")
	public void user_checked_on_checkbox() {
		patientPage.clickOnUpdateCheckBox();
	}	  

	@Then("^user should be able to view the critical message \"([^\"]*)\"$")
	public void user_should_be_able_to_view_the_critical_message(String arg1) {
		patientPage.verifyPatientExceptionMesssage();
	}

	@When("^user clicks on complete button$")
	public void user_clicks_on_complete_button() {
		
		r1AccessCommonMethod.clickActionStatusTab("Complete");
	}

	@Then("^user should be able to view message \"([^\"]*)\"$")
	public void user_should_be_able_to_view_message(String arg1) {
		patientPage.verifyCriticalExceptionMesssage();
	}

	@When("^user run the query and fetch the encounteridThree$")
	public void user_run_the_query_and_fetch_the_encounteridThree() {
	  
	}

	@Then("^user should be able to view message \"([^\"]*)\" with ok and cancel button$")
	public void user_should_be_able_to_view_message_with_ok_and_cancel_button(String arg1) {
		
	}

//	@When("^user clicks on cancel button$")
//	public void user_clicks_on_cancel_button() {
//	   
//	}

	@Then("^user should able to view the incomplete state of account$")
	public void user_should_able_to_view_the_incomplete_state_of_account() {
		patientPage.verifyIncompleteStatus();
	}
	
	@Then("^user should able to view the complete state of account$")
	public void user_should_able_to_view_the_complete_state_of_account() {
		patientPage.verifyCompleteStatus();
	}

	@When("^user run the query and fetch the encounteridFour$")
	public void user_run_the_query_and_fetch_the_encounteridFour() {
	   
	}

	@Then("^user should be able view patient tab color as red$")
	public void user_should_be_able_view_patient_tab_color_as_red() {
		patientPage.verifyPatientTabcolor();
	}

	@Then("^user should be able to patient tab color as red$")
	public void user_should_be_able_to_patient_tab_color_as_red() {
		patientPage.verifyPatientTabcolor();
	}

	@When("^user run the query and fetch the encounteridFifth$")
	public void user_run_the_query_and_fetch_the_encounteridFifth() throws ClassNotFoundException, IOException, SQLException{
		patientPage.getPatientGuranorAccount();
	}

	@Then("^user should be able to clicks on checkout button$")
	public void user_should_be_able_to_clicks_on_checkout_button() {
		r1AccessCommonMethod.clickOnCheckOut();
	}
//@393733
	@Then("^user should be able to view patient details$")
	public void user_should_be_able_to_view_patient_details() {
		patientPage.verifyPatientDetails();
	}

	@Then("^user verify the patient tab color$")
	public void user_verify_the_patient_tab_color() {
		patientPage.verifyPatientTabcolor();
		patientPage.verifyIncompleteStatus();
	}
	//////////
	@Given("^User is on Account Worklist Page$")
	public void user_is_on_Account_Worklist_Page() {
	   
	}

	@When("^user run the query and fetch the encounterid$")
	public void user_run_the_query_and_fetch_the_encounterid() {
	   
	}

	@Then("^user should able to view encounterid$")
	public void user_should_able_to_view_encounterid() {
	  
	}

}
