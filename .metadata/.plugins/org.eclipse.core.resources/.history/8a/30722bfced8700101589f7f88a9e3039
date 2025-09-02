package webutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class WebUtil {

	private WebDriver driver;
	private WebUtil utilobj;
	private static ExtentReports extReport;
	private ExtentTest extentTest;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chromebrowser")) {
			setDriver(new ChromeDriver());
			System.out.println("ChromeBrowser launched Sucessfully");
			extentTest.log(Status.INFO, browser + " launched Sucessfully");

		}
		if (browser.equalsIgnoreCase("edgebrowser")) {
			setDriver(new EdgeDriver());
			System.out.println("EdgeBrowser launched Sucessfully");
			extentTest.log(Status.INFO, browser + " launched Sucessfully");
		}
		if (browser.equalsIgnoreCase("firefoxbrowser")) {
			setDriver(new FirefoxDriver());
			System.out.println("FireFoxBrowser launched Sucessfully");
			extentTest.log(Status.INFO, browser + " launched Sucessfully");
		}
		implicitlyWait();
	}

	public static ExtentReports genrateExtentReport() {
		extReport = new ExtentReports();
		SimpleDateFormat simpDtaeFormat = new SimpleDateFormat("dd_MM_yyyy hh_mm_ss a");
		String timeStamp = simpDtaeFormat.format(new Date());
		File folderObj = new File("VtigerResult");
		if (!folderObj.exists()) {
			folderObj.mkdir();
		}
		ExtentSparkReporter extSparkReport = new ExtentSparkReporter("VtigerResult\\" + "vtiger.html" + timeStamp);
		extSparkReport.config().setTheme(Theme.DARK);
		extSparkReport.config().setReportName("Akash varun");
		extReport.attachReporter(extSparkReport);
		return extReport;
	}

	public ExtentTest generateExtentTest(String testName) {
		if (extReport == null) {
			genrateExtentReport();
		}
		extentTest = extReport.createTest(testName);
		return extentTest;
	}

	public void flush() {
		extReport.flush();
	}

	public void openURL(String URL) {

		getDriver().get(URL);
		System.out.println("URL Open Sucessfully");
		extentTest.log(Status.INFO, URL + " Open Sucessfully");
		extentTest.addScreenCaptureFromPath(URL);
	}

	/*
	 * This method will close the page.
	 * 
	 * @param - no parameter
	 * 
	 * @return - no return
	 */
	public void close() {
		try {
			getDriver().close();
			extentTest.log(Status.INFO, "Close page successfully");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Close page not successfully");
			e.printStackTrace();

		}
	}

	/*
	 * This method will quit the all browser.
	 * 
	 * @param - no parameter
	 * 
	 * @return - no return
	 */
	public void quite() {
		try {
			getDriver().quit();
			extentTest.log(Status.INFO, "Quit page successfully");
		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Quit page not successfully");
			e.printStackTrace();

		}
	}

	public void sendkeys(WebElement we, String value) {
		we.sendKeys(value);
		System.out.println(value + " Enter Sucessfully");
		extentTest.log(Status.INFO, value + " Enter Sucessfully");
		extentTest.addScreenCaptureFromPath(value);
	}

	public void clear(WebElement we) {
		we.clear();
		System.out.println("Clear Sucessfully");
		extentTest.log(Status.INFO, " clear Text Sucessfully");

	}

	public void click(WebElement we) {
		we.click();
		System.out.println("Click Sucessfully");
		extentTest.log(Status.INFO, " clicked Sucessfully");

	}

	public String getText(WebElement we) {
		String elementText = we.getText();
		System.out.println("Get Text Sucessfully");
		extentTest.log(Status.INFO, " Get Text Sucessfully");
		extentTest.addScreenCaptureFromPath(elementText);

		return elementText;

	}

	// -------------------------------------------------------------------------------------------

	public void verifyGetTitle(String expTitle) {
		String acttitle = getDriver().getTitle();
		if (expTitle.equalsIgnoreCase(acttitle)) {
			System.out.println("Passed " + acttitle + " Match Sucessfully to " + expTitle);
			extentTest.log(Status.PASS, acttitle + " Match Sucessfully to " + expTitle);
		} else {
			System.out.println("Failed " + acttitle + " Not Match Sucessfully to " + expTitle);
			extentTest.log(Status.FAIL, acttitle + " Not Match Sucessfully to " + expTitle);
			extentTest.addScreenCaptureFromPath(acttitle);
		}

	}

	public void verifyCurrentURL(String expURL) {
		String actURL = getDriver().getCurrentUrl();
		if (expURL.equalsIgnoreCase(actURL)) {
			System.out.println("Passed " + actURL + " Match Sucessfully to " + expURL);
			extentTest.log(Status.PASS, actURL + " Match Sucessfully to " + expURL);
		} else {
			System.out.println("Failed " + actURL + " Not Match Sucessfully to " + expURL);
			extentTest.log(Status.FAIL, actURL + " Not Match Sucessfully to " + expURL);
			extentTest.addScreenCaptureFromPath(actURL);
		}

	}

	public String getAttribute(WebElement we, String attributeValue) {
		String elementText = we.getAttribute(attributeValue);
		System.out.println("Get Attribute Text Sucessfully");
		extentTest.log(Status.INFO, " Get Attribute Text Sucessfully");
		return elementText;
	}

	public void verifyTextValue(String actText, String expText) {
		if (expText.equalsIgnoreCase(actText)) {
			System.out.println("Passed ' " + actText + " '  Match Sucessfully to ' " + expText + " '");
			extentTest.log(Status.PASS, actText + " '  Match Sucessfully to ' " + expText + " '");
		} else {
			System.out.println("Failed ' " + actText + " ' Not Match Sucessfully to ' " + expText + " '");
			extentTest.log(Status.FAIL, actText + " ' Not Match Sucessfully to ' " + expText + " '");
			extentTest.addScreenCaptureFromPath(actText);
		}

	}

	public WebElement verifyGetFirstSelectedOption(WebElement we) {

		Select selObj = new Select(we);
		WebElement weColorOption = selObj.getFirstSelectedOption();
		System.out.println("DropDown Text Fetch Sucessfully");
		extentTest.log(Status.INFO, " DropDown Text Fetch Sucessfully");
		return weColorOption;
	}

	// ----------------------------------------------------------------------------------------------------------------------------

	public void selectDropDownByText(WebElement we, String visibleText) {

		Select selObj = new Select(we);
		selObj.selectByVisibleText(visibleText);
		System.out.println("DropDown Text Selected Sucessfully");
		extentTest.log(Status.INFO, visibleText + " DropDown Text Selected Sucessfully");
	}

	public void implicitlyWait() {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		System.out.println("Implicitly wait Sucessfully");
		extentTest.log(Status.INFO, "Implicitly wait Sucessfully");
	}

	/*
	 * This method will take screenshot.
	 * 
	 * @param - String testcaseimagename
	 * 
	 * @return - String
	 */
	public String takeScreenShot(String testCaseImageName) {
		DateFormat dFormat = new SimpleDateFormat("MM-dd-yyyy hh-mm-ss a");
		String timeStamp = dFormat.format(new java.util.Date());
		TakesScreenshot tssobj = (TakesScreenshot) driver;
		File sourceFile = tssobj.getScreenshotAs(OutputType.FILE);
		File folderobj = new File("SnapshotsFolder");
		if (folderobj.exists() == false) {
			folderobj.mkdir();
		}
		File destinationFile = new File("SnapshotsFolder\\" + testCaseImageName + "" + timeStamp + ".JPG");
		try {
			Files.copy(sourceFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationFile.getAbsolutePath();
	}

	// Read Data from properties file...
	public Properties propertiFile() {
		String path = "C:\\Users\\Dell\\Desktop\\testngproject\\src\\test\\resources\\config.properties";

		Properties properties = null;

		try {
			properties = new Properties();
			FileInputStream fIS = new FileInputStream(path);
			properties.load(fIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
}
