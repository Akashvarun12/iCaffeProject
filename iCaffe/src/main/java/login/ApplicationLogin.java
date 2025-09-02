package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webutil.WebUtil;

public class ApplicationLogin {

	private WebUtil utilobj;

	public ApplicationLogin(WebUtil utilobj) {
		this.utilobj = utilobj;
		PageFactory.initElements(utilobj.getDriver(), this);

	}

	@FindBy(xpath = "//input[@name='user_name']")
	public WebElement usernameTB;

	@FindBy(xpath = "//input[@name='user_password']")
	public WebElement passwordTB;

	@FindBy(xpath = "//input[@name='Login']")
	public WebElement signinBT;
	
	@FindBy(xpath = "//select[@name='login_theme']")
	public WebElement verifyLoginTheme;

	@FindBy(xpath = "//font[contains(text(),'You must specify a valid username and password.')]")
	public WebElement message; 

	public void launchAndOpenURL(String URL) {
		utilobj.launchBrowser("chrome");
		utilobj.openURL(URL);
     
	}

	public void verifyLoginPage(String title, String URL) {

		utilobj.verifyGetTitle(title);
		utilobj.verifyCurrentURL(URL);
	}

	public String verifyTextBoxCredential(String xpath) {
		String attText = utilobj.getDriver().findElement(By.xpath("//input[contains(@name,'" + xpath + "')]")).getAttribute("value");
		return attText;
	}

	public void enterLoginCreadential(String userName, String password) {

		utilobj.clear(usernameTB);
		utilobj.sendkeys(usernameTB, userName);
		utilobj.clear(passwordTB);
		utilobj.sendkeys(passwordTB, password);
	}

	public void enterLoginCreadentialFromDataProvider(String userName, String password) {

		utilobj.clear(usernameTB);
		utilobj.sendkeys(usernameTB, userName);
		utilobj.clear(passwordTB);
		utilobj.sendkeys(passwordTB, password);
	}
	
	public void clickOnLoginBT() {

		utilobj.click(signinBT);
	}

	public String verifyMessageOfEnteringInavlidCredential() {
	String msg=	utilobj.getText(message);
	return msg;
	}

	public String verifyColorThemeDD() {
	WebElement colorDDSelectedOption= utilobj.verifyGetFirstSelectedOption(verifyLoginTheme);
	String colorDDSelectedOptionText=colorDDSelectedOption.getText();
	return colorDDSelectedOptionText;
	}
	
	public void selectColorThemeDD(String visibleText) {
		utilobj.selectDropDownByText(verifyLoginTheme, visibleText);

	}
	
}
