import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.print.attribute.standard.OrientationRequested;

public class MainPage {
    String mainUrl = "https://romanceabroad.com/";
    WebDriver driver;
    String currentUrlSearch;
    String currentUrlMedia;
    String expectedUrlSearch = "https://romanceabroad.com/users/search";
    String expectedUrlMedia = "https://romanceabroad.com/media/index";
    By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    By LINK_MEDIA = By.cssSelector("a[href='https://romanceabroad.com/media/index']");
    By LINK_SIGN_IN = By.xpath("//a[@href='https://romanceabroad.com/users/login_form']");
    By BUTTON_REGISTRATION = By.xpath("//button[@id='show-registration-block']");
    By EMAIL = By.cssSelector("input#email");
    By PASSWORD = By.cssSelector("input#password");
    By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");

    int indexLinkSignIn = 0;





                             //Variables for integers, By, String and WebElements.
    String currentUrlHome;
    String currentUrlHowWeWork;
    String currentUrlGifts;
    String currentUrlTourUkraine;
    String currentUrlBlog;
    String expectedUrlHome = "https://romanceabroad.com/#";
    String expectedUrlHowWeWok = "https://romanceabroad.com/content/view/how-it-works";
    String expectedUrlGifts = "https://romanceabroad.com/store/category-sweets";
    String expectedUrlTourUkraine = "https://romanceabroad.com/store/sweets/20-tour_to_ukraine";
    String expectedUrlBlog = "https://romanceabroad.com/content/view/blog";


    By HOME_LINK = By.xpath("//a[@href='#'][text()='HOME']");
    By HOW_WE_WORK_LINK = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    By GIFTS_LINK = By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']");
    By TOUR_TO_UKRAINE_LINK = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine'][text()='TOUR TO UKRAINE']");
    By BLOG_LINK = By.xpath("//a[@href='https://romanceabroad.com/content/view/blog']");
    By TITLE_NAME = By.xpath("//img[@src='/img/logo.jpg']");
    By BOOK_NOW = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine']");
    By SIGN_IN_REGISTRATION = By.xpath("//a[@id='ajax_login_link']");
    By TEXT_FIELD_EMAIL_REGISTRATION = By.cssSelector("input#email");
    By TEXT_FIELD_PASSWORD_REGISTRATION  = By.cssSelector("input#password");
    By BUTTON_SIGN_IN = By.xpath("//button[@name='logbtn']");



    int indexTitleName = 0;
    int indexBookNow = 0;










    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get (mainUrl);

    }

    @Test
    public void testSearchPage () {
        driver.findElement(LINK_SEARCH).click();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        Assert.assertEquals(currentUrlSearch, expectedUrlSearch);
    }


    @Test
    public void testMainPage () {
        driver.findElement(LINK_MEDIA).click();
        currentUrlMedia = driver.getCurrentUrl();
        System.out.println(currentUrlMedia);
        Assert.assertEquals(currentUrlMedia, expectedUrlMedia);
    }


    @Test
    public void testSignIn () {
        driver.findElements(LINK_SIGN_IN).get(indexLinkSignIn).click();
    }


    @Test
    public void testRegistration () {
        driver.findElement(BUTTON_REGISTRATION).click();
        driver.findElement(EMAIL).sendKeys("abc@gmail.com");
        driver.findElement(PASSWORD).sendKeys("Oregon");
        driver.findElement(BUTTON_NEXT).click();
    }



                       //  Homework 4. Test Cases for all the tabs on the Main Page//

       //I know it's easy and more efficient to create variable and use xpath for title, but I just create integer to see how it works.
    @Test
    public void testTitle (){
        driver.findElements(TITLE_NAME).get(indexTitleName).click();

    }


    @Test
    public void testHomeLink () {
        driver.findElement(HOME_LINK).click();
        currentUrlHome = driver.getCurrentUrl();
        System.out.println(currentUrlHome);
        Assert.assertEquals(currentUrlHome, expectedUrlHome);
        }

    @Test
    public void testHowWeWorkLink () {
        driver.findElement(HOW_WE_WORK_LINK).click();
        currentUrlHowWeWork = driver.getCurrentUrl();
        System.out.println(currentUrlHowWeWork);
        Assert.assertEquals(currentUrlHowWeWork,expectedUrlHowWeWok);

        }
    @Test
    public void testGiftsLink () {
        driver.findElement(GIFTS_LINK).click();
        currentUrlGifts = driver.getCurrentUrl();
        System.out.println(currentUrlGifts);
        Assert.assertEquals(currentUrlGifts,expectedUrlGifts);

    }

    @Test
    public void testTourToUkraineLink () {
        driver.findElement(TOUR_TO_UKRAINE_LINK).click();
        currentUrlTourUkraine = driver.getCurrentUrl();
        System.out.println(currentUrlTourUkraine);
        Assert.assertEquals(currentUrlTourUkraine, expectedUrlTourUkraine);

    }

    @Test
    public void testBlogLink() {
        driver.findElement(BLOG_LINK).click();
        currentUrlBlog = driver.getCurrentUrl();
        System.out.println(currentUrlBlog);
        Assert.assertEquals(currentUrlBlog, expectedUrlBlog);
    }

     // Here I tried to use WebElement for this test case//

    @Test
    public void testBookNow() {
        WebElement linkBookNow = driver.findElement(BOOK_NOW);
        linkBookNow.click();

    }

                //Create test case for Sign In link using WebDriver and sending keys//

    @Test
    public void testSignInLink() {
        WebElement linkSignIn = driver.findElement(SIGN_IN_REGISTRATION);
        linkSignIn.click();
    }

    @Test
    public void testSignInRegistration() {
        driver.findElement(SIGN_IN_REGISTRATION).click();
        driver.findElement(TEXT_FIELD_EMAIL_REGISTRATION).sendKeys("abc@gmail.com");
        driver.findElement(TEXT_FIELD_PASSWORD_REGISTRATION).sendKeys("Tenant");
        driver.findElement(BUTTON_SIGN_IN).click();


    }







    @AfterMethod
    public void afterActions() {
     //   driver.quit();

    }
}
