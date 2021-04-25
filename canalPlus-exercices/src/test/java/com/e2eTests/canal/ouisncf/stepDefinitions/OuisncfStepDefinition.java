package com.e2eTests.canal.ouisncf.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.e2eTests.canal.ouisncf.pages.OuisncfPage;
import com.e2eTests.canal.utils.CommonMethods;
import com.e2eTests.canal.utils.Setup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OuisncfStepDefinition {
	
	public WebDriver driver;
	private CommonMethods commonMethods = new CommonMethods();
	private OuisncfPage ouisncfPage = new OuisncfPage();
	
	public OuisncfStepDefinition() {
		driver = Setup.driver;
	}
	
	@Given("^je souhaite me rendre sur le site ouisncf \"([^\"]*)\"$")
	public void jeSouhaiteMeRendreSurLeSiteOuisncf(String url) throws Throwable {
		commonMethods.openUrl(url);
	}

	@When("^je recherche un billet de train entre \"([^\"]*)\" et \"([^\"]*)\" pour le \"([^\"]*)\" a \"([^\"]*)\"$")
	public void jeRechercheUnBilletDeTrainEntreEtPourLeA(String from, String to, String date, String hour) throws Throwable {

		ouisncfPage.selectDestination(from);
		ouisncfPage.selectDestination(to);
	    ouisncfPage.clickElement(OuisncfPage.dateToGo);
	    ouisncfPage.dateToGo(date);
	    ouisncfPage.selectStartHour(hour);
	    ouisncfPage.clickElement(OuisncfPage.submitDate);
	    ouisncfPage.clickElement(OuisncfPage.searchButton);
	}

	@Then("^le train de \"([^\"]*)\" \"([^\"]*)\" est bien affiche$")
	public void leTrainDeEstBienAffiche(String hour, String train) throws Throwable {
		boolean checkHour = commonMethods.isElementDisplayed(OuisncfPage.checkHour);
		Assert.assertTrue(checkHour);
		boolean checkTrain = commonMethods.isElementDisplayed(OuisncfPage.checkTrain);
		Assert.assertTrue(checkTrain);
	}

}
