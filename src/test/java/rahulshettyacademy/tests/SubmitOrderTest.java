package rahulshettyacademy.tests;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";
	@Test(dataProvider="getdata",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException
	{
		
      
      ProductCatalogue productCatalogue = landingPage.LoginApplication(input.get("email"),input.get("password"));
      List<WebElement> products = productCatalogue.getProductList();
      productCatalogue.addProductToCart(input.get("product"));
      CartPage cartPage = productCatalogue.goToCartPage();
       Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
      Assert.assertTrue(match);
      
      CheckoutPage checkoutpage = cartPage.gotoCheckout();
      checkoutpage.selectCounty("United States");
      ConfirmationPage confirmationPage = checkoutpage.submitOrder();
      String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	 }
	
	@Test(groups={"Purchase"})
	public void OrderHistoryTest()
	{
		ProductCatalogue productCatalogue = landingPage.LoginApplication("anupamamungara@gmail.com", "Selenium@1course");
		OrderPage ordersPage = productCatalogue.goToorderPage();
		ordersPage.VerifyOrderDisplay(productName);
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}
	
    @DataProvider
    public Object[][] getdata() throws IOException
    {
 //   	HashMap<String,String> map = new HashMap<String,String>();
 //   	map.put("email", "anupamamungara@gmail.com");
 //   	map.put("password", "Selenium@1course");
 //   	map.put("product","ZARA COAT 3");
    	
 //   	HashMap<String,String> map1 = new HashMap<String,String>();
 //   	map1.put("email", "rahulshetty@gmail.com");
 //   	map1.put("password", "Iamking@000");
 //   	map1.put("product","ADIDAS ORIGINAL");
    	List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Academy\\data1\\PurchaseOrder.json");
    	return new Object [][] { {data.get(0)}, {data.get(1)} };
    }
    //@DataProvider -- we can follow like this or like above 
    //public object[][] getData()
    //{
    // return new object[][] {{"anupamamungara@gmail.com","Selenium@1course","ZARA COAT 3"}, {"rahulshetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}

}
