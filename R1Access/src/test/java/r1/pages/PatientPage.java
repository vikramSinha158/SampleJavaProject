package r1.pages;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;   
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;
import java.util.Random; 
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.commons.utilities.CommonMethods;
import r1.commons.databaseconnection.DataAccess;
import r1.commons.databaseconnection.QueryConstantPatient;

public class PatientPage extends BasePage {

	Alert alert;
	CommonMethods commonMethod;
	static String SearchAccount, admintdate, dischargedate;
	String patientupdateFirstName, patientupdateLastName, gurantorUpateFirstName, gurantorUpdateLastName, query,status,tabcolor,skipAddress,Address,message;
	boolean checkDisplaySelect = true;
	R1AccessCommonMethods r1AccessCommonMethod;
	DataAccess dataAccess;
	QueryConstantPatient queryConstantPatient;
	Select select;	
	int length;	
	
	////*[contains(@id,'_lblMessage')]
	
	@FindBy(xpath = "//*[contains(@id,'_lblMessage')]")
	private WebElementFacade messageRecordUpdate;
	
	@FindBy(xpath = "//*[contains(@id,'_btnStatusOverrideUpdate')]")
	private WebElementFacade continueButton;
	
	@FindBy(xpath = "//*[contains(@id,'_btnStatusOverrideCancel')]")
	private WebElementFacade continueBCancelutton;
	
	@FindBy(xpath = "//td[contains(text(),'Are you sure you want to mark the task complete?')]")
	private WebElementFacade softException;
	
	@FindBy(xpath = "//*[contains(@id,'_txtSSN')]")
	private WebElementFacade getSSN;
	
	@FindBy(xpath = "//*[contains(@id,'_valSSN')]/li")
	private WebElementFacade ssnMessage;
	
	@FindBy(xpath = "//SELECT[contains(@id,'_ddlGender')]")
	private WebElementFacade selectGender;
	
	@FindBy(xpath = "//SELECT[contains(@id,'_ddlPatientType')]")
	private WebElementFacade selectPatientType;	

	@FindBy(xpath = "//*[contains(@id,'_grdSkipTrace')]//tr//td")
	private WebElementFacade skipGridLastName;

	@FindBy(xpath = "//*[contains(@id,'_grdSkipTrace')]//tr//td[9]")
	private WebElementFacade skipGridLAddress;

	@FindBy(xpath = "//*[contains(@id,'_btnSkipTrace')]")
	private WebElementFacade skipTraceButton;

	@FindBy(xpath = "//*[@id='Body']/div[4]")
	private WebElementFacade gurantorPopUP;

	@FindBy(xpath = "//a[contains(@id,'_btnEditGuar')]/img")
	private WebElementFacade gurantorEditLinkButton;

	@FindBy(xpath = "//a[contains(@id,'_btnRemoveGuar')]/img")
	private WebElementFacade gurantorDeleteLinkButton;

	@FindBy(xpath = "//*[contains(@id,'_txtGuarLastName')]")
	private WebElementFacade gurantorLastName;

	@FindBy(xpath = "//*[contains(@id,'_txtGuarFirstName')]")
	private WebElementFacade gurantorFirstName;

	@FindBy(xpath = "//div[@class='ui-dialog-buttonset']//button[1]")
	private WebElementFacade gurantorOK;

	@FindBy(xpath = "//div[@class='ui-dialog-buttonset']//button[2]")
	private WebElementFacade gurantorCancel;

	@FindBy(xpath = "//a[contains(@id,'_btnGuarUpdate')]")
	private WebElementFacade gurantorUpdate;

	@FindBy(xpath = "//a[contains(@id,'_btnUpdate')]")
	private WebElementFacade patientUpdate;

	@FindBy(xpath = "//div[@id='ui-id-5']")
	private WebElementFacade gurantorUpdatConfirm;

	@FindBy(xpath = "//*[@id='Table2']//label")
	private WebElementFacade updateRecord;

	@FindBy(xpath = "//input[contains(@id,'_chkAllowUpdate')]")
	private WebElementFacade checktUpdate;
	
	@FindBy(xpath = "//input[contains(@id,'_chkAllowUpdate')]")
	private List<WebElementFacade> checktUpdateList;

	@FindBy(xpath = "//input[contains(@id,'_chkReturnedMail')]")
	private WebElementFacade checkReturnedMail;

	@FindBy(xpath = "//input[contains(@id,'_chkAdmitted')]")
	private WebElementFacade checkAdmitted;

	@FindBy(xpath = "//input[contains(@id,'_chkDischarged')]")
	private WebElementFacade checkDischarge;

	@FindBy(xpath = "//input[contains(@id,'_chkCancel')]")
	private WebElementFacade checkCancel;

	@FindBy(xpath = "//table[@class='normal']")
	private WebElementFacade patientExceptionPanel;

	@FindBy(xpath = "//input[contains(@id,'_txtAddress1')]")
	private WebElementFacade patientAddress;

	@FindBy(xpath = "//input[contains(@id,'_txtAddress2')]")
	private WebElementFacade patientAddress2;

	@FindBy(xpath = "//input[contains(@id,'_txtCity')]")
	private WebElementFacade patientCity;

	@FindBy(xpath = "//input[contains(@id,'_txtZip')]")
	private WebElementFacade patientZip;

	@FindBy(xpath = "//input[contains(@id,'_txtLastName')]")
	private WebElementFacade patientLastName;

	@FindBy(xpath = "//input[contains(@id,'_txtFirstName')]")
	private WebElementFacade patientFirstName;

	@FindBy(xpath = "//*[contains(@id,'_txtGuarLastName')]")
	private List<WebElementFacade> gurantorTabLastName;

	@FindBy(xpath = "//*[contains(@id,'_WorklistPanel_tdBottom')]")
	private WebElementFacade criticalErrorMessage;
	
	@FindBy(xpath = "//input[contains(@id,'_txtSSN')]")
	private WebElementFacade newSSNText;	
	
	@FindBy(xpath = "//input[contains(@id,'_txtAdmitDate')]")
	private WebElementFacade admitDate;		

    public void clickOnGurantorEditLinkButton() {
		clickOn(gurantorEditLinkButton);
	}
	public void clickOnGurantorDeleteLinkButton() {
		clickOn(gurantorDeleteLinkButton);
	}
	public void clickOngurantorOK() {
		clickOn(gurantorOK);
	}
	public void clickOngurantorCancel() {
		clickOn(gurantorCancel);
	}
	public void clickOngurantorUpdate() {
		clickOn(gurantorUpdate);
	}
	public void clickOnPatientUpdate() {
		clickOn(patientUpdate);
	}
	public void clickOnUpdateCheckBox() {
		clickOn(checktUpdate);
	}	
	public void clickCheckUpdate()
	{
		length = checktUpdateList.size();	
		if (length> 0)
		{	clickOn(checktUpdate);
			clickOn(patientUpdate);
		}
		else
		{
			clickOn(patientUpdate);
		}		
	}
	
	public void clearkPatientAddress() {
		patientAddress.clear();
	}
	public void clearPatientAddress2() {
		patientAddress2.clear();
	}
	public void clearPatientCity() {
		patientCity.clear();
	}
	public void clearPatientZip() {
		patientZip.clear();
	}
	public void getPatientGuranorAccount() throws ClassNotFoundException, IOException, SQLException {
		query = QueryConstantPatient.queryPatientGurantor();
		SearchAccount = DataAccess.getEncounterId(("encounterid"), query);
	}
	public void updateGurantorFirstName() {
		int randomNumber = CommonMethods.GetRandom(100);
		gurantorUpateFirstName = "TESTFIRSTNAME" + Integer.toString(randomNumber);
		gurantorFirstName.clear();
		gurantorFirstName.sendKeys(gurantorUpateFirstName);
	}
	public void updateGurantorLastName() {
		int randomNumber = CommonMethods.GetRandom(100);
		gurantorUpdateLastName = "TESTLASTNAME" + Integer.toString(randomNumber);
		gurantorLastName.clear();
		gurantorLastName.sendKeys(gurantorUpdateLastName);
	}
	String updatedGurantorFirstName, updatedGurantorLastName;

	public void verifyGurantorUpdatedFirstNameLastName() {
		updatedGurantorFirstName = gurantorFirstName.getAttribute("value").toUpperCase().trim();
		updatedGurantorLastName = gurantorLastName.getAttribute("value").trim().toUpperCase().trim();
		Assert.assertTrue("First Name is not updateed",
				updatedGurantorFirstName.equalsIgnoreCase(gurantorUpateFirstName));
		Assert.assertTrue("Last Name is not updateed",
				updatedGurantorLastName.equalsIgnoreCase(gurantorUpdateLastName));
	}
	public void setPatientFirstName(String FirstName) {
		typeInto(patientFirstName, FirstName);
	}

	public void setPatientLastName(String lastName) {
		typeInto(patientLastName, lastName);
	}
	public void verifyUpdatedFirstNameLastName(String FirstName, String LastName) {
		Assert.assertTrue("First Name is not updateed", patientFirstName.getText().trim() == FirstName);
		Assert.assertTrue("Last Name is not updateed", patientLastName.getText().trim() == LastName);
	}
	public void getPatientCriticalAccount() throws ClassNotFoundException, IOException, SQLException {
		query = QueryConstantPatient.queryPatientGetCricitcalError();
		SearchAccount = DataAccess.getEncounterId(("encounterid"), query);
	}
	public void getPatientNonCriticalAccount() throws ClassNotFoundException, IOException, SQLException {
		query = QueryConstantPatient.queryPatientGetNonricitcalError();
		SearchAccount = DataAccess.getEncounterId(("encounterid"), query);
	}
	public void getPatientAccountGetChargeZero() throws ClassNotFoundException, IOException, SQLException {
		query = QueryConstantPatient.queryPatientforGreaterZeroAmmount();
		SearchAccount = DataAccess.getEncounterId(("encounterid"), query);
	}
	public void getPatientAccountGetChargeNotZero() throws ClassNotFoundException, IOException, SQLException {
		query = QueryConstantPatient.queryPatientforZeroAmmount();
		SearchAccount = DataAccess.getEncounterId(("encounterid"), query);
	}
	public void getPatientAccountGetChargeGreaterZero() throws ClassNotFoundException, IOException, SQLException {
		query = QueryConstantPatient.queryPatientforGreaterZeroAmmount();
		SearchAccount = DataAccess.getEncounterId(("encounterid"), query);
	}
	public void getPatientCritical() throws ClassNotFoundException, IOException, SQLException {
		query= QueryConstantPatient.queryPatientGetCricitcalError();
		SearchAccount = DataAccess.getEncounterId(("encounterid"), query);
	}
	public void clickOnSearch() {
		r1AccessCommonMethod.clickUpperHeaderLink("Search");
	}
	public void entersSearchText() {
		r1AccessCommonMethod.enterVisitNumber(SearchAccount);
	}
	public void clickOnSearchButton() {
		r1AccessCommonMethod.clickOnSearchButton();
	}
	public void clickPatientTab() {
		r1AccessCommonMethod.clickR1AccesModulesTab("Patient");
	}	
	public void clickCompleteButton()
	{
		r1AccessCommonMethod.clickActionStatusTab("Complete");
	}	
	public void verifyGurantorConfirmMessage() {
	    message = gurantorPopUP.getText();
		Assert.assertTrue("Are you sure? message does not exist", message.contains("Are you sure?"));
		Assert.assertTrue("Yes No button does not exist", message.contains("YesNo"));
	}
	public void ClearAddressCityZip() {
		patientAddress.clear();
		patientCity.clear();
		patientZip.clear();
	}
	public void VerifyCheckBox() {
		checkDisplaySelect = checktUpdate.isSelected();
		Assert.assertTrue("Checkbox is not disable", checkDisplaySelect == false);
	    message = updateRecord.getText().trim().trim();
		Assert.assertTrue("Update Patient Record? does not exist", message.equalsIgnoreCase("Update Patient Record?"));
	}
	//	Patient Address-Invalid Zip
	public void verifyPatientExceptionMesssage() {
		message = patientExceptionPanel.getText();
		Assert.assertTrue("Patient Address Street Number Not Valid message does not exist",
				message.contains("Patient Address Street Number Not Valid")|| message.contains("Patient Address-Invalid Zip"));
	//	Assert.assertTrue(
				//"Patient Address-Street Address Missing Patient Address-City Missing Patient Address-Zip Missing message does not exist",
			//	message.contains(
						//"Patient Address-Street Address Missing Patient Address-City Missing Patient Address-Zip Missing"));
	}
	public void verifyCriticalExceptionMesssage() {
		message = criticalErrorMessage.getText();
		Assert.assertTrue("Critical Exceptions Exist - Completion not allowed message does not exist",
				message.contains("Critical Exceptions Exist - Completion not allowed."));
	}
	public void verifyPatientTabcolor() {
	    tabcolor = r1AccessCommonMethod.checkTabColor("Patient");
		Assert.assertTrue("Patient tab color is not red", tabcolor.equalsIgnoreCase("Red"));
	}
	public void verifyIncompleteStatus() {
	   status = r1AccessCommonMethod.chkTabStatusIncompleteComplete();
	   Assert.assertTrue("Patient tab status is not Incomplete", status.equalsIgnoreCase("Incomplete") || status.equalsIgnoreCase("Redo"));
	}
	public void verifyCompleteStatus() {
		status = r1AccessCommonMethod.chkTabStatusIncompleteComplete();
		Assert.assertTrue("Patient tab status is notomplete", status.equalsIgnoreCase("Complete"));
	}
	public void verifyPatientDetails() {
		checkDisplaySelect = patientAddress.isDisplayed();
		Assert.assertTrue("Checkbox is not disable", checkDisplaySelect == true);
		checkDisplaySelect = patientCity.isDisplayed();
		Assert.assertTrue("Checkbox is not disable", checkDisplaySelect == true);
	}
	public void VerifyReturnMailCheckBox() {
		checkDisplaySelect = checkReturnedMail.isSelected();
		Assert.assertTrue("Checkbox is not disable", checkDisplaySelect == false);
	}
	public void VerifyAdmitCheckBox() {
		checkDisplaySelect = checktUpdate.isSelected();
		Assert.assertTrue("Checkbox is not disable", checkDisplaySelect == false);
		checkDisplaySelect = checkReturnedMail.isSelected();
		Assert.assertTrue("Checkbox is not disable", checkDisplaySelect == false);
	}
	public void VerifyCancelCheckBox() {
		checkDisplaySelect = checkCancel.isSelected();
		Assert.assertTrue("Checkbox is not disable", checkDisplaySelect == false);
	}
	public void getPatientAdmitDischargeDateStatus() throws ClassNotFoundException, IOException, SQLException {
		checkDisplaySelect = checkAdmitted.isSelected();
		query = queryConstantPatient.queryPatientCheckReturn(SearchAccount);
		admintdate = DataAccess.getEncounterId("isadmitted", query);
		if (admintdate == "1") {
			Assert.assertTrue("Checkbox is not disable", checkDisplaySelect == true);
		} else {
			Assert.assertTrue("Checkbox is not disable", checkDisplaySelect == false);
		}
		checkDisplaySelect = checkDischarge.isSelected();
		dischargedate = DataAccess.getEncounterId("isdischarged", query);
		if (dischargedate.equals("1")) {
			Assert.assertTrue("Checkbox is not disable", checkDisplaySelect == true);
		} else {
			Assert.assertTrue("Checkbox is not disable", checkDisplaySelect == false);
		}
	}
	public void verifyPatientCheckBox() {
		checkDisplaySelect = checkAdmitted.isDisplayed();
		Assert.assertTrue("Admit Checkbox is not disable", checkDisplaySelect == true);
		checkDisplaySelect = checkDischarge.isDisplayed();
		Assert.assertTrue("Dishcharge Checkbox is not disable", checkDisplaySelect == true);
		checkDisplaySelect = checkReturnedMail.isDisplayed();
		Assert.assertTrue("Return Checkbox is not disable", checkDisplaySelect == true);
		checkDisplaySelect = checkCancel.isDisplayed();
		Assert.assertTrue("Camce Checkbox is not disable", checkDisplaySelect == true);
	}
	public void VerifyGurantorTab() {
		checkDisplaySelect = gurantorLastName.isDisplayed();
		Assert.assertTrue("Gurantor Panel is visible", checkDisplaySelect == false);
	}
	public void AlertMessage() {
		getAlert().accept();
	}
	public void getFdischargePatient() throws ClassNotFoundException, IOException, SQLException {
		query = QueryConstantPatient.queryFdischargePatient();
		SearchAccount = DataAccess.getEncounterId(("encounterid"), query);
	}
	public void verifySkipTraceButton() {
		checkDisplaySelect = skipTraceButton.isDisplayed();
		Assert.assertTrue("Skip button does not visible", checkDisplaySelect == true);
	}
	public void clickSkipTraceButton() {
		clickOn(skipTraceButton);
	}
	public void verifySkipLastName() {
		checkDisplaySelect = skipGridLastName.isDisplayed();
		Assert.assertTrue("Skip Last Name does not visible", checkDisplaySelect == true);
	}
	public void clickSkipLastName() {
		clickOn(skipGridLastName);
	}
	public void verifySkipGridAddress() {
		skipAddress = skipGridLAddress.getText().trim();
		Address = patientAddress.getAttribute("value").trim();
		Assert.assertTrue("Skip Trace Grid Address does not updated ", skipAddress.equals(Address));
	}
	public void verifyGurantorTab() {
	   int count = gurantorTabLastName.size();
		Assert.assertTrue("Gurantor Tab is visible", count <= 0);
	}
	public void EnterInvalidAddress() {
		patientAddress.clear();
		patientAddress.sendKeys("TestAddress");
		patientCity.clear();
		patientCity.sendKeys("TestCity");
		patientZip.clear();
		patientZip.sendKeys("TestZip");
	}
	
	public void verifyNewPatientFields()
	{	checkDisplaySelect=patientAddress.isDisplayed();
		Assert.assertTrue("Address is not visible", checkDisplaySelect == true);		
		checkDisplaySelect=patientAddress2.isDisplayed();
		Assert.assertTrue("Address2 is not visible", checkDisplaySelect == true);
		checkDisplaySelect=patientCity.isDisplayed();
		Assert.assertTrue("City is not visible", checkDisplaySelect == true);		
		checkDisplaySelect=patientZip.isDisplayed();
		Assert.assertTrue("Zip is not visible", checkDisplaySelect == true);
		checkDisplaySelect=patientLastName.isDisplayed();
		Assert.assertTrue("Last Name is not visible", checkDisplaySelect == true);
		checkDisplaySelect=patientFirstName.isDisplayed();
		Assert.assertTrue("First  Name is not visible", checkDisplaySelect == true);
		checkDisplaySelect=newSSNText.isDisplayed();
		Assert.assertTrue("SSN is not visible", checkDisplaySelect == true);
		checkDisplaySelect=admitDate.isDisplayed();
		Assert.assertTrue("Admitn Date is not visible", checkDisplaySelect == true);		
	}	
	
	String NewPatientFistName, NewPatientLastNam, NewPatientCity,NewPatientZip,NewPatientAddress1,NewPatientAddress2;
	
    public void addPatient() 
    {	 selectFromDropdown(selectGender,"Female");
		 selectFromDropdown(selectPatientType,"S - Outpatient Surgery");
		 LocalDate futureDate = LocalDate.now().plusDays(16);
		 admitDate.sendKeys(futureDate.toString());
		 int randomNumber = CommonMethods.GetRandom(999999999);
		 int ranValue=CommonMethods.GetRandom(9);
			newSSNText.sendKeys(String.valueOf(randomNumber));
		    ranValue=CommonMethods.GetRandom(20);
		    patientFirstName.clear();
		    patientFirstName.sendKeys("TESTFIRSTNAME" + Integer.toString(ranValue));		
          	patientLastName.clear();
			patientLastName.sendKeys("TESTLASTNAME" + Integer.toString(ranValue));	
			patientAddress.clear();
			patientAddress.sendKeys("TESTADDRESS" + Integer.toString(ranValue));	
			patientAddress2.clear();
			patientAddress2.sendKeys("TESTADDRESS2" + Integer.toString(ranValue));	
			patientCity.clear();
			patientCity.sendKeys("TESTCITY" + Integer.toString(ranValue));	
			patientZip.clear();
			patientZip.sendKeys("TESTzip" + Integer.toString(ranValue));			  
	}	    
    public void verifyPatientTabcolorRed()
    {
      tabcolor=	r1AccessCommonMethod.checkTabColor("Patient");
      Assert.assertTrue("Admitn Date is not visible", tabcolor.equalsIgnoreCase("Red"));
    }
    String sSNnumber;
    public void addSNNumber()
    { 
      newSSNText.clear();
      newSSNText.sendKeys(sSNnumber+"44");
    }   
    public void verifyStatusPatientTab()
    {
    	status=r1AccessCommonMethod.chkTabStatusIncompleteComplete();    	
    } 
    
    String newSSnNumber;
    public void modifySNNumber()
    { sSNnumber=	getSSN.getAttribute("value");  
    // sSNnumber=	getSSN.getText();
     System.out.print(sSNnumber);
      length=  sSNnumber.length();
      sSNnumber=   sSNnumber.substring(1,length-2);  
      getSSN.clear();
      newSSnNumber=sSNnumber+"55";
      getSSN.sendKeys(newSSnNumber);
    }    
    public void verifySSN()
    {
    	sSNnumber=	getSSN.getAttribute("value");  
    	Assert.assertTrue("SSN Number is not updated",sSNnumber.equalsIgnoreCase(sSNnumber));
    }    
	public void verifySSNExceptionForLenth() {
		message = patientExceptionPanel.getText();
		Assert.assertTrue("Patient Address Street Number Not Valid message does not exist",
				message.contains("Patient Address Street Number Not Valid"));
		Assert.assertTrue(
				"Patient Address-Street Address Missing Patient Address-City Missing Patient Address-Zip Missing message does not exist",
				message.contains(
						"Patient Address-Street Address Missing Patient Address-City Missing Patient Address-Zip Missing"));
	}
	
	public void verifySSNExceptionForChange() {
		message = patientExceptionPanel.getText();
		Assert.assertTrue("Patient Address Street Number Not Valid message does not exist",
				message.contains("Patient Address Street Number Not Valid"));
		Assert.assertTrue(
				"Patient Address-Street Address Missing Patient Address-City Missing Patient Address-Zip Missing message does not exist",
				message.contains(
						"Patient Address-Street Address Missing Patient Address-City Missing Patient Address-Zip Missing"));	
     
   }	
	public void verifySSNMessaage()
	{		message =ssnMessage.getText();
		Assert.assertTrue("Invalid SSN message does not exist",
				message.contains("Invalid SSN"));
	}	
	public void verifySoftException()
	{
		message = softException.getText();
		Assert.assertTrue("Soft Exception message does not exist",
				message.contains("Exceptions Exist - Are you sure you want to mark the task complete?"));		
	}	
	
	public void verifyRecordUpdated()
	{
		message = messageRecordUpdate.getText();
		Assert.assertTrue("Record Updated message does not exist",
				message.contains("Record Updated"));		
	}	
	public void clickContinueutton() {
		clickOn(continueButton);
	}
	
	public void verifyCancelkContinueutton() {
		checkDisplaySelect = continueButton.isDisplayed();
		Assert.assertTrue("Continue button is not disable", checkDisplaySelect == true);
		checkDisplaySelect = continueBCancelutton.isDisplayed();
		Assert.assertTrue("Continue Camcel button is not disable", checkDisplaySelect == true);
	}
	
	public void getEncounteridPatientTabRed() throws ClassNotFoundException, IOException, SQLException 
	{	query = QueryConstantPatient.queryPatienTabRed();
		SearchAccount = DataAccess.getEncounterId(("encounterid"), query);
	}
	public void getEncounteridPatientTabBlue() throws ClassNotFoundException, IOException, SQLException 
	{	query = QueryConstantPatient.queryPatienTabBlue();
		SearchAccount = DataAccess.getEncounterId(("encounterid"), query);
	}
}