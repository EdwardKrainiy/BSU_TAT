package at.page;

import at.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends AbstractPage {
    private final String PAGE_URL = "https://xistore.by";
    private final By linkErrorMessage = By.className("errortext");

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
        driver.navigate().to(PAGE_URL);
        authorizationButton.click();
        registrationButton.click();
        return this;
    }

    public RegistrationPage register(User user){
        loginInput.sendKeys(user.getLogin());
        submitButton.click();
        return this;
    }

    public String getErrorMessage(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(linkErrorMessage)).getText();
    }
}
