package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage extends LoadableComponent<BasePage> {

    protected static SelenideElement waitForElement(SelenideElement element, String message) {
        return $(element).shouldBe(Condition.visible.because(message));
    }

//    @Override
//    public BasePage get() {
//        return super.get();
//    }

    @Override
    protected void load() {}

    protected BasePage() {
        isLoaded();
    }
}
