package at.test;

import at.model.User;
import at.page.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationWithEmptyEmailFieldTest extends CommonCondition {
    @Test
    public void RegistrationWithEmptyEmailFieldTest(){
        User testUserWithEmptyFields = new User("", "");
        String errorMessage = new RegistrationPage(driver)
                .openPage()
                .register(testUserWithEmptyFields)
                .getErrorMessage();
        Assert.assertEquals("Поле \"Электронная почта\" обязательно для заполнения", errorMessage);
    }
}
