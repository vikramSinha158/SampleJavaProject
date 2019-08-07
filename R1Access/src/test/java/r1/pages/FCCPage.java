package r1.pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;

public class FCCPage extends BasePage{
	
	
	List<String> fccWorkListAccounts;
	String patientPagevisitNumber;
	
	@FindBy(xpath = "//span[@class='subhead']/span[1]")
	private WebElementFacade fccWorkListTitle;
	
	@FindBy(xpath = "//td[@class='PanelTitle']//td[@class='SubHead']/span")
	private List<WebElementFacade> patientDetailsLabel;
	
	
	@FindBy(xpath = "//span[contains(@id,'lblName')]")
	private List<WebElementFacade> patientDetailsNameLabel;
	
	@FindBy(xpath = "(//td[@class='PanelTitle']//td[@class='SubHead2'])[last()-1]")
	private List<WebElementFacade> patientDetailsAdmitDateLabel;
	
	@FindBy(xpath = "//a[contains(@class,'record-next')]")
	private WebElementFacade rightVCRButton;
	
	@FindBy(xpath = "//td[@class='accountnumber']")
	private List<WebElementFacade> fccWorkListAccountsList;
	
	@FindBy(xpath = "//span[contains(@id,'lblEncounterNum')]")
	private WebElementFacade patientVisit;
	
	@FindBy(xpath = "//li[contains(@class,'TabBGSel')]")
	private WebElementFacade fccTab;
	
	
	
	
	
	
	
	
	
	
	


	
	
	public void verifyFCCWorkListPage() {
		fccWorkListAccounts = new ArrayList<String>();
		for(int i=0;i<fccWorkListAccountsList.size();i++) {
			fccWorkListAccounts.add(fccWorkListAccountsList.get(i).getText());
		}
		Assert.assertEquals("FCC Worklist page title is not matching", "FCC Coverage Workflow", fccWorkListTitle.getText());
	}
	
	public void verifyPatientDetailsLabel() {
		Assert.assertTrue("Patient Name is not appearingon Patient details label", patientDetailsNameLabel.size()>0);
		Assert.assertTrue("Admit Date is not appearingon Patient details label", patientDetailsAdmitDateLabel.size()>0);
		Assert.assertEquals("DOB Label is not verified", "DOB:",patientDetailsLabel.get(0).getText());
		Assert.assertEquals("SSN Label is not verified", "SSN:",patientDetailsLabel.get(1).getText());
		Assert.assertEquals("MR Label is not verified", "MR#:",patientDetailsLabel.get(2).getText());
		Assert.assertEquals("VISIT Label is not verified", "Visit#:",patientDetailsLabel.get(3).getText());
		Assert.assertEquals("PT Label is not verified", "PT:",patientDetailsLabel.get(4).getText());
		Assert.assertEquals("SERV Label is not verified", "Serv:",patientDetailsLabel.get(5).getText());
		Assert.assertEquals("LOC Label is not verified", "Loc:",patientDetailsLabel.get(6).getText());
	}
	
	public void clickRightVCRButton() {
		patientPagevisitNumber = patientVisit.getText();
		clickOn(rightVCRButton);
		Assert.assertTrue("Next Account FCC is not display",!patientPagevisitNumber.equals(patientVisit.getText()) && fccWorkListAccounts.contains(patientVisit.getText()) && fccTab.getText().equals("FCC"));
	}
	
	
	
	
	

}
