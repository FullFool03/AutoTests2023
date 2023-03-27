import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

//loadable component
public abstract class LoadableComponent {
    public static Duration TIMEOUT = Duration.ofSeconds(10);

    public static SelenideElement waitForElement(By element, String message) {
        return $(element).shouldBe(Condition.visible.because(message), TIMEOUT);
    }
}
