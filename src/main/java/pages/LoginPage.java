package pages;

import common.Browser;
import org.openqa.selenium.By;

public class LoginPage {
    private static final By textFieldEmail = By.cssSelector("[data-test-id='username']");
    private static final By buttonNext = By.cssSelector("[data-test-id='next-btn']");
    private static final By textFieldPassword = By.cssSelector("[data-test-id='password']");
    private static final By buttonLogin = By.cssSelector("[data-test-id='login-btn']");
    public Browser browser = new Browser();

    public LoginPage openUrl() {
        browser.openUrl("https://e2e.innosabi.com/");
        return this;
    }

    public LoginPage setEmail(String email) {
        browser.sendKeys(textFieldEmail, email);
        return this;
    }

    public LoginPage clickNext() {
        browser.click(buttonNext);
        return this;
    }

    public LoginPage setPassword(String password) {
        browser.sendKeys(textFieldPassword, password);
        return this;
    }

    public void clickLogin() {
        browser.click(buttonLogin);
    }

}
