package org.ewa.cho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Double.parseDouble;

public class LandingPage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[3]/div[1]/div[1]/article/div/div[1]/a/img")
    private WebElement shopItemButton;
    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickTheItem(){
        shopItemButton.click();
    }

}
