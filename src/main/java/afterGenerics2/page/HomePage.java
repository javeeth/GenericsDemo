package afterGenerics2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        //super(driver);
    }

    //*********Page Variables*********
    String baseURL = "https://www.amazon.in/";


    //*********Page Methods*********
    //Go to Homepage
    public HomePage goToAmazon() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(10000);
        return this;
    }

}