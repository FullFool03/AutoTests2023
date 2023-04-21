package Pages;

import Utils.User;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private User user;
    private final SelenideElement EMAIL_FIELD = $x("//*[@id='field_email']");
    private final SelenideElement PASSWORD_FIELD = $x("//input[@name='st.password']");
    private final SelenideElement SUBMIT_BUTTON = $x("//input[@type='submit']");
    private final SelenideElement LOGIN_ERROR_FIELD = $x("//*/form/div[3]/div");
    private final SelenideElement TOP_PANEL = $x("//*[@id=\"topPanel\"]");
    private final SelenideElement QR_BUTTON = $x("/html/body/div[10]/div[5]/div[3]/div[1]/div/div/div/div[1]/div[3]/div/div/main/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div/a[2]");
    private final SelenideElement QR_TEXT = $x("//*[@id=\"hook_Block_AnonymLoginQRCode\"]/div/div[1]/div[1]/div[1]");
    private static final String URL = "https://ok.ru";

    public MainPage login(String email, String password) {
        $(EMAIL_FIELD).shouldBe(Condition.visible).setValue(email).shouldBe(Condition.value(email));
        $(PASSWORD_FIELD).shouldBe(Condition.visible).setValue(password).shouldBe(Condition.value(password));
        $(SUBMIT_BUTTON).shouldBe(Condition.visible).click();
        return new MainPage();
    }

//    public MainPage login1(User user) {
//        $(EMAIL_FIELD).shouldBe(Condition.visible).setValue(user.getEmail()).shouldBe(Condition.value(user.getEmail()));
//        $(PASSWORD_FIELD).shouldBe(Condition.visible).setValue(user.getPassword()).shouldBe(Condition.value(user.getPassword()));
//        $(SUBMIT_BUTTON).shouldBe(Condition.visible).click();
//        return new MainPage();
//    }

    public SelenideElement qrEnter() {
        return QR_BUTTON;
    }

    public SelenideElement getWrongLoginFiled() {
        return LOGIN_ERROR_FIELD;
    }

    public SelenideElement getQR_TEXT() {
        return QR_TEXT;
    }

    @Override
    protected void load() {
        Selenide.open(URL);
    }

    @Override
    protected void isLoaded() throws Error {
        load();

//        EMAIL_FIELD.shouldBe(Condition.visible);
    }
}
