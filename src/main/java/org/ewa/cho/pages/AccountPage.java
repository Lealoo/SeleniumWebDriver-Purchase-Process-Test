package org.ewa.cho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    private WebDriver driver;
    @FindBy(id = "history-link")
    private WebElement orderHistoryAndDetailsButton;

    public AccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOrderHistoryAndDetailsButton(){
        orderHistoryAndDetailsButton.click();
    }

}
