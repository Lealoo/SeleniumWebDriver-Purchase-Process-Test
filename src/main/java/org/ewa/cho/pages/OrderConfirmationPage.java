package org.ewa.cho.pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class OrderConfirmationPage {
    private WebDriver driver;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section[2]/div/div/div[2]/ul/li[1]")
    private WebElement orderReference;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section[2]/div/div/div[1]/div[2]/table/tbody/tr[4]/td[2]")
    private WebElement totalOrderPrice;


    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void takeScreenShotOfAnOrder(){
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(screenshotFile.toPath(), new File("order_confirmation.png").toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getOrderReferenceText(){
        String orderText = orderReference.getText().substring(17);
        return orderText;
    }
    public String getTotalOrderPriceText(){
        String totalPriceNumber = totalOrderPrice.getText().substring(1);
        return totalPriceNumber;
    }

}
