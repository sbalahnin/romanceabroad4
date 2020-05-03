import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BaseActions {


    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void verifyDropDownList() {
        WebElement dropDownListSortBy = driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY);
        getDropDownListByValue(dropDownListSortBy, "date_created");

    }

}



