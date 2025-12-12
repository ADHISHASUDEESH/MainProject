package PageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilss.Waithelp;

public class Checkout {
	
	WebDriver driver;

    private By name = By.id("name");
    private By country = By.id("country");
    private By city = By.id("city");
    private By creditCard = By.id("card");
    private By month = By.id("month");
    private By year = By.id("year");
    private By purchaseButton = By.xpath("//button[text()='Purchase']");
    private By successMsg = By.xpath("//h2[contains(text(),'Thank you for your purchase!')]");
    private By okButton = By.xpath("//button[text()='OK']");

    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    public void fillOrderForm(String uname, String ctry, String cty, String card, String mon, String yr) {
        driver.findElement(name).sendKeys(uname);
        driver.findElement(country).sendKeys(ctry);
        driver.findElement(city).sendKeys(cty);
        driver.findElement(creditCard).sendKeys(card);
        driver.findElement(month).sendKeys(mon);
        driver.findElement(year).sendKeys(yr);
    }

    public void clickPurchase() {
        driver.findElement(purchaseButton).click();
    }

    public boolean isPurchaseSuccessShown() {
        return driver.findElement(successMsg).isDisplayed();
    }

    public void confirmSuccess() {
        driver.findElement(okButton).click();
    }
}
