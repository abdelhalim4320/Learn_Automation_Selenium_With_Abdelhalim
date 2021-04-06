package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testing extends Selenium {

    @Test
    public void verifyLogo(){
        boolean logo=driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
        Assert.assertTrue(logo);
    }

    @Test
    public void verifyLogo1(){
        boolean expectedLogo=true;
        boolean actualLogo=driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
        Assert.assertEquals(expectedLogo,actualLogo,"testing ");
    }

    @Test
    public void signIn() throws InterruptedException {
        Actions actions =new Actions(driver);
     WebElement element = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        actions.moveToElement(element).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
        String expectedTitle="Amazon Sign-In";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"test title");

    }
}


