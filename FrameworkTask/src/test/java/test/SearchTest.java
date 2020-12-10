package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchPage;

public class SearchTest extends CommonCondition {

    @Test
    public void SearchWithEmptyFieldTest(){
        System.out.println("Test5");
        String searchMessage = new SearchPage(driver)
                .openPage()
                .searchWithEmptyField()
                .getSearchMessage();
        Assert.assertEquals(searchMessage, "К СОЖАЛЕНИЮ, НА ВАШ ПОИСКОВЫЙ ЗАПРОС НИЧЕГО НЕ НАЙДЕНО.");

    }

    @Test
    public void SearchWithQueryTest() {
        System.out.println("Test6");

        String searchQuery = "Xiaomi";
        String nameOfTheFirstSearchedPhone = new SearchPage(driver)
                .openPage()
                .searchWithFilledField(searchQuery)
                .getNameOfTheFirstPhone();
        Assert.assertTrue(nameOfTheFirstSearchedPhone.contains(searchQuery));
    }
}
