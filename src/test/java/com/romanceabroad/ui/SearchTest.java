package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchTest extends BaseUI {
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

}



