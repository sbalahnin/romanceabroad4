package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseUI {


    @Test
    public void MainPageTest() {
        driver.switchTo().frame(mainPage.findYoutubeIframe());
        if (mainPage.findYoutubePlayButton().isDisplayed()) {
            Assert.assertTrue(mainPage.findYoutubePlayButton().isDisplayed(), "Video is displayed");
            System.out.println("Video is displayed");
            mainPage.findYoutubePlayButton().click();
        } else {
            Assert.fail("Video is not displayed");
        }

    }

    @Test
    public void testLinksOnMainPage() {
        mainPage.checkLinksOnWebPage("//a", "href");
        mainPage.checkLinksOnWebPage("//img", "src");
        driver.findElement(Locators.LINK_SEARCH);
        mainPage.checkLinksOnWebPage("//a", "href");
        mainPage.checkLinksOnWebPage("//img", "src");

    }
    @Test
    public void smokeTestMainPage (){
        List<WebElement> mainTabs = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li/a"));
        for (int i = 0; i <mainTabs.size() ; i++) {
            mainTabs.get(i).click();
            driver.get(Data.mainUrl);
            mainTabs = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li/a"));

        }
    }


}

