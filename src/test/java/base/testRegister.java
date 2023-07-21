package base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;

public class testRegister {
    private WebDriver driver;
    private LoginPage loginPage;
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        loginPage = new LoginPage(this.driver);
        this.driver.get("https://demo.openmrs.org/openmrs/login.htm");
    }
    @Test
    public void login(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.selectLocation("Laboratory");
        loginPage.clickButton();
    }
    @Test
    public void RegisterPatient(){
     login();
     WebElement registerPatientLink = driver.findElement(By.linkText("Register a patient"));
     registerPatientLink.click();
    WebElement givenName = driver.findElement(By.cssSelector("p.left input[name='givenName']"));
    givenName.sendKeys("Nguyen");
    WebElement familyName = driver.findElement(By.cssSelector("p.left input[name='familyName']"));
    familyName.sendKeys("Truong Nghia");
    WebElement nextButton = driver.findElement(By.id("next-button"));
    nextButton.click();
    WebElement gender = driver.findElement(By.id("gender-field"));
    Select selectGender = new Select(gender);
    selectGender.selectByValue("M");
//    selectGender.selectByVisibleText("Female");
    nextButton.click();
    WebElement day = driver.findElement(By.id("birthdateDay-field"));
    day.sendKeys("29");
    WebElement month = driver.findElement(By.id("birthdateMonth-field"));
    Select selectMonth = new Select(month);
    selectMonth.selectByValue("7");
    WebElement year = driver.findElement(By.id("birthdateYear-field"));
    year.sendKeys("2003");
    nextButton.click();
    WebElement address = driver.findElement(By.id("address1"));
    address.sendKeys("FPT University");
    nextButton.click();
    WebElement phoneNumber = driver.findElement(By.name("phoneNumber"));
    phoneNumber.sendKeys("0975261263s");
    nextButton.click();
    nextButton.click();
    WebElement confirmButton = driver.findElement(By.id("submit"));
    confirmButton.click();
//  select.selectByVisibleText("Female"); chọn theo văn bản








        String expectedPattern = "https://demo.openmrs.org/openmrs/coreapps/clinicianfacing/patient.page\\?patientId=\\w+";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertTrue(actualUrl.matches(expectedPattern),
                "URL mismatch: Expected pattern - " + expectedPattern + ", Actual - " + actualUrl);
    }
}
