package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility  {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    public void selectMenu(String menu) {
        //click on menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space() = '" + menu + "']"));
        //verify navigation of page
        String expected = menu;
        String actual = getTextFromElement(By.xpath("//h1[contains(text(),'" + menu + "')]"));
        Assert.assertEquals("Incorrect top menu", expected, actual);
    }
    @Test
    public void verifyPageNavigation() throws InterruptedException {
        selectMenu("Computers");
        selectMenu("electronics");
        selectMenu("Apparel");
        selectMenu("Digital downloads");
        selectMenu("Books");
        selectMenu("Jewelry");
        selectMenu("Gift Cards");
    }
    @After
    public void setDown() {

        closeBrowser();
    }

    }



