package r1.steps.definitions;

import java.io.IOException;
import java.sql.SQLException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.pages.Navigation;
import r1.pages.UserLogin;
import r1.pages.PatientPage;
import r1.commons.R1AccessCommonMethods;
import r1.commons.utilities.CommonMethods;
import java.io.FileNotFoundException;
import r1.commons.databaseconnection.DatabaseConn;

public class PatientStepDef {

	Navigation navigation;
	UserLogin userLogin;
	PatientPage patientPage;
	R1AccessCommonMethods r1AccessCommonMethod;
	String userName, encCounter;

	@When("^user clicks on search button of menu$")
	public void user_clicks_on_search_button_of_menu() {
		patientPage.clickOnSearch();
	}

	@When("^user enter encounterid in search textbox$")
	public void user_enter_encounterid_in_search_textbox() {
		patientPage.enterVisitTextBox(encCounter);
	}

	@When("^user clicks on submit button$")
	public void user_clicks_on_submit_button() {
		patientPage.clickOnSearchButton();
	}

	@Then("^user should be able to view on Account Level Details Page$")
	public void user_should_be_able_to_view_on_Account_Level_Details_Page() {
		patientPage.verifyPatientCheckBox();
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
		patientPage.clickSkipTraceOk();
		patientPage.clickPatientTabInner();
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

	@Then("^user should be able to view and clear the fields Address City Zip\\.$")
	public void user_should_be_able_to_view_and_clear_the_fields_Address_City_Zip() {
		patientPage.ClearAddressCityZip();
	}

	@When("^user checked on checkbox$")
	public void user_checked_on_checkbox() {
		patientPage.clickCheckUpdate();
	}

	@Then("^user should be able to view the critical message \"([^\"]*)\"$")
	public void user_should_be_able_to_view_the_critical_message(String message) {
		patientPage.verifyPatientExceptionMesssage(message);
	}

	@When("^user clicks on complete button$")
	public void user_clicks_on_complete_button() {
		r1AccessCommonMethod.clickActionStatusTab("Complete");
	}

	@Then("^user should be able to view message \"([^\"]*)\"$")
	public void user_should_be_able_to_view_message(String message) {
		patientPage.verifyCriticalExceptionMesssage(message);
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

	@Then("^user should be able to clicks on checkout button$")
	public void user_should_be_able_to_clicks_on_checkout_button() {
		r1AccessCommonMethod.clickOnCheckOut();
	}

	@Then("^user verify the patient tab color$")
	public void user_verify_the_patient_tab_color() {
		patientPage.verifyPatientTabcolor();
		patientPage.verifyIncompleteStatus();
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
		patientPage.clickSkipTraceOk();
	}

	@Then("^user should be able to view address grid$")
	public void user_should_be_able_to_view_address_grid() {
		patientPage.verifySkipLastName();
	}

	@When("^user click lastname link of grid$")
	public void user_click_lastname_link_of_grid() {
		patientPage.clickSkipLastName();
	}

	@Then("^user should be able to view lastname updated address$")
	public void user_should_be_able_to_view_lastname_updated_address() {
		patientPage.clickPatientTabInner();
		patientPage.verifySkipGridAddress();
	}

	@Then("^Then user should not able to view Gurantor tab;$")
	public void then_user_should_not_able_to_view_Gurantor_tab() {
		patientPage.verifyGurantorTab();
	}

	@Then("^user should be able to view skip and skip date button$")
	public void user_should_be_able_to_view_skip_and_skip_date_button() {
		patientPage.verifySkipTraceButton();
	}

	@Then("^user enter invalid address city and zip$")
	public void user_enter_invalid_address_city_and_zip() {
		patientPage.EnterInvalidAddress();
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
	public void then_new_page_should_get_opened_with_blank_required_fields()
			throws ClassNotFoundException, IOException, SQLException {
		patientPage.verifyNewPatientFields();
	}

	@Then("^new account should be created$")
	public void new_account_should_be_created() {
		patientPage.verifyPatientCheckBox();
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
		patientPage.clickPatientTabInner();
	}

	@When("^user make changes against the SSN field but not adding any other digits$")
	public void user_make_changes_against_the_SSN_field_but_not_adding_any_other_digits() {
		patientPage.modifySNNumber();
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

	@Then("^Patient Tab turn into Blue$")
	public void patient_Tab_turn_into_Blue() {
		patientPage.verifyCompleteStatus();
	}

	@Then("^Value of SSN should get updated$")
	public void value_of_SSN_should_get_updated() {
		patientPage.verifySSN();
	}

	@When("^user enter invalid address in mandatory fields$")
	public void user_enter_invalid_address_in_mandatory_fields() {
		patientPage.EnterInvalidAddress();
	}

	@When("^clicks on Update button$")
	public void clicks_on_Update_button() {
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

	@Then("^Exceptions Exist - Are you sure you want to mark the task complete\\? With Continue & Cancel button should display$")
	public void exceptions_Exist_Are_you_sure_you_want_to_mark_the_task_complete_With_Continue_Cancel_button_should_display()
			throws ClassNotFoundException, IOException, SQLException {
		patientPage.verifySoftException();
	}

	@When("^user clicks on Continue button$")
	public void user_clicks_on_Continue_button() {
		patientPage.clickContinueutton();
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

	@Then("^user should be able to view skip button with date$")
	public void user_should_be_able_to_view_skip_button_with_date() {
		patientPage.verifySkipTraceWithDate();
	}

	@When("^user clicks on skip show trace button$")
	public void user_clicks_on_skip_show_trace_button() {
		patientPage.clickOnShowTrace();
	}

	@Then("^use should be able to address$")
	public void use_should_be_able_to_address() {
		patientPage.verifyBadAddress();
	}

	@Then("^use should be verify complete status$")
	public void use_should_be_verify_complete_status() {
		patientPage.verifyActionlogComplete();
	}

	@Then("^Patient Tab not load$")
	public void patient_Tab_not_load() {
		patientPage.verifyPatientTab();
	}

	@When("^user clicks on Setting link$")
	public void user_clicks_on_Setting_link() {
		r1AccessCommonMethod.clickFooterR1AccesModulesTab("Settings");
	}

	@When("^user clicks on user managment of IT Tools$")
	public void user_clicks_on_user_managment_of_IT_Tools() {
		r1AccessCommonMethod.clickSubSideR1HubModulesMenuLink("IT Tools");
	}

	@When("^user clicks on ARSupervisor CheckBoxs$")
	public void user_clicks_on_ARSupervisor_CheckBoxs() throws InterruptedException, IOException {

		userName = CommonMethods.loadProperties("username").trim();
		r1AccessCommonMethod.setUserRoles("Username", userName, "PA Supervisor", true);
	}

	@Then("^user should be able to view cancelled checkbox in disableState mode$")
	public void user_should_be_able_to_view_cancelled_checkbox_in_disableState_mode() {
		patientPage.VerifyCancelCheckBox();
	}

	@When("^user enter encounterid in search textbox(\\d+)$")
	public void user_enter_encounterid_in_search_textbox(int arg1) {
		patientPage.entersSearchText();
	}

	@When("^user clicks on ARSupervisor CheckBoxs for disable Role$")
	public void user_clicks_on_ARSupervisor_CheckBoxs_for_disable_Role() throws InterruptedException, IOException {
		userName = CommonMethods.loadProperties("username").trim();
		r1AccessCommonMethod.setUserRoles("Username", userName, "PA Supervisor", false);
	}

	@Then("^user should be able to view and alter the SSN Address$")
	public void user_should_be_able_to_view_and_alter_the_SSN_Address()
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		patientPage.AlterSSNAddressCityZip();
	}

	@When("^user runs the query \"([^\"]*)\" for patient details$")
	public void user_runs_the_query_for_patient_details(String query)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		patientPage.runQueryTran(query);
		DatabaseConn.resultSet.next();
		encCounter = DatabaseConn.resultSet.getString("encounterid");
	}

	@Then("^user should be able to clicks on checkout button by run query \"([^\"]*)\"$")
	public void user_should_be_able_to_clicks_on_checkout_button_by_run_query(String query)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		patientPage.getPatientAdmitDischargeDateStatus(query, encCounter);
	}	

	public void user_runs_the_query_for_patient_details_for_facility(String query, String Facility) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		patientPage.runQueryTranForFacility(query,Facility);
		DatabaseConn.resultSet.next();
		encCounter = DatabaseConn.resultSet.getString("encounterid");
	}

}
