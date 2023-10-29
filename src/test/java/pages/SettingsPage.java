package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;


public class SettingsPage {


    private final SelenideElement
            settings = $(id("org.wikipedia.alpha:id/explore_overflow_settings"));

    private final ElementsCollection
            languagePanel = $$(AppiumBy.className("android.widget.TextView"));
    public SettingsPage settingsMenu() {
        settings.click();

        return this;
    }

    public SettingsPage languagePanel() {
        languagePanel.findBy(text("Wikipedia language")).click();

        return this;
    }

}