package PageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilss.Waithelp;

public class Loginpage {

	 WebDriver driver;

	    private By loginLink = By.id("login2");
	    private By usernameField = By.id("loginusername");
	    private By passwordField = By.id("loginpassword");
	    private By loginButton = By.xpath("//button[text()='Log in']");
	    private By welcomeUser = By.id("nameofuser");
	    private By logoutButton = By.id("logout2");

	    public Loginpage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void clickLogin() {
	        driver.findElement(loginLink).click();
	    }

	    public void enterUsername(String username) {
	        driver.findElement(usernameField).sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLoginButton() {
	        driver.findElement(loginButton).click();
	    }

	    public boolean isLoginSuccessful(String username) {
	        return driver.findElement(welcomeUser).getText().contains(username);
	    }

	    public void clickLogout() {
	        driver.findElement(logoutButton).click();
	    }
	}


