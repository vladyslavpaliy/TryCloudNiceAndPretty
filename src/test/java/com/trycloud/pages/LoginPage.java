package com.trycloud.pages;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class LoginPage {

    private final WebDriver driver = Driver.get();

    @FindBy(id = "user")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "submit-form")
    private WebElement loginButton;
    @FindBy(id = "lost-password")
    private WebElement forgotPassword;
    @FindBy(css = "[class='warning wrongPasswordMsg']")
    private WebElement warningMsg;
    @FindBy(xpath = "//li[contains(@data-id,'contacts')]")
    public WebElement contactsPage;


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void login() {
        usernameField.sendKeys(ConfigurationReader.getProperty("username1"));
        passwordField.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);//click
    }

    public String getWarningMsg() {
        return warningMsg.getText();
    }

    public String checkUrl() {
        return driver.getCurrentUrl();
    }

    public String checkTitle() {
        return driver.getTitle();
    }

    public DashboardPage loginHappyPath() {
        usernameField.sendKeys(ConfigurationReader.getProperty("username1"));
        passwordField.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
        return new DashboardPage();
    }


}
