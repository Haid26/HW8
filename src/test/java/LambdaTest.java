import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    private static final String REPO = "Haid26/HW7", ISSUE = "New TestIssue #126";

    @Test
    public void lamdaTestGit() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("ищем репозиторий " + REPO, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys(REPO);
            $("#query-builder-test").submit();
        });

        step("кликаем по найденному репозиторию " + REPO, () -> {
            $("[href=\"/" + REPO + "\"]").click();
        });
        step("кликаем на вкладку issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем что в списке issues есть " + ISSUE, () -> {
            $(withText(ISSUE)).should(Condition.exist);
        });


    }
}
