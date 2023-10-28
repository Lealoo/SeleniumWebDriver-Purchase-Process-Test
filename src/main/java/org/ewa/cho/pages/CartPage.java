package org.ewa.cho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends BasePage{
    //text-sm-center
    private WebDriver driver;
    @FindBy(xpath = "/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a")
    private WebElement proceedToCheckOutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProceedToCheckOutButton() {
        return getVisibleElement(proceedToCheckOutButton);
    }

    public void clickProceedToCheckOutButtonOnCartPage(){
        getProceedToCheckOutButton().click();
    }
}
