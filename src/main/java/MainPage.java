import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage extends BaseActions {


    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    String currentUrlBlog;
    String currentUrlGifts;
    String currentUrlHowWeWork;
    String currentUrlMedia;
    String currentUrlSignIn;
    String currentUrlTourUkraine;

    public void clickJoinButton() {

        driver.findElement(Locators.BUTTON_REGISTRATION).click();
    }

    public void completeFirstPartOfRegistration() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(Data.email);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.TEXT_FIELD_PASSWORD)));
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(Data.password);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_NEXT));
        driver.findElement(Locators.BUTTON_NEXT).click();
    }

    public void secondPartOfRegistration() {

        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(generateNewNumber(Data.nickname, 10));
        driver.findElement(Locators.LIST_DATE).click();
        driver.findElement(Locators.DATE_OF_BIRTH).click();
        driver.findElement(Locators.LIST_MONTH).click();
        driver.findElement(Locators.MONTH_OF_BIRTH).click();
        driver.findElement(Locators.LIST_YEAR).click();
        driver.findElement(Locators.YEAR_OF_BIRTH).click();
        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(Data.phone);
        driver.findElement(Locators.TEXT_FIELD_LOCATION).sendKeys(Data.location);
        WebElement checkboxConfirmation = driver.findElement(Locators.CHECKBOX_CONFIRMATION);
        checkboxConfirmation.click();
    }

    public String verifyBlogLink() {
        driver.findElements(Locators.BLOG_LINK).get(Locators.indexLinkBlog).click();
        currentUrlBlog = driver.getCurrentUrl();
        return currentUrlBlog;
    }

    public String verifyGiftLink() {
        driver.findElement(Locators.GIFTS_LINK).click();
        currentUrlGifts = driver.getCurrentUrl();
        return currentUrlGifts;
    }

    public String verifyHowWeWorkLink() {
        driver.findElement(Locators.HOW_WE_WORK_LINK).click();
        currentUrlHowWeWork = driver.getCurrentUrl();
        return currentUrlHowWeWork;
    }

    public String verifyMediaLink() {
        driver.findElement(Locators.LINK_MEDIA).click();
        currentUrlMedia = driver.getCurrentUrl();
        return currentUrlMedia;
    }

    public String verifySignInLink() {
        driver.findElement(Locators.LINK_SIGN_IN).click();
        currentUrlSignIn = driver.getCurrentUrl();
        return currentUrlSignIn;
    }

    public String verifyTourToUkraineLink() {
        driver.findElement(Locators.TOUR_TO_UKRAINE_LINK).click();
        currentUrlTourUkraine = driver.getCurrentUrl();
        return currentUrlTourUkraine;
    }
}



