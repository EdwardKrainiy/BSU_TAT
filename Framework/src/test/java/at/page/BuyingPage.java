package at.page;

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
    private final By amountOfOnePhoneOnBasketElement = By.xpath("//*[@id=\"QUANTITY_INPUT_426340\"]");
    private final By basketIsEmptyTextElement = By.xpath("/html/body/div[2]/div[5]/div/div/div/div/div");

    @FindBy(xpath = "//*[@id=\"426340\"]/td[4]/div/a[1]")
    private WebElement plusButtonElement;

    @FindBy(xpath = "//*[@id=\"426362\"]/td[4]/div/a[2]")
    private WebElement minusButtonElement;

    @FindBy(xpath = "//a[@class='mbw-delete']")
    private WebElement deleteFromBasketButton;

    @FindBy(xpath = "//*[@id=\"bx_1717408340_10342\"]/div[4]/div/a")
    private WebElement buyPhoneButton;

    @FindBy(xpath = "//*[@id=\"bx_2369550383_10342_buy_link\"]")
    private WebElement addToBasketButton;

    public BuyingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public BuyingPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public BuyingPage buyPhone(){
        buyPhoneButton.click();
        return this;
    }

    public BuyingPage addToBasket(){
        addToBasketButton.click();
        return this;
    }

    public int getAmountOfPhones(){
        return new Integer (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(amountOfItemsOnBasketElement)).getText());
    }

    public BuyingPage clickOnPlusButton(){
        plusButtonElement.click();
        return this;
    }

    public BuyingPage clickOnMinusButton(){
        minusButtonElement.click();
        return this;
    }

    public int getAmountOfThisPhone(){
        return new Integer (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(amountOfOnePhoneOnBasketElement)).getText());
    }

    public BuyingPage deletePhoneFromBasket(){
        deleteFromBasketButton.click();
        return this;
    }

    public String getBasketIsEmptyText(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(basketIsEmptyTextElement)).getText();
    }
}
