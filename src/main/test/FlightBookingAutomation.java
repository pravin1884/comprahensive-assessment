import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

public class FlightBookingAutomation {

    public static void main(String[] args) {

        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // replace with the actual path

        // Create a ChromeOptions object to manage browser settings
        ChromeOptions options = new ChromeOptions();

        // Initialize WebDriver (ChromeDriver) with options
        WebDriver driver = new ChromeDriver(options);

        try {
            // Launch the MakeMyTrip website
            driver.get("https://www.makemytrip.com/");

            // Maximize the window
            driver.manage().window().maximize();

            // Wait for elements to be loaded (optional, to avoid timing issues)
            WebDriverWait wait = new WebDriverWait(driver, 10);

            // Click on the "Flights" tab (assumed element by the text)
            WebElement flightsTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Flights']")));
            flightsTab.click();

            // Select "Round Trip" option
            WebElement roundTripRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class, 'round-trip')]")));
            roundTripRadioButton.click();

            // Enter the "From" location as HYD
            WebElement fromLocationField = wait.until(ExpectedConditions.elementToBeClickable(By.id("fromCity")));
            fromLocationField.click();
            WebElement fromLocationInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));
            fromLocationInput.sendKeys("HYD");
            WebElement fromLocationOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), 'Hyderabad')]")));
            fromLocationOption.click();

            // Enter the "To" location as MAA
            WebElement toLocationField = wait.until(ExpectedConditions.elementToBeClickable(By.id("toCity")));
            toLocationField.click();
            WebElement toLocationInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='To']")));
            toLocationInput.sendKeys("MAA");
            WebElement toLocationOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), 'Chennai')]")));
            toLocationOption.click();

            // Select Departure Date
            WebElement departureDateField = wait.until(ExpectedConditions.elementToBeClickable(By.id("departure")));
            departureDateField.click();
            WebElement departureDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Wed Dec 27 2024']"))); // example date, change as needed
            departureDate.click();

            // Select Return Date
            WebElement returnDateField = wait.until(ExpectedConditions.elementToBeClickable(By.id("return")));
            returnDateField.click();
            WebElement returnDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Sat Dec 30 2024']"))); // example date, change as needed
            returnDate.click();

            // Click on the "Search" button
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")));
            searchButton.click();

            // Verify that the search results page is displayed by checking if an element from the results page exists
            WebElement resultsPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Flights from HYD to MAA']")));
            if (resultsPage.isDisplayed()) {
                System.out.println("Search page displayed as expected.");
            } else {
                System.out.println("Search page is not displayed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
