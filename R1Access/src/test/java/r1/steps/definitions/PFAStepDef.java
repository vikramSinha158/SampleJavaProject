package r1.steps.definitions;

import java.io.IOException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.pages.Navigation;
import r1.pages.PFAPage;
import r1.pages.UserLogin;

public class PFAStepDef extends BasePage {
	
	UserLogin userLogin;
	Navigation navigation;
	R1AccessCommonMethods r1AccessCommonMethods;
	PFAPage pfaPage ;

	@Given("^user is on R(\\d+) Access home page$")
	public void user_is_on_R_Access_home_page(int arg1) throws IOException {
		
	}


	@Given("^user clicks on Settings link$")
	public void user_clicks_on_Settings_link() {
		r1AccessCommonMethods.clickFooterR1AccesModulesTab("Settings");
	    
	}

	@Given("^user clicks on PFA Configuration link$")
	public void user_clicks_on_PFA_Configuration_link() {
	    r1AccessCommonMethods.clickSubSideR1HubModulesMenuLink("PFA Configuration");    
	}

	@Given("^user clicks on PFA Level_1 Questions link$")
	public void user_clicks_on_PFA_Level_1_Questions_link() {
		r1AccessCommonMethods.clickSubSideR1HubModulesMenuLink("PFA Level 1 Questions");	
	}

	@When("^user clicks on New button$")
	public void user_clicks_on_New_button() {
	    r1AccessCommonMethods.clickUpperHeaderLink("New");
	}

	@When("^Input values in the Question Code \"([^\"]*)\" and Question \"([^\"]*)\" fields$")
	public void input_values_in_the_Question_Code_and_Question_fields(String code, String question) {
	   pfaPage.inputPFAQues(code, question);
	}

	@When("^user clicks on is Active check box$")
	public void user_clicks_on_is_Active_check_box() {
	   pfaPage.clickIsActiveQuesChkbox();     
	}

	@When("^user clicks Add button$")
	public void user_clicks_Add_button() {
	    pfaPage.addQuestion();
	}
	
	@Then("^PFA Level1 question should be created with message \"([^\"]*)\"$")
	public void pfa_Level_question_should_be_created_with_message(String mesg) {
	    pfaPage.verifyQuesAddedLabel(mesg);
	}

	@When("^user clicks on New Answer button$")
	public void user_clicks_on_New_Answer_button() {
	    pfaPage.clickNewAns();
	}


	@When("^user input values in the Answer Code \"([^\"]*)\" and Answer Text \"([^\"]*)\" fields$")
	public void user_input_values_in_the_Answer_Code_and_Answer_Text_fields(String code, String ans) {
		pfaPage.inputAns(code, ans);
	}


	@When("^user clicks on Cancel button\\.$")
	public void user_clicks_on_Cancel_button() {
	    pfaPage.clickcancelAns();
	}

	@When("^user clicks on is Active Check box$")
	public void user_clicks_on_is_Active_Check_box() {
	    pfaPage.clickIsActiveAnsChkbox();
	}
	
	@Then("^PFA answers panel should not be appear$")
	public void pfa_answers_panel_should_not_be_appear() {
	    pfaPage.verifyPFAAnsPanel();
	}

	@When("^user clicks on Add Answer button\\.$")
	public void user_clicks_on_Add_Answer_button() {
	    pfaPage.clickAddAns();
	}

	@Then("^new answer should be added in the answers grid with message \"([^\"]*)\"$")
	public void new_answer_should_be_added_in_the_answers_grid_with_message(String msg) {
	    pfaPage.verifyAnsLabelAdded(msg);
	    
	}

	@When("^user clicks on Link Answer button$")
	public void user_clicks_on_Link_Answer_button() {
	    pfaPage.clickLinkAns();
	}

	@When("^user clicks on cancel link answer button\\.$")
	public void user_clicks_on_cancel_link_answer_button() {
	   pfaPage.clickCancelLinkAns();
	}
	
	@Then("^Answer dropdown list, Link New Answer button and Cancel button should not be appear\\.$")
	public void answer_dropdown_list_Link_New_Answer_button_and_Cancel_button_should_not_be_appear() {
	    pfaPage.verifyFieldsNotVisible();
	}

	@When("^user select an created answer from dropdown$")
	public void user_select_an_created_answer_from_dropdown() {
	    pfaPage.selectCreatedAns();
	}

	@When("^user clicks on Link new Answer button\\.$")
	public void user_clicks_on_Link_new_Answer_button() {
	    pfaPage.clickLinkNewAns();
	}

	@Then("^displays added answer in the answers grid placed under Update button$")
	public void displays_added_answer_in_the_answers_grid_placed_under_Update_button() {
	    pfaPage.verifyAnsAdded();   
	}

	@Then("^message \"([^\"]*)\" appear$")
	public void message_appear(String msg) {
	    pfaPage.verifyAnsAddedMessage(msg);
	}

	@When("^user clicks on Unlink Answer button$")
	public void user_clicks_on_Unlink_Answer_button() {
	    pfaPage.clickUnlinkAns();    
	}

	@When("^user select an answer from dropdown$")
	public void user_select_an_answer_from_dropdown() {	    
	    pfaPage.selectAnstoUnlink();
	}

	@When("^user clicks on Unlink Existing Answer button\\.$")
	public void user_clicks_on_Unlink_Existing_Answer_button() {
	    pfaPage.clickUnlinkExistingAns();    
	}

	@Then("^message \"([^\"]*)\" appear for the question should be appear$")
	public void message_appear_for_the_question_should_be_appear(String msg) {
	    pfaPage.verifyAnsUnlinked(msg);
	}



	@Then("^answer should not be appear in answer grid under Update button$")
	public void answer_should_not_be_appear_in_answer_grid_under_Update_button() {
	    
	    
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Given("^user clicks on PFA Funding Source Rules link$")
	public void user_clicks_on_PFA_Funding_Source_Rules_link() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}


	@When("^user open an funding source from worklist$")
	public void user_open_an_funding_source_from_worklist() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user clicks on Add Rule button$")
	public void user_clicks_on_Add_Rule_button() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Add New Rule panel should get disappear$")
	public void add_New_Rule_panel_should_get_disappear() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user input values in Rule name text field\\.$")
	public void user_input_values_in_Rule_name_text_field() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user check the Active Check box$")
	public void user_check_the_Active_Check_box() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user clicks on save button$")
	public void user_clicks_on_save_button() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^if rule name Exists Displays Message PFA Rule with the same name already exists!$")
	public void if_rule_name_Exists_Displays_Message_PFA_Rule_with_the_same_name_already_exists() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^if Rule name does not exists, New Rule should be added$")
	public void if_Rule_name_does_not_exists_New_Rule_should_be_added() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^displays message PFA Rule added successfully$")
	public void displays_message_PFA_Rule_added_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user clicks on add criteria button$")
	public void user_clicks_on_add_criteria_button() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Add New Criteria panel get disappear$")
	public void add_New_Criteria_panel_get_disappear() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user select name from Name dropdown$")
	public void user_select_name_from_Name_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user select value from Operator dropdown$")
	public void user_select_value_from_Operator_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user select value from value dropdown$")
	public void user_select_value_from_value_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	

	@Then("^Criteria should be added in Rules grid with the message \"([^\"]*)\"$")
	public void criteria_should_be_added_in_Rules_grid_with_the_message(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user clicks on patient access link$")
	public void user_clicks_on_patient_access_link() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user clicks on R(\\d+) detect worklist$")
	public void user_clicks_on_R_detect_worklist(int arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user open an account from R(\\d+) detect worklist$")
	public void user_open_an_account_from_R_detect_worklist(int arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^Select all the question answer according to created Rule/Criteria$")
	public void select_all_the_question_answer_according_to_created_Rule_Criteria() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user clicks on Save and Continue button$")
	public void user_clicks_on_Save_and_Continue_button() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^user navigate to Screening Needs\\(L(\\d+)\\) screen And funding source should be configured appear according to created rule$")
	public void user_navigate_to_Screening_Needs_L_screen_And_funding_source_should_be_configured_appear_according_to_created_rule(int arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user open the funding source where created the new rule on PFA funding source rules tab\\.$")
	public void user_open_the_funding_source_where_created_the_new_rule_on_PFA_funding_source_rules_tab() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user clicks on delete button\\.$")
	public void user_clicks_on_delete_button() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^criteria should be disappeared with message Criteria Deleted successfully$")
	public void criteria_should_be_disappeared_with_message_Criteria_Deleted_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^select all the question answer according to deleted criteria from rule$")
	public void select_all_the_question_answer_according_to_deleted_criteria_from_rule() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^user navigate to Screening Needs\\(L(\\d+)\\) screen And funding source should not be configured appear according to created rule\\.$")
	public void user_navigate_to_Screening_Needs_L_screen_And_funding_source_should_not_be_configured_appear_according_to_created_rule(int arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}


	@When("^user clicks on Delete Rule button\\.$")
	public void user_clicks_on_Delete_Rule_button() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Rule should be disappeared with message Rule deactivated successfully$")
	public void rule_should_be_disappeared_with_message_Rule_deactivated_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^Select all the question answer according to deleted rule$")
	public void select_all_the_question_answer_according_to_deleted_rule() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^user navigate to Screening Needs\\(L(\\d+)\\) screen And funding source should not be configured appear according to delete rule\\.$")
	public void user_navigate_to_Screening_Needs_L_screen_And_funding_source_should_not_be_configured_appear_according_to_delete_rule(int arg1) {
	    
	    
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
