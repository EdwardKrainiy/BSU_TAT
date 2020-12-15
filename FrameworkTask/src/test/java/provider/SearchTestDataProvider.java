package provider;

import org.testng.annotations.DataProvider;

public class SearchTestDataProvider {

    @DataProvider(name = "searchTestProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                { "Xiaomi" },
                { "Xi" },
                {"omi"}};
    }
}
