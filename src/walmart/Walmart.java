package walmart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Walmart extends HomePage {

    // 1.test searchBox
//    @Test()
//    public void testSearchBoxButton(){
//        String expectedText="";
//        String actualText =driver.findElement(By.id("")).getText();
//        WebElement link=driver.findElement(By.id())
//    }

    @Test
    public void testPageTitle() {
        String expectedText = "Walmart.com | Save Money. Live Better.";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Page title not match");

    }
//@Test
//    public void signInToYourAccount(){
//        driver.findElement(By.xpath("//*[@id=\"hf-account-flyout\"]/span/span/span[2]")).click();
//        driver.findElement(By.xpath("//*[@id=\"vh-account-menu-root\"]/div[2]/div/a[1]/div/span/div")).click();
//        driver.findElement(By.cssSelector("#email")).sendKeys("vampireano@gmail.com");
//        driver.findElement(By.cssSelector("//*[@id=\"password\"]")).sendKeys("Hello1234");
//        driver.findElement(By.xpath("//*[@id=\"remember-me\"]")).click();
//        driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/button[1]")).click();
//
//    }
//    @Test()
//    public void testSignInToYourAccount(){
//        String expectedPageTitle="Walmart.com | Save Money. Live Better.";
//        WebElement actualPageTitle=  driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/button[1]"));
//        Assert.assertEquals(actualPageTitle,expectedPageTitle,"fail");
    //}


    // 2 create account

    public void createAccountPage(){
        driver.findElement(By.xpath("//*[@id=\"hf-account-flyout\"]/span/span/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"vh-account-menu-root\"]/div[2]/div/a[1]/div/span/div")).click();
        driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/button[2]")).click();

    }
    @Test()
    public void testCreateAccountPage(){
        createAccountPage();
        String expectedPage="Login";
       String actualPage=driver.getPageSource();
    }





}
