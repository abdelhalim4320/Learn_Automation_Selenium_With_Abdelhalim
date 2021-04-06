package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class TestAmazon extends HomePageOld{
    @Test()
    public void testCheckSearchBox() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 11");
        driver.findElement(By.id("nav-search-submit-button")).click();
        String expectedText = "\"Iphone 11\"";
        String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(actualText, expectedText, "testing");

    }


    // . test page title
    @Test(priority = 1)
    public void testPageTitle() {
        String expectedText = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Page title not match");
    }

    // test sign in
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


    //  test verify amazon Logo
    // first way
    @Test()
    public void verifyAmazonLogo(){
        boolean logo=driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
        Assert.assertTrue(logo);
    }

    // second way
    @Test
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
        driver.findElement(By.id("101 d7733126-announce")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-cart\"]")));
        driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();

        String expectedPage="Amazon.com Shopping Cart";
        String actualPage= driver.getTitle();
        Assert.assertEquals(actualPage,expectedPage,"product is added successfully");

    }


    // this just scrolling scrolling by using pixel
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

    @Test()
    public void testSignOut() throws InterruptedException {
        // sign in firs bu using test sign in method
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("hamlatabdelhalim@gmail.com");
        driver.findElement(By.className("a-button-input")).click();
        driver.findElement(By.className("a-button-input")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Hamlat4320");
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();

        // sign out now
        Actions act=new Actions(driver);
        WebElement element= driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]"));
        act.moveToElement(element).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]/span")).click();
        String expectedPage="Amazon Sign-In";
        String actualPage= driver.getTitle();
        Assert.assertEquals(actualPage,expectedPage,"Test sign-Out");

    }
    // test button change language to Español - ES - Traducción
    @Test()
    public void testButtonChangeLanguage(){
        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).click();
        driver.findElement(By.id("hmenu-icp-language")).click();
        driver.findElement(By.xpath("//*[@id=\"customer-preferences\"]/div/div/form/div[1]/div[1]/div[2]/div/label/i")).click();
        String expectedTitle="Change Language & Currency Settings";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"box checked ");



    }

    // test change language in amazon
    @Test()
    public void testChangeLanguage(){
      driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).click();
      driver.findElement(By.id("hmenu-icp-language")).click();
      driver.findElement(By.xpath("//*[@id=\"customer-preferences\"]/div/div/form/div[1]/div[1]/div[2]/div/label/i")).click();
      driver.findElement(By.className("a-button-input")).click();
      String expectedTitle="Amazon.com: Compras en Línea de Electrónicos, Ropa, Computadoras, Libros, DVDs y más";
      String actualTitle=driver.getTitle();
      Assert.assertEquals(actualTitle,expectedTitle,"language changed ");

    }

    // test switch country in amazon.com
    @Test()
    public void testSwitchCountry () {
        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[34]/a)")).click();
        driver.findElement(By.id("a-autoid-0-announce")).click();
//        Wait wait=new WebDriverWait(driver,3);
//        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("a-autoid-0-announce"))));
        driver.findElement(By.xpath("//*[@id=\"icp-selected-country_2\"]/div/div/div[2]/span")).click();
        driver.findElement(By.className("a-button-input")).click();

        String expectedUrl="https://www.amazon.com/gp/navigation-country/select-country/?ref_=nav_em_locale_0_1_1_54";
        String actualUlr= driver.getCurrentUrl();
        Assert.assertEquals(actualUlr,expectedUrl,"open url");

    }

    // test change location
    @Test()
    public void testChangeLocation (){
        // connect first
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("hamlatabdelhalim@gmail.com");
        driver.findElement(By.className("a-button-input")).click();
        driver.findElement(By.className("a-button-input")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Hamlat4320");
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();

        driver.findElement(By.id("nav-global-location-popover-link")).click();

       // driver.findElement(By.className("GLUX_Full_Width a-declarative")).sendKeys("07300");
        driver.findElement(By.xpath("//*[@id=\"GLUXManageAddressLink\"]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"a-popover-3\"]/div/div[2]/span/span/span/button")).click();

    }


    // test prime video direct
    @Test()
    public void testPrimeVideoDirect() {
        driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[4]/table/tbody/tr[7]/td[11]/a/span")).click();
        String expectedPage = "https://videodirect.amazon.com/home/landing";
        String actualPage = driver.getCurrentUrl();
        Assert.assertEquals(actualPage, expectedPage, "the new page is matching ");
    }


    //@Test search a product and add it to cart
    @Test()
    public void TestSearchProductAndAddItToCart(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bike");
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[5]/div/span/div/div/div[2]/div[1]/div/div/span/a/div/img")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"a-autoid-12\"]/span/input")).click();

        String expectedPage="Amazon.com Shopping Cart";
        String actualPage= driver.getTitle();
        Assert.assertEquals(actualPage,expectedPage," 3 products are added successfully");

    }


    // test Sell products on Amazon functionality
    @Test()
    public  void testSellProductsOonAmazon(){
        driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[3]/ul/li[1]/a")).click();
        String expectedPage="Sell on Amazon | Build Your Ecommerce Business";
        String actualPage= driver.getTitle();
        Assert.assertEquals(actualPage,expectedPage," testing SellProductsOonAmazon ");
    }


    // teat Amazon Assistant functionality
    @Test()
    public  void testAmazonAssistant(){
        driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[7]/ul/li[8]/a")).click();
        String expectedPage="Amazon Assistant";
        String actualPage= driver.getTitle();
        Assert.assertEquals(actualPage,expectedPage," testing SellProductsOonAmazon ");
    }


    // test switch account
    @Test()
    public void switchAccount () {
        // connect first
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("hamlatabdelhalim@gmail.com");
        driver.findElement(By.className("a-button-input")).click();
        driver.findElement(By.className("a-button-input")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Hamlat4320");
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
        // switch account
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@id=\"nav-item-switch-account\"]/span")).click();
        String expectedPage="Amazon Sign-In";
        String actualPage= driver.getTitle();
        Assert.assertEquals(actualPage,expectedPage," switch account  ");

    }

    // test subscribe&save items
    @Test()
    public void testSubscribeAndSaveItems () {
        // connect first
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("hamlatabdelhalim@gmail.com");
        driver.findElement(By.className("a-button-input")).click();
        driver.findElement(By.className("a-button-input")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Hamlat4320");
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
        // subscribe&save items
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@id=\"nav-al-your-account\"]/a[9]/span")).click();
        driver.findElement(By.id("a-autoid-0-announce")).click();

        String expectedTitle="Amazon.com: Subscribe & Save | Save on Everyday Essentials";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"test subscribe&save items ");

    }
    // test cart if it is displaying
    @Test
    public void verifyCart(){
        boolean expectedAmazonCart=true;
        boolean actualAmazonLCart=driver.findElement(By.id("nav-link-accountList-nav-line-1")).isDisplayed();
        Assert.assertEquals(actualAmazonLCart,expectedAmazonCart,"test");
    }

    // test customer service functionality
    @Test()
    public void testCustomerServiceFunctionality(){
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]")).click();
        String expectedText="Hello. What can we help you with?";
        String actualTest= driver.findElement(By.xpath("/html/body/div[2]/div[1]/h1")).getText();
        Assert.assertEquals(actualTest, expectedText, "testing");
    }
    //*[@id="nav-xshop"]/a[6]


    // test books functionality
    @Test()
    public void testBooksFunctionality(){
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[6]")).click();
        driver.findElement(By.xpath("//*[@id=\"widgetFilters\"]/div/div[3]/div[1]/a/div/div[2]/span")).click();
        String expectedText="Arts & Photography Books";
        String actualTest= driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div[2]/div[1]/div[1]/div/h1/b")).getText();
        Assert.assertEquals(actualTest, expectedText, "testing");
    }



    // test about amazon functionality
    @Test()
    public void testAboutAmazon(){
        driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[3]/a")).click();
        String expectedTitle="About Amazon";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "testing");
    }


    // test amazon devices
    @Test()
    public void testAmazonDevices(){
        driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[7]/a")).click();
        String expectedTitle="Amazon Devices - Official Site - Kindle, Fire, Echo devices";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "testing");
    }


    // test amazon Home
    @Test()
    public void testAmazonHome(){
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[12]")).click();

        String expectedTitle="Shop Amazon Home Products";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "testing");
    }



    // test  check amazon cart
    @Test()
    public void testCheckAmazonCart(){
        driver.findElement(By.xpath("//*[@id=\"nav-cart-text-container\"]")).click();

        String expectedTitle="Amazon.com Shopping Cart";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "testing");
    }


    // test  Returns And Orders
    @Test()
    public void testReturnsAndOrders(){
        driver.findElement(By.xpath("//*[@id=\"nav-orders\"]/span[2]")).click();

        String expectedTitle="Amazon Sign-In";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "testing");
    }


    // test Whole Foods Market
    @Test()
    public void testWholeFoodsMarket(){
        driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[4]/table/tbody/tr[9]/td[3]/a/span")).click();

        String expectedTitle="Whole Foods Market | Whatever Makes You Whole";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "testing");
    }


    // test best sellers
    @Test()
    public void testBestSellers(){
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]")).click();

        String expectedTitle="Amazon.com Best Sellers: The most popular items on Amazon";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "testing");
    }


    // test change language in amazon header
    @Test()
    public void testChangeLanguageHeader(){
        driver.findElement(By.xpath("//*[@id=\"icp-nav-flyout\"]/span/span[2]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"customer-preferences\"]/div/div/form/div[1]/div[1]/div[2]/div/label/span")).click();
        driver.findElement(By.className("a-button-input")).click();
        String expectedTitle="Amazon.com: Compras en Línea de Electrónicos, Ropa, Computadoras, Libros, DVDs y más";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"language changed ");

    }

    @Test()
    public void testCheckSearchBox1() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 11");
     driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        String expectedText = "\"Iphone 11\"";
        String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(actualText, expectedText, "testing");

    }


























}
