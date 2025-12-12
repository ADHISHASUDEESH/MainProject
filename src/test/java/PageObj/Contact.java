package PageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Contact {
	 WebDriver driver;

	    // Locators
	    By txtEmail = By.id("recipient-email");
	    By txtName = By.id("recipient-name");
	    By txtMessage = By.id("message-text");
	    By btnSendMessage = By.xpath("//button[text()='Send message']");
	    By btnClose = By.xpath("//button[text()='Close']");

	    public Contact(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Actions
	    public void enterEmail(String email) {
	        driver.findElement(txtEmail).clear();
	        driver.findElement(txtEmail).sendKeys(email);
	    }

	    public void enterName(String name) {
	        driver.findElement(txtName).clear();
	        driver.findElement(txtName).sendKeys(name);
	    }

	    public void enterMessage(String message) {
	        driver.findElement(txtMessage).clear();
	        driver.findElement(txtMessage).sendKeys(message);
	    }

	    public void clickSendMessage() {
	        driver.findElement(btnSendMessage).click();
	    }

	    public void clickCloseButton() {
	        driver.findElement(btnClose).click();
	    }

	    // Utility
	    public boolean isFormDisplayed() {
	        return driver.findElement(txtEmail).isDisplayed();
	    }

	    public void fillContactForm(String email, String name, String message) {
	        enterEmail(email);
	        enterName(name);
	        enterMessage(message);
	    }
}
