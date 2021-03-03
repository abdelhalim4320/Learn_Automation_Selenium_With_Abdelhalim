package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageOld {

   WebDriver driver; // reference variable for webDriver
    String productName="Mask";
    String searchBoxLocator="twotabsearchtextbox";
    String searchButtonLocator="nav-search-submit-button";
    String amazonUrl="https://www.amazon.com/";



    // setUp method
    @BeforeMethod
    public void setUp(){
        String chromeDriverPath="BrowserDriver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver =new ChromeDriver();
        driver.get(amazonUrl);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }


   // Action method
    public void checkSearchBox(){
        // enter product name
        driver.findElement(By.id(searchBoxLocator)).sendKeys(productName);
        // click on search button
        driver.findElement(By.id(searchButtonLocator)).click();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        // driver.close // close one window
        driver.quit(); // close all the windows
    }

    // test search box

    @Test()
    public void testCheckSearchBox(){
        checkSearchBox();
        String expectedText="\"Mask\"";
        String actualText=driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(actualText,expectedText,"testing");
 }



}
