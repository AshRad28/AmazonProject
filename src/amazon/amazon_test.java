package amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
    public void Amazon() {
        driver.get("https://amazon.in");
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Keyboards");
        driver.findElement(By.xpath("//*[@id=\"nav-flyout-searchAjax\"]/div[2]/div/div[1]/div[4]/div/div[1]")).click();
        
    }
}
