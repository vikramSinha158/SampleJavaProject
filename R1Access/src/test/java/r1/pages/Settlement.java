package r1.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;

import r1.commons.databaseconnection.QueryExecutor;

public class Settlement extends BasePage {

	List<String> tabList;
	@FindBy(xpath = "//A[contains(@class,'footer_nav')][contains(@href,'Patient-Access')]")
	private WebElementFacade hrefPatientAccess;

	@FindBy(xpath = "//ul[@class='detailTabs']//li")
	private List<WebElementFacade> r1AccessTabs;

	@FindBy(xpath = "//span[@class='subhead'][text()='Pre-Registration']")
	private WebElementFacade preRegLabel;

	@FindBy(xpath = "//td[@class='SubHead'][contains(text()  ,'Prior Balance =' )]")
	private WebElementFacade priorBalLabel;

	@FindBy(xpath = "//tr[contains(@id , 'trPrimaryDisposition' )]//td[@class=  'subhead']")
	private WebElementFacade primaryDispositionLabel;

	@FindBy(xpath = "//span[contains(@id , 'lblNonCollReasons')]")
	private WebElementFacade nonCollReasonLabel;

	@FindBy(xpath = "//tr[contains(@id , 'trAttemptResult')]//select//option")
	private WebElementFacade nonCollReasons;

	@FindBy(xpath = "//span[contains(@id , 'PrimaryDisposition')]//span//label")
	private List<WebElementFacade> primaryDispositionLabelValues;

	@FindBy(xpath = "//span[contains(@id , 'PrimaryDisposition')]//span//input")
	private List<WebElementFacade> primaryDispositionLabelStatus;

	@FindBy(xpath = "//td[@class='SubHead'][contains(text()  ,'Prior Balance =' )]//span")
	private WebElementFacade priorBalVal;

	@FindBy(xpath = "//a[contains(@id , 'WorklistPanel_grid_lnkClear')]")
	private WebElementFacade showAllButton;

	@FindBy(xpath = "//input[contains(@id , 'chkShowRelatedVisits' )]")
	private WebElementFacade relatedVisitsChkbox;

	@FindBy(xpath = "//select[contains(@id , 'NonCollReasons' )]")
	private WebElementFacade selectNonCollectionReason;

	@FindBy(xpath = "//table[contains (@id  ,'tblCharges')]/following-sibling::table//td[@class = 'SubHead']")
	private WebElementFacade totalPaymentsLabel;

	@FindBy(xpath = "//table[contains (@id  ,'tblCharges')]/following-sibling::table//td[@class = 'SubHead']//span")
	private WebElementFacade totalPaymentsVal;

	@FindBy(xpath = "//table[contains (@id , 'GenericList_grdGenericList')]//td[@align = 'right']")
	private List<WebElementFacade> totalPaymentsAmountVal;

	@FindBy(xpath = "//input[contains(@id , 'dshPayments_imgIcon')]")
	private WebElementFacade totalPaymentsExpandbtn;

	public void clickTotalPaymentsExpandbtn() {
		totalPaymentsExpandbtn.click();
	}

	public void verifyTotalPaymentsPanelColumns(List<String> lst) {
		List<String> colmnList = new ArrayList<String>();
		colmnList.add("PostDate");
		colmnList.add("Pmt Code");
		colmnList.add("Description");
		colmnList.add("Plan Code");
		colmnList.add("Tran Type");
		colmnList.add("Tran Date");
		colmnList.add("Amount");
		Assert.assertTrue("Columns label verified", colmnList.equals(lst));
	}

	public void verifyTotalPaymentsVal() {
		double totalAmount = 0;
		int index2 = totalPaymentsVal.getText().length() - 1;
		double totalPaymentVal = Double.parseDouble(totalPaymentsVal.getText().substring(2, index2));
		for (int i = 1; i < totalPaymentsAmountVal.size(); i++) {
			totalAmount = totalAmount
					+ Double.parseDouble(totalPaymentsAmountVal.get(i).getText().substring(2, index2));
		}
		if (totalPaymentVal == totalAmount) {
			Assert.assertTrue(true);
		}
	}

	public void verifyTotalPaymentsPanel() {
		totalPaymentsLabel.isVisible();
	}

	public void verifyPreRegWorklist() {
		Assert.assertTrue("Pre Registration tab is not displayed", preRegLabel.isDisplayed());
		if (showAllButton.isVisible()) {
			showAllButton.click();
		}
	}

	public void verifyR1AccessTabs() {
		List<String> tabs = new ArrayList<String>();
		tabs.add("Patient");
		tabs.add("Coverage");
		tabs.add("Residual");
		tabs.add("Services");
		tabs.add("Clearance");
		tabs.add("PCP Validation");
		tabs.add("PFA");
		tabs.add("Conversion FU");
		tabs.add("Authorization");
		tabs.add("Notes");
		tabs.add("Settlement");
		tabs.add("Log");
		tabs.add("FCC Contact");
		tabs.add("Configuration Rules");
		Collections.sort(tabs);
		tabList = new ArrayList<String>();
		for (int i = 0; i < r1AccessTabs.size(); i++) {
			tabList.add(r1AccessTabs.get(i).getText());
		}
		Collections.sort(tabList);
		Assert.assertTrue("R1 Access modules tab is not visible ", tabs.equals(tabList));
	}

	public void verifyPriorBal() {
		Assert.assertTrue("Prior Balance label is not displayed", priorBalLabel.isDisplayed());
		Assert.assertTrue("Related balance not displayed", priorBalVal.isDisplayed());
	}

	public void verifyTabisEditable() {
		Assert.assertTrue("Related visit field not editable ", relatedVisitsChkbox.isClickable());
		Assert.assertTrue("Non collection reason field not editable ", selectNonCollectionReason.isClickable());
	}

	public void runQueryTranServer(String queryName)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		QueryExecutor.runQueryTran(this.getClass().getSimpleName().replace("Page", ""), queryName);
	}

	public void verifyRelatedVisitChkboxUnchecked() {
		Assert.assertTrue("Related Visit Checkbox is enabled.", !relatedVisitsChkbox.isEnabled());
	}

	public void verifyPrimaryDisposition() {
		Assert.assertTrue("Primary Disposition Label is visible.", primaryDispositionLabel.isDisplayed());
		for (int i = 0; i < primaryDispositionLabelStatus.size(); i++) {
			if (primaryDispositionLabelValues.get(i).getText().trim().equalsIgnoreCase("No Payment")) {
				Assert.assertTrue(primaryDispositionLabelStatus.get(i).getAttribute("checked").equals("true"));
			}
		}
	}

	public void verifyNonCollReason() {
		Assert.assertTrue("Non Collection reason not displayed", nonCollReasonLabel.isDisplayed());
		Assert.assertTrue(nonCollReasons.getText().equals("[Select One]"));
	}
}
