package r1.pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;

public class CWLPage extends PageObject {
	String encounterId;
	R1AccessCommonMethods common;
	LocalDateTime myDateObj = LocalDateTime.now();

	public String followUpWorklistRow = "//*[contains(@id,'grdWorklist')]/tbody/tr";
	public String followUpWorklistHeader = "//*[contains(@id,'grdWorklist')]/tbody/tr[1]/td";

	@FindBy(xpath = "//*[contains(@id,'grdWorklist')]/tbody/tr")
	private List<WebElementFacade> AccountRecords;

	@FindBy(xpath = "//td[contains(text(),'Patient Visit and Address')]")
	private WebElementFacade verify_patient_tab;

	@FindBy(linkText = "Settings")
	private WebElementFacade Settings;

	@FindBy(xpath = "//div[@id='sidebar']/div[1]/span[2]/span/div/span[2]")
	private List<WebElementFacade> payor_config_submenu;

	@FindBy(xpath = "//*[@id='dnn_ctr1220_ConversionFundingSources_dgConversionFundingSource']/tbody/tr")
	private List<WebElementFacade> conversionPlanList;

	@FindBy(xpath = "//div[@class='side_nav']//a /following-sibling::span[@class='txt']")
	private List<WebElementFacade> Setting_submenu;

	@FindBy(xpath = "//span[@igtxt='1']")
	private List<WebElementFacade> conversionFollowList;

	@FindBy(xpath = "//span[text()='I/S at Risk']")
	private WebElementFacade ISRisk;

	@FindBy(xpath = "//span[text()='E/O at Risk']")
	private WebElementFacade EORisk;

	@FindBy(xpath = "//span[text()='Future Follow Up']")
	private WebElementFacade FutureFollowUp;

	@FindBy(xpath = "//span[text()='Zero Balance']")
	private WebElementFacade zeroBalance;

	String[] conversionList = { "Conversion Followup", "Pending", "", "", "", "", "", "", "", "On-Deck", "I/S at Risk",
			"E/O at Risk", "Future Follow Up", "Zero Balance", "Supervisor Worklist", "Care Coverage", "", "", "BSO" };
	ArrayList<String> namesList = new ArrayList<String>();

	@FindBy(xpath = "//table[@class='worklistTable']/tbody/tr")
	private List<WebElementFacade> conversionFollowtableRows;

	@FindBy(xpath = "//a[contains(@id,'_grid_lnkClear')]")
	private List<WebElementFacade> showAll;

	@FindBy(xpath = "//table[@class='worklistTable']/tbody/tr[")
	private WebElementFacade beforeXpath;

	@FindBy(xpath = "]/td[5]/a")
	private WebElementFacade afterXpath;

	public void click_setting() {
		Settings.click();

	}

	public void submenuList() {
		int size = Setting_submenu.size();

		for (int i = 0; i < size; i++) {
			@SuppressWarnings("unused")
			String submenu = Setting_submenu.get(i).getText();

		}

	}

	public void payorcon_submenu(String menu) {
		common.clickSubSideR1HubModulesMenuLink(menu);
	}

	public void settingSubmenuList() {
		for (int i = 0; i < Setting_submenu.size(); i++) {
			@SuppressWarnings("unused")
			String submenu = Setting_submenu.get(i).getText();

		}
	}

	public void payorConfiglist() {
		for (int i = 0; i < Setting_submenu.size(); i++) {
			@SuppressWarnings("unused")
			String submenu = Setting_submenu.get(i).getText();

		}
	}

	public void verifyCPMSize() {
		int size = conversionPlanList.size();
		Assert.assertFalse(size == 0);

	}

	public void filterList() {

		for (int i = 0; i < conversionFollowList.size(); i++) {
			String optionValue = conversionFollowList.get(i).getText();

			if (optionValue.equals("")) {
				continue;
			} else if (optionValue.equals(conversionList[i])) {
				Assert.assertTrue("passed on: " + optionValue, true);
			} else {

				Assert.assertTrue("failed on: " + optionValue, false);
			}
		}
	}

	public void clickOnIsRisk() {
		clickShowAll();
		ISRisk.click();
	}

	@SuppressWarnings({ "unchecked" })
	public void conversiontable(String val1, String val2) {
		ArrayList<String> ptCol = common.getTableColValue(followUpWorklistRow, followUpWorklistHeader, "PT");
		if (AccountRecords.size() > 1) {
			for (int k = 0; k < ptCol.size(); k++) {

				String i = ptCol.get(k);
				if (i.contains(val1)) {
					Assert.assertTrue(i + " is matching with" + " " + val1, true);

				} else if (i.contains(val2)) {
					Assert.assertTrue(i + " is matching with" + " " + val2, true);
				} else {
					Assert.assertTrue("PT value is coming" + i, false);
				}
			}
		} else {
			Assert.assertTrue("No Accounts records are present", false);
		}
	}

	public void verifyNfuDt() {
		@SuppressWarnings("unchecked")
		ArrayList<String> NFUdt = common.getTableColValue(followUpWorklistRow, followUpWorklistHeader, "NFU Dt");
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String currentDate = myDateObj.format(myFormatObj);
		if (AccountRecords.size() > 1) {
			for (String nfudate : NFUdt) {
				if (currentDate.compareTo(nfudate) <= 0) {
					Assert.assertTrue("nfudate is not correct " + currentDate.compareTo(nfudate), false);

				} else if (nfudate.isEmpty()) {

					Assert.assertTrue("nfudate is empty", true);

				} else {
					Assert.assertTrue("current: " + currentDate + " nfudate: " + nfudate, true);

				}
			}

		} else {
			Assert.assertTrue("No Accounts records are present", false);
		}
	}

	public void verifyTotalBal() {
		@SuppressWarnings("unchecked")
		ArrayList<String> openBal = common.getTableColValue(followUpWorklistRow, followUpWorklistHeader,
				"Total Open Bal");
		if (AccountRecords.size() > 1) {
			for (String TotalopenBal : openBal) {

				double d = Double.parseDouble(TotalopenBal);
				if (d == 0.00 || d == 0) {

					Assert.assertTrue("total balance is coming " + d, false);
				} else {
					Assert.assertTrue("total balance is coming " + d, true);
				}
			}

		} else {
			Assert.assertTrue("No Accounts records are present", false);
		}
	}

	@SuppressWarnings("unchecked")
	public void verifyTotalzeroBal() {
		ArrayList<String> openBal = common.getTableColValue(followUpWorklistRow, followUpWorklistHeader,
				"Total Open Bal");
		if (AccountRecords.size() > 1) {
			for (String TotalopenBal : openBal) {

				double d = Double.parseDouble(TotalopenBal);
				if (d == 0.00 || d == 0) {
					Assert.assertTrue("Total balnce is coming " + d + "on zero balnce", true);

				} else {
					Assert.assertTrue("Total balance is coming " + d, false);
				}
			}

		} else {
			Assert.assertTrue("No Accounts records are present", false);
		}
	}

	public void verifyLA() {
		@SuppressWarnings("unchecked")
		ArrayList<String> LA = common.getTableColValue(followUpWorklistRow, followUpWorklistHeader, "LA");
		if (AccountRecords.size() > 1) {
			for (String LAvalue : LA) {
				if (LAvalue.contains("Referred to Care Coverage")) {
					Assert.assertTrue("LA values is " + LAvalue, false);
				} else if (LAvalue.contains("Referred to Supervisor")) {
					Assert.assertTrue("LA values is " + LAvalue, false);

				} else {
					Assert.assertTrue("LA value is " + LAvalue, true);

				}
			}
		} else {
			Assert.assertTrue("No Accounts records are present", false);
		}

	}

	public void clickShowAll() {
		int k = showAll.size();
		if (k > 0) {
			showAll.get(0).click();
		}
	}

	public void clickEoRisk() {
		clickShowAll();
		EORisk.click();
	}

	public void clickFutureFollowUp() {
		clickShowAll();
		FutureFollowUp.click();
	}

	public void clickZeroBalance() {
		clickShowAll();
		zeroBalance.click();
	}

}
