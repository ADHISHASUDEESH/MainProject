package PageObj;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product_view {
	
	    WebDriver driver;

	    // Constructor
	    public Product_view(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Locators
	    private By phonesCategory = By.xpath("//a[text()='Phones']");
	    private By laptopsCategory = By.xpath("//a[text()='Laptops']");
	    private By monitorsCategory = By.xpath("//a[text()='Monitors']");
	    private By productImages = By.cssSelector(".card-img-top");
	//    private By productPrices = By.cssSelector(".card-block .card-text"); // price elements
	    private By productTitles = By.cssSelector(".card-title");   // phone names
	    private By productPrices = By.cssSelector("h5.price-container");  // PRICE LOCATOR
	    // Actions
	    public void clickPhonesCategory() {
	        driver.findElement(phonesCategory).click();
	    }

	    public void clickLaptopsCategory() {
	        driver.findElement(laptopsCategory).click();
	    }

	    public void clickMonitorsCategory() {
	        driver.findElement(monitorsCategory).click();
	    }

	    public boolean areProductImagesDisplayed() {

	       
	        List<WebElement> images = driver.findElements(By.cssSelector(".card-img-top.img-fluid"));

	        if (images.isEmpty()) {
	            return false;  // No images found
	        }

	        // Check each image is displayed
	        for (WebElement img : images) {
	            if (!img.isDisplayed()) {
	                return false;
	            }
	        }

	        return true;
	    }

	    // Fetch all product names
	    public List<String> getProductNames() {
	        List<WebElement> names = driver.findElements(productTitles);
	        List<String> productNames = new ArrayList<>();

	        for (WebElement name : names) {
	            productNames.add(name.getText().trim());
	        }

	        return productNames;
	    }
	
	    
}





