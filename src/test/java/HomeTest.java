import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomeTest extends BaseUI {




    @Test
    public void MainPageTest () {
        WebElement ele = driver.findElement(Locators.YOUTUBE_LINK);
        driver.switchTo().frame(ele);
        driver.findElement(Locators.YOUTUBE_PLAY_BUTTON).click();


    }



}
