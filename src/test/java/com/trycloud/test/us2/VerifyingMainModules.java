package com.trycloud.test.us2;
import com.trycloud.base.TestBase;
import com.trycloud.pages.HomePage;
import com.trycloud.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyingMainModules extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void verifyingMainModules()  {

        loginPage.login();
        //2. Verify the user see the following modules:
        //Dashboard
        homePage.hoverOver(homePage.dashboard);
        Assert.assertEquals(homePage.dashboard.getText(), "Dashboard", "Element has a different name");

        //Files
        homePage.hoverOver(homePage.files);
        Assert.assertEquals(homePage.files.getText(), "Files");

        //Galleries
        homePage.hoverOver(homePage.galleries);
        Assert.assertEquals(homePage.galleries.getText(), "Photos", "Element has a different name");
        System.out.println("Element has a different name!!!");

        //Activity
        homePage.hoverOver(homePage.activity);
        Assert.assertEquals(homePage.activity.getText(), "Activity", "Element has a different name");

        //Talk
        homePage.hoverOver(homePage.talk);
        Assert.assertEquals(homePage.talk.getText(), "Talk", "Element has a different name");

        //Mail
        homePage.hoverOver(homePage.mail);
        Assert.assertEquals(homePage.mail.getText(), "Mail", "Element has a different name");

        //Contacts
        homePage.hoverOver(homePage.contacts);
         Assert.assertEquals(homePage.contacts.getText(), "Contacts", "Element has a different name");

        //Circles
        homePage.hoverOver(homePage.circles);
        Assert.assertEquals(homePage.circles.getText(), "Circles", "Element has a different name");

        //Calendar
        homePage.hoverOver(homePage.calendar);
        Assert.assertEquals(homePage.calendar.getText(), "Calendar", "Element has a different name");

        //Deck
        homePage.hoverOver(homePage.deck);
        Assert.assertEquals(homePage.deck.getText(), "Deck", "Element has a different name");

    }


}

