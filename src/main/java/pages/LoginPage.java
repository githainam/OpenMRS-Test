package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By userNameTxt = By.id("username");
    //tìm trên trang web thẻ nào có id là username
    private By passwordTxt = By.id("password");
    private By loginButton = By.id("loginButton");
    private By locationDropdown = By.id("sessionLocation");
    private By locationOptions = By.cssSelector("#sessionLocation li");

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public void setUserName(String userName) {

        driver.findElement(userNameTxt).sendKeys(userName);
        //findElement : tìm trên trang web có element nào y như biến usernametxt
        //sendKeys : truyền vào username 1 cái String
    }

    public void setPassword(String password) {

        driver.findElement(passwordTxt).sendKeys(password);
    }

    public LoginPage selectLocation(String location) {
        WebElement locationElement = driver.findElement(locationDropdown);
        locationElement.click();

        By locationOption = By.xpath("//ul[@id='sessionLocation']//li[contains(text(), '" + location + "')]");
        WebElement optionElement = driver.findElement(locationOption);
        optionElement.click();

        return this;
    }
    public void clickButton() {
        driver.findElement(loginButton).click();
    }

}
