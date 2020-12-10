package at.test;

import at.page.ComparingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddTwoPhonesToComparingAndDeleteOnePhoneFromComparingTest extends CommonCondition {
    @Test
    public void ComparingTwoPhonesAndDeletingOnePhoneTest() {
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

