import org.openqa.selenium.By;

public class Locators {


    //MainPage
    public static final By YOUTUBE_LINK = By.xpath("//iframe[@src='https://www.youtube.com/embed/RRECuJzm3IY?start=85']");
    public static final By YOUTUBE_PLAY_BUTTON = By.cssSelector("button.ytp-large-play-button.ytp-button");
    public static final By TITLE_OF_PAGE = By.xpath("//h1");
    public static final By TAB_OF_MAIN_PAGE = By.xpath("//ul[@class='navbar-nav']//li");

    //HowWeWork page
    public static final By HOW_WE_WORK_LINK = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    public static final By IMAGES = By.xpath("//a[@class='g-pic-border g-rounded']");

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
    public static final By LIST_DAYS = By.xpath("//div[@id='daySelect']");
    public static final By LIST_VALUE_DAY = By.xpath("//li[@data-handler='selectDay']");

    //MONTH DROP DOWN
    public static final By LIST_MONTHS = By.xpath("//div[@id='monthSelect']");
    public static final By LIST_VALUE_MONTH = By.xpath("//li[@data-handler='selectMonth']");

    //YEAR DROP DOWN
    public static final By LIST_YEARS = By.xpath("//div[@id='yearSelect']");
    public static final By LIST_VALUE_YEAR = By.xpath("//li[@data-handler='selectYear']");



    public static final By AUTOFILLING_FORM = By.xpath("//input[@name='region_name']");
    public static final By LIST_VALUE_LOCATIONS = By.xpath("//div[@class='dropdown dropdown_location']//ul/li");


    public static final By CHECKBOX_CONFIRMATION = By.cssSelector("input#confirmation");

    //Search
    public static final By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    public static final By DROP_DOWN_LIST_SORT_BY = By.xpath("//div[@class='form-inline']//select");
    public static final By DROP_DOWN_MAX_AGE = By.cssSelector("select#age_max");


                         //Homework 14:  Create 10 xpath with 2 attributes
    //Pretty Women Page
    public static final By MENU_LIST_VIEW = By.xpath("//a[@href='javascript:void(0);'][@class='active']");
    public static final By BUTTON_SENT_MESSAGE = By.xpath("//button[@id='btn_write_message_836500'][@class='btn btn-secondary']");
    public static final By PAGINATION_SECOND_PAGE = By.xpath("//a[@href='https://romanceabroad.com/users/search/default/DESC/2'][text()='2']");

    //PHOTOS PAGE
    public static final By LINK_PHOTO_GALLERY = By.xpath("//a[@href='https://romanceabroad.com/media/photo'][@class='b-tabs__text']");
    public static final By LINK_ALBUMS_GALLERY = By.xpath("//a[@href='https://romanceabroad.com/media/albums'][@class='b-tabs__text']");

    //GIFT PAGE
    public static final By BUTTON_FIND_PEOPLE= By.xpath("//button[@type='submit'][@id='main_search_button_user_line']");
    public static final By LINK_INDIVIDUAL_TOUR_TO_UKRAINE = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/5-vip_individual_tour_to_ukraine'][text()='Individual trip to Ukraine']");

    //Tour to Ukraine page
    public static final By BUTTON_PAY_WITH_PAY_PAL = By.xpath("//a[@class='btn btn-primary btn-block'][@target='_blank']");

   //BLOG page
    public static final By LINK_KHARKOV_DATING_AGENCY = By.xpath("//a[@href='/content/view/kharkov-dating-agency'][text()='Kharkov dating agency']");
    public static final By LINK_WEST_WEB_ART = By.xpath("//a[@href='http://westwebart.ru'][@target='_blank']");


    //Create 10 xpaths with 2 parents.
           //Home page
    public static final By LINK_PHONE_NUMBER = By.xpath("//i//a[@href='callto:18885997816']");
    public static final By LINK_EMAIL = By.xpath("//i//span//a[@href='mailto:support@romanceabroad.com']");
    public static final By LINK_FACEBOOK = By.xpath("//div//img[@src='/img/facebook-ico.jpg']");
    public static final By IMAGE_ROMANCE_ABROAD = By.xpath("//div//a//img[@src='/img/logo.jpg']");
    public static final By TITLE_UKRAINIAN_BRIDES = By.xpath("//div/h2[@class='section-heading text-white']");
    public static final By BUTTON_JOIN_NOW = By.xpath("//span//a[@href='#']");
    public static final By BUTTON_REQUEST_TOUR_INFO = By.xpath("//div//a[@class='btn btn-primary btn-xl js-scroll-trigger']");
    public static final By BUTTON_LOGIN = By.xpath("//header//div//a[@id='ajax_login_link']");

            //Gift page
    public static final By LINK_HELP= By.xpath("//div//div[@class='footer-menu-title-block'][@id='footer-menu-title-0']");
    public static final By LINK_RUSSIAN_LANGUAGE = By.xpath("//ul//li[@class='last']");

    //ContactUs page
    public static final By LINK_CONTACT_US = By.xpath("//a[@href='https://romanceabroad.com/tickets/']");
    public static final By DROP_DOWN_LIST_REASON = By.cssSelector("select.form-control");
    public static final By TEXT_FIELD_YOUR_NAME = By.xpath("//input[@name='user_name']");
    public static final By TEXT_FIELD_EMAIL_ON_CONTACT_US_PAGE = By.xpath("//input[@name='user_email']");
    public static final By TEXT_FIELD_SUBJECT = By.xpath("//input[@name='subject']");
    public static final By TEXT_FIELD_MESSAGE = By.xpath("//textarea[@name='message']");
    public static final By BUTTON_SUBMIT = By.xpath("//input[@type='submit']");


}



