package org.ewa.cho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HeaderPage extends BasePage {
    private WebDriver driver;
    @FindBy(className = "user-info")
    private WebElement userSignInButton;
    @FindBy(id = "_desktop_logo")
    private WebElement homePageButton;
    @FindBy(name = "s")
    private WebElement searchInputField;
    @FindBy(className = "account")
    private WebElement accountButton;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUserSignInButton() {
        return getVisibleElement(userSignInButton);
    }

    public WebElement getHomePageButton() {
        return getVisibleElement(homePageButton);
    }

    public WebElement getSearchInputField() {
        return getVisibleElement(searchInputField);
    }

    public WebElement getAccountButton() {
        return getVisibleElement(accountButton);
    }

    public void clickSignInButton(){
        getUserSignInButton().click();
    }
    public void clickHomePageButton(){
        getHomePageButton().click();
    }
    public void fillAndSubmitSearchInputField(String nameOfAnItem){
        getSearchInputField().clear();
        getSearchInputField().sendKeys(nameOfAnItem);
        getSearchInputField().submit();
    }
    public void clickAccountButton(){
        getAccountButton().click();
    }

}
