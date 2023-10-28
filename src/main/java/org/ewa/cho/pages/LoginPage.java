package org.ewa.cho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    @FindBy(id = "field-email")
    private WebElement emailInputField;
    @FindBy(id = "field-password")
    private WebElement passwordInputField;
    @FindBy(id = "submit-login")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void fillEmailInputField(String email){
        emailInputField.sendKeys(email);
    }
    public void fillPasswordInputField(String password){
        passwordInputField.sendKeys(password);
    }
    public void clickSignInButton(){
        signInButton.click();
    }
}
