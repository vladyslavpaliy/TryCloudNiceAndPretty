package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
//

    @FindBy(className = "user-status-menu-item__toggle user-status-menu-item__toggle--inline")
    private WebElement status;

    @FindBy(className = "icon action-item__menutoggle icon-fair-day action-item__menutoggle--with-title")
    private WebElement weather;

    @FindBy(xpath = "//a[@class='edit-panels icon-rename' and text()='Customize']")
    private WebElement customize;

    @FindBy(css = "svg[class='material-design-icon__svg']")
    private WebElement search;



    public DashboardPage(){
        PageFactory.initElements(Driver.get(), this);

    }

    //TryCloud Navigation
    public void navigateTo(String tab){
        String tabXpath= "//li[@data-id='"+tab+"']";
        WebElement tabElement = Driver.get().findElement(By.xpath(tabXpath));
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();


    }


}
