import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestAuth {
    private final DataHelper.AuthInfo userInfo = DataHelper.getAuthInfo();

    @Test
    public void validAuthorization() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        loginPage.validAuth(userInfo);
        $("[data-test-id='code'] input").shouldBe();
    }

}
