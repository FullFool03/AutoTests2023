import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$x;
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

    private static By element = byXpath("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div");

    @Test
    public void testEquals() {
        String str = ("Ginger");
        String sr1 = ("Ginger");
        assertThat(sr1, equalTo(str));
    }

    @Test
    public void rightLogIn() {
        String localPassword = ("autotests2023");
        String rightPassword = (RIGHT_PASSWORD);
        assertThat(localPassword, equalTo(rightPassword));
        MainPage page = new MainPage(BASE_URL, element);
        page.login(RIGHT_LOGIN, RIGHT_PASSWORD);
        page.getMainPage().shouldBe(Condition.visible);
    }

    @Test
    public void wrongLogInMatchers() {
        MainPage page = new MainPage(BASE_URL);
        page.login(WRONG_LOGIN, WRONG_PASSWORD);
        String str = "Неправильно указан логин и/или пароль";
        assertThat(page.getWrongLoginFiled().innerText(), equalTo(str));
        page.getWrongLoginFiled().shouldHave(Condition.text("Неправильно указан логин и/или пароль"));
    }

    @Test
    public void wrongLogIn() {
        MainPage page = new MainPage(BASE_URL);
        page.qrEnter().click();
        page.getQrText().shouldBe(Condition.visible);
        String str = "Получите код для быстрого входа в ОК:";
        assertThat(page.getQrText().innerText(), equalTo(str));
    }
}
