package pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.junit.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class SettingsPage extends BasePage {

    @AndroidFindBy(id = "tipPercentageEditText")
    private WebElement tipPercentage;

    @AndroidFindBy(id = "saveSettingsButton")
    private WebElement saveSettingsButton;

    HomePage homePage;

    private double convertPercent;

    public SettingsPage(AppiumDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    public void isInitialized() {
        assertTrue(this.tipPercentage.isDisplayed());
        assertTrue(this.saveSettingsButton.isDisplayed());
    }

    public void enterTipPercentage(String percent) {
        this.tipPercentage.clear();
        this.tipPercentage.sendKeys(percent);
        convertPercent = Double.parseDouble(percent);
    }

    public void clickSaveSettingsButton() {
        this.saveSettingsButton.click();
    }

    public void checkSettings() {
        assertEquals(convertPercent, homePage.getPercent());
    }
}