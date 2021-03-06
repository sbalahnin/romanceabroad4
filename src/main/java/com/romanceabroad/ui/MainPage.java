package com.romanceabroad.ui;
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
    String currentUrlPhotos;
    String currentUrlSignIn;
    String currentUrlTourUkraine;
    String currentUrlSearch;



    public void clickJoinButton() {
        Reports.log("Wait Join button");
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_REGISTRATION));

        Reports.log("Click Join button");
        driver.findElement(Locators.BUTTON_REGISTRATION).click();
    }

    public void completeFirstPartOfRegistration(String email, String password) {
        Reports.log("Wait email text field");
    //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Reports.log("Type email in text field: " + email);
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(email);

        Reports.log("Wait email text field");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.TEXT_FIELD_PASSWORD)));

        Reports.log("Type password text field: " + password);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(password);

    }

    public void clickNextButton() {
        Reports.log("Wait Next button");
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_NEXT));

        Reports.log("Click Next button");
        driver.findElement(Locators.BUTTON_NEXT).click();


    }

    public void secondPartOfRegistration(String nickname, String day, String month, String year,
                                         String phone, String city, String location) {

        Reports.log("Type Nickname: " + nickname);
        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(nickname);

        Reports.log("Click list of days");
        driver.findElement(Locators.LIST_DAYS).click();

        Reports.log("Select specific day:" + day);
        clickValueOfLists(Locators.LIST_VALUE_DAY, day);

        Reports.log("Click list of months");
        driver.findElement(Locators.LIST_MONTHS).click();

        Reports.log("Select specific month: " + month);
        clickValueOfLists(Locators.LIST_VALUE_MONTH, month);

        Reports.log("Click list of years");
        driver.findElement(Locators.LIST_YEARS).click();

        Reports.log("Select specific year: " + year);
        clickValueOfLists(Locators.LIST_VALUE_YEAR, year);

        Reports.log("Type phone in text field: " + phone);
        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(phone);

        Reports.log("Click confirmation checkbox");
        WebElement checkboxConfirmation = driver.findElement(Locators.CHECKBOX_CONFIRMATION);
        checkboxConfirmation.click();

        Reports.log("Clear location autofilling form");
        driver.findElement(Locators.AUTOFILLING_FORM).clear();

        Reports.log("Type ane of city: " + city);
        driver.findElement(Locators.AUTOFILLING_FORM).sendKeys(city);

        clickValueOfLists(Locators.LIST_VALUE_LOCATIONS, location);

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

    public String verifyPhotosLink() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.LINK_MEDIA));
        driver.findElement(Locators.LINK_MEDIA).click();
        javaWaitSec(5);
        currentUrlPhotos = driver.getCurrentUrl();
        return currentUrlPhotos;
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

    public String verifySearchLink() {
        driver.findElement(Locators.LINK_SEARCH).click();
        currentUrlSearch = driver.getCurrentUrl();
        return currentUrlSearch;
    }

    public WebElement findYoutubeIframe() {
        WebElement iFrame = driver.findElement(Locators.YOUTUBE_LINK);
        return iFrame;
    }

    public WebElement findYoutubePlayButton() {
        WebElement buttonPlay = driver.findElement(Locators.YOUTUBE_PLAY_BUTTON);
        return buttonPlay;


    }


}




