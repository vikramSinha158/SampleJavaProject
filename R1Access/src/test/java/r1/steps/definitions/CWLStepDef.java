package r1.steps.definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.pages.CWLPage;

public class CWLStepDef extends BasePage {

	CWLPage cwl;

	@When("^Click on \"([^\"]*)\" menu$")
	public void click_on_menu(String arg1) {
      cwl.click_setting();
    }

	@Then("^List of sub-menus should be displayed in left panel$")
	public void list_of_sub_menus_should_be_displayed_in_left_panel() {
      cwl.submenuList();
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

	@Then("^verify following filter folder lists$")
	public void verify_following_filter_folder_lists() {
	   cwl.filterList();
	}

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

	@Then("^user clicks E/O at Risk$")
	public void user_clicks_E_O_at_Risk() {
       cwl.clickEoRisk();
	}

	@Then("^verify \"([^\"]*)\" value as 'E' OR 'O'$")
	public void verify_value_as_E_OR_O(String arg1) {
       cwl.conversiontable("E", "O");
    }

	@Then("^user clicks Future Follow Up$")
	public void user_clicks_Future_Follow_Up() {
       cwl.clickFutureFollowUp();
    }

	@Then("^user clicks Zero Balance$")
	public void user_clicks_Zero_Balance() {
       cwl.clickZeroBalance();
    }

	@Then("^verify total open balance=(\\d+)$")
	public void verify_total_open_balance(int arg1) {
       cwl.verifyTotalzeroBal();
    }

}
