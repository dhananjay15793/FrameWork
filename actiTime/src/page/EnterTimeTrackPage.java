package page;

import generic.AutoUtility;
import generic.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EnterTimeTrackPage extends BasePage {
	@FindBy(xpath="(//div[contains(text(),'Settings')])[1]")
	private WebElement settings;
	
	@FindBy(linkText="Licenses")
	private WebElement licenses;
	
	public EnterTimeTrackPage(WebDriver driver) {
		super(driver);
		
	}

	public void clickSettings(){
		log.info("Clicking on Settings");
		AutoUtility.sleep(2);
		settings.click();
	}
	
	public void clickLicenses(){
		log.info("Clicking on licenses");
		licenses.click();
	}
}
