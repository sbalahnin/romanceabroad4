package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchTest extends BaseUI {
    String nameOfUser;
    String titleOfUserSection;
    String nameOfLinks;
    String titleOfPage;
    String titleOfNewsPage;


    public static final boolean testCase10 = true;
    public static final boolean testCase11 = true;
    public static final boolean testCase12 = true;

    @Test(priority = 2, enabled = testCase10, groups = {"ie"})
    public void testSearchPageTestCase10() {
        Assert.assertTrue(driver.findElement(Locators.LINK_SEARCH).isDisplayed(), "Element is not displayed");
        String searchLink = mainPage.verifySearchLink();
        System.out.println(searchLink);
        softAssert.assertEquals(searchLink, Data.expectedUrlSearch, "URL is wrong");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert.assertAll();

    }

    @Test(priority = 1, enabled = testCase11, groups = {"user", "admin"})
    public void selectRandomDropDownListTestOnSearchPageCase11() {
        mainPage.verifySearchLink();
        mainPage.javaWaitSec(3);
        int sizeOfDropDownListSortBy = searchPage.getSizeDropDownList(Locators.DROP_DOWN_MAX_AGE);
        System.out.println(sizeOfDropDownListSortBy);
        for (int i = 0; i < sizeOfDropDownListSortBy; i++) {
            searchPage.selectItemRandomDropDownOption(Locators.DROP_DOWN_MAX_AGE, "Sort by");
            mainPage.javaWaitSec(3);
        }

    }

    @Test(dataProvider = "Search", dataProviderClass = DataProviders.class, priority = 1, enabled = testCase12, groups = {"user", "admin"})
    public void searchDifferentResults12(String minAge, String maxAge, String sortBy) {
        int min = Integer.parseInt(minAge);
        int max = Integer.parseInt(maxAge);

        mainPage.verifySearchLink();
        mainPage.javaWaitSec(3);
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_MIN_AGE), minAge);
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_MAX_AGE), maxAge);
        searchPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY), sortBy);
        searchPage.clickSearchButton();

        List<WebElement> infoAboutUser = driver.findElements(By.xpath("//div[@class ='text-overflow']"));
        for (int i = 0; i < infoAboutUser.size(); i++) {
            if (i % 2 == 0) {

                String info = infoAboutUser.get(i).getText();
                String[] splitedPhrase = info.split(", ");
                String age = splitedPhrase[1];
                int ageNum = Integer.parseInt(age);
                if (min <= ageNum || ageNum <= max) {
                    System.out.println("This age is: " + ageNum + " is correct");
                } else {
                    Assert.fail("Wrong age: " + ageNum);
                }

            }
        }
    }

    @Test
    public void searchForAllUsers() {
        mainPage.verifySearchLink();
        mainPage.javaWait(3000);
        List<WebElement> checkAllUserProfile = driver.findElements(Locators.USER_PROFILE_NAME);
        for (int i = 0; i < checkAllUserProfile.size(); i++) {
            WebElement listOfUsers = checkAllUserProfile.get(i);
            nameOfUser = listOfUsers.getText();
            if (nameOfUser.contains("Marina")) {
                listOfUsers.click();
                Assert.assertTrue(driver.findElement(Locators.PROFILE_USER_IMAGE).isDisplayed(), "Image is displayed");
                System.out.println("Image is displayed");
            } else {
                System.out.println("Image is missing");
            }
            checkAllUserProfile = driver.findElements(Locators.USER_PROFILE_NAME);


        }
    }

    @Test
    public void verifyMarinaUserProfile() {
        mainPage.verifySearchLink();
        mainPage.javaWait(5000);
        String marinaUserUrl = searchPage.verifyMarinaUserUrl();
        System.out.println(marinaUserUrl);
        Assert.assertEquals(marinaUserUrl, Data.expectedUrlMarinaUser);
        Assert.assertTrue(driver.findElement(Locators.BUTTON_SEND_MESSAGE_ON_PROFILE_PAGE).isDisplayed(),
                "Send Message button is displayed");
        System.out.println("Send Message button is displayed on a page");
        titleOfUserSection = searchPage.userProfileSectionTitle();
        Assert.assertEquals(titleOfUserSection, Data.expectedUserProfileTitle);
        System.out.println(titleOfUserSection);

    }

    @Test
    public void searchAllOptionFromDropDownList() {
        mainPage.verifySearchLink();
        mainPage.javaWait(5000);
        String marinaUserUrl = searchPage.verifyMarinaUserUrl();
        System.out.println(marinaUserUrl);
        driver.findElement(Locators.LINK_USER_PROFILE_GALLERY).click();
        mainPage.javaWaitSec(3);
        driver.findElement(Locators.DROP_DOWN_SORT_BY_USER_PROFILE_BY_DATE).click();
        Assert.assertTrue(driver.findElement(Locators.USER_CONTENT_GALLERY).isDisplayed(), "Photos are displayed");
        System.out.println("User has pictures on the page sorted by Date");
        driver.findElement(Locators.DROP_DOWN_SORT_BY_USER_PROFILE_BY_COMMENTS).click();
        Assert.assertTrue(driver.findElement(Locators.USER_CONTENT_GALLERY).isDisplayed(), "Photos are displayed");
        System.out.println("User has pictures on the page sorted by Comments");
        driver.findElement(Locators.DROP_DOWN_SORT_BY_USER_PROFILE_BY_VIEWS).click();
        Assert.assertTrue(driver.findElement(Locators.USER_CONTENT_GALLERY).isDisplayed(), "Photos are displayed");
        System.out.println("User has pictures on the page sorted by View");


    }

    @Test
    public void testALlFooterLinks() {
        mainPage.verifySearchLink();
        mainPage.javaWaitSec(2);
        List<WebElement> footerLinks = searchPage.collectAllLinksOfFooter();
        for (int i = 0; i < footerLinks.size(); i++) {
            WebElement link = footerLinks.get(i);
            nameOfLinks = link.getText();
            System.out.println("Link: " + nameOfLinks);
            link.click();
            mainPage.javaWaitSec(3);


             //else if(linkText.contains("News")) {
               // String text = driver.findElement(By.xpath("//div[@class='search-header']//div[contains(@class, 'title')]")).getText();
                //System.out.println(text+" !!!!!!!!!!!!!!");
            if (i == 3){
                titleOfNewsPage = driver.findElement(Locators.TITLE_NEWS_PAGE).getText();
            }else
            titleOfPage = searchPage.getAnyTitle();
            System.out.println("Page Title: " + titleOfPage);
            if (i == 0) {
                Assert.assertEquals(titleOfPage, Data.expectedTitleContactUs);
            } else if (i == 1) {
                Assert.assertEquals(titleOfPage, Data.expectedTitleSiteMap);
            } else if (i == 2) {
                Assert.assertEquals(titleOfPage, Data.expectedTitleHowWeWork);
            } else if (i == 3) {
                wait.until(ExpectedConditions.elementToBeClickable(Locators.TITLE_NEWS_PAGE)).isDisplayed();
                Assert.assertEquals(titleOfNewsPage, Data.expectedTitleNews);
            } else if (i == 4) {
                Assert.assertEquals(titleOfPage, Data.expectedTitlePrivacy);
            } else if (i == 5) {
                Assert.assertEquals(titleOfPage, Data.expectedTitleTermsOfUse);
               break;

            }
            footerLinks = searchPage.collectAllLinksOfFooter();
        }

    }
}



