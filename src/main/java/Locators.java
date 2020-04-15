import org.openqa.selenium.By;

public class Locators {


    //MainPage

    public static final  By YOUTUBE_LINK = By.xpath("//iframe[@src='https://www.youtube.com/embed/RRECuJzm3IY?start=85']");
    public static final  By YOUTUBE_PLAY_BUTTON = By.cssSelector("button.ytp-large-play-button.ytp-button");



   //HowWeWork page
   public static final By HOW_WE_WORK_LINK = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");

   //GiftsLink
   public static final By GIFTS_LINK = By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']");


   //TourToUkraine Link
   public static final By TOUR_TO_UKRAINE_LINK = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine'][text()='TOUR TO UKRAINE']");

   //Media page
    public static final By LINK_MEDIA = By.cssSelector("a[href='https://romanceabroad.com/media/index']");

    //Blog page
    public static final By BLOG_LINK = By.cssSelector("a[class='nav-link ']");
    public static final int indexLinkBlog = 2;

    //SignIn page
    public static final By LINK_SIGN_IN = By.xpath("//a[@href='https://romanceabroad.com/users/login_form']");


    //Registration
    public static final By BUTTON_REGISTRATION = By.xpath("//button[@id='show-registration-block']");
    public static final By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static final By TEXT_FIELD_EMAIL = By.cssSelector("input#email");
    public static final By TEXT_FIELD_PASSWORD = By.cssSelector("input#password");
    public static final By TEXT_FIELD_NICKNAME = By.cssSelector("input#nickname");
    public static final By TEXT_FIELD_PHONE = By.cssSelector("input[name='data[phone]']");

    //Day drop down selected
    public static final By LIST_DATE = By.xpath("//div[@id='daySelect']");
    public static final By DATE_OF_BIRTH = By.xpath("//li[@data-handler='selectDay']//a[text()='5']");

    //MONTH DROP DOWN
    public static final By LIST_MONTH = By.xpath("//div[@id='monthSelect']");
    public static final By MONTH_OF_BIRTH = By.xpath("//li[@data-handler='selectMonth']//a[text()='Jun']");


    //YEAR DROP DOWN
    public static final By LIST_YEAR = By.xpath("//div[@id='yearSelect']");
    public static final By YEAR_OF_BIRTH = By.xpath("//li[@data-handler='selectYear']//a[text()='1986']");



    public static final By TEXT_FIELD_LOCATION = By.cssSelector("input[placeholder='Type your location']");
    public static final By CHECKBOX_CONFIRMATION = By.cssSelector("input#confirmation");


    //Search
    public static final By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    public static final By DROP_DOWN_LIST_SORT_BY = By.xpath("//div[@class='form-inline']//select");

}



