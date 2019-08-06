package r1.steps.definitions;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.commons.utilities.AssertValues;
import r1.pages.ClearancePage;
import r1.pages.UserLogin;

public class ClearanceIStepDef extends BasePage{


 	UserLogin userLogin;
 	r1.pages.Navigation navigation;
 	ClearancePage clearancePage;
 	R1AccessCommonMethods commonMethods;
 	String accountNumber;
 	
 	//private static final org.apache.logging.log4j.Logger LOGGER = (org.apache.logging.log4j.Logger) Logger.getLogger(AssertValues.class.getName());

	

@When("^user clicks on \"([^\"]*)\"$")
public void user_clicks_on(String arg1) {
	clearancePage.clickPatientAccess();
	clearancePage.clickPreRegistration();
    
}


@When("^user clicks on \"([^\"]*)\" expand button$")
public void user_clicks_on_expand_button(String arg1) {
	
	clearancePage.clickPatientAccess();
	clearancePage.clickPreRegistration();
	clearancePage.clickIncompleteTaskExpButton();
    
}
/*
@Then("^user clicks on \"([^\"]*)\" sub filter folder$")
public void user_clicks_on_sub_filter_folder(String arg1) {
	
	clearancePage.clickClearanceIncompleteTask();
	commonMethods.clickR1AccesModulesTab("Clearance");
    
}*/

@Then("^user clicks on any Account from filter subfolder$")
public void user_clicks_on_any_Account_from_filter_subfolder() {
	commonMethods.clickOnUnassignedAccount();
    
}

@Then("^user clicks on Clearance tab$")
public void user_clicks_on_Clearance_tab() {
	commonMethods.clickR1AccesModulesTab("Clearance");
    
}

@When("^user clicks on Clearance sub filter folder$")
public void user_clicks_on_Clearance_sub_filter_folder() {
	clearancePage.clickClearanceIncompleteTask();
	
}


@Given("^user is on Clearance tab$")
public void user_is_on_Clearance_tab() {
	clearancePage.verifyClearanceTabPage("Clearance");
	
}

@When("^user clicks on Checkout button$")
public void user_clicks_on_Checkout_button() {
    commonMethods.clickOnCheckOut();
    
}

@When("^user set the value of MSP and Order checkbox to Checked$")
public void user_set_the_value_of_MSP_and_Order_checkbox_to_Checked() {
    clearancePage.clickOnMSPCheckBox();
}

@When("^user set the value of Clearance  checkbox equals to Checked$")
public void user_set_the_value_of_Clearance_checkbox_equals_to_Checked() {
    clearancePage.clickClearanceCheckBox();
    
}

@Then("^user should be able to view MSP and Order checkbox to be Checked$")
public void user_should_be_able_to_view_MSP_and_Order_checkbox_to_be_Checked() {
	clearancePage.verifyMspCheckBox();
	clearancePage.verifyClearanceCheckBox();
    
}

@Then("^user should be able to view tab Status equal to Completed and tab and tab ribbon color equal to Blue$")
public void user_should_be_able_to_view_tab_Status_equal_to_Completed_and_tab_and_tab_ribbon_color_equal_to_Blue() {
   clearancePage.verifyStatus();
	
    
}


@When("^user clicks on Log tab$")
public void user_clicks_on_Log_tab() {
	commonMethods.clickR1AccesModulesTab("Log");
    
}

@Then("^user should be able to see a log for Task equal to Clearance and Status equal to Completed$")
public void user_should_be_able_to_see_a_log_for_Task_equal_to_Clearance_and_Status_equal_to_Completed() {
	accountNumber = clearancePage.getAccountNumber();
	clearancePage.verifyCheckboxChecked();
	 
}


@Then("^user should not able to see the account in the worklist$")
public void user_should_not_able_to_see_the_account_in_the_worklist() {
	clearancePage.clickClearanceIncompleteTask();
	clearancePage.verifyPresenceOfAccountInWorkList(accountNumber);
	
}

@When("^user clicks on worklist folder$")
public void user_clicks_on_worklist_folder() {
	clearancePage.clickGlobalWorklist();	
    
}

@Then("^user is able to see the account in the worklist using filter criteria$")
public void user_is_able_to_see_the_account_in_the_worklist_using_filter_criteria() {
	clearancePage.verifyPresenceOfAccountInWorkList(accountNumber);
    
}

@Then("^user is able to see the traffic light in BLUE color for the record$")
public void user_is_able_to_see_the_traffic_light_in_BLUE_color_for_the_record() {
    
    
}


@When("^user clicks on Redo button$")
public void user_clicks_on_Redo_button() {
   commonMethods.clickOnCheckOut();
	
}

@Then("^user is able to see Clearance check box becomes unchecked and enabled for editing with Clearance tab color as RED$")
public void user_is_able_to_see_Clearance_check_box_becomes_unchecked_and_enabled_for_editing_with_Clearance_tab_color_as_RED() {
	commonMethods.clickOnCheckOut();
    
}

@Then("^user is able to see the Log page related to that account$")
public void user_is_able_to_see_the_Log_page_related_to_that_account() {
    
    
}

@Then("^user is able to see a log for Task equal to Clearance and Status equal to Redo$")
public void user_is_able_to_see_a_log_for_Task_equal_to_Clearance_and_Status_equal_to_Redo() {
    
    
}

@Then("^user is able to see Accounts having RED traffic light under CI filter folder in the filtered worklist$")
public void user_is_able_to_see_Accounts_having_RED_traffic_light_under_CI_filter_folder_in_the_filtered_worklist() {
    
    
}

@Then("^user is able to see MSP checkbox on Clearance tab as checked in case of non medicare accounts$")
public void user_is_able_to_see_MSP_checkbox_on_Clearance_tab_as_checked_in_case_of_non_medicare_accounts() {
    
    
}

@Then("^MSP tab gets automatically checked$")
public void msp_tab_gets_automatically_checked() {
    
    
}

@Then("^user is able to see Clearance Tab should be visible in RED color$")
public void user_is_able_to_see_Clearance_Tab_should_be_visible_in_RED_color() {
    
    
}

@Then("^user is able to see MSP check box on Clearance tab$")
public void user_is_able_to_see_MSP_check_box_on_Clearance_tab() {
    
    
}

@Then("^user is able to see Clearance tab doesnt get automatically checked in case of medicare coverage accounts$")
public void user_is_able_to_see_Clearance_tab_doesnt_get_automatically_checked_in_case_of_medicare_coverage_accounts() {
    
    
}


	
}
