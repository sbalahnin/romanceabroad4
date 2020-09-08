package com.romanceabroad.ui;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.URL;


public class BaseUI {
    WebDriver driver;
    WebDriverWait wait;
    MainPage mainPage;
    SearchPage searchPage;
    HowWeWorkPage howWeWorkPage;
    ContactUsPage contactUsPage;
    PhotosPage photosPage;
    SoftAssert softAssert = new SoftAssert();

    protected TestBox testBox;

    protected enum TestBox {
        LOCAL, SAUCE, BROWSERS,
    }

    @BeforeMethod(groups = {"user", "admin", "ie"}, alwaysRun = true)
    @Parameters({"browser", "version", "platform", "testbox"})
    public void setup(@Optional("chrome") String browser, @Optional("null") String version, @Optional("null") String platform,
                      @Optional("local") String box, Method method) throws Exception {
        Reports.start(method.getDeclaringClass().getName() + " : " + method.getName());
        if (box.equalsIgnoreCase("local")) {
            testBox = TestBox.LOCAL;
        } else if (box.equalsIgnoreCase("sauce")) {
            testBox = TestBox.SAUCE;
        }
        switch (testBox) {
            case LOCAL:


                // Check if parameter passed from TestNG is 'firefox'
                if (browser.equalsIgnoreCase("firefox")) {
                    // Create firefox instance
                    System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                    driver = new FirefoxDriver();
                }
                // Check if parameter passed as 'chrome'
                else if (browser.equalsIgnoreCase("chrome")) {
                    // Set path to chromedriverOLD.exe
                    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                    // Create chrome instance
                    driver = new ChromeDriver();
                    driver.get("chrome://settings/clearBrowserData");
                } else if (browser.equalsIgnoreCase("IE")) {
                    System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    driver.manage().deleteAllCookies();
                } else {
                    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.get("chrome://settings/clearBrowserData");

                }
                break;
                case SAUCE:
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("username", "Andrew86");
                capabilities.setCapability("accessKey", "421bd7fc-73a5-4c13-98aa-c00c1660836f");
                capabilities.setCapability("browserName", browser);
                capabilities.setCapability("platform", platform);
                capabilities.setCapability("version", version);
                capabilities.setCapability("name",  method.getName());
                driver = new RemoteWebDriver(
                        new URL("http://" + System.getenv("SAUCE_USERNAME") + ":" + System.getenv("SAUCE_ACCESS_KEY") + "@ondemand.saucelabs.com:80/wd/hub"),
                        capabilities);
                break;

                }
                wait = new WebDriverWait(driver, 20);
                mainPage = new MainPage(driver, wait);
                searchPage = new SearchPage(driver, wait);
                contactUsPage = new ContactUsPage(driver, wait);
                howWeWorkPage = new HowWeWorkPage(driver, wait);
                photosPage = new PhotosPage(driver, wait);
                driver.manage().window().maximize();
                driver.get(Data.mainUrl);
        }

        @AfterMethod
        public void afterActions (ITestResult testResult){
            if (testResult.getStatus() == ITestResult.FAILURE) {
                Reports.fail(driver, testResult.getName());
            }
            Reports.stop();

            //driver.quit();
        }

}