package afterGenerics2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Page {

    public BasePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Click Method
    public void click (By elementLocation) {
        wait.until(ExpectedConditions.elementToBeClickable(elementLocation)).click();
    }

    //Write Text
    public void writeText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    public String readText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
}
