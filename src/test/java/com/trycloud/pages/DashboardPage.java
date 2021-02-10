package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {


    @FindBy(className = "user-status-menu-item__toggle user-status-menu-item__toggle--inline")
    private WebElement status;

    @FindBy(className = "icon action-item__menutoggle icon-fair-day action-item__menutoggle--with-title")
    private WebElement weather;

    @FindBy(xpath = "//a[@class='edit-panels icon-rename' and text()='Customize']")
    private WebElement customize;

    @FindBy(css = "svg[class='material-design-icon__svg']")
    private WebElement search;

    @FindBy(css = "div[class='notifications-button menutoggle']")
    private WebElement notification;

    @FindBy(css = "div[class='icon-contacts menutoggle']")
    private WebElement contacts;

    @FindBy(css = "div[class='avatardiv avatardiv-shown']")
    private WebElement avatar;

    @FindBy(css = "li[data-id='logout']")
    private WebElement logout;

    @FindBy(css = "li[data-id='help']")
    private WebElement help;

    @FindBy(css = "a[class='user-status-menu-item__toggle']")
    private WebElement setStatus;

    @FindBy(css = "li[data-id='settings']")
    private WebElement settings;

    @FindBy(css = "input[class='unified-search__form-input']")
    private WebElement searchInput;

    public WebElement getStatus() {
        return status;
    }

    public WebElement getWeather() {
        return weather;
    }

    public WebElement getCustomize() {
        return customize;
    }

    public WebElement getSearch() {
        return search;
    }

    public WebElement getNotification() {
        return notification;
    }

    public WebElement getContacts() {
        return contacts;
    }

    public WebElement getAvatar() {
        return avatar;
    }

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getHelp() {
        return help;
    }

    public WebElement getSetStatus() {
        return setStatus;
    }

    public WebElement getSettings() {
        return settings;
    }

    public DashboardPage(){
        PageFactory.initElements(Driver.get(), this);

    }
    /**
     * @param tab
     * dashboard
     * files
     * photos
     * activity
     * spreed
     * mail
     * contacts
     * circles
     * calendar
     * deck
     */

    //TryCloud Navigation
    public void navigateTo(String tab){
        String tabXpath= "//li[@data-id='"+tab+"']";
        WebElement tabElement = Driver.get().findElement(By.xpath(tabXpath));
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
       wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();

    }

    public LoginPage logout(){
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(avatar)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();

        return new LoginPage();

    }

    public void searchInput(String txt){
       WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
       searchInput.sendKeys(txt);
       wait.until(ExpectedConditions.textToBePresentInElement(searchInput, txt));
       searchInput.sendKeys(Keys.ENTER);

    }


}
