package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;


public class StartTwoPage {


    private final SelenideElement
            nextPage = $(By.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            OnePage = $(By.id("org.wikipedia.alpha:id/primaryTextView"));

    public StartTwoPage nextPage() {
        nextPage.click();

        return this;
    }

    public StartTwoPage textTwoPage(String value) {
        assertThat(OnePage.getText())
                .isEqualTo(value);
        return this;
    }


}