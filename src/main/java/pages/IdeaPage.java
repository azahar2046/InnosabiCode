package pages;

import common.Browser;
import org.openqa.selenium.By;

public class IdeaPage {
    private static final By textFieldIdeaTitle = By.cssSelector("[formcontrolname='title']");
    private static final By textFieldIdea = By.cssSelector("[formcontrolname='content'] textarea");
    private static final By buttonSubmitIdea = By.cssSelector(".btn-primary");
    Browser browser;

    public IdeaPage setIdeaTitle(String title) {
        browser.sendKeys(textFieldIdeaTitle, title);
        return this;
    }

    public IdeaPage setIdea(String idea) {
        browser.sendKeys(textFieldIdea, idea);
        return this;
    }

    public void clickSubmitIdea() {
        browser.clickByText(buttonSubmitIdea, "Submit idea");
    }

    public IdeaPage(Browser browser) {
        this.browser = browser;
    }

}
