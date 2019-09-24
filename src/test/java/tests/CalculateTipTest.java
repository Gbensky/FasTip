package tests;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import pages.HomePage;


public class CalculateTipTest extends BaseTest {
    HomePage homePage;
    Double billAmount;

    Faker faker = new Faker();

    @Given("^User opens app$")
    public void setUp() throws Throwable {
        super.setUp();
        homePage = new HomePage(driver);
        billAmount = faker.number().randomDouble(2, 1, 100000);
    }

    @Then("^User should see app fully loaded$")
    public void launchedApp() {
        homePage.isInitialized();
    }

    @When("^User enters bill amount$")
    public void enterBillAmount() {
        homePage.enterAmount(billAmount.toString());
    }

    @And("^clicks on the Calculate Tip Button$")
    public void clickCalculateTipButton() {
        homePage.clickCalcTipButton();
    }

    @Then("^User should see Tip amount as Tip Percentage multiplied by bill amount")
    public void checkCalculatedTipAmount() {
        homePage.checkTipAmount();
    }

    @And("^Total Amount as bill amount plus Tip Amount$")
    public void checkCalculatedTotalAmount() {
        homePage.checkTotalAmount();
    }
}
