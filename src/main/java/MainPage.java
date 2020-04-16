import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage extends BaseActions {


public MainPage (WebDriver driver, WebDriverWait wait) {
    super(driver, wait);

    }

    public void clickJoinButton (){
        driver.findElement(Locators.BUTTON_REGISTRATION).click();
    }

    public void completeFirstPartOfRegistration () {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(Data.email);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.TEXT_FIELD_PASSWORD)));
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(Data.password);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_NEXT));
        driver.findElement(Locators.BUTTON_NEXT).click();
    }

    public void secondPartOfRegistration () {

        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(generateNewNumber(Data.nickname, 10));
        driver.findElement(Locators.LIST_DATE).click();
        driver.findElement(Locators.DATE_OF_BIRTH).click();
        driver.findElement(Locators.LIST_MONTH).click();
        driver.findElement(Locators.MONTH_OF_BIRTH).click();
        driver.findElement(Locators.LIST_YEAR).click();
        driver.findElement(Locators.YEAR_OF_BIRTH).click();
        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(Data.phone);
        driver.findElement(Locators.TEXT_FIELD_LOCATION).sendKeys(Data.location);
        WebElement checkboxConfirmation = driver.findElement(Locators.CHECKBOX_CONFIRMATION);
        boolean selectedCheckbox = checkboxConfirmation.isSelected();
        System.out.println(selectedCheckbox + "!!!!!!!");
        checkboxConfirmation.click();
    }
}



