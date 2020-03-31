import org.testng.Assert;
import org.testng.annotations.Test;

public class TourToUkraineTest extends BaseUI{
        String currentUrlTourUkraine;

        @Test
        public void testTourToUkraineLink () {
            driver.findElement(Locators.TOUR_TO_UKRAINE_LINK).click();
            currentUrlTourUkraine = driver.getCurrentUrl();
            System.out.println(currentUrlTourUkraine);
            Assert.assertEquals(currentUrlTourUkraine, Data.expectedUrlTourUkraine);

        }

    }

