package r1.steps.definitions;

import java.io.IOException;
import java.sql.SQLException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.R1AccessCommonMethods;
import r1.pages.ConfigRulePage;

public class ConfigRuleStepDef {
	ConfigRulePage configRule;
	R1AccessCommonMethods common;
	
	@Then("^user is able to view \"([^\"]*)\" page$")
	public void user_is_able_to_view_page(String title) {
		configRule.verifyWorkList();
	}
	
	@Then("^user is able to verify and click on Configuration Rules tab$")
	public void user_is_able_to_verify_and_click_on_Configuration_Rules_tab() {
		configRule.verifyConfigurationRules();
	}
	
	@When("^user search \"([^\"]*)\" account using query$")
	public void user_search_account_using_query(String rule) throws ClassNotFoundException, IOException, SQLException {
		configRule.enter_encounter_id(rule);
	}
	
	@When("^user clicks on 'Search' tab$")
	public void user_clicks_on_Search_tab() {
		configRule.clicks_on_search();
	}
	
	@When("^user expand Primary Authorization Suppression tool bar$")
	public void user_expand_Primary_Authorization_Suppression_tool_bar() {
		configRule.dshPrimaryAuthImgIcon();
	}
	
	@Then("^user verify details under 'Log History' grid PAS tab$")
	public void user_verify_details_under_Log_History_grid() {
		configRule.verifyLogHistoryPAS();
	}
	
	@Then("^user verify details under 'Field Details' grid PAS tab$")
	public void user_verify_details_under_Field_Details_grid_Matching_Rules() {
		configRule.verifyFieldDetailsPAS();
	}
	
	@Then("^user verify details under 'Matching Rules' grid PAS tab$")
	public void user_verify_details_under_Matching_Rules_grid() {
		configRule.verifyMatchingRulesPAS();
	}

	@Then("^user set 'Include Partial Matches' checkbox = \"([^\"]*)\" and verify partial matching table appears PAS tab$")
	public void user_set_Include_Partial_Matches_checkbox_and_verify_partial_matching_table_appears(String status) {
		configRule.verifyPrimaryAuthIncludePartial(status);
	}

	@Then("^user set 'Include Partial Matches' checkbox = \"([^\"]*)\" and verify partial matching table disappears PAS tab$")
	public void user_set_Include_Partial_Matches_checkbox_and_verify_partial_matching_table_disappears(String status) {
		configRule.verifyPrimaryAuthIncludePartial(status);
	}
	
	@Then("^user set 'Include Inactive' checkbox = \"([^\"]*)\" and verify Inactive rules table appears PAS tab$")
	public void user_set_Include_Inactive_checkbox_and_verify_Inactive_rules_table_appears(String status) {
		configRule.verifyPrimaryAuthIncludeInactive(status);
	}

	@Then("^user set 'Include Inactive' checkbox = \"([^\"]*)\" and verify Inactive rules table disappears PAS tab$")
	public void user_set_Include_Inactive_checkbox_and_verify_Inactive_rules_table_disappears(String status) {
		configRule.verifyPrimaryAuthIncludeInactive(status);
	}
	
	@Then("^user collapse Primary Authorization Suppression tool bar$")
	public void user_expand_collapse_Primary_Authorization_Suppression_tool_bar() {
		configRule.dshPrimaryAuthImgIcon();
	}
	
	@When("^user expand Primary Coverage Exceptions tool bar$")
	public void user_expand_Primary_Coverage_Exceptions_tool_bar() {
		configRule.dshPrimaryConfigImgIcon();
	}
	
	@Then("^user verify details under 'Log History' grid PCE tab$")
	public void user_verify_details_under_Log_History_grid_PCE_tab() {
		configRule.verifyLogHistoryPCE();
	}
	
	@Then("^user verify details under 'Field Details' grid PCE tab$")
	public void user_verify_details_under_Field_Details_grid_Matching_Rules_PCE_tab() {
		configRule.verifyFieldDetailsPCE();
	}

	@Then("^user verify details under 'Matching Rules' grid PCE tab$")
	public void user_verify_details_under_Matching_Rules_grid_PCE_tab() {
		configRule.verifyMatchingRulesPCE();
	}
	
	@Then("^user set 'Include Partial Matches' checkbox = \"([^\"]*)\" and verify partial matching table appears PCE tab$")
	public void user_set_Include_Partial_Matches_checkbox_and_verify_partial_matching_table_appears_PCE_tab(String status) {
		configRule.verifyPrimaryConfigIncludePartial(status);
	}

	@Then("^user set 'Include Partial Matches' checkbox = \"([^\"]*)\" and verify partial matching table disappears PCE tab$")
	public void user_set_Include_Partial_Matches_checkbox_and_verify_partial_matching_table_disappears_PCE_tab(String status) {
		configRule.verifyPrimaryConfigIncludePartial(status);
	}

	@Then("^user set 'Include Inactive' checkbox = \"([^\"]*)\" and verify Inactive rules table appears PCE tab$")
	public void user_set_Include_Inactive_checkbox_and_verify_Inactive_rules_table_appears_PCE_tab(String status) {
		configRule.verifyPrimaryConfigIncludeInactive(status);
	}

	@Then("^user set 'Include Inactive' checkbox = \"([^\"]*)\" and verify Inactive rules table disappears PCE tab$")
	public void user_set_Include_Inactive_checkbox_and_verify_Inactive_rules_table_disappears_PCE_tab(String status) {
		configRule.verifyPrimaryConfigIncludeInactive(status);
	}

	@Then("^user collapse Primary Coverage Exceptions tool bar$")
	public void user_expand_collapse_Primary_Coverage_Exceptions_tool_bar() {
		configRule.dshPrimaryConfigImgIcon();
	}
	
	@When("^user click on Redo button$")
	public void user_click_on_Redo_button() {
	    common.clickOnCheckOut();
	}
	
	@Then("^user verify 'Coverage Section'$")
	public void user_verify_Coverage_Section() {
		configRule.verifySelectedCoverage();
	}
	
	@Then("^user verify 'Primary Authorization Suppression' and 'Primary Coverage Exceptions' tab visible \"([^\"]*)\"$")
	public void user_verify_Primary_Authorization_Suppression_and_Primary_Coverage_Exceptions_tab_visible(String arg1) {
		configRule.verifyPrimaryAuthAndCoverage(arg1);
	}
	
	@When("^user expand Service Automation Rules tool bar$")
	public void user_expand_Service_Automation_Rules_tool_bar() {
		configRule.dshServicesAuthImgIcon();
	}
	
	@Then("^And user verify details under 'Field Details' grid SAR tab$")
	public void and_user_verify_details_under_Field_Details_grid_SAR_tab() {
		configRule.verifyFieldDetailsSAR();
	}
	
	@Then("^user verify details under 'Matching Rules' grid SAR tab$")
	public void user_verify_details_under_Matching_Rules_grid_SAR_tab() {
		configRule.verifyMatchingRulesSAR();
	}
	
	@Then("^user set 'Include Partial Matches' checkbox = \"([^\"]*)\" and verify partial matching table appears SAR tab$")
	public void user_set_Include_Partial_Matches_checkbox_and_verify_partial_matching_table_appears_SAR_tab(String status) {
		configRule.verifyServicesAutomationIncludePartial(status);
	}

	@Then("^user set 'Include Partial Matches' checkbox = \"([^\"]*)\" and verify partial matching table disappears SAR tab$")
	public void user_set_Include_Partial_Matches_checkbox_and_verify_partial_matching_table_disappears_SAR_tab(String status) {
		configRule.verifyServicesAutomationIncludePartial(status);
	}

	@Then("^user set 'Include Inactive' checkbox = \"([^\"]*)\" and verify Inactive rules table appears SAR tab$")
	public void user_set_Include_Inactive_checkbox_and_verify_Inactive_rules_table_appears_SAR_tab(String status) {
		configRule.verifyServicesAutomationIncludeInactive(status);
	}

	@Then("^user set 'Include Inactive' checkbox = \"([^\"]*)\" and verify Inactive rules table disappears SAR tab$")
	public void user_set_Include_Inactive_checkbox_and_verify_Inactive_rules_table_disappears_SAR_tab(String status) {
		configRule.verifyServicesAutomationIncludeInactive(status);
	}

	@Then("^user expand Service Automation Rule tool bar$")
	public void user_expand_Service_Automation_Rule_tool_bar() {
		configRule.dshServicesAuthImgIcon();
	}
}
