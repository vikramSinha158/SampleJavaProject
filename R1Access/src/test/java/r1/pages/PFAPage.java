package r1.pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import r1.commons.BasePage;
import r1.commons.DataAccess;
import r1.commons.databaseconnection.QueryConstantPFA;

public class PFAPage extends BasePage{

	String ansCodeValue;
	QueryConstantPFA queryConstantPFA;
	
	@FindBy(xpath = "//input[contains(@id , 'txtQuestionCode')]")
	private WebElementFacade inputQuesCode;
	
	@FindBy(xpath = "//textarea[contains(@id , 'txtQuestion')]")
	private WebElementFacade inputQues;
	
	@FindBy(xpath = "//input[contains(@id , 'chkActive')]")
	private WebElementFacade isActiveQuestionChkbox;
	
	@FindBy(xpath = "//input[contains(@id , 'btnAdd')]")
	private WebElementFacade addBtn;
	
	@FindBy(xpath = "//span[contains(@id , 'lblQuestionError')]")
	private WebElementFacade quesAddedLbl;
	
	@FindBy(xpath = "//input[contains(@id , 'btnAddNewAnswer')]")
	private WebElementFacade newAnsBtn;
	
	@FindBy(xpath = "//input[contains(@id , 'txtAnswerCode')]")
	private WebElementFacade ansCodeTxtBox;
	
	@FindBy(xpath = "//textarea[contains(@id , 'txtAnswerText')]")
	private WebElementFacade ansTxtBox;
	
	@FindBy(xpath = "//input[contains(@id , 'btnCancelAddNewAnswers')]")
	private WebElementFacade cancelAnsBtn;
	
	@FindBy(xpath = "//input[contains(@id , 'btnAddNewAnswers')]")
	private WebElementFacade addAnsBtn;
	
	@FindBy(xpath = "//span[contains(@id , 'lblPFAAnswers')]")
	private WebElementFacade lblPFAAns;
	
	@FindBy(xpath = "//span[contains(@id , 'lblAnswerError')]")
	private WebElementFacade lblAnsAdded;
	
	@FindBy(xpath = "//input[contains(@id , 'btnAddQuestionAnswer')]")
	private WebElementFacade linkAnsBtn;
	
	@FindBy(xpath = "//input[contains(@id , 'btnCancelLinkAnswer')]")
	private WebElementFacade cancelLinkAnsBtn;
	
	@FindBy(xpath = "//select[contains(@id , 'ddlAnswerList' )]")
	private WebElementFacade ansDropdwnList;
	
	@FindBy(xpath = "//input[contains(@id , 'btnLinkAnswer' )]")
	private WebElementFacade linkNewAnsBtn;
	
	@FindBy(xpath = "//span[contains(@id , 'lblAnswerCode_0')]")
	private WebElementFacade linkedAns;
	
	@FindBy(xpath = "//span[contains(@id , 'lblLinkAnswerError')]")
	private WebElementFacade ansAddedMsg;
	
	@FindBy(xpath = "//input[contains(@id , 'btnUnlinkAnswer')]")
	private WebElementFacade unlinkAnsBtn;
	
	@FindBy(xpath = "//select[contains(@id , 'ddlUnlinkAnswerlist' )]")
	private WebElementFacade unlinkAnsDropdown;
	
	@FindBy(xpath = "//span[contains(@id , 'lblUnlinkAnswerError')]")
	private WebElementFacade unlinkAnsSuccessMsg;
	
	@FindBy(xpath = "//input[contains(@id , 'chkAnswerActive')]")
	private WebElementFacade isActiveAns;
	
	@FindBy(xpath = "//input[@value = 'Unlink Existing Answer']")
	private WebElementFacade unlinkExistingAnsBtn;
	
	@FindBy(xpath = "//span[contains(@id , 'lblQuestion_12')]")
	private WebElementFacade pregnancyQuestion;
	
	@FindBy(xpath = "//table[contains(@id , 'rblYesNo_12')]//input")
	private List<WebElementFacade> pregnancyQuestionAns;
	
	@FindBy(xpath = "//table[contains(@id , 'rblYesNo_12')]//label")
	private List<WebElementFacade> pregnancyQuestionAnsLabel;
	
	
	public void inputPFAQues(String code , String question)
	{
		typeInto(inputQuesCode, code);
		typeInto(inputQues, question);
	}
	
	public void clickIsActiveQuesChkbox()
	{
		clickOn(isActiveQuestionChkbox);
	}
	
	public void clickIsActiveAnsChkbox()
	{
		clickOn(isActiveAns);
	}
	
	public void addQuestion()
	{
		clickOn(addBtn);
	}
	
	public void verifyQuesAddedLabel(String msg)
	{
		Assert.assertTrue(quesAddedLbl.getText().equalsIgnoreCase(msg));
	}
	
	public void clickNewAns()
	{
		clickOn(newAnsBtn);
	}
	
	public void inputAns(String ansCode , String ansText)
	{
		typeInto(ansCodeTxtBox, ansCode);
		typeInto(ansTxtBox, ansText);
		ansCodeValue = ansCode;
	}
	
	public void clickcancelAns()
	{
		clickOn(cancelAnsBtn);
	}
	
	public void clickAddAns()
	{
		clickOn(addAnsBtn);
	}
	
	public void verifyPFAAnsPanel()
	{
		Assert.assertTrue(!lblPFAAns.isVisible());
	}
	
	public void verifyAnsLabelAdded(String info)
	{
		Assert.assertTrue(lblAnsAdded.getText().equalsIgnoreCase(info));
	}
	
	public void clickLinkAns()
	{
		clickOn(linkAnsBtn);
	}
	
	public void clickCancelLinkAns()
	{
		clickOn(cancelLinkAnsBtn);
	}
	
	public void verifyFieldsNotVisible()
	{
		Assert.assertTrue(!linkNewAnsBtn.isVisible());
		Assert.assertTrue(!cancelLinkAnsBtn.isVisible());
		Assert.assertTrue(!ansDropdwnList.isVisible());
	}
	
	public void selectCreatedAns()
	{
		selectFromDropdown(ansDropdwnList, ansCodeValue);
	}
	
	public void clickLinkNewAns()
	{
		clickOn(linkNewAnsBtn);
	}
	
	public void verifyAnsAdded()
	{
		Assert.assertTrue(linkedAns.getText().equals(ansCodeValue));
	}
	
	public void verifyAnsAddedMessage(String messg)
	{
		ansAddedMsg.getText().equalsIgnoreCase(messg);
	}
	
	public void clickUnlinkAns()
	{
		clickOn(unlinkAnsBtn);
	}
	
	public void selectAnstoUnlink()
	{
		selectFromDropdown(unlinkAnsDropdown, ansCodeValue);
	}
	
	public void clickUnlinkExistingAns()
	{
		clickOn(unlinkExistingAnsBtn);
	}
	
	public void verifyAnsUnlinked(String mesg)
	{
		Assert.assertTrue(unlinkAnsSuccessMsg.getText().equalsIgnoreCase(mesg));
	}
	
	public void verifyAnsRemoved()
	{
		Assert.assertTrue(!linkedAns.isVisible());
	}
	
	public String runQuery(String queryNo) throws ClassNotFoundException, IOException, SQLException
	{
		if(queryNo.equals("PFA_419028_SQL10"))
		{
			String query = queryConstantPFA.PFA_419028_SQL10();
			return DataAccess.getEncounterId("EncounterID", query);
		}
		else if(queryNo.equals("PFA_419029_SQL11"))
		{
			String query = queryConstantPFA.PFA_419029_SQL11();
			return DataAccess.getEncounterId("EncounterID", query);
		}else if(queryNo.equals("PFA_419030_SQL12"))
		{
			String query = queryConstantPFA.PFA_419030_SQL12();
			return DataAccess.getEncounterId("EncounterID", query);
		}
		else return null;
	}
	
	public void verifyAnsweForPregnancy(String ques )
	{
		System.out.println(ques);
		System.out.println(pregnancyQuestion.getText());
		Assert.assertTrue(pregnancyQuestion.getText().equalsIgnoreCase(ques));
		for(int i= 0; i<pregnancyQuestionAns.size() ; i++)
		{
			String status = pregnancyQuestionAns.get(i).getAttribute("checked");
			System.out.println(status);
			if(status.equals("true"))
			{
				Assert.assertTrue(pregnancyQuestionAnsLabel.get(i).getText().equals("No"));;
				System.out.println(pregnancyQuestionAnsLabel.get(i).getText());
				break;
			}
			
		}
	}
	
	public void verifyNoAnswerSelectedforPregnancy(String ques )
	{
		int count = 0;
		System.out.println(ques);
		System.out.println(pregnancyQuestion.getText());
		Assert.assertTrue(pregnancyQuestion.getText().equalsIgnoreCase(ques));
		for(int i= 0; i<pregnancyQuestionAns.size() ; i++)
		{
			String status = pregnancyQuestionAns.get(i).getAttribute("checked");
			if(status.equals("true"))
			{
				count++;
				break;
			}
			
			if(count>0)
			{
				Assert.assertTrue(false);
			}else
				Assert.assertTrue(true);	
		}
	}
	
	
	

	
	
	
}

