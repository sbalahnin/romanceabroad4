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
    String currentUrlContactUs;


    public void clickJoinButton() {

        driver.findElement(Locators.BUTTON_REGISTRATION).click();
    }

    public void completeFirstPartOfRegistration(String email, String password) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.TEXT_FIELD_PASSWORD)));
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(password);

    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_NEXT));
        driver.findElement(Locators.BUTTON_NEXT).click();


    }

    public void secondPartOfRegistration(String nickname, String day, String month, String year,
                                         String phone, String city, String location) {

        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(nickname);
        driver.findElement(Locators.LIST_DAYS).click();
        clickValueOfLists(Locators.LIST_VALUE_DAY, day);

        driver.findElement(Locators.LIST_MONTHS).click();
        clickValueOfLists(Locators.LIST_VALUE_MONTH, month);

        driver.findElement(Locators.LIST_YEARS).click();
        clickValueOfLists(Locators.LIST_VALUE_YEAR, year);

        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(phone);
        WebElement checkboxConfirmation = driver.findElement(Locators.CHECKBOX_CONFIRMATION);
        checkboxConfirmation.click();

        driver.findElement(Locators.AUTOFILLING_FORM).clear();
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

    public String verifyContactUsLink() {
        driver.findElement(Locators.LINK_CONTACT_US).click();
        currentUrlContactUs = driver.getCurrentUrl();
        return currentUrlContactUs;
    }

}




