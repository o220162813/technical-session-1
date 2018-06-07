package PageObjects;

import StepDefinitions.StepDefinition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Stephen C-F Lin on 2018/6/6.
 */
public class BasePage {
    protected static WebDriver driver = StepDefinition.getDriver();

    public static <T> T initPage(WebDriver webDriver, Class<T> pageClassToProxy) {
        return PageFactory.initElements(webDriver, pageClassToProxy);
    }
}
