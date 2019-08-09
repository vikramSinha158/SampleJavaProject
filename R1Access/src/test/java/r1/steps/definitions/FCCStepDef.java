package r1.steps.definitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.pages.FCCPage;

public class FCCStepDef {
	
	FCCPage fccPage;
	
	
	@Given("^user is on FCC worklist$")
	public void user_is_on_FCC_worklist(){
		fccPage.verifyFCCWorkListPage();
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
	
}
