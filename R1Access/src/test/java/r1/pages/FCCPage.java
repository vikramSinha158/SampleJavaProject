package r1.pages;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import cucumber.api.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.utilities.CommonMethods;

public class FCCPage extends BasePage{
	
	
	List<String> fccWorkListAccounts;
	String patientPagevisitNumber;
	String workListDataAsc;
	
	
	@FindBy(xpath = "//span[@class='subhead']/span[1]")
	private WebElementFacade fccWorkListTitle;
	
	@FindBy(xpath = "//td[@class='PanelTitle']//td[@class='SubHead']/span")
	private List<WebElementFacade> patientDetailsLabel;
	
	@FindBy(xpath = "//td[@class='PanelTitle']//td[@class='SubHead2']/span")
	private List<WebElementFacade> patientDetailsText;
	
	
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
	
	
	
	


	
	
	public void verifyFCCWorkListPage() {
		fccWorkListAccounts = new ArrayList<String>();
		for(int i=0;i<fccWorkListAccountsList.size();i++) {
			fccWorkListAccounts.add(fccWorkListAccountsList.get(i).getText());
		}
		Assert.assertEquals("FCC Worklist page title is not matching", "FCC Coverage Workflow", fccWorkListTitle.getText());
	}
	
	public void verifyPatientDetailsLabel() {
		Assert.assertTrue("Patient Name is not appearingon Patient details label", patientDetailsNameLabel.size()>0);
		Assert.assertTrue("Admit Date is not appearingon Patient details label", patientDetailsAdmitDateLabel.size()>0);
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
}
