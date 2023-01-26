package Utils;

import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class ParentClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public ParentClass(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driver.manage().deleteAllCookies();
    }
                    // ---- SİTEYE GİTME -----//
    public void gotoSite(String url){
        driver.get(url);

                     // ---- CLİCK LOCATOR -----//
    }
    public void clickTo(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
                    // ---- CLİCK WEB ELEMENT -----//
    public void clickTo(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
                    // ---- SEND KEYS LOCATOR -----//
    public void sendKeysTo(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
                    // ---- BOOLEAN CLEAR SEND KEYS -----//
    public void sendKeysTo(By locator, String text, boolean clear){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if(clear){
            element.clear();
            element.sendKeys(text);
        }
    }
                        // ---- SEND KEYS WEB ELEMENT -----//
    public void sendKeysTo(WebElement element,String text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
                            // ---- SLEEP -----//
    public void sleepTo(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // ---- HOVER -----//
    public void hover(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).pause(1000).perform();
    }


    // ---- SCROOL INTO VİEW WEB ELEMENT-----//
    public void scrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    // ---- SCROOL INTO VİEW LOCATOR -----//
    public void scrollIntoView(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));
    }



    public void verifyTextIn(By locator,String str){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Assert.assertTrue(element.getText().toLowerCase(Locale.ROOT).contains(str.toLowerCase(Locale.ROOT)));
    }



    public int randomSayi(int size){
        return (int) (Math.random() * size);

    }


    public void screenShotBySelenium() throws IOException {
        String scrName = "ScreenShot_ " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        TakesScreenshot scr = (TakesScreenshot) driver; //driver'ın screenshot'unu alıyoruz
        File scrFile = scr.getScreenshotAs(OutputType.FILE); //File tipinde bir değişkene atıyoruz. Çıktı tipi olarak FILE
        File hedefFile = new File("src/test/resources/screenshots/" + scrName + ".png"); //Hedef dosyasını oluşturuyoruz.
        FileUtils.copyFile(scrFile, hedefFile); //Ekran görüntüsünü hedef dosyaya kopyalıyoruz.
    }

    public static void assertIsDisplayed(List<WebElement> elementList){
       for (WebElement element : elementList){
           Assert.assertTrue(element.isDisplayed());
       }

    }
    public static void assertIsEnabled(List<WebElement> elementList){
        for (WebElement element : elementList){
            Assert.assertTrue(element.isEnabled());
        }

    }
    public static void assertIsSelected(List<WebElement> elementList){
        for (WebElement element : elementList){
            Assert.assertTrue(element.isSelected());
        }

    }
    public static WebElement waitForvisibility(WebElement element , int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForvisibility(By locator , int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClicibilty(By locator , int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static WebElement waitForClicibilty(WebElement element , int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
