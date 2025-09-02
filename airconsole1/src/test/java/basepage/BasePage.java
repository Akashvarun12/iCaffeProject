package basepage;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import net.sourceforge.tess4j.TesseractException;
import pages.Login;
import util.WebUtil;

public class BasePage {

	protected WebUtil utilObj = new WebUtil();
	
	@BeforeSuite
	public void beforeSuit() {
		
		
	}
	
	@BeforeClass
	public void beforeClass() {

		utilObj.launchBrowser("ChromeBrowser");
		utilObj.openURL("http://www.airconsol.com:8080/airconsol/secureAdmin/Consol/air/jsp/login_air.jsp");
		
	}
	@BeforeMethod
	public void beforeMethod() throws IOException, TesseractException, InterruptedException {
		
		Login log=new Login(utilObj);
		log.validLogin();
		
		
	}
	@AfterMethod
	public void afterMethod() {
		
		//utilObj.quit();
	}
	
	@AfterClass
	public void afterClass() {
		
		
	}
	@AfterSuite
	public void afterSuit() {
		
	//	utilObj.quit();
	}
	
}
