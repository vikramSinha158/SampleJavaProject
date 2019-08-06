package r1.steps.definitions;

import java.io.IOException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.pages.Navigation;
import r1.pages.NotesPage;
import r1.pages.PCPPage;
import r1.pages.UserLogin;
import r1.serenity.steps.NotesSteps;


public class PCPStepDef extends BasePage{

	PCPPage pCPPage;
	UserLogin userLogin;
	Navigation navigation;
	R1AccessCommonMethods R1AccessCommonMethodsRef;
	
		
	@When("^user clicks on setting link$")
	public void user_clicks_on_setting_link() {
		navigation.clickSettingsLink();
	}

	@When("^user clicks on IT Tool$")
	public void user_clicks_on_IT_Tool() {
		navigation.clickITToolsLink();
	}

	@When("^user clicks on Facility Setting configuration$")
	public void user_clicks_on_Facility_Setting_configuration() {
		navigation.clickFacilitySettingConfiguration();
	}

	@When("^user select \"([^\"]*)\" from search dropdown$")
	public void user_select_from_search_dropdown(String searchField) {
		pCPPage.selectSearchField(searchField);
	}

	@When("^user enters \"([^\"]*)\" on search textbox$")
	public void user_enters_on_search_textbox(String searchText) {
		pCPPage.searchText(searchText);
	}

	@When("^user clicks on search icon$")
	public void user_clicks_on_search_icon() {
		pCPPage.clickSearchIcon();	
	}

	@When("^user clicks on view icon of corresponding code$")
	public void user_clicks_on_view_icon_of_corresponding_code() {
		pCPPage.clickGridView();
	}

	@When("^user select \"([^\"]*)\" from search drop down for Locations$")
	public void user_select_from_search_drop_down_for_Locations(String searchFieldFacility) {
		pCPPage.selectSearchFieldFacilitySetting(searchFieldFacility);
	}

	@When("^user enters \"([^\"]*)\" on search textbox for Locations$")
	public void user_enters_on_search_textbox_for_Locations(String searchText) {
		pCPPage.searchTextLocations(searchText);
	}

	@When("^user clicks on search icon for Locations$")
	public void user_clicks_on_search_icon_for_Locations() {
		pCPPage.clickSearchIconLocations();	 
	}

	@When("^user edits the setting value to \"([^\"]*)\"$")
	public void user_edits_the_setting_value_to(String settingValue) throws IOException {
		pCPPage.edit_text_setting_value(settingValue);
		navigation.clickSettingsLink();
		navigation.clickITToolsLink();	
		pCPPage.clearCache();
	}

	@When("^user clicks on patient access tab$")
	public void user_clicks_on_patient_access_tab() {
		navigation.clickMenu("Patient Access");
	}

	@When("^user clicks on \"([^\"]*)\" worklist$")
	public void user_clicks_on_worklist(String arg1) {
		navigation.clickMenu("Pre-Registration");
	}

	@Given("^user is on \"([^\"]*)\" worklist page$") 
	public void user_is_on_worklist_page(String arg1) {
		pCPPage.verifyWorkListTitle(arg1);
	}

	@When("^user open any account$")
	public void user_open_any_account() {
		pCPPage.clickRecord();
	}

	@Then("^user should able to view \"([^\"]*)\" tab$")
	public void user_should_able_to_view_tab(String tab) {
		pCPPage.verifyAccountDetailMenuLink(tab);
	}
	
	@When("^user checkout the account$")
	public void user_checkout_the_account() {
		R1AccessCommonMethodsRef.checkOut();
	}
	//..modified
	@When("^user click on \"([^\"]*)\" tab$")
	public void user_click_on_tab(String tab) {
		pCPPage.clickAccountDetailMenuLink(tab);
	}
	
	@Then("^user should able to view pcp tab status as Incomplete$")
	public void user_should_able_to_view_pcp_tab_status_as_Incomplete() {
		pCPPage.verifyIncompleteTabStatus();
	}

	@Then("^user should able to view pcp tab status bar color as Red$")
	public void user_should_able_to_view_pcp_tab_status_bar_color_as_Red() {
		pCPPage.verifyTabStatusRedColor();
		pCPPage.clickRelease();
	}

	@When("^user clicks on expand \\+ icon of incomplete task filter folder$")
	public void user_clicks_on_expand_icon_of_incomplete_task_filter_folder() {
		pCPPage.clickPlusIncompTask();
	}

	@When("^user clicks on PCP sub filter folder$")
	public void user_clicks_on_PCP_sub_filter_folder() {
		pCPPage.clickPcpFilterFolder();
	}

	@Then("^user should able to view incomplete pcp accounts$")
	public void user_should_able_to_view_incomplete_pcp_accounts() {
		pCPPage.verifyPcpIncompTask();
		pCPPage.clickRelease();
	}

	@When("^user set the value of pcp checkbox equals to checked$")
	public void user_set_the_value_of_pcp_checkbox_equals_to_checked() {
		pCPPage.clickPcpValidChkBox();
		pCPPage.clickRelease();
	}

	@Then("^user should able to view pcp tab status as complete$")
	public void user_should_able_to_view_pcp_tab_status_as_complete() {
		pCPPage.verifycompleteTabStatus();
	}

	@Then("^user should able to view pcp tab status bar color as Blue$")
	public void user_should_able_to_view_pcp_tab_status_bar_color_as_Blue() {
		pCPPage.verifyTabStatusBlueColor();
	}

	@Then("^user should able to view a log for task equals to pcp and status equals to completed as last log in Action Log panel$")
	public void user_should_able_to_view_a_log_for_task_equals_to_pcp_and_status_equals_to_completed_as_last_log_in_Action_Log_panel() {
		pCPPage.verifyActionlog();
		pCPPage.clickRelease();
	}

	@When("^user fetch the Account num$")
	public void user_fetch_the_Account_num() {
		pCPPage.fetchAccountNum();
	}

	@Then("^user should not able to view same fetched Account num in worklist$")
	public void user_should_not_able_to_view_same_fetched_Account_num_in_worklist() {
		pCPPage.verifyAccNotInWrkLst();
	}
}
