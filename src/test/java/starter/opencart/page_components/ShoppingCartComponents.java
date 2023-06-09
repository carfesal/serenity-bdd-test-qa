package starter.opencart.page_components;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.By;

public class ShoppingCartComponents {
    public static Question<String> titleContent() {
        return Text.of(By.xpath("//div[@id = 'content']/h1"));
    }
}
