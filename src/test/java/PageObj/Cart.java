package PageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilss.Waithelp;

public class Cart {
	
	WebDriver driver;

    private By cartLink = By.id("cartur");
    private By deleteButton = By.xpath("(//a[text()='Delete'])[1]");
    private By placeOrderButton = By.xpath("//button[text()='Place Order']");

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }

    public void removeFirstItem() {
        driver.findElement(deleteButton).click();
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrderButton).click();
    }
}
