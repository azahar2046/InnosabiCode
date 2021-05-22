package innosabi.qa.automat.UI;

import common.Utils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.IdeaPage;
import pages.InnovationChallengePage;
import pages.LoginPage;

public class CreateInnovationChallenge {
    LoginPage loginPage;
    HomePage homePage;
    InnovationChallengePage innovationChallengePage;
    IdeaPage ideaPage;

    String title;
    String idea;
    String comment;

    @BeforeClass
    private void setUp() {
        loginPage = new LoginPage();
        homePage = new HomePage(loginPage.browser);
        innovationChallengePage = new InnovationChallengePage(loginPage.browser);
        ideaPage = new IdeaPage(loginPage.browser);

        title = Utils.randomString(20);
        idea = Utils.randomParagraph();
        comment = Utils.randomString(10);

    }


    @Test
    public void createInnovationChallenge() {
        loginPage.setEmail("md.azahar2046@gmail.com")
                .clickNext()
                .setPassword("2046@Azahar")
                .clickLogin();

        homePage.clickInnovationChallenge();

        innovationChallengePage.clickSubmitIdea();

        ideaPage.setIdeaTitle(title)
                .setIdea(idea)
                .clickSubmitIdea();

        innovationChallengePage.setComment(title, comment)
                .clickSend();
    }

    @AfterClass(alwaysRun = true)
    private void tearDown() {
        loginPage.browser.quitBrowser();
    }
}