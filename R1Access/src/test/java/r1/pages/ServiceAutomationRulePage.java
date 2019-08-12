package r1.pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import au.com.bytecode.opencsv.CSVReader;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.commons.utilities.CommonMethods;

public class ServiceAutomationRulePage extends BasePage {

	R1AccessCommonMethods commonMethodsR1Access;
	String textRuleName, taskId, facilityName;
	int count;
	ArrayList<String> getColValue, getIsEnableColValue;

	@FindBy(xpath = "//span[text() = 'Zero Touch Residual Configuration']")
	private WebElementFacade zero_touch_residual_configuration_Page;

	@FindBy(xpath = "//input[contains(@id,'ServiceAutomationDashboard_btnAdd')]")
	private WebElementFacade addButton;

	@FindBy(xpath = "//input[contains(@id,'btnCancle')]")
	private WebElementFacade btnCancle;

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
	public String serviceAutomationRowHeader = "//table[contains(@id,'_gvServiceAutomation')]//tr[1]/th";

	@FindBy(xpath = "//span[text()='Message Publish']/following-sibling::a")
	private WebElementFacade btnMessagePublish;

	@FindBy(xpath = "//table//a[contains(text(),'Publish')]")
	private WebElementFacade btnPublish;

	@FindBy(xpath = "//input[contains(@id,'publish_facility')]")
	private WebElementFacade txtFacilityCode;

	@FindBy(xpath = "//input[contains(@id,'publish_taskid')]")
	private WebElementFacade txtTaskid;

	@FindBy(xpath = "//a[contains(text(),'Show All')]")
	private List<WebElementFacade> btnShowAll;

	@FindBy(xpath = "//input[contains(@id,'dshServiceAutomation_imgIcon')]")
	private WebElementFacade ImgIcon;

	@FindBy(xpath = "//table[contains(@id,'_gvServiceAutomation')]//td[1]")
	private WebElementFacade selectId;

	@FindBy(xpath = "//input[contains(@id,'_btnEdit')]")
	private WebElementFacade btnEdit;

	@FindBy(xpath = "//input[contains(@disabled,'disabled')]")
	private WebElementFacade disableRuleAccuracy;

	@FindBy(xpath = "//input[contains(@id,'_btnDeactivate')]")
	private WebElementFacade btnDeactivate;

	@FindBy(xpath = "//input[contains(@id,'_btnActivate')]")
	private WebElementFacade btnActivate;

	@FindBy(xpath = "//input[contains(@id,'_btnDelete')]")
	private WebElementFacade btnDelete;

	@FindBy(xpath = "//span[contains(text(),'Add Service Automation Rule')]")
	private WebElementFacade Add_Service_Automation_Rule_PopUp;

	@FindBy(xpath = "//table[contains(@id,'gvServiceAutomation')]//tr//td[16]")
	private List<WebElementFacade> isEnabledColVal;

	@FindBy(xpath = "//input[contains(@id,'btnExport')]")
	private WebElementFacade btnExport;

	@FindBy(xpath = "//table[contains(@id,'gvServiceAutomation')]//th")
	private List<WebElementFacade> totalHeaderUI;

	public String matchingRuletableRow = "//table[contains(@id,'ctl05_dgDataSourceRuleMatches')]//tr";
	public String matchingRuleRowHeader = "//table[contains(@id,'ctl05_dgDataSourceRuleMatches')]//tr[1]/td";

	/***************************************************************************************************************************************************/

	public void serviceAutomationRule_Page() {
		Assert.assertEquals("Zero Touch Residual Configuration",
				zero_touch_residual_configuration_Page.getText().toString());
	}

	public void addServiceAutomationRulePopUp() {
		Assert.assertEquals("Add Service Automation Rule", Add_Service_Automation_Rule_PopUp.getText().toString());
	}

	public void clickAddButton() {
		clickOn(addButton);
	}

	public void clickSaveButton() {
		clickOn(btnSave);
	}

	public void clickCancelButton() {
		clickOn(btnCancle);
	}

	public void clickMessagePublishButton() {
		clickOn(btnMessagePublish);
	}

	public void clickPublishButton() {
		clickOn(btnPublish);
	}

	public void verifyAccuracyUnabled() {
		clickOn(selectId);
		clickOn(btnEdit);
	}

	public void verifyRuleDeactivate() {
		clickOn(btnDeactivate);

	}

	public void verifyRuleActivate() {
		clickOn(btnActivate);

	}

	public void verifyDeleteButton() {
		clickOn(btnDelete);

	}

	public void verifyRuleAccuracy(String accuracyValue) {
		Assert.assertTrue("Accuracy textbox is empty", txtRuleAccuracy.getAttribute("value").contains(accuracyValue));
	}

	public void addServiceAutomationRulePopUpDisappear() {
		Assert.assertFalse("Add Service Automation Rule popup is appear",
				Add_Service_Automation_Rule_PopUp.isVisible());
	}

	public void verifyRuleAccuracyDisable() {
		Assert.assertNotNull(disableRuleAccuracy);
	}

	public void clickShowAllButton() {
		count = btnShowAll.size();
		if (count > 0) {
			clickOn(btnShowAll.get(0));
		}
	}

	public void clickServiceAutomationRule() {
		withAction().moveToElement(ImgIcon).click().build().perform();
	}

	public void verifyGrdDRGSelected() {
		count = btnShowAll.size();
		Assert.assertTrue("Service selected grid does not exist", count > 1);
	}

	public void addServiceAutomationRule(String ruleName, String patientType, String facilityPatientType) {
		typeInto(txtRuleName, ruleName);
		typeInto(txtPatientType, patientType);
		typeInto(txtFacilityPatientType, facilityPatientType);
		textRuleName = ruleName;
	}

	public void enterCPTCode(String cptCode) {
		typeInto(txtServicesCPTCodes, cptCode);
	}

	public void enterFacilityCode() throws IOException {
		facilityName = CommonMethods.LoadProperties("facility");
		typeInto(txtFacilityCode, facilityName);

	}

	public void selectIsEnabledCheckBox() {
		boolean checkIsEnabled = checkBoxIsEnabled.isSelected();
		if (!checkIsEnabled)
			clickOn(checkBoxIsEnabled);
	}

	public void selectCompleteServicesTaskCheckBox() {
		boolean checkCompleteServicesTask = checkBoxCompleteServicesTask.isSelected();
		if (!checkCompleteServicesTask)
			clickOn(checkBoxCompleteServicesTask);
	}

	@SuppressWarnings("unchecked")
	public void verifyServiceAutomationRuleAdded() {
		getColValue = commonMethodsR1Access.getTableColValue(serviceAutomationtableRow, serviceAutomationRowHeader,
				"Rule Name");
		Assert.assertTrue("Service Automation Rule does not exist", getColValue.contains(textRuleName));
		for (int i = 1; i < getColValue.size(); i++) {
			if (getColValue.get(i).equals(textRuleName)) {
				getIsEnableColValue = commonMethodsR1Access.getTableColValue(serviceAutomationtableRow,
						serviceAutomationRowHeader, "ID");
				taskId = (String) getIsEnableColValue.get(i);
				break;

			}

		}

	}

	@SuppressWarnings("unchecked")
	public void verifyServiceAutomationRuleEdit() {
		getColValue = commonMethodsR1Access.getTableColValue(serviceAutomationtableRow, serviceAutomationRowHeader,
				"Rule Name");
		Assert.assertTrue("Service Automation Rule does not exist", getColValue.contains(textRuleName));
		for (int i = 1; i <= getColValue.size(); i++) {
			if (getColValue.get(i).equals(textRuleName)) {
				getIsEnableColValue = commonMethodsR1Access.getTableColValue(serviceAutomationtableRow,
						serviceAutomationRowHeader, "ID");
				taskId = (String) getIsEnableColValue.get(i);
				break;

			}

		}

	}

	@SuppressWarnings("unchecked")
	public void selectIsEnabledColumnValueTrue() {
		getColValue = commonMethodsR1Access.getTableColValue(serviceAutomationtableRow, serviceAutomationRowHeader,
				"ID");
		for (int i = 1; i < getColValue.size(); i++) {
			if (getColValue.get(i).equals(taskId)) {
				getIsEnableColValue = commonMethodsR1Access.getTableColValue(serviceAutomationtableRow,
						serviceAutomationRowHeader, "Is Enabled");
				if (getIsEnableColValue.get(i).equals("True")) {
					clickOn(isEnabledColVal.get(i));
				}
				break;

			}
		}
	}

	@SuppressWarnings("unchecked")
	public void verifyIsEnabledColumnValueFalse() {
		getColValue = commonMethodsR1Access.getTableColValue(serviceAutomationtableRow, serviceAutomationRowHeader,
				"ID");
		for (int i = 1; i < getColValue.size(); i++) {
			if (getColValue.get(i).equals(taskId)) {
				getIsEnableColValue = commonMethodsR1Access.getTableColValue(serviceAutomationtableRow,
						serviceAutomationRowHeader, "Is Enabled");
				Assert.assertTrue("Is Enabled Cloumn value is True", getIsEnableColValue.get(i).equals("False"));
				break;

			}
		}
	}

	@SuppressWarnings("unchecked")
	public void clickIsEnabledColumnValueFalse() {
		getColValue = commonMethodsR1Access.getTableColValue(serviceAutomationtableRow, serviceAutomationRowHeader,
				"ID");
		for (int i = 1; i < getColValue.size(); i++) {
			if (getColValue.get(i).equals(taskId)) {
				getIsEnableColValue = commonMethodsR1Access.getTableColValue(serviceAutomationtableRow,
						serviceAutomationRowHeader, "Is Enabled");
				if (getIsEnableColValue.get(i).equals("False")) {
					clickOn(isEnabledColVal.get(i));
				}
				break;

			}
		}
	}

	@SuppressWarnings("unchecked")
	public void verifyIsEnabledColumnValueTrue() {
		getColValue = commonMethodsR1Access.getTableColValue(serviceAutomationtableRow, serviceAutomationRowHeader,
				"ID");
		for (int i = 1; i < getColValue.size(); i++) {
			if (getColValue.get(i).equals(taskId)) {
				getIsEnableColValue = commonMethodsR1Access.getTableColValue(serviceAutomationtableRow,
						serviceAutomationRowHeader, "Is Enabled");
				Assert.assertTrue("Is Enabled Cloumn value is True", getIsEnableColValue.get(i).equals("True"));
				break;

			}
		}
	}

	public void clickExport() {
		clickOn(btnExport);
	}

	public void verifyExport() throws IOException {
		String downloadpath = CommonMethods.LoadProperties("downloadpath");
		int uiHeadercount = totalHeaderUI.size();
		Assert.assertTrue("Failed to download Expected document",
				isFileDownloadedWithContent(downloadpath, uiHeadercount));
	}

	@SuppressWarnings("resource")
	public boolean isFileDownloadedWithContent(String downloadpath, int uiHeadercount) throws IOException {
		boolean flag = false;
		File dir = new File(downloadpath);
		File[] dir_contents = dir.listFiles();
		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().contains("BusinessAutomationRule")) {
				String path = downloadpath + "\\" + dir_contents[i].getName();
				CSVReader reader = new CSVReader(new FileReader(path));
				List<String[]> li = reader.readAll();
				Iterator<String[]> it = li.iterator();
				while (it.hasNext()) {
					String[] str = it.next();
					Assert.assertTrue("total header count in excel is mis matched with UI while exporting",
							str.length >= uiHeadercount);
					break;
				}
				dir_contents[i].delete();
				return flag = true;
			}
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public void verifyNoServiceAdded() {
		getColValue = commonMethodsR1Access.getTableColValue(matchingRuletableRow, matchingRuleRowHeader, "Rule Id");
		Assert.assertFalse("Service Automation Rule exist in matching rule panel", getColValue.contains(taskId));

	}

	@SuppressWarnings("unchecked")
	public void verifyMatchingRule() {
		getColValue = commonMethodsR1Access.getTableColValue(matchingRuletableRow, matchingRuleRowHeader, "Rule Id");
		Assert.assertTrue("Service Automation Rule does not exist in matching rule panel",
				getColValue.contains(taskId));

	}

}
