package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserManager {
	public static WebDriver doBrowserSetup() throws IOException {
        WebDriver driver = null;
        String name = PropertiesLoader.loadProperty("browser.name");
        if (name.equalsIgnoreCase("Chrome")) {

            String pathExtension = PropertiesLoader.loadProperty("chrome-path");

            System.setProperty("webdriver.chrome.driver","C:\\Users\\Ajit Tamboli\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("load-extension=" + pathExtension); 
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);

        } else if (name.equalsIgnoreCase("Firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments();
            firefoxOptions.addArguments();
            driver = new FirefoxDriver(firefoxOptions);
        }
        return driver;
    }
	
	
}
