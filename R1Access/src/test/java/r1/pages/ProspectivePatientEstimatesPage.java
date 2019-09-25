package r1.pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;



public class ProspectivePatientEstimatesPage extends PageObject{
	
	
	ArrayList<String> getColValue;
	String selPayorCode,selPlanCode,selSubscriberID,selCopay,selCoIns,selDeduct,selOOPRemaining,selVerified;
	int count;
	R1AccessCommonMethods commonMethodsR1Access;
	String firstname,valuePayorCode,valuePlanCode,subscriberId,valueCopay,valueCoinsurance,valueDeductible,valueOOP,payorStatus,encounteredID;
	
	@FindBy(xpath = "//span[text() = 'Prospective Patient Estimates']")
	private WebElementFacade prospective_patient_estimates_Page;
	
	@FindBy(xpath = "//input[contains(@id,'btnAddPatient')]")
	private WebElementFacade addButton;
	
	@FindBy(xpath = "//a[contains(@id,'_btnAddCoverage')]")
	private WebElementFacade btnAddCoverage;
	
	@FindBy(xpath = "//a[contains(text(),'Update Coverage')]")
	private WebElementFacade btnUpdateCoverage;
	
	@FindBy(xpath = "//input[contains(@id,'_lbCheckEligibility')]")
	private WebElementFacade btnCheckEligibility;
	
	@FindBy(xpath = "//span[contains(text(),'First Name Required !!')]")
	private WebElementFacade msgFirstName;
	
	@FindBy(xpath = "//span[contains(text(),'Last Name Required !!')]")
	private WebElementFacade msgLastName;
	
	@FindBy(xpath = "//span[contains(text(),'DOB Required !!')]")
	private WebElementFacade msgDOB;
	
	@FindBy(xpath = "//span[contains(text(),'Gender Required !!')]")
	private WebElementFacade msgGender;
	
	@FindBy(xpath = "//span[contains(text(),'Patient Type Required !!')]")
	private WebElementFacade msgPatientType;
	
	@FindBy(xpath = "//span[contains(text(),'Enter Valid Phone No')]")
	private WebElementFacade msgPhone;
	
	@FindBy(xpath = "//input[contains(@id,'txtPatientFirstName')]")
	private WebElementFacade txtFirstName;
	
	@FindBy(xpath = "//input[contains(@id,'txtPatientLastName')]")
	private WebElementFacade txtLastName;
	
	@FindBy(xpath = "//input[contains(@id,'txtGuarantorFirstName')]")
	private WebElementFacade txtGuarantorFirstName;
	
	@FindBy(xpath = "//input[contains(@id,'txtGuarantorLastName')]")
	private WebElementFacade txtGuarantorLastName;
	
	@FindBy(xpath = "//input[contains(@id,'txtDOB')]")
	private WebElementFacade txtDOB;
	
	@FindBy(xpath = "//input[contains(@id,'txtGuarantorDOB')]")
	private WebElementFacade txtGuarantorDOB;
	
	@FindBy(xpath = "//select[contains(@id,'ddlGender')]")
	private WebElementFacade selectGender;
	
	@FindBy(xpath = "//select[contains(@id,'ddlPatientType')]")
	private WebElementFacade selectPatientType;
	
	@FindBy(xpath = "//input[contains(@id,'txtPhoneNumber')]")
	private WebElementFacade txtPhoneNumber;
	
	@FindBy(xpath = "//span[contains(@id,'lblmessage')]")
	private WebElementFacade txtMessagebelowEighteen;
	
	@FindBy(xpath = "//span[contains(@id,'lblmessage')]")
	private WebElementFacade txtMessageAboveEighteen;
	
	@FindBy(xpath = "//div[contains(@class,'row patient-details')]")
	private WebElementFacade panelPatientDetail;
	
	@FindBy(xpath = "//select[contains(@id,'_ddlPayorCode')]")
	private WebElementFacade selectPayorCode;
	
	@FindBy(xpath = "//select[contains(@id,'_ddlFacilityPlanCode')]")
	private WebElementFacade selectFacilityPlanCode;
	
	@FindBy(xpath = "//input[contains(@id,'_txtSubscriberID')]")
	private WebElementFacade txtSubscriberID;
	
	@FindBy(xpath = "//input[contains(@id,'_txtCopay')]")
	private WebElementFacade txtCopay;
	
	@FindBy(xpath = "//input[contains(@id,'_txtCoinsurance')]")
	private WebElementFacade txtCoinsurance;
	
	@FindBy(xpath = "//input[contains(@id,'_txtDeductible')]")
	private WebElementFacade txtDeductible;
	
	@FindBy(xpath = "//input[contains(@id,'_txtMaxOutOfPocket')]")
	private WebElementFacade txtMaxOutOfPocket;
	
	@FindBy(xpath = "//select[contains(@id,'_ddlStatus')]")
	private WebElementFacade ddlStatus;
	
	@FindBy(xpath = "//table[contains(@id,'grdCoverageSelected')]//img[contains(@alt,'Delete')]/..")
	private WebElementFacade crossMark;
	
	@FindBy(xpath = "//table[contains(@id,'_grdCoverageSelected')]//tr[@class='PanelDetail']")
	private WebElementFacade getCoverageRowValue;
	
	@FindBy(xpath = "//label[contains(text(),'Payor')]")
	private WebElementFacade lblPayor;
	
	@FindBy(xpath = "//label[contains(text(),'Plan')]")
	private WebElementFacade lblPlan;
	
	@FindBy(xpath = "//label[contains(text(),'Subscriber ID')]")
	private WebElementFacade lblSubscriberID;
	
	@FindBy(xpath = "//input[contains(@id,'_txtKeyword')]")
	private WebElementFacade txtServiceSearch;
	
	@FindBy(xpath = "//input[contains(@id,'_btnSearch')]")
	private WebElementFacade btnServiceSearch;
	
	@FindBy(xpath = "//label[contains(text(),'Exact Match')]/preceding-sibling::input")
	private WebElementFacade btnExactMatch;
	
	@FindBy(xpath = "//table[contains(@id,'_grdDRGSearchResults')]//tr//a")
	private WebElementFacade grdDRGSearchResults;
	
	@FindBy(xpath = "//table[contains(@id,'_grdHCPCSearchResults')]//tr//a")
	private WebElementFacade grdHCPCSearchResults;
	
	@FindBy(xpath = "//table[contains(@id,'_grdDRGSelected')]//tr")
	private List<WebElementFacade> grdDRGSelected;
	
	@FindBy(xpath = "//div[contains(@id,'_pnlSelectedServicesBody')]//tr")
	private List<WebElementFacade> grdHCPCSelected;
	
	@FindBy(xpath = "//input[contains(@id,'_btnCalculate')]")
	private WebElementFacade btnCalculate;
	
	@FindBy(xpath = "//table[contains(@id,'_tblPrimaryCoverage')]//tr[2]//td[2]//input")
	private WebElementFacade txtCopay1;
	
	@FindBy(xpath = "//input[contains(@id,'_txtDeductible1')]")
	private WebElementFacade txtDeductible1;
	
	@FindBy(xpath = "//input[contains(@id,'_txtCoinsurance1')]")
	private WebElementFacade txtCoinsurance1;
	
	@FindBy(xpath = "//input[contains(@id,'_txtMaxOutPocket1')]")
	private WebElementFacade txtMaxOutPocket1;
	
	public String coverageResultRow = "//table[contains(@id,'_grdCoverageSelected')]//tr";
	public String coverageResultRowHeader= "//table[contains(@id,'_grdCoverageSelected')]//tr[1]/td";
	
	public String pstWorklisttRow = "//table[contains(@id,'_grid_grdWorklist')]//tr";
	public String pstWorklistRowHeader= "//table[contains(@id,'_grid_grdWorklist')]//tr[1]/td";
	
	
	
/****************************************************************************************************************************************/	
	
	public void clickServiceSearchButton() {
		clickOn(btnServiceSearch);
	}
	
	public void enterDRGCode(String drgCode) {
		typeInto(txtServiceSearch,drgCode);
	}
	
	public void enterCPTCode(String cptCode) {
		typeInto(txtServiceSearch,cptCode);
	}

	public void verifyPateintDetailLable() {
	    Assert.assertTrue("patient detail labels are not matching",panelPatientDetail.getText().contains("First Name*") &&
	     panelPatientDetail.getText().contains("Last Name*") &&
	     panelPatientDetail.getText().contains("DOB*") &&
	     panelPatientDetail.getText().contains("Gender*") &&
	     panelPatientDetail.getText().contains("Patient Type*") &&
	     panelPatientDetail.getText().contains("Phone*"));
    }
	
	public void validationMessagesRequiredFields() {
		Assert.assertEquals("First Name Required !!", msgFirstName.getText());
		Assert.assertEquals("Last Name Required !!", msgLastName.getText());
		Assert.assertEquals("DOB Required !!", msgDOB.getText());
		Assert.assertEquals("Gender Required !!", msgGender.getText());
		Assert.assertEquals("Patient Type Required !!", msgPatientType.getText());
		Assert.assertEquals("Enter Valid Phone No", msgPhone.getText());
	}
	
	public void verifyCoveragePanelLable() {
		Assert.assertEquals("Payor lable is not matching", txtGuarantorFirstName.getText().contains("Payor"));
		Assert.assertEquals("Plan lable is not matching", txtGuarantorFirstName.getText().contains("Plan"));
		Assert.assertEquals("Subscriber ID lable is not matching", txtGuarantorFirstName.getText().contains("Subscriber ID"));
	}
	
   public void prospectivePatientEstimates_Page(){
		Assert.assertEquals("Prospective Patient Estimates", prospective_patient_estimates_Page.getText().toString());
	}
	
	public void clickAddButton() {
		clickOn(addButton);
	}
	
	public void clickAddCoverageButton() {
		clickOn(btnAddCoverage);
	}
	
	public void clickUpdateCoverageButton() {
		clickOn(btnUpdateCoverage);
	}
	
	public void clickCheckEligibilityButton() {
		clickOn(btnCheckEligibility);
	}
	
    public void clickProspectivepatientEstimatesLink(String item) {
		commonMethodsR1Access.clickSubSideR1HubModulesMenuLink(item);
	}
	
	public void clickNewLink(String newTab) {
		commonMethodsR1Access.clickUpperHeaderLink(newTab);
	}
	
	public void clickWorklistLink(String worklist) {
		commonMethodsR1Access.clickUpperHeaderLink(worklist);
	}
	
	public void workListFilter(String firstName, String equals) {
		commonMethodsR1Access.ddlWorkListFilter("F Name", "=", firstname);
	}
	
	public void enterPatientName(String firstName, String lastName) {
		typeInto(txtFirstName,firstName);
		typeInto(txtLastName,lastName);
		firstname=firstName; 
	}
	
	public void enterGuarantorName(String firstName, String lastName) {
		typeInto(txtGuarantorFirstName,firstName);
		typeInto(txtGuarantorLastName,lastName);
		firstname=firstName;
	}
	
	public void enterguarantorDOB(String dob) {
		typeInto(txtGuarantorDOB,dob);
	}
	
	public void enterPatientDetailBelowEighteen(String dob, String gender, String phoneNo) {
		typeInto(txtDOB,dob);
		selectFromDropdown(selectGender,gender);
		typeInto(txtPhoneNumber,phoneNo);
	}
	
	public void verifyMessageBelowEighteen(String message) {
		Assert.assertTrue("Message is not verified",txtMessagebelowEighteen.getText().contains(message));
	}
	
	public void enterPatientDetailAboveEighteen(String dob, String gender, String phoneNo) {
		typeInto(txtDOB,dob);
		selectFromDropdown(selectGender,gender);
		typeInto(txtPhoneNumber,phoneNo);
	}
	
	public void verifyMessageAboveEighteen(String message) {
		Assert.assertTrue("Message is not verified",txtMessageAboveEighteen.getText().contains(message));
	}
	
	public void selectPatientType(String patientType) {
		selectFromDropdown(selectPatientType,patientType);
	}
	
	public void enterCoverageDetail(String payorCode, String planCode, String subscriberID) {
		selectFromDropdown(selectPayorCode,payorCode);
		selectFromDropdown(selectFacilityPlanCode,planCode);
		typeInto(txtSubscriberID,subscriberID);
		valuePayorCode= payorCode;
		valuePlanCode= planCode;
		subscriberId= subscriberID;
	}
	
	public void enterCoverageDetail(String copay, String coinsurance, String deductible, String oop) {
		typeInto(txtCopay,copay);
		typeInto(txtCoinsurance,coinsurance);
		typeInto(txtDeductible,deductible);
		typeInto(txtMaxOutOfPocket,oop);
		valueCopay= copay;
		valueCoinsurance= coinsurance;
		valueDeductible= deductible;
		valueOOP= oop;
	}
	
	public void selectStatus(String status) {
		selectFromDropdown(ddlStatus,status);
		payorStatus= status;
	}
	
	public void DelAllCoverage() throws InterruptedException 
    {
    	int size = commonMethodsR1Access.getTableColValue(coverageResultRow, coverageResultRowHeader, "Payor").size();
    	while(size>0)
    	{
    	clickOn(crossMark);	
    	size--;
    	}
    	Assert.assertEquals("Coverage didn't get deleted", size, 0);	
    }
	
	@SuppressWarnings("unchecked")
	public void getEncounteredID() {
		getColValue= commonMethodsR1Access.getTableColValue(pstWorklisttRow, pstWorklistRowHeader, "Acc #");
	    encounteredID = getColValue.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public void verifyPayorCode() {
		getColValue= commonMethodsR1Access.getTableColValue(coverageResultRow, coverageResultRowHeader, "Payor") ;
		selPayorCode=getColValue.get(0);
		Assert.assertTrue("Coverage row values are not matching", selPayorCode.contains(valuePayorCode));
	}
	
	@SuppressWarnings("unchecked")
	public void verifyPlanCode() {
		getColValue= commonMethodsR1Access.getTableColValue(coverageResultRow, coverageResultRowHeader, "Plan") ;
		selPlanCode=getColValue.get(0);
		Assert.assertTrue("Coverage row values are not matching", valuePlanCode.contains(selPlanCode));
	}
	
	@SuppressWarnings("unchecked")
	public void verifySubscriberID() {
		getColValue= commonMethodsR1Access.getTableColValue(coverageResultRow, coverageResultRowHeader, "Subscriber") ;
		selSubscriberID=getColValue.get(0);
		Assert.assertTrue("Coverage row values are not matching", selSubscriberID.contains(subscriberId));
	}
	
	@SuppressWarnings("unchecked")
	public void verifyCopay() {
		getColValue= commonMethodsR1Access.getTableColValue(coverageResultRow, coverageResultRowHeader, "Copay") ;
		selCopay=getColValue.get(0);
		Assert.assertTrue("Coverage row values are not matching", selCopay.contains(valueCopay));
	}
	
	@SuppressWarnings("unchecked")
	public void verifyCoIns() {
		getColValue= commonMethodsR1Access.getTableColValue(coverageResultRow, coverageResultRowHeader, "CoIns") ;
		selCoIns=getColValue.get(0);
		Assert.assertTrue("Coverage row values are not matching", selCoIns.contains(valueCoinsurance));
	}
	
	@SuppressWarnings("unchecked")
	public void verifyDeduct() {
		getColValue= commonMethodsR1Access.getTableColValue(coverageResultRow, coverageResultRowHeader, "Deduct") ;
		selDeduct=getColValue.get(0);
		Assert.assertTrue("Coverage row values are not matching", selDeduct.contains(valueDeductible));
	}
	
	@SuppressWarnings("unchecked")
	public void verifyOOPRemaining() {
		getColValue= commonMethodsR1Access.getTableColValue(coverageResultRow, coverageResultRowHeader, "OOP Remaining") ;
		selOOPRemaining=getColValue.get(0);
		Assert.assertTrue("Coverage row values are not matching", selOOPRemaining.contains(valueOOP));
	}
	
	@SuppressWarnings("unchecked")
	public void verifyPayorStatus() {
		getColValue= commonMethodsR1Access.getTableColValue(coverageResultRow, coverageResultRowHeader, "Verified") ;
		selVerified=getColValue.get(0);
		Assert.assertTrue("Coverage row values are not matching", selVerified.contains(payorStatus));
	}
	
	public void verifyPatientPortion() {
		System.out.println(txtCopay1.getText());
		System.out.println(selCopay);
		Assert.assertTrue("patient potion values are not matching", txtCopay1.getText().contains(selCopay) &&
				txtDeductible1.getText().contains(selDeduct) &&
				txtCoinsurance1.getText().contains(selCoIns) &&
				txtMaxOutPocket1.getText().contains(selOOPRemaining));
	}
	
	public void selectRadioExactOrContains(){
		boolean radioContains = btnExactMatch.isSelected();
		if (!radioContains)
			clickOn(btnExactMatch);
     }
	
	public void clickAddDRGServiceButton() {
		clickOn(grdDRGSearchResults);
	}
	
	public void clickAddCPTServiceButton() {
		clickOn(grdHCPCSearchResults);
	}
	
	public void verifyGrdDRGSelected() {
		count=grdDRGSelected.size();
		Assert.assertTrue("Service selected grid does not exist" , count > 1);
    }
	
	public void verifyGrdHCPCSelected() {
		count=grdHCPCSelected.size();
		Assert.assertTrue("Service selected grid does not exist" , count > 1);
    }
	
	public void clickCalculateButton() {
		clickOn(btnCalculate);
	}

	
    
	
	}
	




	
	
	
	
	
	
	
	
	
	
	


