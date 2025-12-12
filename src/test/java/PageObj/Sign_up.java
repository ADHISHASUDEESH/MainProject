package PageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilss.Waithelp;

public class Sign_up {
	
	 WebDriver driver;

	    private By signUpLink = By.id("signin2");
	    private By usernameField = By.id("sign-username");
	    private By passwordField = By.id("sign-password");
	    private By signUpButton = By.xpath("//button[text()='Sign up']");

	    public Sign_up(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void clickSignUp() {
	        driver.findElement(signUpLink).click();
	    }

	    public void enterUsername(String username) {
	        driver.findElement(usernameField).sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickSignUpButton() {
	        driver.findElement(signUpButton).click();
	    }

	    public void handleAlert() throws InterruptedException {
	        Thread.sleep(2000);
	        driver.switchTo().alert().accept();
	    }
	}


