package page;

import model.User;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@SuppressWarnings("unused")
public class RegistrationPage extends AbstractPage {
    private final static String PAGE_URL = "#modalLogin";
    private final static By linkErrorMessage = By.xpath("//*[@id=\"comp_36d8e386ca9debade673c72daf2f657c\"]/div/p");
    Logger log = Logger.getLogger(RegistrationPage.class);

    @FindBy(className = "navigation-cabinet-link")
    private WebElement authorizationButton;

    @FindBy(xpath = "//*[@id=\"system_auth_form\"]/div[2]/div[2]/a")
    private WebElement registrationButton;

    @FindBy(name = "REGISTER[EMAIL]")
    private WebElement loginInput;

    @FindBy(id = "register_submit_button")
    private WebElement submitButton;

    public RegistrationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public RegistrationPage openPage() {
        log.info("openPage method has been called.");
        driver.navigate().to(URL + PAGE_URL);
        authorizationButton.click();
        registrationButton.click();
        return this;
    }

    public RegistrationPage tryToRegister(User user){
        log.info("register method has been called.");
        loginInput.sendKeys(user.getLogin());
        submitButton.click();
        return this;
    }

    public String getErrorMessage(){
        log.info("getErrorMessage method has been called.");
        return waitForAllWebElements(linkErrorMessage).get(0).getText();
    }
}
