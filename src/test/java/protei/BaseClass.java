package protei;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    String path = "src/test/resources/qa-test.html";
    File file = new File(path);
    String absolutePath = file.getAbsolutePath();

    public WebDriver driver;

    protected Properties properties;

    @BeforeClass
    public void setUpProperties() {
        properties = PropertiesUtil.loadProperties();
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(absolutePath);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}