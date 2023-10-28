package org.ewa.cho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class OrderHistoryPage {
    private WebDriver driver;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/table/tbody/tr[1]/th")
    private WebElement orderReference;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/table/tbody/tr[1]/td[2]")
    private WebElement orderTotalPrice;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/table/tbody/tr[1]/td[4]/span")
    private WebElement orderStatus;
    public OrderHistoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String getOrderReferenceText(){
        String orderReferenceText = orderReference.getText();
        return orderReferenceText;
    }
    public String getOrderTotalPriceText(){
        String orderTotalPriceText = orderTotalPrice.getText().substring(1);
        return orderTotalPriceText;
    }
    public String getOrderStatusText(){
        String orderStatusText = orderStatus.getText().substring(0, 22);
        return orderStatusText;
    }
}
