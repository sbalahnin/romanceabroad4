import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        List<WebElement> links = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++) {
            String info = links.get(i).getText();
            System.out.println(info);
            links.get(i).click();
            driver.get(Data.expectedUrlSignIn);
            links = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));
        }

    }


                                       //Homework for Lesson 10
              // Create 3 types of Conditions (String, Integer, Boolean) + Boolean with "isSelected + Assert.fail
    @Test
    public void tesCase8 () {
         String car1 = "Audi";
         String car2 = "BMW";

        if (car1.contains("Audi") || car2.contains("Audi")) {
            System.out.println("You bought a German car!!!");
        } else {
            Assert.fail("User not found");
        }
    }

    @Test
    public void testCase9(){
        int companies = 7;
        int total;

        if(companies==7){
            total = 100+7;

        }else{
            total=100-7;
        }
        System.out.println(total);
    }

    @Test
    public void testCase10 () {
        WebElement blogLink = driver.findElement(Locators.BLOG_LINK);
        if(blogLink.isDisplayed()){
            blogLink.click();
        }else{
            Assert.fail("We cannot find Blog tab");
        }
    }

                          //Create  ArrayLists (String, Integer, WebElement) + Loops with String and WebElements;
    @Test
    public void testCases11 (){
        List<String> userName = new ArrayList<>(Arrays.asList("Steven", "Michael", "John", "William", "Andrew", "Matt", "Eric"));
        System.out.println(userName);
        for (int i = 0; i <7 ; i++) {
        boolean firstName = userName.get(i).contentEquals("Andrew");
        System.out.println(firstName);
        }

    }
    @Test
    public void testCase12 (){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(25, 78, 34, 147, 213));
        int sum = numbers.get(0)+numbers.get(2)+numbers.get(4);
        System.out.println(sum);
    }

    @Test
    public void testCase13 () {
        List<WebElement> hyperlinks = driver.findElements(By.xpath("//a"));
        System.out.println(hyperlinks.size());
        for (int i = 0; i <hyperlinks.size() ; i++) {
        String allElements = hyperlinks.get(i).getText();
        System.out.println(allElements);

        }
    }

}





