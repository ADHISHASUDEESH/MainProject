package Testcasesdemo;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObj.Product_view;
import utilss.Basetestt;

public class ProductView_Test extends Basetestt {

	@Test(priority = 1)
	public void verifyPhonesCategoryImagesDisplayed() {
	    Product_view pv = new Product_view(driver);
	    
	    pv.clickPhonesCategory();
	    
	    // Wait for images to load 
	    new WebDriverWait(driver, Duration.ofSeconds(5))
	            .until(ExpectedConditions.visibilityOfElementLocated(
	                    By.cssSelector(".card-img-top.img-fluid")
	            ));

	    Assert.assertTrue(pv.areProductImagesDisplayed(),
	            "Product images are not displayed under Phones category!");
	    
	    System.out.println("Phones category images displayed successfully.");
	}

	    @Test(priority = 2)
	    public void verifyLaptopsCategoryImagesDisplayed() throws InterruptedException {
	        Product_view pv = new Product_view(driver);
	        pv.clickLaptopsCategory();
	        Thread.sleep(2000);

	        Assert.assertTrue(pv.areProductImagesDisplayed(), 
	                "Product images are not displayed under Laptops category!");
	        System.out.println("Laptops category images displayed successfully.");
	    }

	    @Test(priority = 3)
	    public void verifyMonitorsCategoryImagesDisplayed() throws InterruptedException {
	        Product_view pv = new Product_view(driver);
	        pv.clickMonitorsCategory();
	        Thread.sleep(2000);

	        Assert.assertTrue(pv.areProductImagesDisplayed(), 
	                "Product images are not displayed under Monitors category!");
	        System.out.println("Monitors category images displayed successfully.");
	    }
	 

	        @Test(priority = 4)
	        public void verifyAllPhoneNamesDisplayed() throws InterruptedException {

	            Product_view pv = new Product_view(driver);
	            pv.clickPhonesCategory();
	            Thread.sleep(2000);

	            List<String> names = pv.getProductNames();

	            // Print all names
	            System.out.println("Phone Names Displayed:");
	            for (String n : names) {
	                System.out.println(" - " + n);
	            }

	            // Validation
	            Assert.assertTrue(names.size() > 0, "No product names displayed under Phones!");
	            System.out.println("All phone names displayed successfully.");
	        }
	        @Test(priority = 5)
	        public void TC_Phone_NEG_001_verifyPhonesNotShownWithoutClick() {
	            Product_view pv = new Product_view(driver);

	            List<String> names = pv.getProductNames();

	            Assert.assertTrue(names.size() == 0, 
	                "Phones should NOT load before clicking the category!");

	            System.out.println("TC_Phone_NEG_001 PASSED: Phones are not shown by default.");
	        }
	        @Test(priority = 6)
	        public void TC_Phone_NEG_002_verifyNoEmptyProductNames() throws InterruptedException {
	            Product_view pv = new Product_view(driver);
	            pv.clickPhonesCategory();
	            Thread.sleep(2000);

	            List<String> names = pv.getProductNames();

	            for (String n : names) {
	                Assert.assertFalse(n.trim().isEmpty(), "Found empty product name!");
	            }

	            System.out.println("TC_Phone_NEG_003 PASSED: No empty product names found.");
	        }
	        
	        @Test(priority = 7)
	        public void TC_Phone_NEG_003_verifyNoDuplicateProductNames() throws InterruptedException {
	            Product_view pv = new Product_view(driver);
	            pv.clickPhonesCategory();
	            Thread.sleep(2000);

	            List<String> names = pv.getProductNames();
	            Set<String> unique = new HashSet<>(names);

	            Assert.assertEquals(unique.size(), names.size(), "Duplicate phone products found!");

	            System.out.println("TC_Phone_NEG_004 PASSED: All product names are unique.");
	        }

	        
}
