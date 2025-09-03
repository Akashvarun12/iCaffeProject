package icaffetestcases;

import org.testng.annotations.Test;

import basetest.BaseTest;
import basetest.BaseTestForLogin;
import login.ApplicationLogin;
import webutil.ExcelDataSuplier;
import webutil.WebUtil;

public class DemoVtigerTestcase extends BaseTestForLogin {

	private WebUtil utilObj = new WebUtil();

	
//	@Test(priority = 1)
	public void verifyLoginPageWithValidCredential() {
		utilObj.generateExtentTest("verifyLoginPageWithValidCredential");
		utilObj.launchBrowser("chromebrowser");
		utilObj.openURL("http://localhost:8888/");
		ApplicationLogin appLoObj = new ApplicationLogin(utilObj);
		appLoObj.verifyLoginPage("vtiger CRM 5 - Commercial Open Source CRM", "http://localhost:8888/");
		appLoObj.enterLoginCreadential("admin","admin");
		String actUserNameText = appLoObj.verifyTextBoxCredential("user_name");
		utilObj.verifyTextValue(actUserNameText, "admin");
		String actPassText = appLoObj.verifyTextBoxCredential("user_password");
		utilObj.verifyTextValue(actPassText, "admin");
		String actLoginBTText = appLoObj.verifyTextBoxCredential("Login");
		utilObj.verifyTextValue(actLoginBTText, "  Login  ");
		appLoObj.clickOnLoginBT();
		utilObj.verifyGetTitle("admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM");
		utilObj.quite();
		utilObj.flush();

	}

	@Test(priority = 2,dataProvider = "ReadDataFromExcel",dataProviderClass = ExcelDataSuplier.class)
	public void verifyLoginPageWithInValidCredential(String userName,String password) {
		utilObj.generateExtentTest("verifyLoginPageWithInValidCredential");
		utilObj.launchBrowser("chromebrowser");
		utilObj.openURL("http://localhost:8888/");
		ApplicationLogin appLoObj = new ApplicationLogin(utilObj);
		appLoObj.verifyLoginPage("vtiger CRM 5 - Commercial Open Source CRM", "http://localhost:8888/");
		appLoObj.enterLoginCreadentialFromDataProvider(userName, password);
		String actUserNameText = appLoObj.verifyTextBoxCredential("user_name");
		utilObj.verifyTextValue(actUserNameText, userName);
		String actPassText = appLoObj.verifyTextBoxCredential("user_password");
		utilObj.verifyTextValue(actPassText, password);
		String actLoginBTText = appLoObj.verifyTextBoxCredential("Login");
		utilObj.verifyTextValue(actLoginBTText, "  Login  ");
		appLoObj.clickOnLoginBT();
		String message = appLoObj.verifyMessageOfEnteringInavlidCredential();
		utilObj.verifyTextValue(message, "You must specify a valid username and password.");
		utilObj.quite();
		utilObj.flush();

	}

//	@Test(priority = 3)
	public void verifyLoginPageColorTheme() {
		utilObj.generateExtentTest("verifyLoginPageColorTheme");
		utilObj.launchBrowser("chromebrowser");
		utilObj.openURL("http://localhost:8888/");
		ApplicationLogin appLoObj = new ApplicationLogin(utilObj);
		appLoObj.verifyLoginPage("vtiger CRM 5 - Commercial Open Source CRM", "http://localhost:8888/");
		appLoObj.enterLoginCreadential("admin", "admin");
		String actUserNameText = appLoObj.verifyTextBoxCredential("user_name");
		utilObj.verifyTextValue(actUserNameText, "admin");
		String actPassText = appLoObj.verifyTextBoxCredential("user_password");
		utilObj.verifyTextValue(actPassText, "admin");
		String defaultselectedColorTheme = appLoObj.verifyColorThemeDD();
		utilObj.verifyTextValue(defaultselectedColorTheme, "softed");
		appLoObj.selectColorThemeDD("bluelagoon");
		String selectedColorTheme = appLoObj.verifyColorThemeDD();
		utilObj.verifyTextValue(selectedColorTheme, "bluelagoon");
		String actLoginBTText = appLoObj.verifyTextBoxCredential("Login");
		utilObj.verifyTextValue(actLoginBTText, "  Login  ");
		appLoObj.clickOnLoginBT();
		utilObj.flush();

	}
}
