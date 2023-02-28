package com.motivity.BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebPage {
    public WebDriver driver;
    public DesiredCapabilities desiredCapabilities;

    /**
      * For Normal Test
     */
    @BeforeSuite
    public void launchingTheBrowser(){
         WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    /**
    *   Selenium Grid  and
    *    LambdaTest
    */

//    @Parameters({"browser"})
//
//    @BeforeTest
//    public void setUp(String browser) throws MalformedURLException {
//        switch(browser){
//            case "chrome" :
//                desiredCapabilities = new DesiredCapabilities();
//                ChromeOptions chromeOptions = new ChromeOptions();
//                desiredCapabilities.setCapability("browserName ","chrome");
//                chromeOptions.merge(desiredCapabilities);
//               driver = new RemoteWebDriver(new URL("http://192.168.1.7:4444/wd/hub"),chromeOptions);
//
//
//                //lambda Test
//                 // driver = new RemoteWebDriver(new URL("https://siva8kolli:vD3odXjTNAuNp8c9erlyzXklveqygmOySmBFTuZyyKGRwmKvhN@hub.lambdatest.com/wd/hub"),desiredCapabilities);
//
//                break;
//
//
//            case "edge" :
//                desiredCapabilities = new DesiredCapabilities();
//                EdgeOptions edgeOptions = new EdgeOptions();
//                desiredCapabilities.setCapability("browserName ","MicrosoftEdge");
//                edgeOptions.merge(desiredCapabilities);
//                driver = new RemoteWebDriver(new URL("http://192.168.1.7:4444/wd/hub"),edgeOptions);
//               // driver = new RemoteWebDriver(new URL("https://siva8kolli:vD3odXjTNAuNp8c9erlyzXklveqygmOySmBFTuZyyKGRwmKvhN@hub.lambdatest.com/wd/hub"),desiredCapabilities);
//
//                break;
//        }
//        driver.get("https://magento.softwaretestingboard.com/");
//    }

}
