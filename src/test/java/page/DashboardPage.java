package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class DashboardPage {
    private final SelenideElement dashboardLabel = $("[data-test-id='dashboard']");

    public DashboardPage() {
        webdriver().shouldHave(url("http://localhost:9999/dashboard"));
        dashboardLabel.shouldHave(Condition.text("Личный кабинет"), Condition.visible);
    }
}
