import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class RegistrationTest extends BaseUI {

    @Test
    public void testRegistration() {
        driver.findElement(Locators.BUTTON_REGISTRATION).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(Data.email);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.TEXT_FIELD_PASSWORD)));
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(Data.password);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_NEXT));
        driver.findElement(Locators.BUTTON_NEXT).click();
        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(Data.nickname);
        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(Data.phone);
        driver.findElement(Locators.TEXT_FIELD_LOCATION).sendKeys(Data.location);
        WebElement checkboxConfirmation = driver.findElement(Locators.CHECKBOX_CONFIRMATION );
        boolean selectedCheckbox = checkboxConfirmation.isSelected();
        System.out.println(selectedCheckbox + "!!!!!!!");
        checkboxConfirmation.click();

        //SELECT DAY FROM DROPDOWN
        driver.findElement(Locators.SELECT_DROPDOWN_DATE).click();
        driver.findElement(Locators.DATE_OF_BIRTH).click();

        //SELECT MONTH FROM DROP DOWN
        driver.findElement(Locators.SELECT_DROPDOWN_MONTH).click();
        driver.findElement(Locators.MONTH_OF_BIRTH).click();


        //SELECT YEAR FROM DROPDOWN
        driver.findElement(Locators.SELECT_DROPDOWN_YEAR).click();
        driver.findElement(Locators.YEAR_OF_BIRTH).click();

    }

}