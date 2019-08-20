package r1.pages;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import cucumber.api.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.utilities.CommonMethods;
import r1.serenity.steps.R1NeccessitySteps;

public class FCCPage extends BasePage{
	
	R1NeccessitySteps neccessitySteps;
	
	List<String> fccWorkListAccounts;
	String patientPagevisitNumber,workListDataAsc,visit;
	
	
	@FindBy(xpath = "//span[@class='subhead']/span[1]")
	private WebElementFacade fccWorkListTitle;
	
	@FindBy(xpath = "//td[@class='PanelTitle']//td[@class='SubHead']/span")
	private List<WebElementFacade> patientDetailsLabel;
	
	@FindBy(xpath = "//td[@class='PanelTitle']//td[@class='SubHead2']/span")
	private List<WebElementFacade> patientDetailsText;
	
	@FindBy(xpath = "//select[contains(@name,'ddlActions')]")
	private WebElementFacade activityDropDown;
	
	@FindBy(xpath = "//select[contains(@name,'ddlDisposition')]")
	private WebElementFacade dispositionDropDown;
	
	@FindBy(xpath = "//span[contains(@id,'lblName')]")
	private List<WebElementFacade> patientDetailsNameLabel;
	
	@FindBy(xpath = "(//td[@class='PanelTitle']//td[@class='SubHead2'])[last()-1]")
	private List<WebElementFacade> patientDetailsAdmitDateLabel;
	
	@FindBy(xpath = "//a[contains(@class,'record-next')]")
	private WebElementFacade rightVCRButton;
	
	@FindBy(xpath = "//td[@class='accountnumber']")
	private List<WebElementFacade> fccWorkListAccountsList;
	
	@FindBy(xpath = "//span[contains(@id,'lblEncounterNum')]")
	private WebElementFacade patientVisit;
	
	@FindBy(xpath = "//li[contains(@class,'TabBGSel')]")
	private WebElementFacade fccTab;
	
	@FindBy(xpath = "//a[contains(@id,'LocationChooser_hypLoc')]")
	private WebElementFacade facilityList;
	
	@FindBy(xpath = "//select[contains(@id,'ddlColumns')]")
	private WebElementFacade filterDropDown;
	
	@FindBy(xpath = "//select[contains(@id,'ddlClauses')]")
	private WebElementFacade operatorDropDown;
	
	@FindBy(xpath = "//input[contains(@id,'txtSearch')][1]")
	private WebElementFacade textBox;
	
	@FindBy(xpath = "//a[contains(@id,'btnFilter')]")
	private WebElementFacade filterButton;
	
	@FindBy(xpath = "//table[@class='worklistTable']//tr[@valign='middle']")
	private List<WebElementFacade> workListSize;
	
	@FindBy(xpath = "//a[contains(@id,'lnkClear')]")
	private WebElementFacade clearButton;
	
	@FindBy(xpath = "//a[text()='Facility']")
	private WebElementFacade facilityColumnHeader;
	
	@FindBy(xpath = "//table[@class='worklistTable']//tr//td[@class='rowNumber']/following-sibling::td[1]/a")
	private List<WebElementFacade> sortedFacilityAscSize;
	
	@FindBy(xpath = "//table[@class='worklistTable']//tr//td[@class='rowNumber']/following-sibling::td[3]")
	private List<WebElementFacade> workListPatientType;
	
	
	@FindBy(xpath = "//select[contains(@name,'ddlPatientType')]")
	private WebElementFacade patientTypeDropDown;
	
	@FindBy(xpath = "//input[contains(@name,'txtNextFollowUpDate')]")
	private WebElementFacade followUpDate;
	
	@FindBy(xpath = "//table[@class='PanelDetail']//tr[1]/td")
	private List<WebElementFacade> followupHistoryLabel;

	@FindBy(xpath = "//table[@class='PanelDetail']//tr[2]/td")
	private List<WebElementFacade> followupHistoryValue;
	
	@FindBy(xpath = "//table[@class='PanelDetail actionLog']//tr[1]/td")
	private List<WebElementFacade> actionLogLabels;

	@FindBy(xpath = "//table[@class='PanelDetail actionLog']//tr[2]/td")
	private List<WebElementFacade> actionLogValues;
	
	@FindBy(xpath = "//span[@class='header']")
	private WebElementFacade fccHubPage;
	
	@FindBy(xpath = "//span[contains(@id,'lblEncounterNum')]")
	private WebElementFacade visitNumber;
	
	@FindBy(xpath = "//tr/td[@class='accountnumber']")
	private List<WebElementFacade> visitNumberWorkList;
	
	@FindBy(xpath = "//table[@class='worklistTable']//tr/td[15]/a")
	private List<WebElementFacade> workListDisposition;
	
	@FindBy(xpath = "//table[@class='worklistTable']//tr/td[16]/a")
	private List<WebElementFacade> workListFollowUp;
	
	@FindBy(xpath = "//select[contains(@id,'searchColumn')]")
	private WebElementFacade serviceScopeFilter;
	
	@FindBy(xpath = "//select[@id='dllLocationSearch']")
	private WebElementFacade searchDropDown;
	
	@FindBy(xpath = "//input[@id='txtLocSearchValue']")
	private WebElementFacade searchTextField;
	
	@FindBy(xpath = "//span[@id='BtnLocSearch']")
	private WebElementFacade searchButton;
	
	@FindBy(xpath = "//div[@id='LocationGridData']//div/a")
	private WebElementFacade viewLink;
	
	@FindBy(xpath = "//div[@id='FacilitySettingsTasksGridData']/div/div[3]")
	private List<WebElementFacade> workListName;
	
	@FindBy(xpath = "//div[@id='FacilitySettingsTasksGridData']/div/div[1]")
	private List<WebElementFacade> workListDrillDownIcon;
	
	@FindBy(xpath = "//div[@id='pnlFacilitySettingsTasks']//div[text()='Pre-Registration']/following-sibling::div[3]")
	private WebElementFacade workListEdit;
	
	@FindBy(xpath = "//div[@id='TaskGridDataData']/div/div[1]")
	private WebElementFacade workListTaskList;
	
	



	
	public void verifyFCCWorkListPage(String pageTitle) {
		fccWorkListAccounts = new ArrayList<String>();
		for(int i=0;i<fccWorkListAccountsList.size();i++) {
			fccWorkListAccounts.add(fccWorkListAccountsList.get(i).getText());
		}
		Assert.assertEquals("FCC Worklist page title is not matching", pageTitle, fccWorkListTitle.getText());
	}
	
	public void verifyR1FCCHubPage() {
		Assert.assertEquals("R1 FCC menu page is not launching", "FCC", fccHubPage.getText());
		
	}
	
	public void verifyPatientDetailsLabel() {
		Assert.assertTrue("Patient Name is not appearingon Patient details label", patientDetailsNameLabel.size()>0);
		Assert.assertTrue("Admit Date is not appearing on Patient details label", patientDetailsAdmitDateLabel.size()>0);
		Assert.assertEquals("DOB Label is not verified", "DOB:",patientDetailsLabel.get(0).getText());
		Assert.assertEquals("SSN Label is not verified", "SSN:",patientDetailsLabel.get(1).getText());
		Assert.assertEquals("MR Label is not verified", "MR#:",patientDetailsLabel.get(2).getText());
		Assert.assertEquals("VISIT Label is not verified", "Visit#:",patientDetailsLabel.get(3).getText());
		Assert.assertEquals("PT Label is not verified", "PT:",patientDetailsLabel.get(4).getText());
		Assert.assertEquals("SERV Label is not verified", "Serv:",patientDetailsLabel.get(5).getText());
		Assert.assertEquals("LOC Label is not verified", "Loc:",patientDetailsLabel.get(6).getText());
		
		
		Assert.assertTrue("DOB value is missing", patientDetailsText.get(0).getText().length()>0);
		Assert.assertTrue("SSN value is missing", patientDetailsText.get(1).getText().length()>0);
		Assert.assertTrue("MR value is missing", patientDetailsText.get(2).getText().length()>0);
		Assert.assertTrue("VISIT value is missing", patientDetailsText.get(3).getText().length()>0);
		Assert.assertTrue("PT value is missing", patientDetailsText.get(4).getText().length()>0);
		Assert.assertTrue("SERV value is missing",patientDetailsText.get(5).getText().length()>0);
		Assert.assertTrue("LOC value is missing", patientDetailsText.get(6).getText().length()>0);
		Assert.assertTrue("Admit Date value is missing", patientDetailsText.get(8).getText().length()>0);
		
	}
	
	public void clickRightVCRButton() {
		patientPagevisitNumber = patientVisit.getText();
		clickOn(rightVCRButton);
		Assert.assertTrue("Next Account FCC is not display",!patientPagevisitNumber.equals(patientVisit.getText()) && fccWorkListAccounts.contains(patientVisit.getText()) && fccTab.getText().equals("FCC"));
	}
	
	public void verifySelectedFacility(String facility) {
	Assert.assertTrue("Selected Facility is not matching",facility.contains(facilityList.getText()));
	}
	
	public void selectFilterOperator(DataTable filter) {
		List<List<String>> filterList = filter.raw();
		
		for(int i=0;i<filterList.size();i++) {
			selectFromDropdown(filterDropDown,filterList.get(i).get(0));
			Assert.assertEquals("Selected Filter is not matching",getSelectedLabelFrom(filterDropDown), filterList.get(i).get(0));
			
			for(int j=0;j<CommonMethods.dropDownSize(operatorDropDown);j++) {
				CommonMethods.DrpIndex(operatorDropDown,j);
				selectFromDropdown(operatorDropDown,getSelectedValueFrom(operatorDropDown));
				Assert.assertEquals("Selected Operator is not matching",getSelectedValueFrom(operatorDropDown),CommonMethods.dropDownValues(operatorDropDown).get(j).getText());
			}
		 }
		
	}
	
	public void selectFilter(String filter) {
		selectFromDropdown(filterDropDown,filter);
	}
	
	public void selectOperator(String operator) {
		selectFromDropdown(operatorDropDown,operator);
	}
	
	public void enterText(String text) {
		textBox.sendKeys(text);
	}
	
	public void clickFilterButton() {
		clickOn(filterButton);
	}
	
	public void verifyWorkListSize(String text) {
		Assert.assertTrue(workListSize.size()>0);
		for(int i=0;i<fccWorkListAccountsList.size();i++) {
			Assert.assertTrue("There is no searched Account with-"+text,fccWorkListAccountsList.get(i).getText().contains(text));
		}
	}
	
	public void clickClearButton() {
		clickOn(clearButton);
	}
	
	public void clickFacilityColumnHeader() {
		clickOn(facilityColumnHeader);
	}
	
	public void verifyWorkListAscAsc() {
		workListDataAsc = sortedFacilityAscSize.get(0).getText();
	}
	
	public void verifyWorkListAscDesc() {
		Assert.assertTrue(!sortedFacilityAscSize.get(0).getText().equals(workListDataAsc));
	}
	
	public void selectPatientType(String patient) {
		selectFromDropdown(patientTypeDropDown,patient);
	}
	
	public void verifyFilterPatientType() {
		for(int i=0;i<workListPatientType.size();i++) {
			Assert.assertEquals("Patient type I is mismatch in PT column","I",workListPatientType.get(i).getText());
		}
	}
	
	public String selectActivity() {
		return CommonMethods.selectRandomList(activityDropDown);
	}
	
	public String selectDisposition() {
		return CommonMethods.selectRandomList(dispositionDropDown);
	}
	
	public void verifyFollowUp(String activity, String disposition,String type, String note) throws ClassNotFoundException, IOException, SQLException {
		visit = visitNumber.getText();
		Assert.assertTrue("Followup History label Updated By is not matching",followupHistoryLabel.get(0).getText().contains("Updated By"));
		Assert.assertTrue("Followup History label Type is not matching",followupHistoryLabel.get(1).getText().contains("Type"));
		Assert.assertTrue("Followup History label Action is not matching",followupHistoryLabel.get(2).getText().contains("Action"));
		Assert.assertTrue("Followup History label Disposition is not matching",followupHistoryLabel.get(3).getText().contains("Disposition"));
		Assert.assertTrue("Followup History label Note is not matching",followupHistoryLabel.get(4).getText().contains("Note"));
		Assert.assertTrue("Followup History label Event Date is not matching",followupHistoryLabel.get(5).getText().contains("Event Date"));
		Assert.assertTrue("Followup History label Next Action Date is not matching",followupHistoryLabel.get(6).getText().contains("Next Action Date"));
		Assert.assertTrue("Followup History label Updated Date is not matching",followupHistoryLabel.get(7).getText().contains("Updated Date"));
			
		neccessitySteps = new R1NeccessitySteps();
		
		Assert.assertTrue("Follow Up History Value Updated By is not matching",followupHistoryValue.get(0).getText().contains(neccessitySteps.getUserDisplayName()));
		Assert.assertTrue("Follow Up History Value Type is not matching",followupHistoryValue.get(1).getText().contains(type));
		Assert.assertTrue("Follow Up History Value Action is not matching",followupHistoryValue.get(2).getText().contains(activity));
		Assert.assertTrue("Follow Up History Value Disposition is not matching",followupHistoryValue.get(3).getText().contains(disposition));
		Assert.assertTrue("Follow Up History Value Note is not matching",followupHistoryValue.get(4).getText().contains(note));
		Assert.assertTrue("Follow Up History Value Event Date is not matching",followupHistoryValue.get(5).getText().contains(new SimpleDateFormat("MM/d/yyyy").format(new Date())));
		Assert.assertTrue("Follow Up History Value Next Action Date is not matching",followupHistoryValue.get(6).getText().contains(new SimpleDateFormat("MM/d/yyyy").format(new Date())));
		Assert.assertTrue("Follow Up History Value Updated Date is not matching",followupHistoryValue.get(7).getText().contains(new SimpleDateFormat("M/d/yyyy").format(new Date())));
	}
	
	public void verifyFCCActivityLog(String note) throws IOException {
		Assert.assertTrue("Activity Log header Type/Disposition is not matching", actionLogLabels.get(0).getText().contains("Type/Disposition"));
		Assert.assertTrue("Activity Log header Task is not matching", actionLogLabels.get(1).getText().contains("Task"));
		Assert.assertTrue("Activity Log header Updated By is not matching", actionLogLabels.get(2).getText().contains("Updated By"));
		Assert.assertTrue("Activity Log header Status is not matching", actionLogLabels.get(3).getText().contains("Status"));
		Assert.assertTrue("Activity Log header Note is not matching", actionLogLabels.get(4).getText().contains("Note"));
		Assert.assertTrue("Activity Log header Date/Time is not matching", actionLogLabels.get(5).getText().contains("Date/Time"));
		
		Assert.assertTrue("Activity Log value Type/Disposition is not matching", actionLogValues.get(0).getText().contains("Task"));
		Assert.assertTrue("Activity Log value Task is not matching", actionLogValues.get(1).getText().contains("Take Action"));
		Assert.assertTrue("Activity Log value Updated By is not matching", actionLogValues.get(2).getText().toLowerCase().contains(CommonMethods.LoadProperties("username").toLowerCase()));
		Assert.assertTrue("Activity Log value Status is not matching", actionLogValues.get(3).getText().contains("Incomplete"));
		Assert.assertTrue("Activity Log value Note is not matching", actionLogValues.get(4).getText().contains(note));
		Assert.assertTrue("Activity Log value Date/Time is not matching", actionLogValues.get(5).getText().contains(new SimpleDateFormat("M/d/yyyy").format(new Date())));
	}
	
	public void verifyWorkListDisposition(String disposition) {
		boolean flag = false;
		for(int i=0;i<visitNumberWorkList.size();i++) {
			if(visitNumberWorkList.get(i).getText().equals(visit)) {
				flag = true;
				Assert.assertEquals("Worklist Disposition is not matching",workListDisposition.get(i).getText(), disposition);
				Assert.assertTrue("Worklist FollowUp is not matching",workListDisposition.get(i).getText().contains(new SimpleDateFormat("MM/d/yyyy").format(new Date())));
				break;
			}
			Assert.assertTrue("Visit number is not appearing on the worklist",flag==true);
		}
	}
	
	
	public void selectServiceScopeFilter(String filter) {
		selectFromDropdown(serviceScopeFilter,filter);
	}
	
	public void selectSearchDropDownFacilitySetting(String search) {
		selectFromDropdown(searchDropDown,search);
	}
	
	public void enterTextFacilitySetting(String text) {
		typeInto(searchTextField,text);
	}
	
	public void clickSearchIcon() {
		clickOn(searchButton);
	}
	
	public void clickView() {
		clickOn(viewLink);
	}
	
	public void verifyFacilitySettingWorklistName(String worklistName) {
		boolean flag = false;
		for(int i=0;i<workListName.size();i++) {
			if(workListName.get(i).getText().contains(worklistName)) {
				flag = true;
				Assert.assertEquals("WorkList name is not matching on Facility Setting window",flag,true);
				break;
			}
		}
		Assert.assertEquals("WorkList name is not matching on Facility Setting window",flag,true);
	}
	
	public void clickFacilitySettingWorklistNameEdit(String worklistName) {
		for(int i=0;i<workListName.size();i++) {
			if(workListName.get(i).getText().contains(worklistName)) {
				clickOn(workListDrillDownIcon.get(i));
				withAction().moveToElement(workListEdit).click().build().perform();
			}
		}
	}
	
	public void verifyFacilitySettingWorklistTask(String worklistTask) {
		Assert.assertEquals("FCC Contact task is not appearing in the Facility Setting window",worklistTask,workListTaskList.getText());
	}
	
	
}
