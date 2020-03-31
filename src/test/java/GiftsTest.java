import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftsTest extends BaseUI{
        String currentUrlGifts;


        @Test
        public void testGiftsLink () {
            driver.findElement(Locators.GIFTS_LINK).click();
            currentUrlGifts = driver.getCurrentUrl();
            System.out.println(currentUrlGifts);
            Assert.assertEquals(currentUrlGifts,Data.expectedUrlGifts);

        }
    }

