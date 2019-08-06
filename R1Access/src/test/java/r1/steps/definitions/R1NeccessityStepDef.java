package r1.steps.definitions;

import java.io.IOException;
import java.sql.SQLException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.pages.Navigation;
import r1.pages.R1NeccessityPage;
import r1.pages.UserLogin;
import r1.serenity.steps.R1NeccessitySteps;

public class R1NeccessityStepDef extends BasePage{
	
	R1NeccessityPage neccessityPage;
	R1NeccessitySteps neccessitySteps;
	UserLogin userLogin;
	Navigation navigation;
	
	String encounterID;
	
	@Then("^user is on \"([^\"]*)\" page$")
	public void user_is_on_page(String pageTitle) {
		neccessityPage.verifyWorkListTitle(pageTitle);
	}
	
	@Then("^user should be able to view Filters in left panel$")
	public void user_should_be_able_to_view_Filters_in_left_panel() {
		neccessityPage.verifyWorkListFilter();
	}
	
	@And("^user should be able to view labels NEW,TASK,COLUMNS,SEARCH,EXPORT,SAVE LIST and CONFIG$")
	public void user_should_be_able_to_view_labels_NEW_TASK_COLUMNS_SEARCH_EXPORT_SAVE_LIST_and_CONFIG() {
		neccessityPage.verifyLabels();
	}
	
	@Then("^user should be able to view all tabs in Red, Blue and Yellow color$")
	public void user_should_be_able_to_view_all_tabs_in_Red_Blue_and_Green_color() {
		neccessityPage.verifyTabsColor();
	}
	
	@Then("^user run the query and fetch the \"([^\"]*)\"$")
	public void user_run_the_query_and_fetch_encounterid(String col) throws ClassNotFoundException, IOException, SQLException {
		encounterID = neccessitySteps.searchEncounterID(col);
	}
	
	@When("^user click on the \"([^\"]*)\" button on blue ribbon$")
	public void user_click_on_the_button_on_blue_ribbon(String label) throws ClassNotFoundException, IOException, SQLException {
		neccessityPage.clickAccountButtonOnRibbon(label);
	}
	
	@Then("^user should be able to view SSN:, L/F Name:, Med Rec: and Visit: labels$")
	public void user_should_be_able_to_view_labels(){
		neccessityPage.verifySearchedAccountLabels();
	}
	
	@And("^user enters the EncounterID into search field$")
	public void user_enters_the_encounterID_into_search_field(){
		neccessityPage.enterEncounterID(encounterID);
	}
	
	@And("^user clicks on the Search button$")
	public void user_clicks_on_the_Search_button(){
		neccessityPage.clickSearchButton();
	}
	
	@Then("^user should be able to view R1 Necessity tab with ribbon color red/blue$")
	public void user_should_be_able_to_view_tab_with_ribbon_color_red_blue(){
		neccessityPage.verifyR1NecessityTab();
	}
	
	@When("^user clicks on the \"([^\"]*)\" filter$")
	public void user_clicks_on_the_filter(String filterName){
		neccessityPage.clickFilterMainMenu(filterName);
	}
	
	@Then("^user should be able to view accounts displayed on the Necessity Required worklist$")
	public void user_should_be_able_to_view_accounts_displayed_on_the_Necessity_Required_worklist(){
		neccessityPage.verifyAccountsDisplayed();
	}
	
	
	
	@And("^user clicks on \"([^\"]*)\" button$")
	public void user_clicks_on_Checkout_button(String menu) throws InterruptedException{
		neccessityPage.clickAccountButton(menu);
		neccessityPage.verifyRedoButton();
	}
	
	@And("^user search the service \"([^\"]*)\"$")
	public void user_search_the_service(String service){
		neccessityPage.searchService(service);
	}
	
	@Then("^user clicks on the searched service link$")
	public void user_clicks_on_the_searched_service_link(){
		neccessityPage.clickServiceLink();
	}
	
	@And("^user clicks on any diagnosis link$")
	public void user_clicks_on_any_diagnosis_link(){
		neccessityPage.clickDiagnosisLink();
	}
	
	@Then("^user run the query and fetch the neccessity encounterID \"([^\"]*)\"$")
	public void user_run_the_query_and_fetch_the_neccessity_encounterID(String column) throws ClassNotFoundException, IOException, SQLException{
		encounterID = neccessitySteps.searchNecessityEncounterID(column);
	}
	
	@And("^user select activity \"([^\"]*)\" from activity drop down$")
	public void user_select_activity(String activity){
		neccessityPage.selectActivity(activity);
	}
	
	@And("^Disposition drop down should disappear$")
	public void Disposition_drop_down_should_disappear() throws InterruptedException{
		neccessityPage.verifyDispositionHide();
	}
	
	@Then("^user should be able to view new log under FollowUp history section with note \"([^\"]*)\"$")
	public void user_should_be_able_to_view_new_log_under_FollowUp_history_section_with_note(String note){
		neccessityPage.verifyFollowUpHistory(note);
	}
	
	
	@And("^user clicks on the Print ABN English button$")
	public void user_clicks_on_the_Print_ABN_English_button(){
		neccessityPage.clickABNEnglish();
	}
	
	@And("^user clicks on the Print ABN Spanish button$")
	public void user_clicks_on_the_Print_ABN_Spanish_button(){
		neccessityPage.clickABNSpanish();
	}
	
	@Then("^user should be able to view ABN English pdf$")
	public void user_should_be_able_to_view_ABN_English_pdf(){
		neccessityPage.verifyABNEnglishPdf();
	}
	
	@Then("^user should be able to view ABN Spanish pdf$")
	public void user_should_be_able_to_view_ABN_Spanish_pdf(){
		neccessityPage.verifyABNSpanishPdf();
	}
	
	@Then("^user should be able to view the Activity Log grid with labels$")
	public void user_should_be_able_to_view_the_Activity_Log_grid_with_labels() throws IOException{
		neccessityPage.verifyActivityLog();
	}
	
	@Then("^user should be able to view follow up history grid with labels and data$")
	public void user_should_be_able_to_view_follow_up_history_grid_with_labels_and_data() throws ClassNotFoundException, IOException, SQLException{
		neccessityPage.verifyFollowUp();
	}
	
	@Then("^user run the query and fetch the neccessity incomplete encounterID \"([^\"]*)\" and verify with UI$")
	public void user_run_the_query_and_fetch_the_neccessity_incomplete_encounterID(String columnName) throws ClassNotFoundException, IOException, SQLException{
		neccessityPage.verifyNecessityIncompleteAccounts(columnName);
	}
	
	@Then("^user clicks on the Necessity Incomplete filter$")
	public void user_clicks_on_the_Necessity_Required_drill_down_filter() throws InterruptedException{
		neccessityPage.clickNecessityRequiredDrillDown();
	}
	
	@When("^user clicks on account$")
	public void user_clicks_on_account() {
		neccessityPage.clickNecessityAccount();
	}
	
	@Then("^user should be able to view the status Incomplete, Redo or Assigned$")
	public void user_should_be_able_to_view_the_status() {
		neccessityPage.verifyNecessityAccountStatus();
	}
	
}
