package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.WebUtil;

public class HomePage {

	
	
	public WebUtil webUtilObj;

	public HomePage(WebUtil webUtilObj) {

		PageFactory.initElements(webUtilObj.driver, this);
		this.webUtilObj = webUtilObj;
	}
	
	@FindBy(xpath = "//h5[text()=' Services ']")
	WebElement services;
	
	@FindBy(xpath = "(//button[@class='mat-focus-indicator mat-icon-button mat-button-base'])[17]")
	WebElement eSANCHIT;
	
	@FindBy(xpath = "//a[text()='eSANCHIT']")
	WebElement eSANCHITDD;
	
	@FindBy(xpath = "//button[@id='ym-auto-pop-up-close-button']")
	WebElement popupClose;
	
	
	
	public void HomePageDetails() {
		webUtilObj.click(popupClose, "Handle poop-up");
		webUtilObj.click(services, "Service");
	
		webUtilObj.scrollByJavaScript();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webUtilObj.click(eSANCHIT, "eSANCHIT");
		webUtilObj.click(eSANCHITDD, "eSANCHIT DROPDOWN");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webUtilObj.windowHandles("https://www.icegate.gov.in/esanchit/home");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
