package Testcasesdemo;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObj.Loginpage;
import utilss.Basetestt;

public class LoginTest extends Basetestt {

    @Test(priority = 1)
    public void verifyLoginWithWrongPassword() throws InterruptedException {
        Loginpage login = new Loginpage(driver);

        login.clickLogin();
        Thread.sleep(1000);

        login.enterUsername("Surumi123");
        login.enterPassword("wrongpass");
        login.clickLoginButton();

        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Message: " + alertText);
        Assert.assertTrue(alertText.contains("Wrong password"), "Incorrect alert for invalid password!");
        alert.accept();
    }

    @Test(priority = 2)
    public void verifyLoginWithUnregisteredUser() throws InterruptedException {
        Loginpage login = new Loginpage(driver);

        login.clickLogin();
        Thread.sleep(1000);

        login.enterUsername("UnknownUser");
        login.enterPassword("abc@123");
        login.clickLoginButton();

        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertTrue(alertText.contains("User does not exist"), "Unexpected alert message!");
        alert.accept();
    }

    @Test(priority = 3)
    public void verifyLoginWithEmptyFields() throws InterruptedException {
        Loginpage login = new Loginpage(driver);

        login.clickLogin();
        Thread.sleep(1000);

        login.clickLoginButton();
        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertTrue(alertText.contains("Please fill out Username and Password"), 
                "Expected validation alert not shown!");
        alert.accept();
    }

    @Test(priority = 4)
    public void verifyLoginWithEmptyUsernameOnly() throws InterruptedException {
        Loginpage login = new Loginpage(driver);

        login.clickLogin();
        Thread.sleep(1000);

        login.enterPassword("test@123");
        login.clickLoginButton();

        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertTrue(alertText.contains("Please fill out Username and Password"), 
                "Alert message mismatch for empty username!");
        alert.accept();
    }

    @Test(priority = 5)
    public void verifyLoginWithEmptyPasswordOnly() throws InterruptedException {
        Loginpage login = new Loginpage(driver);

        login.clickLogin();
        Thread.sleep(1000);

        login.enterUsername("Surumi123");
        login.clickLoginButton();

        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertTrue(alertText.contains("Please fill out Username and Password"), 
                "Alert message mismatch for empty password!");
        alert.accept();
    }

}
