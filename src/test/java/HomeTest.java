import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseUI {


    @Test
    public void MainPageTest() {
        WebElement ele = driver.findElement(Locators.YOUTUBE_LINK);
        driver.switchTo().frame(ele);
        WebElement playButton =  driver.findElement(Locators.YOUTUBE_PLAY_BUTTON);
        if(playButton.isDisplayed()){
            Assert.assertTrue(playButton.isDisplayed(),"Video is displayed");
            System.out.println("Video is displayed");
            playButton.click();
        }else{
            Assert.fail("Video is not displayed");
        }

    }

}
