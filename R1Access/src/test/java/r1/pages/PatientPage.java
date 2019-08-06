package r1.pages;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.commons.utilities.CommonMethods;
import r1.commons.utilities.CommonMethods.common;
import r1.serenity.steps.NotesSteps;
import r1.serenity.steps.PatientSteps;


public class PatientPage extends BasePage {
	
	Alert alert;
	CommonMethods commonMethod;
	String patientupdateFirstName, patientupdateLastName,gurantorUpateFirstName,gurantorUpdateLastName;
	static String SearchAccount;
	
	R1AccessCommonMethods r1AccessCommonMethod;
	
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
	
	////*[@id="Table2"]/tbody/tr[7]//label	

	@FindBy(xpath = "//*[@id='Table2']//label")
	private WebElementFacade updateRecord;	
	
	@FindBy(xpath = "//input[contains(@id,'_chkAllowUpdate')]")
	private WebElementFacade checktUpdate;
	
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
	
	////*[@id="dnn_ctr1501_WorklistPanel_tdBottom"]/table/tbody/tr[5]/td/table/tbody/tr[3]
	
	@FindBy(xpath = "//*[@id='dnn_ctr1501_WorklistPanel_tdBottom']/table/tbody/tr[5]/td/table/tbody/tr[3]/td")
	private WebElementFacade criticalErrorMessage;	

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
	public void clearkPatientAddress()
	{
		patientAddress.clear();
	}
	public void clearPatientAddress2()
	{
		patientAddress2.clear();
	}
	public void clearPatientCity()
	{
		patientCity.clear();
	}
	
	public void clearPatientZip()
	{
		patientZip.clear();
	}	
	
	public void updateGurantorFirstName()
	{	
		int randomNumber=CommonMethods.GetRandom(100);
		gurantorUpateFirstName="TESTFIRSTNAME"+ Integer.toString(randomNumber);
		gurantorFirstName.clear();
		gurantorFirstName.sendKeys(gurantorUpateFirstName);
	}
	public void updateGurantorLastName()
	{		
		int randomNumber=CommonMethods.GetRandom(100);
		gurantorUpdateLastName="TESTLASTNAME"+ Integer.toString(randomNumber);
		gurantorLastName.clear();
		gurantorLastName.sendKeys(gurantorUpdateLastName);
	}
	String updatedGurantorFirstName,updatedGurantorLastName;
	public void verifyGurantorUpdatedFirstNameLastName()
	{
		updatedGurantorFirstName=gurantorFirstName.getAttribute("value").toUpperCase().trim();
	 	System.out.println(updatedGurantorFirstName);
		System.out.println(gurantorUpateFirstName);
	 	updatedGurantorLastName=gurantorLastName.getAttribute("value").trim().toUpperCase().trim();
		System.out.println(updatedGurantorLastName);
		System.out.println(gurantorUpdateLastName);
		//System.out.println("7875847584");
		Assert.assertTrue("First Name is not updateed", updatedGurantorFirstName.equalsIgnoreCase(gurantorUpateFirstName));
		Assert.assertTrue("Last Name is not updateed", updatedGurantorLastName.equalsIgnoreCase(gurantorUpdateLastName));
     }
	
	
	public void setPatientFirstName(String FirstName)
	{
		typeInto(patientFirstName,FirstName);		
	}
	public void setPatientLastName(String lastName)
	{
		typeInto(patientLastName,lastName);
	}	
	

	public void verifyUpdatedFirstNameLastName(String FirstName, String LastName)
	{
		Assert.assertTrue("First Name is not updateed", patientFirstName.getText().trim()==FirstName);
		Assert.assertTrue("Last Name is not updateed", patientLastName.getText().trim()==LastName);
     }
	
	public void getPatientGuranorAccount () throws ClassNotFoundException, IOException, SQLException {
		SearchAccount =	PatientSteps.getPatientGuranorAccount("encounterid");
	//	System.out.println(SearchAccount);
		//getAccount="0181222349169";
		System.out.println(SearchAccount);
	}
	
	public void getPatientCriticalAccount () throws ClassNotFoundException, IOException, SQLException {
		SearchAccount =	PatientSteps.getPatientCriticalAccounts("encounterid");
	//	System.out.println(SearchAccount);
		//getAccount="0181222349169";
		System.out.println(SearchAccount);
	}
	
	public void getPatientNonCriticalAccount () throws ClassNotFoundException, IOException, SQLException {
		SearchAccount =	PatientSteps.getPatientNotZeroChargelAccounts("encounterid");
	//	System.out.println(SearchAccount);
		//getAccount="0181222349169";
		System.out.println(SearchAccount);
	}
	public void getPatientAccountGetChargeZero () throws ClassNotFoundException, IOException, SQLException {
		SearchAccount =	PatientSteps.getPatientZeroChargelAccounts("encounterId");
		//	System.out.println(SearchAccount);
			//getAccount="0181222349169";
			System.out.println(SearchAccount);
	}
	
	public void getPatientAccountGetChargeNotZero () throws ClassNotFoundException, IOException, SQLException {
		SearchAccount =	PatientSteps.getPatientGuranorAccount("encounterid");
	//	System.out.println(SearchAccount);
		//getAccount="0000106295364";
		System.out.println(SearchAccount);
	}
	public void getPatientAccountGetChargeGreaterZero () throws ClassNotFoundException, IOException, SQLException {
		SearchAccount =	PatientSteps.getPatientGreaterZeroChargeAccounts("encounterid");
	//	System.out.println(SearchAccount);
		//getAccount="0000106295364";
		System.out.println(SearchAccount);
	}
	public void getPatientCritical () throws ClassNotFoundException, IOException, SQLException {
		SearchAccount =	PatientSteps.getPatientGuranorAccount("encounterid");
	//	System.out.println(SearchAccount);
		//getAccount="0127142595363";
		System.out.println(SearchAccount);
	}
	public void clickOnSearch()
	{
		r1AccessCommonMethod.clickUpperHeaderLink("Search");		
	}
	
	public void entersSearchText()
	{
	  r1AccessCommonMethod.enterVisitNumber(SearchAccount);
 	System.out.println(SearchAccount);
			
	}
	public void clickOnSearchButton()
	{
		r1AccessCommonMethod.clickOnSearchButton();		
	}
	
	public void clickPatientTab()
	{
		r1AccessCommonMethod.clickR1AccesModulesTab("Patient");
	}
	
	public void verifyGurantorConfirmMessage()
	{
	 String message=gurantorPopUP.getText();
	  System.out.println(message);
	  Assert.assertTrue("Are you sure? message does not exist", message.contains("Are you sure?"));
	  Assert.assertTrue("Yes No button does not exist", message.contains("YesNo"));
	 
	}
	
	public void ClearAddressCityZip()
	{
		patientAddress.clear();
		patientCity.clear();
		patientZip.clear();		
	}
	
	public void VerifyCheckBox()
	{
	 boolean checkValue =checktUpdate.isSelected();
	 System.out.println(checkValue);
	 Assert.assertTrue("Checkbox is not disable", checkValue==false);
     String message=  updateRecord.getText().trim().trim();
     System.out.println(message);
	 Assert.assertTrue("Update Patient Record? does not exist", message.equalsIgnoreCase("Update Patient Record?"));
		
	}
	
	public void verifyPatientExceptionMesssage()
	{
	String messag=	patientExceptionPanel.getText();
	 System.out.println(messag);
	 Assert.assertTrue("Patient Address Street Number Not Valid message does not exist", messag.contains("Patient Address Street Number Not Valid"));
	 Assert.assertTrue("Patient Address-Street Address Missing Patient Address-City Missing Patient Address-Zip Missing message does not exist", messag.contains("Patient Address-Street Address Missing Patient Address-City Missing Patient Address-Zip Missing"));	
	}
	
	public void  verifyCriticalExceptionMesssage()
	{
		String messag=criticalErrorMessage.getText();
		 System.out.println(messag);
		 Assert.assertTrue("Critical Exceptions Exist - Completion not allowed message does not exist", messag.contains("Critical Exceptions Exist - Completion not allowed."));
		
	}
	
 public void verifyPatientTabcolor()
 { 
   String color= r1AccessCommonMethod.checkTabColor("Patient");
   System.out.println(color);
   Assert.assertTrue("Patient tab color is not red", color.equalsIgnoreCase("Red"));
 }
 public void verifyIncompleteStatus()
 {
	 String status= r1AccessCommonMethod.chkTabStatusIncompleteComplete();
	 System.out.println(status);
	 Assert.assertTrue("Patient tab status is not Incomplete", status.equalsIgnoreCase("Incomplete"));
 }
 
 public void verifyCompleteStatus()
 {
	 String status= r1AccessCommonMethod.chkTabStatusIncompleteComplete();
	 System.out.println(status);
	 Assert.assertTrue("Patient tab status is notomplete", status.equalsIgnoreCase("Complete"));
 }
 public void verifyPatientDetails()
 { 
   boolean addressExist= patientAddress.isDisplayed();
   System.out.println(addressExist);
   Assert.assertTrue("Checkbox is not disable", addressExist==true);
   boolean cityExist= patientCity.isDisplayed();
   Assert.assertTrue("Checkbox is not disable", cityExist==true);
   System.out.println(cityExist);
 }
 

	public void VerifyReturnMailCheckBox()
	{
	 boolean checkValue =checkReturnedMail.isSelected();
	 System.out.println(checkValue);
	 Assert.assertTrue("Checkbox is not disable", checkValue==false);
	}
	
	public void VerifyAdmitCheckBox()
	{
	 boolean checkValue =checktUpdate.isSelected();
	 System.out.println(checkValue);
	 Assert.assertTrue("Checkbox is not disable", checkValue==false);
	 
	 
	 boolean checkValueq =checkReturnedMail.isSelected();
	 System.out.println(checkValue);
	 Assert.assertTrue("Checkbox is not disable", checkValue==false);
   		
	}
	
	public void VerifyCancelCheckBox()
	{
	 boolean checkValue =checkCancel.isSelected();
	 System.out.println(checkValue);
	 Assert.assertTrue("Checkbox is not disable", checkValue==false);
   		
	}
	
	public void getPatientAdmitDischargeDateStatus () throws ClassNotFoundException, IOException, SQLException {
		boolean checkAdmitDate =checkAdmitted.isSelected();
		 System.out.println(checkAdmitDate);	
		 boolean checkDischargetDate =checkDischarge.isSelected();
		 System.out.println(checkDischargetDate);		 
		
		String admintdate=PatientSteps.getPatientAdmitDischargeDateStatus(SearchAccount,"isadmitted");
		
		if (admintdate=="1")
		{
			 Assert.assertTrue("Checkbox is not disable", checkAdmitDate==true);
		}		
		else
		{
			 Assert.assertTrue("Checkbox is not disable", checkAdmitDate==false);
		}
		
		String dischargedate=PatientSteps.getPatientAdmitDischargeDateStatus(SearchAccount,"isdischarged");
		
		if (dischargedate=="1")
		{
			 Assert.assertTrue("Checkbox is not disable", checkDischargetDate==true);
		}
		
		else
		{
			 Assert.assertTrue("Checkbox is not disable", checkDischargetDate==false);
		}		
	}
	
	public void verifyPatientCheckBox()
	{
		boolean checkAdmitDate =checkAdmitted.isDisplayed();
		 Assert.assertTrue("Admit Checkbox is not disable", checkAdmitDate==true);
		 boolean checkDischargetDate =checkDischarge.isDisplayed();
		 Assert.assertTrue("Dishcharge Checkbox is not disable", checkDischargetDate==true);
		 boolean checkReturn= checkReturnedMail.isDisplayed();
		 Assert.assertTrue("Return Checkbox is not disable", checkReturn==true);
		 boolean checkcancel =checkCancel.isDisplayed();
		 Assert.assertTrue("Camce Checkbox is not disable", checkcancel==true);
		// boolean checkCancel= checkCancel..
		
	}
	
	public void VerifyGurantorTab()
	{
		boolean checkGurantor =gurantorLastName.isDisplayed();
		 System.out.println(checkGurantor);
		 Assert.assertTrue("Gurantor Panel is visible", checkGurantor==false);	
		
	}
	
	public void AlertMessage()
	{
		getAlert().accept();
		
		
	}

}