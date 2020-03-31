import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class SignInTest extends BaseUI{
            String currentUrlSignIn;

        @Test
        public void testSignInTest() {
            WebElement linkSignIn = driver.findElement(Locators.LINK_SIGN_IN);
            linkSignIn.click();
            currentUrlSignIn = driver.getCurrentUrl();
            System.out.println(currentUrlSignIn);
            Assert.assertEquals(currentUrlSignIn, Data.expectedUrlSignIn);

        }

    }

