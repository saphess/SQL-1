package page;

import helpers.DataHelper;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final SelenideElement loginField = $("[data-test-id='login'] input");
    private static final SelenideElement passwordField = $("[data-test-id='password'] input");
    private static final SelenideElement buttonNext = $("[data-test-id='action-login']");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public VerificationPage validAuth(DataHelper.User user) {
        loginField.setValue(user.getLogin());
        passwordField.setValue(user.getPassword());
        buttonNext.click();

        return new VerificationPage();
    }
}
