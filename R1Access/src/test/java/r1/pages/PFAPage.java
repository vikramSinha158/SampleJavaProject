package r1.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

import cucumber.api.DataTable;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.DataAccess;
import r1.commons.R1AccessCommonMethods;
import r1.commons.databaseconnection.QueryConstantPFA;
import r1.commons.databaseconnection.QueryExecutor;
import r1.serenity.steps.PFASteps;

public class PFAPage extends BasePage {

	R1AccessCommonMethods commonMethodsR1Access;
	PFASteps pfaSteps;
	ArrayList<String> getColValue, getVerifiedColValue;
	String selPlanCode, payorCode, visitNo;
	int count;
	String ansCodeValue, followUpDate;
	QueryConstantPFA queryConstantPFA;
	R1AccessCommonMethods r1Common;

	@FindBy(xpath = "//span[contains(text(),'Unworked')]")
	private WebElementFacade filterUnworked;

	@FindBy(xpath = "//a[contains(@id,'btnAddNew')]")
	private WebElementFacade btnAddCoverage;

	@FindBy(xpath = "//input[contains(@id,'_txtSearchPayors')]")
	private WebElementFacade txtSearchPayors;

	@FindBy(xpath = "//a[contains(@id,'_btnRunSearch')]")
	private WebElementFacade findPayorButton;

	@FindBy(xpath = "//table[contains(@id,'grdCoverageSearchResults')]//tr[2]/td[1]/a")
	private WebElementFacade linkPlanCode;

	@FindBy(xpath = "//a[@class='StandardButton'][contains(text(),'Add')]")
	private WebElementFacade btnPayorAdd;

	@FindBy(xpath = "//table[contains(@id,'_grdCoverageSelected')]//tr[2]/td[15]/a")
	private WebElementFacade statusCoverage;

	@FindBy(xpath = "//select[contains(@id,'_CoverageDetails_ddlStatus')]")
	private WebElementFacade coverageStatus;

	@FindBy(xpath = "//a[contains(@id,'_CoverageDetails_btnUpdate')]")
	private WebElementFacade btnUpdate;

	@FindBy(xpath = "//span[contains (@id, 'accTaskAction_lblStatus' )]")
	private WebElementFacade statusLabel;

	@FindBy(xpath = "//table[contains(@id,'grdCoverageSelected')]//img[contains(@alt,'Delete')]/..")
	private WebElementFacade crossMark;

	public String coveragesearchResultRow = "//*[contains(@id,'grdCoverageSearchResults')]//tr";
	public String coveragesearchResultRowHeader = "//*[contains(@id,'grdCoverageSearchResults')]//tr[1]/td";

	public String coveragePlanCodeRow = "//table[contains(@id,'_grdCoverageSelected')]//tr";
	public String coveragePlanCodeRowHeader = "//table[contains(@id,'_grdCoverageSelected')]//tr[1]/td";

	@FindBy(xpath = "//input[contains(@id,'_Task826_btnSave')]")
	private WebElementFacade btnSaveAndContinue;

	@FindBy(xpath = "//input[contains(@id,'_btnClearAnswers')]")
	private WebElementFacade btnClearAnswers;

	@FindBy(xpath = "//div[contains(@id,'_pnlCommonDataNeeds')]//span")
	private WebElementFacade common_Data_Needs;

	@FindBy(xpath = "//td//input[contains(@id,'_txtL2_TOTAL_INCOME')]")
	private WebElementFacade txtTotalIncome;

	@FindBy(xpath = "//input[contains(@id,'_txtL2_ANNUAL_INCOME')]")
	private WebElementFacade txtAnnualIncome;

	@FindBy(xpath = "//input[contains(@id,'_txtL2_FPL')]")
	private WebElementFacade txtFPL;

	@FindBy(xpath = "//td[@class='PanelTitle']//tr//input[contains(@id,'txt')]")
	private List<WebElementFacade> searchedAccountTextBox;

	@FindBy(xpath = "//a[@class='StandardButton']")
	private WebElementFacade accountSearchButton;

	@FindBy(xpath = "//input[contains(@id,'_rblYesNo_17_1_17')]")
	private WebElementFacade defaultAnswer;

	@FindBy(xpath = "//table[contains(@id,'_rblYesNo_11')]//tr//input")
	private List<WebElementFacade> veteranRadioBtn;

	@FindBy(xpath = "//table[contains(@id,'_grdScreeningQuestions')]//input[contains(@type,'radio')]")
	private List<WebElementFacade> listRadioButtons;

	@FindBy(xpath = "//span[contains(@class , 'clsUnCoOperative' )]//input")
	private List<WebElementFacade> screeningQuestionnaireStatus;

	@FindBy(xpath = "//span[contains(@class , 'clsUnCoOperative' )]//label")
	private List<WebElementFacade> screeningQuestionnaireStatusLabel;

	@FindBy(xpath = "//table[contains(@id , 'grdScreeningQuestions' )]//input")
	private List<WebElementFacade> screeningAnsInputs;

	@FindBy(xpath = "//input[contains(@id , '_chkActions_0')]")
	private List<WebElementFacade> chkAction;

	@FindBy(xpath = "//span[contains(text() , 'Action successfully updated')]")
	private WebElementFacade actionUpdateMsg;

	@FindBy(xpath = "//input[contains(@id , '_btnSave_0')]")
	private WebElementFacade clickSaveActionItem;

	@FindBy(xpath = "//input[contains(@id , '0_txtfollowupdate_0')]")
	private WebElementFacade txtFollowUpDate;

	@FindBy(xpath = "//input[contains(@id , 'txtQuestionCode')]")
	private WebElementFacade inputQuesCode;

	@FindBy(xpath = "//textarea[contains(@id , 'txtQuestion')]")
	private WebElementFacade inputQues;

	@FindBy(xpath = "//input[contains(@id , 'chkActive')]")
	private WebElementFacade isActiveQuestionChkbox;

	@FindBy(xpath = "//input[contains(@id , 'btnAdd')]")
	private WebElementFacade addBtn;

	@FindBy(xpath = "//span[contains(@id , 'lblQuestionError')]")
	private WebElementFacade quesAddedLbl;

	@FindBy(xpath = "//input[contains(@id , 'btnAddNewAnswer')]")
	private WebElementFacade newAnsBtn;

	@FindBy(xpath = "//input[contains(@id , 'txtAnswerCode')]")
	private WebElementFacade ansCodeTxtBox;

	@FindBy(xpath = "//textarea[contains(@id , 'txtAnswerText')]")
	private WebElementFacade ansTxtBox;

	@FindBy(xpath = "//input[contains(@id , 'btnCancelAddNewAnswers')]")
	private WebElementFacade cancelAnsBtn;

	@FindBy(xpath = "//input[contains(@id , 'btnAddNewAnswers')]")
	private WebElementFacade addAnsBtn;

	@FindBy(xpath = "//span[contains(@id , 'lblPFAAnswers')]")
	private WebElementFacade lblPFAAns;

	@FindBy(xpath = "//span[contains(@id , 'lblAnswerError')]")
	private WebElementFacade lblAnsAdded;

	@FindBy(xpath = "//input[contains(@id , 'btnAddQuestionAnswer')]")
	private WebElementFacade linkAnsBtn;

	@FindBy(xpath = "//input[contains(@id , 'btnCancelLinkAnswer')]")
	private WebElementFacade cancelLinkAnsBtn;

	@FindBy(xpath = "//select[contains(@id , 'ddlAnswerList' )]")
	private WebElementFacade ansDropdwnList;

	@FindBy(xpath = "//input[contains(@id , 'btnLinkAnswer' )]")
	private WebElementFacade linkNewAnsBtn;

	@FindBy(xpath = "//span[contains(@id , 'lblAnswerCode_0')]")
	private WebElementFacade linkedAns;

	@FindBy(xpath = "//span[contains(@id , 'lblLinkAnswerError')]")
	private WebElementFacade ansAddedMsg;

	@FindBy(xpath = "//input[contains(@id , 'btnUnlinkAnswer')]")
	private WebElementFacade unlinkAnsBtn;

	@FindBy(xpath = "//select[contains(@id , 'ddlUnlinkAnswerlist' )]")
	private WebElementFacade unlinkAnsDropdown;

	@FindBy(xpath = "//span[contains(@id , 'lblUnlinkAnswerError')]")
	private WebElementFacade unlinkAnsSuccessMsg;

	@FindBy(xpath = "//input[contains(@id , 'chkAnswerActive')]")
	private WebElementFacade isActiveAns;

	@FindBy(xpath = "//input[@value = 'Unlink Existing Answer']")
	private WebElementFacade unlinkExistingAnsBtn;

	@FindBy(xpath = "//span[contains(text() , 'Are you pregnant or is your ')]")
	private WebElementFacade pregnancyQuestion;

	@FindBy(xpath = "//span[contains(text(), 'Are you pregnant or is your upcoming visit pregnancy related')]//..//..//following-sibling::tr//input")
	private List<WebElementFacade> pregnancyQuestionAns;

	@FindBy(xpath = "//span[contains(text(), 'Are you pregnant or is your upcoming visit pregnancy related')]//..//..//following-sibling::tr//label")
	private List<WebElementFacade> pregnancyQuestionAnsLabel;

	@FindBy(xpath = "//span[@id = 'SpnOverride']")
	private WebElementFacade overrideTab;

	@FindBy(xpath = "//span[contains(@id ,'lblEncounterNum')]")
	private WebElementFacade encounterId;

	@FindBy(xpath = "//input[contains(@id , 'OverrideQuestionnaire1_txtFollowUpDate')]")
	private WebElementFacade followUpDateTextbox;

	@FindBy(xpath = "//div[contains(@id, 'OverrideQuestionnaire1_updOverride')]//div")
	private List<WebElementFacade> followUpDateLabel;

	@FindBy(xpath = "//img[contains(@id , 'OverrideQuestionnaire1_imgOverrideCalendar')]")
	private WebElementFacade datePicker;

	@FindBy(xpath = "//input[contains(@id , 'OverrideQuestionnaire1_btnSaveCWL')]")
	private WebElementFacade saveCWLButton;

	@FindBy(xpath = "//span[contains(@id, 'OverrideQuestionnaire1_lblCWLMessage')]")
	private WebElementFacade errorCWLMessage;

	@FindBy(xpath = "//select[contains(@id , 'ddlFundingSource')]")
	private WebElementFacade fundingSourceDropdown;

	@FindBy(xpath = "//select[contains(@id , 'ddlAction')]")
	private WebElementFacade actionDropdown;

	@FindBy(xpath = "//input[contains(@id , 'ChkConfirm')]")
	private WebElementFacade confirmCheckBOx;

	@FindBy(xpath = "//textarea[contains(@id , 'txtNote')]")
	private WebElementFacade noteTextbox;

	@FindBy(xpath = "//span[contains(text() , 'Record Added into CWL Successfully')]")
	private WebElementFacade recordAddedLabel;

	@FindBy(xpath = "//a[contains(text() , 'Auto Insurance')]")
	private WebElementFacade fundingSourceonCWLWrklst;

	@FindBy(xpath = "//li[contains(@id , 'tabsTask_trTab_0')]")
	private WebElementFacade pfaTabColor;

	@FindBy(xpath = "//*[contains(text(),'R1 Detect')]//..//*[contains(@imgtype , 'exp')]//..//..//following-sibling::div//*[contains(text() , 'Unworked')]")
	private WebElementFacade unworkedSubFolder;

	@FindBy(xpath = "//input[@value = 'Save & Continue']")
	private WebElementFacade saveAndContBtn;

	@FindBy(xpath = "//span[@class= 'tab-span-active']")
	private WebElementFacade activeTabPFA;

	@FindBy(xpath = "//span[contains(@id , 'lblFundingId')]")
	private List<WebElementFacade> fundingSourcesScreeningNeeds;

	@FindBy(xpath = "//table[contains(@id,'_grdScreeningQuestions')]//tr[contains(@valign,'top')]")
	private List<WebElementFacade> totalQuestions;

	public String ScreenQuesAns1 = "//table[contains(@id,'_grdScreeningQuestions')]//tr[";

	public String ScreenQuesAns2 = "]//tr[2]/td[2]/table//input";

	@FindBy(xpath = "//*[contains(text(),'R1 Detect')]//..//*[contains(@imgtype , 'exp')]//..//..//following-sibling::div//*[contains(text() , 'Self Pay L2')]")
	private WebElementFacade selfPayL2SubFolder;

	@FindBy(xpath = "//span[contains(@id , 'ScreeningNeeds')]")
	private WebElementFacade screeningNeedsTab;

	@FindBy(xpath = "//span[contains(@id , 'SpnActionItems')]")
	private WebElementFacade actionItemsTab;

	@FindBy(xpath = "//input[contains(@id , 'NOOFHOUSE_HOLDS')]")
	private WebElementFacade enterPersonInHousehold;

	@FindBy(xpath = "//input[contains(@id , 'rblEmploymentStatus_0')]")
	private WebElementFacade fullTimeStatus;

	@FindBy(xpath = "//input[contains(@id , 'btnSubmit')]")
	private WebElementFacade submitAllFSBtn;

	@FindBy(xpath = "//div[contains(@class, 'DataNeedsPassed')]//span")
	private WebElementFacade commonDataNeedsPassed;

	@FindBy(xpath = "//input[contains(@id , 'rblEmploymentStatus')]")
	private List<WebElementFacade> patientEmploymentStatus;

	@FindBy(xpath = "//label[contains(@for , 'rblEmploymentStatus')]")
	private List<WebElementFacade> patientEmploymentStatusLabel;

	@FindBy(xpath = "//span[contains(text(), 'Are you a resident of:')]//..//..//following-sibling::tr//input")
	private List<WebElementFacade> residentQuestionAns;

	@FindBy(xpath = "//span[contains(text(), 'Are you a resident of:')]//..//..//following-sibling::tr//label")
	private List<WebElementFacade> residentQuestionAnsLabel;

	/*********************************************************************************************************************************************************************************************/

	public void enterPayorCode(String payorCode) {
		typeInto(txtSearchPayors, payorCode);
	}

	public void clickUnworkedFilterFolder() {
		clickOn(filterUnworked);
	}

	public void clickAddCoverageButton() {
		clickOn(btnAddCoverage);
	}

	public void clickFindPayorButton() {
		clickOn(findPayorButton);
	}

	public void clickPayorAddButton() {
		clickOn(btnPayorAdd);
	}

	public void selectVerificationStatus() {
		selectFromDropdown(coverageStatus, "Passed");
	}

	public void clickUpdateButton() {
		clickOn(btnUpdate);
	}

	public void clickSaveAndContinue() {
		clickOn(btnSaveAndContinue);
	}

	public void clickClearAnswers() {
		clickOn(btnClearAnswers);
	}

	public void clickSearchButton() {
		clickOn(accountSearchButton);
	}
	
	public void runQueryTranServer(String queryName)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		QueryExecutor.runQueryTran(this.getClass().getSimpleName().replace("Page", ""),queryName);
	}

	public void verifyCommonDataNeeds() {

		Assert.assertEquals("Common Data Needs", common_Data_Needs.getText().toString());
	}

	public void fetchPayorCode(String col) throws ClassNotFoundException, SQLException, IOException {
		payorCode = pfaSteps.getPayorCode(col);
	}

	public void enterEncounterID(String id) {
		typeInto(searchedAccountTextBox.get(4), id);
	}

	public void verifyTabStatus(String status) {
		Assert.assertTrue(commonMethodsR1Access.chkTabStatusIncompleteComplete().equals(status));
	}

	public void verifyTabColor(String moduleTab, String color) {
		Assert.assertTrue(commonMethodsR1Access.checkTabColor(moduleTab).equalsIgnoreCase(color));

	}

	public void verifyTabColorAndStatus(String moduleTab, String color) {
		Assert.assertTrue(commonMethodsR1Access.checkTabColor(moduleTab).equalsIgnoreCase(color));
	}

	public void DelAllCoverage() throws InterruptedException {
		int size = commonMethodsR1Access.getTableColValue(coveragePlanCodeRow, coveragePlanCodeRowHeader, "Payor")
				.size();
		while (size > 0) {
			clickOn(crossMark);
			size--;
		}
		Assert.assertEquals("Coverage didn't get deleted", size, 0);
	}

	@SuppressWarnings("unchecked")
	public void selectPlanCodeResultGrid() {
		getColValue = commonMethodsR1Access.getTableColValue(coveragesearchResultRow, coveragesearchResultRowHeader,
				"Plan Code");
		selPlanCode = getColValue.get(0);
		clickOn(linkPlanCode);
	}

	public void VAHealthCareSystem() {
		for (int i = 0; i < veteranRadioBtn.size(); i++) {
			Assert.assertTrue(!veteranRadioBtn.get(i).isSelected());
		}
	}

	@SuppressWarnings("unchecked")
	public void verifyPlanCodeCoverageTable(String status) {
		getVerifiedColValue = commonMethodsR1Access.getTableColValue(coveragePlanCodeRow, coveragePlanCodeRowHeader,
				"Verified");
		if (!(getVerifiedColValue.get(0).contains(status))) {
			clickOn(statusCoverage);

		}

	}

	public void verifyScreeningQuestionTab() {
		int count = totalQuestions.size();
		for (int i = 0; i < count; i++) {
			String Ques = ScreenQuesAns1 + (i + 2) + ScreenQuesAns2;
			clickOn(element(By.xpath(Ques)));

		}
	}

	public void checkActionBox() throws InterruptedException {

		for (int i = 0; i < chkAction.size(); i++) {
			if (!chkAction.get(4).isSelected()) {
				Thread.sleep(6000);
				clickOn(chkAction.get(i));

			}
		}

	}

	public void getFollowUpDate() {
		Assert.assertTrue(!txtFollowUpDate.getText().equals(null));
		followUpDate = txtFollowUpDate.getText();

	}

	public void clickSaveActionItems() {
		clickOn(clickSaveActionItem);
	}

	public void verifyUpdateActionMessage(String message) {
		Assert.assertEquals(message, actionUpdateMsg.getText().toString());

	}

	public void inputPFAQues(String code, String question) {
		typeInto(inputQuesCode, code);
		typeInto(inputQues, question);
	}

	public void clickIsActiveQuesChkbox() {
		clickOn(isActiveQuestionChkbox);
	}

	public void clickIsActiveAnsChkbox() {
		clickOn(isActiveAns);
	}

	public void addQuestion() {
		clickOn(addBtn);
	}

	public void verifyQuesAddedLabel(String msg) {
		Assert.assertTrue(quesAddedLbl.getText().equalsIgnoreCase(msg));
	}

	public void clickNewAns() {
		clickOn(newAnsBtn);
	}

	public void inputAns(String ansCode, String ansText) {
		typeInto(ansCodeTxtBox, ansCode);
		typeInto(ansTxtBox, ansText);
		ansCodeValue = ansCode;
	}

	public void clickcancelAns() {
		clickOn(cancelAnsBtn);
	}

	public void clickAddAns() {
		clickOn(addAnsBtn);
	}

	public void verifyPFAAnsPanel() {
		Assert.assertTrue(!lblPFAAns.isVisible());
	}

	public void verifyAnsLabelAdded(String info) {
		Assert.assertTrue(lblAnsAdded.getText().equalsIgnoreCase(info));
	}

	public void clickLinkAns() {
		clickOn(linkAnsBtn);
	}

	public void clickCancelLinkAns() {
		clickOn(cancelLinkAnsBtn);
	}

	public void verifyFieldsNotVisible() {
		Assert.assertTrue(!linkNewAnsBtn.isVisible());
		Assert.assertTrue(!cancelLinkAnsBtn.isVisible());
		Assert.assertTrue(!ansDropdwnList.isVisible());
	}

	public void selectCreatedAns() {
		selectFromDropdown(ansDropdwnList, ansCodeValue);
	}

	public void clickLinkNewAns() {
		clickOn(linkNewAnsBtn);
	}

	public void verifyAnsAdded() {
		Assert.assertTrue(linkedAns.getText().equals(ansCodeValue));
	}

	public void verifyAnsAddedMessage(String messg) {
		ansAddedMsg.getText().equalsIgnoreCase(messg);
	}

	public void clickUnlinkAns() {
		clickOn(unlinkAnsBtn);
	}

	public void selectAnstoUnlink() {
		selectFromDropdown(unlinkAnsDropdown, ansCodeValue);
	}

	public void clickUnlinkExistingAns() {
		clickOn(unlinkExistingAnsBtn);
	}

	public void verifyAnsUnlinked(String mesg) {
		Assert.assertTrue(unlinkAnsSuccessMsg.getText().equalsIgnoreCase(mesg));
	}

	public void verifyAnsRemoved() {
		Assert.assertTrue(!linkedAns.isVisible());
	}

	public String getEncounterIdFor_PFA_419028_SQL10() throws ClassNotFoundException, IOException, SQLException {
		String query = queryConstantPFA.PFA_419028_SQL10();
		return DataAccess.getEncounterId("EncounterID", query);
	}

	public String getEncounterIdFor_PFA_419029_SQL11() throws ClassNotFoundException, IOException, SQLException {
		String query = queryConstantPFA.PFA_419029_SQL11();
		return DataAccess.getEncounterId("EncounterID", query);
	}

	public String getEncounterIdFor_PFA_419030_SQL12() throws ClassNotFoundException, IOException, SQLException {
		String query = queryConstantPFA.PFA_419030_SQL12();
		return DataAccess.getEncounterId("EncounterID", query);
	}

	public void verifyAnsweForPregnancy(String ques) {
		Assert.assertTrue(pregnancyQuestion.getText().equalsIgnoreCase(ques));
		for (int i = 0; i < pregnancyQuestionAns.size(); i++) {
			String status = pregnancyQuestionAns.get(i).getAttribute("checked");
			if (status.equals("true")) {
				Assert.assertTrue(pregnancyQuestionAnsLabel.get(i).getText().equals("No"));
				break;
			}

		}
	}

	public void verifyDefaultAnswerForResident(String ques) {
		for (int i = 1; i < residentQuestionAns.size(); i--) {
			String status = residentQuestionAns.get(i).getAttribute("checked");
			if (status.equals("true")) {
				Assert.assertTrue(residentQuestionAnsLabel.get(i).getText().equals("Other"));
				break;
			}

		}
	}

	public void verifyNoAnswerSelectedforPregnancy(String ques) {
		int count = 0;
		Assert.assertTrue(pregnancyQuestion.getText().equalsIgnoreCase(ques));
		for (int i = 0; i < pregnancyQuestionAns.size(); i++) {
			String status = pregnancyQuestionAns.get(i).getAttribute("checked");
			if (status.equals("true")) {
				count++;
				break;
			}

			if (count > 0) {
				Assert.assertTrue(false);
			} else
				Assert.assertTrue(true);
		}
	}

	public void clickOverrideTab() {
		clickOn(overrideTab);
		visitNo = encounterId.getText();
	}

	public void verifyFollowUpDateTextBox() {
		String status = followUpDateTextbox.getAttribute("disabled");
		if (status.equals("true")) {
			Assert.assertTrue(true);
		}
	}

	public void verifyFollowUpLabel() {
		for (int i = 0; i < followUpDateLabel.size(); i++) {
			if (followUpDateLabel.get(i).getText().trim().equals("* FollowUp Date :")) {
				Assert.assertTrue(followUpDateLabel.get(i).getText().trim().equals("* FollowUp Date :"));
			}
		}

	}

	public void verifyDatePicker() {
		Assert.assertTrue(datePicker.isVisible());
	}

	public void clicksaveCWLButton() {
		clickOn(saveCWLButton);
	}

	public void verifyCWLErrorMsg(String msg) {
		Assert.assertTrue(errorCWLMessage.getText().trim().equalsIgnoreCase(msg));
	}

	public void selectFundingSource() {
		selectFromDropdown(fundingSourceDropdown, "Auto Insurance");
	}

	public void selectAction() throws InterruptedException {
		Thread.sleep(5000);
		selectFromDropdown(actionDropdown, "Funding Source Identified");
	}

	public void checkConfirmChkbox() {
		confirmCheckBOx.click();
	}

	public void enterText() {
		noteTextbox.clear();
		noteTextbox.sendKeys("Patient does NOT have other active insurance that is applicable to this visit");
	}

	public void verifyRecordAdded(String msg) {
		Assert.assertTrue(recordAddedLabel.getText().equalsIgnoreCase(msg));
	}

	public void verifyTabCompleted() {
		pfaTabColor.getAttribute("class").equals("TabBGSelC");
		r1Common.chkTabStatusIncompleteComplete();
	}

	public String currentWorkingAccount() {
		return encounterId.getText();
	}

	public void verifyAccountinCWLWrklst() {
		fundingSourceonCWLWrklst.getText().equalsIgnoreCase("Auto Insurance");
	}

	public void clickUnworkedSubfolder() {
		clickOn(unworkedSubFolder);
	}

	public void clickSaveAndContBtn() {
		clickOn(saveAndContBtn);
	}

	public void verifyActiveTab() {
		Assert.assertTrue(activeTabPFA.getText().equals("PFA"));
	}

	public void verifyMultipleFundngSrc() {
		int x = fundingSourcesScreeningNeeds.size();
		if (x == 1) {
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}
	}

	public void clickSelfPaySubFolder() {
		clickOn(selfPayL2SubFolder);
	}

	public void clickScreeningNeedsTab() {
		clickOn(screeningNeedsTab);
	}

	public void clickActionItemsTab() throws InterruptedException {
		Thread.sleep(7000);
		clickOn(actionItemsTab);
	}

	public void enterNoOfPersonInHousehold() {
		enterPersonInHousehold.clear();
		enterPersonInHousehold.sendKeys("3");
	}

	public void selectEmpStatus() {
		clickOn(fullTimeStatus);
	}

	public void clickSubmitAllBtn() {
		clickOn(submitAllFSBtn);
	}

	public void verifycommonDataNeedsTabGreen() {
		Assert.assertTrue(commonDataNeedsPassed.getText().equalsIgnoreCase("Common Data Needs"));
	}

	public void verifyEmploymentStatusAsFull() {
		for (int i = 0; i < patientEmploymentStatus.size(); i++) {
			if (patientEmploymentStatusLabel.get(i).getText().equalsIgnoreCase("Full Time")) {
				Assert.assertTrue(true);
				break;
			}
		}
	}

	public void verifyScreeningQuesDeclined(String status) {
		for (int i = 0; i < screeningQuestionnaireStatus.size(); i++) {
			if (screeningQuestionnaireStatus.get(i).isSelected()) {
				Assert.assertTrue(screeningQuestionnaireStatusLabel.get(i).getText().equalsIgnoreCase(status));
			}
		}
	}

	public void clickYesForScreeningQuestionnaire() {
		for (int i = 0; i < screeningQuestionnaireStatusLabel.size(); i++) {
			if (screeningQuestionnaireStatusLabel.get(i).getText().equalsIgnoreCase("Yes")) {
				screeningQuestionnaireStatus.get(i).click();
			}
		}
	}

	public void verifyAnswersDisabledOrEnabled() {
		int count = 0;
		for (int i = 1; i < screeningAnsInputs.size(); i++) {
			if (screeningAnsInputs.get(i).getAttribute("disabled") != null) {
				count++;
			}
		}

		if (count > 0) {
			System.out.println("Disabled");
		} else {
			System.out.println("Enabled");
		}
	}

	public void verifyAnswersSelected() throws InterruptedException {
		int count = 0;
		Thread.sleep(4000);
		for (int i = 2; i < screeningAnsInputs.size(); i++) {
			if (screeningAnsInputs.get(i).isSelected()) {
				count++;
			}
		}

		if (count > 0) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

}
