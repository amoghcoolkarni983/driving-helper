package drive.tests;

import com.framework.handlers.ActionHandler;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.framework.reports.ReportBuilder;

import com.framework.test.BaseTest;

import drive.basetest.BasePageTest;
import pages.BasePage;

public class SarathiPage extends BasePageTest {

    private static Logger logger = LogManager.getLogger(BaseTest.class);

    @Test
    @Parameters({"environment"})
    public void verifyClosePregnancyForPregnancyOutcomeAsMiscarriage(String environment) {

        System.out
                .println("=====Execution started=====");

        new BasePage(driver);
        reportBuilder = new ReportBuilder();
        launchURI("MH");
        driver.findElement(By.xpath("(//a[contains(text(),'Others')])[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Camp Registration')]")).click();
        driver.findElement(By.xpath("(.//*[@type='text'])[1]")).sendKeys("2890002420");
        driver.findElement(By.xpath("(.//*[@type='text'])[2]")).sendKeys("17-01-1995");
        new ActionHandler(driver).waitForSomeTime(15000);
        reportBuilder.takeScreenShot("Sarathi/Step 1");
        driver.findElement(By.xpath("(.//*[@type='button'])[1]")).click();
        System.out
                .println("=====script execution ended=======");

    }

}
