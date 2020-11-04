package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DrivingObjects {

	@FindBy(xpath = "//*[@id=\"stfNameId\"]/option[17]")
	public static WebElement stateName;


	@FindBy(xpath = "/html/body/div/div/div[3]/div[3]/form/div/div[2]")
    public static WebElement stateList;

    @FindBy(xpath = "/html/body/div/div/div[3]/section[3]/div/div/div[3]/a")
    public static WebElement appStatus;


    @FindBy(xpath = ".//*[@name=\"applNum\"]")
    public static WebElement appNo;

    @FindBy(xpath = ".//*[@name=\"dateOfBirth\"]")
    public static WebElement dob;




}
