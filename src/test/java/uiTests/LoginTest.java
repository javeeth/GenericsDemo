package uiTests;

import afterGenerics2.page.HomePage;
import afterGenerics2.page.LoginPage;
import afterGenerics2.page.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public Page page;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();

        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver, 15);

        //Maximize Window
        driver.manage().window().maximize();

        //Instantiate the Page Class
        page = new Page(driver, wait);
    }

    @Test
    public void loginToAmazon() throws InterruptedException {

        page.GetInstance(HomePage.class).goToAmazon();

        page.GetInstance(LoginPage.class).loginToAmazon("javeeth@gmail.com");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
