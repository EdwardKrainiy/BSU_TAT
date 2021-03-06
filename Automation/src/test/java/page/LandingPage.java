package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

    private WebDriver driver;

    public LandingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"title-search-input\"]")
    public WebElement searchField;

    @FindBy(xpath = "//*[@id=\"title-search\"]/form/button")
    public WebElement searchButton;

    public WebElement getCloseAdButton(){
        try {
            return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.className("popmechanic-close")));
        } catch (Exception e){
            System.out.println("Ad not found.");
            return null;
        }
    }

    public void clickCloseAdButton(){
        if(getCloseAdButton() != null){
            getCloseAdButton().click();
        }
    }

    public void inputStringToSearchField(String query){
        searchField.sendKeys(query);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public String getNameOfTheFirstPhoneOnPage(){
        return this.driver.findElement(By.className("search__page_item-name")).getText();
    }
}


