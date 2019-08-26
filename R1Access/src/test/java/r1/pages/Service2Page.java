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
import r1.commons.databaseconnection.QueryConstantService;

import java.util.Random;

public class Service2Page extends BasePage {
	Random random = new Random();
	R1AccessCommonMethods r1AccessCommonMethod;
	boolean flag = false;
	int i, settingValue;
	int rowIndex;
	String query, value;

	@FindBy(xpath = "//input[contains(@id,'txtSearch')]")

	private WebElementFacade searchTextBox;

	@FindBy(xpath = "//a[contains(@id,'btnSearch')]")

	private WebElementFacade searchButton;

	@FindBy(xpath = "//table[contains(@id,'_grdHCPCSearchResults')]")

	private WebElementFacade serviceSearchResults;

	@FindBy(xpath = "//table[contains(@id,'_grdHCPCSearchResults')]")

	private List<WebElementFacade> clickServiceSearchResults;

	@FindBy(xpath = "//span[contains(@id,'RdPricingMode')]//input")

	private List<WebElementFacade> singleMultipleRadioBtn;

	@FindBy(xpath = "//table[contains(@id,'_grdHCPCSearchResults')]//tr//a")

	private List<WebElementFacade> clickOnServiceSearchResults;

	@FindBy(xpath = "//table[contains(@id,'_grdICD9SearchResults')]//tr//a")

	private List<WebElementFacade> clickOnICDCodes;

	@FindBy(xpath = "//table[contains(@id,'grdHCPCSelected')]//tr[@class='PanelDetail']//a//img[@src='/images/delete.gif']")

	private List<WebElementFacade> deleteServices;

	@FindBy(xpath = "//table[contains(@id,'_grdHCPCSelected')]//tr[@class='PanelDetail']//td")

	private List<WebElementFacade> verifyServicesGetAdded;

	@FindBy(xpath = " //a[contains(@id,'lnkViewMode')]")

	private WebElementFacade clickOnAdmitting;

	@FindBy(xpath = " //a[contains(@id,'accTaskAction_btnStatusOverrideUpdate')]")

	private WebElementFacade clickOnContinueButton;

	@FindBy(xpath = "//table[contains(@id,'grdICD9Selected')]//tr[@class='PanelTitle tableHeader']//td")

	private List<WebElementFacade> fetchICDCodesIndexFromTable;

	@FindBy(xpath = "//table[contains(@id,'grdICD9Selected')]//tr[@class='PanelDetail']")

	private List<WebElementFacade> fetchICDCodesIndexValueFromTable;

	@FindBy(xpath = "//label[contains(text(), 'Single')]//preceding-sibling::input")

	private WebElementFacade singleRadioButton;

	@FindBy(xpath = "//label[contains(text(), 'Multiple')]//preceding-sibling::input")

	private WebElementFacade multipleRadioButton;

	@FindBy(xpath = "//table[contains(@id, 'tblICD9SearchResults')]//tr//td[3]")

	private List<WebElementFacade> icdninediagnosisgrid;

	@FindBy(xpath = "//input[contains(@id,'ChkShowICD9Codes')]")

	private WebElementFacade showICDCheckBox;

	@FindBy(xpath = "//table[contains(@id,'grdICD9Selected')]//tr[@class='PanelDetail']//td[1]")

	private WebElementFacade clickICDCodesUpArrow;

	@FindBy(xpath = "//table[contains(@id,'grdICD9Selected')]//tr")

	private List<WebElementFacade> clickICDCodesRowValue;

	@FindBy(xpath = "//table[contains(@id,'grdICD9Selected')]//img[contains(@src,'/images/dn.gif')]")

	private WebElementFacade clickICDCodesIndexValueFromTable;
				
	@FindBy(xpath = "//table[@class='PanelTitle']//tr[@class='PanelTitle']")

	private WebElementFacade verifyFinalText;
	
	@FindBy(xpath = "//input[contains(@name,'txtSearch')]")

	private WebElementFacade verifySearchTextBox;
	
	@FindBy(xpath = "//input[contains(@name,'txtSearch')]")

	private WebElementFacade verifySearchButton;
	
	
	/*............ Service Query ..................................*/

	public void verifyServiceandResidualSettings(String facility, String serviceSetting, String residualSetting)
			throws ClassNotFoundException, IOException, SQLException {
		settingValue = Integer.parseInt(retrieveSettingValue(serviceSetting, facility));
		
		if (settingValue != 2) {
			r1AccessCommonMethod.clickFooterR1AccesModulesTab("Settings");
			r1AccessCommonMethod.clickSubSideR1HubModulesMenuLink("IT Tools");
			r1AccessCommonMethod.clickSubSideR1HubModulesMenuLink("FacilitySetting Configuration");
			r1AccessCommonMethod.setFacilitySettingVal(facility, serviceSetting, "2");
		}

		settingValue = Integer.parseInt(retrieveSettingValue(residualSetting,facility));

		if (settingValue != 2) {
			r1AccessCommonMethod.clickFooterR1AccesModulesTab("Settings");
			r1AccessCommonMethod.clickSubSideR1HubModulesMenuLink("IT Tools");
			r1AccessCommonMethod.clickSubSideR1HubModulesMenuLink("FacilitySetting Configuration");
			r1AccessCommonMethod.setFacilitySettingVal(facility, residualSetting, "2");
		}
		
		if (settingValue != 2)
		{
		r1AccessCommonMethod.clickFooterR1AccesModulesTab("Settings");
		r1AccessCommonMethod.clickSubSideR1HubModulesMenuLink("IT Tools");
		r1AccessCommonMethod.clearCache();
		r1AccessCommonMethod.clickFooterR1AccesModulesTab("Patient Access");
		r1AccessCommonMethod.clickSubSideR1HubModulesMenuLink("Pre-Registration");		
		}
	}

	public String retrieveSettingValue(String settingName,String facility) throws ClassNotFoundException, IOException, SQLException {
		query = QueryConstantService.fetchSettingValue(settingName);
		value = DataAccess.getColumValue(("SettingValue"), query, facility);
		return value;
	}
	
	public String retrieveExpiredHCPCValue() throws ClassNotFoundException, IOException, SQLException {
		query = QueryConstantService.fetchHCPCCodeValue();
		value = DataAccess.getColumValue(("hcpc_code_id"), query);
		return value;
	}
	

	/*............ Service Query ..................................*/

	
	public void verifyUpDownArrowKeyIsWorking() {
		for (int i = 1; i <= verifyServicesGetAdded.size(); i++) {
			String before = clickICDCodesRowValue.get(i).getText().toString();
			clickOn(clickICDCodesIndexValueFromTable);
			String after = clickICDCodesRowValue.get(i + 1).getText().toString();
			Assert.assertTrue("Up Down Arrow Is Not Working", !after.equals(before));
			System.out.print(after);
		}
	}

	public void clickOnAdmiting() {
		if (clickOnAdmitting.getText().equalsIgnoreCase("Admitting")) {
			clickOn(clickOnAdmitting);
		}
	}

	public void enterCodes(String text) {
		typeInto(searchTextBox, text);
	}

	public void clickOnSearch() {
		clickOn(searchButton);
	}

	public void verifyServiceSearchResults() {
		Assert.assertTrue("service search results grid is not coming", serviceSearchResults.isDisplayed());
	}

	public void verifySingleMultipleRadioBtn() {
		Assert.assertTrue("Single Multiple Radio Button Not Coming ", singleMultipleRadioBtn.size() == 2);
		Assert.assertTrue("Single radio button label does not exist", singleRadioButton.isDisplayed());
		Assert.assertTrue("Multiple radio button label does not exist", multipleRadioButton.isDisplayed());
	}

	public void verifySingleMultipleRadioBtnNotExists() {
		Assert.assertTrue("Single Multiple Radio Not Coming ", singleMultipleRadioBtn.size() == 0);
	}

	public void addServicesSearchResults() {
		i = random.nextInt(clickOnServiceSearchResults.size());
		value = clickOnServiceSearchResults.get(i).getText().toString();
		withAction().moveToElement(clickOnServiceSearchResults.get(i)).click().build().perform();
	}

	public void deleteServices() {
		for (int i = deleteServices.size(); i > 0; i--) {
			withAction().moveToElement(deleteServices.get(0)).click().build().perform();
			r1AccessCommonMethod.clickOnCheckOut();
		}
	}

	public void verifyServiceGridIsNotDisplayed() {
		Assert.assertFalse("Service Grid Is Appearing", !serviceSearchResults.isDisplayed());
	}

	public void verifyServiceShouldBeAdded() {
		for (int i = 0; i < verifyServicesGetAdded.size(); i++) {
			if (verifyServicesGetAdded.get(i).getText().toString().contains(value)) {
				flag = true;
			}
		}
		Assert.assertTrue("Service don't get added", flag);
	}

	public void addICDDiagnosisCodes() {
		i = random.nextInt(clickOnICDCodes.size());
		// abc=clickOnServiceSearchResults.get(i).getText().toString();
		withAction().moveToElement(clickOnICDCodes.get(i)).click().build().perform();
	}

	public void verifyTabColorAndStatus(String moduleTab, String tabStatus, String color) {
		Assert.assertTrue(r1AccessCommonMethod.chkTabStatusIncompleteComplete().equalsIgnoreCase("tabStatus"));
		Assert.assertTrue(r1AccessCommonMethod.checkTabColor(moduleTab).equalsIgnoreCase(color));
	}

	public void clickOnExceptionContinueButton(String tab) {

		if (clickOnContinueButton.isDisplayed()) {
			if (clickOnContinueButton.getText().equalsIgnoreCase(tab)) {
				clickOn(clickOnContinueButton);
			}
		}
	}

	public void verifyModeIsSelectedInContextToSettings(String Text) {
		if (Text.equalsIgnoreCase("Single")) {
			Assert.assertTrue("Single radio button does not exist", singleRadioButton.isSelected());
		} else {
			Assert.assertTrue("Multiple radio button does not exist", multipleRadioButton.isSelected());
		}
	}

	public void verifyICDCodesCheckboxExist() {
		Assert.assertTrue("ICD9 checkbox code does not exist", showICDCheckBox.isDisplayed());
	}

	public void clickOnICD9Checkbox() {
		clickOn(showICDCheckBox);
	}

	public void verifyICD9CodesAreComingOrNot(String Text) {
		if (Text.equalsIgnoreCase("ICD10")) {
			for (int i = 0; i < icdninediagnosisgrid.size(); i++) {
				if (icdninediagnosisgrid.get(i).getText().toString().contains("ICD10")) {
					flag = true;
				}
			}
			Assert.assertTrue("ICD10  code does not exist", flag);
		} else {
			for (int i = 0; i < icdninediagnosisgrid.size(); i++) {
				if (icdninediagnosisgrid.get(i).getText().toString().contains("ICD9")) {
					flag = true;
					break;
				}
			}
			Assert.assertTrue("ICD9  code does not exist", flag);
		}
	}
}
