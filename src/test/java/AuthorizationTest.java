import Helpers.SQLHelper;
import Page.LoginPage;
import Page.VerificationPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

@Slf4j
public class AuthorizationTest {

    @BeforeAll
    static void setUp() {
        open("http://localhost:9999");
    }

    @Test
    public void validAuthorization() {
        var validUser = SQLHelper.getUser("vasya");
        LoginPage loginPage = new LoginPage();
        VerificationPage verificationPage = loginPage.validAuth(validUser);
        verificationPage.validVerify(validUser);
        webdriver().shouldHave(url("http://localhost:9999/dashboard"));
    }
}
