import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class StepsTest {

    private static final String REPO = "Haid26/HW7", ISSUE = "New TestIssue #126";

    @Test
    public void annotatedStepTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        GitHubSteps steps = new GitHubSteps();
        steps.openGit();
        steps.searchForRepo(REPO);
        steps.clickOnFoundRepo(REPO);
        steps.issueClick();
        steps.issueCheck(ISSUE);
    }
}
