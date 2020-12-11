package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
    private final String PAGE_URL = "https://xistore.by";
    private final By linkErrorMessage = By.className("errortext");

    @FindBy(className = "navigation-cabinet-link")
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
        driver.navigate().to(PAGE_URL);
        authorizationButton.click();
        return this;
    }

    public LoginPage login(User user){
        loginInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        submitButton.click();
        return this;
    }

    public String getErrorMessage(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(linkErrorMessage)).getText();
    }
}
