package page;

import model.User;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends AbstractPage {
    private final String PAGE_URL = "https://xistore.by/#modalLogin";
    private final By linkErrorMessage = By.className("errortext");
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
        driver.navigate().to(PAGE_URL);
        authorizationButton.click();
        registrationButton.click();
        return this;
    }

    public RegistrationPage register(User user){
        log.info("register method has been called.");
        loginInput.sendKeys(user.getLogin());
        submitButton.click();
        return this;
    }

    public String getErrorMessage(){
        log.info("getErrorMessage method has been called.");
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(linkErrorMessage)).getText();
    }
}
