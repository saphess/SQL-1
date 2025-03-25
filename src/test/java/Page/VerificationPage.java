package Page;

import Helpers.DataHelper;
import Helpers.SQLHelper;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class VerificationPage {
    private static final SelenideElement codeField =  $("[data-test-id='code'] input");
    private static final SelenideElement buttonNext = $("[data-test-id='action-verify']");

    public VerificationPage() {
        webdriver().shouldHave(url("http://localhost:9999/verification"));
    }

    public void validVerify(DataHelper.User user){
        codeField.setValue(SQLHelper.getCode(user).getCode());
        buttonNext.click();
    }
}
