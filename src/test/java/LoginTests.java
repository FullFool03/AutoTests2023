import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LoginTests extends BaseTest {

    private final static String BASE_URL = "https://ok.ru";
    private final static String WRONG_LOGIN = "123";
    private final static String RIGHT_LOGIN = "botS23AT18";
    private final static String WRONG_PASSWORD = "123";
    private final static String RIGHT_PASSWORD = "autotests2023";
    private final static String NO_EMAIL = "https://ok.ru/dk?st.cmd=anonymMain&st.error=errors.email.empty";
    private static By element = byXpath("//input[@name='st.email']");
    private final static User user = new User(RIGHT_LOGIN, RIGHT_PASSWORD);
    private final static User wrongUser = new User(WRONG_LOGIN, WRONG_PASSWORD);

    //Chain of invocations
    @Test
    public void rightLogIn() {
        MainPage page = new MainPage(BASE_URL, element);
        page
                .setEmailField(user)
                .setPasswordField(user)
                .pressEnter();
        page.getMainPage().shouldBe(Condition.visible);
    }

    @Test
    public void wrongLogIn() {
        MainPage page = new MainPage(BASE_URL);
        page
                .setEmailField(wrongUser)
                .setPasswordField(wrongUser)
                .pressEnter();
        page.getWrongLoginFiled().shouldHave(Condition.text("Неправильно указан логин и/или пароль"));
    }

    @Test
    public void noUsername() {
        MainPage page = new MainPage(BASE_URL);
        page
                .setPasswordField(wrongUser)
                .pressEnter();
        webdriver().shouldHave(url(NO_EMAIL));
        page.getWrongLoginFiled().shouldHave(Condition.text("Введите логин"));
    }

    @Test
    public void qrLogIn() {
        MainPage page = new MainPage(BASE_URL);
        page.qrEnter().click();
        page.getQrText().shouldBe(Condition.visible);
    }
}
