package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        String menu = "Computers";
        clickOnElement(By.xpath("//a[text()='Computers ']"));
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: Z to A");
        // Verify the Product will arrange in Descending order.
        List<WebElement> List = driver.findElements(By.xpath("//select[@id='products-orderby']"));
        for (int i = 0; i < List.size(); i++) {
            System.out.println(List.get(i).getText());
            String exp = List.get(i).getText();
            String actual = List.get(i).getText();
            Assert.assertEquals("Price not ordered : High to Low ", exp, actual);
            System.out.println("Produts display in descending order");
        }

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully()throws InterruptedException{
        //Click on Computer Menu.
     clickOnElement(By.xpath("//a[text()='Computers ']"));
     //click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
     //
       selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: A to Z");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[text() = 'Build your own computer']"));
        Assert.assertEquals("Total matched", "Build your own computer", getTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']")));
     //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        clickOnElement(By.id("product_attribute_1"));
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200") ;
     //select 8GB
       clickOnElement(By.id("product_attribute_1") );
       selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]" );
     //select HDD radio
       clickOnElement(By.id("product_attribute_3_7") );
     //Select OS radio "Vista Premium [+$60.00]
     clickOnElement(By.id("product_attribute_4_9") );
   //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]
     clickOnElement(By.id("product_attribute_5_12") );
        // Verify the price "$1,475.00"
      Assert.assertEquals("$1,300.00",getTextFromElement(By.id("price-value-1")));
      clickOnElement(By.id("add-to-cart-button-1"));
     //Verify the Message "The product has been added to your shopping cart" on Top green Bar
     Assert.assertEquals("The product has been added to your shopping cart",getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]")));
  //After that close the bar clicking on the cross button
  clickOnElement(By.xpath("//span[@class = 'close']"));
  //MouseHover on "Shopping cart"
    mouseHoverToElement(By.xpath("//a[@class='ico-cart']") );
  //Verify the message "Shopping cart"
  Assert.assertEquals("Shopping cart",getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart]")));
  Thread.sleep(2000);
  //CLEAR QUANTITY FIELD
     clearTextField(By.xpath("//input[@class='qty-input']"));
  //change the quantity
     sendTextToElement(By.xpath("//input[@class='qty-input']"),"2" );
   //Click on "Update shopping cart"
   clickOnElement(By.xpath("//button[@id='updatecart']"));
   Thread.sleep(2000);
  //verify the Total"$2,950.00"
  Assert.assertEquals("$2,950.00",getTextFromElement(By.xpath("//span[@class='product-subtotal']")));
 //click on checkbox
  clickOnElement(By.xpath("//input[@id='termsofservice']"));
//click on check out
   clickOnElement(By.id("checkout") );
 // VERIFY TEXT
 Assert.assertEquals("Welcome, Please Sign In!",getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")));
//click on check out as guest
clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']") );
//Fill all mandatory field
  sendTextToElement(By.id("BillingNewAddress_FirstName"),"Maya" );
  sendTextToElement(By.id("BillingNewAddress_LastName"),"Smith" );
  sendTextToElement(By.id("BillingNewAddress_Email"),"Maya277@gmail.com");
  selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"United Kingdom" );
  sendTextToElement(By.id("BillingNewAddress_City"),"Watford" );
  sendTextToElement(By.id("BillingNewAddress_Address1"),"10 Hainesway" );
  sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"W25 7Qu");
  sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"07899675871");
  clickOnElement(By.xpath("//button[text()='Continue']"));
// click on continue
clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
//SELECT RADIO BUTTON
clickOnElement(By.id("paymentmethod_1"));
//CLICK ON CONTINUE
clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
//SELECT MASTER CARD
selectByVisibleTextFromDropDown(By.id("CreditCardType"),"Master card" );
// fill the details
sendTextToElement(By.id("CardholderNam"),"Maya Smith" );
sendTextToElement(By.id("CardNumber"),"0000 0000 0000" );
clickOnElement(By.id("ExpireMonth"));
selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"10" );
selectByVisibleTextFromDropDown(By.id("ExpireYear"),"2026" );
sendTextToElement(By.id("CardCode"), "526");
clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

// verify payment method is creadit card
 Assert.assertEquals("Payment Method: Credit Card",getTextFromElement(By.xpath("//li[@class='payment-method']")));
// VERIFY SHIPPING METHOD IS NEXT DAY AIR
Assert.assertEquals("Shipping Method: Next Day Air",getTextFromElement(By.xpath("//li[@class='shipping-method']")));
//VERIFY AMOUNT
Assert.assertEquals("$2,950.00",getTextFromElement(By.xpath("//span[text()='$2,950.00'][@class = 'product-subtotal']" )));
//CLICK ON CONFIRM
clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
// verify thank you
Assert.assertEquals("Thank you",getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]")));
// VERIFY PROCESSED ORDER
Assert.assertEquals("Your order has been successfully processed",getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!")));
//click on continue
clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
// VERIFY THE TEXT
Assert.assertEquals("Welcome to our store",getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")));


}
    @After
    public void setDown() {
        closeBrowser();
    }
}