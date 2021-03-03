package walmart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePage {
    WebDriver driver;
    String walmartUrl="https://www.walmart.com/";
    String searchBoxLocator="//*[@id=\"global-search-input\"]";
    String productName="laptop";
    String searchButtonLocator="#global-search-submit > span > img";



    @BeforeMethod
    public void setUp(){
        String chromeDriverPath="BrowserDriver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver=new ChromeDriver();
        driver.get(walmartUrl);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

//    @Test
//    public void checkSearchBox(){
//        driver.findElement(By.xpath(searchBoxLocator)).sendKeys(productName);
//        driver.findElement(By.cssSelector(searchButtonLocator)).click();
//
//    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit(); // close all the windows
    }

}
