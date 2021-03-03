package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePage {
//    WebDriver is an interface imported from selenium driver
//    ChromeDriver is a class imported from chrome driver


    public static void main(String[] args) throws InterruptedException {
//
        String productName="mask";
        String searchBoxLocator="twotabsearchtextbox";
        String searchButtonLocator="nav-search-submit-button";
        // chrome browser
        String amazonUrl="https://www.amazon.com/";
        String chromeDriverPath="BrowserDriver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        WebDriver driver =new ChromeDriver();
        driver.get(amazonUrl);
        //


//        // for firefox browser
//        String firefoxDriverPath="BrowserDriver/windows/geckodriver.exe";
//        System.setProperty("webdriver.gecko.driver",firefoxDriverPath);
//        WebDriver driver1=new FirefoxDriver();
//        driver1.get("https://www.amazon.com/");
//
//        // for Edge browser
//        String egeDriverPath="BrowserDriver/windows/msedgedriver.exe";
//        System.setProperty("webdriver.edge.driver",egeDriverPath);
//        WebDriver driver2=new EdgeDriver();
//        driver2.get("https://www.amazon.com/");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //sendKeys method is used to enter value
        driver.findElement(By.id(searchBoxLocator)).sendKeys(productName);
        // click method
        driver.findElement(By.id(searchButtonLocator)).click();

        /* the 8 locators:

        driver.findElement(By.className("jhjgjg")).click();
        driver.findElement(By.className("jhjgjg")).click();
        driver.findElement(By.cssSelector("iuhiuhjb")).click();
        driver.findElement(By.linkText("hihi")).click();
        driver.findElement(By.tagName("uguh")).click();
        driver.findElement(By.xpath("hhhh")).click();
        driver.findElement(By.partialLinkText("jhj")).click();

         */



        Thread.sleep(5000); // timing or wait purpose
        driver.close();

    }



}
