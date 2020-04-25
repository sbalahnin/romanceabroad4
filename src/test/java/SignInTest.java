import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseUI {

    @Test
    public void testSignInTest() {
        String signInLink = mainPage.verifySignInLink();
        System.out.println(signInLink);
        Assert.assertEquals(signInLink, Data.expectedUrlSignIn);

    }

}

