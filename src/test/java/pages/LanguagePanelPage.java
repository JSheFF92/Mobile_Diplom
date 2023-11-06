package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class LanguagePanelPage {

    private final ElementsCollection

            language = $$(AppiumBy.id("org.wikipedia.alpha:id/localized_language_name")),
            checkLanguage = $$(AppiumBy.className("android.widget.TextView")),
            addButton = $$(AppiumBy.id("org.wikipedia.alpha:id/wiki_language_title"));

    private final SelenideElement
            deletedMenu = $(AppiumBy.accessibilityId("More options")),
            deletedButton = $(AppiumBy.id("org.wikipedia.alpha:id/content")),
            clickDeletedButton = $(AppiumBy.id("org.wikipedia.alpha:id/menu_delete_selected")),
            confirmButton = $(AppiumBy.id("android:id/button1"));


    public LanguagePanelPage choiceLanguage(String value) {
        language.findBy(text(value));

        return this;
    }

    public LanguagePanelPage localChoiceLanguage(String value) {
        language.findBy(text(value)).click();

        return this;
    }

    public LanguagePanelPage checkChangeLanguage(String value) {
        checkLanguage.findBy(text(value)).shouldBe(visible);

        return this;
    }

    public LanguagePanelPage addLanguageButton(String value) {
        addButton.findBy(text(value)).click();

        return this;
    }

    public LanguagePanelPage deletedMenu() {
        deletedMenu.click();

        return this;
    }

    public LanguagePanelPage deletedButton() {
        deletedButton.click();

        return this;
    }

    public LanguagePanelPage choiceLanguageDeleted(String value) {
        checkLanguage.findBy(text(value)).click();

        return this;
    }

    public LanguagePanelPage clickDeletedButton() {
        clickDeletedButton.click();

        return this;
    }

    public LanguagePanelPage confirmDeletedButton() {
        confirmButton.click();

        return this;
    }


    public LanguagePanelPage checkNotChangeLanguage(String value) {
        checkLanguage.findBy(text(value)).shouldNotBe(visible);

        return this;
    }
}