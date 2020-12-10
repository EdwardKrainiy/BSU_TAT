package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ComparingPage;

public class AddTwoPhonesToComparingAndDeleteOnePhoneFromComparingTest extends CommonCondition {

    @Test
    public void ComparingTwoPhonesAndDeletingOnePhoneTest() {
        System.out.println("Test1");

        ComparingPage comparingPage = new ComparingPage(driver);
        int amountOfPhonesBeforeDeleting = comparingPage
                .openPage()
                .compareTwoPhones()
                .moveToComparingPage()
                .getAmountOfPhonesOnComparingPage();
        int amountOfPhonesAfterDeleting = comparingPage
                .removeOnePhoneFromComparing()
                .getAmountOfPhonesOnComparingPage();
        Assert.assertEquals(amountOfPhonesAfterDeleting, amountOfPhonesBeforeDeleting - 1);
    }
}

