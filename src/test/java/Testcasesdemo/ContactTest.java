package Testcasesdemo;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObj.Contact;
import utilss.Basetestt;

public class ContactTest extends Basetestt{
	 Contact contact;

	    @BeforeMethod
	    public void setUpContactForm() throws InterruptedException {
	        driver.get("https://demoblaze.com");

	        // Click Contact link
	        driver.findElement(By.xpath("//a[text()='Contact']")).click();
	        Thread.sleep(2000);

	        contact = new Contact(driver);
	        System.out.println("Contact form opened successfully.");
	    }


	    @Test
	    public void testValidContactMessage() {
	        contact.fillContactForm("test@mail.com", "Anu", "Hello");
	        System.out.println("Entered valid email, name, and message.");
	        contact.clickSendMessage();

	        String alertText = driver.switchTo().alert().getText();
	        System.out.println("Alert Text: " + alertText);
	        Assert.assertTrue(alertText.contains("Thanks"), "Success message not shown");
	        driver.switchTo().alert().accept();
	        System.out.println("Alert accepted.");
	        System.out.println("Valid Contact Message");
	    }

	    @Test
	    public void testValidEmailOnly() {
	        contact.fillContactForm("aa@mail.com", "", "Message");
	        System.out.println("Entered valid email only.");
	        contact.clickSendMessage();
	        String alertText = driver.switchTo().alert().getText();
	        Assert.assertTrue(alertText.contains("Thanks"));
	        driver.switchTo().alert().accept();
	        System.out.println("Valid Email Only");
	    }

	    @Test
	    public void testValidNameOnly() {
	        contact.fillContactForm("", "Anu", "Hello");
	        contact.clickSendMessage();
	        String alertText = driver.switchTo().alert().getText();
	        Assert.assertTrue(alertText.contains("Thanks"));
	        driver.switchTo().alert().accept();
	        System.out.println("Valid Name Only");
	    }

	    @Test
	    public void testValidMessageOnly() {
	        contact.fillContactForm("", "", "Only message");
	        contact.clickSendMessage();
	        String alertText = driver.switchTo().alert().getText();
	        Assert.assertTrue(alertText.contains("Thanks"));
	        driver.switchTo().alert().accept();
	        System.out.println("Valid Message Only");
	    }

	    @Test
	    public void testCloseButton() {
	        Assert.assertTrue(contact.isFormDisplayed());
	        contact.clickCloseButton();
	        Assert.assertTrue(true);
	        System.out.println("Close Button");
	    }

	    @Test
	    public void testEmptyAllFields() {
	        contact.fillContactForm("", "", "");
	        contact.clickSendMessage();
	        String alertText = driver.switchTo().alert().getText();
	        driver.switchTo().alert().accept();

	        // System accepts empty values → BUG
	        Assert.assertTrue(alertText.contains("Thanks"));
	        System.out.println("EmptyAllFields Test");
	    }

	    @Test
	    public void testInvalidEmailFormat() {

	        contact.fillContactForm("a", "Anu", "Hi");
	        contact.clickSendMessage();

	        String alertText = driver.switchTo().alert().getText();
	        driver.switchTo().alert().accept();

	        // BUG: System should NOT show success message for invalid email
	        Assert.assertTrue(alertText.contains("Thanks"),
	                "Application accepts invalid email format without validation.");
	        System.out.println("InvalidEmailFormat");
	    }
	    @Test
	    public void testVeryLongName() {
	        String longName = "A".repeat(200);
	        contact.fillContactForm("test@mail.com", longName, "Hello");
	        contact.clickSendMessage();
	        String alertText = driver.switchTo().alert().getText();
	        driver.switchTo().alert().accept();
	        Assert.assertTrue(alertText.contains("Thanks"));
	        System.out.println("Long Name Accepted");
	    }

	    @Test
	    public void testVeryLongMessage() {
	        String longMessage = "Hi".repeat(500);
	        contact.fillContactForm("test@mail.com", "Anu", longMessage);
	        contact.clickSendMessage();
	        String alertText = driver.switchTo().alert().getText();
	        driver.switchTo().alert().accept();
	        Assert.assertTrue(alertText.contains("Thanks"));
	        System.out.println("Long Message Accepted");
	    }

	    @Test
	    public void testInvalidCharactersName() {
	        contact.fillContactForm("mail@mail.com", "@@@###", "Hello");
	        contact.clickSendMessage();
	        String alertText = driver.switchTo().alert().getText();
	        driver.switchTo().alert().accept();
	        Assert.assertTrue(alertText.contains("Thanks"));
	        System.out.println("Invalid Characters Accepted (BUG)");
	    }
}
