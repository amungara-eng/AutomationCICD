package rahulshettyacademy.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	

	public void waitForWebElementToAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	//public void waitForWebElementsToAppear(List<WebElement> cartProducts) {
    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    //    wait.until(ExpectedConditions.visibilityOfAllElements(cartProducts));
   // }
	public void waitForWebElementsToAppear(By findBy) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	
	public void waitforWebElementToDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	public void waitforWebElementToappear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	public void waitForElementToBeClickable(By findBy) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		 CartPage cartPage = new CartPage (driver);
		 return cartPage;
	}
	
	public OrderPage goToorderPage()
	{
		orderHeader.click();
		 OrderPage orderPage = new OrderPage (driver);
		 return orderPage;
	}
	
	
	
	
	
	
	
	
	
	
	
}
