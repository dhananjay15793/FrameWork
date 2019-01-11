package generic;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FWListener  implements ITestListener,IAutoConst{
	public Logger log=Logger.getLogger(this.getClass());
	@Override
	public void onTestFailure(ITestResult result) {
		String fileName=AutoUtility.now();
		String photoPath=SCREENSHOT_PATH+fileName+".png";
		AutoUtility.getScreenShot(photoPath);
		//Reporter.log("Screen Shot taken:"+photoPath,true);
		log.info("Screen Shot taken:"+photoPath);
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
