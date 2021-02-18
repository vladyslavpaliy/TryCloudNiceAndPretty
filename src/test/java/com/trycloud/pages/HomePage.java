package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']/li[1]")
    public WebElement dashboard;

    @FindBy(xpath = "//ul[@id='appmenu']/li[2]")
    public WebElement files;

    @FindBy(xpath = "//ul[@id='appmenu']/li[3]")
    public WebElement galleries;

    @FindBy(xpath = "//ul[@id='appmenu']/li[4]")
    public WebElement activity;

    @FindBy(xpath = "//ul[@id='appmenu']/li[5]")
    public WebElement talk;

    @FindBy(xpath = "//ul[@id='appmenu']/li[6]")
    public WebElement mail;

    @FindBy(xpath = "//ul[@id='appmenu']/li[7]")
    public WebElement contacts;

    @FindBy(xpath = "//ul[@id='appmenu']/li[8]")
    public WebElement circles;

    @FindBy(xpath = "//ul[@id='appmenu']/li[9]")
    public WebElement calendar;

    @FindBy(xpath = "//ul[@id='appmenu']/li[10]")
    public WebElement deck;


    public void hoverOver(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }
}