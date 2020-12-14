package test;

import model.User;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.RegistrationPage;


public class RegistrationWithEmptyEmailFieldTest extends CommonCondition {
    Logger log = Logger.getLogger(RegistrationWithEmptyEmailFieldTest.class);

    @Test
    public void registrationWithEmptyEmailFieldTest(){
        log.info("Test4 has been started.");
        User testUserWithEmptyFields = new User("", "");
        String errorMessage = new RegistrationPage(driver)
                .openPage()
                .tryToRegister(testUserWithEmptyFields)
                .getErrorMessage();
        Assert.assertEquals("Поле \"Электронная почта\" обязательно для заполнения", errorMessage);
    }
}
