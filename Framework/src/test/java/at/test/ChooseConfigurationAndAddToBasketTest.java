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

    
}
