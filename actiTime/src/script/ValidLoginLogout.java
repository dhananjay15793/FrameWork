package script;

import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Excel;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLoginLogout extends BaseTest{
	@Test(priority=1)
	public void testValidLoginLogout(){
		String un=Excel.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 0);
		String pw=Excel.getCellValue(INPUT_PATH, "ValidLoginLogout", 1,1);
		String HPT=Excel.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 2);
		String LPT=Excel.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 3);
		//enter valid user name
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
		//enter valid password
		loginPage.setPassword(pw);
		//click on login
		loginPage.clickLogin();
		//verify that home page is displayed
		EnterTimeTrackPage ettPage=new EnterTimeTrackPage(driver);
		ettPage.verifyTitle(HPT);
		//click on logout
		ettPage.clickLogout();
		//verify that login page is displayed
		loginPage.verifyTitle(LPT);
	}
}





