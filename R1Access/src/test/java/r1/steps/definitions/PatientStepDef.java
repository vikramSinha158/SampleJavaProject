package r1.steps.definitions;

import java.io.IOException;
import java.sql.SQLException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.pages.Navigation;
import r1.pages.UserLogin;
import r1.pages.PatientPage;
import r1.commons.R1AccessCommonMethods;
import r1.commons.BasePage;

public class PatientStepDef extends BasePage {

	Navigation navigation;
	UserLogin userLogin;
	PatientPage patientPage;
	R1AccessCommonMethods r1AccessCommonMethod;

	@When("^user clicks on Patient Access link$")
	public void user_clicks_on_Patient_Access_link() {
		r1AccessCommonMethod.clickR1HubModulesMenuLink("Patient Access");
	}
	@When("^user clicks on Pre-Registration$")
	public void user_clicks_on_Pre_Registration() {
		r1AccessCommonMethod.clickSubSideR1HubModulesMenuLink("Pre-Registration");
	}	
	@When("^user run the query and fetch the encounteridOne$")
	public void user_run_the_query_and_fetch_the_encounteridOne()
			throws ClassNotFoundException, IOException, SQLException {
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
		patientPage.verifyPatientCheckBox();
	}
	@When("^user clicks on Patient tab$")
	public void user_clicks_on_Patient_tab() {
		patientPage.clickPatientTab();
	}
	@When("^user clicks on checkout button$")
	public void user_clicks_on_checkout_button() throws InterruptedException {
		r1AccessCommonMethod.checkOut();
		Thread.sleep(10000);
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
		patientPage.AlertMessage();
		patientPage.clickPatientTab();
		r1AccessCommonMethod.checkOut();
	}
	@When("^user clicks on ok button$")
	public void user_clicks_on_ok_button() {
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
	public void user_run_the_query_and_fetch_the_encounteridTwo()
			throws ClassNotFoundException, IOException, SQLException {
		patientPage.getPatientCritical();
	}
	@Then("^user should be able to view and clear the fields Address City Zip\\.$")
	public void user_should_be_able_to_view_and_clear_the_fields_Address_City_Zip() {
		patientPage.ClearAddressCityZip();
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
	@Then("^user should able to view the incomplete state of account$")
	public void user_should_able_to_view_the_incomplete_state_of_account() {
		patientPage.verifyIncompleteStatus();
	}
	@Then("^user should able to view the complete state of account$")
	public void user_should_able_to_view_the_complete_state_of_account() {
		patientPage.verifyCompleteStatus();
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
	public void user_run_the_query_and_fetch_the_encounteridFifth() throws ClassNotFoundException, IOException, SQLException {
		patientPage.getPatientGuranorAccount();
	}	
	@Then("^user should be able to clicks on checkout button$")
	public void user_should_be_able_to_clicks_on_checkout_button() {
		r1AccessCommonMethod.clickOnCheckOut();
	}
	@Then("^user should be able to view patient details$")
	public void user_should_be_able_to_view_patient_details() throws ClassNotFoundException, IOException, SQLException {
		patientPage.verifyPatientDetails();
		patientPage.getPatientAdmitDischargeDateStatus();
	}
	@Then("^user verify the patient tab color$")
	public void user_verify_the_patient_tab_color() {
		patientPage.verifyPatientTabcolor();
		patientPage.verifyIncompleteStatus();
	}
	@When("^user run the query and fetch the encounteridTen$")
	public void user_run_the_query_and_fetch_the_encounteridTen()
			throws ClassNotFoundException, IOException, SQLException {
		patientPage.getFdischargePatient();
	}
	@Then("^user should be able to view patient information$")
	public void user_should_be_able_to_view_patient_information() {
		patientPage.verifyPatientDetails();
	}
	@Then("^user should be able to view skip button$")
	public void user_should_be_able_to_view_skip_button() {
		patientPage.verifySkipTraceButton();
	}
	@When("^user clicks on skip button$")
	public void user_clicks_on_skip_button() {
		patientPage.clickSkipTraceButton();
	}
	@When("^user click on ok button$")
	public void user_click_on_ok_button() {
		patientPage.AlertMessage();
	}
	@Then("^user should be able to view address grid$")
	public void user_should_be_able_to_view_address_grid() {
		//patientPage.verifySkipLastName();
	}
	@When("^user click lastname link of grid$")
	public void user_click_lastname_link_of_grid() {
		patientPage.clickSkipLastName();
	}
	@Then("^user should be able to view lastname updated address$")
	public void user_should_be_able_to_view_lastname_updated_address() {
		patientPage.verifySkipGridAddress();
	}
	@Then("^Then user should not able to view Gurantor tab;$")
	public void then_user_should_not_able_to_view_Gurantor_tab() {
		patientPage.verifyGurantorTab();
	}	
	@When("^user run the query and fetch the encounterid for not discharge patient$")
	public void user_run_the_query_and_fetch_the_encounterid_for_not_discharge_patient() throws ClassNotFoundException, IOException, SQLException {
		patientPage.getFdischargePatient();
	}
	@Then("^user should be able to view skip and skip date button$")
	public void user_should_be_able_to_view_skip_and_skip_date_button() {
		patientPage.verifySkipTraceButton();
	}
	@Then("^user enter invalid address city and zip$")
	public void user_enter_invalid_address_city_and_zip() {
		patientPage.EnterInvalidAddress();
	}	
	@When("^user run the query and fetch the encounterid for discharge patient$")
	public void user_run_the_query_and_fetch_the_encounterid_for_discharge_pat() throws ClassNotFoundException, IOException, SQLException {
		patientPage.getFdischargePatient();
	}
	@When("^user clicks on New link$")
	public void user_clicks_on_New_link() throws ClassNotFoundException, IOException, SQLException {
		r1AccessCommonMethod.clickUpperHeaderLink("NEW");
	}
    @When("^user Add fill fields$")
    public void user_Add_fill_fields() throws ClassNotFoundException, IOException, SQLException {    	
    	patientPage.addPatient();  
    	patientPage.clickOnPatientUpdate();
    }
	@Then("^Then new page should get opened with blank required fields$")
	public void then_new_page_should_get_opened_with_blank_required_fields() throws ClassNotFoundException, IOException, SQLException {
		patientPage.verifyNewPatientFields();		
	}
	@Then("^new account should be created$")
	public void new_account_should_be_created() {
	  
	}	
	@When("^user run the query and fetch the encounterid for not having red tab$")
	public void user_run_the_query_and_fetch_the_encounterid_for_not_having_red_tab() throws ClassNotFoundException, IOException, SQLException {
		patientPage.getEncounteridPatientTabRed();
	}
	@When("^user clicks on the  checkout button$")
	public void user_clicks_on_the_checkout_button() {
		r1AccessCommonMethod.checkOut();
	}
	@Then("^Patient Visit and Address Panel should get displayed$")
	public void patient_Visit_and_Address_Panel_should_get_displayed() {
		patientPage.verifyPatientCheckBox();
	}
	@Then("^Status should be appear incomplete$")
	public void status_should_be_appear_incomplete() {
		patientPage.verifyIncompleteStatus();
	}
	@Then("^Patient tab color should be appear Red$")
	public void patient_tab_color_should_be_appear_Red() {
		patientPage.verifyPatientTabcolorRed();
	}
	@When("^user make changes against the SSN field by adding one or two more digits$")
	public void user_make_changes_against_the_SSN_field_by_adding_one_or_two_more_digits() {
		patientPage.addSNNumber();
	}
	@Then("^message should display as Invalid SSN at the bottom of the Patient Visit and Address Panel$")
	public void message_should_display_as_Invalid_SSN_at_the_bottom_of_the_Patient_Visit_and_Address_Panel() {
		patientPage.verifySSNMessaage();
	}	
	@When("^user clicks on the Patient tab$")
	public void user_clicks_on_the_Patient_tab() {
		patientPage.clickPatientTab();
	}
	@When("^user make changes against the SSN field but not adding any other digits$")
	public void user_make_changes_against_the_SSN_field_but_not_adding_any_other_digits() {
		patientPage.modifySNNumber();
	}
	@Then("^message should display  as SSN has changed at the bottom of the pannel$")
	public void message_should_display_as_SSN_has_changed_at_the_bottom_of_the_pannel() {	    
	}
	@Then("^Update Patient Record\\? With unchecked checkbox should display in front of Skip Trace button$")
	public void update_Patient_Record_With_unchecked_checkbox_should_display_in_front_of_Skip_Trace_button() {
		patientPage.verifySkipTraceButton();
	}
	@When("^user set the value as Checked for the Update Patient Record to checked$")
	public void user_set_the_value_as_Checked_for_the_Update_Patient_Record_to_checked() {
		patientPage.clickOnUpdateCheckBox();
	}
	@When("^user clicks on Update button$")
	public void user_clicks_on_Update_button() {
		patientPage.clickOnPatientUpdate();
	}
	@Then("^Value of SSN should be  updated$")
	public void value_of_SSN_should_be_updated() {
		patientPage.verifySSN();
	}
	@Then("^Record updated message should be displayed$")
	public void record_updated_message_should_be_displayed() {
	;
	}
	@Then("^Patient Tab turn into Blue$")
	public void patient_Tab_turn_into_Blue() {

	}
	@When("^user clicks on Log Tab$")
	public void user_clicks_on_Log_Tab() {
	
	}
	@Then("^user should be able to view the updated history$")
	public void user_should_be_able_to_view_the_updated_history() {
	
	}
	@When("^user clicks on any Account where the Traffic light of P column is Red$")
	public void user_clicks_on_any_Account_where_the_Traffic_light_of_P_column_is_Red()  throws ClassNotFoundException, IOException, SQLException {
	 	patientPage.getEncounteridPatientTabRed();
		patientPage.clickOnSearch();
		patientPage.entersSearchText();
		patientPage.clickOnSearchButton();		
	}
	@Then("^Status should display in the ribbon as Incomplete with Red color$")
	public void status_should_display_in_the_ribbon_as_Incomplete_with_Red_color() {
	
	}
	@When("^user update the exisiting SSN as Null$")
	public void user_update_the_exisiting_SSN_as_Null() {

	}
	@When("^user update the existing phone field as Null$")
	public void user_update_the_existing_phone_field_as_Null() {
	   
	}
	@Then("^message SSN has changed should display at the bottom of the panel$")
	public void message_SSN_has_changed_should_display_at_the_bottom_of_the_panel() {
	   
	}
	@Then("^Update Patient Records\\? checkbox with its value setted to Unchecked should display$")
	public void update_Patient_Records_checkbox_with_its_value_setted_to_Unchecked_should_display() {
	
	}
	@When("^user set the value as Checked for the Update Patient Record\\?$")
	public void user_set_the_value_as_Checked_for_the_Update_Patient_Record() {
	
	}
	@Then("^Value of SSN should get updated$")
	public void value_of_SSN_should_get_updated() {
		patientPage.verifySSN();
	}
	@Then("^user should be able to view Patient Phone Number is Missing\\.Please input Valid Phone Number in  exception Panel$")
	public void user_should_be_able_to_view_Patient_Phone_Number_is_Missing_Please_input_Valid_Phone_Number_in_exception_Panel() {
	
	}
	@When("^user update the Phone and SSN fields with correct values$")
	public void user_update_the_Phone_and_SSN_fields_with_correct_values() {
	   
	}
	@Then("^fields should get updated and exceptions should get removed$")
	public void fields_should_get_updated_and_exceptions_should_get_removed() {
	   
	}		
	//
	@When("^user clicks on any Account where the Traffic light of P column is Blue$")
	public void user_clicks_on_any_Account_where_the_Traffic_light_of_P_column_is_Blue()  throws ClassNotFoundException, IOException, SQLException { 
		patientPage.getEncounteridPatientTabBlue();
	}	
	@Then("^Patient Visit and Address Panel should be visible and details should be displayed$")
	public void patient_Visit_and_Address_Panel_should_be_visible_and_details_should_be_displayed() {
	   
	}

	@Then("^verify the Ribbon color it should get changed into Red color and Status should be displayed as Redo$")
	public void verify_the_Ribbon_color_it_should_get_changed_into_Red_color_and_Status_should_be_displayed_as_Redo() {
	   
	}

	@When("^user enter invalid address in mandatory fields$")
	public void user_enter_invalid_address_in_mandatory_fields() {
		patientPage.EnterInvalidAddress();
	}
	@When("^clicks on Update button$")
	public void clicks_on_Update_button() {		
		//patientPage.clickOnPatientUpdate();
		patientPage.clickCheckUpdate();
	}

	@Then("^display message Record Updated should visible at bottom left of Patient visit and Address Panel$")
	public void display_message_Record_Updated_should_visible_at_bottom_left_of_Patient_visit_and_Address_Panel() {
     patientPage.verifyRecordUpdated();
	}

	@When("^user clicks on Complete button$")
	public void user_clicks_on_Complete_button() {
		patientPage.clickCompleteButton();		
	}

	@Then("^Street Number Not Valid with exception should display in exception panel$")
	public void street_Number_Not_Valid_with_exception_should_display_in_exception_panel() {
		patientPage.verifyPatientExceptionMesssage();
	}

	@Then("^Exceptions Exist - Are you sure you want to mark the task complete\\? With Continue & Cancel button should display$")
	public void exceptions_Exist_Are_you_sure_you_want_to_mark_the_task_complete_With_Continue_Cancel_button_should_display() throws ClassNotFoundException, IOException, SQLException
	{	patientPage.verifySoftException();
	}

	@When("^user clicks on Continue button$")
	public void user_clicks_on_Continue_button() {
		patientPage.clickContinueutton();
	}

	@Then("^Tab gets completed and displays tab colour blue$")
	public void tab_gets_completed_and_displays_tab_colour_blue() {

	}

	@Then("^Status should be Completed$")
	public void status_should_be_Completed() {
	   
	}

	@When("^user clicks on the Patient Tab$")
	public void user_clicks_on_the_Patient_Tab() {
	 
	}

	@When("^Verify the Patient Visit and Address panel$")
	public void verify_the_Patient_Visit_and_Address_panel() {
	
	}

	@Then("^Upadetd address should display$")
	public void upadetd_address_should_display() {
	   
	}

	@Then("^Street Number Not Valid exception message should display in exception panel$")
	public void street_Number_Not_Valid_exception_message_should_display_in_exception_panel() {

	}

	@Then("^Tab will open$")
	public void tab_will_open() {

	}

	@Then("^Displays tab and ribbon color as  Blue and \"([^\"]*)\" should display as \"([^\"]*)\"$")
	public void displays_tab_and_ribbon_color_as_Blue_and_should_display_as(String arg1, String arg2) {
	  
	}

   

@Then("^Skip Trace  button should visible at bottom right of Patient visit and Address panel$")
public void skip_Trace_button_should_visible_at_bottom_right_of_Patient_visit_and_Address_panel() {
  
}

@Then("^Displays tab and ribbon color as  Blue and Status should display as Completed$")
public void displays_tab_and_ribbon_color_as_Blue_and_Status_should_display_as_Completed() {
   
}

//////


@When("^user run the query and fetch the encounterid for skip trace functionality on gurantor tab$")
public void user_run_the_query_and_fetch_the_encounterid_for_skip_trace_functionality_on_gurantor_tab() throws ClassNotFoundException, IOException, SQLException {
	
	patientPage.getEncounteridPatientSkipTraceGurantor();
}

@When("^uhen user clicks on Add gurantor button$")
public void uhen_user_clicks_on_Add_gurantor_button() {
	patientPage.clickAddGurantorButton();
}

@Then("^user should be able to add values$")
public void user_should_be_able_to_add_values() {

	patientPage.updateGurantorLastName();
}

@When("^uhen user clicks on update button$")
public void uhen_user_clicks_on_update_button() {
	patientPage.clickOngurantorUpdate();
}

@Then("^user should be able to updated values$")
public void user_should_be_able_to_updated_values() {

}

@When("^uhen user clicks on Edit button$")
public void uhen_user_clicks_on_Edit_button() {
  
}

@Then("^user should be able to update SSN number$")
public void user_should_be_able_to_update_SSN_number() {

}

@When("^user clicks on skip button of gurantor tab$")
public void user_clicks_on_skip_button_of_gurantor_tab() {
 
}

@When("^user run the query and fetch the encounterid for previously skip traced and not discharged$")
public void user_run_the_query_and_fetch_the_encounterid_for_previously_skip_traced_and_not_discharged()throws ClassNotFoundException, IOException, SQLException {
	patientPage.getEncounteridPatientSkipTraceNotDishcharge();
}

@Then("^user should be able to view skip button with date$")
public void user_should_be_able_to_view_skip_button_with_date() {
	patientPage.verifySkipTraceWithDate();
}
@When("^user clicks on skip show trace button$")
public void user_clicks_on_skip_show_trace_button() {
	patientPage.clickOnShowTrace();
}

@When("^user run the query and fetch the encounterid for previously skip traced and with greater then return days$")
public void user_run_the_query_and_fetch_the_encounterid_for_previously_skip_traced_and_with_greater_then_return_days()throws ClassNotFoundException, IOException, SQLException {
   
}
}
