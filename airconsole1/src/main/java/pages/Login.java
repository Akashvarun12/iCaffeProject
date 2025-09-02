package pages;


import java.io.IOException;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import util.WebUtil;

public class Login {

	public WebUtil webUtilObj;

	public Login(WebUtil webUtilObj) {

		PageFactory.initElements(webUtilObj.driver, this);
		this.webUtilObj = webUtilObj;
	}

	@FindBy(xpath = "//input[@name='j_username']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='j_password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//input[@id='txtCaptcha']")
	WebElement handleCaptchaTextbox;

	@FindBy(xpath = "//img[@id='imgCaptcha']")
	WebElement handleCaptcha;


	public void validLogin()
	{
		
		webUtilObj.inputValue(userName, "HANSINFO", "User Name Textbox");
		webUtilObj.inputValue(password, "HANSINFO", "Password Textbox");
		webUtilObj.click(loginButton, "Login Button");
	}
	
	
}
