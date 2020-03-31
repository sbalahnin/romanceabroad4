import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

    public class SignInTest extends BaseUI{
            String currentUrlSignIn;

        @Test
        public void testSignInTest() {
            WebElement linkSignIn = driver.findElement(Locators.LINK_SIGN_IN);
            linkSignIn.click();

        }

    }

