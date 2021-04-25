package com.e2eTests.canal.bouletcorp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.e2eTests.canal.utils.Setup;

public class BouletcorpPage {

	WebDriver driver;

	public BouletcorpPage() { 
		driver = Setup.driver;
	}

	final static String BUTTON_ALEATOIRE = "//*[contains(text(),'Aléatoire')]";
	final static String FACEBOOK_WIDGET = "//img[@title= 'Facebook']";
	final static String TWITTER_WIDGET = "//img[@title= 'Twitter']";
	final static String TUMBLR_WIDGET = "//a[@title= 'Share on Tumblr']";

	/* @FindBy */
	@FindBy(how = How.XPATH, using = BUTTON_ALEATOIRE)
	public static WebElement buttonAleatoire;
	@FindBy(how = How.XPATH, using = FACEBOOK_WIDGET)
	public static WebElement facebookWidget;
	@FindBy(how = How.XPATH, using = TWITTER_WIDGET)
	public static WebElement twitterWidget;
	@FindBy(how = How.XPATH, using = TUMBLR_WIDGET)
	public static WebElement tumblrWidget;

	/* Methods */
	public void clickButtonAleatoire() {
		buttonAleatoire.click();
	}

	public void checkUrlChanged() {
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl != ("http://www.bouletcorp.com")) {
			System.out.println("Verification successfull - url is changed");
		} else {
			System.out.println("Verification failed - url is not changed");
		}
	}
}
