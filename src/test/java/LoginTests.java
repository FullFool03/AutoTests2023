import Pages.BasePage;
import Pages.LoginPage;
import Utils.User;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginTests extends BaseTest {
    private final static String WRONG_LOGIN = "123";
    private final static String WRONG_PASSWORD = "123";

    private static By element = byXpath("//input[@name='st.email']");
    private final static String NO_EMAIL_URL = "https://ok.ru/dk?st.cmd=anonymMain&st.error=errors.email.empty";

//    private final static User WRONG_USER = new User(WRONG_LOGIN, WRONG_PASSWORD);
    private final static String LOGIN_ERR = "Неправильно указан логин и/или пароль";

    private final static String QR_TEXT ="Получите код для быстрого входа в ОК:";

    public static final String LOGIN_MISSING = "Введите логин";

    @Test
    public void rightLogIn() {
        assertNotNull(loginPage.login(RIGHT_LOGIN,RIGHT_PASSWORD));
    }

    @Test
    public void wrongLogIn() {
        loginPage.login(WRONG_LOGIN,RIGHT_PASSWORD);
        assertThat(loginPage.getWrongLoginFiled().text(), containsString(LOGIN_ERR));
    }

    @Test
    public void noUsername() {
        loginPage.login("",RIGHT_PASSWORD);
        webdriver().shouldHave(url(NO_EMAIL_URL));
        assertThat(loginPage.getWrongLoginFiled().text(), containsString(LOGIN_MISSING));
    }

    @Test
    public void qrLogIn() {
        loginPage.qrEnter().click();
        assertThat(loginPage.getQR_TEXT().text(), containsString(QR_TEXT));
    }

}
