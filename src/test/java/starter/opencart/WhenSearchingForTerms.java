package starter.opencart;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import net.serenitybdd.screenplay.annotations.CastMember;
import org.openqa.selenium.By;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenSearchingForTerms {

    @CastMember(name = "Wendy")
    Actor wendy;

    @Test
    void searchBySingleKeyword() {
        wendy.attemptsTo(
                Open.browserOn().the(OpenCartPage.class),
                PutItemsInCart.putItemInCart("Add to Cart"),
                PutItemsInCart.putItemInCart("Add to Cart"),
//                Search.byKeyword("Everest"),
                Ensure.that(Text.of(By.xpath("//span[@id='cart-total']"))).containsIgnoringCase("2 item")
        );
    }
}
