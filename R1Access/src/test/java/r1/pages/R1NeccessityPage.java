package r1.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import cucumber.api.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.commons.databaseconnection.QueryExecutor;
import r1.commons.utilities.CommonMethods;



public class R1NeccessityPage extends PageObject{
	
	
	R1AccessCommonMethods r1AccessCommonMethods;
	CommonMethods commonMethods;
	String serviceCode;
	
	@FindBy(xpath = "//span[@class='subHead']/preceding-sibling::span")
	private WebElementFacade workListTitle;
	
	@FindBy(xpath = "//a[@class='StandardButton']")
	private WebElementFacade accountSearchButton;
	
	@FindBy(xpath = "//div[contains(@id,'WorklistPanel')]/div[contains(@id,'WorklistPanel')]/span[@igtxt='1']")
	private List<WebElementFacade> workListFilters;
	
	@FindBy(xpath = "//div[@class='rtbInner']/ul[@class='rtbUL']/li[@class='rtbItem rtbBtn']")
	private List<WebElementFacade> workListLabels;
	
	@FindBy(xpath = "//ul[@class='detailTabs']/li")
	private List<WebElementFacade> accountTabs;
	
	@FindBy(xpath = "//td[@class='PanelTitle']//tr//span[contains(@id,'lblSrch')]")
	private List<WebElementFacade> searchedAccountLabels;
	
	@FindBy(xpath = "//td[@class='PanelTitle']//tr//input[contains(@id,'txt')]")
	private List<WebElementFacade> searchedAccountTextBox;
	
	@FindBy(xpath = "//div[@align='left'][contains(@id,'M_dnn')]/div[2]/div[not(contains(@id,'M_dnn'))]//span[@igtxt='1']")
	private List<WebElementFacade> filtersMainMenu;
	
	@FindBy(xpath = "//table[@class='worklistTable']//tr")
	private List<WebElementFacade> necessityRequiredAccounts;
	
	@FindBy(xpath = "//span[contains(@id,'lblEncounterNum')]")
	private WebElementFacade patientVisit;
	
	@FindBy(xpath = "//table[contains(@id,'grdHCPCSearchResults')]//table//tr[last()]//td[3]")
	private List<WebElementFacade> serviceGridAmount;
	
	@FindBy(xpath = "//table[contains(@id,'grdHCPCSearchResults')]//table//tr[last()]//td[1]//a")
	private List<WebElementFacade> serviceGridCode;
	
	@FindBy(xpath = "(//a[contains(@id,'btnSelectICD')])[1]")
	private WebElementFacade diagonisCode;
	
	@FindBy(xpath = "//a[@class='StandardButton']")
	private List<WebElementFacade> accountButtons;
	
	@FindBy(xpath = "//a[contains(@id,'lnkViewMode')]")
	private List<WebElementFacade> admittingLink;
	
	@FindBy(xpath = "//input[@class='txtSearch']")
	private WebElementFacade searchTextBox;
	
	@FindBy(xpath = "//select[contains(@name,'ddlActions')]")
	private WebElementFacade activityDropDown;
	
	@FindBy(xpath = "//table[@class='PanelDetail']//tr[@class='PanelDetail']")
	private WebElementFacade followUpHistory;
	
	@FindBy(xpath = "//a[text()='Print ABN English']")
	private WebElementFacade printABNEnglish;
	
	@FindBy(xpath = "//a[text()='Print ABN Spanish']")
	private WebElementFacade printABNSpanish;
	
	@FindBy(xpath = "//table[@class='PanelDetail actionLog']//tr")
	private List<WebElementFacade> actionLog;
	
	@FindBy(xpath = "//table[@class='PanelDetail']//tr")
	private List<WebElementFacade> followupHistory;
	
	@FindBy(xpath = "//tr/td[@class='accountnumber']")
	private List<WebElementFacade> necessityAccountUI;
	
	@FindBy(xpath = "//span[contains(@id,'accTaskAction_lblStatus')]")
	private WebElementFacade necessityAccountStatus;
	
	@FindBy(xpath = "//table[contains(@class,'alert-warning')]//tr[1]/td")
	private WebElementFacade exceptionsPanel;

	@FindBy(xpath = "//a[contains(text(),'R1 Necessity')]/ancestor::li")
	private WebElementFacade r1NecessityTabColor;
	
	@FindBy(xpath = "//a[contains(text(),'Services')]/ancestor::li")
	private WebElementFacade servicesTabColor;
	
	@FindBy(xpath = "//tr[@class='colorBG']//td")
	private WebElementFacade criticalError;
	
	@FindBy(xpath = "//input[contains(@name,'txtNextFollowUpDate')]")
	private WebElementFacade followUpDate;
	
	@FindBy(xpath = "//a[contains(@id,'tabsTask')]")
	private List<WebElementFacade> accountDetailMenuLinks;
	
	@FindBy(xpath = "//tr[@class='PanelDetail']//img[@alt='Delete']")
	private List<WebElementFacade> deleteCoverage;
	
	@FindBy(xpath = "//input[contains(@id,'txtSearchPayors')]")
	private WebElementFacade searchTextPayor;
	
	@FindBy(xpath = "//a[contains(@id,'btnRunSearch')]")
	private WebElementFacade findButton;
	
	@FindBy(xpath = "//tr[@class='PanelDetail']/td/a")
	private List<WebElementFacade> planCode;
	
	@FindBy(xpath = "//a[contains(@id,'btnAddCoverage')]")
	private WebElementFacade addCoverageButton;
	
	@FindBy(xpath = "//tr[@class='PanelDetail']/td[3]")
	private WebElementFacade cob;
	
	@FindBy(xpath = "//a[contains(text(),'Coverage')]/ancestor::li")
	private WebElementFacade coverageTabColor;
	
	@FindBy(xpath = "//a[contains(text(),'Patient')]/ancestor::li")
	private WebElementFacade patientTabColor;
	
	@FindBy(xpath = "//span[contains(@id,'lblPatientType')]")
	private WebElementFacade patientTypeDemographic;
	
	String dispositionDropDown = "//span[contains(@id,'lblDisposition')][text()='Disposition:'][contains(@style,'display')]";
	
	public void verifyWorkListTitle(String worklist) {
		Assert.assertEquals("Worklist title is not matching",worklist,workListTitle.getText());
	}
	
	
	public void verifyWorkListFilter() {
		Assert.assertTrue("WorkList Filter is not appearing",workListFilters.size()>0);
	}
	
	public void verifyLabels() {
			Assert.assertEquals("NEW label is not matching","NEW",workListLabels.get(0).getText());
			Assert.assertEquals("TASK label is not matching","TASK",workListLabels.get(1).getText());
			Assert.assertEquals("COLUMNS label is not matching","COLUMNS",workListLabels.get(2).getText());
			Assert.assertEquals("SEARCH label is not matching", "SEARCH",workListLabels.get(3).getText());
			Assert.assertEquals("EXPORT label is not matching","EXPORT",workListLabels.get(4).getText());
			Assert.assertEquals("SAVE LIST label is not matching","SAVE LIST",workListLabels.get(5).getText());
			Assert.assertEquals("CONFIG label is not matching","CONFIG",workListLabels.get(6).getText());
	}
	
	public void verifyTabsColor() {
		for(int i=0;i<accountTabs.size();i++) {
			Assert.assertTrue("Tab color is not matching",accountTabs.get(i).getAttribute("class").contains("C") || accountTabs.get(i).getAttribute("class").contains("I") || accountTabs.get(i).getAttribute("class").contains("U"));
		}
	}
	
	public void clickAccountButtonOnRibbon(String label) {
		r1AccessCommonMethods.clickUpperHeaderLink(label);
	}
	
	public void verifySearchedAccountLabels() {
		Assert.assertTrue("SSN: is not matching",searchedAccountLabels.get(0).getText().equals("SSN:"));
		Assert.assertTrue("L/F Name: is not matching",searchedAccountLabels.get(1).getText().equals("L/F Name:"));
		Assert.assertTrue("Med Rec#: is not matching",searchedAccountLabels.get(2).getText().equals("Med Rec#:"));
		Assert.assertTrue("Visit#: is not matching",searchedAccountLabels.get(3).getText().equals("Visit#:"));
	}
	
	public void enterEncounterID(String id) {
		typeInto(searchedAccountTextBox.get(4),id);
	}
	
	public void clickSearchButton() {
		clickOn(accountSearchButton);
	}
	
	public void verifyR1NecessityTab() {
		List<String> listAccount = new ArrayList<String>();
		for(int i=0;i<accountTabs.size();i++) {
			listAccount.add(accountTabs.get(i).getText());
		}
		Assert.assertTrue("R1 Necessity™ is not matching",listAccount.contains("R1 Necessity™"));
		
		for(int i=0;i<accountTabs.size();i++) {
			if(accountTabs.get(i).getText().contains("R1 Necessity™")) {
				Assert.assertTrue("R1 Necessity tab's color is not matching",accountTabs.get(i).getAttribute("class").contains("C") || accountTabs.get(i).getAttribute("class").contains("I"));
			}
		}
	}
	
	public void clickFilterMainMenu(String menuName) {
		for(int i=0;i<filtersMainMenu.size();i++) {
			if(filtersMainMenu.get(i).getText().trim().equals(menuName)) {
				withAction().moveToElement(filtersMainMenu.get(i)).click().build().perform();
				break;
			}
		}
	}
	
	public void clickAccountButton(String menuName) {
		for(int i=0;i<accountButtons.size();i++) {
			if(accountButtons.get(i).getText().equalsIgnoreCase(menuName)) {
				withAction().moveToElement(accountButtons.get(i)).click().build().perform();
				break;
			}
		}
	}
	
	public void verifyRedoButton() {
		for(int i=0;i<accountButtons.size();i++) {
			if(accountButtons.get(i).getText().equalsIgnoreCase("Redo")) {
				withAction().moveToElement(accountButtons.get(i)).click().build().perform();
			}
		
		}
	}
	
	public void verifyReleaseButton() {
		for(int i=0;i<accountButtons.size();i++) {
			if(accountButtons.get(i).getText().equalsIgnoreCase("Release")) {
				withAction().moveToElement(accountButtons.get(i)).click().build().perform();
			}
		
		}
	}
	
	public void verifyAdmittingLink() {
		if(admittingLink.size()>0) {
			clickOn(admittingLink.get(0));
		}
	}
	
	public void verifyAccountsDisplayed() {
		Assert.assertTrue("There is no accounts in the worklist",necessityRequiredAccounts.size()>1);
	}
	
	public void searchService(String serviceText) {
		typeInto(searchTextBox,serviceText);
		clickAccountButton("Search");
	}
	
	public void clickServiceLink() {
		for(int i=0;i<serviceGridAmount.size();i++) {
			if(Double.parseDouble(serviceGridAmount.get(i).getText().replaceAll("[$ ,]", ""))>0) {
				serviceCode = serviceGridCode.get(i).getText();
				clickOn(serviceGridCode.get(i));
				break;
			}
		}
	}
	
	public void runQueryTranServer(String queryName)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		QueryExecutor.runQueryTran(this.getClass().getSimpleName().replace("Page", ""),queryName);
	}
	
	public void runQueryTranServerParam(String queryName, String registrationID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		QueryExecutor.runQueryTranParam(this.getClass().getSimpleName().replace("Page", ""),queryName,registrationID);
	}
	
	public void clickDiagnosisLink() {
		clickOn(diagonisCode);
	}
	
	public void selectActivity(String menu) {
		selectFromDropdown(activityDropDown,menu);
	}
	
	public void verifyFollowUpHistory(String note) {
		Assert.assertTrue("Followup History is not matching",followUpHistory.getText().trim().contains(note));
	}

	public void verifyDispositionHide() throws InterruptedException {
		Assert.assertTrue("Disposition is not getting hide",commonMethods.getElementsSize(dispositionDropDown)>0);
	}
	
	public void clickABNEnglish() {
		clickOn(printABNEnglish);
	}
	
	public void clickABNSpanish() {
		clickOn(printABNSpanish);
	}
	
	public void verifyABNEnglishPdf() {
		commonMethods.switchWindow();
		Assert.assertTrue(commonMethods.getWindowTitle().contains("Advance Beneficiary"));
		commonMethods.closeWindow();
		commonMethods.switchWindow();
	}
	
	public void verifyABNSpanishPdf() {
		commonMethods.switchWindow();
		Assert.assertTrue(commonMethods.getWindowTitle().contains("Notificación previa"));
		commonMethods.closeWindow();
		commonMethods.switchWindow();
	}
	
	public void verifyActivityLog() throws IOException {
		Assert.assertTrue("Activity Log header is not matching", actionLog.get(0).getText().contains("Type/Disposition") &&
																 actionLog.get(0).getText().contains("Task") &&
																 actionLog.get(0).getText().contains("Updated By") &&
																 actionLog.get(0).getText().contains("Status") &&
																 actionLog.get(0).getText().contains("Note") &&
																 actionLog.get(0).getText().contains("Date/Time"));
		Assert.assertTrue("Type/Disposition is not matching", actionLog.get(1).getText().contains("Task"));
		Assert.assertTrue("Task is not matching", actionLog.get(1).getText().contains("R1 Necessity™"));
		Assert.assertTrue("Updated By is not matching", actionLog.get(1).getText().toLowerCase().contains(CommonMethods.loadProperties("username").toLowerCase()));
		Assert.assertTrue("Type/Disposition is not matching", actionLog.get(1).getText().contains("Completed") || actionLog.get(1).getText().contains("Incomplete") || actionLog.get(1).getText().contains("Assigned") || actionLog.get(1).getText().contains("Redo") || actionLog.get(1).getText().contains("Unassigned"));
		Assert.assertTrue("Type/Disposition is not matching", actionLog.get(1).getText().contains(new SimpleDateFormat("M/d/yyyy").format(new Date())));
	}
	
	public void verifyFollowUp() throws ClassNotFoundException, IOException, SQLException {
		Assert.assertTrue("Followup History labels are not matching",followupHistory.get(0).getText().contains("Updated By") &&
						  followupHistory.get(0).getText().contains("Type") &&
						  followupHistory.get(0).getText().contains("Action") &&
						  followupHistory.get(0).getText().contains("Disposition") &&
						  followupHistory.get(0).getText().contains("Note") &&
						  followupHistory.get(0).getText().contains("Event Date") &&
						  followupHistory.get(0).getText().contains("Next Action Date") &&
						  followupHistory.get(0).getText().contains("Updated Date"));
		
		
	}


	
	public void clickNecessityRequiredDrillDown() throws InterruptedException {
		r1AccessCommonMethods.subFolderClick("Necessity Required", "Necessity Incomplete");
	}
	
	public void clickNecessityAccount() {
		clickOn(necessityAccountUI.get(0));
	}
	
	public void verifyNecessityAccountStatus() {
		Assert.assertTrue(necessityAccountStatus.getText().contains("Incomplete") || necessityAccountStatus.getText().contains("Redo") || necessityAccountStatus.getText().contains("Assigned"));
	}
	
	public void verifyExceptions(DataTable exceptions) {
	List<List<String>> exceptionList = exceptions.raw();
	for(int i=0;i<2;i++) {
		 if(exceptionsPanel.getText().contains(exceptionList.get(i).get(0)) && exceptionsPanel.getText().contains(exceptionList.get(i).get(1))) {
		}
		 else {
			Assert.assertTrue("Exception-"+exceptionList.get(i).get(0)+"-is not matching", false);
		 }
		 
	 }
	}
	
	public void verifyNecessityColor() {
		Assert.assertEquals("Necessity Tab color is not appearing in RED color","TabBGSelI",r1NecessityTabColor.getAttribute("class"));
	}
	
	public void verifyServiceColor() {
		Assert.assertEquals("Service Tab color is not appearing in BLUE color","TabBGC",servicesTabColor.getAttribute("class"));
	}
	
	public void verifyNecessityColorBlue() {
		Assert.assertEquals("Necessity Tab color is not appearing in BLUE color","TabBGC",r1NecessityTabColor.getAttribute("class"));
	}
	
	public void verifyCriticalException(String exception) {
		Assert.assertEquals("Critical Exception is not matching for R1Necessity Complete action", exception, criticalError.getText().trim());
	}
	
	public void verifyExceptionsNecessityService(String exception) {
		Assert.assertFalse(exception+"-is visible in the exception panel for R1Necessity",exceptionsPanel.getText().contains(exception));
	}
	
	public void verifyExceptionsEnabled(String exception) {
		Assert.assertTrue(exception+"-is visible in the exception panel for R1Necessity",exceptionsPanel.getText().contains(exception));
	}
	
	public void necissityTabDisable() {
		for(int i=0;i<accountDetailMenuLinks.size();i++) {
			Assert.assertFalse("Necessity Tab is appearing",accountDetailMenuLinks.get(i).getText().contains("R1 Necessity"));
		}
	}
	
	
	
	
	
	public void addMedicalCoverage(String coverage) {
		for(int i=0;i<deleteCoverage.size();i++) {
		clickOn(deleteCoverage.get(0));
		}
		searchTextPayor.sendKeys(coverage);
		clickOn(findButton);
		int random = 1+(int)(Math.random() * planCode.size());
		clickOn(planCode.get(random-1));
		clickOn(addCoverageButton);
	}
	
	public void verifyCOB() {
		Assert.assertEquals("COB is not matching as 1","1",cob.getText());
	}
	
	public void verifyCoverageColor() {
		Assert.assertEquals("Coverage Tab color is not appearing in Blue color","TabBGSelC",coverageTabColor.getAttribute("class"));
	}
	
	
	public void verifyPatientColor() {
		Assert.assertEquals("Patient Tab color is not appearing in Blue color",patientTabColor.getAttribute("class"),"TabBGC");
	}
	
	public void necissityTabEnabled() {
		for(int i=0;i<accountDetailMenuLinks.size();i++) {
			Assert.assertTrue("Necessity Tab is not appearing",accountDetailMenuLinks.get(i).getText().contains("R1 Necessity"));
		}
	}
	
	public void patientTypeDemographic() {
		Assert.assertEquals("Patient Type is not matching", "O", patientTypeDemographic.getText());
	}
	
	public void verifySearchedVisitNumber(String visit) {
		Assert.assertEquals("Searched visit number is not matching", visit,patientVisit.getText());
	}
	
	
	
	
}
