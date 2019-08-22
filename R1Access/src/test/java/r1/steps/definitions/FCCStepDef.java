package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.pages.FCCPage;
import r1.pages.NotesPage;
import r1.serenity.steps.FCCSteps;

public class FCCStepDef {
	
	FCCPage fccPage;
	NotesPage notesPage;
	FCCSteps fccSteps;
	
	String activity, disposition,encounterID;
	
	
	@Given("^user is on R1 FCC menu page$")
	public void user_is_on_R1_FCC_menu_page(){
		fccPage.verifyR1FCCHubPage();
	}
	
	@Then("^user is on FCC \"([^\"]*)\" worklist$")
	public void user_is_on_FCC_worklist(String pageTitle){
		fccPage.verifyFCCWorkListPage(pageTitle);
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
	
	@And("^user should be able to view the selected facility \"([^\"]*)\"$")
	public void user_should_be_able_to_view_the_selected_facility(String facility){
		fccPage.verifySelectedFacility(facility);
	}
	
	@Then("^user select value from Filter and operator drop down$")
	public void user_select_value_from_Filter_and_operator_drop_down(DataTable filter){
		fccPage.selectFilterOperator(filter);
	}
	
	@When("^user select the filter \"([^\"]*)\"$")
	public void user_select_the_filter(String filter) {
		fccPage.selectFilter(filter);
	}
	
	@And("^user select the operator \"([^\"]*)\"$")
	public void user_select_the_operator(String operator) {
		fccPage.selectOperator(operator);
	}
	
	@And("^user enters text \"([^\"]*)\" into text box$")
	public void user_enters_text(String text) {
		fccPage.enterText(text);
	}
	
	@And("^user clicks on the Filter button$")
	public void user_clicks_on_the_Filter_button() {
		fccPage.clickFilterButton();
	}
	
	@Then("^user should be able to view the worklist with account containing \"([^\"]*)\"$")
	public void user_should_be_able_to_view_the_worklist(String text) {
		fccPage.verifyWorkListSize(text);
	}
	
	@When("^user clicks on the Clear button$")
	public void user_clicks_on_the_Clear_button() {
		fccPage.clickClearButton();
	}
	
	@And("^user clicks on the column header$")
	public void user_clicks_on_the_column_header() {
		fccPage.clickFacilityColumnHeader();
	}
	
	@And("^worklist data should appear in ascending order$")
	public void worklist_data_should_appear_in_ascending_order() {
		fccPage.verifyWorkListAscAsc();
	}

	@And("^worklist data should appear in descending order$")
	public void worklist_data_should_appear_in_descending_order() {
		fccPage.verifyWorkListAscDesc();
	}
	
	@When("^user select patient type \"([^\"]*)\"$")
	public void user_select_patient_type(String type) {
		fccPage.selectPatientType(type);
	}
	
	@Then("^user should be able to view the I in PT column$")
	public void user_should_be_able_to_view_the_I_in_PT_column() {
		fccPage.verifyFilterPatientType();
	}
	
	@And("^user select activity from activity drop down$")
	public void user_select_activity_from_activity_drop_down() {
		activity = fccPage.selectActivity();
	}
	
	@And("^user select disposition from disposition drop down$")
	public void user_select_disposition_from_disposition_drop_down() {
		disposition = fccPage.selectDisposition();
	}
	
	
	@Then("^user should be able to view the follow up labels with type \"([^\"]*)\" and note \"([^\"]*)\"$")
	public void user_should_be_able_to_view_the_labels_with_values(String type, String note) throws ClassNotFoundException, IOException, SQLException{
		fccPage.verifyFollowUp(activity,disposition,type,note);
	}
	
	@Then("^user should be able to view the action log labels with values and note \"([^\"]*)\"$")
	public void user_should_be_able_to_view_the_action_log_labels_with_values_and_note(String note) throws IOException{
		fccPage.verifyFCCActivityLog(note);
	}
	
	@Then("^user should be able to view the added Disposition and FollowUpDate as today's date$")
	public void user_should_be_able_to_view_the_added_Disposition_and_FollowUpDate(){
		fccPage.verifyWorkListDisposition(disposition);
	}
	
	@Then("^user select scopename \"([^\"]*)\"$")
	public void user_select_scopename(String scopeName) throws IOException{
		fccPage.selectServiceScopeFilter(scopeName);
	}
	
	@Then("^user select the \"([^\"]*)\" from search dropdown$")
	public void user_select_search(String search) throws IOException{
		fccPage.selectSearchDropDownFacilitySetting(search);
	}
	
	@And("^user enter code \"([^\"]*)\" in text field$")
	public void user_enter_code(String code) throws IOException{
		fccPage.enterTextFacilitySetting(code);
	}
	
	@And("^user clicks on the search icon$")
	public void user_clicks_on_the_search_icon() throws IOException{
		fccPage.clickSearchIcon();
	}
	
	@And("^user clicks on the view link$")
	public void user_clicks_on_the_view_link() throws IOException{
		fccPage.clickView();
	}
	
	@Then("^user should be able to view the \"([^\"]*)\" in Facility Setting - Task section$")
	public void user_should_view_facility_setting_worklistname(String workListName) throws IOException{
		fccPage.verifyFacilitySettingWorklistName(workListName);
	}
	
	@When("^user clicks on the Edit button against worklist \"([^\"]*)\"$")
	public void user_clicks_on_the_Edit_button(String workListName){
		fccPage.clickFacilitySettingWorklistNameEdit(workListName);
	}
	
	@Then("^user should be able to view \"([^\"]*)\" in Tasks detail window$")
	public void user_should_be_able_to_view_task(String taskName){
		fccPage.verifyFacilitySettingWorklistTask(taskName);
	}
	
	@When("^user clicks on the sub filter \"([^\"]*)\" under filter \"([^\"]*)\"$")
	public void user_clicks_on_the_sub_filter(String filterSubFolder, String filterFolder) throws InterruptedException{
		fccPage.clickSubFolder(filterFolder,filterSubFolder);
	}
	
	@When("^user clicks on the FCC Contact filter in filter folder$")
	public void user_clicks_on_the_FCC_Contact_filter_in_filter() throws InterruptedException{
		fccPage.clickFccContactFilter();
	}
	
	@And("^user should be able to view the \"([^\"]*)\" title on worklist$")
	public void verify_the_filter_folder_redirection(String filterFolderTitle){
		fccPage.verifyFilterFolderRedirection(filterFolderTitle);
	}
	
	
	@Then("^user should be able to view FCC Contact tab color in BLUE$")
	public void user_should_be_able_to_view_FCC_Contact_tab_color_in_BLUE() {
		fccPage.verifyFCCContactColorBlue();
	}
	
	@Then("^user should be able to view the Status as Complete$")
	public void user_should_be_able_to_view_the_Status_as_Complete() {
		fccPage.verifyStatusHeader();
	}
	
	@When("^user runs the query \"([^\"]*)\" for facility \"([^\"]*)\"$")
	public void user_runs_the_query(String query, String facility) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		fccPage.runQuery(query,facility);
	}
	
	@And("^user fetch the encounterID \"([^\"]*)\"$")
	public void user_fetch_the_encounterID(String column) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		encounterID = fccPage.getEncounterID(column);
	}
	
	@Then("^user enters the encounterID into search field$")
	public void user_enters_the_encounterID_into_search_field() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		fccPage.enterSearchText(encounterID);
	}
}
