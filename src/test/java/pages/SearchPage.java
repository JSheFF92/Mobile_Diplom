package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class SearchPage {

    private final SelenideElement
            languageButton = $(AppiumBy.id("org.wikipedia.alpha:id/search_lang_button")),
            addTextSearchLine = $(id("org.wikipedia.alpha:id/search_src_text"));


    public SearchPage addValueSearchLine(String value) {
        addTextSearchLine.sendKeys(value);

        return this;
    }

    public SearchPage goLanguagePage() {
        languageButton.click();

        return this;
    }
}
