import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchTest extends BaseUI {


    @Test
    public void testSearchPage() {
        Assert.assertTrue(driver.findElement(Locators.LINK_SEARCH).isDisplayed(), "Element is not displayed");
        String searchLink = searchPage.verifySearchLink();
        System.out.println(searchLink);
        softAssert.assertEquals(searchLink, Data.expectedUrlSearch, "URL is wrong");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchPage.verifyDropDownList();
        softAssert.assertAll();

    }

}


