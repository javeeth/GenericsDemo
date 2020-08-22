package afterGenerics2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    //*********Constructor*********
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Web Elements*********
    By usernameBy = By.id("ap_email");
    By loginButtonBy = By.id("continue");
    By signInButtonBy = By.xpath("//a[text()='Sign in securely']");
    //*********Page Methods*********

    public LoginPage loginToAmazon(String username) {

        click(signInButtonBy);
        //Enter Username(Email)
        writeText(usernameBy, username);
        //Click Login Button
        click(loginButtonBy);
        return this;
    }
}
