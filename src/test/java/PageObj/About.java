package PageObj;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.JavascriptExecutor;

	public class About {

	    WebDriver driver;

	    By aboutLink = By.xpath("//a[text()='About us']");
	    By aboutModal = By.id("videoModal");
	    By videoFrame = By.id("example-video_html5_api");
	    By closeButton = By.xpath("//div[@id='videoModal']//button[text()='Close']");

	    public About(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void clickAboutLink() {
	        driver.findElement(aboutLink).click();
	    }

	    public boolean isModalDisplayed() {
	        return driver.findElement(aboutModal).isDisplayed();
	    }

	    public boolean isVideoDisplayed() {
	        WebElement iframe = driver.findElement(videoFrame);
	        return iframe.isDisplayed();
	    }
	    //  PLAY the video
	    public void playVideo() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("document.getElementById('example-video_html5_api').play()");
	    }

	    // PAUSE the video
	    public void pauseVideo() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("document.getElementById('example-video_html5_api').pause()");
	    }

	    // Check if PAUSED
	    public boolean isVideoPaused() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        return (Boolean) js.executeScript("return document.getElementById('example-video_html5_api').paused");
	    }


	    public void clickCloseButton() {
	        driver.findElement(closeButton).click();
	    }
	}


