package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;


public class StartFourPage {


    private final SelenideElement
            accept = $(By.id("org.wikipedia.alpha:id/acceptButton")),
            fourPage = $(By.id("org.wikipedia.alpha:id/primaryTextView"));

    public StartFourPage acceptButton() {
        accept.click();

        return this;
    }

    public StartFourPage textFourPage(String value) {
        assertThat(fourPage.getText())
                .isEqualTo(value);
        return this;
    }


}