package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhotosPage {

    private WebDriver driver= Driver.get();

   // all elements for Your photo module
    @FindBy(xpath = "//span[@title='Your photos']")
    private WebElement yourPhotosModule;

    @FindBy(xpath = "//h2[contains(text(),'Your photos')]")
    private WebElement yourPhotosLabelTest;


    // all elements for Your videos module
    @FindBy(xpath = "//span[@title='Your videos']")
    private WebElement yourVideosModule;

    @FindBy(xpath = "//h2[contains(text(),'Your videos')]")
    private WebElement yourVideosLabelTest;


    // all elements for  Favorites module
    @FindBy(xpath = "//span[@title='Favorites']")
    private WebElement yourFavoritesModule;

    @FindBy(xpath = "//h2[contains(text(),'Favorites')]")
    private WebElement yourFavoritesLabelText;


    // all elements for Your folders module
    @FindBy(xpath = "//span[@title='Your folders']")
    private WebElement yourFoldersModule;

    @FindBy(xpath = "//h2[contains(text(),'Your folders')]")
    private WebElement yourFoldersLabelText;


    // all elements for Shared with you module
    @FindBy(xpath = "//span[@title='Shared with you']")
    private WebElement yourSharedWithYouModule;

    @FindBy(xpath = "//h2[contains(text(),'Shared with')]")
    private WebElement yourSharedWithYouLabelText;


    // all elements for Your Tagged Photos module
    @FindBy(xpath = "//span[@title='Tagged photos']")
    private WebElement yourTaggedPhotosModule;

    @FindBy(xpath = "//h2[contains(text(),'Tagged photos')]")
    private WebElement yourTaggedPhotosLabelText;


    @FindBy(xpath = "//*[@id=\"app-content-vue\"]/div/div[2]/h2")
    private WebElement displayedMessage;

    @FindBy(xpath = "//a[@class='app-navigation-toggle']")
    private  WebElement photosMenu;



    public void photosModule(String moduleName){
        driver.findElement(By.xpath("//span[@title='"+moduleName+"']")).click();
    }







    public PhotosPage(){
        PageFactory.initElements(driver,this);
    }





}
