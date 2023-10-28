package org.ewa.cho.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OrderPage extends BasePage{
    private WebDriver driver;
    @FindBy(name = "confirm-addresses")
    private WebElement confirmAddressButton;
    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmDeliveryOptionButton;
    @FindBy(xpath = "/html/body/main/section/div/div/section/div/div[1]/section[4]/div/div[2]/div[1]/div/label")
    private WebElement payByCheckOptionRadioButton;
    @FindBy(className = "condition-label")
    private WebElement termsAndConditionsCheckBox;
    @FindBy(xpath = "/html/body/main/section/div/div/section/div/div[1]/section[4]/div/div[3]/div[1]/button")
    private WebElement placeOrderButton;
    public OrderPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getConfirmAddressButton() {
        return getVisibleElement(confirmAddressButton);
    }
    public WebElement getConfirmDeliveryOptionButton() {
        return getVisibleElement(confirmDeliveryOptionButton);
    }
    public WebElement getPayByCheckOptionRadioButton() {
        return getVisibleElement(payByCheckOptionRadioButton);
    }
    public WebElement getTermsAndConditionsCheckBox() {
        return getVisibleElement(termsAndConditionsCheckBox);
    }

    public WebElement getPlaceOrderButton() {
        return getVisibleElement(placeOrderButton);
    }

    public void clickConfirmAddressButton(){
        getConfirmAddressButton().click();
    }
    public void clickConfirmDeliveryOptionButton(){
        getConfirmDeliveryOptionButton().click();
    }
    public void clickPayByCheckOption(){
        getPayByCheckOptionRadioButton().click();
       // JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        //jsExecutor.executeScript("document.querySelector(\"#payment-option-1\").click()");
    }
    public void clickTermsAndConditionsCheckBox(){
        getTermsAndConditionsCheckBox().click();
    }
    public void clickPlaceOrderButton(){
        getPlaceOrderButton().click();
    }
}
