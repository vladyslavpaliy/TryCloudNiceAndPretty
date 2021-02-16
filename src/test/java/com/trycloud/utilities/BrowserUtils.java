package com.trycloud.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class BrowserUtils {
    public static String getScreenshot(String name){
        String path = System.getProperty("user.dir")+"/test-output/screenshots"+name+".png";
        //it'll create a new folder in your project
        //system.getProperty("user.dir)-->location of your project

        //creating an objet of take screenshot
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.get();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //takes a screenshot and return it as a file object

        File destination = new File(path);//that's where we'll store a screenshot

        try {
            //cope file to a previously specified location
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return path;

    }

}
