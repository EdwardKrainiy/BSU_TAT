package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "search__page_item-name")
    public List<WebElement> phoneLinksOnThePage;

    @FindBy(xpath = "//*[@id=\"bx_2369550383_10342_buy_link\"]")
    public WebElement addToBasketButton;

    public void clickOnTheFirstPhoneLink(){
        phoneLinksOnThePage.get(0).click();
    }

    public void clickAddToBasketButton(){
        addToBasketButton.click();
    }

    public String getAmountOfItemsInBasket(){
        return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.className("basket_items_list-head"))).getText();
    }
}
