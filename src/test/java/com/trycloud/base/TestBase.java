package com.trycloud.base;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract  class TestBase {

    private WebDriver driver = Driver.get();

    private static Properties configFile;

    public TestBase(){
       try {
           //IO-->input output
           FileInputStream file = new FileInputStream("src/test/java/com/trycloud/utilities/config/configuration.properties");
            configFile = new Properties();
           configFile.load(file);
           file.close();

       } catch (IOException e) {
           System.out.println("File was not loaded");
           e.printStackTrace();
       }
}

    @BeforeMethod
    public void setUp(){
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown(){ driver.close(); }

}
