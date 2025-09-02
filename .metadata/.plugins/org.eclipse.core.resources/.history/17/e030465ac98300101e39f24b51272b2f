package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.WebUtil;

public class LocationForm {

	
	
	
	public WebUtil webUtilObj;

	public LocationForm(WebUtil webUtilObj) {

		PageFactory.initElements(webUtilObj.driver, this);
		this.webUtilObj = webUtilObj;
	}
	
	@FindBy(xpath = "//select[@name='d_location']")
	WebElement locationDD;
	
	@FindBy(xpath = "//select[@name='d_transport']")
	WebElement modeDD;
	
	@FindBy(xpath = "//input[@id='CmdSubmit']")
	WebElement loginBT;
	
	public void fillUpLocationForm() {
		webUtilObj.selectByVisibleText(locationDD, "Delhi Air Cargo");
		webUtilObj.selectByVisibleText(modeDD, "Air");
		webUtilObj.click(loginBT, "Login Button");
	}
	
	
	
	
}
