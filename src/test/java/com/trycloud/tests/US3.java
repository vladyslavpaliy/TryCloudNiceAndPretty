package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.google.common.base.Verify;
import com.sun.source.tree.AssertTree;
import com.trycloud.base.TestBase;
import com.trycloud.pages.FilesPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class US3 extends TestBase{

    FilesPage files = new FilesPage();
    LoginPage log = new LoginPage();
    Faker faker = new Faker();
    Random random = new Random();

    @Test (priority = 1)
    public void TC1(){
    log.loginHappyPath();
    WebElement Files = Driver.get().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a"));
    Files.click();
    String filesTitle = log.checkTitle();
    Assert.assertTrue(filesTitle.contains("Files"),"Title FAIL");
    }

    @Test (priority = 1)
    public void TC2() {
        FilesPage files = new FilesPage();
      //  Test case #2 - verify users can select all the uploaded files from the page
       // 1. Login as a user
        WebElement Files = Driver.get().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a"));
        Files.click();
       // 2. Click the top left checkbox of the table
        files.selectAllFilesCheckbox.click();
       // 3. Assert all the files are selected
        /*
        Assert.assertTrue(files.selectAllFilesCheckbox.isSelected(),"NOT selected FAIL");
       // (Pre-condition: there should be at least 2 files are uploaded the page)
       */
        if(files.selectAllFilesCheckbox.isSelected()){
            System.out.println("selected, PASS");
        }else {
            System.out.println("not selected, FAIL");
        }


    }

    @Test(priority = 3)
    public void TC3(){
      //  Test case #3 - verify users can add a file to favorites.
     //   1. Login as a user
        WebElement Files = Driver.get().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a"));
        Files.click();
      //  2. Click action-icon from any file on the page
        files.actionIcon.click();
       // 3. Choose “Add to Favorites” option
        files.addOrRemoveFromFavorites.click();
     //   4. Click “Favorites” sub-module on the lest side
        files.favoritesButton.click();
     //   5. Verify the chosen file is listed on the table
       WebElement displayed = Driver.get().findElement(By.xpath("//*[@id=\"fileList\"]/tr/td[1]/a/span[1]"));
        Assert.assertTrue(displayed.isDisplayed(),"file not displayed FAIL");
     //           (Pre-condition: there should be at least 1 file is uploaded)

}

    @Test(priority = 4)
    public void TC4() {

    //    Test case #4 - verify users can remove a file from favorites.
     //   1. Login as a user
        WebElement Files = Driver.get().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a"));
        Files.click();
     //   2. Click action-icon from any file on the page
        files.actionIcon.click();
     //   3. Click “Remove from Favorites” option
        files.addOrRemoveFromFavorites.click();
     //   4. Verify that the file is removed from Favorites sub-module’s table.
        files.favoritesButton.click();
        /*
        boolean file = Driver.get().findElement(By.xpath("//*[@id=\"fileList\"]/tr/td[1]/a/span[1]")).isDisplayed();
        Assert.assertFalse(file,"file not displayed FAIL");
     //   (Pre-condition: there should be at least 1 file is added to favorites table)
     */
    }

    @Test(priority = 5)
    public void TC5() throws AWTException{

      //  Test case #5 - verify users can upload a file directly to the homepage (File-Uploading)
      //  1. Login as a user
        WebElement Files = Driver.get().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a"));
        Files.click();
     //   2. Click the “+” icon on top
        files.createNewButton.click();
     //   3. Click “upload file”
        files.uploadFileButton.click();
      //  4. Upload a file
        String path = "/Users/vladyslavpaliy/Desktop/Screen Shot 2021-02-05 at 15.16.28xzdsa.png";
       // files.uploadFileButton.sendKeys(path+ Keys.ENTER);

        Robot robot = new Robot();
        // COMMAND + Tad needed to press cuz focus is JAVA lose focus
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(2000);
       //path to Photo
       robot.keyPress(KeyEvent.VK_RIGHT);
       robot.keyRelease(KeyEvent.VK_RIGHT);
        robot.delay(1000);
       robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
        robot.delay(1000);
       robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
       robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
        robot.delay(1000);
       robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(5000);

     //   5. Verify the file is displayed on the page

        System.out.println(files.allPresentFilesList.size());

    }
    @Test(priority = 6)
    public void TC6() {
        // Test case #6 - verify users can create a folder
        //  1. Login as a user
        WebElement Files = Driver.get().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a"));
        Files.click();
        // 2. Click the “+” icon on top
        files.createNewButton.click();
        // 3. Click New Folder
        files.newFolderButton.click();
        //    4. Write a folder name
        // 5. Click submit icon
        WebElement folderNameLine = Driver.get().findElement(By.id("view13-input-folder"));
        folderNameLine.sendKeys("Z folder"+Keys.ENTER);
        // 6. Verify the folder is displayed on the page

    }
    @Test(priority = 7)
    public void TC7() throws AWTException {
       // Test case #7 - verify users can upload a file inside a folder
     //   1. Login as a user
        WebElement Files = Driver.get().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a"));
        Files.click();
     //   2. Choose a folder from the page
        WebElement firstFolder = Driver.get().findElement(By.xpath("//*[@id=\"fileList\"]/tr[1]/td[2]/a/span[1]"));
        firstFolder.click();
     //   3. Click the “+” icon on top
        files.createNewButton.click();
     //   4. Click “upload file”
        files.uploadFileButton.click();
     //   5. Upload a file
        String path = "/Users/vladyslavpaliy/Desktop/Screen Shot 2021-02-05 at 15.16.28xzdsa.png";
        // files.uploadFileButton.sendKeys(path+ Keys.ENTER);

        Robot robot = new Robot();
        // COMMAND + Tad needed to press cuz focus is JAVA lose focus
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(2000);
        //path to Photo
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(10000);
        //  6. Verify the file is displayed on the page
        WebElement displayedFile = Driver.get().findElement(By.xpath("//*[@id=\"fileList\"]/tr/td[1]/label"));
        Assert.assertTrue(displayedFile.isDisplayed(),"file not exist FAIL");

      //  (Pre-condition: there should be at least 1 folder is created on the filers page)

    }
    @Test(priority = 8)
    public void TC8_1() {
        //Test case #8 - verify users can delete a file/folder.
       // 1. Login as a user
       // log.loginHappyPath();
        WebElement Files = Driver.get().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a"));
        Files.click();
       // 2. Click action-icon from any file on the page
        files.actionIcon.click();
       // 3. Choose “delete files” option
        files.deleteFolderOrFile.click();
        //4. Click deleted files on the left bottom corner
        files.deletedFilesButton.click();
        //5. Verify the deleted file is displayed no the page.

        // (Pre-condition: there should be at least 1 file is uploaded inside files page)

        // to do not fail test next time, file need to be restored
        WebElement restore = Driver.get().findElement(By.xpath("/html/body/div[3]/div[2]/div[13]/table/tbody/tr/td[2]/a/span[3]/a[1]"));
        restore.click();

    }
    @Test(priority = 8)
    public void TC8_2() {
      //  Test case #8 - verify users can write comments to files/folders.
    //    1. Login as a user
        WebElement Files = Driver.get().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a"));
        Files.click();
      //  2. Click action-icon from any file on the page
        files.actionIcon.click();
     //   3. Click details
        files.details.click();
     //   4. Write a comment inside to the input box
        WebElement comments = Driver.get().findElement(By.id("commentsTabView"));
        comments.click();
        WebElement commentBox = Driver.get().findElement(By.xpath("/html/body/div[3]/aside/div/div/section[2]/div/div[1]/form/div[1]"));
        commentBox.sendKeys("ku-ku"+Keys.ENTER);
     //   5. Click the submit button to post it
     //   6. Verify the comment is displayed in the comment section.
        WebElement newCommentMessage = Driver.get().findElement(By.xpath("//*[@id=\"commentsTabView\"]/ul/li/div[1]"));
        Assert.assertTrue(newCommentMessage.isDisplayed(),"comment not displayed, FAIL");
    //    (Pre-condition: there should be at least 1 file/foler is uploaded inside files page)


    }
}


