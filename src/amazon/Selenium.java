package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selenium {

    //c connect to browser

    // url
    // driver path
    // system.getProperty(url
    // WebDriver driver= Chrome driver ,ie,firefox
    // driver.get()
    WebDriver driver;

    @BeforeMethod()
    public void setUp(){
        String url="https://www.amazon.com/";
        String chromeDriverPath="BrowserDriver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterMethod()
    public void tearDown(){
        driver.quit(); // close all browsers
       // driver.close();// close one browser
    }



}
