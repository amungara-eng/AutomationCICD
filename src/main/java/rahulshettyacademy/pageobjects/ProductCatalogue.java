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

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		//Initialization, this is constructor and first code execute from this block in this class
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	      
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4.mb-3"));
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	@FindBy(css=".col-lg-4.mb-3")
	List<WebElement> products;
	By productsBy = By.cssSelector(".col-lg-4.mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastmessage = By.cssSelector("#toast-container");
	
	//creating abstract classes
	
	public List<WebElement> getProductList()
	{
		waitForWebElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		
		WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName))
			    .findFirst()
			        .orElseThrow(() -> new RuntimeException("Product not found"));
		return prod;
			}
	
	
	public void addProductToCart(String productName)
	{
		
		WebElement prod = getProductByName(productName);

	    // wait until Add To Cart button is clickable
	    waitForElementToBeClickable(addToCart);

	    // JS click to avoid intercepted click issue
	    WebElement button = prod.findElement(addToCart);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

	    waitForWebElementToAppear(toastmessage);
	    waitforWebElementToDisappear(spinner);
		
	}

	
	
	

	
	
	
	
    
	
	
	
	
	
	
	
	
	
	
	
	
	
}
