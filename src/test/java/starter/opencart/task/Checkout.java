package starter.opencart.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.Map;

public class Checkout {

    static Target CHECKOUT_BUTTON = Target.the("Checkout Button")
                                        .located(By.xpath("//a[@title = 'Checkout']"));
    static Target GUEST_RADIO_BUTTON = Target.the("Guest Radio Button")
                                    .located(By.xpath("//input[@value = 'guest']"));
    @Step
    public static Performable openCheckoutPage(){
        return Task.where(
                "Move to checkout page",
                Scroll.to(CHECKOUT_BUTTON).andAlignToTop(),
                Click.on(CHECKOUT_BUTTON)
        );
    }

    @Step("Step 1: Checkout Options")
    public static Performable fillCheckoutOptions() {
        return Task.where(
                "Select Guest Checkout",
                Click.on(GUEST_RADIO_BUTTON),
                Click.on(Button.withNameOrId("button-account"))
        );
    }

    public static Performable fillBillingDetails(Map<String, String> billInfo) {
        return null;
    }
}
