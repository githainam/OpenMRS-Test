package base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class logout {
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
    public void logout(){
        login();
        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://demo.openmrs.org/openmrs/login.htm", currentUrl, "Logout unsuccessful!");
    }
    @Test
    public void login(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.selectLocation("Laboratory");
        loginPage.clickButton();
    }
}

