package generic;

import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage implements IAutoConst{
	public WebDriver driver;
	public long lngETO;
	public Logger log;
	
	public WebDriverWait wait;
	
	@FindBy(id="logoutLink")
	public WebElement logoutLNK;
	
	public BasePage(WebDriver driver){
		this.driver=driver;
		String strETO=AutoUtility.getPropertyValue(CONFIG_PATH,"ETO");
		lngETO=Long.parseLong(strETO);
		wait=new WebDriverWait(driver,lngETO);
		log=Logger.getLogger(this.getClass());
		PageFactory.initElements(driver,this);
	}
	
	public void clickLogout(){
		log.info("Clicking on logout");
		AutoUtility.sleep(2);
		logoutLNK.click();
	}
	
	public void verifyTitle(String eTitle){
		log.info("Expected Title:"+eTitle);
		try
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			log.info("Title is matching");
		}
		catch(Exception e)
		{
			String aTitle=driver.getTitle();
			log.info("Actual Title:"+aTitle);
			log.info("Title is NOT matching");
			Assert.fail();
		}
	}
	
	public void verifyElementIsPresent(WebElement element){
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			log.info("Element is Present");
		}
		catch(Exception e)
		{
			log.info("Element is Not Present");
			Assert.fail();
		}
	}
	
	public void EnterText(WebElement element){
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			log.info("Element is Present");
		}
		catch(Exception e)
		{
			log.info("Element is Not Present");
			Assert.fail();
		}
	}
	
	public void ClickElement(WebElement element){
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.withTimeout(lngETO,TimeUnit.SECONDS);
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			log.info("Click element");
		}
		catch(Exception e)
		{
			log.info("Unable to Click element");
			Assert.fail();
		}
	}
	
	
	
	
	public void verifyElementIsClickable(WebElement element){
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.withTimeout(lngETO,TimeUnit.SECONDS);
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
			log.info("Element is Clickable");
		}
		catch(Exception e)
		{
			log.info("Element is Not Clickable");
			Assert.fail();
		}
	}
}
