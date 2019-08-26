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
	    
		cwl.click_setting();
	   
	}

	@Then("^List of sub-menus should be displayed in left panel$")
	public void list_of_sub_menus_should_be_displayed_in_left_panel() {
	    
	     cwl.submenuList();;
	}

	@When("^Mouse hover on \"([^\"]*)\" menu$")
	public void mouse_hover_on_menu(String arg1) {
	    
		cwl.select_submenu("Payor and Plan Config");
		
	    
	}

	@Then("^Sub menu list of worklist for \"([^\"]*)\" menu should be displayed$")
	public void sub_menu_list_of_worklist_for_menu_should_be_displayed(String arg1) {
	    
		cwl.settingSubmenuList();
	}

	@When("^Click on 'Conversion Plan Mapping' sub menu$")
	public void click_on_Conversion_Plan_Mapping_sub_menu() {
	    
		cwl.payorcon_submenu("Conversion Plan Mapping");
	    
	}
	
	@Then("^All the necessary plan codes which are mapped into CWL should be displayed$")
	public void all_the_necessary_plan_codes_which_are_mapped_into_CWL_should_be_displayed() {
	    
	    cwl.verifyCPMSize();
	}
	

	/*Test Case 391787:CWL_Verify the filter folders in the worklist*/
	
	@When("^user click on \"([^\"]*)\"$")
	public void user_click_on(String arg1) {
	    
	   cwl.clickOnpatientAccess();
	}

	@When("^user user clicks on Conversion Follow up$")
	public void user_user_clicks_on_Conversion_Follow_up() {
	    
	  cwl.clickConversionfollowup();	}
	


	@Then("^verify following filter folder lists$")
	public void verify_following_filter_folder_lists() {
	    
		cwl.filterList();
	    
	}
	
	// Test Case 391788:CWL_Verify records in "I/S at Risk" filter folder
	
	@When("^user clicks \"([^\"]*)\"$")
	public void user_clicks(String arg1) {
	    
		cwl.clickOnIsRisk();
	    
	}

	
	@Then("^verify \"([^\"]*)\" value$")
	public void verify_value(String arg1) {
	    
		cwl.conversiontable("I", "S");
	    
	}

	@Then("^Verify NFU date$")
	public void verify_NFU_date() {
	    
		cwl.verifyNfuDt();
	    
	}
	
	@Then("^Verify Total Open Balance value$")
	public void verify_Total_Open_Balance_value() {
	    
	   cwl.verifyTotalBal();
	}

	@Then("^LA column(.*) \"([^\"]*)\" / \"([^\"]*)\"$")
	public void la_column(String arg1, String arg2, String arg3) {
	    
	    cwl.verifyLA();
	}

	/*----------------Test Case 391788:CWL_Verify records in "E/O" at Risk" filter folder--------------------------*/
	
	@Then("^user clicks E/O at Risk$")
	public void user_clicks_E_O_at_Risk() {
	    
		cwl.clickEoRisk();
	}

	@Then("^verify \"([^\"]*)\" value as 'E' OR 'O'$")
	public void verify_value_as_E_OR_O(String arg1) {
	    
		cwl.conversiontable("E", "O");
	    
	}
	
	/*----------------Test Case 391788:CWL_Verify records in "Future Follow Up" filter folder--------------------------*/

	@Then("^user clicks Future Follow Up$")
	public void user_clicks_Future_Follow_Up() {
	    
		cwl.clickFutureFollowUp();
	    
	}
	
	
	/*----------------Test Case 391791:CWL_Verify records in "Zero Balance" filter folder--------------------------*/
	
	@Then("^user clicks Zero Balance$")
	public void user_clicks_Zero_Balance() {
	    
		cwl.clickZeroBalance();
	    
	}


 @Then("^verify total open balance=(\\d+)$")
 public void verify_total_open_balance(int arg1) {
    
	 cwl.verifyTotalzeroBal();
   
  }

 
 
 
 
 
 
 
 
 
}
