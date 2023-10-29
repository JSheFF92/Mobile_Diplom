package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class ArticlePage {

    private final ElementsCollection
            textOnArticle = $$(AppiumBy.className("android.view.View"));

    private final SelenideElement
            visibleText = $(AppiumBy.className("android.view.View")),
            localVisibleText = $(AppiumBy.className("android.webkit.WebView"));

    public ArticlePage findTextInPage(String value) {
        textOnArticle.findBy(text(value));

        return this;
    }

    public ArticlePage visibleTextInPage() {
        visibleText.shouldBe(visible);

        return this;
    }

    public ArticlePage localVisibleTextInPage(String value) {
        localVisibleText.shouldBe(visible);

        return this;
    }

}