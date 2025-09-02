package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepage.BasePage;
import pages.LocationForm;

public class AirConsoleLoginTestCase extends BasePage {

	@Test
	public void loginTestCase() {

		String actLoctionFormTitle = utilObj.getTitle();
		String expLoctionFormTitle = "Welcome to Hans Infomatics (P) Ltd";
		Assert.assertEquals(actLoctionFormTitle, expLoctionFormTitle);

		LocationForm locationObj = new LocationForm(utilObj);
		locationObj.fillUpLocationForm();
	}

}
