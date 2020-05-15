package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MediaTest extends BaseUI {


    @Test
    public void testMediaPage() {
        String mediaLink = mainPage.verifyMediaLink();
        System.out.println(mediaLink);
        Assert.assertEquals(mediaLink, Data.expectedUrlMedia);
        mainPage.javaWaitSec(5);


    }
}
