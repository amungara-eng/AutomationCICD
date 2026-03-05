package rahulshettyacademy.tests;

import java.time.Duration;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalonetestjava {

	public static void main(String[] args) {
		// TODO Auto-generated method 
               //new comments
     String productName = "ZARA COAT 3";
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().window().maximize();
      driver.get("https://rahulshettyacademy.com/client");
      driver.findElement(By.id("userEmail")).sendKeys("anupamamungara@gmail.com");
      driver.findElement(By.id("userPassword")).sendKeys("Selenium@1course");
      driver.findElement(By.id("login")).click();
    //  driver.findElement(By.cssSelector(".btn.w-10.rounded"));
      List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4.mb-3"));
      
     
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      WebElement addToCart = driver.findElements(By.cssSelector(".col-lg-4.mb-3"))
    		    .stream()
    		    .filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
    		    .map(product -> product.findElements(By.tagName("button"))
    		        .stream()
    		        .filter(btn -> btn.getText().contains("Add To Cart"))
    		        .findFirst()
    		        .orElseThrow(() -> new RuntimeException("Add to cart button not found"))
    		    )
    		    .findFirst()
    		    .orElseThrow(() -> new RuntimeException("Product not found"));

    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);
    	WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
    	wait1.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
    	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
      
        List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);
        driver.findElement(By.cssSelector(".totalRow button")).click();
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "United States").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[1]")).click();
        driver.findElement(By.cssSelector(".action__submit")).click();
        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        System.out.println(confirmMessage);
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        
    
        
        
        	
        }

}
