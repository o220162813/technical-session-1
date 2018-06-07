package StepDefinitions;


import PageObjects.BasePage;
import PageObjects.GoogleHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;



/**
 * Created by Stephen C-F Lin on 2018/6/6.
 */
public class StepDefinition {
    public static WebDriver driver = StepDefinition.getDriver();
    static Logger log = LogManager.getLogger();

    GoogleHomePage googleHomePage;

    @Given("^Tester goes to the \"([^\"]*)\" website")
    public void givenTesterAccess(String webPageName) {
        System.out.println("show url: " + webPageName);
        String url;
        switch(webPageName.toUpperCase()) {
            case "GOOGLE HOME":
                url = "https://www.google.com";
                break;
            default:
                throw new Error("Page name is required");
        }
        System.out.println("hi");
        driver.get(url);
        if(!GoogleHomePage.isPageLoaded()) {
            throw new Error();
        }
        googleHomePage = BasePage.initPage(driver, GoogleHomePage.class);
    }

    @When("^Tester searches the \"([^\"]*)\" keyword")
    public void whenTesterDoAction(String keyword) {
        String TEXT_SEARCH_FIELD = "//input[@name='q']";
        String CBTN_SEARCH_SUBMIT = "//input[@name='btnK']";

        WebElement text_searchField = driver.findElement(By.xpath(TEXT_SEARCH_FIELD));
        WebElement cbtn_searchSubmit = driver.findElement(By.xpath(CBTN_SEARCH_SUBMIT));

        text_searchField.clear();
        text_searchField.sendKeys(keyword);
        text_searchField.click();

        cbtn_searchSubmit.click();
    }

    @Then("^Tester sees the \"([^\"]*)\" hyperlink is returned")
    public void thenTesterVerifiesResult(String result) {
        //a[text()='Selenium WebDriver']
        String resultxpath = "//*[text()='"+ result + "']";
        WebElement resultelement = driver.findElement(By.xpath(resultxpath));
        Assert.assertTrue(resultelement.isDisplayed());
    }

    @Given("^Tester fails a test case")
    public void givenTesterFailsTest() {
        Assert.fail();
    }

    public static WebDriver getDriver() {
        DesiredCapabilities dc;

        if(driver==null) {
            dc = DesiredCapabilities.chrome();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("chrome.switches", "--disable-extensions");
            dc.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

//            System.setProperty("webdriver.chrome.driver",
//                    System.getProperty("user.dir") + "/src/test/resources/BrowserDrivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "/src/test/resources/BrowserDrivers/chromedriver_win32_2.39.exe");
            driver = new ChromeDriver(dc);
            driver.manage().window().maximize();
        }

        return driver;
    }
}
