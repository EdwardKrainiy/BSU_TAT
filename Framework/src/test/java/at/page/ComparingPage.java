package at.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComparingPage extends AbstractPage {
    private final String PAGE_URL = "https://xistore.by/catalog/telefony/";
    private final By listOfPhonesOnComparingPage =  By.className("mCS_img_loaded");

    @FindBy(xpath = "//*[@id=\"bx_1717408340_10342\"]/div[2]/a")
    private WebElement compareFirstPhoneButton;

    @FindBy(xpath = "//*[@id=\"bx_1717408340_25893\"]/div[2]/a")
    private WebElement compareSecondPhoneButton;

    @FindBy(xpath = "/html/body/div[2]/footer/div[3]/a[1]")
    private WebElement sendToComparingPageButton;

    @FindBy(className = "remove-item")
    private WebElement removeFromComparingButton;

    public ComparingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ComparingPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public ComparingPage compareTwoPhones(){
        compareFirstPhoneButton.click();
        compareSecondPhoneButton.click();
        return this;
    }

    public ComparingPage moveToComparingPage(){
        sendToComparingPageButton.click();
        return this;
    }

    public int getAmountOfPhonesOnComparingPage(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listOfPhonesOnComparingPage)).size() / 2;
    }

    public ComparingPage removeOnePhoneFromComparing(){
        removeFromComparingButton.click();
        return this;
    }
}
