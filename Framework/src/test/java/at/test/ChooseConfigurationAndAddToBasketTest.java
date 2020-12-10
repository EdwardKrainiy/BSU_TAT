package at.test;

import at.page.BuyingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChooseConfigurationAndAddToBasketTest extends CommonCondition {
    @Test
    public void ChooseConfigurationAndAddToBasketTest(){
        int amountOfPhonesOnBasket = new BuyingPage(driver)
                .openPage()
                .buyPhone()
                .addToBasket()
                .getAmountOfPhones();
        Assert.assertEquals(amountOfPhonesOnBasket, 1);
    }
    
    @Test
    public void AddingAndSubtractingAmountOfPhoneTest(){
        BuyingPage buyingPage = new BuyingPage(driver);
        int amountOfPhonesOnBasketBeforeAddingAndSubtracting = buyingPage
                .openPage()
                .buyPhone()
                .addToBasket()
                .getAmountOfPhones();
        int amountOfPhonesOnBasketAfterAddingAndSubtracting = buyingPage
                .clickOnMinusButton()
                .clickOnPlusButton()
                .getAmountOfPhones();
        Assert.assertEquals(amountOfPhonesOnBasketBeforeAddingAndSubtracting, amountOfPhonesOnBasketAfterAddingAndSubtracting);
    }

    @Test
    public void DeletingPhoneFromBasket(){
        String basketIsEmptyText = new BuyingPage(driver)
                .openPage()
                .buyPhone()
                .addToBasket()
                .deletePhoneFromBasket()
                .getBasketIsEmptyText();
        Assert.assertEquals(basketIsEmptyText, "Вы ничего не добавили в корзину");
    }
    
}
