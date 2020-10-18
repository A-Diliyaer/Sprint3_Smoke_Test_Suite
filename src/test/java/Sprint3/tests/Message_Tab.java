package Sprint3.tests;

import Sprint3.util.BrowserUtil;
import Sprint3.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
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
    //==============================================================================================

    @Test
    public void TestCase_4_to_6(){


        //4-Then user click Upload files and images link √
        //Test Case 4-6



        driver.findElement(By.xpath("//span[.='Message']")).click();
        driver.findElement(By.xpath("//span[@id='bx-b-uploadfile-blogPostForm']")).click();
        BrowserUtil.Wait(2);
        driver.findElement(By.xpath("//input[@name='bxu_files[]']")).sendKeys("/Users/karaduran/Desktop/CRM/Test.pdf ");
        BrowserUtil.Wait(2);
        boolean file_displayed = driver.findElement(By.xpath("//span[@class='files-text']")).isDisplayed();
        Assert.assertTrue(file_displayed,"File is not uploaded");




    }







    @Test
    public void TestCase7_to_9() {
        /*
        7-Then user click Download from external drive link
        8-Then user selects available document
        9-Then user clicks Select document button
         */





        driver.findElement(By.xpath("//span[@class='feed-add-post-micro-title']")).click();
        BrowserUtil.Wait(1);
        //3-And user click Upload files icon √
        driver.findElement(By.id("bx-b-uploadfile-blogPostForm")).click();
        BrowserUtil.Wait(1);


        //7-Then user click Download from external drive link
        driver.findElement(By.xpath("(//span[.='Download from external drive'])[1]")).click();
        BrowserUtil.Wait(2);
        //external links
        List<WebElement> listOfExternalLinks = driver.findElements(By.xpath("//div[@class='bx-file-dialog-tab-item']"));
        for (WebElement eachLink : listOfExternalLinks) {
            System.out.println(eachLink.getText());
            eachLink.click();
            BrowserUtil.Wait(1);

        }

        //<span class="popup-window-button popup-window-button-link popup-window-button-link-cancel" id="">Cancel</span>
        List<WebElement> listOfExternalPopUps = driver.findElements(By.xpath("//span[@class='popup-window-button popup-window-button-link popup-window-button-link-cancel']"));
        for (WebElement each : listOfExternalPopUps) {
            System.out.println(each.getText());
        }


        driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-link popup-window-button-link-cancel']")).click();
        BrowserUtil.Wait(2);
        Assert.fail("Download from external drive module has not been developed");





    }


    @Test
    public void SelectDocFromBitrix24_TestCase10_12(){

        driver.findElement(By.xpath("//span[@class='feed-add-post-micro-title']")).click();
        BrowserUtil.Wait(1);
        //3-And user click Upload files icon √
        driver.findElement(By.id("bx-b-uploadfile-blogPostForm")).click();
        BrowserUtil.Wait(1);

        /*
        10-Then user clicks Select document from Bitrix24 link
        11-Then user select available files
        12-Then user click select document button

         */

        //10-Then user clicks Select document from Bitrix24 link
        driver.findElement(By.xpath("//span[@class='wd-fa-add-file-light-title-text diskuf-selector-link'][1]")).click();

        //11-Then user select available files
        List<WebElement> listOfDocs = driver.findElements(By.xpath("//a[@class='bx-file-dialog-content-link bx-file-dialog-icon bx-file-dialog-icon-file']"));
        for (WebElement eachDoc:listOfDocs){
            System.out.println(eachDoc.getText());
            eachDoc.click();
        }
        //12-Then user click select document button
        driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-accept']")).click();


        //Verification for each selected doc
        List<WebElement> displayedDocs = driver.findElements(By.xpath("//span[@class='files-text']"));
        for (WebElement eachDoc : displayedDocs){
            boolean correction = eachDoc.isDisplayed();
            Assert.assertTrue(correction,"Selected docs did not displayed, Verification Failed");
        }


    }

    @Test
    public void DesktopApp_TestCase_13_to_15(){


        driver.findElement(By.xpath("//span[@class='feed-add-post-micro-title']")).click();
        BrowserUtil.Wait(1);
        //3-And user click Upload files icon √
        driver.findElement(By.id("bx-b-uploadfile-blogPostForm")).click();
        BrowserUtil.Wait(1);

        /*
        13-Then user clicks Create using Desktop applications link
        14-Then user selects an option
        15-Then user verify selected files uploaded successfully
         */
        driver.findElement(By.xpath("//span[@onclick='DiskOpenMenuCreateService(this); return false;'][1]")).click();

        List<WebElement> listOfCreatingUsing = driver.findElements(By.xpath("//span[@class='menu-popup-item-text']"));
        for (WebElement each: listOfCreatingUsing){
            System.out.println(each.getText());
        }



        //driver.findElement(By.xpath("(//span[@class='wd-fa-add-file-light-title-text'])[3]")).click();

        //BrowserUtils.wait(2);

        driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[1]")).click();
        BrowserUtil.Wait(2);

        driver.findElement(By.xpath("//span[@class='popup-window-button']")).click();
        BrowserUtil.Wait(2);

        driver.findElement(By.xpath("(//a[@class='wd-fa-add-file-editor-link-block'])[1]")).click();

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);


        //set allows only unique values

        Set<String> windowHandles = driver.getWindowHandles();

        for (String each:windowHandles){
            driver.switchTo().window(each);
            System.out.println("Current title = "+driver.getTitle());
            BrowserUtil.Wait(1);

        }
        System.out.println(driver.findElement(By.id("error-text")).getText());
        BrowserUtil.Wait(1);



        driver.close();
        driver.switchTo().window(mainHandle);
        Assert.fail("User cannot selects an option due to incomplete configuration! ");









    }



    //===========================================================================================




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
    @Test
    public void messageQuote() throws InterruptedException {
        // Selects "Message" tab on the main selection menu
        Thread.sleep(1);
        WebElement messageField = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageField.click();
        //Clicking on Insert video icon
        Thread.sleep(1);
        WebElement video = driver.findElement(By.xpath("//*[@id=\"bx-b-video-blogPostForm\"]/span/i"));
        video.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.switchTo().window(driver.getWindowHandle());

        driver.findElement(By.xpath("//input[@class='bxhtmled-90-input']")).sendKeys("www.google.com");
        driver.findElement(By.xpath("//input[@value='Save']")).click();

    }
        @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
