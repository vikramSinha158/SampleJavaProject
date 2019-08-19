package r1.pages;

import static org.junit.Assert.assertFalse;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.javascript.host.Set;
import com.ibm.icu.text.SimpleDateFormat;

import cucumber.api.java.it.Date;
import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.commons.databaseconnection.QueryConstantCwl;


public class CWLPage extends BasePage {
	String encounterId;
	R1AccessCommonMethods common;
	QueryConstantCwl cwlQuery;
	LocalDateTime myDateObj=LocalDateTime.now();
	
	public String followUpWorklistRow = "//*[contains(@id,'grdWorklist')]/tbody/tr";
  	public String followUpWorklistHeader = "//*[contains(@id,'grdWorklist')]/tbody/tr[1]/td";
  	
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
	
	@FindBy(xpath="//span[text()='I/S at Risk']")
	private WebElementFacade ISRisk;
	
	String[] conversionList = {"Conversion Followup","Pending"," "," "," "," "," "," "," ","On-Deck","at Risk","E/O at Risk","Future Follow Up","Zero Balance","Supervisor Worklist","Care Coverage"," "," ","BSO"};
	
	@FindBy(xpath = "//table[@class='worklistTable']/tbody/tr")
	private List<WebElementFacade> conversionFollowtableRows;
	
	public void click_setting()
	{
		Settings.click();
		
	}
	
	public void submenuList()
	{
		int size=Setting_submenu.size();
		
		
		for(int i=0;i<size;i++)
		{
			String submenu=Setting_submenu.get(i).getText();
			System.out.println(submenu);
		}
		
	}
		public void select_submenu( String menu)
		{
			common.clickSubSideR1HubModulesMenuLink(menu);
			
		}
			public void payorcon_submenu( String menu)
			{
				common.clickSubSideR1HubModulesMenuLink(menu);
			}
			
			
			
			public void settingSubmenuList()
			{
				for(int i=0;i<Setting_submenu.size();i++)
				{
					String submenu=Setting_submenu.get(i).getText();
					System.out.println(submenu);
			}
			}
			
			public void payorConfiglist()
			{
				for(int i=0;i<Setting_submenu.size();i++)
				{
					String submenu=Setting_submenu.get(i).getText();
					System.out.println(submenu);
			}
	}
			
			public void verifyCPMSize()
			{
				int size=conversionPlanList.size();
				System.out.println(size);
				Assert.assertFalse(size==0);
				
			}
	//Test Case 391787:CWL_Verify the filter folders in the worklist
			
			
			// click on patient access
			public void clickOnpatientAccess()
			{
				common.clickFooterR1AccesModulesTab("PATIENT ACCESS");
			}
			public void clickConversionfollowup()
			{
				common.clickSubSideR1HubModulesMenuLink("Conversion Followup");
			}
			
			// Verify Conversion Follow up filter folder lists
			
			public void filterList()
			{

			
				for(int i=0;i<conversionList.length;i++)
				{
					String optionValue=conversionFollowList.get(i).getText();
					if(optionValue.equals(conversionList[i]))
					{
						System.out.println("passed on: " + optionValue);
					}else
					{
						System.out.println("failed on: " + optionValue);
					}
				}
			}
			
			//CWL_Verify records in "I/S at Risk" filter folder
			
			public void clickOnIsRisk()
			{
				ISRisk.click();
			}

			@FindBy(xpath="//table[@class='worklistTable']/tbody/tr[")
			private WebElementFacade beforeXpath;
			
			@FindBy(xpath="]/td[5]/a")
			private WebElementFacade afterXpath;
			
			@SuppressWarnings("deprecation")
			
			// verify PT value on Conversion Followup > I/S at Risk 
			public void conversiontable()
			{
				
				
				 ArrayList<String> ptCol= common.getTableColValue(followUpWorklistRow,followUpWorklistHeader,"PT");
				 for(String i:ptCol)
				 {

					 if((!i.equals("I") || i.equals("S")) && (!i.equals("S") || i.equals("I")))
					 {
						 Assert.assertTrue(false);
						 System.out.println(i+" Pt value is not matching");
					 }else
					 {
						System.out.println(i+" Pt value is matching");
					 }
						 
					
					 System.out.println(i);
				 }
				 
				}
			
			// verify NFU date on Conversion Followup > I/S at Risk 
				public void verifyNfuDt() 
				{
					ArrayList<String> NFUdt= common.getTableColValue(followUpWorklistRow,followUpWorklistHeader,"NFU Dt");
					DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
				    String currentDate = myDateObj.format(myFormatObj); 
				    System.out.println("After formatting: " + currentDate); 
				  	for(String nfudate:NFUdt)
					{
						if(currentDate.compareTo(nfudate)<=0)
								{
							 Assert.assertTrue(false);
								System.out.println(currentDate.compareTo(nfudate));
								}
						else if(nfudate.isEmpty())
						{
							 Assert.assertTrue(true);
						}else
						{
							 Assert.assertTrue(true);
						}
						System.out.println(currentDate.compareTo(nfudate));
						
					} 
					{
						
					}
				}
				
				
				// Verify total balance on Conversion Followup > I/S at Risk  
				public void verifyTotalBal() {
				ArrayList<String> openBal=  common.getTableColValue(followUpWorklistRow,followUpWorklistHeader,"Total Open Bal");
				for(String TotalopenBal:openBal)
				{
					//int result = Integer.parseInt(TotalopenBal);
					double d = Double.parseDouble(TotalopenBal);
					if(d==0)
					{
						 Assert.assertTrue(false);
					}else
					{
						Assert.assertTrue(true);
						System.out.println(d);
					}
				}
				
			}}
