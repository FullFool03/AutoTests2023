import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.$;

public abstract class BaseTest extends LoadableComponent {
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "3440x1440";
        Configuration.headless = false;
    }
    @BeforeAll
    public static void Config() {
        Configuration.browser = "chrome";
    }

    @BeforeEach
    public void init() {
        setUp();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }
}
