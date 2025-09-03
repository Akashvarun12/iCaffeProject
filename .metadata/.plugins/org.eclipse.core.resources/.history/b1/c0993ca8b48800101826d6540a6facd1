package demobasetest;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class BaseTest {
	protected WebUtil utilObj ;

	
	@DataProvider
	public Object[][] provideLoginData() {

		 List<Map<String,String>> testData = ExcelDataSuplier.setExcelFile("TestSheet");
		 int dataMapCount=testData.size();
		 Object[][] allData= new Object[dataMapCount][1];
		 for(int i=0;i<=dataMapCount-1;i++) {
			allData[i][0] = testData.get(i);
		 }
		 
	return allData;    
	}


	@BeforeSuite
	public void generatReport() {
		WebUtil.genrateExtentReport();
	}

	@BeforeTest
	public void importFileFromExcel() {

	}

	@BeforeClass
	public void beforeClass() {
//		utilObj.genrateExtentReport();
	}

	@Parameters({"browser","URL", "userName", "password"})
	@BeforeMethod
	public void login(String browser,String url,String userName,String password,  Method testName) {
//		utilObj = WebUtilPage.getObject();
		utilObj.generateExtentTest(testName.getName());
//		Properties pr = utilObj.propertiFile();
//		String urlName = pr.getProperty("url");
		utilObj.launchBrowser(browser);
		utilObj.openURL(url);
//		String userName = pr.getProperty("username");
//		String password = pr.getProperty("password");
//		Login_Page logObj = new Login_Page(utilObj);
//		logObj.loginCredentialAllTestCase(userName, password);
	}

	@AfterMethod
	public void takeScreenShot(ITestResult result, Method testName) throws InterruptedException {
		if (result.getStatus() == ITestResult.FAILURE) {

			String snapShot=utilObj.takeScreenShot(testName.getName());
			utilObj.generateExtentTest(snapShot).addScreenCaptureFromPath(snapShot);
		} 
		utilObj.flush();
		Thread.sleep(1000);
//		Login_Page logObj = new Login_Page(utilObj);
//		logObj.logOut();
		utilObj.quite();

	}

	@AfterSuite
	public void closeBrowser() {
		utilObj.flush();
	}

}
