package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.UUID;

public class ElectronicsTest extends Utility  {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void UserShouldNavigateToCellPhonesPageSuccessfully() {
        // Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        // Mouse Hover on “Cell phones” and "Click"
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
        //  Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));

       Assert.assertEquals("Incorrect Top Menu", expectedText, actualText) ;
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException{
        // * 2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
        Thread.sleep(2000);
        // * 2.2 Mouse Hover on “Cell phones” and "Click"
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
        Thread.sleep(2000);
        // * 2.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals ("Incorrect Top Menu", expectedText, actualText) ;
        // * 2.4 Click on List View Tab
        clickOnElement(By.linkText("List"));
        Thread.sleep(2000);
        // * 2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.linkText("Nokia Lumia 1020"));
        // * 2.6 Verify the text “Nokia Lumia 1020”
        String expectedMessage = "Nokia Lumia 1020";
        String actualMessage = getTextFromElement(By.xpath("//h1[text() = 'Nokia Lumia 1020']"));
       Assert.assertEquals ("Incorrect message displayed!", expectedMessage, actualMessage) ;
        // * 2.7 Verify the price “$349.00”
        Thread.sleep(2000);
        String expectedPrice = "$349.00";
        String actualPrice = getTextFromElement(By.id("price-value-20"));
        Assert.assertEquals ("Incorrect Price", expectedPrice, actualPrice) ;
        // * 2.8 Change quantity to 2
        Thread.sleep(2000);
        clearTextField(By.id("product_enteredQuantity_20"));
        Thread.sleep(2000);
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");
        // * 2.9 Click on “ADD TO CART” tab
        Thread.sleep(2000);
        clickOnElement(By.id("add-to-cart-button-20"));
        // * 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(2000);
        String expectedOutput = "The product has been added to your shopping cart";
        String actualOutput = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals ("", expectedOutput, actualOutput) ;
        Thread.sleep(2000);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class = 'close']"));
        Thread.sleep(2000);
        // * 2.11 Then MouseHover on "Shopping cart"
        mouseHoverToElement(By.xpath("//a[@class='ico-cart']"));
        //Click on "GO TO CART" button.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[@class='cart-label']"));
        // * 2.12 Verify the message "Shopping cart"
        String expectedCartMessage = "Shopping cart";
        String actualCartMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
       Assert.assertEquals ("Incorrect message displayed!", expectedCartMessage, actualCartMessage) ;
        Thread.sleep(2000);
        // * 2.13 Verify the quantity is 2
        String expectedQuantity = "2";
        String actualQuantity = driver.findElement(By.xpath("//input[@class = 'qty-input']")).getAttribute("value");
        Assert.assertEquals ("Incorrect quantity",expectedQuantity, actualQuantity) ;
        Thread.sleep(2000);
        // * 2.14 Verify the Total $698.00
        String expectedTotal = "$698.00";
        String actualTotal = getTextFromElement(By.xpath("//span[text() = '$698.00']"));
        Assert.assertEquals ("", expectedTotal, actualTotal) ;
        Thread.sleep(2000);
        // * 2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        Thread.sleep(2000);
        // * 2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        Thread.sleep(2000);
        // * 2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedWelcomeMessage = "Welcome, Please Sign In!";
        String actualWelcomeMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Assert.assertEquals("Incorrect message displayed!", expectedWelcomeMessage, actualWelcomeMessage) ;
        Thread.sleep(2000);
        // * 2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[@class = 'button-1 register-button']"));
        Thread.sleep(2000);
        // * 2.19 Verify the text “Register”
        String expectedRegisterText = "Register";
        String actualRegisterText = getTextFromElement(By.xpath("//h1[normalize-space()='Register']"));
        Assert.assertEquals ("", expectedRegisterText, actualRegisterText) ;
        // * 2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"), "Maya");
        sendTextToElement(By.id("LastName"), "Smith");
//        sendTextToElement(By.name("DateOfBirthDay"), "18");
//        sendTextToElement(By.name("DateOfBirthMonth"), "December");
//        sendTextToElement(By.name("DateOfBirthYear"), "1988");
        final String randomEmail = randomEmail();
        sendTextToElement(By.id("Email"), randomEmail);
        sendTextToElement(By.name("Password"), "456789");
        sendTextToElement(By.name("ConfirmPassword"), "456789");
        // * 2.21 Click on “REGISTER” Button
        clickOnElement(By.name("register-button"));
        Thread.sleep(2000);
        // * 2.22 Verify the message “Your registration completed”
        String expectedRegistrationMessage = "Your registration completed";
        String actualRegistrationMessage = getTextFromElement(By.className("result"));
        Assert.assertEquals ("Incorrect message displayed", expectedRegistrationMessage, actualRegistrationMessage) ;
        Thread.sleep(2000);
        // * 2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(2000);
        // * 2.24 Verify the text “Shopping cart”
        String expectedCartText = "Shopping cart";
        String actualCartText = getTextFromElement(By.linkText("Shopping cart"));
        Assert.assertEquals ("Incorrect Shopping Cart Text!", expectedCartText, actualCartText) ;
        Thread.sleep(2000);
        clickOnElement(By.linkText("Log in"));
        sendTextToElement(By.id("Email"),randomEmail);
        sendTextToElement(By.name("Password"), "456789");
        Thread.sleep(2000);
        //Click on Login button
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        Thread.sleep(2000);
        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(2000);
        //Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        Thread.sleep(2000);
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "Watford");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "10 Hainesway");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "WD25 7qu");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07899675871");
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@class='button-1 new-address-next-step-button']"));
        //Click on Radio Button “2nd Day Air ($0.00)
        clickOnElement(By.id("shippingoption_2"));
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectByValueFromDropDown(By.id("CreditCardType"), "Visa") ;
        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Maya Smith");
        sendTextToElement(By.id("CardNumber"), "0000 0000 0000 0000");
        Thread.sleep(2000);
        clickOnElement(By.id("ExpireMonth"));
        selectByValueFromDropDown(By.id("ExpireMonth"), "10");
        selectByValueFromDropDown(By.id("ExpireYear"), "2026");
        sendTextToElement(By.id("CardCode"), "526");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //Verify “Payment Method” is “Credit Card”
        String expectedPayment= "Payment Method: Credit Card";
        String actualPayment = getTextFromElement(By.xpath("//li[@class='payment-method']"));
       Assert.assertEquals ("Incorrect payment method",expectedPayment,actualPayment) ;
        // Verify “Shipping Method” is “2nd Day Air”
        String expectedShippingMethod= "Shipping Method: 2nd Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//li[@class='shipping-method']"));
       Assert.assertEquals ("Error message",expectedShippingMethod,actualShippingMethod) ;
        //Verify Total is “$698.00”
        String expectedPaymentValue = "$698.00";
        String actualPaymentValue = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
        Assert.assertEquals ("Error message",expectedPaymentValue,actualPaymentValue) ;
        Thread.sleep(2000);
        //Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //Verify the Text “Thank You”
        String expectedMessageThank = "Thank you";
        String actualMessageThank = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals ("Error message displayed",expectedMessageThank,actualMessageThank) ;
        //Verify the message “Your order has been successfully processed!”
        String expectedVerifyMessage = "Your order has been successfully processed!";
        String actualVerifyMessage = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals ("Error displayed",expectedVerifyMessage,actualVerifyMessage) ;
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //Verify the text “Welcome to our store”
        String expectedyWelcomeText = "Welcome to our store";
        String actualWelcomeText = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals ("Error message",expectedyWelcomeText,actualWelcomeText) ;
        //Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals ("Error in URL",expectedUrl,actualUrl) ;
    }

    private String randomEmail() {

        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    }

}




