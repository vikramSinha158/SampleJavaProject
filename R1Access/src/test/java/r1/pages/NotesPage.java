package r1.pages;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.databaseconnection.QueryExecutor;
import r1.commons.utilities.CommonMethods;
import r1.commons.utilities.CommonMethods.common;
import r1.serenity.steps.NotesSteps;



public class NotesPage extends BasePage {
	
	common common;
	
	@FindBy(xpath = "//span[@class='subHead']/preceding-sibling::span")
	private WebElementFacade workListTitle;

	@FindBy(xpath = "//a[@class='GBtn']")
	private List<WebElementFacade> workListRecord;
	
	@FindBy(xpath = "//a[contains(@id,'tabsTask')]")
	private List<WebElementFacade> accountDetailMenuLinks;
	
	@FindBy(xpath = "//table[@class='detailTable']//td[text()='Notes']")
	private WebElementFacade notesLabel;
	
	@FindBy(xpath = "//a[contains(@id,'btnAddNew')]")
	private WebElementFacade notesIcon;
	
	@FindBy(xpath = "//select[contains(@id,'ddlNoteType')]")
	private WebElementFacade notesDropDown;

	@FindBy(xpath = "//li[@class='TabBGC']/a[@class='TabLC'][text()='Notes']")
	private WebElementFacade notesColor;
	
	@FindBy(xpath = "//table[@class='section-title']//tr/td[1]")
	private WebElementFacade accountDetailPage;
	
	@FindBy(xpath = "//a[contains(@id,'btnAdd')][@class='StandardButton']")
	private WebElementFacade addButton;

	@FindBy(xpath = "//table[contains(@id,'dlNotes')]/tbody/tr[1]//tr[@class='PanelTitle']/td[1]")
	private WebElementFacade notesDateTime;
	
	@FindBy(xpath = "//table[contains(@id,'dlNotes')]/tbody/tr[1]//tr[@class='PanelTitle']/td[2]")
	private WebElementFacade notesUser;
	
	@FindBy(xpath = "//table[contains(@id,'dlNotes')]/tbody/tr[1]//tr[@class='PanelDetail']/td")
	private WebElementFacade noteText;
	
	@FindBy(xpath = "//textarea[contains(@name,'txtNote')]")
	private WebElementFacade noteTextBox;

	@FindBy(xpath = "//table/tbody/tr[2]")
	private WebElementFacade popUp;	
	
	@FindBy(xpath = "//span[contains(@id,'lblEncounterNum')]")
	private WebElementFacade encounterID;	
	
	@FindBy(xpath = "//span[contains(@id,'lblName')]")
	private WebElementFacade patientName;	
	
	@FindBy(xpath = "//span[contains(@id,'lblDOB')]")
	private WebElementFacade patientDob;
	
	@FindBy(xpath = "//span[contains(@id,'lblAdmitDate')]")
	private WebElementFacade patientAdmitDate;
	
	@FindBy(xpath = "//span[contains(@id,'lblEncounterNum')]")
	private WebElementFacade patientAccount;
	
	@FindBy(xpath = "//a[contains(@id,'btnCancel')][@class='StandardButton']")
	private WebElementFacade cancelButton;
	
	
	
	public List<WebElementFacade> accountDetailMenuLinks() {
		return accountDetailMenuLinks;
	}
	
	public void clickAccountDetailMenuLink(String menuName) {
		for(int i=0;i<accountDetailMenuLinks.size();i++) {
			if(accountDetailMenuLinks.get(i).getText().equals(menuName) || accountDetailMenuLinks.get(i).getText().equalsIgnoreCase(menuName)) {
				withAction().moveToElement(accountDetailMenuLinks.get(i)).click().build().perform();
				break;
			}
		}
	}
	
	public void clickRecord() {
		int random = 1+(int)(Math.random() * workListRecord.size());
		clickOn(workListRecord.get(random-1));
	}
	
	public void clickNotesIcon() {
		clickOn(notesIcon);
	}
	
	public void selectMenu(String menu) {
		selectFromDropdown(notesDropDown,menu);
	}

	public void clickAddButton() {
		clickOn(addButton);
	}
	
	public void clickCancelButton() {
		clickOn(cancelButton);
	}
	
	public void sendNoteText(String text) {
		typeInto(noteTextBox,text);
	}
	
	public void verifyPopup(String note) {
		String name = patientName.getText();
		String dob = new SimpleDateFormat("M/d/yyyy").format(new Date(patientDob.getText()));
		String admitdate = new SimpleDateFormat("M/d/yyyy").format(new Date(patientAdmitDate.getText()));
		String account = patientAccount.getText();		
		
		common.switchWindow();
		Assert.assertTrue("Pop up labels are not matching",popUp.getText().contains("Name:") &&
				popUp.getText().contains("DOB:") &&
				popUp.getText().contains("Service Date:") &&
				popUp.getText().contains("Account:") &&
				popUp.getText().contains("Note:"));
		
		Assert.assertTrue("Patient Name is not matching on pop up",popUp.getText().contains(name));
		Assert.assertTrue("Patient DOB is not matching on pop up",popUp.getText().contains(dob));
		Assert.assertTrue("Patient Service Date is not matching on pop up",popUp.getText().contains(admitdate));
		Assert.assertTrue("Patient Account is not matching on pop up",popUp.getText().contains(account));		
		Assert.assertTrue("Note Note is not matching on pop up",popUp.getText().contains(note));
		
		common.closeWindow();
		common.switchWindow();
	}
	
	public void verifyNotesDateTime() throws IOException {
		Assert.assertTrue("Note's date and time stamped is not matching",notesDateTime.getText().contains(new SimpleDateFormat("M/d/yyyy").format(new Date()).toString()));
		Assert.assertTrue("Note's user name is not verified",notesUser.getText().equalsIgnoreCase(CommonMethods.LoadProperties("username")));
	}
	
	public void verifyBlankNote() {
		Assert.assertTrue("Note is appearing with text", noteText.getText().equals("") || noteText.getText().trim().equals("Prescription :") || noteText.getText().trim().equals("Patient ID :"));
	}
	
	public void verifyNote(String text) {
		Assert.assertTrue("Note is not matching", noteText.getText().contains(text));
	}
	
	public void verifyCancelNote(String text) {
		Assert.assertFalse("Note is matching", noteText.getText().contains(text));
	}
	
	/*public void verifyNoteDB(String column) throws ClassNotFoundException, IOException, SQLException, InterruptedException {
		Assert.assertTrue("Note is not matching with database",noteText.getText().contains(NotesSteps.verifyNewCreatedScope(encounterID.getText(), column)));
	}*/
	
	public void runQuery(String queryName) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		QueryExecutor.runQueryTranParam(queryName,encounterID.getText());
	}
	
	public void verifyNoteDB(String col) throws SQLException{
		while(DatabaseConn.resultSet.next()) {
			Assert.assertTrue("Note is not matching with database",noteText.getText().contains(DatabaseConn.resultSet.getString(col)));
		}
	}
	
	public void verifyWorkListTitle(String worklist) {
		Assert.assertEquals("Worklist title is not matching", workListTitle.getText(), worklist);
	}
	
	public void verifyNotesLabel() {
		Assert.assertEquals("Notes", notesLabel.getText());
	}
	
	public void verifyNotesDropDown() {
		Assert.assertTrue("Notes drop down is not appeared", notesDropDown.isDisplayed());
	}
	
	public void verifyNotesTabColor() {
		Assert.assertTrue("Notes tab color is not matching", notesColor.isDisplayed());
	}
	
	public void verifyAccountDetailPage() {
		Assert.assertTrue("Patient Visit and Address".equals(accountDetailPage.getText().trim()));
	}
}
