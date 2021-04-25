package com.e2eTests.canal.ouisncf.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.e2eTests.canal.utils.Setup;

public class OuisncfPage {

	WebDriver driver;

	public OuisncfPage() {
		driver = Setup.driver;
	}

	final static String FROM_STATION = "vsb-origin-train-launch";
	final static String TO_STATION = "vsb-destination-train-launch";
	final static String DATE_BUTTON = "vsb-dates-dialog-train-launch-aller-retour-1";
	final static String DATE_TO_GO = "vsb-datepicker-departure-date-input";
	final static String START_HOUR = "schedule-select-startDate";
	final static String SUBMIT_DATE = "vsb-datepicker-train-launch-aller-retour-submit";
	final static String CHECK_HOUR = "//time[@class= 'travel-info_time__2BO41']";
	final static String CHECK_TRAIN = "//span[@class= 'travel-info_label__Jw_Zi']";
	final static String SEARCH_BUTTON = "vsb-booking-train-launch-submit";

	/* @FindBy */
	@FindBy(how = How.ID, using = FROM_STATION)
	public static WebElement fromStation;
	@FindBy(how = How.ID, using = TO_STATION)
	public static WebElement toStation;
	@FindBy(how = How.ID, using = DATE_BUTTON)
	public static WebElement dateButton;
	@FindBy(how = How.ID, using = DATE_TO_GO)
	public static WebElement dateToGo;
	@FindBy(how = How.ID, using = START_HOUR)
	public static WebElement startHour;
	@FindBy(how = How.ID, using = SUBMIT_DATE)
	public static WebElement submitDate;
	@FindBy(how = How.XPATH, using = CHECK_HOUR)
	public static WebElement checkHour;
	@FindBy(how = How.XPATH, using = CHECK_TRAIN)
	public static WebElement checkTrain;
	@FindBy(how = How.XPATH, using = SEARCH_BUTTON)
	public static WebElement searchButton;
	
	/* Methods */
	public void clickElement(WebElement element) {
		element.click();
	}
	
	public void dateToGo(String date) {
		dateToGo.sendKeys(date);
	}
	
	public void selectStartHour(String value) {
		Select startDate = new Select(startHour);
		startDate.selectByValue(value);
	}
	
	public void selectDestination(String destination) throws InterruptedException {
		driver.findElement(By.id("vsb-origin-train-launch")).sendKeys(destination); 
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	    List<WebElement> listItems = driver.findElements(By.xpath("//*[@id=\"vsb-booking-train\"]/div[2]/fieldset/div/div[1]/p[1]")); 
	    for(WebElement listsItems : listItems ) {
	    	if (listsItems.getText().equalsIgnoreCase(destination)) {
	    		listsItems.click();
	    		break;
	    	}  	
	    }
	}
	

}
