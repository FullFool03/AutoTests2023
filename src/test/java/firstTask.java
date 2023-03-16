import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class firstTask extends BaseTest {

    private final static String BASE_URL = "https://ok.ru";
    private final static String WRONG_LOGIN = "123";
    private final static String RIGHT_LOGIN = "email";
    private final static String WRONG_PASSWORD = "123";
    private final static String RIGHT_PASSWORD = "password";
    private final static String NO_EMAIL = "https://ok.ru/dk?st.cmd=anonymMain&st.error=errors.email.empty";


    @Test
    public void rightLogIn() throws InterruptedException {
        MainPage page = new MainPage(BASE_URL);
        page.login(RIGHT_LOGIN, RIGHT_PASSWORD);
        page.getMainPage().shouldBe(Condition.visible);
        Thread.sleep(1000);
    }

    @Test
    public void wrongLogIn() throws InterruptedException {
        MainPage page = new MainPage(BASE_URL);
        page.login(WRONG_LOGIN, WRONG_PASSWORD);
        page.getWrongLoginFiled().shouldHave(Condition.text("Неправильно указан логин и/или пароль"));
        Thread.sleep(1000);
    }

    @Test
    public void noUsername() throws InterruptedException {
        MainPage page = new MainPage(BASE_URL);
        page.login("", WRONG_PASSWORD);
        webdriver().shouldHave(url(NO_EMAIL));
        page.getWrongLoginFiled().shouldHave(Condition.text("Введите логин"));
        Thread.sleep(1000);
    }

    @Test
    public void qrLogIn() throws InterruptedException {
        MainPage page = new MainPage(BASE_URL);
        page.qrEnter().click();
        page.getQrText().shouldBe(Condition.visible);
        Thread.sleep(1000);
    }
}
