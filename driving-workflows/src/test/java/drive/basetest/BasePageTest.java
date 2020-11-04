package drive.basetest;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.framework.config.GlobalProperties;
import com.framework.config.PropertiesRepository;
import com.framework.driverfactory.DriverFactory;
import com.framework.reports.ReportBuilder;
import com.framework.reports.TestNGCustomReporter;
import com.framework.test.BaseTest;
import com.framework.utils.ExcelUtils;
import com.google.common.collect.ArrayListMultimap;
@Listeners({ com.framework.reports.ReportBuilder.class })

public class BasePageTest {
	private static Logger logger = LogManager.getLogger(BaseTest.class);

	protected static WebDriver driver = null;
	protected ExtentReports extent;

	protected ReportBuilder reportBuilder;

	static {
		try {
			PropertiesRepository.loadAllProperties();
			ExcelUtils.setExcel(System.getProperty("user.dir") + PropertiesRepository.getString("testdata.excel.file"));
		} catch (Exception e) {
			logger.error("Unable to load properties files", e);
		}
	}

	@Parameters({ "suitename", "environment", "browsertype" })
	@BeforeSuite
	public void beforeSuite(String suiteName, String environment, String browserType) {
		ReportBuilder.testMap = ArrayListMultimap.create();
		ReportBuilder.logMap = ArrayListMultimap.create();
		GlobalProperties.BrowserType = browserType;
		GlobalProperties.Environment = environment;
		GlobalProperties.SuiteName = suiteName;
		extent = ReportBuilder.init(GlobalProperties.SuiteName, GlobalProperties.BrowserType);
	}

	@BeforeMethod
	public void setup() {
		driver = DriverFactory.getDriver(GlobalProperties.BrowserType);
		ReportBuilder.setDriver(driver);
		manageDriver(driver);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		DriverFactory.removeDriver(driver);
	}

	@AfterSuite
	public void afterSuite(ITestContext context) {
		ReportBuilder.buildReports(extent, context);
		ReportBuilder.testMap.clear();
		ReportBuilder.logMap.clear();
	}

	private void manageDriver(WebDriver webDriver) {
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
		webDriver.manage().timeouts().implicitlyWait(PropertiesRepository.getInt("global.implicit.wait"),
				TimeUnit.SECONDS);
	}

	public void launchURI(String URI) {

		switch (URI) {
			case "MH":

				String url2 = ExcelUtils.getDataByColumnNameWithRowIndex("Drive", "URI", 3).trim();
				driver.get(url2);
				TestNGCustomReporter.log(logger, "Launched Vanity URL selected for Pregnancy Outcome" + URI);

				break;

			case "APP":


				String url3 = ExcelUtils.getDataByColumnNameWithRowIndex("Drive", "URI", 4).trim();
				driver.get(url3);
				TestNGCustomReporter.log(logger, "Launched Vanity URL selected for Pregnancy Outcome" + URI);

				break;

				default:
			String url1 = ExcelUtils.getDataByColumnNameWithRowIndex("Drive", "URI", 2).trim();
			driver.get(url1);
			TestNGCustomReporter.log(logger, "Launched Vanity URL selected for Pregnancy Outcome" + URI);

		}

	}


}
