package test;

import driver.DriverSingleton;
import model.User;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;


public class LoginWithEmptyFieldsTest extends CommonCondition {
    Logger log = Logger.getLogger(LoginWithEmptyFieldsTest.class);
    private static final String ERROR_MESSAGE = "Неверный логин или пароль.";

    @Test
    public void loginWithEmptyFieldsTest(){
        log.info("loginWithEmptyFieldsTest has been started.");
        User testUserWithEmptyFields = new User("", "");
        String loginMessage = new LoginPage(DriverSingleton.getDriver())
                .openPage()
                .tryToLogin(testUserWithEmptyFields)
                .getErrorMessage();
        Assert.assertEquals(loginMessage, ERROR_MESSAGE);
    }
}
