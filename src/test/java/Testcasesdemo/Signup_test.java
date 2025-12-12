package Testcasesdemo;

import org.testng.annotations.Test;

import PageObj.Sign_up;
import utilss.Basetestt;

public class Signup_test extends Basetestt{

	@Test
	public void verifySuccessfulSignup() throws InterruptedException {
	    Sign_up signup = new Sign_up(driver);

	    // Step 1: Click the Sign-Up link
	    signup.clickSignUp();
	    Thread.sleep(1000);

	    // 🔥 Step 2: Generate a unique username automatically
	    String uniqueUsername = "User" + System.currentTimeMillis(); 
	    String password = "test@123";

	    // Print username for reference
	    System.out.println("Generated Username: " + uniqueUsername);

	    // Step 3: Enter the generated username and password
	    signup.enterUsername(uniqueUsername);
	    signup.enterPassword(password);

	    // Step 4: Click the Sign-Up button
	    signup.clickSignUpButton();

	    // Step 5: Handle and verify alert message
	    Thread.sleep(3000);
	    String alertText = driver.switchTo().alert().getText();
	    System.out.println("Alert Message: " + alertText);

	    assert alertText.contains("Sign up successful.") : "Sign-up failed!";
	    signup.handleAlert();
	}

	 @Test
	    public void verifySignupWithBlankFields() throws InterruptedException {
	        Sign_up signup = new Sign_up(driver);
	        
	        // Step 1: Click the Sign-Up link
	        signup.clickSignUp();
	        Thread.sleep(1000);

	        // Step 2: Leave both fields empty
	        signup.enterUsername("");
	        signup.enterPassword("");

	        // Step 3: Click Sign-Up button
	        signup.clickSignUpButton();

	        // Step 4: Capture alert message
	        Thread.sleep(2000);
	        String alertText = driver.switchTo().alert().getText();
	        System.out.println("Alert Message: " + alertText);
	        assert alertText.contains("Please fill out Username and Password.") : "Validation alert not displayed!";
	        signup.handleAlert();
	    }
	 @Test
	    public void verifySignupWithInvalidUsername() throws InterruptedException {
	        Sign_up signup = new Sign_up(driver);
	        
	        // Step 1: Click the Sign-Up link
	        signup.clickSignUp();
	        Thread.sleep(1000);

	        // Step 2: Enter invalid username and password
	        signup.enterUsername("@@@@89");
	        signup.enterPassword("test@123");

	        // Step 3: Click Sign-Up button
	        signup.clickSignUpButton();

	        // Step 4: Capture alert message
	        Thread.sleep(2000);
	        String alertText = driver.switchTo().alert().getText();
	        System.out.println("Alert Message: " + alertText);
	       // Thread.sleep(5000);	   
	       // Thread.sleep(5000);	 
	        assert alertText.contains("Invalid username") || alertText.contains("This user already exist.") 
	            : "Expected validation message not displayed!";
	        //Thread.sleep(5000);	 
	        signup.handleAlert();
	    }
}
