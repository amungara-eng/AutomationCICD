package rahulshettyacademy.tests;

import rahulshettyacademy.TestComponents.Retry;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException
	{
     String productName = "ZARA COAT 3";
     landingPage.LoginApplication("anupamamungara@gmail.com", "Seleniucourse");
      Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
      
      }
	
		@Test(retryAnalyzer=Retry.class)
		public void ProductErrorValidation() throws IOException
		{
	     String productName = "ZARA COAT 3";
	      
	      ProductCatalogue productCatalogue = landingPage.LoginApplication("anupamamungara@gmail.com", "Selenium@1course");
	      List<WebElement> products = productCatalogue.getProductList();
	      productCatalogue.addProductToCart(productName);
	      CartPage cartPage = productCatalogue.goToCartPage();
	       Boolean match = cartPage.VerifyProductDisplay(productName);
	      Assert.assertTrue(match);
	       	
	        }

	}



//Selenium@1course