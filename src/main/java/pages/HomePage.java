package pages;

import common.Browser;
import org.openqa.selenium.By;

public class HomePage {
    private static final By linkInnovationChallenge = By.cssSelector(".card-topic");
    Browser browser;

    public void clickInnovationChallenge() {
        browser.scrollIntoView(linkInnovationChallenge);
        browser.click(linkInnovationChallenge);
    }

    public HomePage(Browser browser) {
        this.browser = browser;
    }
}
