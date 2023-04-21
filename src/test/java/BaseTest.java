import Pages.BasePage;
import Pages.LoginPage;
import Utils.User;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.$;

public abstract class BaseTest {

    protected LoginPage loginPage;
    protected final static String RIGHT_LOGIN = "botS23AT18";
    protected final static String RIGHT_PASSWORD = "autotests2023";

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "3440x1440";
        Configuration.headless = false;
    }

    @BeforeEach
    public void init() {
        setUp();
        loginPage = new LoginPage();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
