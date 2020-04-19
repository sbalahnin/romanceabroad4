import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class RegistrationTests extends BaseUI {

    @Test
    public void testRegistration() {
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration();
        mainPage.secondPartOfRegistration();

                 //Homework 10. Created hard assertions (Assert.assertTrue, Assert.fail).

        WebElement confirmation = driver.findElement(Locators.CHECKBOX_CONFIRMATION);
        if (confirmation.isSelected()) {
            Assert.assertTrue(confirmation.isSelected(), "Checkbox is selected");
            System.out.println("Check box is already selected");
        }else{
            Assert.fail("Checkbox is not selected");
        }

    }
}
