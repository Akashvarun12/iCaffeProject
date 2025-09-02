package util;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtil {

	public WebDriver driver;

	public void launchBrowser(String browserName) {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();

		prefs.put("profile.credentials_enable_service", false);
		prefs.put("profile.password_manager_leak_detection", false);

		options.setExperimentalOption("prefs", prefs);

		if (browserName.equalsIgnoreCase("ChromeBrowser")) {

			driver = new ChromeDriver(options);
			System.out.println(browserName + " Browser open successfully");
		}
		if (browserName.equalsIgnoreCase("EdgeBrowser")) {

			driver = new EdgeDriver();
			System.out.println(browserName + " Browser open successfully");
		}
		if (browserName.equalsIgnoreCase("FirefoxBrowser")) {
			driver = new FirefoxDriver();
			System.out.println(browserName + " Browser open successfully");
		}

		implicitlywait();
		maxmize();

	}

	public File getScreenshotElement(WebElement we) {
		File src = we.getScreenshotAs(OutputType.FILE);
		return src;
	}

	public void openURL(String URL) {
		driver.get(URL);
		System.out.println(URL + " URL Hit successfully");
	}

	public void quit() {
		driver.quit();
		System.out.println("Quit page successfully");
	}

	public String getTitle() {
		String title = driver.getTitle();
		System.out.println(title + " Title Fetch successfully");
		return title;
	}

	public void inputValue(WebElement weEle, String input, String elementName) {
		weEle.sendKeys(input);
		System.out.println(elementName+" "+input + " Enter successfully " );
	}

	public void click(WebElement weEle, String elementName) {
		weEle.click();
		System.out.println("Click successfully " + elementName);
	}

	public void implicitlywait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		System.out.println("Implicitly Wait successfully");
	}

	public void maxmize() {
		driver.manage().window().maximize();
		System.out.println("Maxmize window successfully");
	}
	
	public void getText(WebElement we) {
		String text =we.getText();
		System.out.println(text+"- Text Fetch successfully");
	}

	public void alertAccept() {
		driver.switchTo().alert().accept();
		System.out.println("Alert accept successfully");
	}

	public void alertDismiss() {
		driver.switchTo().alert().dismiss();
		System.out.println("Alert Dissmis successfully");
	}

	public void explicitlyWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void selectByVisibleText(WebElement we,String dropDown) {
		
		Select selObj=	new Select(we);
		selObj.selectByVisibleText(dropDown);
		System.out.println("Select "+dropDown+ " successfully");
	}

	public void scrollByAmount() {
		Actions actObj= new Actions(driver);
		actObj.scrollByAmount(0, 400);
	}
	
	public void scrollByJavaScript() {
		JavascriptExecutor js=	(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
	}
	
	public void windowHandles(String currentUrl) {
		Set <String>  hndlewindow= driver.getWindowHandles();
		
		for (String handle : hndlewindow) {
			driver.switchTo().window(handle);
			String expwindow=driver.getCurrentUrl();
			if(expwindow.equalsIgnoreCase(currentUrl)) {
				
			}
		}
	}
}
