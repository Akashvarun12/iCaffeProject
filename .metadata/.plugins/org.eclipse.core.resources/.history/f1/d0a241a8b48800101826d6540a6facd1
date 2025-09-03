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

public class BaseTestForLogin {


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
	//		utilObj = WebUtilPage.getObject();
		}

		@Parameters({"browser","URL"})
		@BeforeMethod
		public void login(String browser,String url,  Method testName) {
//			utilObj = WebUtilPage.getObject();
			utilObj.generateExtentTest(testName.getName());

			utilObj.launchBrowser(browser);
			utilObj.openURL(url);

		}

		@AfterMethod
		public void takeScreenShot(ITestResult result, Method testName) throws InterruptedException {
			if (result.getStatus() == ITestResult.FAILURE) {
		
				utilObj.takeScreenShot(testName.getName());
			}
			Thread.sleep(1000);
//			Login_Page logObj = new Login_Page(utilObj);
//			logObj.logOut();
			utilObj.quite();
			utilObj.flush();

		}

		@AfterSuite
		public void closeBrowser() {
			utilObj.flush();
		}

	}


