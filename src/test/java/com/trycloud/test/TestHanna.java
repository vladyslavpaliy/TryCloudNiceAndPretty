package com.trycloud.test;

import com.trycloud.base.TestBase;
import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.LoginPage;
import org.testng.annotations.Test;

public class TestHanna extends TestBase {


    @Test
    public void test(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginHappyPath().searchInput("hanna");
    }
}
