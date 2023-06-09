package starter.opencart.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import starter.opencart.page_components.CheckoutComponents;

import java.util.Map;

public class Checkout {

    static Target CHECKOUT_BUTTON = Target.the("Checkout Button")
                                        .located(By.xpath("//a[@title = 'Checkout']"));
    static Target GUEST_RADIO_BUTTON = Target.the("Guest Radio Button")
                                    .located(By.xpath("//input[@value = 'guest']"));
    static Target BUTTON_GUEST = Target.the("Continue Button from Billing Details Step")
            .located(By.xpath("//input[@id = 'button-guest']"));
    static Target H1_TITLE = Target.the("Success Order Title")
            .located(By.xpath("//div[@id = 'content']/h1"));
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
                Click.on(By.xpath("//input[@id = 'button-account']"))
        );
    }

    @Step("Step 1: Billing Details")
    public static Performable fillBillingDetails(Map<String, String> billInfo) {
        return Task.where(
                "Fill billing details",
                Enter.theValue(billInfo.get("firstName")).into(InputField.withNameOrId("input-payment-firstname")),
                Enter.theValue(billInfo.get("lastName")).into(InputField.withNameOrId("input-payment-lastname")),
                Enter.theValue(billInfo.get("email")).into(InputField.withNameOrId("input-payment-email")),
                Enter.theValue(billInfo.get("telephone")).into(InputField.withNameOrId("input-payment-telephone")),
                Enter.theValue(billInfo.get("address")).into(InputField.withNameOrId("input-payment-address-1")),
                Enter.theValue(billInfo.get("city")).into(InputField.withNameOrId("input-payment-city")),
                Enter.theValue(billInfo.get("postCode")).into(InputField.withNameOrId("input-payment-postcode")),
                SelectFromOptions.byVisibleText(billInfo.get("country")).from("#input-payment-country"),
                SelectFromOptions.byVisibleText(billInfo.get("state")).from("#input-payment-zone"),
                Scroll.to(BUTTON_GUEST).andAlignToTop(),
                Click.on(BUTTON_GUEST)
        );
    }

    @Step("Step 3: Payment Method")
    public static Performable fillPaymentMethod(){
        return Task.where(
                "Fill Payment Method",
                Click.on(By.xpath("//input[@name = 'agree']")),
                Click.on(By.xpath("//input[@id = 'button-payment-method']"))
        );
    }

    @Step("Step 4: Confirm Order")
    public static Performable confirmOrder(){
        return Click.on(By.xpath("//input[@id = 'button-confirm']"));
    }

    @Step("Enter to Checkout")
    public static Performable checkSuccesfulOrder(){
        return Task.where(
                "Check Succesful Order",
                WaitUntil.the(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id = 'content']/h1"),"Your order has been placed")),
                Ensure.that(CheckoutComponents.successText()).containsIgnoringCase("Your order has been placed")
        );
    }
}
