import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchTest extends BaseUI {
    String currentUrlSearch;


    @Test
    public void testSearchPage() {
        Assert.assertTrue(driver.findElement(Locators.LINK_SEARCH).isDisplayed(), "Element is not displayed");
        driver.findElement(Locators.LINK_SEARCH).click();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        //Assert.assertEquals(currentUrlSearch, Data.expectedUrlSearch);
        softAssert.assertEquals(currentUrlSearch, Data.expectedUrlSearch, "URL is wrong");
        softAssert.assertEquals(currentUrlSearch, Data.expectedUrlSearch, "URL is wrong");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement dropDownListSortBy = driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY);
        searchPage.getDropDownListByValue(dropDownListSortBy,"date_created");
        softAssert.assertAll();


    }
    public void validateAssertions(){
        Assert.assertEquals("Web", "Web is");
        Assert.assertTrue(driver.findElement(By.xpath("//a")).isSelected(), "Element is not displayed");
        Assert.fail("Element is not displayed");


    }

}
