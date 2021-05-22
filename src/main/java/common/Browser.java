package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Browser {

    private WebDriver webDriver;

    private void setUpDriver() {

        String osName = System.getProperty("os.name");
        String userDir = System.getProperty("user.dir");

        if (osName != null && osName.toLowerCase().contains("windows")) {
            System.setProperty("webdriver.chrome.driver", userDir + "/chromedriver.exe");

        } else if (osName != null && osName.toLowerCase().contains("linux")) {
            System.setProperty("webdriver.chrome.driver", userDir + "/chromedriver");
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void openUrl(String Url) {
        setUpDriver();
        webDriver.get(Url);
    }


    public void sendKeys(By by, String text) {

        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement webElement = webDriver.findElement(by);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void click(By by) {
        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);

        wait.until(ExpectedConditions.elementToBeClickable(by));
        WebElement webElement = webDriver.findElement(by);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).click().perform();
    }

    public void clickByText(By by, String text) {
        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);

        wait.until(ExpectedConditions.elementToBeClickable(by));
        List<WebElement> webElements = webDriver.findElements(by);
        Actions actions = new Actions(webDriver);
        for (WebElement element : webElements) {
            if (element.getText().equalsIgnoreCase(text)) {
                actions.moveToElement(element).click().perform();
                break;
            }

        }

    }


    public void enterComment(By suggestionCards, String title, String comment) {
        List<WebElement> webElements = webDriver.findElements(suggestionCards);
        Actions actions = new Actions(webDriver);
        for (WebElement element : webElements) {
            String text = element.findElement(By.cssSelector(".title")).getText();
            if (title.equalsIgnoreCase(text)) {
                WebElement commentElement = element.findElement(By.cssSelector("textarea"));
                actions.moveToElement(commentElement).click().perform();
                commentElement.sendKeys(comment);
                break;
            }

        }

    }

    public void quitBrowser() {
        webDriver.quit();
    }

}
