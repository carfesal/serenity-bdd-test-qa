package starter.opencart.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import starter.opencart.page_components.ShoppingCartComponents;

public class VerifyCart {

    @Step("Enter to Checkout")
    public static Performable verifyCart() {
        return Task.where(
                "Verify Cart",
                Click.on(By.xpath("//a[@title = 'Shopping Cart']")),
                Ensure.that(ShoppingCartComponents.titleContent()).containsIgnoringCase("Use Gift Certificate")
        );
    }
}
