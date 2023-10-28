import org.ewa.cho.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class PurchaseProcessTest {
    private WebDriver driver;
    private static String orderNumber;
    private static String totalOrderPrice;

    @DataProvider(name = "testPurchaseProcessData")
    public Object[][] testData() {
        return new Object[][]{
                {"M", "5"},
                //  {"XL", "7"},

        };
    }

    @BeforeTest
    public void setUp() {
        this.driver = new ChromeDriver();
        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/");

        headerPage.clickSignInButton();
        loginPage.fillEmailInputField("luckykate@mail.com");
        loginPage.fillPasswordInputField("luckyme1234");
        loginPage.clickSignInButton();
        headerPage.clickHomePageButton();
    }

    @Test(dataProvider = "testPurchaseProcessData", priority = 0)
    public void purchaseProcess(String size, String itemQuantity) {
        HeaderPage headerPage = new HeaderPage(driver);
        LandingPage landingPage = new LandingPage(driver);


        headerPage.fillAndSubmitSearchInputField("Hummingbird Printed Sweater");
        landingPage.clickTheItem();

        ShopItemPage shopItemPage = new ShopItemPage(driver);

        String discountPercentage;
        String regularPrice;
        String discountPrice;
        String calculatedDiscountPrice;

        discountPercentage = shopItemPage.getDiscountPercentageText();
        regularPrice = shopItemPage.getRegularPriceText();
        discountPrice = shopItemPage.getDiscountPriceText();
        calculatedDiscountPrice = shopItemPage.claculateDiscountPrice();

        Assert.assertEquals("SAVE 20%", discountPercentage);
        Assert.assertEquals("€35.90", regularPrice);
        Assert.assertEquals(calculatedDiscountPrice, discountPrice);
        //Assert.assertEquals("€28.72",calculatedDiscountPrice);
        //Assert.assertEquals("€28.72", discountPrice);

        shopItemPage.selectSizeFromDropDownList(size);


        shopItemPage.specifyTheQuantityOfTheItemAndConfirm(itemQuantity);
        // shopItemPage.clickAddToCartButton();

        PopUpCartPage popUpCartPage = new PopUpCartPage(driver);
        popUpCartPage.clickProceedToCheckoutButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickProceedToCheckOutButtonOnCartPage();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickConfirmAddressButton();
        orderPage.clickConfirmDeliveryOptionButton();
        orderPage.clickPayByCheckOption();
        orderPage.clickTermsAndConditionsCheckBox();
        orderPage.clickPlaceOrderButton();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.takeScreenShotOfAnOrder();
        orderNumber = orderConfirmationPage.getOrderReferenceText();
        totalOrderPrice = orderConfirmationPage.getTotalOrderPriceText();
    }

    @Test(priority = 1)
    public void orderHistoryTest() {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickAccountButton();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickOrderHistoryAndDetailsButton();

        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        String lastOrderReferenceText = orderHistoryPage.getOrderReferenceText();
        String lastOrderTotalPriceText = orderHistoryPage.getOrderTotalPriceText();
        String lastOrderStatusText = orderHistoryPage.getOrderStatusText();

        Assert.assertEquals(lastOrderStatusText, "Awaiting check payment");
        Assert.assertEquals(lastOrderReferenceText, orderNumber);
        Assert.assertEquals(lastOrderTotalPriceText, totalOrderPrice);
    }


    @AfterTest
    public void after(){
        driver.quit();
    }
}
