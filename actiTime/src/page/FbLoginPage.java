package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.BasePage;

public class FbLoginPage extends BasePage{
	@FindBy(id="email")
	private WebElement usernameTXB;
	
	@FindBy(id="pass")
	private WebElement passwordTXB;

	public FbLoginPage(WebDriver driver) {
		super(driver);
	}
	public void setUserName(String un){
		log.info("Entering username:"+un);
		usernameTXB.sendKeys(un);
		
		
		verifyElementIsClickable(usernameTXB);
	}
	
	public void setPassword(String pw){
		log.info("Entering password:"+pw);
		passwordTXB.sendKeys(pw);
		
	}   
}
