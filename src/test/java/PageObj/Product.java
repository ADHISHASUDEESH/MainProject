package PageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilss.Waithelp;

public class Product {
	
	WebDriver driver;

    private By addToCartButton = By.xpath("//a[text()='Add to cart']");

    public Product(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void handleAlert() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }
}
