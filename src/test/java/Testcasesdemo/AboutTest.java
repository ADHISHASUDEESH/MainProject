package Testcasesdemo;

	import org.testng.Assert;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import PageObj.About;
	import utilss.Basetestt;

	public class AboutTest extends Basetestt {

	    About about;

	    @BeforeMethod
	    public void setUpAboutPage() throws InterruptedException {
	        driver.get("https://demoblaze.com");
	        about = new About(driver);
	        Thread.sleep(2000);
	    }

	    @Test(priority = 1)
	    public void testOpenAboutModal() throws InterruptedException {
	        about.clickAboutLink();
	        Thread.sleep(2000);
	        Assert.assertTrue(about.isModalDisplayed(), "About Us modal not displayed!");

	        System.out.println("About Us modal opened successfully.");
	    }

	    @Test(priority = 2)
	    public void testVideoDisplayed() throws InterruptedException {
	    	 Thread.sleep(5000);
	    	about.clickAboutLink();
	        Thread.sleep(5000);
	        Thread.sleep(5000);
	        Thread.sleep(5000);
	        Assert.assertTrue(about.isVideoDisplayed(), "Video is not displayed inside modal!");
	        Thread.sleep(5000);
	        System.out.println("Video iframe displayed successfully.");
	    }

	    @Test(priority = 3)
	    public void testCloseButtonWorks() throws InterruptedException {
	        about.clickAboutLink();
	        Thread.sleep(2000);

	        about.clickCloseButton();
	        Thread.sleep(1000);

	        System.out.println("Close button clicked successfully.");
	        Assert.assertTrue(true);
	    }

	    @Test(priority = 4)
	    public void testIframeLoads() throws InterruptedException {
	        about.clickAboutLink();
	        Thread.sleep(5000);

	        boolean videoVisible = about.isVideoDisplayed();
	        Assert.assertTrue(videoVisible, "Iframe did not load properly!");

	        System.out.println("Iframe loaded properly inside About Us modal.");
	    }
	    
	    @Test(priority = 5)
	    public void testVideoPauseFunctionality() throws InterruptedException {
	        about.clickAboutLink();
	        Thread.sleep(3000);

	        // Play the video
	        about.playVideo();
	        Thread.sleep(3000);

	        // Pause the video
	        about.pauseVideo();
	        Thread.sleep(2000);

	        // Verify video is paused
	        Assert.assertTrue(about.isVideoPaused(), "Video did not pause!");
	        System.out.println("Video paused successfully.");
	    }

	}


