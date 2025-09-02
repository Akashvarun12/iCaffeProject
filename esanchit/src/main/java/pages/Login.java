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

	@FindBy(xpath = "//input[@id='icegateId']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//button[text()=' LOGIN ']")
	WebElement loginButton;




	public void validLogin()
	{
		
		webUtilObj.inputValue(userName, "VIRGINCARGO", "User Name Textbox");
		webUtilObj.inputValue(password, "Vsdelhi@1024", "Password Textbox");
		webUtilObj.click(loginButton, "Login Button");
	}
	
	
}
