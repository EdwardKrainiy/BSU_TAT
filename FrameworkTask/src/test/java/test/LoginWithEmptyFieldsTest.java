package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;

public class LoginWithEmptyFieldsTest extends CommonCondition {

    @Test
    public void LoginWithEmptyFieldsTest(){
        System.out.println("Test3");

        User testUserWithEmptyFields = new User("", "");
        String errorMessage = new LoginPage(driver)
                .openPage()
                .login(testUserWithEmptyFields)
                .getErrorMessage();
        Assert.assertEquals("Неверный логин или пароль.", errorMessage);
    }
}
