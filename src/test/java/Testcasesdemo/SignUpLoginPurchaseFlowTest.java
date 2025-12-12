package Testcasesdemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObj.Cart;
import PageObj.Checkout;
import PageObj.Home;
import PageObj.Loginpage;
import PageObj.Product;
import PageObj.Sign_up;
import utilss.Basetestt;

public class SignUpLoginPurchaseFlowTest extends Basetestt {

	 @Test
	    public void testSignUpLoginPurchaseFlow() throws InterruptedException {
		  System.out.println("\n===== TEST STARTED: SignUp → Login → Purchase Flow =====");
		 driver.get("https://demoblaze.com/");
		 System.out.println("Opened Demoblaze website.");
	        Thread.sleep(2000);

	        // ========== SIGN UP ==========
	        System.out.println("\n--- SIGN UP PROCESS STARTED ---");
	        Sign_up signUp = new Sign_up(driver);
	        String username = "Surumi" + System.currentTimeMillis();
	        String password = "Test@123";
	        signUp.clickSignUp();
	        Thread.sleep(1000);
	        signUp.enterUsername(username);
	        signUp.enterPassword(password);
	        signUp.clickSignUpButton();
	        
	       signUp.handleAlert(); // handle "Sign up successful" or "User already exists"
	       System.out.println("SignUp successful OR user already exists handled.");
	        Thread.sleep(5000);
	        Thread.sleep(5000);

	        // ========== LOGIN ==========
	        System.out.println("\n--- LOGIN PROCESS STARTED ---");
	        Loginpage login = new Loginpage(driver);
	        login.clickLogin();
	        Thread.sleep(5000);
	        Thread.sleep(1000);
	        login.enterUsername(username);
	        login.enterPassword(password);
	        login.clickLoginButton();
	        Thread.sleep(2000);
	        Thread.sleep(5000);
	        Thread.sleep(5000);
	        Assert.assertTrue(login.isLoginSuccessful(username), "Login failed!");
	        System.out.println("Login successful as: " + username);
	        Thread.sleep(5000);
	        Thread.sleep(5000);
	        // ========== ADD TWO PRODUCTS ==========
	        Home home = new Home(driver);
	        System.out.println("\n--- ADDING FIRST PRODUCT ---");

	        home.clickFirstProduct();
	        Thread.sleep(1500);
	        Thread.sleep(5000);
	        Product product = new Product(driver);
	        product.addToCart();
	        
	        Thread.sleep(1000);
	        Thread.sleep(5000);
	        product.handleAlert();
	        Thread.sleep(5000);
	        Thread.sleep(5000);
	        System.out.println("First product added to cart successfully.");
	        //driver.navigate().back();
	        driver.navigate().to("https://demoblaze.com/index.html");
	        System.out.println("\n--- ADDING SECOND PRODUCT ---");
	        Thread.sleep(5000);
	        Thread.sleep(5000);
	        Thread.sleep(5000);
	        home.clickSecondProduct();
	        Thread.sleep(5000);
	        Thread.sleep(5000);
	        Thread.sleep(5000);
	        product.addToCart();
	        Thread.sleep(5000);
	        product.handleAlert();
	        System.out.println("Second product added to cart successfully.");

	        // ========== OPEN CART AND REMOVE ONE ITEM ==========
	        System.out.println("\n--- CART OPERATIONS STARTED ---");

	        Cart cart = new Cart(driver);
	        cart.openCart();
	        System.out.println("Opened Cart page.");

	        Thread.sleep(2000);
	        cart.removeFirstItem();
	        Thread.sleep(2000);
	        System.out.println("Removed first item from cart.");


	        // ========== PLACE ORDER ==========
	        System.out.println("\n--- PLACE ORDER PROCESS STARTED ---");

	        cart.clickPlaceOrder();
	        Thread.sleep(1000);

	        Checkout checkout = new Checkout(driver);
	        checkout.fillOrderForm("Surumi Tester", "India", "Kochi", "4111111111111111", "12", "2030");
	        Thread.sleep(1000);
	        System.out.println("Order form filled.");
	        checkout.clickPurchase();
	        Thread.sleep(1500);

	        Assert.assertTrue(checkout.isPurchaseSuccessShown(), "Purchase confirmation not shown!");
	        checkout.confirmSuccess();
	        System.out.println("Purchase completed successfully!");
	        System.out.println("\n===== TEST COMPLETED: SignUp → Login → Purchase Flow =====\n");
	    }
}
