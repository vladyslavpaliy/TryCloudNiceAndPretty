package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class FilesPage{

    private WebDriver driver = Driver.get();
    // All FILES
    @FindBy (xpath = "//*[@id=\"app-navigation\"]/ul/li[1]/a")
    public WebElement allFilesButton;
    @FindBy (xpath = "//*[@id=\"app-navigation\"]/ul/li[2]/a")
    public WebElement recentButton;
    @FindBy (xpath = "//*[@id=\"app-navigation\"]/ul/li[3]/a")
    public WebElement favoritesButton;
    @FindBy (xpath = "//*[@id=\"app-navigation\"]/ul/li[4]/a")
    public WebElement shareButton;
    @FindBy (xpath = "//*[@id=\"app-navigation\"]/ul/li[5]/a")
    public WebElement shareTags;
    @FindBy (xpath = "//*[@id=\"app-navigation\"]/ul/li[6]/a")
    public WebElement shareToCircle;
    @FindBy (xpath = "//*[@id=\"app-navigation\"]/ul/li[7]/a")
    public WebElement deletedFilesButton;

    @FindBy (xpath = "/html/body/div[3]/div[2]/div[2]/table/thead/tr/th[1]/label")
    public WebElement selectAllFilesCheckbox;
    //Action icon
    @FindBy (xpath = "//*[@id=\"fileList\"]/tr[1]/td[2]/a/span[3]/a[2]")
    public WebElement actionIcon;
    @FindBy (xpath = "//*[@id=\"fileList\"]/tr[1]/td[2]/div/ul/li[3]/a/span[2]")
    public WebElement addOrRemoveFromFavorites;
    @FindBy (xpath = "//*[@id=\"fileList\"]/tr[1]/td[2]/div/ul/li[4]/a/span[2]")
    public WebElement details;
    @FindBy (xpath = "//*[@id=\"fileList\"]/tr[1]/td[2]/div/ul/li[5]/a/span[2]")
    public WebElement rename;
    @FindBy (xpath = "//*[@id=\"fileList\"]/tr[1]/td[2]/div/ul/li[6]/a/span[2]")
    public WebElement moveOrCopy;
    @FindBy (xpath = "//*[@id=\"fileList\"]/tr[1]/td[2]/div/ul/li[7]/a/span[2]")
    public WebElement download;
    @FindBy (xpath = "//*[@id=\"fileList\"]/tr[1]/td[2]/div/ul/li[8]/a/span[2]")
    public WebElement deleteFolderOrFile;

    // + options
    @FindBy (xpath = "//*[@id=\"controls\"]/div[2]/a/span[1]")
    public WebElement createNewButton;
    @FindBy (xpath = "//*[@id=\"controls\"]/div[2]/div[2]/ul/li[1]/label/span[2]")
    public WebElement uploadFileButton;
    @FindBy (xpath = "//*[@id=\"controls\"]/div[2]/div[2]/ul/li[2]/a/span[2]")
    public WebElement newFolderButton;
    @FindBy (xpath = "//*[@id=\"controls\"]/div[2]/div[2]/ul/li[3]/a/span[2]")
    public WebElement newTextDocumentButton;
    @FindBy (xpath = "//*[@id=\"controls\"]/div[2]/div[2]/ul/li[4]/a/span[2]")
    public WebElement newDocumentButton;
    @FindBy (xpath = "//*[@id=\"controls\"]/div[2]/div[2]/ul/li[5]/a/span[2]")
    public WebElement newSpreadSheetButton;
    @FindBy (xpath = "//*[@id=\"controls\"]/div[2]/div[2]/ul/li[6]/a/span[2]")
    public WebElement newPresentationButton;


    @FindBy(xpath = "//*[@id=\"fileList\"]/tr[1]/td[1]/label")
    public List<WebElement> allPresentFilesList;


    public FilesPage(){
        PageFactory.initElements(driver,this);
    }

    public void uploadFile(String name){
        createNewButton.click();
        uploadFileButton.sendKeys(name);
    }

    public void createFolder(String name){
        createNewButton.click();
        newFolderButton.click();
        driver.findElement(By.xpath("//*[@id=\"controls\"]/div[2]/div[2]/ul/li[2]/a/span[2]")).sendKeys(name + Keys.ENTER);
    }

    public void createNewTextDocument(String name){
        createNewButton.click();
        newTextDocumentButton.click();
        driver.findElement(By.xpath("//*[@id=\"view16-input-file\"]")).sendKeys(name + Keys.ENTER);
    }

    public void createNewDocument(String name){
        createNewButton.click();
        newDocumentButton.click();
        driver.findElement(By.xpath("//*[@id=\"view13-input-x-office-document\"]")).sendKeys(name + Keys.ENTER);
    }

    public void createNewSpreadsheet(String name){
        createNewButton.click();
        newSpreadSheetButton.click();
        driver.findElement(By.xpath("//*[@id=\"view13-input-x-office-spreadsheet\"]")).sendKeys(name + Keys.ENTER);
    }

    public void createNewPresentation(String name){
        createNewButton.click();
        newPresentationButton.click();
        driver.findElement(By.xpath("//*[@id=\"view13-input-x-office-presentation\"]")).sendKeys(name + Keys.ENTER);
    }


}
