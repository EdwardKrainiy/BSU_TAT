package at.test;

import at.page.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends CommonCondition {
    @Test
    public void SearchWithEmptyFieldTest(){
        String searchMessage = new SearchPage(driver)
                .openPage()
                .searchWithEmptyField()
                .getSearchMessage();
        Assert.assertEquals(searchMessage, "К СОЖАЛЕНИЮ, НА ВАШ ПОИСКОВЫЙ ЗАПРОС НИЧЕГО НЕ НАЙДЕНО.");
    }

    @Test
    public void SearchWithQueryTest() {
        String searchQuery = "Xiaomi";
        String nameOfTheFirstSearchedPhone = new SearchPage(driver)
                .openPage()
                .searchWithFilledField(searchQuery)
                .getNameOfTheFirstPhone();
        Assert.assertTrue(nameOfTheFirstSearchedPhone.contains(searchQuery));
    }
}
