package page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BuyingPage extends AbstractPage {
    private final String PAGE_URL = "https://xistore.by/catalog/telefony/";
    private final By amountOfItemsOnBasketElement = By.xpath("//*[@id=\"basket_items_list\"]/div[1]/span");
    Logger log = Logger.getLogger(BuyingPage.class);

    @FindBy(xpath = "//*[@id=\"bx_1717408340_10342\"]/div[4]/div/div[1]/a")
    private WebElement buyPhoneButton;

    @FindBy(className = "button-link-pay")
    private WebElement addToBasketButton;

    public BuyingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public BuyingPage openPage() {
        log.info("openPage method has been called.");
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public BuyingPage buyPhone(){
        log.info("buyPhone method has been called.");
        buyPhoneButton.click();
        return this;
    }

    public BuyingPage addToBasket(){
        log.info("addToBasket method has been called.");
        addToBasketButton.click();
        addToBasketButton.click();
        return this;
    }

    public int getAmountOfPhones(){
        log.info("getAmountOfPhones method has been called.");
        return new Integer (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(amountOfItemsOnBasketElement)).getText());
    }
}
