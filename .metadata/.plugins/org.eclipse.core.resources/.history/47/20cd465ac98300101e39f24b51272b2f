package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.WebUtil;

public class Logout {

	public WebUtil webUtilObj;

	public Logout(WebUtil webUtilObj) {

		PageFactory.initElements(webUtilObj.driver, this);
		this.webUtilObj = webUtilObj;
	}
	

	@FindBy(xpath = "//a[@id='logout']")
	WebElement logout;
	
	public void logout() {
		webUtilObj.click(logout, "Logout Sucessfully");
	}
}
