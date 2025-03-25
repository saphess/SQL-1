package page;

import helpers.DataHelper;
import helpers.SQLHelper;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class VerificationPage {
    private static final SelenideElement codeField =  $("[data-test-id='code'] input");
    private static final SelenideElement buttonNext = $("[data-test-id='action-verify']");

    public VerificationPage() {
        webdriver().shouldHave(url("http://localhost:9999/verification"));
        $(Selectors.withText("Необходимо подтверждение")).should(Condition.visible);
        codeField.should(Condition.visible);
        buttonNext.should(Condition.text("Продолжить"), Condition.visible);
    }

    public DashboardPage validVerify(DataHelper.User user){
        codeField.setValue(SQLHelper.getCode(user).getCode());
        buttonNext.click();

        return new DashboardPage();
    }
}
