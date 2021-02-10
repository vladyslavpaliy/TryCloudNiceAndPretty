package com.trycloud.test;

import com.trycloud.base.TestBase;
import com.trycloud.pages.ContactsPage;
import com.trycloud.pages.LoginPage;
import org.testng.annotations.Test;

public class test1 extends TestBase{

    @Test
    public void test2(){
        LoginPage sd = new LoginPage();
        sd.loginHappyPath();

    }
}
