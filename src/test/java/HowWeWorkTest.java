
import org.testng.Assert;
import org.testng.annotations.Test;


public class HowWeWorkTest extends BaseUI {


    @Test
    public void testHowWeWorkLink() {
        String howWeWorkLink = mainPage.verifyHowWeWorkLink();
        System.out.println(howWeWorkLink);
        Assert.assertEquals(howWeWorkLink, Data.expectedUrlHowWeWok);

    }
}












































































