package script;

import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Excel;
import page.EnterTimeTrackPage;
import page.LicensePage;
import page.LoginPage;

public class VerifyProductEdition extends BaseTest{
 @Test(priority=3)
 public void testProductEdition()
 {
	 	String un=Excel.getCellValue(INPUT_PATH,"VerifyProductEdition",1,0);
		String pw=Excel.getCellValue(INPUT_PATH,"VerifyProductEdition",1,1);
		String LPT=Excel.getCellValue(INPUT_PATH,"VerifyProductEdition",1,2);
		//Get the version
		LoginPage loginPage=new LoginPage(driver);
		String version=loginPage.getVersion();
		//enter valid user name
		loginPage.setUserName(un);
		//enter valid password
		loginPage.setPassword(pw);
		//click on login
		loginPage.clickLogin();
		//click Settings
		EnterTimeTrackPage ettPage=new EnterTimeTrackPage(driver);
		ettPage.clickSettings();
	    //click Licenses 
		ettPage.clickLicenses();
		//verify that Licenses page is displayed
		LicensePage licensePage=new LicensePage(driver);
		licensePage.verifyTitle(LPT);
		//verify Product Edition is same as version
		licensePage.compareProductEdition(version);
		//click on logout
		ettPage.clickLogout();
 }
}






