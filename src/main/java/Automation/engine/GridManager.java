package Automation.engine;

import com.sun.source.tree.TryTree;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridManager {

    public static WebDriver TakeToGrid () {


        WebDriver driver = null;
        try {
            String GridUrl = "http://localhost:4444";
            URL url = new URL(GridUrl);

            ChromeOptions chromeOptions = new ChromeOptions();
            //  chromeOptions.setCapability("browserVersion", "67");
            // chromeOptions.setCapability("platformName", "Windows 10");
            driver = new RemoteWebDriver(url, chromeOptions);


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("remote error");
        }


        return driver;

    }





}
