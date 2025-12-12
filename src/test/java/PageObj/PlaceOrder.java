package PageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaceOrder {
	WebDriver driver;

    // Constructor
    public PlaceOrder(WebDriver driver) {
        this.driver = driver;
    }

    // Locators (NO PageFactory)
    private By txtName = By.id("name");
    private By txtCountry = By.id("country");
    private By txtCity = By.id("city");
    private By txtCard = By.id("card");
    private By txtMonth = By.id("month");
    private By txtYear = By.id("year");
    private By btnPurchase = By.xpath("//button[text()='Purchase']");
    private By btnClose = By.xpath("//button[text()='Close']");

    // Actions
    public void enterName(String name) {
        driver.findElement(txtName).clear();
        driver.findElement(txtName).sendKeys(name);
    }

    public void enterCountry(String country) {
        driver.findElement(txtCountry).clear();
        driver.findElement(txtCountry).sendKeys(country);
    }

    public void enterCity(String city) {
        driver.findElement(txtCity).clear();
        driver.findElement(txtCity).sendKeys(city);
    }

    public void enterCard(String card) {
        driver.findElement(txtCard).clear();
        driver.findElement(txtCard).sendKeys(card);
    }

    public void enterMonth(String month) {
        driver.findElement(txtMonth).clear();
        driver.findElement(txtMonth).sendKeys(month);
    }

    public void enterYear(String year) {
        driver.findElement(txtYear).clear();
        driver.findElement(txtYear).sendKeys(year);
    }

    public void clickPurchase() {
        driver.findElement(btnPurchase).click();
    }

    public void clickClose() {
        driver.findElement(btnClose).click();
    }

    // Fill the entire form
    public void fillOrderForm(String name, String country, String city, String card, String month, String year) {
        enterName(name);
        enterCountry(country);
        enterCity(city);
        enterCard(card);
        enterMonth(month);
        enterYear(year);
    }
}
