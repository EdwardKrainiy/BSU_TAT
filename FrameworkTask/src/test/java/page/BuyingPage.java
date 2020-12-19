package page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BuyingPage extends AbstractPage {
    private final String PAGE_URL = "catalog/telefony/";
    private final By amountOfItemsOnBasketElement = By.xpath("//*[@id=\"basket_items_list\"]/div[1]/span");
    Logger log = Logger.getLogger(BuyingPage.class);

    @FindBy(className = "search__page_item-name")
    private WebElement buyPhoneButton;

    @FindBy(className = "button-link-orange")
    private WebElement addToBasketButton;

    public BuyingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public BuyingPage openPage() {
        log.info("openPage method has been called.");
        driver.navigate().to(URL + PAGE_URL);
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
        return new Integer(getFinalWebElementWhichNeedInTest(amountOfItemsOnBasketElement).get(0).getText());
    }
}
