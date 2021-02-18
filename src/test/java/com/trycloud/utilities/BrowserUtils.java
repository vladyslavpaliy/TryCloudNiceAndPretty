package com.trycloud.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class BrowserUtils {
    public static String getScreenshot(String name){
        //if you wanna be mre specific and avoid name duplication
        name=name+"_"+ LocalDateTime.now();
        String path = System.getProperty("user.dir")+"/test-output/screenshots/"+name+".png";
        //it'll create a new folder in your project
        //system.getProperty("user.dir)-->location of your project

        //creating an objet of take screenshot
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.get();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //takes a screenshot and return it as a file object

        File destination = new File(path);//that's where we'll store a screenshot

        try {
            //copy file to a previously specified location
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return path;

    }

    /**
     * this method just waits for page to be loaded.
     */
    public static void waitForPageToLoad(long timeOutInSeconds){
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState" ).equals("complete");
        try{
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOutInSeconds);
            wait.until(expectation);
        }catch(Throwable error){
            error.printStackTrace();
        }
    }

    /**
     *simple click method with JS . scrolls and then clicks
     */
    public static void clickWithJS(WebElement element){
        ( (JavascriptExecutor)Driver.get()).executeScript("arguments[0].scrollIntoView(true)", element);
        ((JavascriptExecutor)Driver.get()).executeScript("arguments[0].click()",element);
    }
}
