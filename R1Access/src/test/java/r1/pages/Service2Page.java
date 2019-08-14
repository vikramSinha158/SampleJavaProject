package r1.pages;

import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import java.util.Random;

public class Service2Page extends BasePage {
	Random random = new Random();
	R1AccessCommonMethods r1AccessCommonMethod;
	String value;
	boolean flag = false;
	int i;
	int rowIndex;

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

	@FindBy(xpath = "//table[contains(@id,'grdICD9Selected')]//tr[@class='PanelDetail']//td[1]")

	private WebElementFacade clickICDCodesUpArrow;

	@FindBy(xpath = "//table[contains(@id,'grdICD9Selected')]//tr")

	private List<WebElementFacade> clickICDCodesIndexValueFromTable;

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
		Assert.assertTrue("Single Multiple Radio Not Coming ", singleMultipleRadioBtn.size() == 2);
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

	public void verifyTabColorAndCompleteStatus() {
		Assert.assertTrue(r1AccessCommonMethod.chkTabStatusIncompleteComplete().equalsIgnoreCase("Incomplete"));
		Assert.assertTrue(r1AccessCommonMethod.checkTabColor("Services").equalsIgnoreCase("blue"));
	}

	public void clickOnExceptionContinueButton(String tab) {
		if (clickOnContinueButton.getText().equalsIgnoreCase(tab)) {
			clickOn(clickOnContinueButton);
		}
	}

}
