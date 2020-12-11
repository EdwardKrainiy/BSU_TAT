package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import page.LoginPage;


public class LoginWithEmptyFieldsTest extends CommonCondition {
    Logger log = Logger.getLogger(LoginWithEmptyFieldsTest.class);

    @Test
    public void LoginWithEmptyFieldsTest(){
        log.info("Test ");
        User testUserWithEmptyFields = new User("", "");
        String errorMessage = new LoginPage(driver)
                .openPage()
                .login(testUserWithEmptyFields)
                .getErrorMessage();
        Assert.assertEquals("Неверный логин или пароль.", errorMessage);
    }
}
