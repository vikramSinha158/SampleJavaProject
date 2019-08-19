package r1.pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.DataAccess;
import r1.commons.R1AccessCommonMethods;
import r1.commons.databaseconnection.QueryConstantPFA;
import r1.serenity.steps.PFASteps;

public class PFAPage extends BasePage{

	R1AccessCommonMethods commonMethodsR1Access;
	PFASteps pfaSteps;
	ArrayList<String> getColValue,getVerifiedColValue;
	String selPlanCode,payorCode;
	
	@FindBy(xpath = "//span[contains(text(),'Unworked')]")
	private WebElementFacade filterUnworked;
	
	@FindBy(xpath = "//a[contains(@id,'btnAddNew')]")
	private WebElementFacade btnAddCoverage;
	
	@FindBy(xpath = "//input[contains(@id,'_txtSearchPayors')]")
	private WebElementFacade txtSearchPayors;
	
	@FindBy(xpath = "//a[contains(@id,'_btnRunSearch')]")
	private WebElementFacade findPayorButton;
	
	@FindBy(xpath = "//table[contains(@id,'grdCoverageSearchResults')]//tr[2]/td[1]/a")
	private WebElementFacade linkPlanCode;
	
	@FindBy(xpath = "//a[@class='StandardButton'][contains(text(),'Add')]")
	private WebElementFacade btnPayorAdd;
	
	@FindBy(xpath = "//table[contains(@id,'_grdCoverageSelected')]//tr[2]/td[15]/a")
	private WebElementFacade statusCoverage;
	
	@FindBy(xpath = "//select[contains(@id,'_CoverageDetails_ddlStatus')]")
	private WebElementFacade coverageStatus;
	
	@FindBy(xpath = "//a[contains(@id,'_CoverageDetails_btnUpdate')]")
	private WebElementFacade btnUpdate;
	
	@FindBy(xpath = "//span[contains (@id, 'accTaskAction_lblStatus' )]")
	private WebElementFacade statusLabel;
	
	@FindBy(xpath = "//table[contains(@id,'grdCoverageSelected')]//img[contains(@alt,'Delete')]/..")
	private WebElementFacade crossMark;
	
	public String coveragesearchResultRow= "//*[contains(@id,'grdCoverageSearchResults')]//tr";
	public String coveragesearchResultRowHeader= "//*[contains(@id,'grdCoverageSearchResults')]//tr[1]/td";
	
	public String coveragePlanCodeRow= "//table[contains(@id,'_grdCoverageSelected')]//tr";
	public String coveragePlanCodeRowHeader= "//table[contains(@id,'_grdCoverageSelected')]//tr[1]/td";
	 
	 
	
	
	
	
	
	
	
	
	/*********************************************************************************************************************************************************************************************/
	
	public void enterPayorCode() {
		typeInto(txtSearchPayors, payorCode);
	}
	
	public void clickUnworkedFilterFolder() {
		clickOn(filterUnworked);
	}
	
	public void clickAddCoverageButton() {
		clickOn(btnAddCoverage);
	}
	
	public void clickFindPayorButton() {
		clickOn(findPayorButton);
	}
	
	public void clickPayorAddButton() {
		clickOn(btnPayorAdd);
	}
	
	public void selectVerificationStatus() {
		selectFromDropdown(coverageStatus,"Passed");
	}
	
	public void clickUpdateButton() {
		clickOn(btnUpdate);
	}
	
	public void fetchPayorCode(String col) throws ClassNotFoundException, SQLException, IOException {
		payorCode = pfaSteps.getPayorCode(col);
		
	}
	
	public void verifyTabStatus(String status) {
		System.out.println(commonMethodsR1Access.chkTabStatusIncompleteComplete());
		 Assert.assertTrue(commonMethodsR1Access.chkTabStatusIncompleteComplete().equals(status));
	}
	
	public void verifyTabColor(String tabColor) {
		 Assert.assertTrue(commonMethodsR1Access.checkTabColor(tabColor).equals(tabColor));
	}
	
	public void DelAllCoverage() throws InterruptedException 
    {
    	int size = commonMethodsR1Access.getTableColValue(coveragePlanCodeRow,coveragePlanCodeRowHeader, "Payor").size();
    	while(size>0)
    	{
    	clickOn(crossMark);	
    	size--;
    	}
    	Assert.assertEquals("Coverage didn't get deleted", size, 0);	
    }
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public void selectPlanCodeResultGrid() {
		getColValue = commonMethodsR1Access.getTableColValue(coveragesearchResultRow, coveragesearchResultRowHeader,
				"Plan Code");
		selPlanCode = getColValue.get(0);
		clickOn(linkPlanCode);
	}
	
	@SuppressWarnings("unchecked")
	public void verifyPlanCodeCoverageTable(String status) {
		getVerifiedColValue = commonMethodsR1Access.getTableColValue(coveragePlanCodeRow,coveragePlanCodeRowHeader, "Verified");
		if(!(getVerifiedColValue.get(0).contains(status)))
		{
			clickOn(statusCoverage);
			
		}
		
		
		
		
		
		
	

	}
	
	
	}

