package test;

import driver.DriverSingleton;
import model.User;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.RegistrationPage;


public class RegistrationWithEmptyEmailFieldTest extends CommonCondition {
    Logger log = Logger.getLogger(RegistrationWithEmptyEmailFieldTest.class);
    private static final String WARNING_MESSAGE = "Поле \"Электронная почта\" обязательно для заполнения";

    @Test
    public void registrationWithEmptyEmailFieldTest(){
        log.info("registrationWithEmptyEmailFieldTest has been started.");
        User testUserWithEmptyFields = new User("", "");
        String registrationMessage = new RegistrationPage(DriverSingleton.getDriver())
                .openPage()
                .tryToRegister(testUserWithEmptyFields)
                .getErrorMessage();
        Assert.assertEquals(registrationMessage, WARNING_MESSAGE);
    }
}
