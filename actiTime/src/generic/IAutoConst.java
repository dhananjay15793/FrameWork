package generic;

public interface IAutoConst {
	String CHROME_KEY="webdriver.chrome.driver";
	String CHROME_VALUE="./driver/chromedriver.exe";
	String CHROME_VALUE_LINUX="/home/dhananjaykumar/Downloads/chromedriver";
	
	String GECKO_KEY="webdriver.gecko.driver";
	String GECKO_VALUE="./driver/geckodriver.exe";
	
	String SCREENSHOT_PATH="./screenshot/";
	String INPUT_PATH="./data/input.xlsx";
	String CONFIG_PATH="./config.properties";
}
/* all the variables in interface are by default
 * public static final
 */