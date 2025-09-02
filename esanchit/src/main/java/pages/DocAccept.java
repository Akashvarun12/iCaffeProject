package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.WebUtil;

public class DocAccept {

	
	public WebUtil webUtilObj;

	public DocAccept(WebUtil webUtilObj) {

		PageFactory.initElements(webUtilObj.driver, this);
		this.webUtilObj = webUtilObj;
	}
	

	@FindBy(xpath = "//input[@id='submitDocsConfirm']")
	WebElement docAccept;
	
	
	public void docAccept() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		webUtilObj.click(docAccept, "Accept Button");
	}
	
	
	
}
