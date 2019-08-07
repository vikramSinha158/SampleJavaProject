package r1.pages;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;

public class ServiceAutomationRulePage extends BasePage{
	
	R1AccessCommonMethods commonMethodsR1Access;
	String textRuleName,taskId;
	int count;
	ArrayList<String> getColValue,getColValue1;
	
	
	
	@FindBy(xpath = "//span[text() = 'Zero Touch Residual Configuration']")
	private WebElementFacade zero_touch_residual_configuration_Page;
	
	@FindBy(xpath = "//input[contains(@id,'ServiceAutomationDashboard_btnAdd')]")
	private WebElementFacade addButton;
	
	@FindBy(xpath = "//input[contains(@id,'txtRuleName')]")
	private WebElementFacade txtRuleName;
	
	@FindBy(xpath = "//input[contains(@id,'txtPatientType')]")
	private WebElementFacade txtPatientType;
	
	@FindBy(xpath = "//input[contains(@id,'txtFacilityPatientType')]")
	private WebElementFacade txtFacilityPatientType;
	
	@FindBy(xpath = "//input[contains(@id,'txtRuleAccuracy')]")
	private WebElementFacade txtRuleAccuracy;
	
	@FindBy(xpath = "//textarea[contains(@id,'txtServicesCPTCodes')]")
	private WebElementFacade txtServicesCPTCodes;
	
	@FindBy(xpath = "//label[contains(text(),'Is Enabled')]/preceding-sibling::input")
	private WebElementFacade checkBoxIsEnabled;
	
	@FindBy(xpath = "//label[contains(text(),'Complete Services Task')]/preceding-sibling::input")
	private WebElementFacade checkBoxCompleteServicesTask;
	
	@FindBy(xpath = "//input[contains(@id,'btnSave')]")
	private WebElementFacade btnSave;
	
	public String serviceAutomationtableRow = "//table[contains(@id,'_gvServiceAutomation')]//tr";
	public String serviceAutomationRowHeader= "//table[contains(@id,'_gvServiceAutomation')]//tr[1]/th";
	
	@FindBy(xpath = "//span[text()='Message Publish']/following-sibling::a")
	private WebElementFacade btnMessagePublish;
	
	@FindBy(xpath = "//table//a[contains(text(),'Publish')]")
	private WebElementFacade btnPublish;
	
	@FindBy(xpath = "//input[contains(@id,'publish_facility')]")
	private WebElementFacade txtFacilityCode;
	
	@FindBy(xpath = "//a[contains(text(),'Show All')]")
	private WebElementFacade btnShowAll;
	
	
	/***************************************************************************************************************************************************/
	
	
	 public void serviceAutomationRule_Page(){
			Assert.assertEquals("Zero Touch Residual Configuration", zero_touch_residual_configuration_Page.getText().toString());
		}
	 
	 public void clickAddButton() {
			clickOn(addButton);
		}
	 
	 public void clickSaveButton() {
			clickOn(btnSave);
		}
	 
	 public void clickMessagePublishButton() {
			clickOn(btnMessagePublish);
		}
	 
	 public void clickPublishButton() {
			clickOn(btnPublish);
		}
	 
	 public void clickShowAllButton() {
		 //boolean clickShowAll = btnShowAll.isDisplayed();
		 if(btnShowAll.isDisplayed()){
		 clickOn(btnShowAll);
		}
	 }
	 
	 public void addServiceAutomationRule(String ruleName, String patientType, String facilityPatientType, String ruleAccuracy) {
			typeInto(txtRuleName, ruleName);
			typeInto(txtPatientType, patientType);
			typeInto(txtFacilityPatientType, facilityPatientType);
			typeInto(txtRuleAccuracy, ruleAccuracy);
			textRuleName= ruleName;
	    }
	 
	 public void enterCPTCode(String cptCode) {
			typeInto(txtServicesCPTCodes,cptCode);
		}
	 
	 public void enterFacilityCode(String facilityCode) {
			typeInto(txtFacilityCode,facilityCode);
		}
	 
	 public void selectIsEnabledCheckBox(){
			boolean checkIsEnabled = checkBoxIsEnabled.isSelected();
			if (!checkIsEnabled)
				clickOn(checkBoxIsEnabled);
	     }
	 
	 public void selectCompleteServicesTaskCheckBox(){
			boolean checkCompleteServicesTask = checkBoxCompleteServicesTask.isSelected();
			if (!checkCompleteServicesTask)
				clickOn(checkBoxCompleteServicesTask);
	     }
	 
	@SuppressWarnings("unchecked")
	public void verifyServiceAutomationRuleAdded() {
		getColValue= commonMethodsR1Access.getTableColValue(serviceAutomationtableRow, serviceAutomationRowHeader, "Rule Name") ;
			Assert.assertTrue("Service Automation Rule does not exist", getColValue.contains(textRuleName));
			for (int i = 1; i <= getColValue.size(); i++) {
				if(getColValue.get(i).equals(textRuleName))
			    {
				  getColValue1 = commonMethodsR1Access.getTableColValue(serviceAutomationtableRow, serviceAutomationRowHeader, "ID") ;
				  taskId= (String) getColValue1.get(i);
				  break;
			
				}
				
			}
				
		}
	
	
	

}
