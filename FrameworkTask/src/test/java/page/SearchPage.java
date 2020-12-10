package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends AbstractPage {
    private final String PAGE_URL = "https://xistore.by";
    private final By searchMessageElement = By.className("search-result-new");
    private final By firstSearchedPhoneElement = By.className("search__page_item-name");

    @FindBy(className = "input-search-button")
    private WebElement submitSearchButton;

    @FindBy(id = "title-search-input")
    private WebElement searchField;

    public SearchPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public SearchPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public SearchPage searchWithEmptyField(){
        submitSearchButton.click();
        return this;
    }

    public SearchPage searchWithFilledField(String query){
        searchField.sendKeys(query);
        submitSearchButton.click();
        return this;
    }

    public String getSearchMessage(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(searchMessageElement)).getText();
    }

    public String getNameOfTheFirstPhone(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(firstSearchedPhoneElement)).getText();
    }
}
