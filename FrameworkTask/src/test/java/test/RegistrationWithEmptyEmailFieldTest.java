package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.RegistrationPage;

public class RegistrationWithEmptyEmailFieldTest extends CommonCondition {

    @Test
    public void RegistrationWithEmptyEmailFieldTest(){
        System.out.println("Test4");

        User testUserWithEmptyFields = new User("", "");
        String errorMessage = new RegistrationPage(driver)
                .openPage()
                .register(testUserWithEmptyFields)
                .getErrorMessage();
        Assert.assertEquals("Поле \"Электронная почта\" обязательно для заполнения", errorMessage);
    }
}
