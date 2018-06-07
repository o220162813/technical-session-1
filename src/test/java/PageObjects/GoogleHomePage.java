package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Stephen C-F Lin on 2018/6/6.
 */
public class GoogleHomePage extends BasePage {
    public static final String url = "https://www.google.com";
    public static final String PAGE_CHECKER = "//title[text()='Google']";
    public static final String TEXT_SEARCH_FIELD = "//input[@name='q']";
    public static final String CBTN_SEARCH_SUBMIT = "//input[@name='btnK']";

    @FindBy(xpath=PAGE_CHECKER)
    WebElement chkr_pageChecker;
    @FindBy(xpath=TEXT_SEARCH_FIELD)
    WebElement text_searchField;
    @FindBy(xpath=CBTN_SEARCH_SUBMIT)
    WebElement cbtn_searchSubmit;

    public void enterSearchTest() {
    }

    public Boolean isSearchResultShown(String resulttext) {
        return true;
    }

    public static Boolean isPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PAGE_CHECKER)));
        } catch(TimeoutException e) {
            return false;
        }
        return true;
    }

}
