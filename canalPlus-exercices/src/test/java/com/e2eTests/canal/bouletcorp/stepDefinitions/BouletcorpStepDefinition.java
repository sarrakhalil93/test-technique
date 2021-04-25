package com.e2eTests.canal.bouletcorp.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.e2eTests.canal.bouletcorp.pages.BouletcorpPage;
import com.e2eTests.canal.utils.CommonMethods;
import com.e2eTests.canal.utils.Setup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BouletcorpStepDefinition {

	public WebDriver driver;
	private BouletcorpPage bouletcorpPage = new BouletcorpPage();
	private CommonMethods commonMethods = new CommonMethods();

	public BouletcorpStepDefinition() {
		driver = Setup.driver;
	}

	@Given("^je me rends sur \"([^\"]*)\"$")
	public void jeMeRendsSur(String url) throws Throwable {
		PageFactory.initElements(driver, BouletcorpPage.class);
		commonMethods.openUrl(url);
	}

	@When("^je clique sur Aleatoire$")
	public void jeCliqueSurAleatoire() throws Throwable {
		bouletcorpPage.clickButtonAleatoire();
	}

	@Then("^la page a change$")
	public void laPageAChange() throws Throwable {
		bouletcorpPage.checkUrlChanged();
		commonMethods.scrollerBottom();
	}

	@Then("^les widgets facebook, twitter et tumblr sont bien affiches$")
	public void lesWidgetsFacebookTwitterEtTumblrSontBienAffiches() throws Throwable {
		boolean facebook = commonMethods.isElementDisplayed(BouletcorpPage.facebookWidget);
		Assert.assertTrue(facebook);
		boolean twitter = commonMethods.isElementDisplayed(BouletcorpPage.twitterWidget);
		Assert.assertTrue(twitter);
		boolean tumblr = commonMethods.isElementDisplayed(BouletcorpPage.tumblrWidget);
		Assert.assertTrue(tumblr);
	}

}
