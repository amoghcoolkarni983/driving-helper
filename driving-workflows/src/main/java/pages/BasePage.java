package pages;

import com.framework.handlers.*;
import com.framework.reports.ReportBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.*;

public class BasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	protected WebDriver driver;
	protected PopUpHandler popUpHandler;
	protected ElementHandler elementHandler;
	protected ActionHandler actionHandler;
	protected JavaScriptHandler javaScriptHandler;
	protected ReportBuilder reportBuilder;
	protected BaseHandler baseHandler;

	public BasePage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, DrivingObjects.class);

		this.driver = webDriver;
		popUpHandler = new PopUpHandler(webDriver);
		elementHandler = new ElementHandler(webDriver);
		actionHandler = new ActionHandler(webDriver);
		javaScriptHandler = new JavaScriptHandler(webDriver);
		reportBuilder = new ReportBuilder();
		baseHandler = new BaseHandler(webDriver);

	}

}
