package r1.steps.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.pages.Navigation;
import r1.pages.NotesPage;
import r1.pages.UserLogin;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.commons.databaseconnection.DatabaseConn;


public class NotesStepDef extends BasePage {

	NotesPage notesPage;
	UserLogin userLogin;
	Navigation navigation;
	R1AccessCommonMethods r1AccessCommonMethod;
	String encounterId;

	@Given("^user is on R1 hub page$")
	public void user_is_on_R1_hub_page() throws IOException {
		OpenBrowser();
		userLogin.EnterCredentials();
		userLogin.ClickLoginButton();
	}

	@Given("^user is on hub page$")
	public void user_is_on_hub_page() throws IOException {
		navigation.clickR1Logo();
	}

	@When("^user clicks on facility list$")
	public void user_clicks_on_facility_list() throws InterruptedException {
		navigation.clickFacilityList();
	}

	@And("^user select the facility \"([^\"]*)\"$")
	public void user_select_the_facility(String facility) throws IOException {
		navigation.selectFacility(facility);
	}

	@And("^user clicks on \"([^\"]*)\" menu$")
	public void user_clicks_on_menu(String menu) {
		navigation.clickMenu(menu);
	}

	@Then("^user should be able to view the \"([^\"]*)\" label on worklist page$")
	public void user_should_be_able_to_view_the_label_on_worklist_page(String worklist) {
		notesPage.verifyWorkListTitle(worklist);
	}
	
    @Then("^user fetch the \"([^\"]*)\" from Query$")
    public void user_fetch_the_from_Query(String query) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
    	notesPage.runQueryTranServer(query);
		DatabaseConn.resultSet.next();
		encounterId = DatabaseConn.resultSet.getString("encounterid");
    }

	@Given("^user is on account detail page$")
	public void user_is_on_account_detail_page() {
		notesPage.verifyAccountDetailPage();
	}

	@Then("^user should be able to view Notes label$")
	public void user_should_be_able_to_view_Notes_label() {
		notesPage.verifyNotesLabel();
	}

	@Then("^user clicks on the green \\+ icon$")
	public void user_clicks_on_the_green_icon() {
		notesPage.clickNotesIcon();
	}

	@Then("^user should be able to view notes entry drop down$")
	public void user_should_be_able_to_view_notes_entry_drop_down() {
		notesPage.verifyNotesDropDown();
	}

	@Then("^user should be able to view the Notes tab in blue color$")
	public void user_should_be_able_to_view_the_Notes_tab_in_blue_color() {
		notesPage.verifyNotesTabColor();
	}

	@And("^user select \"([^\"]*)\" menu from drop down$")
	public void user_select_menu_from_drop_down(String menu) {
		notesPage.selectMenu(menu);
	}

	@And("^user clicks on the Add button$")
	public void user_clicks_on_the_Add_button() {
		notesPage.clickAddButton();
	}

	@Then("^user should be able to view blank note with date and time stamped$")
	public void user_should_be_able_to_view_blank_note_with_date_and_time_stamped() throws IOException {
		notesPage.verifyNotesDateTime();
		notesPage.verifyBlankNote();
	}

	@And("^user enters text \"([^\"]*)\" into Note text box$")
	public void user_enters_text_into_Note_text_box(String note) throws IOException {
		notesPage.sendNoteText(note);
	}

	@Then("^user should be able to view note \"([^\"]*)\" with date and time stamped$")
	public void user_should_be_able_to_view_note_with_date_and_time_stamped(String note) throws IOException {
		notesPage.verifyNotesDateTime();
		notesPage.verifyNote(note);
	}

	@Then("^user should be able to view the pop up with labels and note \"([^\"]*)\"$")
	public void user_should_be_able_to_view_the_label(String note) throws IOException {
		notesPage.verifyPopup(note);
	}

	@And("^user clicks on the Cancel button$")
	public void user_clicks_on_the_Cancel_button() {
		notesPage.clickCancelButton();
	}

	@Then("^user should not able to view added note \"([^\"]*)\"$")
	public void user_should_not_able_to_view_added_note(String cancelNote) {
		notesPage.verifyCancelNote(cancelNote);
	}

	@Then("^user verify the database column \"([^\"]*)\" with UI$")
	public void user_verify_the_database_with_ui(String column)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		notesPage.verifyNoteDB(column);
	}

}
