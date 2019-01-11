package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.AutoUtility;
import generic.BasePage;

public class LoginPage extends BasePage{
	

	@FindBy(id="username")
	private WebElement usernameTXB;
	
	@FindBy(name="pwd")
	private WebElement passwordTXB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	
	@FindBy(xpath="//nobr[contains(text(),'actiTIME')]")
	private WebElement version;
	
	public WebElement getLoginBTN() {
		return loginBTN;
	}


	public void setLoginBTN(WebElement loginBTN) {
		this.loginBTN = loginBTN;
	}

	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errMsg;
	
	public LoginPage(WebDriver driver) {
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
	
	public void clickLogin(){
		log.info("Clicking on login");
		loginBTN.click();
	}
	
	public String getVersion(){
		String strVersion=version.getText();
		log.info("Version is:"+strVersion);
		return strVersion;
	}
	
	public void verifyErrMsgIsDisplayed(){
		log.info("verify Error Message Is Displayed");
		AutoUtility.sleep(2);
		verifyElementIsPresent(errMsg);
	}
}




