package provider;

import org.testng.annotations.DataProvider;

public class SearchTestDataProvider {

    @DataProvider(name = "correctQuerySearchTestProvider")
    public Object[][] correctSearchDataProviderMethod() {
        return new Object[][]{
                { "Xiaomi" },
                { "Xi" },
                {"omi"}};
    }

    @DataProvider(name = "incorrectQuerySearchTestProvider")
    public Object[][] incorrectSearchDataProviderMethod() {
        return new Object[][]{
                { "Xiomi" }};
    }
}
