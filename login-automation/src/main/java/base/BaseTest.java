package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up ChromeOptions to auto-allow notifications
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 1); // 1=Allow
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://dev-dash.janitri.in/");
        // Optionally—add waits if the page loads with dynamic elements
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}




