package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class stepDefinitionimpl extends BaseTest{
	
	public LandingPage landingpage;
	public ProductCatalogue productCatalogue;
	ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		landingpage = launchApplication();
	}
	
	@Given("^Logged in with your username (.+) and password (.+)$")
    public void logged_in_with_your_username_and_password(String username, String password)
    {
		 productCatalogue = landingPage.LoginApplication(username, password);
    }
	
	@When("^i add product (.+) to cart$")
	public void i_add_product_to_cart(String productname)
	{
		List<WebElement> products = productCatalogue.getProductList();
	      productCatalogue.addProductToCart(productname);
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productname)
	{
		CartPage cartPage = productCatalogue.goToCartPage();
	       Boolean match = cartPage.VerifyProductDisplay(productname);
	      Assert.assertTrue(match);
	      
	      CheckoutPage checkoutpage = cartPage.gotoCheckout();
	      checkoutpage.selectCounty("United States");
	      confirmationPage = checkoutpage.submitOrder();
	}
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_ConfirmationPage(String expectedMessage) {
	    String actualMessage = confirmationPage.getConfirmationMessage();
	    Assert.assertEquals(actualMessage, expectedMessage);
	}
	@Then("{string} message is displayed")
	public void message_is_displayed(String expectedMessage) {
	    String actualMessage = landingpage.getErrorMessage(); // Implement this in LandingPage
	    Assert.assertEquals(actualMessage, expectedMessage);
	}
}



















