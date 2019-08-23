package r1.commons.utilities;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.*;
import net.thucydides.core.util.*;
import r1.commons.BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class CommonMethods{

	public static void DrpVisibleTxt(WebElementFacade we, String s) {
		Select drp = new Select(we);
		drp.selectByVisibleText(s);
	}
	
	public static String selectRandomList(WebElementFacade element) {
		 Select selectDropdown = new Select(element);
	     List<WebElement> listOptionDropdown = selectDropdown.getOptions();
	     int random = (int)(Math.random() * listOptionDropdown.size()-1)+1;
	     selectDropdown.selectByIndex(random);
	     return selectDropdown.getFirstSelectedOption().getText();
	}
	
	public static String selectListWithContains(WebElementFacade element, String text) {
		Select selectDropdown = new Select(element);
	     List<WebElement> listOptionDropdown = selectDropdown.getOptions();
	     for(int i=0;i<listOptionDropdown.size();i++) {
	    	 if(listOptionDropdown.get(i).getText().contains(text)) {
	    		 selectDropdown.selectByIndex(i);
	    	 }
	     }
	     return selectDropdown.getFirstSelectedOption().getText();
	}
	
	public static int dropDownSize(WebElementFacade list) {
		Select drpList = new Select(list);
		return drpList.getOptions().size();
	}
	
	public static List<WebElement> dropDownValues(WebElementFacade list) {
		Select drpList = new Select(list);
		return drpList.getOptions();
	}

	public static void DrpVal(WebElementFacade we, String s) {
		Select drp = new Select(we);
		drp.selectByValue(s);
	}

	public static void DrpIndex(WebElementFacade we, int i) {
		Select drp = new Select(we);
		drp.selectByIndex(i);
	}

	public class common extends BasePage {
		PageObject page;

		// Click on Ok or accept on Alter message box
		public void HandleAlertsAccept() {
			page.getAlert().accept();
		}

		// Click on Cancel or dismiss on Alert message box
		public void HandleAlertDismiss() {
			page.getAlert().dismiss();
		}

		// Count the number of windows open on the application, switch to those windows
		// and get title of it.
		public void HandleMultipleWindows() {
			String mainWindow = getDriver().getWindowHandle();
			Set<String> handles = getDriver().getWindowHandles();
			int countWindow = handles.size();
			//System.out.println("Total Windows open are" + countWindow);
			for (String windowHandles : handles)
				if (!mainWindow.equals(windowHandles)) {
					getDriver().switchTo().window(windowHandles);
					//System.out.println(getDriver().switchTo().window(windowHandles).getTitle());
				}
		}
		
		public void switchWindow() {
			for(String windowHandles : getDriver().getWindowHandles()) {
				getDriver().switchTo().window(windowHandles);
			}
		}
		
		public void closeWindow() {
			getDriver().close();
		}
		
		public String getWindowTitle() {
			return getDriver().getTitle();
		}
		
		public void DefaultWindow() {
			getDriver().switchTo().defaultContent();
		}
		
		
		// Switch to frame using frame name
		public void FrameSwitchUsingName(WebElementFacade frameName) {
			try {
				getDriver().switchTo().frame(frameName);

			} catch (NoSuchFrameException e) {
				System.out.println(e.getMessage());
			}
		}

		// Switch to frame using frameID
		public void FrameUsingId(int frameId) {
			try {
				getDriver().switchTo().frame(frameId);
			} catch (NoSuchFrameException e) {
				System.out.println(e.getMessage());
			}
		}

		// Count the number of frames present on the page
		public int GetTotalFrameCountInCurrentPage() {
			int ret = 0;
			By byFrameTag = (By) By.tagName("frame");
			List<WebElement> frameList = getDriver().findElements(byFrameTag);
			int frameSize = frameList.size();
			System.out.println("There are " + frameSize + " frame in current web page.");
			By byIFrameTag = (By) By.tagName("iframe");
			List<WebElement> iframeList = getDriver().findElements(byIFrameTag);
			int iframeSize = iframeList.size();
			System.out.println("There are " + iframeSize + " iframe in current web page.");
			ret = frameSize + iframeSize;
			return ret;
		}
		
		public int getElementsSize(String xpath) {
			return getDriver().findElements(By.xpath(xpath)).size();
		}
	}

	/**
	 * 
	 * @Author AmeyaS - Read parameters from serenity.properties file
	 * 
	 */
	public static String LoadProperties(String input) throws IOException {
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		return variables.getProperty(input);
	}

	public static int GetRandom(int all) {
		Random rnd = new Random();
		return rnd.nextInt(all);
	}
	
	public static String queryProperties(String input) throws FileNotFoundException, IOException {
		 Properties prop = new Properties();
		 prop.load(new FileInputStream("src/test/resources/TestData/Query.properties"));
		 return prop.getProperty(input);
	}
	
}
