import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Matchers {
    private final static String BASE_URL = "https://ok.ru";
    private final static String WRONG_LOGIN = "123";
    private final static String RIGHT_LOGIN = "botS23AT18";
    private final static String WRONG_PASSWORD = "123";
    private final static String RIGHT_PASSWORD = "autotests2023";

    private final static String NO_EMAIL = "https://ok.ru/dk?st.cmd=anonymMain&st.error=errors.email.empty";
    private final static String NoLoginOrPassword = "https://ok.ru/dk?st.cmd=anonymMain&st.error=errors.email.empty";



    @Test
    public void testEquals() {
        String str = ("Ginger");
        String sr1 = ("Ginger");
        assertThat(sr1, equalTo(str));
    }

    @Test
    public void rightLogIn() throws InterruptedException {
        String localPassword = ("autotests2023");
        String rightPassword = (RIGHT_PASSWORD);
        assertThat(localPassword, equalTo(rightPassword));
        MainPage page = new MainPage(BASE_URL);
        page.login(RIGHT_LOGIN, RIGHT_PASSWORD);
        page.getMainPage().shouldBe(Condition.visible);
        Thread.sleep(1000);
    }

    @Test
    public void wrongLogInMatchers() throws InterruptedException {
        MainPage page = new MainPage(BASE_URL);
        page.login(WRONG_LOGIN, WRONG_PASSWORD);
        String str = "Неправильно указан логин и/или пароль";
        assertThat(page.getWrongLoginFiled().innerText(),equalTo(str));
        page.getWrongLoginFiled().shouldHave(Condition.text("Неправильно указан логин и/или пароль"));
        Thread.sleep(1000);
    }

    @Test
    public void wrongLogIn() throws InterruptedException {
        MainPage page = new MainPage(BASE_URL);
        page.login(WRONG_LOGIN, WRONG_PASSWORD);
        String str = "Неправильно указан логин и/или пароль";
        assertThat(page.getWrongLoginFiled().innerText(),equalTo(str));
        page.getWrongLoginFiled().shouldHave(Condition.text("Неправильно указан логин и/или пароль"));
        Thread.sleep(1000);
    }
}
