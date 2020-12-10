package at.test;

import at.model.User;
import at.page.LoginPage;
import at.page.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithEmptyFieldsTest extends CommonCondition {
    @Test
    public void LoginWithEmptyFieldsTest(){
        User testUserWithEmptyFields = new User("", "");
        String errorMessage = new LoginPage(driver)
                .openPage()
                .login(testUserWithEmptyFields)
                .getErrorMessage();
        Assert.assertEquals("Неверный логин или пароль.", errorMessage);
    }
}
