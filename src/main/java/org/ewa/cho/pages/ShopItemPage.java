package org.ewa.cho.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;

public class ShopItemPage extends BasePage{
    private WebDriver driver;

    @FindBy(className = "regular-price")
    private WebElement regularPrice;
    @FindBy(className = "current-price-value")
    private WebElement discountPrice;
    @FindBy(className = "discount-percentage")
    private WebElement discountPercentage;
    @FindBy(id = "group_1")
    private WebElement sizeDropDownList;
    @FindBy(id = "quantity_wanted")
    private WebElement itemQuantityInputField;
    @FindBy(className = "bootstrap-touchspin-up")
    private WebElement addItemByOneButton;
    @FindBy(className = "add-to-cart")
    private WebElement addToCartButton;

    public ShopItemPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRegularPrice() {
        return getVisibleElement(regularPrice);
    }

    public WebElement getDiscountPrice() {
        return getVisibleElement(discountPrice);
    }

    public WebElement getDiscountPercentage() {
        return getVisibleElement(discountPercentage);
    }

    public WebElement getSizeDropDownList() {
        return getVisibleElement(sizeDropDownList);
    }

    public WebElement getItemQuantityInputField() {
        return getVisibleElement(itemQuantityInputField);
    }

    public WebElement getAddItemByOneButton() {
        return getVisibleElement(addItemByOneButton);
    }

    public WebElement getAddToCartButton() {
        return getVisibleElement(addToCartButton);
    }

    public String getRegularPriceText(){
        return getRegularPrice().getText();
    }
    public String claculateDiscountPrice(){
        double discountValue = 0.2;
        String priceText = getRegularPrice().getText();
        double price = Double.parseDouble(priceText.substring(1));

        price -= price * discountValue;
        priceText = Double.toString(price);
        priceText = "€" + priceText;

        return priceText;
    }
    public String getDiscountPriceText(){
        return getDiscountPrice().getText();
    }
    public String getDiscountPercentageText(){
        return getDiscountPercentage().getText();
    }
    public void selectSizeFromDropDownList(String size){
        Select select = new Select(getSizeDropDownList());
        select.selectByVisibleText(size);
    }
    public void specifyTheQuantityOfTheItemAndConfirm(String quantity){
        getItemQuantityInputField().click();
        getItemQuantityInputField().sendKeys(Keys.BACK_SPACE, quantity, Keys.ENTER);
    }

   /* public void clickAddToCartButton(){
        getAddToCartButton().click();
    }*/

}
