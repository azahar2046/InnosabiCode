package pages;

import common.Browser;
import org.openqa.selenium.By;

public class InnovationChallengePage {

    private static final By buttonSubmitIdea = By.cssSelector("div.can-submit button");
    private static final By suggestionCards = By.cssSelector(".panel-suggestion");
    private static final By buttonSendComment = By.cssSelector(".btn-send");
    private static final By commentInformation = By.cssSelector(".comment-information");
    Browser browser;

    public void clickSubmitIdea() {
        browser.click(buttonSubmitIdea);
    }

    public InnovationChallengePage setComment(String title, String comment) {
        browser.enterComment(suggestionCards, title, comment);
        return this;
    }

    public void clickSend() {
        browser.click(buttonSendComment);
    }

    public InnovationChallengePage(Browser browser) {
        this.browser = browser;
    }
}
