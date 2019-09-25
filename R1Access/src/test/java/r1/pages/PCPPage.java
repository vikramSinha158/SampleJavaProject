package r1.pages;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;

public class PCPPage extends BasePage {

	String AccountNum;
	int size;
	R1AccessCommonMethods R1AccessCommonMethodsRef;

	@FindBy(xpath = "//select[@id='dllLocationSearch']")
	private WebElementFacade searchList;

	@FindBy(xpath = "//input[@id='txtLocSearchValue']")
	private WebElementFacade searchTextBox;

	@FindBy(xpath = "//span[@id='BtnLocSearch']")
	private WebElementFacade searchButton;

	@FindBy(xpath = "//div[@id='LocationGridData']//div//a")
	private WebElementFacade gridView;

	@FindBy(xpath = "//select[@id='dllFSSearch']")
	private WebElementFacade searchListFacilitySettings;

	@FindBy(xpath = "//input[@id='txtFSSearchValue']")
	private WebElementFacade searchTextBoxLocations;

	@FindBy(xpath = "//span[@id='BtnFSSearch']")
	private WebElementFacade searchButtonLocations;

	@FindBy(xpath = "//div[text()='TrackPCPComplete']/following-sibling::div[1]")
	private WebElementFacade TrackPCPCompleteSettingValue;

	@FindBy(xpath = "//textarea[@id='txtSettingValue']")
	private WebElementFacade text_setting_value;

	@FindBy(xpath = "//input[@id='Button1']")
	private WebElementFacade update_facility_button;

	@FindBy(xpath = "//div[@text = 'Update Facility Setting']")
	private WebElementFacade edit_facility_setting;

	@FindBy(xpath = "//span[@class='txt'][text()='Cache']")
	private WebElementFacade cache_link;

	@FindBy(xpath = "//input[contains(@id,'btnClearAll')]")
	private WebElementFacade cache_clear_all;

	@FindBy(xpath = "//span[@class='subHead']/preceding-sibling::span")
	private WebElementFacade workListTitle;

	@FindBy(xpath = "//a[@class='GBtn']")
	private List<WebElementFacade> workListRecord;

	@FindBy(xpath = "//*[contains(@id,'grdWorklist')]//tr")
	private List<WebElementFacade> workListTotalRow;

	@FindBy(xpath = "//a[contains(@id,'tabsTask')]")
	private List<WebElementFacade> accountDetailMenuLinks;

	@FindBy(xpath = "//span[contains(@id,'lblStatus')]")
	private WebElementFacade tabStatus;

	@FindBy(xpath = "//*[contains(text(),'Incomplete Task')]//..//*[contains(@imgtype,'exp')]")
	private WebElementFacade incompleteTaskPlus;

	@FindBy(xpath = "//span[contains(text(),'PCP Validation')]")
	private WebElementFacade pcpFilterfolder;

	@FindBy(xpath = "//input[contains(@name,'chkStatus')]")
	private WebElementFacade pcpValidationChkBox;

	@FindBy(xpath = "//*[contains(@class,'PanelDetail actionLog')]//tr[contains(@class,'PanelDetail')][1]/td[2]")
	private WebElementFacade lastTaskLog;

	@FindBy(xpath = "//*[contains(@class,'PanelDetail actionLog')]//tr[contains(@class,'PanelDetail')][1]/td[4]")
	private WebElementFacade lastStatusLog;

	@FindBy(xpath = "//span[contains(@id,'lblEncounterNum')]")
	private WebElementFacade fetchAccNum;

	@FindBy(xpath = "//a[contains(text(),'Show All')]")
	private WebElementFacade showAll;

	@FindBy(xpath = "//*[contains(@id,'grdWorklist')]//tr[contains(@class,'tableHeader')]/td[2]")
	private WebElementFacade firstColName;

	@FindBy(xpath = "//a[contains(text(),'Release')]")
	private WebElementFacade release;

	public List<WebElementFacade> accountDetailMenuLinks() {
		return accountDetailMenuLinks;
	}

	public void clickAccountDetailMenuLink(String tabName) {
		for (int i = 0; i < accountDetailMenuLinks.size(); i++) {
			if (accountDetailMenuLinks.get(i).getText().equalsIgnoreCase(tabName)) {
				withAction().moveToElement(accountDetailMenuLinks.get(i)).click().build().perform();
				break;
			}
		}
	}

	public void selectSearchField(String text) {
		selectFromDropdown(searchList, text);
	}

	public void searchText(String text) {
		typeInto(searchTextBox, text);
	}

	public void clickSearchIcon() {
		clickOn(searchButton);
	}

	public void clickGridView() {
		clickOn(gridView);
	}

	public void clickRelease() {
		if (release.isVisible()) {
			clickOn(release);
		}
	}

	public void clickPlusIncompTask() {
		clickOn(incompleteTaskPlus);
	}

	public void clickPcpFilterFolder() {
		clickOn(pcpFilterfolder);
	}

	public void selectSearchFieldFacilitySetting(String text) {
		selectFromDropdown(searchListFacilitySettings, text);
	}

	public void searchTextLocations(String text) {
		typeInto(searchTextBoxLocations, text);
	}

	public void clickSearchIconLocations() {
		clickOn(searchButtonLocations);
	}

	public void edit_text_setting_value(String value) throws IOException {
		if (!TrackPCPCompleteSettingValue.getText().equals(value)) {
			withAction().moveToElement(edit_facility_setting).click().build().perform();
			text_setting_value.clear();
			text_setting_value.sendKeys(value);
			update_facility_button.click();
		}
	}

	public void clearCache() {
		withAction().moveToElement(cache_link).click().build().perform();
		cache_clear_all.click();
	}

	public void clickPcpValidChkBox() {
		clickOn(pcpValidationChkBox);
	}

	public void clickRecord() {
		if (showAll.isVisible()) {
			clickOn(showAll);
		}
		int random = 1 + (int) (Math.random() * workListRecord.size());
		clickOn(workListRecord.get(random - 1));
	}

	public void fetchAccountNum() {
		AccountNum = fetchAccNum.getText();
	}

	public int WorkLstSize() {
		return size = workListTotalRow.size();
	}

	public void verifyAccNotInWrkLst() {
		boolean flag = false;
		String colName = firstColName.getText();
		R1AccessCommonMethodsRef.ddlWorkListFilter(colName, "=", AccountNum);
		int sz = WorkLstSize();
		if (sz == 1)
			flag = true;
		Assert.assertTrue("Account still exists in PCP worklist after completing validation", flag);
	}

	public void verifyAccountDetailMenuLink(String tabName) {
		boolean flag = false;
		for (int i = 0; i < accountDetailMenuLinks.size(); i++) {
			if (accountDetailMenuLinks.get(i).getText().contains(tabName)) {
				flag = true;
				break;
			}
		}
		Assert.assertTrue("tab is not visible", flag);
	}

	public void verifyPcpIncompTask() {
		clickRecord();
		clickAccountDetailMenuLink("PCP Validation");
		verifyIncompleteTabStatus();
	}

	public void verifyIncompleteTabStatus() {
		Assert.assertTrue("tab status does not matched", tabStatus.getText().contains("Incomplete"));
	}

	public void verifycompleteTabStatus() {
		Assert.assertTrue("tab status does not matched", tabStatus.getText().contains("Complete"));
	}

	public void verifyTabStatusRedColor() {
		Assert.assertTrue("tab status color is not red",
				tabStatus.getCssValue("color").contains("rgba(169, 68, 66, 1)"));
	}

	public void verifyTabStatusBlueColor() {
		Assert.assertTrue("tab status color is not Blue",
				tabStatus.getCssValue("color").contains("rgba(49, 112, 143, 1)"));
	}

	public void verifyActionlog() {
		Assert.assertTrue("last task does not matches with PCP", lastTaskLog.getText().contains("PCP Validation"));
		Assert.assertTrue("last status log was not completed", lastStatusLog.getText().contains("Completed"));
	}

	public void verifyWorkListTitle(String worklist) {
		Assert.assertEquals("Worklist title is not matching", workListTitle.getText(), worklist);
	}

	public void verifyTab(String tab) {
		Assert.assertEquals("tab is not visible", workListTitle.getText(), tab);
	}
}
