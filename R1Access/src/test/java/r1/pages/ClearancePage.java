package r1.pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.utilities.AssertValues;

public class ClearancePage extends BasePage {
	
	WebDriver driver;
	String encounterId;
	
	//------------Clearance Module-------
	

	@FindBy(xpath = "//a[contains(@id,'LocationChooser_hypLoc')]")
	private WebElementFacade facilityList;
	
	@FindBy(xpath = "//select[contains(@id,'LocationChooser_ddlLocation')]")
	private WebElementFacade facility;
	
	@FindBy(xpath = "//input[contains(@id,'txtCity')]")
	private WebElementFacade textBoxCity ;
	
	@FindBy(xpath = "//input[contains(@id,'_txtFirstName')]")
	private WebElementFacade textBoxFirstName;
	
	@FindBy(xpath = "//input[contains(@id,'txtAddress1')]")
	private WebElementFacade txtAddress1 ;
	
	@FindBy(xpath = "//input[contains(@id,'txtAddress2')]")
	private WebElementFacade txtAddress2;
	
	@FindBy(xpath = "//input[contains(@id,'txtState')]")
	private WebElementFacade  textBoxState;
	
	@FindBy(xpath = "//input[contains(@id,'txtZip')]")
	private WebElementFacade txtBoxZip;
	
	@FindBy(xpath = "//a[contains(text(),'Update')]")
	private WebElementFacade txtBoxUpdate ;
	
	@FindBy(xpath = "//a[contains(@id,'btnSkipTrace')]")
	private WebElementFacade txtBoxSkip;
	
	@FindBy(xpath = "//input[contains(@id,'txtSSN')]")
	private WebElementFacade txtBoxSSN ;
	
	@FindBy(xpath = "//input[contains(@id,'txtLastName')]")
	private WebElementFacade txtLastname ;
	
	@FindBy(xpath = "//input[contains(@id,'txtPhone')]")
	private WebElementFacade txtPhone ;
	
	@FindBy(xpath = "//input[contains(@id,'txtDOB')]")
	private WebElementFacade txtDOB;
	
	@FindBy(xpath = "//select[contains(@id,'ddlPatientType')]")
	private WebElementFacade  txtPatientType;
	
	@FindBy(xpath = "//input[contains(@id,'txtZip')]")
	private WebElementFacade txtStateZip;
	
	@FindBy(xpath = "//input[contains(@id,'txtState')]")
	private WebElementFacade  txtStateText;
	
	@FindBy(xpath = "//select[contains(@id,'ddlGender')]")
	private WebElementFacade txtGender;
	
	@FindBy(xpath = "//input[contains(@id,'txtAdmitDate')]")
	private WebElementFacade  txtAdmitDate;
	
	@FindBy(xpath = "//a[contains(@id,'btnUpdate')]")
	private WebElementFacade txtUpdateButton;
	
	@FindBy(xpath = "//a[@class='TabLI'][text()='Clearance']")
	private WebElementFacade tabClearance;
	
	@FindBy(xpath = "//input[contains(@name,'chkStatus')]")
	private WebElementFacade checkboxClearance ;
	
	@FindBy(xpath = "//input[contains(@name,'chkMsp')]")
	private WebElementFacade checkboxMsp;
	
	@FindBy(xpath = "//a[contains(@id,'_dlActions_btnAction')][text()='Complete']")
	private WebElementFacade txtComplete;
	
	@FindBy(xpath = "//a[contains(@id,'btnUpdate')]")
	private WebElementFacade txt;
	
	@FindBy(xpath = "//A[contains(@class,'footer_nav')][contains(@href,'Patient-Access')]")
	private WebElementFacade hrefPatientAccess;
	
	@FindBy(xpath = "//A[contains(@href,'Patient-Access/Pre-Registration')]")
	private WebElementFacade preRegistration;
	
	@FindBy(xpath = "//*[contains(text(),'Incomplete Task')]//..//*[contains(@imgtype,'exp')]")
	private WebElementFacade expBtnIncompleteTask;
	
	@FindBy(xpath = "//span[text()='Clearance']")
	private WebElementFacade menuClearanceIncompleteTask;
	
	@FindBy(xpath = "//span[text()='Clearance']")
	private WebElementFacade labelClearance;
	
	@FindBy(xpath = "//span[text()='MSP']")
	private WebElementFacade labelMSP;
	
	@FindBy(xpath = "//input[contains(@id,'ClearancMSP')]")
	private WebElementFacade chkBoxMSP;
	
	@FindBy(xpath = "//input[contains(@id,'chkStatus')]")
	private WebElementFacade chkBoxClearance;
	
	@FindBy(xpath = "//table[@class='PanelDetail actionLog']/tbody//tr[@class='PanelDetail']/td")
	private WebElementFacade logTableRow;
	
	@FindBy(xpath = "//table[@class='PanelDetail actionLog']/tbody//tr[@class='PanelDetail']/td")
	private List<WebElementFacade> logItem;
	
	@FindBy(xpath = "//span[contains(@id,'lblStatus')]")
	private WebElementFacade statusLabel;
	
	@FindBy(xpath = "//span[contains(@id,'lblStatus')]")
	private WebElementFacade accountNumber;
	
	@FindBy(xpath = "//tr[@valign='middle']/td[2]/a")
	private List<WebElementFacade> acoountNumbersInWorkList;
	
	@FindBy(xpath = "//span[@class='rtbText'][text()='orklist']")
	private WebElementFacade workListMenu;
	
	@FindBy(xpath = "//span[contains(@id,'lblEncounterNum')]")
	private WebElementFacade accountId;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void clickFacilityList() throws InterruptedException {
		clickOn(facilityList);
	}
	
	public void selectFacility(String text) {
		selectFromDropdown(facility,text);
	}
	
	public void clickPatientAccess() {
		clickOn(hrefPatientAccess);
	}
	
	public void clickPreRegistration() {
		clickOn(preRegistration);
	}
		
	public void clickIncompleteTaskExpButton(){
		clickOn(expBtnIncompleteTask);
	}
	
	public void clickClearanceIncompleteTask(){
		clickOn(menuClearanceIncompleteTask);
	
	}
	public void verifyClearanceTabPage(String label){
		
		if(labelClearance.isDisplayed()){
			System.out.println("Clearance checkbox verified");
			
		 } else {
			 System.out.println("Clearance checkbox couldnot verified");
		 }
	
	}
	public void clickClearanceCheckBox(){
		clickOn(chkBoxClearance);
	}
	
	public void clickOnMSPCheckBox(){
		clickOn(chkBoxMSP);
	}
	
	public void verifyCheckboxChecked(){
		List<String> listAccount = new ArrayList<String>();
		for(int i=0;i< logItem.size();i++) {
			listAccount.add(logItem.get(i).getText());
			
			if(i==6) {
				break;
			}
		}
		Assert.assertTrue("Clearance logs is not matching",listAccount.contains("Completed"));
		
	}
	
	public void verifyStatus(){
		Assert.assertEquals("Tab status is not complete", statusLabel.getText().contains("Completed") , true);
		
	}
	
	public void verifyClearanceCheckBox(){
		Assert.assertEquals("Clearance checkBox is not checked", chkBoxClearance.getAttribute("checked") , "true");
		
	}
	
	public void verifyMspCheckBox(){
		
		String checkedStatus = chkBoxMSP.getAttribute("checked");
		System.out.println("Checked status value :- " + checkedStatus);
		Assert.assertEquals("Msp checkBox is not checked", chkBoxMSP.getAttribute("checked") , "true");
		
	}
	
	public void verifyMspCheckBo(){
		Assert.assertEquals("Msp checkBox is not checked", chkBoxMSP.getAttribute("checked") , "true");
		
	}
	
	public void verifyPresenceOfAccountInWorkList(String accountNumber){
		String accountInWorklist=null;
		for(int i=0;i< acoountNumbersInWorkList.size();i++) {
			if(acoountNumbersInWorkList.get(i).getText().trim().equalsIgnoreCase((accountNumber).trim())) {
				accountInWorklist=acoountNumbersInWorkList.get(i).getText();
				System.out.println("accountNumber verified in the worklist");
			}
		}
		Assert.assertEquals("Account is not present in the work list", accountInWorklist , accountNumber);
	}
	
	public void clickGlobalWorklist(){
		clickOn(workListMenu);
		
	}
	
	public String getAccountNumber(){
		encounterId = accountId.getText();
		return encounterId;
	}
	
	
	public void clickOnRedo(){
	//	clickOn(redo);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
