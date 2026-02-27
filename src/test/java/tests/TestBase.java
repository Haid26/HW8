package tests;

import com.codeborne.selenide.Configuration;
import config.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    private static final TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());


    @BeforeAll
    static void setupSelenideConfig() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;

        Configuration.browser = testConfig.getBrowserName();
        Configuration.browserVersion = testConfig.getBrowserVersion();
        Configuration.remote = testConfig.getRemoteUrl();
    }
}
