package page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@SuppressWarnings("unused")
public class ComparingPage extends AbstractPage {
    private final static String PAGE_URL = "catalog/telefony/";
    private final static By listOfPhonesOnComparingPage =  By.className("b-mobile-img");
    Logger log = Logger.getLogger(ComparingPage.class);

    @FindBy(className = "js_compare_id_10342")
    private WebElement compareFirstPhoneButton;

    @FindBy(className = "js_compare_id_25893")
    private WebElement compareSecondPhoneButton;

    @FindBy(className = "comparison-mob__btn")
    private WebElement sendToComparingPageButton;

    @FindBy(className = "remove-item")
    private WebElement removeFromComparingButton;

    public ComparingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ComparingPage openPage() {
        log.info("openPage method has been called.");
        driver.navigate().to(URL + PAGE_URL);
        return this;
    }

    public ComparingPage compareTwoPhones(){
        log.info("compareTwoPhones method has been called.");
        compareFirstPhoneButton.click();
        compareSecondPhoneButton.click();
        return this;
    }

    public ComparingPage moveToComparingPage(){
        log.info("moveToComparingPage method has been called.");
        sendToComparingPageButton.click();
        return this;
    }

    public int getAmountOfPhonesOnComparingPage(){
        log.info("getAmountOfPhonesOnComparingPage method has been called.");
        return waitForAllWebElements(listOfPhonesOnComparingPage).size() / 2;
    }

    public ComparingPage removeOnePhoneFromComparing(){
        log.info("removeOnePhoneFromComparing method has been called.");
        removeFromComparingButton.click();
        return this;
    }
}
