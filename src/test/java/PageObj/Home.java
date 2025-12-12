package PageObj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilss.Waithelp;

public class Home {

	WebDriver driver;

    private By firstProduct = By.xpath("(//a[@class='hrefch'])[1]");
    private By secondProduct = By.xpath("(//a[@class='hrefch'])[2]");
    private By cartLink = By.id("cartur");

    
 // New Pagination locators
    private By previousBtn = By.id("prev2"); 
    private By nextBtn = By.id("next2");

    // Slider arrows
    private By leftArrow = By.xpath("//span[@class='carousel-control-prev-icon']");
    private By rightArrow = By.xpath("//span[@class='carousel-control-next-icon']");

    // Slider image (first image)
    private By sliderImage = By.xpath("(//div[@id='carouselExampleIndicators']//img)[1]");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFirstProduct() {
        driver.findElement(firstProduct).click();
    }

    public void clickSecondProduct() {
        driver.findElement(secondProduct).click();
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }
    // ===== Pagination Methods =====

    public void clickPrevious() {
        driver.findElement(previousBtn).click();
    }

    public void clickNext() {
        driver.findElement(nextBtn).click();
    }

    public boolean isPreviousDisplayed() {
        return driver.findElement(previousBtn).isDisplayed();
    }

    public boolean isNextDisplayed() {
        return driver.findElement(nextBtn).isDisplayed();
    }

    public boolean isPreviousEnabled() {
        return driver.findElement(previousBtn).isEnabled();
    }

    public boolean isNextEnabled() {
        return driver.findElement(nextBtn).isEnabled();
    }
    
    // Check if image is visible
    public boolean isSliderImageVisible() {
        return driver.findElement(sliderImage).isDisplayed();
    }
    public void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }
}
