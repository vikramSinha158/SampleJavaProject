package r1.steps.definitions;

import java.io.IOException;
import java.sql.SQLException;

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
	String eId;

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
	    pfaPage.verifyAnsRemoved();    
	}

	
	// 491028	


	@When("^user clicks on R1 detect worklist$")
	public void user_clicks_on_R_detect_worklist() {
	   r1AccessCommonMethods.clickSubSideR1HubModulesMenuLink("R1 Detect");
		/*
		 * r1AccessCommonMethods.clickSubSideR1HubModulesMenuLink("Pre-Registration");
		 * r1AccessCommonMethods.clickOnUnassignedAccount();
		 * r1AccessCommonMethods.clickR1AccesModulesTab("PFA"); pfaPage.
		 * verifyAnsweForPregnancy("Are you pregnant or is your upcoming visit pregnancy related?"
		 * );
		 */ 
	}


	@When("^user fetch the encounterid from Query \"([^\"]*)\"$")
	public void user_fetch_the_encounterid_from_Query(String qNo) throws ClassNotFoundException, IOException, SQLException {
	    eId = pfaPage.runQuery(qNo);
	}

	@When("^user clicks on SEARCH link$")
	public void user_clicks_on_SEARCH_link() {
	    r1AccessCommonMethods.clickUpperHeaderLink("Search");
	}

	@When("^enters the encounterid in visit Text field$")
	public void enters_the_encounterid_in_visit_Text_field() {
	    r1AccessCommonMethods.enterVisitNumber(eId);
	}

	@When("^user clicks on Search button$")
	public void user_clicks_on_Search_button() {
	    r1AccessCommonMethods.clickOnSearchButton();  
	}

	@Then("^Default answer should be No selected for question \"([^\"]*)\" on L1Screening Questions tab$")
	public void default_answer_should_be_No_selected_for_question_on_L_Screening_Questions_tab(String ques) {
	    pfaPage.verifyAnsweForPregnancy(ques);
	}
	
	@Then("^no answer is selected for the question \"([^\"]*)\" on L1Screening Questions tab$")
	public void no_answer_is_selected_for_the_question_on_L1_Screening_Questions_tab(String ques) {
	    pfaPage.verifyNoAnswerSelectedforPregnancy(ques);
	}
	
	
	
	
}
