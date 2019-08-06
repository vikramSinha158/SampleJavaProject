package r1.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;

public class CorrectAddressPage extends BasePage {
	
	R1AccessCommonMethods R1AccessCommonMethodsRef;
	public ArrayList<String> colValues;
	public ArrayList<String> columnValue;
	String AccountNum;
	int size;
	
	
	public String ReturnedMailTableRow = "//*[contains(@id,'grdWorklist')]/tbody/tr";
  	public String ReturnedMailTablecol = "//*[contains(@id,'grdWorklist')]/tbody/tr/td";
  	public String ReturnedMailTableHeader = "//*[contains(@id,'grdWorklist')]/tbody/tr[1]/td";
	
	@FindBy(xpath = "//span[@class='subHead']/preceding-sibling::span")
	private WebElementFacade workListTitle;
	
	@FindBy(xpath = "//a[contains(text(),'MRN')]")
	private WebElementFacade MRNCol;
	
	@FindBy(xpath = "//table[contains(@id,'grdWorklist')]//tr")
	private List<WebElementFacade> worklistRecordCount;
	
	@FindBy(xpath = "//a[contains(text(),'Show All')]")
	private WebElementFacade showAll;
	
	@FindBy(xpath = "//a[@class='GBtn']")
	private List<WebElementFacade> workListRecord;
	
	@FindBy(xpath = "//*[contains(@id,'grdWorklist')]//tr")
	private List<WebElementFacade> workListTotalRow;
	
	@FindBy(xpath = "//table[contains(@id,'tblVisits')]//table[contains(@id,'grdGenericList')]//tr")
	private List<WebElementFacade> settlementRecord;
	
	@FindBy(xpath = "//a[contains(@id,'tabsTask')]")
	private List<WebElementFacade> accountDetailMenuLinks;
	
	@FindBy(xpath = "//table[contains(@class,'section-title')]//td[1]")
	private WebElementFacade patTabVerifyMsg;
	
	@FindBy(xpath = "//table[contains(@class,'section-title')]/following-sibling::table[contains(@id,'Table2')]")
	private WebElementFacade patDemographics;
	
	@FindBy(xpath = "//a[contains(@id,'btnAddNew')]")
	private WebElementFacade notePlusIcon;
	
	@FindBy(xpath = "//*[contains(@id,'txtNotes')]")
	private WebElementFacade noteTextBox;
	
	@FindBy(xpath = "//a[contains(@id,'btnAdd')][contains(text(),'Add')]")
	private WebElementFacade noteAddBtn;
	
	@FindBy(xpath = "//*[contains(@id,'dlNotes')]/tbody/tr[1]/td")
	private WebElementFacade notelastLog;
	
	@FindBy(xpath = "//input[contains(@id,'dshAccountLog_imgIcon')]")
	private WebElementFacade logPlusIcon;
	
	@FindBy(xpath = "//table[contains(@class,'section-title')]")
	private WebElementFacade actionLog;
	
	@FindBy(xpath = "//label[contains(text(),'Returned Mail')]/following-sibling::input")
	private WebElementFacade returnedMailChkBox;
	
	@FindBy(xpath = "//a[contains(@id,'btnUpdate')]")
	private WebElementFacade updateBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Release')]")
	private WebElementFacade release;
	
	@FindBy(xpath = "//span[contains(@id,'lblEncounterNum')]")
	private WebElementFacade fetchAccNum;
	
	@FindBy(xpath = "//*[contains(@id,'grdWorklist')]//tr[contains(@class,'tableHeader')]/td[2]")
	private WebElementFacade firstColName;
	
	public void verifyWorkListTitle(String worklist)
	{
		Assert.assertEquals("Worklist title is not matching", workListTitle.getText(), worklist);
	}
	
	public void clickMRNColHeader() 
	{
		clickOn(MRNCol);
	}
	
	public void sorting(String colName)
	{
		R1AccessCommonMethodsRef.verifySorting(ReturnedMailTableRow,ReturnedMailTableHeader,colName);
	}
	
	@SuppressWarnings("unchecked")
	public void verifyPriorBalNotNull(String colName)
	{
		ArrayList<String> valList = R1AccessCommonMethodsRef.getTableColValue(ReturnedMailTableRow, ReturnedMailTableHeader, "colName");
		boolean flag = true;
		int size = valList.size();
		for(int i = 0 ; i < size ; i++)
		{
		if(valList.get(i).toString().equalsIgnoreCase("null") || valList.get(i).toString().equalsIgnoreCase("0"))
		{
		flag = false;
		}
		}
		Assert.assertTrue("Prior Balance column value contains 0 or Null", flag);	
	}
	
	public void verifyWorkListRecordCount(int sz)
	{
		Assert.assertTrue("More than 15 record exists in worklist page", worklistRecordCount.size() > sz);
	}
	
	public void clickRecord() 
	{
		if(showAll.isVisible())
		{
		clickOn(showAll);
		}
		int random = 1+(int)(Math.random() * workListRecord.size());
		clickOn(workListRecord.get(random-1));
	}
	
	public void filterClickRecord(String name,String val) 
	{
		if(showAll.isVisible())
		{
		clickOn(showAll);
		}
		int random = 1+(int)(Math.random() * workListRecord.size());
		R1AccessCommonMethodsRef.ddlWorkListFilter(name,">",val);
		clickOn(workListRecord.get(random-1));
	}
	
	
	
	
	public void verifyAccountDetailMenuLink(String tabName) 
	{
		boolean flag = false;
		for(int i=0;i<accountDetailMenuLinks.size();i++) 
		{
		if(accountDetailMenuLinks.get(i).getText().contains(tabName)) 
		{
		flag = true;
		break;
		}
		}
		Assert.assertTrue("tab is not visible", flag);
	}
	
	public void verifyPatTabAsDefault()
	{
		Assert.assertTrue("Patient tab is not by set as by default", patTabVerifyMsg.getText().contains("Patient Visit and Address"));
	}
		
	public void verifyPatDemoVisible()
	{
		Assert.assertTrue("Patient tab is not by set as by default", patDemographics.isVisible());
	}
	
	public void verifyDataOnSettlementTab()
	{
		Assert.assertTrue("data is not loaded in settlement tab",settlementRecord.size() > 1);
	}
	
	public void addNotes(String text)
	{
		clickOn(notePlusIcon);
		typeInto(noteTextBox,text);
		clickOn(noteAddBtn);
	}
	
	public void verifyAddedNotes(String text)
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		String formattedDate = sdf.format(date).toString().substring(1,10);
		Assert.assertTrue("Notes didn't got added", notelastLog.getText().toString().contains(formattedDate.toString()));
		Assert.assertTrue("Notes didn't got added", notelastLog.getText().toString().contains(text));
	}
	
	public void verifyActionLog()
	{
		if(logPlusIcon.getAttribute("src").contains("plus"))
		clickOn(logPlusIcon);
		Assert.assertTrue("Action Log is not visible", actionLog.getText().contains("Action Log"));
	}
	
	public void clickReturnedMailChkBox()
	{
		clickOn(returnedMailChkBox);
	}
	
	public void clickUpdateBtn()
	{
		clickOn(updateBtn);
	}
	
	public void clickRelease() 
	{
		if(release.isVisible())
		{
		clickOn(release);
		}
	}
	
	public void fetchAccountNum()
	{
		AccountNum = fetchAccNum.getText();
	}
	
	public int WorkLstSize()
	{
		return size = workListTotalRow.size();
	}
	
	@SuppressWarnings("unused")
	public void verifyAccInWrkLst()
	{
		boolean flag = false;
		String colName = firstColName.getText();
		R1AccessCommonMethodsRef.ddlWorkListFilter(colName,"=",AccountNum);
		int siz = WorkLstSize();
		if(siz == 2)
			flag = true;
		Assert.assertTrue("Account not exists in correct address worklist",flag);
	}
}
