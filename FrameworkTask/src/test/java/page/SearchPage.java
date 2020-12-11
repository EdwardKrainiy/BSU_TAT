package page;

import org.apache.log4j.Logger;
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
    Logger log = Logger.getLogger(SearchPage.class);

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
        log.info("openPage method has been called.");
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public SearchPage searchWithEmptyField(){
        log.info("searchWithEmptyField method has been called.");
        submitSearchButton.click();
        return this;
    }

    public SearchPage searchWithFilledField(String query){
        log.info("searchWithFilledField method has been called.");
        searchField.sendKeys(query);
        submitSearchButton.click();
        return this;
    }

    public String getSearchMessage(){
        log.info("getSearchMessage method has been called.");
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(searchMessageElement)).getText();
    }

    public String getNameOfTheFirstPhone(){
        log.info("getNameOfTheFirstPhone method has been called.");
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(firstSearchedPhoneElement)).getText();
    }
}
