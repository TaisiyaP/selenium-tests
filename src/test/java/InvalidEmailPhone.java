
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvalidEmailPhone {
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
  public void testInvalidEmailPhone() throws Exception {
    driver.findElement(By.linkText("clear")).click();
    driver.findElement(By.linkText("Submit")).click();
    driver.findElement(By.id("form-validation-field-0")).clear();
    driver.findElement(By.id("form-validation-field-0")).sendKeys("tttt");
    driver.findElement(By.id("form-validation-field-1")).clear();
    driver.findElement(By.id("form-validation-field-1")).sendKeys("tttt");
    driver.findElement(By.id("form-validation-field-2")).clear();
    driver.findElement(By.id("form-validation-field-2")).sendKeys("tttt");
    driver.findElement(By.name("country")).clear();
    driver.findElement(By.name("country")).sendKeys("tttt");
    driver.findElement(By.name("company")).clear();
    driver.findElement(By.name("company")).sendKeys("tttt");
    driver.findElement(By.name("message")).clear();
    driver.findElement(By.name("message")).sendKeys("tt");
    driver.findElement(By.linkText("Submit")).click();
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
