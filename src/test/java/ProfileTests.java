import Pages.LoginPage;
import Pages.MainPage;
import Utils.User;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;

public class ProfileTests extends BaseTest{
    private final By FRIENDS_FILD = byXpath("//*[@id=\"hook_Block_Navigation\"]/div/div/div[3]/a/div");
    private final static String BASE_URL = "https://ok.ru";
    private final static String RIGHT_LOGIN = "botS23AT18";
    private final static String RIGHT_PASSWORD = "autotests2023";
    private static By element = byXpath("//input[@name='st.email']");
    private final static User user = new User(RIGHT_LOGIN, RIGHT_PASSWORD);

//    public ProfileTests(){
//        LoginPage page = new LoginPage();
//        page
//                .setEMAIL_FIELD(user)
//                .setPasswordField(user)
//                .pressEnter();
//        page.getMainPage().shouldBe(Condition.visible);
//    }
//
//    @Test
//    public void friends(){
//        MainPage page = new MainPage();
//        page.friendsEnter().click();
//        page.getShcoolFreindsField().shouldBe(Condition.visible);
///        page.photoeEnter();
//    }

}
