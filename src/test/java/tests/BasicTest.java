package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by DTAB.
 * Example tests for AWS Device Farm
 */
public class BasicTest {
    private static AppiumDriver<WebElement> driver;
    public WebDriverWait wait;
    private By enterButton = By.className("button is-dark is-large");
    private By continueButton = By.linkText("Continuer sans mise-à-jour");

    /**
     * Run before each method
     * @throws MalformedURLException
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<WebElement>(appiumURL, capabilities);
    }

    /**
     * Run After each test method
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void basicTest(){
        takeScreenshot("basicTest");
        try{
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //click(continueButton);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            takeScreenshot("Continue Button Clicked");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //click(enterButton);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            takeScreenshot("Enter Button Clicked");

        }catch(Exception e){

        }
        // assertTrue(true);
    }

    void click(By element) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    /**
     * Take Screenshot
     * @param name file name
     * @return true if successful
     */
    private boolean takeScreenshot(final String name) {
        String screenshotDirectory = System.getProperty("appium.screenshots.dir");
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
    }
}
