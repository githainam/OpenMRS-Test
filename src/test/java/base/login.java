package base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class login {
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
    public void testLogin() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.selectLocation("Laboratory");
        loginPage.clickButton();
    }
    @Test
    public void testLoginWithIncorrectUsername() {
        loginPage.setUserName("InvalidUser");
        loginPage.setPassword("Admin123");
        loginPage.selectLocation("Laboratory");
        loginPage.clickButton();
    }

    @Test
    public void testLoginWithIncorrectPassword() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("InvalidPassword");
        loginPage.selectLocation("Laboratory");
        loginPage.clickButton();
    }

    @Test
    public void testLoginWithEmptyUsername() {
        loginPage.setUserName("");
        loginPage.setPassword("Admin123");
        loginPage.selectLocation("Laboratory");
        loginPage.clickButton();
    }

    @Test
    public void testLoginWithEmptyPassword() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("");
        loginPage.selectLocation("Laboratory");
        loginPage.clickButton();
    }
    @Test
    public void testLoginWithEmptyLocation() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.selectLocation("");
        loginPage.clickButton();
    }
//
//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }
}