package base;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;


public class testFindPatient {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(this.driver);
        this.driver.get("https://demo.openmrs.org/openmrs/login.htm");
    }

    @Test
    public void testSearchPatient() {
        login();
        WebElement findPatientLink = driver.findElement(By.linkText("Find Patient Record"));
        findPatientLink.click();
    //WebElement
        WebElement searchInput = driver.findElement(By.id("patient-search"));
        searchInput.sendKeys("100LXD");
//        searchInput.sendKeys(Keys.ENTER);
        WebElement searchResults = driver.findElement(By.id("patient-search-results"));
        String searchResultsText = searchResults.getText();
        Assertions.assertTrue(searchResultsText.contains("100LXD"), "Search result does not contain the expected patient ID: 100NAJ");
    }
    @Test
    public void testSearchBlank() {
        login();
        WebElement findPatientLink = driver.findElement(By.linkText("Find Patient Record"));
        findPatientLink.click();
        WebElement searchInput = driver.findElement(By.id("patient-search"));
        searchInput.sendKeys("");
        searchInput.sendKeys(Keys.ENTER);
        WebElement searchResults = driver.findElement(By.id("patient-search-results"));
        String searchResultsText = searchResults.getText();
        Assertions.assertTrue(searchResultsText.contains(""), "Search result does not contain the expected patient ID: 100NAJ");
    }
    @Test
    public void testSearchWrong() {
        login();
        WebElement findPatientLink = driver.findElement(By.linkText("Find Patient Record"));
        findPatientLink.click();
        WebElement searchInput = driver.findElement(By.id("patient-search"));
        searchInput.sendKeys("100NAJ");
//        searchInput.sendKeys(Keys.ENTER);
        WebElement searchResults = driver.findElement(By.id("patient-search-results"));
        String searchResultsText = searchResults.getText();
        Assertions.assertTrue(searchResultsText.contains("100NAJ"), "Search result does not contain the expected patient ID: 100NAJ");
    }

    private void login() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.selectLocation("Laboratory");
        loginPage.clickButton();
    }
}
