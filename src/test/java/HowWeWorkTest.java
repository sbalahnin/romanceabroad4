
import org.testng.Assert;
import org.testng.annotations.Test;



    public class HowWeWorkTest extends BaseUI {
        String currentUrlHowWeWork;


        @Test
        public void testHowWeWorkLink() {
            driver.findElement(Locators.HOW_WE_WORK_LINK).click();
            currentUrlHowWeWork = driver.getCurrentUrl();
            System.out.println(currentUrlHowWeWork);
            Assert.assertEquals(currentUrlHowWeWork, Data.expectedUrlHowWeWok);

        }
    }












































































