package starter.opencart;

import io.cucumber.java.Before;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import net.serenitybdd.screenplay.annotations.CastMember;
import org.openqa.selenium.WebDriver;
import starter.opencart.task.Checkout;
import starter.opencart.task.PutItemsInCart;
import starter.opencart.task.VerifyCart;
import starter.opencart.task.WaitForCartUpdate;
import starter.opencart.page_components.OpenCartComponents;
import starter.opencart.pages.OpenCartPage;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenTestingOpenCart {

    @Managed
    WebDriver driver;
    @CastMember(name = "Wendy")
    Actor wendy;

    Map<String, String> billInfo;
    @Before
    public void setupActor() {
        wendy.can(BrowseTheWeb.with(driver));
        billInfo = new HashMap<>();
        billInfo.put("firstName", "Carlos");
        billInfo.put("lastName", "Carlos");
        billInfo.put("email", "Carlos");
        billInfo.put("telephone", "Carlos");
        billInfo.put("address", "Carlos");
        billInfo.put("city", "Carlos");
        billInfo.put("postCode", "Carlos");
        billInfo.put("country", "Carlos");
        billInfo.put("state", "Carlos");
    }

    @Test
    @DisplayName("Put items into the cart")
    void testVerifyOpenCartPageProcess() {
        wendy.attemptsTo(
                Open.browserOn().the(OpenCartPage.class),

                //Home Page
                PutItemsInCart.putItemsInCart(2),
                WaitForCartUpdate.waitForItems(2),
                Ensure.that(OpenCartComponents.cartText()).containsIgnoringCase("2 item"),

                // Verify Cart
                VerifyCart.verifyCart(),

                //Checkout Section
                Checkout.openCheckoutPage()
        );
    }
}
