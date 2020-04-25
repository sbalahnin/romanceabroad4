import org.testng.Assert;
import org.testng.annotations.Test;

public class BlogTest extends BaseUI {


    @Test
    public void testBlogLink() {
        String blogLink = mainPage.verifyBlogLink();
        System.out.println(blogLink);
        Assert.assertEquals(blogLink, Data.expectedUrlBlog);
    }

}
