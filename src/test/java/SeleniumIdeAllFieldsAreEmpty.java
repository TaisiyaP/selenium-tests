import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIdeAllFieldsAreEmpty {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.seleniumframework.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/Practiceform/");
        driver.navigate().refresh();
    }

    @Test
    public void testSeleniumIdeAllFieldsAreEmpty() throws Exception {
        driver.findElement(By.linkText("Submit")).click();
        Thread.sleep(1000);
        assertTrue(isErrorPopupTextPresent("This field is required"));
        Thread.sleep(1000);
        assertTrue(isErrorPopupTextPresent("Invalid email address"));
        Thread.sleep(1000);
        assertTrue(isErrorPopupTextPresent("Invalid phone number"));
    }

    private boolean isErrorPopupTextPresent(String text) {
        List<WebElement> errorPopups = driver.findElements(By.cssSelector("div.formErrorContent"));
        for (WebElement errorPopup : errorPopups) {
            if
                    (errorPopup.getText().contains(text)) ;
            {
                return true;
            }
        }
        return false;
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
