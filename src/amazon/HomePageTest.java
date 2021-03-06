package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class HomePageTest extends HomePageOld {

    @Test(priority = 2)
    public void testCheckSearchBox() {
        checkSearchBox();
        String expectedText = "\"Iphone 11\"";
        String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(actualText, expectedText, "testing");

    }

    @Test(priority = 1)
    public void testPageTitle() {
        String expectedText = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Page title not match");
    }

    // 1.action method for  signIn
   @Test
    public void signInToYourAccount() {
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("hamlatabdelhalim@gmail.com");
        driver.findElement(By.className("a-button-input")).click();
        driver.findElement(By.className("a-button-input")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Hamlat4320");
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
        String expectedPage="Amazon Sign-In";
        String actualPage= driver.getTitle();
        Assert.assertEquals(actualPage,expectedPage,"Test sign in");

    }
    // 1. testSignIn
    @Test()
    public void testSignInToYourAccount(){

    String expectedPage="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualPage= driver.getTitle();
        Assert.assertEquals(actualPage,expectedPage,"Test sign in");


    }


    // 2. test verify amazon Logo
      // first way
    @Test()
    public void verifyAmazonLogo(){
        boolean logo=driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
        Assert.assertTrue(logo);
    }

    // second way
    public void verifyAmazonLogo1(){
        boolean expectedAmazonLogo=true;
        boolean actualAmazonLogo=driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
        Assert.assertEquals(expectedAmazonLogo,actualAmazonLogo,"test");
    }



    // 3. test click on prime
    @Test
    public void clickOnPrime(){
        WebElement prime=driver.findElement(By.id("nav-link-prime"));
        prime.click();
    }


    // test add to cart
    @Test()
    public void testAddToCart(){
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]")).click();
        Wait wait=new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-xshop\"]/a[2]")));

        Assert.assertTrue(driver.getTitle().equals("Gold Box Deals | Today's Deals - Amazon.com\n"));

        driver.findElement(By.id("101 45bcabd3-announce")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-cart\"]")));

        driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-active-cart")));

        Assert.assertTrue(driver.getTitle().equals("Gold Box Deals | Today's Deals - Amazon.com\n"));


    }

    // test scrolling by using pixel
    @Test()
    public void testScrollByPixel(){
        JavascriptExecutor executor= (JavascriptExecutor)driver;
        //executor.executeScript("scrollBy(0, 4500)");
        executor.executeScript("window.scrollBy(0,4500)");
    }

    // test scroll page till we find element
    @Test()
    public void testScrollToFindElement(){
        JavascriptExecutor executor= (JavascriptExecutor)driver;
        WebElement item= driver.findElement(By.xpath("//*[@id=\"9e0a9d06-c4e5-4d39-aae9-2324dc2a58c8\"]/div[1]/h2/span[2]"));
          executor.executeScript("arguments[0].scrollIntoView()",item);

    }

    //  test scroll page till bottom

    @Test()
    public void testScrollToBottom() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }

    
}
