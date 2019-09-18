package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.commons.databaseconnection.QueryExecutor;
import r1.pages.Service2Page;
import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.databaseconnection.QueryExecutor;

public class Service2StepDef extends BasePage {
	
	R1AccessCommonMethods r1AccessCommonMethod;
	Service2Page service2;

	@When("^user select the facility$")
	public void user_select_the_facility() throws IOException {
		r1AccessCommonMethod.selectFacility();
	}

	@Then("^verify service and residual settings has version two by running the query \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_service_and_residual_settings_has_version_two_by_running_the_query_and(String serviceQuery,
			String residualQuery)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException, InterruptedException {
		QueryExecutor.runQueryTran(serviceQuery, service2.getmoduleName());
		DatabaseConn.resultSet.next();
		String serviceSetting = DatabaseConn.resultSet.getString("SettingValue");

		QueryExecutor.runQueryTran(residualQuery, service2.getmoduleName());
		DatabaseConn.resultSet.next();
		String residualSetting = DatabaseConn.resultSet.getString("SettingValue");
		service2.verifyServiceandResidualSettings(serviceSetting, residualSetting);
	}

	@When("^user clicks on \"([^\"]*)\" link$")
	public void user_clicks_on_link(String link) {
		r1AccessCommonMethod.clickFooterR1AccesModulesTab(link);
	}

	@When("^user select filter \"([^\"]*)\" operator \"([^\"]*)\" value \"([^\"]*)\" from dropdown$")
	public void user_select_filter_operator_value_from_dropdown(String filter, String op, String value) {
		r1AccessCommonMethod.ddlWorkListFilter(filter, op, value);
	}

	@When("^user clicks on any Unassigned Account$")
	public void user_clicks_on_any_Unassigned_Account() {
		r1AccessCommonMethod.clickOnUnassignedAccount();
	}

	@When("^user clicked on \"([^\"]*)\" tab$")
	public void user_clicked_on_tab(String Text) {
		r1AccessCommonMethod.clickR1AccesModulesTab(Text);
	}

	@When("^user clicks on \"([^\"]*)\" side sub menu$")
	public void user_clicks_on_side_sub_menu(String Text) {
		r1AccessCommonMethod.clickSubSideR1HubModulesMenuLink(Text);
	}

	@Then("^verify the fields before checkout$")
	public void verify_the_fields_before_checkout() {
		r1AccessCommonMethod.verifyActionStatusTabBeforeCheckout();
	}

	@When("^user clicked on checkout button$")
	public void user_clicked_on_checkout_button() {
		r1AccessCommonMethod.clickOnCheckOut();
	}

	@When("^user clicked on Admitting if exists$")
	public void user_clicked_on_Admitting_if_exists() {
		service2.clickOnAdmiting();
	}

	@Then("^verify the fields after the checkout$")
	public void verify_the_fields_after_the_checkout() {
		r1AccessCommonMethod.verifyActionStatusAfterCheckout();
	}

	@When("^user enter services like \"([^\"]*)\" in search field$")
	public void user_enter_services_like_in_search_field(String Text) {
		service2.enterCodes(Text);
		service2.clickOnSearch();
	}

	@Then("^searched result should be shown in service pane$")
	public void searched_result_should_be_shown_in_service_pane() {
		service2.verifyServiceSearchResults();
	}

	@Then("^verify radio buttons$")
	public void verify_radio_buttons() {
		service2.verifySingleMultipleRadioBtn();
	}

	@When("^user add services$")
	public void user_add_services() {
		service2.addServicesSearchResults();
	}

	@Then("^verify service should be added$")
	public void verify_service_should_be_added() {
		service2.verifyServiceShouldBeAdded();
	}

	@When("^user delete added services$")
	public void user_delete_added_services() {
		service2.deleteServices();
	}

	@Then("^service search result grid will not be displayed$")
	public void service_search_result_grid_will_not_be_displayed() {
		service2.verifyServiceGridIsNotDisplayed();
	}

	@When("^user clicks on \"([^\"]*)\" btn$")
	public void user_clicks_on_btn(String Text) {
		r1AccessCommonMethod.clickActionStatusTab(Text);
	}

	@Then("^single multiple radio buttons of pricing will not be displayed$")
	public void single_multiple_radio_buttons_of_pricing_will_not_be_displayed() {
		service2.verifySingleMultipleRadioBtnNotExists();
	}

	@When("^user add ICD Codes$")
	public void user_add_ICD_Codes() {
		service2.addICDDiagnosisCodes();
	}

	@Then("^verify the status of the \"([^\"]*)\" tab is \"([^\"]*)\" and color \"([^\"]*)\"$")
	public void verify_the_status_of_the_tab_is_and_color(String moduleTab, String tabStatus, String color) {
		service2.verifyTabColorAndStatus(moduleTab, tabStatus, color);
	}

	@Then("^verify that up down arrow key is moving of ICD codes$")
	public void verify_that_up_down_arrow_key_is_moving_of_ICD_codes() {
		service2.verifyUpDownArrowKeyIsWorking();
	}

	@When("^user clicked on \"([^\"]*)\" btn$")
	public void user_clicked_on_btn(String Text) {
		service2.clickOnExceptionContinueButton(Text);
	}

	@When("^user clicks on the \"([^\"]*)\" link from footer Tab$")
	public void user_clicks_on_the_link_from_footer_Tab(String Text) {
		r1AccessCommonMethod.clickFooterR1AccesModulesTab(Text);
	}

	@When("^user set the facility \"([^\"]*)\" setting name \"([^\"]*)\" setting value \"([^\"]*)\"$")
	public void user_set_the_facility_setting_name_setting_value(String Text, String Text1, String Text2) {
		r1AccessCommonMethod.setFacilitySettingVal(Text, Text1, Text2);
	}

	@Then("^verify \"([^\"]*)\" radio button should be selected by default$")
	public void verify_radio_button_should_be_selected_by_default(String Text) {
		service2.verifyModeIsSelectedInContextToSettings(Text);
	}

	@Then("^user should be able to view Account Worklist Grid$")
	public void user_should_be_able_to_view_Account_Worklist_Grid() {
		r1AccessCommonMethod.verifyWorklistExists();
	}

	@Then("^verify \"([^\"]*)\" codes are coming in diagnosis grid$")
	public void verify_codes_are_coming_in_diagnosis_grid(String Text) {
		service2.verifyICD9CodesAreComingOrNot(Text);
	}

	@Then("^verify that IcdNine codes checkbox exist$")
	public void verify_that_IcdNine_codes_checkbox_exist() {
		service2.verifyICDCodesCheckboxExist();
	}

	@When("^user clicks on IcdNine codes checkbox$")
	public void user_clicks_on_IcdNine_codes_checkbox() {
		service2.clickOnICD9Checkbox();
	}
}
