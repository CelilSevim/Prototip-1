package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {

    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return getDriver(Browser.CHROME);
    }

    public static WebDriver getDriver(Browser browsers) {

        if (drivers.get() == null) {
            switch (browsers) {
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                    break;
                case OPERA:
                    WebDriverManager.operadriver().setup();
                    drivers.set(new OperaDriver());
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    drivers.set(new ChromeDriver());
            }
        }
        return drivers.get();
    }

    public static void quitDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }
}
