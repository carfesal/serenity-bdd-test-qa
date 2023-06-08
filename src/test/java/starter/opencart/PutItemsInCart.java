package starter.opencart;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollToBy;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.PageElement;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;



public class PutItemsInCart {

    public static Performable putItemInCart(String text){
//        return Task.where("Put item in Cart", Click.on(By.xpath("//div[@class='button-group'][1]/button[@type='button'][1]")));
//        return Click.on(Button.containingText(text));
//        Target ADD_TO_CART_BUTTON = PageElement.located(By.xpath("//*[@id='content']/div[2]/div[1]/div/div[3]/button[1]"));
//        Scroll.to(By.xpath("//div[contains(@class, 'product-layout')]")).andAlignToBottom();
//        WaitUntil.the(ADD_TO_CART_BUTTON, WebElementStateMatchers.isVisible());
        return JavaScriptClick.on(By.xpath("//*[@id='content']/div[2]/div[1]/div/div[3]/button[1]"));
    }
}
//*[@id="content"]/div[2]/div[1]/div/div[3]/button[1]