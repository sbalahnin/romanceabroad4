import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConditionsTest extends BaseUI {

    @Test
    public void conditionsTest1() {
        String fruit = "orange";
        String fruit2 = "Apple";

        if (fruit.contains("apple") || fruit2.contains("Apple")) {
            System.out.println("We can find our fruit");
        } else {
            Assert.fail("We cannot find fruit");
        }
    }

    @Test
    public void conditionsTest2() {
        int number = 10;
        int sum;

        if (number == 10 + 5) {
            sum = 95 + 100;
        } else {
            sum = 100 - 95;
        }
        System.out.println(sum);
    }

    @Test
    public void testCase3() {
        boolean requirement = false;

        if (requirement) {
            System.out.println("Boolean is true");
        } else {
            Assert.fail("Boolean is false");
        }

    }
    /*@Test
    public void testCase4 (){
        WebElement tabSearch = driver.findElement(Locators.LINK_SEARCH);

        if (tabSearch.isDisplayed()){
            tabSearch.click();
        }
        else {
            Assert.fail("we cannot find Pretty Women tab");
        }

    }
        @Test
        public void testCase5 (){
            mainPage.clickJoinButton();
            mainPage.completeFirstPartOfRegistration();
            mainPage.secondPartOfRegistration();


            WebElement checkbox = driver.findElement(Locators.CHECKBOX_CONFIRMATION);

            if (!checkbox.isSelected()){
                checkbox.click();
            }
            else {
                Assert.fail("Checkbox is unselected");
            }
        }*/

    @Test
    public void textCase6() {
        List<Integer> crunchifyList1 = new ArrayList<>(Arrays.asList(5, 10, 19));
        int sum = crunchifyList1.get(1) + crunchifyList1.get(2);
        System.out.println(sum);

    }

    @Test
    public void testCase7() {
        String actualTitle;
        String actualUrlPrettyWomen;
        String info;


        List<WebElement> links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++) {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            info = links.get(i).getText();
            System.out.println(info);
            // links.get(i).click();
            mainPage.ajaxClick(links.get(i));


            if (info.contains("WORK")) {
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                Assert.assertEquals(Data.expectedTitleHowWeWork, actualTitle);
            }
            if (info.contains("Pretty Women")) {
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlPrettyWomen = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedTitlePrettyWomen, actualTitle);
                Assert.assertEquals(actualUrlPrettyWomen, Data.expectedUrlPrettyWomen);
                driver.findElement(Locators.IMAGES).isDisplayed();

                if (actualUrlPrettyWomen.contains("#")) {
                    Assert.fail("It contains restricted #");
                } else {
                    System.out.println("No special characters. It is good url!!!");
                }
            }

            driver.get(Data.expectedUrlSignIn);
            links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        }
    }

    @Test
    public void testCase9() {
        mainPage.ajaxClick(Locators.TAB_OF_MAIN_PAGE, 3);


    }
}




















