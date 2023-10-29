package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class EditsPage {

    private final SelenideElement
            loginPage = $(By.id("org.wikipedia.alpha:id/positiveButton"));


    public EditsPage goLoginPage() {
        loginPage.click();

        return this;
    }
}
