package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage {

    private final SelenideElement
            loginButton = $(By.id("org.wikipedia.alpha:id/create_account_login_button"));


    public LoginPage checkTextLoginButton(String value) {
        assertThat(loginButton.getText())
                .isEqualTo(value);
        return this;
    }
}
