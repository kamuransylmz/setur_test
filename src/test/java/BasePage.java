import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    protected HomePage homePage;
    private final By ads = By.xpath("//span[@class='ins-close-button']");
    private final By image = By.id("responsive-image-1689835577900100");
    private final By cookies = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");

    @BeforeClass
    void setUp(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://www.setur.com.tr/");
        driver.manage().window().maximize();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(image));
        wait.until(ExpectedConditions.elementToBeClickable(ads)).click();

        driver.findElement(cookies).click();

        homePage = new HomePage(driver);

    }
    @AfterClass
    public void tearDown(){
        //driver.quit();
    }

   }