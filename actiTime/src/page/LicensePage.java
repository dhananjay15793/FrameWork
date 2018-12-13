package page;

import generic.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LicensePage extends BasePage{

	@FindBy(xpath="//b[contains(text(),'actiTIME')]")
	private WebElement productEdition;
	
	public LicensePage(WebDriver driver) {
		super(driver);
	}

	public void compareProductEdition(String eVersion){
		log.info("Expected Version:"+eVersion);
		String aVersion=productEdition.getText();
		log.info("Actual Version:"+aVersion);
		Assert.assertEquals(aVersion,eVersion);
	}
}
