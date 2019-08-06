package r1.steps.definitions;

import java.io.IOException;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.pages.NotesPage;
import r1.pages.UserLogin;

public class UserLoginSteps extends BasePage {

	UserLogin loginPage;
	NotesPage chartManagerpage;

	@Given("^user is on Login page$")
	public void user_is_on_home_page() {
	    Assert.assertTrue("Username Field not present", loginPage.VerifyUsernameTextBox());
	}
	
	@When("^user enters Email and Password$")
	public void user_enters_and() throws IOException {
		loginPage.EnterCredentials();
	}

	@When("^user clicks on login button$")
	public void clicks_on_Sign_In_button() {
		loginPage.ClickLoginButton();
	}

	@Then("^user is on the Home page$")
	public void user_is_successfully_logged_In() {
		//chartManagerpage.VerifyPagetitle();
	}
	
	
}
