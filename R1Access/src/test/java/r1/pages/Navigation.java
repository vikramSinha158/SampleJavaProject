package r1.pages;

import java.io.IOException;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.utilities.CommonMethods;

public class Navigation extends PageObject {

	@FindBy(xpath = "//a[contains(@id,'LocationChooser_hypLoc')]")
	private WebElementFacade facilityList;
	
	@FindBy(xpath = "//select[contains(@id,'LocationChooser_ddlLocation')]")
	private WebElementFacade facility;
	
	@FindBy(xpath = "//a[contains(@href,'FCC')]")
	private WebElementFacade FCCLink;
	
	@FindBy(xpath = "//a/following-sibling::span[@class='icn']/following-sibling::span")
	private List<WebElementFacade> preRegistrationLink;
	
	@FindBy(xpath = "//span[@class='txt'][text()='Settings']")
	private WebElementFacade settingsLink;
	
	@FindBy(xpath = "//a[@class='footer_nav'][text()='Settings']")
	private WebElementFacade footerSettingsLink;
	
	@FindBy(xpath = "//span[@class='txt'][text()='IT Tools']")
	private WebElementFacade itTools;
	
	@FindBy(xpath = "//span[@class='txt'][text()='FacilitySetting Configuration']")
	private WebElementFacade facilitySettingConfiguration;
	
	@FindBy(xpath = "//span[@class='txt'][text()='Zero Touch Residual Configuration']")
	private WebElementFacade zeroTouchResidualConfiguration;
	
	@FindBy(xpath = "//span[@class='txt'][text()='Service Bus Monitor']")
	private WebElementFacade serviceBusMonitor;
	
	@FindBy(xpath = "//a[contains(@id,'hypLogo')]")
	private WebElementFacade r1Logo;
	
	
	public List<WebElementFacade> menuLinks() {
		return preRegistrationLink;
	}
	
	public void clickR1Logo() {
		withAction().moveToElement(r1Logo).click().build().perform();
	}
		
	public void clickMenu(String menuName) {
		for(int i=0;i<preRegistrationLink.size();i++) {
			if(preRegistrationLink.get(i).getText().equalsIgnoreCase(menuName)) {
				withAction().moveToElement(preRegistrationLink.get(i)).click().build().perform();
				break;
			}
		}
	}
	
	public void selectFacility() throws IOException {
		CommonMethods.selectListByContains(facility);
	}
	
	public void clickFacilityList() throws InterruptedException {
		clickOn(facilityList);
	}
	
	public void selectFacility(String text) {
		selectFromDropdown(facility,text);
	}
	
	public void clickFCCLink() {
		withAction().moveToElement(FCCLink).click().build().perform();
	}
	
	public void clickSettingsLink() {
		withAction().moveToElement(settingsLink).click().build().perform();
	}
	
	public void clickfooterSettingsLink() {
		withAction().moveToElement(footerSettingsLink).click().build().perform();
	}
	
	public void clickITToolsLink() {
		withAction().moveToElement(itTools).click().build().perform();
	}
	
	public void clickFacilitySettingConfiguration() {
		withAction().moveToElement(facilitySettingConfiguration).click().build().perform();
	}	
	public void clickZeroTouchResidualConfiguration() {
		withAction().moveToElement(zeroTouchResidualConfiguration).click().build().perform();
	}
		
	public void clickServiceBusMonitor() {
		withAction().moveToElement(serviceBusMonitor).click().build().perform();
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
