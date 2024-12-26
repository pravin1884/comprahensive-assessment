import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClass {
    static WebDriver driver;
    @BeforeMethod
    public static void LaunchBrowser() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // replace with the actual path
        WebDriverManager.chromedriver().setup();
        // Create a ChromeOptions object to manage browser settings
        ChromeOptions options = new ChromeOptions();

        // Initialize WebDriver (ChromeDriver) with options
        driver = new ChromeDriver(options);


        // Launch the MakeMyTrip website
        driver.get("https://www.makemytrip.com/");

        // Maximize the window
        driver.manage().window().maximize();

        // Wait for elements to be loaded (optional, to avoid timing issues)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));


    }
    @AfterMethod
    public static void quitDriver(){
        driver.quit();
    }
}
