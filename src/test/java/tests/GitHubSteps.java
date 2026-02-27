package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSteps {

    @Step("Открываем главную страницу")
    public void openGit() {
        open("https://github.com");
    }

    @Step("ищем репозиторий {repo}")
    public void searchForRepo(String repo) {
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step("кликаем по найденному репозиторию {repo}")
    public void clickOnFoundRepo(String repo) {
        $("[href=\"/" + repo + "\"]").click();
    }

    @Step("кликаем на вкладку issues")
    public void issueClick() {
        $("#issues-tab").click();
    }

    @Step("Проверяем что в списке issues есть {issueName}")
    public void issueCheck(String issueName) {
        $(withText(issueName)).should(Condition.exist);
    }

}
