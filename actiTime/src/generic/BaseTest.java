package generic;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Listeners(FWListener.class)
 public class BaseTest implements IAutoConst {
	public WebDriver driver;
	public String strURL;
	public long lngITO;
	public Logger log = Logger.getLogger(this.getClass());
	
	@BeforeSuite
	public void initFrameWork(){
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void openApp(@Optional("chrome") String browser){
		if(browser.equals("chrome")){
			driver=new ChromeDriver();
			log.info("Opening Chrome Browser");
		}
		else{
			driver=new FirefoxDriver();
			log.info("Opening Firefox Browser");
		}
		
		strURL=AutoUtility.getPropertyValue(CONFIG_PATH,"URL");
		driver.get(strURL);
		log.info("Enter the URL:"+strURL);
		String strITO=AutoUtility.getPropertyValue(CONFIG_PATH,"ITO");
		log.info("Set ImplicitWait:"+strITO);
		lngITO=Long.parseLong(strITO);
		driver.manage().timeouts().implicitlyWait(lngITO,TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeApp(){
		driver.quit();
		log.info("Close the Browser");
	}
}
