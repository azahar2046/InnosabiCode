package innosabi.qa.automat.UI;

import common.Utils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.IdeaPage;
import pages.InnovationChallengePage;
import pages.LoginPage;

public class CreateAnIdeaAndComment {
    LoginPage loginPage;
    HomePage homePage;
    InnovationChallengePage innovationChallengePage;
    IdeaPage ideaPage;
    SoftAssert softAssert;

    String success = "Your idea was successfully submitted";
    String title;
    String idea;
    String comment;

    @BeforeClass
    private void setUp() {
        loginPage = new LoginPage();
        homePage = new HomePage(loginPage.browser);
        innovationChallengePage = new InnovationChallengePage(loginPage.browser);
        ideaPage = new IdeaPage(loginPage.browser);
        softAssert = new SoftAssert();

        title = Utils.randomString(20);
        idea = Utils.randomParagraph();
        comment = Utils.randomString(10);

    }


    @Test
    public void createInnovationChallenge() {

        loginPage.openUrl()
                .setEmail("md.azahar2046@gmail.com")
                .clickNext()
                .setPassword("2046@Azahar")
                .clickLogin();

        homePage.clickInnovationChallenge();

        innovationChallengePage.clickSubmitIdea();

        ideaPage.setIdeaTitle(title)
                .setIdea(idea)
                .clickSubmitIdea();

        softAssert.assertEquals(innovationChallengePage.getSuccessMessage(), success);

        innovationChallengePage.setComment(title, comment)
                .clickSend();

        softAssert.assertAll();
    }

    @AfterClass(alwaysRun = true)
    private void tearDown() {
        loginPage.browser.quitBrowser();
    }
}
