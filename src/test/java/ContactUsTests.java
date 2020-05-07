
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTests extends BaseUI {


    @Test
    public void checkContactAdministratorForm() {
        mainPage.verifySearchLink();
        mainPage.javaWaitSec(4);
        String contactUsLink = mainPage.verifyContactUsLink();
        System.out.println(contactUsLink);
        Assert.assertEquals(contactUsLink, Data.expectedUrlContactUs);
        int sizeOfDropDownListReasonOnContactUsPage = contactUsPage.getSizeDropDownList(Locators.DROP_DOWN_LIST_REASON);
        System.out.println(sizeOfDropDownListReasonOnContactUsPage);
        for (int i = 0; i < sizeOfDropDownListReasonOnContactUsPage; i++) {
            contactUsPage.selectItemRandomDropDownOption(Locators.DROP_DOWN_LIST_REASON, "Reason");
            mainPage.javaWaitSec(4);
            contactUsPage.completeContactAdministratorForm(Data.yourName, Data.yourEmail, Data.subject,
                    Data.message);
        }
    }
}
