package com.trycloud.test;

import com.trycloud.base.TestBase;
import com.trycloud.pages.ContactsPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class test1 extends TestBase{

    @Test
    public void test2(){
        LoginPage sd = new LoginPage();
        sd.loginHappyPath();
        System.out.println(ConfigurationReader.getProperty("qa2"));

    }
}
