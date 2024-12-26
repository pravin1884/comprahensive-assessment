import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class FlightSearchStepDefinitions {

    WebDriver driver;

    @Given("I launch the browser and open the MakeMyTrip website")
    public void i_launch_the_browser_and_open_the_make_my_trip_website() {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
    }

    @When("I click on the {string} tab")
    public void i_click_on_the_tab(String tabName) {
        // Click on the Flights tab
        WebElement flightsTab = driver.findElement(By.xpath("//span[text()='" + tabName + "']"));
        flightsTab.click();
    }

    @When("I select {string}")
    public void i_select(String tripType) {
        // Select "Round Trip"
        WebElement roundTripRadio = driver.findElement(By.xpath("//label[@for='roundTrip']"));
        roundTripRadio.click();
    }

    @When("I enter {string} as the From location and {string} as the To location")
    public void i_enter_locations(String fromLocation, String toLocation) {
        // Enter "HYD" as From Location
        WebElement fromInput = driver.findElement(By.id("fromCity"));
        fromInput.click();
        WebElement fromSearchBox = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromSearchBox.sendKeys(fromLocation);
        WebElement fromOption = driver.findElement(By.xpath("//p[text()='Hyderabad']"));
        fromOption.click();

        // Enter "MAA" as To Location
        WebElement toInput = driver.findElement(By.id("toCity"));
        toInput.click();
        WebElement toSearchBox = driver.findElement(By.xpath("//input[@placeholder='To']"));
        toSearchBox.sendKeys(toLocation);
        WebElement toOption = driver.findElement(By.xpath("//p[text()='Chennai']"));
        toOption.click();
    }

    @When("I select the departure date as {string} and return date as {string}")
    public void i_select_dates(String departureDate, String returnDate) {
        // Select Departure Date (2024-12-26)
        WebElement departureDateElement = driver.findElement(By.xpath("//div[@aria-label='Tue " + departureDate + " 2024']"));
        departureDateElement.click();

        // Select Return Date (2025-01-02)
        WebElement returnDateElement = driver.findElement(By.xpath("//div[@aria-label='Tue " + returnDate + " 2025']"));
        returnDateElement.click();
    }

    @When("I click the {string} button")
    public void i_click_the_button(String buttonName) {
        // Click the Search button
        WebElement searchButton = driver.findElement(By.xpath("//a[text()='Search']"));
        searchButton.click();
    }

    @Then("I should see the flight search results page displayed")
    public void i_should_see_the_flight_search_results_page_displayed() {
        // Verify that the flight search results page is displayed
        WebElement resultsPage = driver.findElement(By.xpath("//h1[text()='Choose your flights']"));
        Assert.assertTrue(resultsPage.isDisplayed());

        // Close the browser
        driver.quit();
    }
}
