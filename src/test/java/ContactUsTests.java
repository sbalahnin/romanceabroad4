
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ContactUsTests extends BaseUI {
    @DataProvider(name = "ContactUs")
    public static Object[][] testContactUs2() throws Exception {
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("ContactUs.csv")).stream().forEach(s -> {
            String[] data = s.split(",");
            out.add(new Object[]{data[3]});
        });
        return out.toArray(new Object[out.size()][]);
    }

    @Test (dataProvider = "ContactUs")
    public void checkContactAdministratorForm(String message ) {
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
                    message);
        }
    }
}
