package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.WebUtil;

public class ESanchitHome {

	public WebUtil webUtilObj;

	public ESanchitHome(WebUtil webUtilObj) {

		PageFactory.initElements(webUtilObj.driver, this);
		this.webUtilObj = webUtilObj;
	}
	

	@FindBy(xpath = "//select[contains(@id,'docTypeSelect')]")
	List<WebElement> docType;
	
	@FindBy(xpath = "//button[@id='submitDocs']")
	WebElement submit;
	
	public void documentTypeSelect() {
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		webUtilObj.windowHandles("https://www.icegate.gov.in/esanchit/home");
		
		for (WebElement ele : docType) {
			webUtilObj.selectByVisibleText(ele, "001003-Blood Analysis Report");
		}
		
		
		
		
	}
	
	public void documentTypeSubmit() {
		
		
		
		webUtilObj.click(submit, "submit");
		
	}
	
	
}
