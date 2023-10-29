package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;


public class SearchResultsPage {

    private final ElementsCollection
            searchResultListItems = $$(id("org.wikipedia.alpha:id/page_list_item_title")),
            searchResultListDescriptions = $$(id("org.wikipedia.alpha:id/page_list_item_description"));


    public SearchResultsPage checkResultList() {
            searchResultListItems.shouldHave(sizeGreaterThan(0));

        return this;
    }

    public SearchResultsPage clickFirstElementResultList() {
        searchResultListDescriptions.first().click();

        return this;
    }

}
