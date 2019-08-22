package r1.steps.definitions;

import java.io.IOException;
import java.sql.SQLException;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.pages.CoveragePage;
import r1.pages.Navigation;
import r1.pages.UserLogin;
import r1.serenity.steps.CoverageSteps;

public class CoverageStepDef extends BasePage{
	
	CoveragePage coveragePage;
	UserLogin userLogin;
	Navigation navigation;
	CoverageSteps coverageSteps;

	@When("^user run the query and fetch the coverage \"([^\"]*)\"$")
	public void user_run_the_query_and_fetch_the_coverage(String arg1) throws ClassNotFoundException, SQLException, IOException {
		coveragePage.fetchEncounterId1();
	}

	@When("^user clicks on search tab$")
	public void user_clicks_on_search_tab() {
		coveragePage.clickSearchBtn();
	}

	@When("^user enters the fetched EncounterID into search textbox$")
	public void user_enters_the_fetched_EncounterID_into_search_textbox() {
		coveragePage.enterEncounterID();
	}

	@When("^user should not able to view delete icon$")
	public void user_should_not_able_to_view_delete_icon() {
		coveragePage.verifyDelIconNotVisibile();
	}

	@When("^user should able to view all active coverage with columns value$")
	public void user_should_able_to_view_all_active_coverage_with_columns_value(DataTable dt) {
		coveragePage.StoreAllCoverageColVal(dt);
	}
	
	@When("^user run the query and matches all the column value with database$")
	public void user_run_the_query_and_matches_all_the_column_value_with_database() throws ClassNotFoundException, SQLException, IOException {
		coveragePage.verifyCovColValue();
	}

	@When("^user should able to view Edit icon$")
	public void user_should_able_to_view_Edit_icon() {
		coveragePage.verifyEditIconVisibile();
	}

	@Then("^user should able to view delete icon$")
	public void user_should_able_to_view_delete_icon() {
		coveragePage.verifyDelIconVisibile();
	}
	
	@When("^user should able to view \\+ icon for add new coverage$")
	public void user_should_able_to_view_icon_for_add_new_coverage() {
		coveragePage.verifyCoveragePlusIconVisible();
	}
	
	@When("^user fetches the existing plan code in coverage panel$")
	public void user_fetches_the_existing_plan_code_in_coverage_panel() {
		coveragePage.getExistingPlanCode();
	}

	@When("^user delete existing coverage$")
	public void user_delete_existing_coverage() {
		coveragePage.deleteAllCoverage();
	}

	@When("^user clicks on \\+ sign of coverage panel$")
	public void user_clicks_on_sign_of_coverage_panel() {
		coveragePage.clickAddCovPlusIcon();
	}

	@Then("^user should able to view search payor plan text box$")
	public void user_should_able_to_view_search_payor_plan_text_box() {
		coveragePage.verifyPayorPlantextBoxVisible();
	}

	@When("^user enters any valid plan code$")
	public void user_enters_any_valid_plan_code() {
		coveragePage.enterPlanCode();
	}

	@When("^user clicks on coverage cancel button$")
	public void user_clicks_on_coverage_cancel_button() {
		coveragePage.clickCancelBtn();
	}

	@Then("^user should not able to view search payor plan text box$")
	public void user_should_not_able_to_view_search_payor_plan_text_box() {
		coveragePage.verifyPayorPlantextBoxNotVisible();
		coveragePage.clickRelease();
	}
	
	@When("^user clicks on Find button$")
	public void user_clicks_on_Find_button() {
		coveragePage.clickFindBtn();
	}

	@Then("^user should able to view Search result grid$")
	public void user_should_able_to_view_Search_result_grid() {
		coveragePage.verifySearchResultGrid();
	}

	@When("^user clicks on any plan code hyperlink under search result criteria$")
	public void user_clicks_on_any_plan_code_hyperlink_under_search_result_criteria() {
		coveragePage.clickOnSearchedPlanCode();
	}

	@Then("^user should able to view cancel and Add button$")
	public void user_should_able_to_view_cancel_and_Add_button() {
		coveragePage.verifyCancelAddBtn();
	}

	@When("^user clicks on coverage Add button$")
	public void user_clicks_on_coverage_Add_button() {
		coveragePage.clickAddNewCoverage();
	}

	@Then("^user should able to view added active coverage in coverage panel$")
	public void user_should_able_to_view_added_active_coverage_in_coverage_panel() {
		coveragePage.verifyCoverageAdded();
		coveragePage.clickRelease();
	}

	@Then("^user should able to view deleted coverage as inactive coverage in Other patient coverage panel$")
	public void user_should_able_to_view_deleted_coverage_as_inactive_coverage_in_Other_patient_coverage_panel() {
		coveragePage.verifyCoverageInOther();
	}

	@When("^user clicks on any inactive coverage from other coverage panel$")
	public void user_clicks_on_any_inactive_coverage_from_other_coverage_panel() {
		coveragePage.clickCodeOnOtherPatientCov();
	}

	@Then("^user should able to view clicked coverage gets added in coverage panel$")
	public void user_should_able_to_view_clicked_coverage_gets_added_in_coverage_panel() {
		coveragePage.verifyCodeAddedFromOtherPatCoverage();
		coveragePage.clickRelease();
	}
	
	@When("^user updates the setting \"([^\"]*)\" value as \"([^\"]*)\"$")
	public void user_updates_the_setting_value_as(String name, String value) throws IOException {
		coveragePage.updateSetting(name,value);
	}
	
	@When("^user clicks on coverage editable icon$")
	public void user_clicks_on_coverage_editable_icon() {
		coveragePage.clickEditIcon();
	}

	@Then("^user should able to view New Coverage panel$")
	public void user_should_able_to_view_New_Coverage_panel() {
		coveragePage.verifyNewCovPanelVisible();
	}

	@When("^user edits the Group and Subscriber field$")
	public void user_edits_the_Group_and_Subscriber_field() throws InterruptedException {
		coveragePage.editGrpAndSubScrib();
	}

	@When("^user clicks on cancel button of coverage edition$")
	public void user_clicks_on_cancel_button_of_coverage_edition() {
		coveragePage.clickCancelEditBtn();
	}

	@Then("^user should not able to view New Coverage panel$")
	public void user_should_not_able_to_view_New_Coverage_panel() {
		coveragePage.verifyNewCovPanelNotVisible();
	}

	@When("^user clicks on update button of coverage edition$")
	public void user_clicks_on_update_button_of_coverage_edition() {
		coveragePage.clickUpdateEditBtn();
	}

	@Then("^user should able to view updated data in coverage grid$")
	public void user_should_able_to_view_updated_data_in_coverage_grid() {
		coveragePage.verifyUpdatedDataInCov();
	}
	
	@Then("^user should able to view exception message \"([^\"]*)\"$")
	public void user_should_able_to_view_exception_message(String message) {
		coveragePage.verifyExceptionMessage(message);
	}

	@When("^uer clicks on complete button$")
	public void uer_clicks_on_complete_button() {
		coveragePage.clickExceptionCompleteBtn();	    
	}

	@When("^user clicks on exception continue button$")
	public void user_clicks_on_exception_continue_button() {
		coveragePage.clickExceptionContBtn();	    
	}
	
	@Then("^user should able to view exception message \"([^\"]*)\" with continue and cancel button$")
	public void user_should_able_to_view_exception_message_with_continue_and_cancel_button(String arg1) {
		coveragePage.verifyExceptionMsgWithBtn();
	}

	@Then("^user should able to view \"([^\"]*)\" added as default$")
	public void user_should_able_to_view_added_as_default(String arg1) {
		coveragePage.verifySelfPay();
	}
	
	@Then("^user should able to view coverage tab status as complete$")
	public void user_should_able_to_view_coverage_tab_status_as_complete() {
		coveragePage.verifycompleteTabStatus();
	}

	@Then("^user should able to view coverage tab status bar color as Blue$")
	public void user_should_able_to_view_coverage_tab_status_bar_color_as_Blue() {
		coveragePage.verifyTabStatusBlueColor();
	}
	
	@When("^user run the query and fetches the coverage \"([^\"]*)\"$")
	public void user_run_the_query_and_fetches_the_coverage(String arg1) throws ClassNotFoundException, SQLException, IOException {
		coveragePage.fetchEncounterId2();
	}

	@When("^user add services if no services exists$")
	public void user_add_services_if_no_services_exists() throws ClassNotFoundException, SQLException, IOException {
		coveragePage.verifyServiceAdded();
	}

	@When("^user fetches the Residual balance$")
	public void user_fetches_the_Residual_balance() {
		coveragePage.getResidualBal();
	}

	@When("^user clicks on Arrow button$")
	public void user_clicks_on_Arrow_button() {
		coveragePage.clickArrow();
	}

	@Then("^user should able to view different Residual balance$")
	public void user_should_able_to_view_different_Residual_balance() {
		coveragePage.verifyResidualBal();
	}
	
	@Given("^user run the query and fetch the \"([^\"]*)\" of coverage$")
	public void user_run_the_query_and_fetch_the_of_coverage(String arg1) throws ClassNotFoundException, SQLException, IOException {
		coveragePage.fetchEncounterId3();
	}

	@Given("^user click on TBD hyperlink under verified column in coverage grid$")
	public void user_click_on_TBD_hyperlink_under_verified_column_in_coverage_grid() {
		coveragePage.clickTBD();
	}

	@Then("^user should not able to view Eligibility Results panel$")
	public void user_should_not_able_to_view_Eligibility_Results_panel() {
		coveragePage.verifyEligPanelNotVisible();
	}
	
	@When("^user run the query and fetches the \"([^\"]*)\" of coverage$")
	public void user_run_the_query_and_fetches_the_of_coverage(String arg1) throws ClassNotFoundException, SQLException, IOException {
		coveragePage.fetchEncounterId4();
	}
	
	@When("^user click on any hyperlink under verified column in coverage grid$")
	public void user_click_on_any_hyperlink_under_verified_column_in_coverage_grid() {
		coveragePage.clickHyperlink();
	}

	@When("^user clicks on Unlimited checkbox$")
	public void user_clicks_on_Unlimited_checkbox() {
		coveragePage.clickUnlimitedCheckBox();
	}

	@Then("^user should able to view limit\\(\\$\\) textbox get populated with value \"([^\"]*)\"$")
	public void user_should_able_to_view_limit_$_textbox_get_populated_with_value(String text) {
		coveragePage.verifyLimitTxtBoxVal(text);
	}

	@Then("^user should able to view limit\\(\\$\\) textbox as disabled$")
	public void user_should_able_to_view_limit_$_textbox_as_disabled() {
		coveragePage.verifyLimitTxtBoxDisable();
	}

	@When("^user changes plan name$")
	public void user_changes_plan_name() {
		coveragePage.editPayorName();
	}
	
	@When("^user changes copay,ER,Deductible,Coins field value$")
	public void user_changes_copay_ER_Deductible_Coins_field_value(DataTable dt) {
		coveragePage.editInsVal(dt);
	}

	@When("^user clicks on update button after editing$")
	public void user_clicks_on_update_button_after_editing() {
		coveragePage.clickUpdateInsVal();
	}

	@Then("^user should able to view updated field value$")
	public void user_should_able_to_view_updated_field_value(DataTable dt) {
		coveragePage.verifyUpdatedInsFieldVal(dt);
	}

	@When("^user run the query and passes the current Encounter ID$")
	public void user_run_the_query_and_passes_the_current_Encounter_ID() throws ClassNotFoundException, SQLException, IOException {
		coveragePage.fetchEditedColValue();
	}

	@Then("^user should able to view same updated value in database$")
	public void user_should_able_to_view_same_updated_value_in_database() {
		coveragePage.verifyEditedColValue();
	}

  }
