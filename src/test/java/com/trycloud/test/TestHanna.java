package com.trycloud.test;

import com.github.javafaker.Faker;
import com.trycloud.base.TestBase;
import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHanna extends TestBase {


    @Test
    public void test(){
        LoginPage loginPage = new LoginPage();
        Faker faker = new Faker();
        loginPage.login(faker.name().username(), faker.internet().password());
        Assert.assertEquals(loginPage.getWarningMsg(), "Wrong username or password.");
        BrowserUtils.getScreenshot("login_page");
    }
}
