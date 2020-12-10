package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.BuyingPage;

public class ChooseConfigurationAndAddToBasketTest extends CommonCondition {

    @Test
    public void ChooseConfigurationAndAddToBasketTest(){
        System.out.println("Test2");

        int amountOfPhonesOnBasket = new BuyingPage(driver)
                .openPage()
                .buyPhone()
                .addToBasket()
                .getAmountOfPhones();
        Assert.assertEquals(amountOfPhonesOnBasket, 1);
    }
}
