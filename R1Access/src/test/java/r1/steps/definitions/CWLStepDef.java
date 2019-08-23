package r1.steps.definitions;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.pages.CWLPage;

public class CWLStepDef extends BasePage {

/*	 @391768 Patient_Verify address verification functionality */
	
	CWLPage cwl;
	
	@When("^Click on \"([^\"]*)\" menu$")
	public void click_on_menu(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		cwl.click_setting();
	   
	}

	@Then("^List of sub-menus should be displayed in left panel$")
	public void list_of_sub_menus_should_be_displayed_in_left_panel() {
	    // Write code here that turns the phrase above into concrete actions
	     cwl.submenuList();;
	}

	@When("^Mouse hover on \"([^\"]*)\" menu$")
	public void mouse_hover_on_menu(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		cwl.select_submenu("Payor and Plan Config");
		
	    
	}

	@Then("^Sub menu list of worklist for \"([^\"]*)\" menu should be displayed$")
	public void sub_menu_list_of_worklist_for_menu_should_be_displayed(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		cwl.settingSubmenuList();
	}

	@When("^Click on 'Conversion Plan Mapping' sub menu$")
	public void click_on_Conversion_Plan_Mapping_sub_menu() {
	    // Write code here that turns the phrase above into concrete actions
		cwl.payorcon_submenu("Conversion Plan Mapping");
	    
	}
	
	@Then("^All the necessary plan codes which are mapped into CWL should be displayed$")
	public void all_the_necessary_plan_codes_which_are_mapped_into_CWL_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    cwl.verifyCPMSize();
	}
	

	/*Test Case 391787:CWL_Verify the filter folders in the worklist*/
	
	@When("^user click on \"([^\"]*)\"$")
	public void user_click_on(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	   cwl.clickOnpatientAccess();
	}

	@When("^user user clicks on Conversion Follow up$")
	public void user_user_clicks_on_Conversion_Follow_up() {
	    // Write code here that turns the phrase above into concrete actions
	  cwl.clickConversionfollowup();	}
	


	@Then("^verify following filter folder lists$")
	public void verify_following_filter_folder_lists() {
	    // Write code here that turns the phrase above into concrete actions
		cwl.filterList();
	    
	}
	
	// Test Case 391788:CWL_Verify records in "I/S at Risk" filter folder
	
	@When("^user clicks \"([^\"]*)\"$")
	public void user_clicks(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		cwl.clickOnIsRisk();
	    
	}

	
	@Then("^verify \"([^\"]*)\" value$")
	public void verify_value(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		cwl.conversiontable("I", "S");
	    
	}

	@Then("^Verify NFU date$")
	public void verify_NFU_date() {
	    // Write code here that turns the phrase above into concrete actions
		cwl.verifyNfuDt();
	    
	}
	
	@Then("^Verify Total Open Balance value$")
	public void verify_Total_Open_Balance_value() {
	    // Write code here that turns the phrase above into concrete actions
	   cwl.verifyTotalBal();
	}

	@Then("^LA column(.*) \"([^\"]*)\" / \"([^\"]*)\"$")
	public void la_column(String arg1, String arg2, String arg3) {
	    // Write code here that turns the phrase above into concrete actions
	    cwl.verifyLA();
	}

	/*----------------Test Case 391788:CWL_Verify records in "E/O" at Risk" filter folder--------------------------*/
	
	@Then("^user clicks E/O at Risk$")
	public void user_clicks_E_O_at_Risk() {
	    // Write code here that turns the phrase above into concrete actions
		cwl.clickEoRisk();
	}

	@Then("^verify \"([^\"]*)\" value as 'E' OR 'O'$")
	public void verify_value_as_E_OR_O(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		cwl.conversiontable("E", "O");
	    
	}
	
	/*----------------Test Case 391788:CWL_Verify records in "Future Follow Up" filter folder--------------------------*/

	@Then("^user clicks Future Follow Up$")
	public void user_clicks_Future_Follow_Up() {
	    // Write code here that turns the phrase above into concrete actions
		cwl.clickFutureFollowUp();
	    
	}
	
	
	/*----------------Test Case 391791:CWL_Verify records in "Zero Balance" filter folder--------------------------*/
	
	@Then("^user clicks Zero Balance$")
	public void user_clicks_Zero_Balance() {
	    // Write code here that turns the phrase above into concrete actions
		cwl.clickZeroBalance();
	    
	}


 @Then("^verify total open balance=(\\d+)$")
 public void verify_total_open_balance(int arg1) {
    // Write code here that turns the phrase above into concrete actions
	 cwl.verifyTotalzeroBal();
   
  }
	/*------------------------------------------Test Case 391809:CWL_Verify "Secondary Audit Action" functionality-------------------------------*/
 
 @When("^select any records from conversion followup$")
 public void select_any_records_from_conversion_followup() {
     // Write code here that turns the phrase above into concrete actions
     
 }

 @Then("^record with \"([^\"]*)\" tab loaded should be opened up$")
 public void record_with_tab_loaded_should_be_opened_up(String arg1) {
     // Write code here that turns the phrase above into concrete actions
     
 }

 @Then("^verify Secondary Audit Action panel displayed$")
 public void verify_Secondary_Audit_Action_panel_displayed() {
     // Write code here that turns the phrase above into concrete actions
    
 }

 @When("^save secondary audit action without selecting checkboxes$")
 public void save_secondary_audit_action_without_selecting_checkboxes() {
     // Write code here that turns the phrase above into concrete actions
    
 }

 @Then("^Please select the action to update should be displayed$")
 public void please_select_the_action_to_update_should_be_displayed() {
     // Write code here that turns the phrase above into concrete actions
    
 }

 @Then("^No record should get added to the \"([^\"]*)\" panel$")
 public void no_record_should_get_added_to_the_panel(String arg1) {
     // Write code here that turns the phrase above into concrete actions
    
 }

 @When("^check all the checkboxes and select value from Final status dropdown and save$")
 public void check_all_the_checkboxes_and_select_value_from_Final_status_dropdown_and_save() {
     // Write code here that turns the phrase above into concrete actions
    
 }

 @Then("^verify \"([^\"]*)\" panel records should be added$")
 public void verify_panel_records_should_be_added(String arg1) {
     // Write code here that turns the phrase above into concrete actions
    
 }

 @Then("^If \"([^\"]*)\" is\"([^\"]*)\" no log goes for it$")
 public void if_is_no_log_goes_for_it(String arg1, String arg2) {
     // Write code here that turns the phrase above into concrete actions
    
 }

 @Then("^Verify value in Disposition according to final status$")
 public void verify_value_in_Disposition_according_to_final_status() {
     // Write code here that turns the phrase above into concrete actions
    
 }

 @Then("^Verify mass-update panel$")
 public void verify_mass_update_panel() {
     // Write code here that turns the phrase above into concrete actions
    
 }

 
 
 
 
 
 
 
 
 
}
