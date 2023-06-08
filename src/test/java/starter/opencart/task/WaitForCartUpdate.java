package starter.opencart.task;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitForCartUpdate {
    @Step("Wait for {0} to be in")
    public static Performable waitForItems(int numberOfItemsExpected){
        return WaitUntil.the(ExpectedConditions.textToBePresentInElementLocated(By.id("cart-total"), numberOfItemsExpected + " item"));
    }
}
