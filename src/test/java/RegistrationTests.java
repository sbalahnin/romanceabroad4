import org.testng.annotations.Test;


public class RegistrationTests extends BaseUI {

    @Test
    public void testRegistration() {
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(Data.email, Data.password);
        mainPage.secondPartOfRegistration(mainPage.generateNewNumber(Data.nickname, 10),
                Data.day, Data.month, Data.year, Data.phone, Data.location, Data.city);

    }
}
