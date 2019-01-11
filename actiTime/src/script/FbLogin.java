package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.AutoUtility;
import generic.BaseTest;
import generic.Excel;
import page.FbLoginPage;

public class FbLogin extends BaseTest{
	@Test
	public void testFbLogin() throws Throwable{
		int rowCount=Excel.getRowCount(INPUT_PATH, "FbLogin");
		for(int i=1;i<=rowCount;i++){
			String un=Excel.getCellValue(INPUT_PATH, "FbLogin", i, 0);
			AutoUtility.sleep(3);
			String pw=Excel.getCellValue(INPUT_PATH, "FbLogin", i, 1);
			AutoUtility.sleep(3);
			//enter invalid user name
			FbLoginPage FbLoginPage=new FbLoginPage(driver);
			FbLoginPage.setUserName(un);
			//enter invalid password
			FbLoginPage.setPassword(pw);
		}
	} 
}
