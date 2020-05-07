import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends BaseActions {

    public ContactUsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

   // public void verifyDropDownListOnContactUsPage() {
     //   WebElement dropDownListOnContactUsPage = driver.findElement(Locators.DROP_DOWN_LIST_REASON);
    //    getDropDownListByText(dropDownListOnContactUsPage, "Technical Support");
    //}

    public void completeContactAdministratorForm(String yourName, String yourEmail,
                                                 String subject, String message) {
        driver.findElement(Locators.TEXT_FIELD_YOUR_NAME).clear();
        driver.findElement(Locators.TEXT_FIELD_YOUR_NAME).sendKeys(yourName);
        driver.findElement(Locators.TEXT_FIELD_EMAIL_ON_CONTACT_US_PAGE).clear();
        driver.findElement(Locators.TEXT_FIELD_EMAIL_ON_CONTACT_US_PAGE).sendKeys(yourEmail);
        driver.findElement(Locators.TEXT_FIELD_SUBJECT).clear();
        driver.findElement(Locators.TEXT_FIELD_SUBJECT).sendKeys(subject);
        driver.findElement(Locators.TEXT_FIELD_MESSAGE).clear();
        driver.findElement(Locators.TEXT_FIELD_MESSAGE).sendKeys(message);
        // driver.findElement(Locators.BUTTON_SUBMIT).click();


    }

}



