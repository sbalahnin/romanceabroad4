import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseUI {


    @Test
    public void MainPageTest() {
        driver.switchTo().frame(mainPage.findYoutubeIframe());
        if (mainPage.findYoutubePlayButton().isDisplayed()) {
            Assert.assertTrue(mainPage.findYoutubePlayButton().isDisplayed(), "Video is displayed");
            System.out.println("Video is displayed");
            mainPage.findYoutubePlayButton().click();
        } else {
            Assert.fail("Video is not displayed");
        }

    }

    @Test
    public void testLinksOnMainPage() {
        mainPage.checkLinksOnWebPage("//a", "href");
        mainPage.checkLinksOnWebPage("//img", "src");
        driver.findElement(Locators.LINK_SEARCH);
        mainPage.checkLinksOnWebPage("//a", "href");
        mainPage.checkLinksOnWebPage("//img", "src");

    }


}

