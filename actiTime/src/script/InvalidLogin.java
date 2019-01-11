package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidLogin extends BaseTest{
	@Test(priority=2)
	public void testInvalidLogin(){
		int rowCount=Excel.getRowCount(INPUT_PATH, "InvalidLogin");
		for(int i=1;i<=rowCount;i++){
			String un=Excel.getCellValue(INPUT_PATH, "InvalidLogin", i, 0);
			String pw=Excel.getCellValue(INPUT_PATH, "InvalidLogin", i, 1);
			//enter invalid user name
			LoginPage loginPage=new LoginPage(driver);
			loginPage.setUserName(un);
			//enter invalid password
			loginPage.setPassword(pw);
			//click on login
			loginPage.clickLogin();
			//verify err msg is displayed
			loginPage.verifyErrMsgIsDisplayed();
		}
	}

}
