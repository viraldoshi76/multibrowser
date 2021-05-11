package MultiBowserSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Harrow {

    static String baseUrl ="https://www.harrow.gov.uk/";
    static WebDriver driver;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("ener the browser name ie/chrome/firefox/edge : ");
        String browser = input.next();

        if(browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver","driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }else{
            System.out.println("please enter the correct browser name");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get(baseUrl);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.close();
    }
}
