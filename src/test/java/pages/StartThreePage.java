package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;


public class StartThreePage {


    private final SelenideElement
            nextPage = $(By.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            threePage = $(By.id("org.wikipedia.alpha:id/primaryTextView"));

    public StartThreePage nextPage() {
        nextPage.click();

        return this;
    }

    public StartThreePage textThreePage(String value) {
        assertThat(threePage.getText())
                .isEqualTo(value);
        return this;
    }


}