package r1.steps.definitions;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.pages.PayorStatusPage;

public class PayorStatusStepDef{
	
	PayorStatusPage payorStatusPage;
	
	@Given("^user is on Payor Status worklist page$")
	public void user_is_on_Payor_Status_worklist_page() 
	{
		payorStatusPage.verifyPayorStatusWrkLst();
	}
	
	@Then("^user should able to view column header name$")
	public void user_should_able_to_view_column_header_name(DataTable dt) 
	{
		payorStatusPage.verifyColHeader(dt);
	}

	@Then("^user should able to view all values under Status column as \"([^\"]*)\" or \"([^\"]*)\"$")
	public void user_should_able_to_view_all_values_under_Status_column_as_or(String valActive, String valInactive) 
	{
		payorStatusPage.verifyColValue(valActive,valInactive);	    
	}

	@Then("^user should able to view all values under Status column as HyperLink$")
	public void user_should_able_to_view_all_values_under_Status_column_as_HyperLink() {
		payorStatusPage.verifyStatusValHyperlink();
	}

	@When("^user clicks on \"([^\"]*)\" hyperlink under status column for any particular Payor name$")
	public void user_clicks_on_hyperlink_under_status_column_for_any_particular_Payor_name(String beforeStatus) {
		payorStatusPage.clickStatusValue(beforeStatus);
	}

	@Then("^user should able to view clicked hyperlink as \"([^\"]*)\" for same Payor name with updated Date$")
	public void user_should_able_to_view_clicked_hyperlink_as_for_same_Payor_name_with_updated_Date(String afterStatus) {
		payorStatusPage.verifyStatusValue(afterStatus);
	}
}
