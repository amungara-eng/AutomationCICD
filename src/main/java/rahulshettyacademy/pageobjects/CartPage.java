package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	@FindBy(css = ".totalRow button")
	WebElement chekcoutEle;
	By checkoutBy = By.cssSelector(".totalRow button");
	
	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;
	By cartProductsBy = By.cssSelector(".cartSection h3");
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public Boolean VerifyProductDisplay(String  productName) {
		waitForWebElementsToAppear(cartProductsBy);
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
				return match;
	}
	      
	public CheckoutPage gotoCheckout() {
		 waitForElementToBeClickable(checkoutBy);
		 chekcoutEle.click();
	        return new CheckoutPage(driver);
		
	}
	
	
	
	
}
	
	
	
	
    
	
	
	
	
	
	
	
	
	
	
	
	
	

