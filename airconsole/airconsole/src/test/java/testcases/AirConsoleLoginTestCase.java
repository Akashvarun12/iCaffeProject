package testcases;

import org.testng.annotations.Test;

import basepage.BasePage;
import pages.ESanchit;
import pages.HomePage;

public class AirConsoleLoginTestCase extends BasePage {

	@Test
	public void loginTestCase() {



		HomePage homeObj = new HomePage(utilObj);
		homeObj.HomePageDetails();
		ESanchit esanobj = new ESanchit(utilObj);
		esanobj.eSanchitHome();
	}

}
