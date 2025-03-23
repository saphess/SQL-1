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
        SQLHelper.updateUsers(new DataHelper().generateUser());
        open("http://localhost:9999");
    }

    @Test
    public void validAuthorization() {
        LoginPage page = new LoginPage();
        webdriver().shouldHave(url("http://localhost:9999/verification"));
    }
}
