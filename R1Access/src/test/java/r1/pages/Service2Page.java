package r1.pages;


import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import java.util.Random;

public class Service2Page extends BasePage 
{
	Random random = new Random(); 
	R1AccessCommonMethods r1AccessCommonMethod;
	
	
	@FindBy(xpath = "//input[contains(@id,'txtSearch')]")
	
	private WebElementFacade searchTextBox;
	
	@FindBy(xpath = "//a[contains(@id,'btnSearch')]")
	
	private WebElementFacade searchButton;
		
	@FindBy(xpath = "//table[contains(@id,'_grdHCPCSearchResults')]")
	
	private WebElementFacade serviceSearchResults;
	
	
    @FindBy(xpath = "//table[contains(@id,'_grdHCPCSearchResults')]")
	
	private  List<WebElementFacade> clickServiceSearchResults;
	
	
	@FindBy(xpath = "//span[contains(@id,'RdPricingMode')]//input")
	
	private List<WebElementFacade> singleMultipleRadioBtn;
	

	@FindBy(xpath = "//table[contains(@id,'_grdHCPCSearchResults')]//tr//a")
	
	private List<WebElementFacade> clickOnServiceSearchResults;
	
	
    @FindBy(xpath = "//table[contains(@id,'grdHCPCSelected')]//tr[@class='PanelDetail']//a//img[@src='/images/delete.gif']")
	
	private List<WebElementFacade> deleteServices;
	
	
	
	
	
	public void enterCodes(String text)
	{
		typeInto(searchTextBox,text);
	}
	
	
	public void clickOnSearch()
	{
		clickOn(searchButton);
	}
	
	public void verifyServiceSearchResults()
	{		
		Assert.assertTrue("service search results grid is not coming", serviceSearchResults.isDisplayed());		
	}
	
	
	public void verifySingleMultipleRadioBtn()
	{
		Assert.assertTrue("Single Multiple Radio Not Coming ",singleMultipleRadioBtn.size()==2 );
		
	}
	
	
	public void addServicesSearchResults()
	{
		int i = random.nextInt(clickOnServiceSearchResults.size());			
		withAction().moveToElement(clickOnServiceSearchResults.get(i)).click().build().perform();						
	}
	
	
	public void deleteServices()
	{
		
	for(int i=0; i<deleteServices.size();i++)
	{
		System.out.print(i);
		withAction().moveToElement(deleteServices.get(i)).click().build().perform();			
		r1AccessCommonMethod.clickOnCheckOut();				
	}}
	
	
	
	
	public void verifyServiceGridIsNotDisplayed()
	{
		Assert.assertTrue("service search results grid is coming", !serviceSearchResults.isDisplayed());		
	}
	
	
}
