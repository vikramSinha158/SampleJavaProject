package r1.pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.serenity.steps.ConfigRulesStep;

public class ConfigRulePage extends BasePage {

	R1AccessCommonMethods r1AccessCommonMethods;

	@FindBy(xpath = "//a[contains(text(),'Configuration Rules')]")
	private WebElementFacade configurationRulesLink;

	@FindBy(xpath = "//input[contains(@id,'_dshPrimaryAuth_imgIcon')]")
	private WebElementFacade dshPrimaryAuth_ImgIcon;

	@FindBy(xpath = "//input[contains(@id,'_dshPrimary_imgIcon')]")
	private WebElementFacade dshPrimaryConfig_ImgIcon;

	@FindBy(xpath = "//input[contains(@id,'_dshServiceAutomation_imgIcon')]")
	private WebElementFacade dshServicesAuth_ImgIcon;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryAuth')]//table[contains(@id,'_dgLog')]//tr")
	private List<WebElementFacade> logHistoryPAS;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryAuth')]//table[contains(@id,'_dgDataSourceFields')]//tr")
	private List<WebElementFacade> fieldDetailsPAS;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryAuth')]//table[contains(@id,'_dgDataSourceRuleMatches')]//tr")
	private List<WebElementFacade> matchingRulesPAS;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryCoverage')]//table[contains(@id,'_dgLog')]//tr")
	private List<WebElementFacade> logHistoryPCE;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryCoverage')]//table[contains(@id,'_dgDataSourceFields')]//tr")
	private List<WebElementFacade> fieldDetailsPCE;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryCoverage')]//table[contains(@id,'_dgDataSourceRuleMatches')]//tr")
	private List<WebElementFacade> matchingRulesPCE;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryAuth')]//td[contains(@style,'background-color:LightPink')]")
	private List<WebElementFacade> primaryAuthPartialMatchPink;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryAuth')]//td[contains(@style,'background-color:LightGreen')]")
	private List<WebElementFacade> primaryAuthPartialMatchGreen;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryAuth')]//input[contains(@id,'_cbIncludePartial')]")
	private WebElementFacade primaryAuthIncludePartial;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryAuth')]//input[contains(@id,'_cbIncludeInactive')]")
	private WebElementFacade primaryAuthIncludeInactive;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryAuth')]//td[contains(@style,'background-color:LightGreen')][contains(text(),'True')]")
	private List<WebElementFacade> primaryAuthIncludeInactiveTrue;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryAuth')]//td[contains(@style,'background-color:LightPink')][contains(text(),'False')]")
	private List<WebElementFacade> primaryAuthIncludeInactiveFalse;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryCoverage')]//td[contains(@style,'background-color:LightPink')]")
	private List<WebElementFacade> primaryConfigPartialMatchPink;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryCoverage')]//td[contains(@style,'background-color:LightGreen')]")
	private List<WebElementFacade> primaryConfigPartialMatchGreen;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryCoverage')]//input[contains(@id,'_cbIncludePartial')]")
	private WebElementFacade primaryConfigIncludePartial;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryCoverage')]//input[contains(@id,'_cbIncludeInactive')]")
	private WebElementFacade primaryConfigIncludeInactive;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryCoverage')]//td[contains(@style,'background-color:LightGreen')][contains(text(),'True')]")
	private List<WebElementFacade> primaryConfigIncludeInactiveTrue;

	@FindBy(xpath = "//div[contains(@id,'_divPrimaryCoverage')]//td[contains(@style,'background-color:LightPink')][contains(text(),'False')]")
	private List<WebElementFacade> primaryConfigIncludeInactiveFalse;

	@FindBy(xpath = "//div[contains(@id,'_divService')]//table[contains(@id,'_dgDataSourceFields')]//tr")
	private List<WebElementFacade> fieldDetailsSAR;

	@FindBy(xpath = "//div[contains(@id,'_divService')]//table[contains(@id,'_dgDataSourceRuleMatches')]//tr")
	private List<WebElementFacade> matchingRulesSAR;

	@FindBy(xpath = "//div[contains(@id,'_divService')]//input[contains(@id,'_cbIncludePartial')]")
	private WebElementFacade servicesAutoIncludePartial;

	@FindBy(xpath = "//div[contains(@id,'_divService')]//td[contains(@style,'background-color:LightPink')]")
	private List<WebElementFacade> servicesAutoPartialMatchPink;

	@FindBy(xpath = "//div[contains(@id,'_divService')]//td[contains(@style,'background-color:LightGreen')]")
	private List<WebElementFacade> servicesAutoPartialMatchGreen;

	@FindBy(xpath = "//div[contains(@id,'_divService')]//input[contains(@id,'_cbIncludeInactive')]")
	private WebElementFacade servicesAutoIncludeInactive;

	@FindBy(xpath = "//div[contains(@id,'_divService')]//td[contains(@style,'background-color:LightGreen')][contains(text(),'True')]")
	private List<WebElementFacade> servicesAutoIncludeInactiveTrue;

	@FindBy(xpath = "//div[contains(@id,'_divService')]//td[contains(@style,'background-color:LightPink')][contains(text(),'False')]")
	private List<WebElementFacade> servicesAutoIncludeInactiveFalse;

	@FindBy(xpath = "//table[contains(@id,'_grdCoverageSelected')]//tr")
	private List<WebElementFacade> selectedCoverage;

	@FindBy(xpath = "//table[contains(@id,'grdCoverageSelected')]//img[contains(@title,'Delete')]/..")
	private WebElementFacade crossMark;
	public String CoverageSelectedRow = "//*[contains(@id,'grdCoverageSelected')]//tr";
	public String CoverageSelectedHeader = "//*[contains(@id,'grdCoverageSelected')]//tr[1]/td";

	public void deleteAllCoverage() {
		int size = r1AccessCommonMethods.getTableColValue(CoverageSelectedRow, CoverageSelectedHeader, "Code").size();
		while (size > 0) {
			clickOn(crossMark);
			size--;
		}
	}

	public void verifyWorkList() {
		r1AccessCommonMethods.verifyWorklistExists();
	}

	public void verifyConfigurationRules() {
		configurationRulesLink.click();
	}

	public void enter_encounter_id(String rule) throws ClassNotFoundException, IOException, SQLException {
		String id = "";
		switch (rule) {
		case "PAS":
			id = ConfigRulesStep.searchEncounterIDPAS("EncounterID");
			break;
		case "PCE":
			id = ConfigRulesStep.searchEncounterIDPCE("EncounterID");
			break;
		case "SAR":
			id = ConfigRulesStep.searchEncounterIDSAR("EncounterID");
			break;
		}
		r1AccessCommonMethods.enterVisitNumber(id);
		r1AccessCommonMethods.clickOnSearchButton();
	}

	public void clicks_on_search() {
		r1AccessCommonMethods.clickUpperHeaderLink("Search");
	}

	public void dshPrimaryAuthImgIcon() {
		dshPrimaryAuth_ImgIcon.click();
	}

	public void dshServicesAuthImgIcon() {
		dshServicesAuth_ImgIcon.click();
	}

	public void verifyLogHistoryPAS() {
		System.out.println("====>" + logHistoryPAS.size());
		Assert.assertTrue("Log History validation fail.", logHistoryPAS.size() > 1);
	}

	public void verifyFieldDetailsPAS() {
		Assert.assertTrue("Log History validation fail.", fieldDetailsPAS.size() > 1);
	}

	public void verifyMatchingRulesPAS() {
		Assert.assertTrue("Log History validation fail.", matchingRulesPAS.size() > 1);
	}

	public void verifyPrimaryAuthIncludePartial(String status) {
		if (status.equalsIgnoreCase("true")) {
			if (!primaryAuthIncludePartial.isSelected())
				primaryAuthIncludePartial.click();
			Assert.assertTrue("Partial matching table validation fail.", primaryAuthPartialMatchPink.size() > 0);
		} else if (status.equalsIgnoreCase("false")) {
			if (primaryAuthIncludePartial.isSelected())
				primaryAuthIncludePartial.click();
			Assert.assertTrue("Partial matching table validation fail.", primaryAuthPartialMatchGreen.size() > 0);
		}
	}

	public void verifyPrimaryAuthIncludeInactive(String status) {
		if (status.equalsIgnoreCase("true")) {
			if (!primaryAuthIncludeInactive.isSelected())
				primaryAuthIncludeInactive.click();
			Assert.assertTrue("Partial matching table validation fail.", primaryAuthIncludeInactiveFalse.size() > 0);
		} else if (status.equalsIgnoreCase("false")) {
			if (primaryAuthIncludeInactive.isSelected())
				primaryAuthIncludeInactive.click();
			Assert.assertTrue("Partial matching table validation fail.", primaryAuthIncludeInactiveTrue.size() > 0);
		}
	}

	public void dshPrimaryConfigImgIcon() {
		dshPrimaryConfig_ImgIcon.click();
	}

	public void verifyLogHistoryPCE() {
		Assert.assertTrue("Log History validation fail.", logHistoryPCE.size() > 1);
	}

	public void verifyFieldDetailsPCE() {
		Assert.assertTrue("Field Details validation fail.", fieldDetailsPCE.size() > 1);
	}

	public void verifyFieldDetailsSAR() {
		Assert.assertTrue("Field Details validation fail.", fieldDetailsSAR.size() > 1);
	}

	public void verifyMatchingRulesPCE() {
		Assert.assertTrue("Matching Rules validation fail.", matchingRulesPCE.size() > 1);
	}

	public void verifyMatchingRulesSAR() {
		Assert.assertTrue("Matching Rules validation fail.", matchingRulesSAR.size() > 1);
	}

	public void verifyPrimaryConfigIncludePartial(String status) {
		if (status.equalsIgnoreCase("true")) {
			if (!primaryConfigIncludePartial.isSelected())
				primaryConfigIncludePartial.click();
			Assert.assertTrue("Partial matching table validation fail.", primaryConfigPartialMatchPink.size() > 0);
		} else if (status.equalsIgnoreCase("false")) {
			if (primaryConfigIncludePartial.isSelected())
				primaryConfigIncludePartial.click();
			Assert.assertTrue("Partial matching table validation fail.", primaryConfigPartialMatchGreen.size() > 0);
		}
	}

	public void verifyPrimaryConfigIncludeInactive(String status) {
		if (status.equalsIgnoreCase("true")) {
			if (!primaryConfigIncludeInactive.isSelected())
				primaryConfigIncludeInactive.click();
			Assert.assertTrue("Partial matching table validation fail.", primaryConfigIncludeInactiveFalse.size() > 0);
		} else if (status.equalsIgnoreCase("false")) {
			if (primaryConfigIncludeInactive.isSelected())
				primaryConfigIncludeInactive.click();
			Assert.assertTrue("Partial matching table validation fail.", primaryConfigIncludeInactiveTrue.size() > 0);
		}
	}

	public void verifyServicesAutomationIncludePartial(String status) {
		if (status.equalsIgnoreCase("true")) {
			if (!servicesAutoIncludePartial.isSelected())
				servicesAutoIncludePartial.click();
			Assert.assertTrue("Partial matching table validation fail.", servicesAutoPartialMatchPink.size() > 0);
		} else if (status.equalsIgnoreCase("false")) {
			if (servicesAutoIncludePartial.isSelected())
				servicesAutoIncludePartial.click();
			Assert.assertTrue("Partial matching table validation fail.", servicesAutoPartialMatchGreen.size() > 0);
		}
	}

	public void verifyServicesAutomationIncludeInactive(String status) {
		if (status.equalsIgnoreCase("true")) {
			if (!servicesAutoIncludeInactive.isSelected())
				servicesAutoIncludeInactive.click();
			Assert.assertTrue("Partial matching table validation fail.", servicesAutoIncludeInactiveFalse.size() > 0);
		} else if (status.equalsIgnoreCase("false")) {
			if (servicesAutoIncludeInactive.isSelected())
				servicesAutoIncludeInactive.click();
			Assert.assertTrue("Partial matching table validation fail.", servicesAutoIncludeInactiveTrue.size() > 0);
		}
	}

	public void verifySelectedCoverage() {
		Assert.assertTrue("Coverage validation fail.", selectedCoverage.size() > 1);
	}

	public void verifyPrimaryAuthAndCoverage(String status) {
		if (status.equalsIgnoreCase("true")) {
			Assert.assertTrue("Primary Auth tab is not Present.", dshPrimaryAuth_ImgIcon.isPresent());
			Assert.assertTrue("Primary Coverage tab is not Present.", dshPrimaryConfig_ImgIcon.isPresent());
		} else {
			Assert.assertFalse("Primary Auth tab is Present.", dshPrimaryAuth_ImgIcon.isPresent());
			Assert.assertFalse("Primary Coverage tab is Present.", dshPrimaryConfig_ImgIcon.isPresent());
		}
	}
}
