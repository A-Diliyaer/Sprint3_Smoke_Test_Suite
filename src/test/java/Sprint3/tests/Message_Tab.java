package Sprint3.tests;

import Sprint3.util.BrowserUtil;
import Sprint3.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Message_Tab {

    WebDriver driver;
    String browserType = "chrome";
    //Truck driver Credentials
    String URL = "https://login2.nextbasecrm.com/";
    String userName = "helpdesk28@cybertekschool.com";
    String password = "UserUser";
    protected WebDriverWait wait;


    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
        wait = new WebDriverWait(driver,5);
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Test
    public void verify_topic_icon(){
        driver.findElement(By.xpath("//span[.='Message']")).click();
        driver.findElement(By.xpath("//span[@title='Topic']")).click();
        boolean topic_displayed = driver.findElement(By.xpath("//input[@id='POST_TITLE']")).isDisplayed();

        Assert.assertTrue(topic_displayed,"topic box is not displayed");
    }

    @Test
    public void sprint3_story1_AC5() {
        //Clicking Message Field
        WebElement messageField = driver.findElement(By.xpath("//span[@class='feed-add-post-micro-title']"));
        messageField.click();

        //Clicking Quote Button
        WebElement quoteButton = driver.findElement(By.xpath("//*[@id=\"bx-b-quote-blogPostForm\"]/span/i"));
        quoteButton.click();
        BrowserUtil.Wait(1);

        //Confirming Created Quote Box
        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"bx-html-editor-iframe-cnt-idPostFormLHE_blogPostForm\"]/iframe"));
        driver.switchTo().frame(iframe);
        BrowserUtil.Wait(1);
        WebElement quoteBox = driver.findElement(By.xpath("/html/body/blockquote"));
        Assert.assertTrue(quoteBox.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
