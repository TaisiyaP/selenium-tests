import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvalidPhoneNumber {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.seleniumframework.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(baseUrl + "/Practiceform/");

  }

  @Test
  public void testInvalidPhoneNumber() throws Exception {
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("456");
    driver.findElement(By.cssSelector("span.form-mail > input[name=\"email\"]")).clear();
    driver.findElement(By.cssSelector("span.form-mail > input[name=\"email\"]")).sendKeys("rrrrr");
    driver.findElement(By.name("telephone")).clear();
    driver.findElement(By.name("telephone")).sendKeys("ggggg");
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
