package r1.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import cucumber.api.DataTable;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;

public class PayorStatusPage extends BasePage {
	
	ArrayList<String> columnValue;
	R1AccessCommonMethods R1AccessCommonMethodsRef;
	String payorName;
	
	public String payorStatusTableRow = "//*[contains(@id,'PayorStatus_grd')]/tbody/tr";
  	public String payorStatusTablecol = "//*[contains(@id,'PayorStatus_grd')]/tbody/tr/td";
  	public String payorStatusTableHeader = "//*[contains(@id,'PayorStatus_grd')]/tbody/tr[1]/td";
	
	@FindBy(xpath = "//table[contains(@id,'PayorStatus_grd')]//tr")
	private WebElementFacade payorStatusworkListColTitle;
	
	@FindBy(xpath = "//*[contains(@id,'PayorStatus_grd')]/tbody/tr/td[2]//a")
	private List<WebElementFacade> statusColVal;
	
	@FindBy(xpath = "//table[contains(@id,'PayorStatus_grd')]//*[(text()='Active')]")
	private List<WebElementFacade> activeStatusColVal;
	
	@FindBy(xpath = "//table[contains(@id,'PayorStatus_grd')]//*[(text()='Inactive')]")
	private List<WebElementFacade> inactiveStatusColVal;
	
	
	public void verifyPayorStatusWrkLst()
	{
		Assert.assertTrue("user is not in payor status worklist page", payorStatusworkListColTitle.getText().contains("Payor Name"));
	}

	public void verifyPassedColHeader(String colName)
	{
		Assert.assertTrue("Payor Status worklist column header not found", payorStatusworkListColTitle.getText().contains(colName));
	}

	public void verifyColHeader(DataTable dt)
	{
		List<String> list = dt.asList(String.class);
		for(int i = 0; i < list.size(); i++)
		{
			verifyPassedColHeader(list.get(i).toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	public void verifyColValue(String valActive, String valInactive)
	{
		columnValue = R1AccessCommonMethodsRef.getTableColValue(payorStatusTableRow,payorStatusTableHeader,"Status");
		boolean flag = true;
		if(columnValue.size() > 0)
		{
			for(int i = 0 ; i < columnValue.size(); i++)
		{
		if(!(columnValue.get(i).equalsIgnoreCase(valActive) || columnValue.get(i).equalsIgnoreCase(valInactive)))
		{
			flag = false;
		}
		}
		}
		Assert.assertTrue("payor status column value mis matched", flag);
	}
	
	public void verifyStatusValHyperlink()
	{
		for(int i = 1 ; i < activeStatusColVal.size() ; i++)
		{
			Assert.assertTrue("Status Column is not hyperlink", activeStatusColVal.get(i).getTagName().contains("a"));
		}
		for(int i = 1 ; i < inactiveStatusColVal.size() ; i++)
		{
			Assert.assertTrue("Status Column is not hyperlink", inactiveStatusColVal.get(i).getTagName().contains("a"));
		}
	}
	
	public void clickStatusValue(String beforeStatus)
	{
		int statusFound = 0;
		for(int i = 0; i < statusColVal.size() ; i++)
		{
		if(statusColVal.get(i).getText().equalsIgnoreCase(beforeStatus))
		{
			payorName = R1AccessCommonMethodsRef.getTableColValue(payorStatusTableRow,payorStatusTableHeader,"Payor Name").get(i).toString();
			clickOn(statusColVal.get(i));
			statusFound++;
			break;
		}
		}
		if(statusFound < 1)
		{
			clickOn(statusColVal.get(0));
			clickStatusValue(beforeStatus);
		}
	}
		
	@SuppressWarnings("unchecked")
	public void verifyStatusValue(String afterStatus)
	{
		columnValue = R1AccessCommonMethodsRef.getTableColValue(payorStatusTableRow,payorStatusTableHeader,"Payor Name");
		for(int j = 0; j < columnValue.size() ; j++)
		{
			if(columnValue.get(j).equalsIgnoreCase(payorName))
			{
			Assert.assertTrue("status didn't get changed after clicking", statusColVal.get(j).getText().contains(afterStatus));
			String uDate = (R1AccessCommonMethodsRef.getTableColValue(payorStatusTableRow,payorStatusTableHeader,"Update Date").get(j)).toString();
			uDate = uDate.substring(0,8);
			dateCompare(uDate);
			break;
		}
		}
	}
	
	public void dateCompare(String dateToCmp)
	{
		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		String currDate= dateFormat.format(new Date());
		Assert.assertTrue("updated date mis matched", currDate.equalsIgnoreCase(dateToCmp));		
	}
	
	}