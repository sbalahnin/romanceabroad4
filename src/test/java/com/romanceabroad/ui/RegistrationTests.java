package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.testng.annotations.Listeners;

@Listeners(VideoListener.class)

public class RegistrationTests extends BaseUI {

    @Video(name = "Registration Test")
    @Test(dataProvider = "Registration2", dataProviderClass = DataProviders.class)
    public void testRegistration2(String email, String nickname, boolean reguirement) {
        System.out.println(email);

        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(email, Data.password);
        if (!reguirement) {
            Assert.assertTrue(driver.findElement(Locators.TOOLTIP_ERROR).isDisplayed());
        } else {
            mainPage.clickNextButton();
            mainPage.secondPartOfRegistration(nickname, Data.day, Data.month, Data.year,
                    Data.phone, Data.city, Data.location);
        }
    }

    @Test(dataProvider = "Registration", dataProviderClass = DataProviders.class)
    public void testRegistration(String email, String password, String day, String month, String year,
                                 String phone, String city, String location) {
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(email, password);
        mainPage.clickNextButton();
        mainPage.secondPartOfRegistration(mainPage.generateNewNumber(Data.nickname, 10),
                day, month, year, phone, city, location);

    }

}
