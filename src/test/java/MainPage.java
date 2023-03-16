import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement emailField = $x("//input[@name='st.email']");
    private final SelenideElement passwordlField = $x("//input[@name='st.password']");
    private final SelenideElement submitButton = $x("//input[@type='submit']");
    ////*[@id="tabpanel-login-5403224266"]/form/div[4]/input
    private final SelenideElement loginErrorFild = $x("//*/form/div[3]/div");
    private final SelenideElement topPanel = $x("//*[@id=\"topPanel\"]");
    private final SelenideElement qrButton = $x("/html/body/div[10]/div[5]/div[3]/div[1]/div/div/div/div[1]/div[3]/div/div/main/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div/a[2]");
    private final SelenideElement qrText = $x("//*[@id=\"hook_Block_AnonymLoginQRCode\"]/div/div[1]/div[1]/div[1]");

//    Кнопки регистрации
//    private final SelenideElement 222 = $x("//*/form/div[4]/div[2]/a");
//    private final SelenideElement 111 = $x("//*[@id=\"hook_Block_AnonymRegistrationEnterPhone\"]/div/div[1]/div[1]");

    public MainPage(String url) {
        Selenide.open(url);
    }

    public void login(String email, String password) {
        emailField.setValue(email).shouldBe(Condition.value(email));
        passwordlField.setValue(password).shouldBe(Condition.value(password));
        submitButton.click();
    }

    public SelenideElement qrEnter() {
        return qrButton;
    }

    public SelenideElement getWrongLoginFiled() {
        return loginErrorFild;
    }

    public SelenideElement getMainPage() {
        return topPanel;
    }

    public SelenideElement getQrText() {
        return qrText;
    }
}
