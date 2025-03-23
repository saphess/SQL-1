import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final SelenideElement loginField = $("[data-test-id='login'] input");
    private static final SelenideElement passwordField = $("[data-test-id='password'] input");
    private static final SelenideElement buttonNext = $("[data-test-id='action-login']");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public LoginPage() {
        loginField.setValue(SQLHelper.getFirstUser().getLogin());
        passwordField.setValue(SQLHelper.getFirstUser().getPassword());
        buttonNext.click();
    }
}
