package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ErrorResultPage {

    private final SelenideElement
            errorResult = $(id("org.wikipedia.alpha:id/view_wiki_error_text"));

    public ErrorResultPage checkErrorResult() {
        errorResult.shouldBe(visible);

        return this;
    }
}