package Testcasesdemo;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObj.PlaceOrder;
import utilss.Basetestt;
public class PlaceOrderTest extends Basetestt {

    PlaceOrder orderPage;

    @BeforeMethod
    public void openPlaceOrderPopup() throws InterruptedException {

        driver.get("https://demoblaze.com");
        Thread.sleep(2000);

        // Add item to cart first (requirement for Place Order modal)
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Sony vaio i5")).click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);

        driver.switchTo().alert().accept();

        driver.findElement(By.id("cartur")).click();
        Thread.sleep(1000);

        // Click on Place Order button
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        Thread.sleep(1000);

        orderPage = new PlaceOrder(driver);
    }

    // -----------------------------
    // DATA PROVIDER
    // -----------------------------
    @DataProvider(name = "orderData")
    public Object[][] orderData() {
        return new Object[][]{
                {"Anu", "India", "Kochi", "123456789", "12", "2025"},
                {"Rahul", "Oman", "Muscat", "987654321", "10", "2026"},
                {"Liya", "UAE", "Dubai", "55555555", "08", "2024"},
                {"Ammu", "Qatar", "Doha", "44444444", "05", "2027"}
        };
    }

    // -----------------------------
    // TEST USING DATA PROVIDER
    // -----------------------------
    @Test(dataProvider = "orderData")
    public void testPlaceOrder(String name, String country, String city,
                               String card, String month, String year) throws InterruptedException {

        orderPage.fillOrderForm(name, country, city, card, month, year);
        orderPage.clickPurchase();

        Thread.sleep(1500);

        String confirmationText = driver.findElement(By.className("sweet-alert")).getText();

        System.out.println("Order Confirmation: " + confirmationText);

        Assert.assertTrue(confirmationText.contains("Thank you"),
                "Order success message not displayed!");

        driver.findElement(By.xpath("//button[text()='OK']")).click();
    }

}
