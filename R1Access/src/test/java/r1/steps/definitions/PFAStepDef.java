package r1.steps.definitions;

import java.io.IOException;
import java.sql.SQLException;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.pages.Navigation;
import r1.pages.PFAPage;
import r1.pages.UserLogin;

public class PFAStepDef extends BasePage {
	
	PFAPage pfaPage;
	UserLogin userLogin;
	Navigation navigation;
	R1AccessCommonMethods commonMethodsR1Access;
	
	@When("^user clicks on Unworked subfolder$")
	public void user_clicks_on_Unworked_subfolder() {
		pfaPage.clickUnworkedFilterFolder();
	}

	@When("^user open an account from unworked subfolder worklist$")
	public void user_open_an_account_from_unworked_subfolder_worklist() {
		commonMethodsR1Access.clickOnUnassignedAccount();
	}
	
	@Then("^\"([^\"]*)\" tab color should be visible \"([^\"]*)\"$")
	public void tab_color_should_be_visible(String arg1, String arg2) {
	    
	}

    @When("^user clicks on \"([^\"]*)\" tab$")
	public void user_clicks_on_tab(String tab) {
		commonMethodsR1Access.clickR1AccesModulesTab(tab);
	}

	@When("^check out the account$")
	public void check_out_the_account() {
		commonMethodsR1Access.clickOnCheckOut();
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

    @Then("^\"([^\"]*)\" tab color should be visible blue$")
	public void tab_color_should_be_visible_blue(String tabColor) {
		pfaPage.verifyTabColor(tabColor);
	   
	}
	

	@Then("^status should be \"([^\"]*)\" appear$")
	public void status_should_be_appear(String status) {
		pfaPage.verifyTabStatus(status);
	    
	    
	}


	

}
