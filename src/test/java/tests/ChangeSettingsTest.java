package tests;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SettingsPage;

public class ChangeSettingsTest extends BaseTest {

    HomePage homePage;
    SettingsPage settingsPage;
    Double percentSettings;

    Faker faker = new Faker();

    @Given("^User opens app for settings$")
    public void setUp() throws Throwable {
        super.setUp();
        homePage = new HomePage(driver);
        settingsPage = new SettingsPage(driver);
        percentSettings = faker.number().randomDouble(2, 0, 100);
    }

    @Then("^User moves to Settings page$")
    public void userClicksOnSettingsIcon() {
        homePage.clickSettingsIcon();
    }

    @Given("^User is on the Settings page$")
    public void userOnSettingsPage() {
        settingsPage.isInitialized();
    }

    @When("^User enters Tip Percent$")
    public void enterTipPercentage() {
        settingsPage.enterTipPercentage(percentSettings.toString());
    }

    @And("^clicks on the Save Settings Button$")
    public void clickSaveSettingsButton() {
        settingsPage.clickSaveSettingsButton();
    }


    @Then("^user confirms settings has been saved successfully$")
    public void checkSettings() {
        settingsPage.checkSettings();
    }
}
