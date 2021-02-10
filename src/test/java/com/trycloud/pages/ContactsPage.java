package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Scanner;

public class ContactsPage {

    @FindBy(xpath = "//div[contains(@class,'vue-recycle-scroller__item-view')]//*[contains(@class,'app-content-list-item-line-one')]")
    private List<WebElement> contactList;

    //CONTACT INFO//
    //headerINFO//
    @FindBy(id = "contact-fullname")
    private WebElement name;
    @FindBy(id = "contact-org")
    private WebElement company;
    @FindBy(id = "contact-title")
    private WebElement title;
    //phone//
    @FindBy(xpath = "(//*[@class='property__value'])[1]")
    private WebElement phoneNumber;
    @FindBy(xpath = "(//button[starts-with(@class,'action-item')])[1]")
    private WebElement deletePhoneNumber;
    @FindBy(xpath = "(//span[@class='multiselect__single'])[2]")
    private WebElement phoneNumberTypeDropdown;
    //email//
    @FindBy(xpath = "(//*[@class='property__value'])[2]")
    private WebElement emailAddress;
    @FindBy(xpath = "(//button[starts-with(@class,'action-item')])[2]")
    private WebElement deleteEmail;
    @FindBy(xpath = "(//span[@class='multiselect__single'])[3]")
    private WebElement emailTypeDropdown;
    //Address//
    @FindBy(xpath = "(//*[@class='property__value'])[3]")
    private WebElement postOfficeBox;
    @FindBy(xpath = "(//*[@class='property__value'])[4]")
    private WebElement address;
    @FindBy(xpath = "(//*[@class='property__value'])[5]")
    private WebElement extendedAddress;
    @FindBy(xpath = "(//*[@class='property__value'])[6]")
    private WebElement postalCode;
    @FindBy(xpath = "(//*[@class='property__value'])[7]")
    private WebElement city;
    @FindBy(xpath = "(//*[@class='property__value'])[8]")
    private WebElement stateOrProvince;
    @FindBy(xpath = "(//*[@class='property__value'])[9]")
    private WebElement country;
    @FindBy(xpath = "(//button[starts-with(@class,'action-item')])[3]")
    private WebElement deleteAddress;
    @FindBy(xpath = "(//span[@class='multiselect__single'])[4]")
    private WebElement addressTypeDropdown;

    //contact setting//
    @FindBy(xpath = "//div[@class='contact-header__actions']//button")
    private WebElement contactSettings;
    //address book//
    @FindBy(xpath = "(//span[@class='multiselect__single'])[5]")
    private WebElement setAddressBook;
    //select book//
    @FindBy(xpath = "(//input[@class='multiselect__input'])[5]")
    private WebElement groupsSelect;
    //CONTACT INFO//






    //MENU ELEMENTS
    @FindBy(xpath = "//a[contains(@class,'app-navigation-toggle')]")
    private WebElement menuToggle;
    @FindBy(xpath = "//*[contains(@id,'new-contact-button')]")
    private WebElement newContactBtn;
    @FindBy(xpath = "//*[contains(@title,'All contacts')]")
    private WebElement allContacts;
    @FindBy(xpath = "//*[contains(@title,'Not grouped')]")
    private WebElement notGrouped;
    @FindBy(xpath = "//*[contains(@title,'+ New group')]")
    private WebElement newGroup;
    @FindBy(xpath = "//ul[@class='app-navigation__list']//button")
    private WebElement groupSettings;//            MUST SPECIFY ^[index] ACCORDING TO BOOK INDEX//

    //SETTINGS ELEMENTS
    @FindBy(xpath = "//*[contains(@class,'settings-button')]")
    private WebElement settingsBtn;
    @FindBy(xpath = "//label[contains(@for,'socialSyncToggle')]")
    private WebElement updateAvatarsCheckBox;
    @FindBy(id = "new-addressbook")
    private WebElement newAddressBook;
    @FindBy(xpath = "//li[@class='addressbook']//span")
    private List<WebElement> addressBookList;
    @FindBy(xpath = "//span[contains(text(),'Sort by Display name')]")
    private WebElement sortByDropDown;
    @FindBy(xpath = "//*[@class='addressbook__share icon-shared']")
    private WebElement shareAddressBook;//         MUST SPECIFY ^[index] ACCORDING TO BOOK INDEX//
    @FindBy(xpath    = "//li[@class='addressbook']//button")
    private WebElement addressBookSettings;//MUST SPECIFY ^[index] ACCORDING TO BOOK INDEX//


    private Scanner scan = new Scanner(System.in);
    private final WebDriver driver = Driver.get();

    public ContactsPage() {
        PageFactory
                .initElements(driver, this);
    }

    public void contactNames() {
        for (WebElement each : contactList) {
            int count = 1;
            count++;
            System.out.println("[" + count + "]> " + each.getText());
        }
        int choice = scan.nextInt();
        boolean flag = true;
        while (flag) {
            switch (choice) {
                case 1:
                    contactList.get(0).click();
                    flag = false;
                case 2:
                    contactList.get(1).click();
                    flag = false;
                case 3:
                    contactList.get(2).click();
                    flag = false;

                default:
                    System.out.println("Error invalid choice pick again");
            }
        }
    }

    public String checkUrl() {
        return driver.getCurrentUrl();
    }

    public String checkTitle() {
        return driver.getTitle();
    }

}
