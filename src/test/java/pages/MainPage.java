package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;


public class MainPage {


    private final SelenideElement
            searchLine = $(accessibilityId("Search Wikipedia")),
            navigationButton = $(id("org.wikipedia.alpha:id/menu_overflow_button")),

            tabEdits = $(By.id("org.wikipedia.alpha:id/nav_tab_edits"));

    public MainPage goNavigation() {
        navigationButton.click();

        return this;
    }

    public MainPage goSearchLine() {
        searchLine.click();

        return this;
    }

    public MainPage goEdits() {
        tabEdits.click();

        return this;
    }
}