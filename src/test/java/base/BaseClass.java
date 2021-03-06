package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public void launchBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("-incognito");
//        options.addArguments("disable-infobars");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        WebDriver chromedriver=new ChromeDriver(capabilities);
//        chromedriver.get(url);

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    public WebElement locateElement(String locator, String locValue) {
        try {
            if (locator.equals("id"))
                return driver.findElement(By.id(locValue));
            else if (locator.equals("name"))
                return driver.findElement(By.name(locValue));
            else if (locator.equals("class"))
                return driver.findElement(By.className(locValue));
            else if (locator.equals("link"))
                return driver.findElement(By.linkText(locValue));
            else if (locator.equals("xpath"))
                return driver.findElement(By.xpath(locValue));
            else
                System.out.println("i is not present");
        } catch (NoSuchElementException e) {
        } catch (WebDriverException e) {
        }
        return null;
    }

    public void type(WebElement ele, String data) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 120);
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            ele.clear();
            ele.sendKeys(data);
        } catch (InvalidElementStateException e) {
        } catch (WebDriverException e) {
        }
    }

    public void click(WebElement ele) {
        String text = "";
        try {
            WebDriverWait wait = new WebDriverWait(driver, 90);
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            text = ele.getText();
            ele.click();
        } catch (InvalidElementStateException e) {
        } catch (WebDriverException e) {
        }

    }

    public String getText(WebElement ele) {
        String bReturn = "";
        try {
            bReturn = ele.getText();
        } catch (WebDriverException e) {
        }
        return bReturn;
    }

    public String getTitle() {
        String bReturn = "";
        try {
            bReturn = driver.getTitle();
        } catch (WebDriverException e) {
        }
        return bReturn;
    }

    public boolean verifyExactTitle(String expectedTitle) {
        boolean bReturn = false;
        try {
            if (getTitle().equals(expectedTitle)) {
                bReturn = true;
            } else {
            }
        } catch (WebDriverException e) {
        }
        return bReturn;
    }

    public void closeActiveBrowser() {
        try {
            driver.close();
        } catch (Exception e) {
        }
    }

    public void closeAllBrowsers() {
        try {
            driver.quit();
        } catch (Exception e) {
        }
    }
}
