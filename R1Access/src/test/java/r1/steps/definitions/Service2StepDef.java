
package r1.steps.definitions;

import java.io.IOException;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.pages.Service2Page;

public class Service2StepDef extends BasePage{
	
	R1AccessCommonMethods r1AccessCommonMethod;
	Service2Page service2;
				
	@When("^user clicks on any Unassigned Account$")
	public void user_clicks_on_any_Unassigned_Account() {
		r1AccessCommonMethod.clickOnUnassignedAccount();
	}


	@When("^user clicked on \"([^\"]*)\" tab$")
	public void user_clicked_on_tab(String Text) {
		r1AccessCommonMethod.clickR1AccesModulesTab(Text);
	}

	@Then("^verify the fields before checkout$")
	public void verify_the_fields_before_checkout() {
		r1AccessCommonMethod.verifyActionStatusTabBeforeCheckout();
	}

	@When("^user clicked on checkout button$")
	public void user_clicked_on_checkout_button() {
		r1AccessCommonMethod.clickOnCheckOut();
	}
	
	@When("^user clicked on Admitting if exists$")
	public void user_clicked_on_Admitting_if_exists() {
		service2.clickOnAdmiting();
	}

	@Then("^verify the fields after the checkout$")
	public void verify_the_fields_after_the_checkout() {
		r1AccessCommonMethod.verifyActionStatusAfterCheckout();  
	}

	@When("^user enter services like \"([^\"]*)\" in search field$")
	public void user_enter_services_like_in_search_field(String Text) {
		service2.enterCodes(Text);
		service2.clickOnSearch();
	}

	@Then("^searched result should be shown in service pane$")
	public void searched_result_should_be_shown_in_service_pane() {	    
		service2.verifyServiceSearchResults();
	}

	@Then("^verify radio buttons$")
	public void verify_radio_buttons() {
		service2.verifySingleMultipleRadioBtn();
	}

	@When("^user add services$")
	public void user_add_services() {
		service2.addServicesSearchResults();
	}

	@Then("^verify service should be added$")
	public void verify_service_should_be_added() {
		service2.verifyServiceShouldBeAdded();
	}

	@When("^user delete added services$")
	public void user_delete_added_services() {
		service2.deleteServices();		
	}

	@Then("^service search result grid will not be displayed$")
	public void service_search_result_grid_will_not_be_displayed() {
		service2.verifyServiceGridIsNotDisplayed();

	}

	@When("^user clicks on \"([^\"]*)\" btn$")
	public void user_clicks_on_btn(String Text) {
		r1AccessCommonMethod.clickActionStatusTab(Text);
	}

	@Then("^single multiple radio buttons of pricing will not be displayed$")
	public void single_multiple_radio_buttons_of_pricing_will_not_be_displayed() {
		service2.verifySingleMultipleRadioBtnNotExists();
	}
	
	@When("^user add ICD Codes$")
	public void user_add_ICD_Codes() {	    
		service2.addICDDiagnosisCodes();
	}


   @Then("^verify the status of the tab is completed$")
   public void verify_the_status_of_the_tab_is_completed() {  
	   service2.verifyTabColorAndCompleteStatus();
	   
   }


  @Then("^verify that up down arrow key is moving of ICD codes$")
  public void verify_that_up_down_arrow_key_is_moving_of_ICD_codes() {
   
	  
	  
	  
	  
	  
	  
  }

@When("^user clicked on \"([^\"]*)\" btn$")
public void user_clicked_on_btn(String arg1) {
	
	service2.clickOnExceptionContinueButton("Continue");
}
	
	
}


