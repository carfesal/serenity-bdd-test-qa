package starter.opencart.task;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;


public class PutItemsInCart {
    @Step
    public static Performable putItemsInCart(int numberOfItems){
        return Task.where(
                "Putting items into cart", actor -> {
                    for (int i = 0; i < numberOfItems; i++){
                        actor.attemptsTo(
                                Scroll.to(By.xpath(".//button[contains(@onclick,'cart.add')]")).andAlignToTop(),
                                JavaScriptClick.on(By.xpath(".//button[contains(@onclick,'cart.add')]"))
                        );
                    }
                }
        );
    }
}