import org.testng.Assert;
import org.testng.annotations.Test;

public class BlogTest extends BaseUI {
    String currentUrlBlog;


    @Test
    public void testBlogLink() {
        driver.findElements(Locators.BLOG_LINK).get(Locators.indexLinkBlog).click();
        currentUrlBlog = driver.getCurrentUrl();
        System.out.println(currentUrlBlog);
        Assert.assertEquals(currentUrlBlog, Data.expectedUrlBlog);
    }



}
