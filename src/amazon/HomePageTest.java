package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends HomePageOld {

    @Test(priority = 2)
    public void testCheckSearchBox() {
        checkSearchBox();
        String expectedText = "\"Mask\"";
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

    public void signInToYourAccount() {
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("hamlatabdelhalim@gmail.com");
        driver.findElement(By.className("a-button-input")).click();
        driver.findElement(By.className("a-button-input")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Hamlat4320");
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
        String expectedPage="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualPage= driver.getTitle();
        Assert.assertEquals(actualPage,expectedPage,"Test sign in");

    }
    // 1. testSignIn
    @Test()
    public void testSignInToYourAccount(){
    signInToYourAccount();
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



    
}
