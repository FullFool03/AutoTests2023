import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BaseTest {
    @FindBy(id = "someId")
    private final By emailField = byXpath("//input[@name='st.email']");
    private final By passwordlField = byXpath("//input[@name='st.password']");
    private final SelenideElement submitButton = $x("//input[@type='submit']");
    private final SelenideElement loginErrorFild = $x("//*/form/div[3]/div");
    private final SelenideElement topPanel = $x("//*[@id=\"topPanel\"]");
    private final SelenideElement qrButton = $x("/html/body/div[10]/div[5]/div[3]/div[1]/div/div/div/div[1]/div[3]/div/div/main/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div/a[2]");
    private final SelenideElement qrText = $x("//*[@id=\"hook_Block_AnonymLoginQRCode\"]/div/div[1]/div[1]/div[1]");

    private final SelenideElement freindsField = $x("//*[@id=\"hook_Block_Navigation\"]/div/div/div[3]/a/div/svg");
    private final SelenideElement shcoolFreindsField = $x("//*[@id=\"hook_Block_SchoolFriendsAdd\"]/div/a");
    private final SelenideElement photoeField = $x("//*[@id=\"hook_Block_Navigation\"]/div/div/div[4]/a/div/svg");


    //Loadable Component
    public MainPage(String url, By element) {
        Selenide.open(url);
        waitForElement(element, "Элемент не прогрузился");
    }

    public MainPage(String url) {
        Selenide.open(url);
    }

    public MainPage() {

    }

    public void login(String email, String password) {
        $(emailField).setValue(email).shouldBe(Condition.value(email));
        $(passwordlField).setValue(password).shouldBe(Condition.value(password));
        $(submitButton).click();
    }

    public MainPage setEmailField(User user) {
        waitForElement(emailField, "Не прогрузился логин").setValue(user.getEmail());
        return this;
    }

    public MainPage setPasswordField(User user) {
        waitForElement(passwordlField, "Не прогрузился логин").setValue(user.getPassword());
        return this;
    }

    public void pressEnter() {
        $(submitButton).click();
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

    public SelenideElement friendsEnter() {
        return freindsField;
    }

    public SelenideElement getShcoolFreindsField(){
        return shcoolFreindsField;
    }

    public SelenideElement photoeEnter() {
        return photoeField;
    }
}
