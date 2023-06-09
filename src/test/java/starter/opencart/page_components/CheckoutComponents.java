package starter.opencart.page_components;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.By;

public class CheckoutComponents {
    public static Question<String> successText() {
        return Text.of(By.xpath("//div[@id = 'content']/h1"));
    }
}
