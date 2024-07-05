package amazon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class amazon_test {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\Selenium webdriver\\edgeDriver\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://amazon.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    
    @Test
    public void AmazonHome() {
        // Navigate to Amazon
        driver.get("https://amazon.in");

        // Locate the search box and perform a search
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Iphone 12");
        driver.findElement(By.id("nav-search-submit-button")).click();

        // Click on the specific product link
        driver.findElement(By.linkText("Apple iPhone 13 (128GB) - Blue")).click();

        // Store window handles in a list
        Set<String> handles = driver.getWindowHandles();
        ArrayList<String> array = new ArrayList<>(handles);

        // Print window handles (for debugging purposes)
        System.out.println("Parent Window Handle: " + array.get(0));
        System.out.println("Child Window Handle: " + array.get(1));

        // Switch to the new window (child window)
        driver.switchTo().window(array.get(1));

        // Wait for the button to be clickable
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Click the "Buy Now" button
        driver.findElement(By.id("buy-now-button")).click();

        
        
        
    }
}
