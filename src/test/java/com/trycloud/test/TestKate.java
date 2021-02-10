package com.trycloud.test;

import com.trycloud.base.TestBase;
import com.trycloud.pages.LoginPage;
import com.trycloud.pages.PhotosPage;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestKate extends TestBase {
    LoginPage loginPage=new LoginPage();
    PhotosPage photosPage=new PhotosPage();

    @Test
    public void Test(){
        loginPage.login();

        WebDriverWait wait=new WebDriverWait(Driver.get(),5);
        wait.until(ExpectedConditions.titleContains("Dashboard"));

        Driver.get().findElement(By.xpath("(//a[@aria-label='Photos'])[1]")).click();

       Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       //photosPage.photosModule("Your videos");

 //    Assert.assertTrue(photosPage.getModuleLabelTest(photosPage.getYourTaggedPhotosLabelText()).contains("Tagged photos"));
       Assert.assertTrue( photosPage.isModuleDisplayed());
    }

}
