package r1.steps.definitions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.pages.Settlement;
import r1.pages.UserLogin;

public class SettlementStepDef extends BasePage {

	UserLogin userLogin;
	R1AccessCommonMethods commonMethods;
	Settlement settlement;
	String eId ;

	@Given("^user is on Pre-registration worklist$")
	public void user_is_on_Pre_registration_worklist() {
	    settlement.verifyPreRegWorklist();  
	}

	@When("^user filters the account having \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_filters_the_account_having(String filter, String operator, String val) {
	     commonMethods.ddlWorkListFilter(filter, operator, val);
	}

	@When("^user selects an account having prior balance greater than zero$")
	public void user_selects_an_account_having_prior_balance_greater_than_zero() {
	     commonMethods.clickOnUnassignedAccount();
	}

	@When("^user is able to view the R(\\d+) access modules tab$")
	public void user_is_able_to_view_the_R_access_modules_tab(int arg1) {
	     settlement.verifyR1AccessTabs();
	}

	@When("^user clicks on Settlement tab$")
	public void user_clicks_on_Settlement_tab() {
	    commonMethods.clickR1AccesModulesTab("Settlement");
	}

	@Then("^user is able to view Settlement tab color as \"([^\"]*)\"$")
	public void user_is_able_to_view_Settlement_tab_color_as(String arg1) {
		Assert.assertTrue(commonMethods.checkTabColor("Settlement").equals("Red"));     
	}

	@Then("^Settlement tab status as \"([^\"]*)\"$")
	public void settlement_tab_status_as(String arg1) {
		Assert.assertTrue(commonMethods.chkTabStatusIncompleteComplete().equals("Incomplete"));
	}

	@Then("^user is able to view Prior Balance label$")
	public void user_is_able_to_view_Prior_Balance_label() {
	     settlement.verifyPriorBal();
	}

	@Then("^fields on the tab becomes editable$")
	public void fields_on_the_tab_becomes_editable() {
	     settlement.verifyTabisEditable();
	}	

	@When("^user enters the encounterid in search textbox$")
	public void user_enters_the_encounterid_in_search_textbox() {
		commonMethods.enterVisitNumber(eId);
	}
	
	@When("^user runs the query and fetches the encounterid_(\\d+)$")
	public void user_runs_the_query_and_fetches_the_encounterid_(int arg1) throws ClassNotFoundException, IOException, SQLException {
	    eId = settlement.runQuery();
	}

	@Then("^user should be able to view Total Payments panel$")
	public void user_should_be_able_to_view_Total_Payments_panel_and_amount() {
	   settlement.verifyTotalPaymentsPanel();
	}
	
	@When("^user clicks on expand button$")
	public void user_clicks_on_expand_button() {
	    settlement.clickTotalPaymentsExpandbtn();
	}
	
    @Then("^user should be able to view corresponding columns$")
	public void user_should_be_able_to_view_corresponding_columns(DataTable dt) { 
	    List<String> colmns = dt.asList(String.class);
	    settlement.verifyTotalPaymentsPanelColumns(colmns);
	}
	 
	@Then("^sum of all the values under Amount column should be equal to Total Payments value$")
	public void user_calculate_the_sum_of_all_the_values_under_Amount_column() {
	    settlement.verifyTotalPaymentsVal();
	}

	@When("^user clicks on an account$")
	public void user_clicks_on_an_account() {
		commonMethods.clickOnUnassignedAccount();
	}

	@Then("^user should be able to view show all related visits checkbox as unchecked$")
	public void user_should_be_able_to_view_show_all_related_visits_checkbox_as_unchecked() {
		settlement.verifyRelatedVisitChkboxUnchecked();
	}

	@Then("^No payment selected in Primary Disposition label$")
	public void no_payment_selected_in_Primary_Disposition_label() {
		settlement.verifyPrimaryDisposition();
	}

	@Then("^Select One value is displayed in Non-Collection Reason$")
	public void select_One_value_is_displayed_in_Non_Collection_Reason() {
		settlement.verifyNonCollReason();
	}	
	
}
