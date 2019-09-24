package pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.text.DecimalFormat;

import static org.junit.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;


public class HomePage extends BasePage {

    @AndroidFindBy(id = "billAmtEditText")
    private WebElement billAmount;

    @AndroidFindBy(id = "calcTipButton")
    private WebElement calculateTipButton;

    @AndroidFindBy(id = "tipPctTextView")
    private WebElement tipPercentageText;

    @AndroidFindBy(id = "tipAmtTextView")
    private WebElement tipAmountText;

    @AndroidFindBy(id = "totalAmtTextView")
    private WebElement totalAmountText;

    @AndroidFindBy(id = "menu_settings")
    private WebElement settingsIcon;

    private double convertAmount;
    private double tipPercentValue;
    private double tipAmountValue;
    DecimalFormat df;


    private void setup() {
        String temp = tipPercentageText.getText();
        String tipPercentValueString = temp.substring(0, temp.length() - 1);
        tipPercentValue = Double.parseDouble(tipPercentValueString);
    }

    public HomePage(AppiumDriver driver) {
        super(driver);
        setup();
    }

    public void isInitialized() {
        assertTrue(this.billAmount.isDisplayed());
        assertTrue(this.calculateTipButton.isDisplayed());
        assertTrue(this.tipPercentageText.isDisplayed());
        assertTrue(this.tipAmountText.isDisplayed());
        assertTrue(this.totalAmountText.isDisplayed());
        assertTrue(this.settingsIcon.isDisplayed());
    }

    public void enterAmount(String amount) {
        this.billAmount.clear();
        this.billAmount.sendKeys(amount);
        convertAmount = Double.parseDouble(amount);
    }

    public void clickCalcTipButton() {
        this.calculateTipButton.click();
    }

    public void clickSettingsIcon() {
        this.settingsIcon.click();
    }

    public void checkTipAmount() {
        String temp = tipAmountText.getText();
        String tipAmountValueString = temp.substring(1);
        tipAmountValue = Double.parseDouble(tipAmountValueString);

        df = new DecimalFormat("#.##");

        double calculatedTipAmountValue = Double.parseDouble(df.format((tipPercentValue / 100) * convertAmount));
        assertEquals(tipAmountValue, calculatedTipAmountValue);
    }

    public void checkTotalAmount() {
        String temp = totalAmountText.getText();
        String totalAmountValueString = temp.substring(1);
        double totalAmountValue = Double.parseDouble(totalAmountValueString);

        df = new DecimalFormat("#.##");

        double calculatedTotalAmountValue = Double.parseDouble(df.format(tipAmountValue + convertAmount));
        assertEquals(totalAmountValue, calculatedTotalAmountValue);
    }

    public double getPercent() {
        String temp = tipPercentageText.getText();
        String tipPercentValueString = temp.substring(0, temp.length() - 1);
        tipPercentValue = Double.parseDouble(tipPercentValueString);
        return tipPercentValue;
    }
}
