package r1.steps.definitions;

import java.io.IOException;
import java.sql.SQLException;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.pages.Navigation;
import r1.pages.PFAPage;
import r1.pages.UserLogin;
import r1.serenity.steps.PFASteps;

public class PFAStepDef extends BasePage {

	PFAPage pfaPage;
	PFASteps pfaSteps;
	UserLogin userLogin;
	Navigation navigation;
	R1AccessCommonMethods r1AccessCommonMethods;
	String encounterId, eId, visitNo;

	@Then("^\"([^\"]*)\" tab color should be visible \"([^\"]*)\"$")
	public void tab_color_should_be_visible(String moduleTab, String color) {
		pfaPage.verifyTabColorAndStatus(moduleTab, color);

	}

	@When("^user clicks on \"([^\"]*)\" tab$")
	public void user_clicks_on_tab(String tab) {
		r1AccessCommonMethods.clickR1AccesModulesTab(tab);
	}

	@When("^check out the account$")
	public void check_out_the_account() {
		r1AccessCommonMethods.clickOnCheckOut();
	}

	@When("^user run the query and fetch \"([^\"]*)\"$")
	public void user_run_the_query_and_fetch(String col) throws ClassNotFoundException, SQLException, IOException {
		pfaPage.fetchPayorCode(col);
	}

	@When("^add coverage by click on plus button$")
	public void add_coverage_by_click_on_plus_button() throws InterruptedException {
		pfaPage.DelAllCoverage();
		pfaPage.clickAddCoverageButton();
	}

	@When("^user enters the payor code in search text box$")
	public void user_enters_the_payor_code_in_search_text_box() {
		pfaPage.enterPayorCode();
	}

	@When("^user clicks on find button$")
	public void user_clicks_on_find_button() {
		pfaPage.clickFindPayorButton();
	}

	@When("^user select plan code from search result grid$")
	public void user_select_plan_code_from_search_result_grid() {
		pfaPage.selectPlanCodeResultGrid();
	}

	@When("^click on Add button$")
	public void click_on_Add_button() {
		pfaPage.clickPayorAddButton();
	}

	@When("^user changes coverage status as \"([^\"]*)\" in verified column$")
	public void user_changes_coverage_status_as_in_verified_column(String status) {
		pfaPage.verifyPlanCodeCoverageTable(status);
		pfaPage.selectVerificationStatus();
		pfaPage.clickUpdateButton();
	}

	@Then("^status should be \"([^\"]*)\" appear$")
	public void status_should_be_appear(String status) {
		pfaPage.verifyTabStatus(status);

	}

	@When("^user fetch the \"([^\"]*)\" from Query PFA_418876_SQL1$")
	public void user_fetch_the_from_Query_PFA_418876_SQL1(String col)
			throws ClassNotFoundException, SQLException, IOException {
		encounterId = pfaSteps.getEncounterdIDForResident(col);
	}

	@When("^user enters the encounterid in visit Text field$")
	public void user_enters_the_encounterid_in_visit_Text_field() {
		pfaPage.enterEncounterID(encounterId);
	}

	@Then("^default answer Other should be select for \"([^\"]*)\"$")
	public void default_answer_Other_should_be_select_for(String ques) {
		pfaPage.verifyDefaultAnswerForResident(ques);
	}

	@When("^user fetch the \"([^\"]*)\" from Query PFA_419018_SQL1$")
	public void user_fetch_the_from_Query_PFA_419018_SQL1(String col)
			throws ClassNotFoundException, SQLException, IOException {
		encounterId = pfaSteps.getEncounterdIDAgeLessThanEighteen(col);
	}

	@Then("^there should be no answer selected as default$")
	public void there_should_be_no_answer_selected_as_default() {
		pfaPage.VAHealthCareSystem();

	}

	@When("^user fetch the \"([^\"]*)\" from Query PFA_419018_SQL2$")
	public void user_fetch_the_from_Query_PFA_419018_SQL2(String col)
			throws ClassNotFoundException, SQLException, IOException {
		encounterId = pfaSteps.getEncounterdIDAgeGreaterThanEighteen(col);
	}

	@When("^user fill all the L1 Screening Questions$")
	public void user_fill_all_the_L1_Screening_Questions() {
		pfaPage.verifyScreeningQuestionTab();
	}

	@When("^user clicks on Clear Answers button$")
	public void user_clicks_on_Clear_Answers_button() {
		pfaPage.clickClearAnswers();
	}

	@Then("^all selected answers should be clear appear$")
	public void all_selected_answers_should_be_clear_appear() throws InterruptedException {
		Thread.sleep(4000);
		pfaPage.verifyAnswersSelected();
	}

	@Then("^First question Did the patient decline the screening questionnaire answer should be by deafult \"([^\"]*)\" selected$")
	public void first_question_Did_the_patient_decline_the_screening_questionnaire_answer_should_be_by_deafult_selected(
			String status) {
		pfaPage.verifyScreeningQuesDeclined(status);

	}

	@When("^user clicks on Action Items tab$")
	public void user_clicks_on_Action_Items_tab() throws InterruptedException {
		pfaPage.clickActionItemsTab();

	}

	@When("^user select one or more checkboxes under column Completed corresponding to the funding source$")
	public void user_select_one_or_more_checkboxes_under_column_Completed_corresponding_to_the_funding_source() throws InterruptedException {
		pfaPage.checkActionBox();

	}

	@Then("^FollowUp Date should get appeared with every selection$")
	public void followup_Date_should_get_appeared_with_every_selection() {
		pfaPage.getFollowUpDate();

	}

	@Then("^user clicks on save button after addding action items$")
	public void user_clicks_on_save_button_after_addding_action_items() {
		pfaPage.clickSaveActionItems();

	}

	@Then("^Action should get saved with message \"([^\"]*)\"$")
	public void action_should_get_saved_with_message(String message) {

		pfaPage.verifyUpdateActionMessage(message);

	}

	@Given("^user clicks on Settings link$")
	public void user_clicks_on_Settings_link() {
		r1AccessCommonMethods.clickFooterR1AccesModulesTab("Settings");

	}

	@Given("^user clicks on PFA Configuration link$")
	public void user_clicks_on_PFA_Configuration_link() {
		r1AccessCommonMethods.clickSubSideR1HubModulesMenuLink("PFA Configuration");
	}

	@Given("^user clicks on PFA Level_1 Questions link$")
	public void user_clicks_on_PFA_Level_1_Questions_link() {
		r1AccessCommonMethods.clickSubSideR1HubModulesMenuLink("PFA Level 1 Questions");
	}

	@When("^user clicks on New button$")
	public void user_clicks_on_New_button() {
		r1AccessCommonMethods.clickUpperHeaderLink("New");
	}

	@When("^Input values in the Question Code \"([^\"]*)\" and Question \"([^\"]*)\" fields$")
	public void input_values_in_the_Question_Code_and_Question_fields(String code, String question) {
		pfaPage.inputPFAQues(code, question);
	}

	@When("^user clicks on is Active check box$")
	public void user_clicks_on_is_Active_check_box() {
		pfaPage.clickIsActiveQuesChkbox();
	}

	@When("^user clicks Add button$")
	public void user_clicks_Add_button() {
		pfaPage.addQuestion();
	}

	@Then("^PFA Level1 question should be created with message \"([^\"]*)\"$")
	public void pfa_Level_question_should_be_created_with_message(String mesg) {
		pfaPage.verifyQuesAddedLabel(mesg);
	}

	@When("^user clicks on New Answer button$")
	public void user_clicks_on_New_Answer_button() {
		pfaPage.clickNewAns();
	}

	@When("^user input values in the Answer Code \"([^\"]*)\" and Answer Text \"([^\"]*)\" fields$")
	public void user_input_values_in_the_Answer_Code_and_Answer_Text_fields(String code, String ans) {
		pfaPage.inputAns(code, ans);
	}

	@When("^user clicks on Cancel button\\.$")
	public void user_clicks_on_Cancel_button() {
		pfaPage.clickcancelAns();
	}

	@When("^user clicks on is Active Check box$")
	public void user_clicks_on_is_Active_Check_box() {
		pfaPage.clickIsActiveAnsChkbox();
	}

	@Then("^PFA answers panel should not be appear$")
	public void pfa_answers_panel_should_not_be_appear() {
		pfaPage.verifyPFAAnsPanel();
	}

	@When("^user clicks on Add Answer button\\.$")
	public void user_clicks_on_Add_Answer_button() {
		pfaPage.clickAddAns();
	}

	@Then("^new answer should be added in the answers grid with message \"([^\"]*)\"$")
	public void new_answer_should_be_added_in_the_answers_grid_with_message(String msg) {
		pfaPage.verifyAnsLabelAdded(msg);
	}

	@When("^user clicks on Link Answer button$")
	public void user_clicks_on_Link_Answer_button() {
		pfaPage.clickLinkAns();
	}

	@When("^user clicks on cancel link answer button\\.$")
	public void user_clicks_on_cancel_link_answer_button() {
		pfaPage.clickCancelLinkAns();
	}

	@Then("^Answer dropdown list, Link New Answer button and Cancel button should not be appear\\.$")
	public void answer_dropdown_list_Link_New_Answer_button_and_Cancel_button_should_not_be_appear() {
		pfaPage.verifyFieldsNotVisible();
	}

	@When("^user select an created answer from dropdown$")
	public void user_select_an_created_answer_from_dropdown() {
		pfaPage.selectCreatedAns();
	}

	@When("^user clicks on Link new Answer button\\.$")
	public void user_clicks_on_Link_new_Answer_button() {
		pfaPage.clickLinkNewAns();
	}

	@Then("^displays added answer in the answers grid placed under Update button$")
	public void displays_added_answer_in_the_answers_grid_placed_under_Update_button() {
		pfaPage.verifyAnsAdded();
	}

	@Then("^message \"([^\"]*)\" appear$")
	public void message_appear(String msg) {
		pfaPage.verifyAnsAddedMessage(msg);
	}

	@When("^user clicks on Unlink Answer button$")
	public void user_clicks_on_Unlink_Answer_button() {
		pfaPage.clickUnlinkAns();
	}

	@When("^user select an answer from dropdown$")
	public void user_select_an_answer_from_dropdown() {
		pfaPage.selectAnstoUnlink();
	}

	@When("^user clicks on Unlink Existing Answer button\\.$")
	public void user_clicks_on_Unlink_Existing_Answer_button() {
		pfaPage.clickUnlinkExistingAns();
	}

	@Then("^message \"([^\"]*)\" appear for the question should be appear$")
	public void message_appear_for_the_question_should_be_appear(String msg) {
		pfaPage.verifyAnsUnlinked(msg);
	}

	@Then("^answer should not be appear in answer grid under Update button$")
	public void answer_should_not_be_appear_in_answer_grid_under_Update_button() {
		pfaPage.verifyAnsRemoved();
	}

	@When("^user clicks on R1 detect worklist$")
	public void user_clicks_on_R_detect_worklist() {
		r1AccessCommonMethods.clickSubSideR1HubModulesMenuLink("R1 Detect");
	}

	@When("^user fetch the encounterid from Query PFA_419028_SQL10$")
	public void user_fetch_the_encounterid_from_Query_PFA_SQL10()
			throws ClassNotFoundException, IOException, SQLException {
		eId = pfaPage.getEncounterIdFor_PFA_419028_SQL10();
	}

	@When("^user fetch the encounterid from Query PFA_419029_SQL11$")
	public void user_fetch_the_encounterid_from_Query_PFA_SQL11()
			throws ClassNotFoundException, IOException, SQLException {
		eId = pfaPage.getEncounterIdFor_PFA_419029_SQL11();
	}

	@When("^user fetch the encounterid from Query PFA_419030_SQL12$")
	public void user_fetch_the_encounterid_from_Query_PFA_SQL12()
			throws ClassNotFoundException, IOException, SQLException {
		eId = pfaPage.getEncounterIdFor_PFA_419030_SQL12();
	}

	@When("^user clicks on SEARCH link$")
	public void user_clicks_on_SEARCH_link() {
		r1AccessCommonMethods.clickUpperHeaderLink("Search");
	}

	@When("^enters the encounterid in visit Text field$")
	public void enters_the_encounterid_in_visit_Text_field() {
		r1AccessCommonMethods.enterVisitNumber(eId);
	}

	@When("^user clicks on Search button$")
	public void user_clicks_on_Search_button() {
		r1AccessCommonMethods.clickOnSearchButton();
	}

	@Then("^Default answer should be No selected for question \"([^\"]*)\" on L1Screening Questions tab$")
	public void default_answer_should_be_No_selected_for_question_on_L_Screening_Questions_tab(String ques) {
		pfaPage.verifyAnsweForPregnancy(ques);
	}

	@Then("^no answer is selected for the question \"([^\"]*)\" on L1Screening Questions tab$")
	public void no_answer_is_selected_for_the_question_on_L1_Screening_Questions_tab(String ques) {
		pfaPage.verifyNoAnswerSelectedforPregnancy(ques);
	}

	@When("^user clicks on override tab$")
	public void user_clicks_on_override_tab() {
		r1AccessCommonMethods.checkOut();
		pfaPage.clickOverrideTab();
		visitNo = pfaPage.currentWorkingAccount();
	}

	@When("^user verify FollowUp Date field$")
	public void user_verify_FollowUp_Date_field() {
		pfaPage.verifyFollowUpLabel();
	}

	@Then("^Displays Date picker for Follow up date$")
	public void displays_Date_picker_for_Follow_up_date() {
		pfaPage.verifyDatePicker();
	}

	@Then("^should display autofill Followup date in disabled textbox$")
	public void should_display_autofill_Followup_date_in_disabled_textbox() {
		pfaPage.verifyFollowUpDateTextBox();
	}

	@When("^user clicks on save button without inserting any values$")
	public void user_clicks_on_save_button_without_inserting_any_values() {
		pfaPage.clicksaveCWLButton();
	}

	@Then("^message should be displays \"([^\"]*)\"$")
	public void message_should_be_displays(String msg) {
		pfaPage.verifyCWLErrorMsg(msg);
	}

	@When("^user select value from funding sources dropdown$")
	public void user_select_value_from_funding_sources_dropdown() {
		pfaPage.selectFundingSource();
	}

	@When("^user select value from Action dropdown$")
	public void user_select_value_from_Action_dropdown() throws InterruptedException {
		pfaPage.selectAction();
	}

	@When("^user clicks on checkbox$")
	public void user_clicks_on_checkbox() {
		pfaPage.checkConfirmChkbox();
	}

	@When("^user enters text in text box$")
	public void user_enters_text_in_text_box() {
		pfaPage.enterText();
	}

	@When("^user clicks on save button$")
	public void user_clicks_on_save_button() {
		pfaPage.clicksaveCWLButton();
	}

	@Then("^message should be displayed \"([^\"]*)\"$")
	public void message_should_be_displayed(String msg) {
		pfaPage.verifyRecordAdded(msg);
	}

	@Then("^PFA tab turns blue appear with Completed status$")
	public void pfa_tab_turns_blue_appear_with_Completed_status() {
		pfaPage.verifyTabCompleted();
	}

	@When("^user clicks on the Patient Access link$")
	public void user_clicks_on_the_Patient_Access_link() {
		r1AccessCommonMethods.clickFooterR1AccesModulesTab("Patient Access");
	}

	@When("^user clicks on Conversion Followup worklist$")
	public void user_clicks_on_Conversion_Followup_worklist() {
		r1AccessCommonMethods.clickSubSideR1HubModulesMenuLink("Conversion Followup");
	}

	@When("^user select the value Account operator = from filter dropdown and enter encounter id in text box and click filter$")
	public void user_select_the_value_Account_operator_from_filter_dropdown_and_enter_encounter_id_in_text_box() {
		r1AccessCommonMethods.ddlWorkListFilter("Account", "=", visitNo);
	}

	@Then("^account should be displayed in Conversion Follow up worklist with the above assigned funding source$")
	public void account_should_be_displayed_in_Conversion_Follow_up_worklist_with_the_above_assigned_funding_source() {
		pfaPage.verifyAccountinCWLWrklst();
	}

	@When("^user clicks on Unworked subfolder$")
	public void user_clicks_on_Unworked_subfolder() {
		pfaPage.clickUnworkedSubfolder();
	}

	@When("^user open an account from unworked subfolder worklist$")
	public void user_open_an_account_from_unworked_subfolder_worklist() {
		r1AccessCommonMethods.clickOnUnassignedAccount();
	}

	@When("^user clicks on save and continue button$")
	public void user_clicks_on_save_and_continue_button() {
		pfaPage.clickSaveAndContBtn();
	}

	@Then("^user should be navigate to Screening Needs tab$")
	public void user_should_be_navigate_to_Screening_Needs_tab() {
		pfaPage.verifyActiveTab();
	}

	@Then("^multiple funding source should be displayed\\.$")
	public void multiple_funding_source_should_be_displayed() {
		pfaPage.verifyMultipleFundngSrc();
	}

	@When("^user clicks on Self Pay L2 in Process or Insured L2 in Process subfolder$")
	public void user_clicks_on_Self_Pay_L_in_Process_or_Insured_L_in_Process_subfolder() {
		pfaPage.clickSelfPaySubFolder();
	}

	@When("^user open an account from subfolder worklist$")
	public void user_open_an_account_from_subfolder_worklist() {
		r1AccessCommonMethods.clickOnUnassignedAccount();
	}

	@When("^user clicks check out button$")
	public void user_clicks_check_out_button() {
		r1AccessCommonMethods.checkOut();
	}

	@When("^user clicks on screening needs tab$")
	public void user_clicks_on_screening_needs_tab() {
		pfaPage.clickScreeningNeedsTab();
	}

	@When("^user enter the number of persons in the household$")
	public void user_enter_the_number_of_persons_in_the_household() {
		pfaPage.enterNoOfPersonInHousehold();
	}

	@When("^user select the patient employment status$")
	public void user_select_the_patient_employment_status() {
		pfaPage.selectEmpStatus();
	}

	@When("^user clicks on Submit all FS button$")
	public void user_clicks_on_Submit_all_FS_button() {
		pfaPage.clickSubmitAllBtn();
	}

	@Then("^Common Data Needs bar colour should be GREEN$")
	public void common_Data_Needs_bar_colour_should_be_GREEN() {
		pfaPage.verifycommonDataNeedsTabGreen();
	}

	@Then("^selected employement status check box should be checked appear$")
	public void selected_employement_status_check_box_should_be_checked_appear() {
		pfaPage.verifyEmploymentStatusAsFull();
	}

	@Then("^selected employement status check box should be checked$")
	public void selected_employement_status_check_box_should_be_checked() {
		pfaPage.clickScreeningNeedsTab();
		pfaPage.verifyEmploymentStatusAsFull();
	}

	@When("^Validate answer \"([^\"]*)\" for question Did the patient decline the screening questionnaire$")
	public void validate_answer_for_question_Did_the_patient_decline_the_screening_questionnaire(String status) {
		pfaPage.verifyScreeningQuesDeclined(status);
	}

	@Then("^all the answers should be enabled appear on Screening Questions tab$")
	public void all_the_answers_should_be_enabled_appear_on_Screening_Questions_tab() {
		pfaPage.verifyAnswersDisabledOrEnabled();
	}

	@When("^user select the yes check box for question Did the patient decline the screening questionnaire$")
	public void user_select_the_yes_check_box_for_question_Did_the_patient_decline_the_screening_questionnaire() {
		pfaPage.clickYesForScreeningQuestionnaire();
	}

	@Then("^all the answers should be disabled appear on Screening Questions tab$")
	public void all_the_answers_should_be_disabled_appear_on_Screening_Questions_tab() {
		pfaPage.verifyAnswersDisabledOrEnabled();
	}

}
