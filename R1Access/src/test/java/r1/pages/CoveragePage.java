package r1.pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cucumber.api.DataTable;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.commons.utilities.CommonMethods;
import r1.serenity.steps.CoverageSteps;

public class CoveragePage extends BasePage{
	
	R1AccessCommonMethods commonMethodsRef;
	PCPPage pcpPage;
	Navigation navigation;
	CoverageSteps coverageSteps;
	CommonMethods commonMethods;
	R1NeccessityPage neccessityPage;
	String payorPlanNameUI,COBUI,payorGroupCodeUI,facilityPlanCodeUI,subscriberCodeUI,copayUI1,copayUI2,ERUI1,ERUI2,deductUI1,deductUI2,coinsUI1,coinsUI2,oopUI1,oopUI2;
	boolean match;
	
	ArrayList<String> FacilityPlanCodeOnUI;
	ArrayList<String> FacilityPlanCodeInOthers;
	
	String grpnum = "11111";
	String subnum = "AB11111111";
	String estAmount;
	
	public String CoverageSelectedRow = "//*[contains(@id,'grdCoverageSelected')]//tr";
	public String CoverageSelectedHeader = "//*[contains(@id,'grdCoverageSelected')]//tr[1]/td";
	public String OtherCoverageRow = "//*[contains(@id,'grdCoverageHistory')]//tr";
	public String OtherCoverageHeader = "//*[contains(@id,'grdCoverageHistory')]//tr[1]/td";
	public String hcpcTableRow = "//*[contains(@id,'grdHCPCSelected')]/tbody/tr";
	public String hcpcTableHeader = "//*[contains(@id,'grdHCPCSelected')]/tbody/tr[1]/td";
	public String hcpcSearchResTableRow = "//*[contains(@id,'grdHCPCSearchResults')]/tbody/tr";
	public String hcpcSearchResTableHeader = "//*[contains(@id,'grdHCPCSearchResults')]/tbody/tr[1]/td";
	
	static ArrayList<String> Encounter_ID,hcpcCode;
	static int randomNum;
	
	@FindBy(xpath = "//span[contains(@class,'rtbText')][contains(text(),'Searc')]")
	private WebElementFacade searchTab;
	
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
	
	@FindBy(xpath = "//div[contains(@id,'FacilitySettingsGridData')]/div/div[2]")
	private WebElementFacade SettingValue;
	
	@FindBy(xpath = "//div[@text = 'Update Facility Setting']")
	private WebElementFacade edit_facility_setting;
	
	@FindBy(xpath = "//textarea[@id='txtSettingValue']")
	private WebElementFacade text_setting_value;
	
	@FindBy(xpath = "//input[@id='Button1']")
	private WebElementFacade update_facility_button;
	
	@FindBy(xpath = "//input[contains(@id,'_txtVisit')]")
	private WebElementFacade visitSearch;
	
	@FindBy(xpath = "//a[contains(text(),'Release')]")
	private WebElementFacade release;
	
	@FindBy(xpath = "//table[contains(@id,'grdCoverageSelected')]//img[contains(@title,'Delete')]/..")
	private WebElementFacade crossMark;
	
	@FindBy(xpath = "//table[contains(@id,'grdCoverageSelected')]//img[contains(@title,'Delete')]/..")
	private List<WebElementFacade> delMark;
	
	@FindBy(xpath = "//a[contains(@id,'_btnAddNew') and (@title='Add')]")
	private WebElementFacade coveragePlusIcon;
	
	@FindBy(xpath = "//a[contains(@id,'_btnAddNew') and (@title='Add')]")
	private List<WebElementFacade> coveragePlus;
	
	@FindBy(xpath = "//img[contains(@src,'/images/edit.gif')]/..")
	private WebElementFacade pencil;
	
	@FindBy(xpath = "//img[contains(@src,'/images/edit.gif')]")
	private List<WebElementFacade> pencilIcon;
	
	@FindBy(xpath = "//input[contains(@name,'txtSearchPayors')]")
	private WebElementFacade planTextBox;
	
	@FindBy(xpath = "//a[contains(@id,'btnCoverageSearchCancel')]")
	private WebElementFacade coverageCancelBtn;
	
	@FindBy(xpath = "//a[contains(@id,'_btnRunSearch')]")
	private WebElementFacade coverageFindlBtn;
	
	@FindBy(xpath = "//table[contains(@id,'grdCoverageSearchResults')]")
	private WebElementFacade searchResGrid;
	
	@FindBy(xpath = "//table[contains(@id,'grdCoverageSearchResults')]//a")
	private WebElementFacade covsearchRes;
	
	@FindBy(xpath = "//table[contains(@id,'grdCoverageHistory')]//a")
	private WebElementFacade otherCovsearchRes;
	
	@FindBy(xpath = "//a[contains(@id,'btnCancelNewCoverage')]")
	private WebElementFacade CancelNewCoverageBtn;
	
	@FindBy(xpath = "//a[contains(@id,'btnAddCoverage')]")
	private WebElementFacade addcoverageBtn;
	
	@FindBy(xpath = "//td[contains(text(),'New Coverage')]")
	private WebElementFacade newCovPanel;
	
	@FindBy(xpath = "//input[contains(@title,'Group Number')]")
	private WebElementFacade EditGrpTxtBox;
	
	@FindBy(xpath = "//input[contains(@title,'Subscriber Number')]")
	private WebElementFacade EditSubScribTxtBox;
	
	@FindBy(xpath = "//a[contains(@id,'btnCancelNewCoverage')]")
	private WebElementFacade CancelNewCoverage;
	
	@FindBy(xpath = "//a[contains(@id,'btnAddCoverage')]")
	private WebElementFacade updateNewCoverage;
	
	@FindBy(xpath = "//table[contains(@class,'TaskAction')]")
	private WebElementFacade exceptionPanel;
	
	@FindBy(xpath = "//table[contains(@class,'TaskActionAlert')]//a[contains(text(),'Complete')]")
	private WebElementFacade completeBtn;
	
	@FindBy(xpath = "//table[contains(@class,'TaskAction')]//a[contains(text(),'Continue')]")
	private WebElementFacade continueBtn;
	
	@FindBy(xpath = "//span[contains(@id,'lblStatus')]")
	private WebElementFacade tabStatus;
	
	@FindBy(xpath = "//*[contains(text(),'Services ( Switch to')]//a")
	private WebElementFacade SwitchTo;
	
	@FindBy(xpath = "//input[contains(@id,'_txtSearch')]")
	private WebElementFacade serviceSearchArea;
	
	@FindBy(xpath = "//a[contains(@id,'_btnSearch')]")
	private WebElementFacade serviceSearchBtn;
	
	@FindBy(xpath = "//input[contains(@id,'_txtTodaysCharges')]")
	private WebElementFacade TtlEstmdAmntTxtBox;
	
	@FindBy(xpath = "//table[contains(@id,'_grdCoverageSelected')]//img[contains(@src,'/images/dn.gif')]/..")
	private WebElementFacade clickUpDownArrow;
	
	@FindBy(xpath = "//img[contains(@src,'/images/edit.gif')]/../../preceding-sibling::td[1]")
	private WebElementFacade tbdOrPass;
	
	@FindBy(xpath = "//table[contains(@id,'_grdCoverageSelected')]//a[contains(text(),'TBD')]")
	private WebElementFacade tbd;
	
	@FindBy(xpath = "//table[contains(@id,'_grdCoverageSelected')]//a[contains(text(),'Passed')]")
	private WebElementFacade passed;
	
	@FindBy(xpath = "//div[contains(@id,'_CoverageDetails_divEligResults')]")
	private List<WebElementFacade> eligibilityResPanel;
	
	@FindBy(xpath = "//label[contains(text(),'Unlimited')]/preceding-sibling::input")
	private WebElementFacade unLimChkBox;
	
	@FindBy(xpath = "//input[contains(@id,'txtMaxOutOfPocket')]")
	private WebElementFacade unLimTxtboxVal;
	
	@FindBy(xpath = "//a[contains(@id,'CoverageDetails_btnChangePlan')]")
	private WebElementFacade changePlanNameBtn;
	
	@FindBy(xpath = "//select[contains(@id,'ddlChangePlan')]")
	private WebElementFacade planNameDropDown;
	
	@FindBy(xpath = "//span[contains(@id,'_CoverageDetails_lblPlanName')]")
	private WebElementFacade planName;
	
	@FindBy(xpath = "//input[contains(@id,'CoverageDetails_txtCopay')]")
	private WebElementFacade coPayEditTxtBox;
	
	@FindBy(xpath = "//input[contains(@id,'CoverageDetails_txtCoinsurance')]")
	private WebElementFacade coinsEditTxtBox;
	
	@FindBy(xpath = "//input[contains(@id,'CoverageDetails_txtERCopay')]")
	private WebElementFacade erCopayEditTxtBox;
	
	@FindBy(xpath = "//input[contains(@id,'CoverageDetails_txtDeductible')]")
	private WebElementFacade deductEditTxtBox;
	
	@FindBy(xpath = "//a[contains(@id,'CoverageDetails_btnUpdate')]")
	private WebElementFacade updateBtn;

	
	public void fetchEncounterId1() throws ClassNotFoundException, SQLException, IOException
	{
		Encounter_ID = coverageSteps.getCoverageEncounterID1();
	}
	
	public void fetchEncounterId2() throws ClassNotFoundException, SQLException, IOException
	{
		Encounter_ID = coverageSteps.getCoverageEncounterID2();
	}
	
	public void fetchEncounterId3() throws ClassNotFoundException, SQLException, IOException
	{
		Encounter_ID = coverageSteps.getCoverageEncounterID3();
	}
	
	public void fetchEncounterId4() throws ClassNotFoundException, SQLException, IOException
	{
		Encounter_ID = coverageSteps.getCoverageEncounterID4();
	}
	
	public void clickSearchBtn()
	{
		clickOn(searchTab);
	}
	
	public void enterEncounterID()
	{
		randomNum = generateRandomNum(Encounter_ID.size());
		System.out.println(randomNum);
		System.out.println(Encounter_ID.get(randomNum));
		typeInto(visitSearch,Encounter_ID.get(randomNum));
	}
	
	public void verifyDelIconNotVisibile()
	{
		boolean flag = true;
		if(delMark.size() > 0)
		{
			flag = false;
		}
		Assert.assertTrue("Delete icon is visible before checkout", flag);
	}
	
	public void verifyDelIconVisibile()
	{
		boolean flag = false;
		if(delMark.size() > 0)
		{
			flag = true;
		}
		Assert.assertTrue("Delete icon is visible before checkout", flag);
	}
	
	public int generateRandomNum(int high)
	 {
		Random r = new Random();
		int result = r.nextInt(high);
		return result;
	 }
	
	public void verifyCoveragePlusIconVisible()
	{
		boolean flag = false;
		if(coveragePlus.size() > 0)
		{
			flag = true;
		}
		Assert.assertTrue("coverage plus icon is not visible after checkout", flag);
	}
	
	public void verifyEditIconVisibile()
	{
		boolean flag = false;
		if(pencilIcon.size() > 0)
		{
			flag = true;
		}
		Assert.assertTrue("edit icon icon is not visible before checkout", flag);
	}
	
	public void StoreAllCoverageColVal(DataTable column)
	{
		List<String> list = column.asList(String.class);
		for(int i = 0; i < list.size(); i++)
		{
			getAllUICoverageColValue(list.get(i).toString());
		}
	}
	
	public void verifyCovColValue() throws ClassNotFoundException, SQLException, IOException
	{
		String ID = Encounter_ID.get(randomNum);
		System.out.println(ID);
		CoverageSteps.getCoverageColumnValue(ID);
		
		System.out.println(CoverageSteps.FacilityPlanCodeDB.get(0));
		Assert.assertEquals(facilityPlanCodeUI.replaceAll(" ", "").trim().compareToIgnoreCase(CoverageSteps.FacilityPlanCodeDB.get(0).replaceAll(" ", "").trim()), 0);
		
		System.out.println(CoverageSteps.COBDB.get(0));
		Assert.assertEquals(COBUI.replaceAll(" ", "").trim().compareToIgnoreCase(CoverageSteps.COBDB.get(0).replaceAll(" ", "").trim()), 0);
		
		System.out.println(CoverageSteps.payorGroupCodeDB.get(0));
		Assert.assertEquals(payorGroupCodeUI.replaceAll(" ", "").trim().compareToIgnoreCase(CoverageSteps.payorGroupCodeDB.get(0).replaceAll(" ", "").trim()), 0);

		System.out.println(CoverageSteps.payorPlanNameDB.get(0));
		Assert.assertEquals(payorPlanNameUI.replaceAll(" ", "").trim().compareToIgnoreCase(CoverageSteps.payorPlanNameDB.get(0).replaceAll(" ", "").trim()), 0);
		
		System.out.println(CoverageSteps.subscriberCodeDB.get(0));
		Assert.assertEquals(subscriberCodeUI.replaceAll(" ", "").trim().compareToIgnoreCase(CoverageSteps.subscriberCodeDB.get(0).replaceAll(" ", "").trim()), 0);
		
		System.out.println(CoverageSteps.copayDB.get(0).replaceAll(" ", "").trim().substring(0, 4));
		match = false;
		if(copayUI1.replaceAll(" ", "").trim().contains(CoverageSteps.copayDB.get(0).replaceAll(" ", "").trim().substring(0, 4)) || 
				copayUI2.replaceAll(" ", "").trim().contains(CoverageSteps.copayDB.get(0).replaceAll(" ", "").trim().substring(0, 4)))
		{
			match = true;
		}
		Assert.assertTrue(match);

		System.out.println(CoverageSteps.ERDB.get(0).replaceAll(" ", "").trim().substring(0, 4));
		match = false;
		if(ERUI1.replaceAll(" ", "").trim().contains(CoverageSteps.ERDB.get(0).replaceAll(" ", "").trim().substring(0, 4)) || 
				ERUI2.replaceAll(" ", "").trim().contains(CoverageSteps.ERDB.get(0).replaceAll(" ", "").trim().substring(0, 4)))
		{
			match = true;
		}
		Assert.assertTrue(match);

		System.out.println(CoverageSteps.deductDB.get(0).replaceAll(" ", "").trim().substring(0, 4));
		match = false;
		if(deductUI1.replaceAll(" ", "").trim().contains(CoverageSteps.deductDB.get(0).replaceAll(" ", "").trim().substring(0, 4)) || 
				deductUI2.replaceAll(" ", "").trim().contains(CoverageSteps.deductDB.get(0).replaceAll(" ", "").trim().substring(0, 4)))
		{
			match = true;
		}
		Assert.assertTrue(match);
		
		System.out.println(CoverageSteps.coinsDB.get(0).replaceAll(" ", "").trim().substring(0, 3));
		match = false;
		if(coinsUI1.replaceAll(" ", "").trim().contains(CoverageSteps.coinsDB.get(0).replaceAll(" ", "").trim().substring(0, 3)) || 
				coinsUI2.replaceAll(" ", "").trim().contains(CoverageSteps.coinsDB.get(0).replaceAll(" ", "").trim().substring(0, 3)))
		{
			match = true;
		}
		Assert.assertTrue(match);
		
		System.out.println(CoverageSteps.oopDB.get(0).replaceAll(" ", "").trim().substring(0, 4));
		match = false;
		if(oopUI1.replaceAll(" ", "").trim().contains(CoverageSteps.oopDB.get(0).replaceAll(" ", "").trim().substring(0, 4)) || 
				oopUI2.replaceAll(" ", "").trim().contains(CoverageSteps.oopDB.get(0).replaceAll(" ", "").trim().substring(0, 4)))
		{
			match = true;
		}
		Assert.assertTrue(match);
	}
	
	public void getAllUICoverageColValue(String colName) 
	{
		if(colName.equalsIgnoreCase("COB"))
		{
			COBUI = (String) commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"COB").get(0);
			System.out.println(COBUI);
		}
		else if(colName.equalsIgnoreCase("Code"))
		{
			facilityPlanCodeUI =  (String) commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Code").get(0);	
			System.out.println(facilityPlanCodeUI);
		}
		else if(colName.equalsIgnoreCase("Plan"))
		{
			payorPlanNameUI = (String) commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Plan").get(0);	
			System.out.println(payorPlanNameUI);
		}
		else if(colName.equalsIgnoreCase("Group"))
		{
			payorGroupCodeUI = (String) commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Group").get(0);
			if(payorGroupCodeUI.equals(" "))
			payorGroupCodeUI = null;
			System.out.println(payorGroupCodeUI);
		
		}
		else if(colName.equalsIgnoreCase("Subscriber"))
		{
			subscriberCodeUI = (String) commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Subscriber").get(0);	
			if(subscriberCodeUI.equals(" "))
			subscriberCodeUI = null;	
			System.out.println(subscriberCodeUI);
		}
		else if(colName.equalsIgnoreCase("Copay"))
		{
			copayUI1 = (String) commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Copay").get(0);
			if(copayUI1.equals("$0.00"))
			{
			copayUI1="0.00";
			copayUI2 = null;
			}
			else if(copayUI1.equals(" "))
			copayUI1=null;
			else
			copayUI1 = copayUI1.replace("$","").trim();
			System.out.println(copayUI1);
			System.out.println(copayUI2);
		}
		else if(colName.equalsIgnoreCase("ER"))
		{
			ERUI1 = (String) commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"ER").get(0);
			if(ERUI1.equals("$0.00"))	
			{
			ERUI1="0.00";
			ERUI2 = null;
			}
			else if(ERUI1.equals(" "))
			ERUI1=null;
			else
			ERUI1=ERUI1.replace("$","").trim();
			System.out.println(ERUI1);
			System.out.println(ERUI2);
		}
		else if(colName.equalsIgnoreCase("Deduct"))
		{
			deductUI1 = (String) commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Deduct").get(0);
			if(deductUI1.equals("$0.00"))
			{
			deductUI1="0.00";
			deductUI2 = null;
			}
			else if(deductUI1.equals(" "))
			deductUI1=null;
			else
			deductUI1 = deductUI1.replace("$","").trim();
			System.out.println(deductUI1);
			System.out.println(deductUI2);
		}
		else if(colName.equalsIgnoreCase("Coins"))
		{
			coinsUI1 = (String) commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Coins").get(0);	
			if(coinsUI1.equals("0.00 %"))
			{
			coinsUI1="0.00";
			coinsUI2 = null;
			}
			else if(coinsUI1.equals(" "))
			{
			coinsUI1 = null;
			}
			else
			{
			coinsUI1 = coinsUI1.replace("%","");
			double coinsr = Double.parseDouble(coinsUI1);
			coinsr = coinsr/100;
			coinsUI1 = Double.toString(coinsr);
			}
			System.out.println(coinsUI1);
			System.out.println(coinsUI2);
		}
		else if(colName.equalsIgnoreCase("OOP"))
		{
			oopUI1 = (String) commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"OOP").get(0);	
			if(oopUI1.equals("$0.00") || oopUI1.equals(" "))	
			{
				oopUI1=null;
				oopUI2 = "0.00";
			}
				
			else if( oopUI1.equals("Unlim"))
			{
				oopUI1="9999999.00";
				oopUI2 = null ;
			}
			else	
			{
				oopUI1 = oopUI1.replace("$","").trim();
				oopUI1 = oopUI1.replace(",","").trim();
			}
			System.out.println(oopUI1);
			System.out.println(oopUI2);
		 }
	  }
	
	public void verifyEditedColValue()
	{
			copayUI1 = (String) commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Copay").get(0);
			copayUI1 = copayUI1.replace("$","").trim();
			System.out.println(copayUI1);
		
			ERUI1 = (String) commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"ER").get(0);
			ERUI1=ERUI1.replace("$","").trim();
			System.out.println(ERUI1);
		
			deductUI1 = (String) commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Deduct").get(0);
			deductUI1 = deductUI1.replace("$","").trim();
			System.out.println(deductUI1);
		
			coinsUI1 = (String) commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Coins").get(0);	
			coinsUI1 = coinsUI1.replace("%","");
			double coinsr = Double.parseDouble(coinsUI1);
			coinsr = coinsr/100;
			coinsUI1 = Double.toString(coinsr);
			System.out.println(coinsUI1);
		
			oopUI1 = (String) commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"OOP").get(0);	
			if( oopUI1.equals("Unlim"))
			{
				oopUI1="9999999.00";
				oopUI2 = null ;
			}
			System.out.println(oopUI1);
			System.out.println(oopUI2);
			
			System.out.println(CoverageSteps.copayDB.get(0).replaceAll(" ", "").trim().substring(0, 4));
			match = false;
			if(copayUI1.replaceAll(" ", "").trim().contains(CoverageSteps.copayDB.get(0).replaceAll(" ", "").trim().substring(0, 4)) || 
					copayUI2.replaceAll(" ", "").trim().contains(CoverageSteps.copayDB.get(0).replaceAll(" ", "").trim().substring(0, 4)))
			{
				match = true;
			}
			Assert.assertTrue(match);

			System.out.println(CoverageSteps.ERDB.get(0).replaceAll(" ", "").trim().substring(0, 4));
			match = false;
			if(ERUI1.replaceAll(" ", "").trim().contains(CoverageSteps.ERDB.get(0).replaceAll(" ", "").trim().substring(0, 4)) || 
					ERUI2.replaceAll(" ", "").trim().contains(CoverageSteps.ERDB.get(0).replaceAll(" ", "").trim().substring(0, 4)))
			{
				match = true;
			}
			Assert.assertTrue(match);

			System.out.println(CoverageSteps.deductDB.get(0).replaceAll(" ", "").trim().substring(0, 4));
			match = false;
			if(deductUI1.replaceAll(" ", "").trim().contains(CoverageSteps.deductDB.get(0).replaceAll(" ", "").trim().substring(0, 4)) || 
					deductUI2.replaceAll(" ", "").trim().contains(CoverageSteps.deductDB.get(0).replaceAll(" ", "").trim().substring(0, 4)))
			{
				match = true;
			}
			Assert.assertTrue(match);
			
			System.out.println(CoverageSteps.coinsDB.get(0).replaceAll(" ", "").trim().substring(0, 3));
			match = false;
			if(coinsUI1.replaceAll(" ", "").trim().contains(CoverageSteps.coinsDB.get(0).replaceAll(" ", "").trim().substring(0, 3)) || 
					coinsUI2.replaceAll(" ", "").trim().contains(CoverageSteps.coinsDB.get(0).replaceAll(" ", "").trim().substring(0, 3)))
			{
				match = true;
			}
			Assert.assertTrue(match);
			
			System.out.println(CoverageSteps.oopDB.get(0).replaceAll(" ", "").trim().substring(0, 4));
			match = false;
			if(oopUI1.replaceAll(" ", "").trim().contains(CoverageSteps.oopDB.get(0).replaceAll(" ", "").trim().substring(0, 4)) || 
					oopUI2.replaceAll(" ", "").trim().contains(CoverageSteps.oopDB.get(0).replaceAll(" ", "").trim().substring(0, 4)))
			{
				match = true;
			}
			Assert.assertTrue(match);
	}
	
	public void deleteAllCoverage()
	{
		int size = commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Code").size();
		while(size>0)
		{
			clickOn(crossMark);
			size--;
		}
	}
	
	public void clickRelease() 
	{
		if(release.isVisible())
		{
		clickOn(release);
		}
	}
	
	public void getExistingPlanCode()
	{
		FacilityPlanCodeOnUI = commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Code");
		//for checking
		for(int i = 0 ; i < FacilityPlanCodeOnUI.size(); i++)
			System.out.println(FacilityPlanCodeOnUI.get(i));
	}
	
	public void clickAddCovPlusIcon()
	{
		clickOn(coveragePlusIcon);
	}
	
	public void verifyPayorPlantextBoxVisible()
	{
		Assert.assertTrue("Search payor plan text box is not displayed", planTextBox.isDisplayed());
	}
	
	public void verifyPayorPlantextBoxNotVisible()
	{
		Assert.assertFalse("Search payor plan text box is still getting displayed", planTextBox.isVisible());
	}
	
	public void enterPlanCode()
	{
		System.out.println(FacilityPlanCodeOnUI.get(0));
		typeInto(planTextBox,FacilityPlanCodeOnUI.get(0));
	}

	public void clickCancelBtn()
	{
		clickOn(coverageCancelBtn);
	}
	
	public void clickFindBtn()
	{
		clickOn(coverageFindlBtn);
	}
	
	public void verifySearchResultGrid()
	{
		Assert.assertTrue("Coverage search result grid is visible", searchResGrid.isVisible());
	}
	
	public void clickOnSearchedPlanCode()
	{
		clickOn(covsearchRes);
	}
	
	public void verifyCancelAddBtn()
	{
		Assert.assertTrue("Cancel new coverage button is not visible", CancelNewCoverageBtn.isVisible());
		Assert.assertTrue("Add new coverage button is not visible", addcoverageBtn.isVisible());
	}
	
	public void clickAddNewCoverage()
	{
		clickOn(addcoverageBtn);
	}
	
	public void verifyCoverageAdded()
	{
		int size = commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Code").size();
		boolean flag = false;
		System.out.println(FacilityPlanCodeOnUI.get(0));
		for(int i = 0; i < size; i++)
		{
			if(commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Code").get(i).toString().contains(FacilityPlanCodeOnUI.get(0)))
				flag = true;
		}
		Assert.assertTrue("coverage didn't get added", flag);
	}

	public void verifyCoverageInOther()
	{
		FacilityPlanCodeInOthers = commonMethodsRef.getTableColValue(OtherCoverageRow,OtherCoverageHeader,"Code");
		boolean flag = false;
		System.out.println(FacilityPlanCodeOnUI.get(0));
		System.out.println(FacilityPlanCodeOnUI.get(0).toString());
		for(int i = 0 ; i < FacilityPlanCodeInOthers.size() ; i++)
		{
			if(FacilityPlanCodeInOthers.get(i).toString().contains(FacilityPlanCodeOnUI.get(0).toString()))
				flag = true;
		}
		Assert.assertTrue("Coverage didn't get added to Other coverage grid result after deleting", flag);
	}
	
	public void clickCodeOnOtherPatientCov()
	{
		FacilityPlanCodeInOthers = commonMethodsRef.getTableColValue(OtherCoverageRow,OtherCoverageHeader,"Code");
		clickOn(otherCovsearchRes);
	}
	
	public void verifyCodeAddedFromOtherPatCoverage()
	{
		FacilityPlanCodeOnUI = commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Code");
		boolean flag = false;
		System.out.println(FacilityPlanCodeInOthers.get(0));
		for(int i = 0;i<FacilityPlanCodeOnUI.size();i++)
		{
			if(FacilityPlanCodeOnUI.get(i).toString().contains(FacilityPlanCodeInOthers.get(0).toString()))
			flag = true;
			break;
		}
		Assert.assertTrue("coverage didn't get added to coverage from other patient coverage", flag);
	}
	
	public void updateSetting(String settingName,String settingValue) throws IOException
	{
		navigation.clickfooterSettingsLink();
		navigation.clickITToolsLink();
		navigation.clickFacilitySettingConfiguration();
		selectFromDropdown(searchList,"Code");
		typeInto(searchTextBox,CommonMethods.LoadProperties("facility"));
		clickOn(searchButton);
		clickOn(gridView);
		selectFromDropdown(searchListFacilitySettings,"Setting Name");
		typeInto(searchTextBoxLocations,settingName);
		clickOn(searchButtonLocations);
		edit_text_setting_value(settingName,settingValue);
		navigation.clickMenu("Patient Access");
	}
	
	public void edit_text_setting_value(String SettingName,String value) throws IOException
	{
		if(!SettingValue.getText().equals(value)) 
		{
		withAction().moveToElement(edit_facility_setting).click().build().perform();
		text_setting_value.clear();
		text_setting_value.sendKeys(value);
		update_facility_button.click();
		}
	}
	
	public void clickEditIcon()
	{
		clickOn(pencil);
	}
	
	public void verifyNewCovPanelVisible()
	{
		Assert.assertTrue("New coverage panel is not visible after clicking on edit icon", newCovPanel.isVisible());
	}
	
	public void editGrpAndSubScrib() throws InterruptedException
	{
		typeInto(EditGrpTxtBox,grpnum);
		clickOn(EditSubScribTxtBox);
		waitForWithRefresh();
		//Thread.sleep(5000);
		typeInto(EditSubScribTxtBox,subnum);
	}

	public void clickCancelEditBtn()
	{
		clickOn(CancelNewCoverage);
	}
	
	public void clickUpdateEditBtn()
	{
		clickOn(updateNewCoverage);
	}
	
	public void verifyNewCovPanelNotVisible()
	{
		Assert.assertFalse("New coverage panel is not visible after clicking on edit icon", newCovPanel.isVisible());
	}
	
	public void verifyUpdatedDataInCov()
	{
		boolean flag = false;
		payorGroupCodeUI = commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Group").get(0).toString();
		System.out.println(payorGroupCodeUI);
		subscriberCodeUI = commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Subscriber").get(0).toString();
		System.out.println(subscriberCodeUI);
		if(payorGroupCodeUI.contains(grpnum))
			if(subscriberCodeUI.contains(subnum))
				flag = true;
		Assert.assertTrue("group number or/and subscriber number didn't get updated", flag);
	}
	
	public void verifyExceptionMessage(String msg)
	{
		String exceptionUIMsg = exceptionPanel.getText().toString().trim();
		Assert.assertTrue("exception message didn't appeared", exceptionUIMsg.contains(msg));
	}
	
	public void clickExceptionCompleteBtn()
	{
		clickOn(completeBtn);
	}
	
	public void verifyExceptionMsgWithBtn()
	{
		String exceptionUIMsg = exceptionPanel.getText().toString().trim();
		if(exceptionUIMsg.contains("Exceptions Exist - Are you sure you want to mark the task complete?"))
		{
			Assert.assertTrue("Exception alert warning message didn't get displayed", exceptionUIMsg.contains("Exceptions Exist - Are you sure you want to mark the task complete?"));
			Assert.assertTrue("warning message of Cancel button didn't get displayed", exceptionUIMsg.contains("Cancel"));
			Assert.assertTrue("warning message of Continue button didn't get displayed", exceptionUIMsg.contains("Continue"));
			clickOn(continueBtn);
		}
	}
	
	public void clickExceptionContBtn()
	{
		if(continueBtn.isVisible())
		clickOn(continueBtn);
	}
	
	public void verifycompleteTabStatus() 
	{
		Assert.assertTrue("tab status does not matched", tabStatus.getText().contains("Complete"));
	}
	
	public void verifyTabStatusBlueColor() 
	{
		Assert.assertTrue("tab status color is not Blue", tabStatus.getCssValue("color").contains("rgba(49, 112, 143, 1)"));	
	}
	
	public void verifySelfPay()
	{
		String Payor = commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Payor").get(0).toString();
		Assert.assertTrue("SelfPay plan didn't get added automatically after deleting all covering", Payor.contains("SELF PAY"));
	}
	
	public void verifyServiceAdded() throws ClassNotFoundException, SQLException, IOException
	{
		if(SwitchTo.getText().contains("Admitting"))
		{
			clickOn(SwitchTo);
		}
		if(commonMethodsRef.getTableColValue(hcpcTableRow,hcpcTableHeader, "HCPC").size() < 1)
		{
			hcpcCode = coverageSteps.getHcpcCode();
			randomNum = generateRandomNum(hcpcCode.size());
			typeInto(serviceSearchArea,hcpcCode.get(randomNum) + "|");
			clickOn(serviceSearchBtn);
			ArrayList<String> getHCPCColValues = commonMethodsRef.getTableColValue(hcpcTableRow,hcpcTableHeader, "HCPC");
			Assert.assertTrue(getHCPCColValues.get(0).contains(hcpcCode.get(randomNum)));
			if(commonMethodsRef.getTableColValue(hcpcTableRow,hcpcTableHeader, "Rate").get(0).toString().contains("$0.00"))
			{
			typeInto(serviceSearchArea,"skin");
			clickOn(serviceSearchBtn);
			neccessityPage.clickServiceLink();
			}
		}
		if(completeBtn.isVisible())
		{
		clickOn(completeBtn);
		if(exceptionPanel.getText().toString().trim().contains("Exceptions Exist - Are you sure you want to mark the task complete?"))
		{
			clickOn(continueBtn);
		}
		}
	}
	public void getResidualBal()
	{
		estAmount = TtlEstmdAmntTxtBox.getAttribute("value").toString().replaceAll("$", "").trim();
		System.out.println(estAmount);
	}
	
	public void clickArrow()
	{
		clickOn(clickUpDownArrow);
	}
	
	public void verifyResidualBal()
	{
		System.out.println(estAmount);
		System.out.println(TtlEstmdAmntTxtBox.getAttribute("value").toString().replaceAll("$", "").trim());
		Assert.assertFalse(TtlEstmdAmntTxtBox.getAttribute("value").toString().replaceAll("$", "").trim().equalsIgnoreCase(estAmount));
	}
	
	public void clickTBD()
	{
		clickOn(tbd);
	}
	
	public void clickHyperlink()
	{
		clickOn(tbdOrPass);
	}
	
	public void verifyEligPanelNotVisible()
	{
		System.out.println(eligibilityResPanel.size());
		Assert.assertTrue("Eligibility result panel is visible for account whose eligibility has never been run previously", eligibilityResPanel.size() == 0);
	}
	
	public void clickUnlimitedCheckBox()
	{
		System.out.println(unLimChkBox.isSelected());
		if(!(unLimChkBox.isSelected()))
		clickOn(unLimChkBox);
	}
	
	public void verifyLimitTxtBoxVal(String text)
	{
		System.out.println(unLimTxtboxVal.getAttribute("value"));
		Assert.assertTrue("Limit($) textbox does not contain unlimited text after clicking on unlimited checkbox", unLimTxtboxVal.getAttribute("value").contains(text));
	}
	
	public void verifyLimitTxtBoxDisable()
	{
		System.out.println(unLimTxtboxVal.isEnabled());
		Assert.assertFalse("Limit($) textbox is not disabled", unLimTxtboxVal.isEnabled());
	}
	
	public void editPayorName()
	{
		payorPlanNameUI = planName.getText();
		System.out.println(payorPlanNameUI);
		clickOn(changePlanNameBtn);
		int rndNum = generateRandomNum(planNameDropDown.getSelectOptions().size());
		planNameDropDown.selectByIndex(rndNum);
		payorPlanNameUI =planNameDropDown.getSelectedVisibleTextValue().toString().trim();
		System.out.println(payorPlanNameUI);
	}
	
	public void editInsVal(DataTable dt)
	{
		List<Map<String,String>> field = dt.asMaps(String.class, String.class);
		typeInto(coPayEditTxtBox,field.get(0).get("copay"));
		typeInto(coinsEditTxtBox,field.get(0).get("coins"));
		typeInto(erCopayEditTxtBox,field.get(0).get("ER"));
		typeInto(deductEditTxtBox,field.get(0).get("Deductible"));
	}
	
	public void clickUpdateInsVal()
	{
		clickOn(updateBtn);
	}
	
	public void verifyUpdatedInsFieldVal(DataTable dt)
	{
		System.out.println(commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Plan").get(0));
		Assert.assertTrue(payorPlanNameUI.contains(commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Plan").get(0).toString()));
		payorPlanNameUI = commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Plan").get(0).toString().trim();
		List<Map<String,String>> fieldVal = dt.asMaps(String.class, String.class);
		Assert.assertTrue(commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Copay").get(0).toString().contains(fieldVal.get(0).get("copay")));
		Assert.assertTrue(commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"ER").get(0).toString().contains(fieldVal.get(0).get("ER")));
		Assert.assertTrue(commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Deduct").get(0).toString().contains(fieldVal.get(0).get("Deductible")));
		Assert.assertTrue(commonMethodsRef.getTableColValue(CoverageSelectedRow,CoverageSelectedHeader,"Coins").get(0).toString().contains(fieldVal.get(0).get("coins")));
	}
	
	public void fetchEditedColValue() throws ClassNotFoundException, SQLException, IOException
	{
		String ID = Encounter_ID.get(randomNum);
		System.out.println(ID);
		CoverageSteps.getEditedColumnValue(ID);
	}
	
	
	
	
	}
