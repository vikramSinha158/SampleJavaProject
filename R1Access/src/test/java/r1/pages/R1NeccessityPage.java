package r1.pages;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;

import cucumber.api.DataTable;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.commons.utilities.CommonMethods;
import r1.commons.utilities.CommonMethods.common;
import r1.serenity.steps.R1NeccessitySteps;

public class R1NeccessityPage extends BasePage{
	
	R1NeccessitySteps neccessitySteps;
	R1AccessCommonMethods r1AccessCommonMethods;
	common common;
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
	
	@FindBy(xpath = "//div[@align='left'][contains(@id,'M_dnn')]/div[2]/div[not(contains(@id,'M_dnn'))]")
	private List<WebElementFacade> filtersMainMenu;
	
	@FindBy(xpath = "//table[@class='worklistTable']//tr")
	private List<WebElementFacade> necessityRequiredAccounts;
	
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
	
	String dispositionDropDown = "//span[contains(@id,'lblDisposition')][text()='Disposition:'][contains(@style,'display')]";
	
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
	
	
	
	
	public void verifyWorkListTitle(String worklist) {
		Assert.assertEquals("Worklist title is not matching", workListTitle.getText(), worklist);
	}
	
	
	public void verifyWorkListFilter() {
		Assert.assertTrue("WorkList Filter is not appearing",workListFilters.size()>0);
	}
	
	public void verifyLabels() {
			Assert.assertEquals("NEW label is not matching",workListLabels.get(0).getText(), "NEW");
			Assert.assertEquals("TASK label is not matching",workListLabels.get(1).getText(), "TASK");
			Assert.assertEquals("COLUMNS label is not matching",workListLabels.get(2).getText(), "COLUMNS");
			Assert.assertEquals("SEARCH label is not matching",workListLabels.get(3).getText(), "SEARCH");
			Assert.assertEquals("EXPORT label is not matching",workListLabels.get(4).getText(), "EXPORT");
			Assert.assertEquals("SAVE LIST label is not matching",workListLabels.get(5).getText(), "SAVE LIST");
			Assert.assertEquals("CONFIG label is not matching",workListLabels.get(6).getText(), "CONFIG");
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
		Assert.assertTrue("There is no accounts for Necessity Required",necessityRequiredAccounts.size()>1);
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
		Assert.assertTrue("Disposition is not getting hide",common.getElementsSize(dispositionDropDown)>0);
	}
	
	public void clickABNEnglish() {
		clickOn(printABNEnglish);
	}
	
	public void clickABNSpanish() {
		clickOn(printABNSpanish);
	}
	
	public void verifyABNEnglishPdf() {
		common.switchWindow();
		Assert.assertTrue(common.getWindowTitle().contains("Advance Beneficiary"));
		common.closeWindow();
		common.switchWindow();
	}
	
	public void verifyABNSpanishPdf() {
		common.switchWindow();
		Assert.assertTrue(common.getWindowTitle().contains("Notificación previa"));
		common.closeWindow();
		common.switchWindow();
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
		Assert.assertTrue("Updated By is not matching", actionLog.get(1).getText().toLowerCase().contains(CommonMethods.LoadProperties("username").toLowerCase()));
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
		
		Assert.assertTrue(followupHistory.get(1).getText().contains(neccessitySteps.getUserDisplayName()) &&
				followupHistory.get(1).getText().contains("Medical Necessity") &&
				followupHistory.get(1).getText().contains("ABN Printed") &&
				followupHistory.get(1).getText().contains("N/A") &&
				followupHistory.get(1).getText().contains("Medical Necessity") &&
				followupHistory.get(1).getText().contains(serviceCode) &&
				followupHistory.get(1).getText().contains(new SimpleDateFormat("MM/d/yyyy").format(new Date())));
	}

	public void verifyNecessityIncompleteAccounts(String column) throws ClassNotFoundException, IOException, SQLException {
		for(int i=0;i<necessityAccountUI.size();i++) {
			Assert.assertTrue("Account--"+necessityAccountUI.get(i).getText()+"--is not matching.",neccessitySteps.getNecessityEncounterID(column).contains(necessityAccountUI.get(i).getText()));
		}
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
	@SuppressWarnings("unused")
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
		Assert.assertEquals("Necessity Tab color is not appearing in RED color",r1NecessityTabColor.getAttribute("class"), "TabBGSelI");
	}
	
	public void verifyServiceColor() {
		Assert.assertEquals("Service Tab color is not appearing in BLUE color",servicesTabColor.getAttribute("class"), "TabBGC");
	}
	
	public void verifyNecessityColorBlue() {
		Assert.assertEquals("Necessity Tab color is not appearing in BLUE color",r1NecessityTabColor.getAttribute("class"), "TabBGC");
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
	
	
}
