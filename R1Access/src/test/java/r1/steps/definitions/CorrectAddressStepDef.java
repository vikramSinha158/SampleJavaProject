package r1.steps.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.R1AccessCommonMethods;
import r1.pages.CorrectAddressPage;
import r1.pages.Navigation;
import r1.pages.UserLogin;

public class CorrectAddressStepDef {
	
	CorrectAddressPage correctAddressPage;
	UserLogin userLogin;
	Navigation navigation;
	R1AccessCommonMethods R1AccessCommonMethodsRef;
	

@Given("^user is on correct address worklist page$")
public void user_is_on_correct_address_worklist_page() {
	correctAddressPage.verifyWorkListTitle("Returned Mail");
}

@When("^user clicks on MRN column to sort the records$")
public void user_clicks_on_MRN_column_to_sort_the_records() {
	correctAddressPage.clickMRNColHeader();
}

@Then("^user should able to view sorted records with no duplicate MRN on worklist$")
public void user_should_able_to_view_sorted_records_with_no_duplicate_MRN_on_worklist() {
	correctAddressPage.sorting("MRN");
}

@Then("^user should not view any accounts with prior balance equals to zero or null on worklist$")
public void user_should_not_view_any_accounts_with_prior_balance_equals_to_zero_or_null_on_worklist() {
	correctAddressPage.verifyPriorBalNotNull("Prior Balance");
}

@Then("^user should able to view (\\d+) records on worklist$")
public void user_should_able_to_view_records_on_worklist(int num) {
	correctAddressPage.verifyWorkListRecordCount(num);
}

@When("^user connects to trandb and run the \"([^\"]*)\" by passing any one MRN from worklist$")
public void user_connects_to_trandb_and_run_the_by_passing_any_one_MRN_from_worklist(String arg1) {
    // Write code here that turns the phrase above into concrete actions
    
}

@Then("^user should able to view multiple Account with one MRN$")
public void user_should_able_to_view_multiple_Account_with_one_MRN() {
    // Write code here that turns the phrase above into concrete actions
    
}

@When("^user clicks on any account$")
public void user_clicks_on_any_account() {
	correctAddressPage.clickRecord();
}

@When("^user clicks on any account having \"([^\"]*)\" greater than \"([^\"]*)\"$")
public void user_clicks_on_any_account_having_greater_than(String arg1, String arg2) {
	
	correctAddressPage.filterClickRecord(arg1,arg2);
}


@Then("^user should able to view \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" tab$")
public void user_should_able_to_view_tab(String tab1, String tab2, String tab3, String tab4) {
	correctAddressPage.verifyAccountDetailMenuLink(tab1);
	correctAddressPage.verifyAccountDetailMenuLink(tab2);
	correctAddressPage.verifyAccountDetailMenuLink(tab3);
	correctAddressPage.verifyAccountDetailMenuLink(tab4);
}

@Then("^user should able to view patient tab by default$")
public void user_should_able_to_view_patient_tab_by_default() {
	correctAddressPage.verifyPatTabAsDefault();
}

@Then("^user should able to view patient demographics information on patient tab$")
public void user_should_able_to_view_patient_demographics_information_on_patient_tab() {
	correctAddressPage.verifyPatDemoVisible();
}

@Then("^user should able to view data loaded on settlement tab$")
public void user_should_able_to_view_data_loaded_on_settlement_tab() {
	correctAddressPage.verifyDataOnSettlementTab();
}

@When("^user add notes$")
public void user_add_notes() {
	correctAddressPage.addNotes("Test");
}

@Then("^user should able to view Notes entered$")
public void user_should_able_to_view_Notes_entered() {
	correctAddressPage.verifyAddedNotes("Test");
}

@Then("^user should able to view Action log$")
public void user_should_able_to_view_Action_log() {
	correctAddressPage.verifyActionLog();
}

@When("^user clicks on footer patient access tab$")
public void user_clicks_on_footer_patient_access_tab() {
	R1AccessCommonMethodsRef.clickFooterR1AccesModulesTab("Patient Access");
}

@When("^user marks Returned Mail checkbox as checked$")
public void user_marks_Returned_Mail_checkbox_as_checked() {
	correctAddressPage.clickReturnedMailChkBox();
}

@When("^user click on update button$")
public void user_click_on_update_button() {
	correctAddressPage.clickUpdateBtn();
}

@When("^user fetches the Account num$")
public void user_fetches_the_Account_num() {
	correctAddressPage.fetchAccountNum();
}

@Then("^user should able to view same fetched account on correct address worklist$")
public void user_should_able_to_view_same_fetched_account_on_correct_address_worklist() {
	correctAddressPage.verifyAccInWrkLst();
}

}
