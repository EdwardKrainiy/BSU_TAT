package test;

import driver.DriverSingleton;
import model.User;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;


public class LoginWithEmptyFieldsTest extends CommonCondition {
    Logger log = Logger.getLogger(LoginWithEmptyFieldsTest.class);

    @Test
    public void loginWithEmptyFieldsTest(){
        log.info("Test3 has been started.");
        User testUserWithEmptyFields = new User("", "");
        String errorMessage = new LoginPage(DriverSingleton.getDriver())
                .openPage()
                .tryToLogin(testUserWithEmptyFields)
                .getErrorMessage();
        Assert.assertEquals("Неверный логин или пароль.", errorMessage);
    }
}
