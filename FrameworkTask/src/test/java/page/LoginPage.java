package page;

import model.User;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends AbstractPage {
    private final String PAGE_URL = "#modalLogin";
    private final By linkErrorMessage = By.xpath("//*[@id=\"comp_e4a030fa544c48699047d8b0f024d2eb\"]/p");
    Logger log = Logger.getLogger(LoginPage.class);

    @FindBy(className = "navigation-cabinet-list")
    private WebElement authorizationButton;

    @FindBy(name = "USER_LOGIN")
    private WebElement loginInput;

    @FindBy(name = "USER_PASSWORD")
    private WebElement passwordInput;

    @FindBy(className = "modal-input-button")
    private WebElement submitButton;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage() {
        log.info("openPage method has been called.");
        driver.navigate().to(URL + PAGE_URL);
        authorizationButton.click();
        return this;
    }

    public LoginPage tryToLogin(User user){
        log.info("login method has been called.");
        loginInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        submitButton.click();
        return this;
    }

    public String getErrorMessage(){
        log.info("getErrorMessage method has been called.");
        return getFinalWebElementWhichNeedInTest(linkErrorMessage).get(0).getText();
    }
}
