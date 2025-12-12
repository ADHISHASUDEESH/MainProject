package Testcasesdemo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObj.Home;
import utilss.Basetestt;

public class HomeTest extends Basetestt{

        @Test
	    public void testClickFirstProduct() throws InterruptedException {
	        Home home = new Home(driver);
	        Thread.sleep(2000);
	        
	        home.clickFirstProduct();
	        Thread.sleep(2000);
	        // more assertions can be added in ProductPage tests
	    }
        
        @Test(priority = 1)
        public void verifyPaginationButtonsDisplayed() {
            Home home = new Home(driver);

            Assert.assertTrue(home.isPreviousDisplayed(), "Previous button not displayed!");
            Assert.assertTrue(home.isNextDisplayed(), "Next button not displayed!");

            System.out.println("Pagination buttons displayed successfully.");
        }

        @Test(priority = 2)
        public void verifyNextButtonClick() throws Exception {
            Home home = new Home(driver);

            Assert.assertTrue(home.isNextEnabled(), "Next button is disabled!");
            home.clickNext();
            Thread.sleep(1000);

            System.out.println("Next button clicked successfully.");
        }

        @Test(priority = 3)
        public void verifyPreviousButtonClick() throws Exception {
            Home home = new Home(driver);

            Assert.assertTrue(home.isPreviousEnabled(), "Previous button is disabled!");
            home.clickPrevious();
            Thread.sleep(1000);

            System.out.println("Previous button clicked successfully.");
        }

        @Test(priority = 4)
        public void verifySliderImageDisplayed() {
            Home home = new Home(driver);

            Assert.assertTrue(home.isSliderImageVisible(), 
                              "Slider image is not visible!");

            System.out.println("Slider image displayed successfully.");
        }

        @Test
        public void scrollTest() throws InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            System.out.println("Scrolling down by 500 pixels...");
            js.executeScript("window.scrollBy(0, 500);");
            Thread.sleep(5000);

            System.out.println("Scrolling up by 500 pixels...");
            js.executeScript("window.scrollBy(0, -500);");
            Thread.sleep(5000);

            System.out.println("Scroll test completed successfully.");
        }


	}


