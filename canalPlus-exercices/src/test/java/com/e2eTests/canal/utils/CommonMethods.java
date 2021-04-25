package com.e2eTests.canal.utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {

	public static WebDriver driver;
	public static Properties prop;

	public CommonMethods() {
		driver = Setup.driver;
	}
	
	public void openUrl(String url) {
		driver.get(url);
	}

	public void scrollerBottom() {
		for (int second = 0;; second++) {
			if (second >= 60) {
				break;
			}
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)", "");
		}
	}

	public Boolean isElementDisplayed(WebElement element) {
		Boolean isElementDisplayed = element.isDisplayed();
		return isElementDisplayed;
	}
	

	public void openBrowserWithConfigFile() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/ressources/configs/configs.properties");
		prop.load(fis);
		driver.get(prop.getProperty("url1"));
	}

}
