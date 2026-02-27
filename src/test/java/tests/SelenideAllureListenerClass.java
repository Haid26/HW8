package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideAllureListenerClass extends TestBase {


    @Test
    public void issueSearchTest(){
        SelenideLogger.addListener("allure",new AllureSelenide());

        open("https://github.com");
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys("haid26/HW7");
        $("#query-builder-test").submit();

        $("[href=\"/Haid26/HW7\"]").click();
        $("#issues-tab").click();
        $(withText("New TestIssue #126")).should(Condition.exist);

    }
}
