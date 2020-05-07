import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchTest extends BaseUI {
    public static final boolean testCase10 = true;
    public static final boolean testCase11 = true;

    @Test (priority = 2, enabled = testCase10, groups = {"ie"})
    public void testSearchPageTestCase10() {
        Assert.assertTrue(driver.findElement(Locators.LINK_SEARCH).isDisplayed(), "Element is not displayed");
        String searchLink = mainPage.verifySearchLink();
        System.out.println(searchLink);
        softAssert.assertEquals(searchLink, Data.expectedUrlSearch, "URL is wrong");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert.assertAll();

    }

    @Test (priority = 1, enabled = testCase11, groups = {"user", "admin"})
    public void selectRandomDropDownListTestOnSearchPageCase11() {
        driver.findElement(Locators.LINK_SEARCH).click();
        mainPage.javaWaitSec(3);
        int sizeOfDropDownListSortBy = searchPage.getSizeDropDownList(Locators.DROP_DOWN_MAX_AGE);
        System.out.println(sizeOfDropDownListSortBy);
        for (int i = 0; i < sizeOfDropDownListSortBy; i++) {
            searchPage.selectItemRandomDropDownOption(Locators.DROP_DOWN_MAX_AGE, "Sort by");
            mainPage.javaWaitSec(3);
        }

    }
}


