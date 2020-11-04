package drive.tests;

import com.framework.handlers.ActionHandler;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.framework.reports.ReportBuilder;

import com.framework.test.BaseTest;

import drive.basetest.BasePageTest;
import pages.BasePage;

import static pageobjects.DrivingObjects.*;

public class SarathiPage extends BasePageTest {

	private static Logger logger = LogManager.getLogger(BaseTest.class);

	@Test
	@Parameters({ "environment" })
	public void verifyClosePregnancyForPregnancyOutcomeAsMiscarriage(String environment) {

			System.out
					.println("=====Execution started=====");

		   new BasePage(driver);



			/*
			 * Step 1:Search patient A identified in pre-requisite in the Orion(Vanity) URL
			 */
			launchURI("test");
			reportBuilder = new ReportBuilder();
			reportBuilder.takeScreenShot("Sarathi/Step 1");


			launchURI("MH");

		reportBuilder.takeScreenShot("Sarathi/Step 2");

		 new ActionHandler(driver).waitForSomeTime(1000);


		boolean isDisplayed = appStatus.isDisplayed();

		new ActionHandler(driver).waitForSomeTime(1000);
		appStatus.click();

		new ActionHandler(driver).waitForSomeTime(1000);

		reportBuilder.takeScreenShot("Sarathi/Step 3");

		appNo.sendKeys("2890002420");

		dob.sendKeys("17-01-1995");




		System.out
				.println("=====script execution ended=======");
		
	}

}
