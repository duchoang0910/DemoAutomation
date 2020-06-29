import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;

import static org.openqa.selenium.Keys.ENTER;

public class BaseTest {
    static String driverPath = "C:\\InApps\\Duc\\Automation\\Driver\\";
    public WebDriver driver;
    String URL_login = "https://zappay.inapps.technology/login";
    String URL_dashBoard = "https://zappay.inapps.technology/client/customers";
    String user_login = "email";
    String user_pass = "password";
    public void login(String userName, String password) {
        driver.get(URL_login);
        driver.findElement(By.id(user_login)).sendKeys(userName);
        driver.findElement(By.id(user_pass)).sendKeys(password, ENTER);
    }
    public void takeScreenShot() throws Exception{
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("D:\\SoftwareTestingMaterial.png"));
    }
 /*   @BeforeClass
    public void setUp() {*/
//Google
/*
        System.out.println("*******************");
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_login);
    }*/

// Firefox
 /*       System.out.println("launching firefox browser");
        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(URL_login);
    }*/
    //        Passing browser parameter from testng xml
    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
        //Firefox
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\InApps\\Duc\\Automation\\Driver\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(URL_login);
        }
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\InApps\\Duc\\Automation\\Driver\\chromedriver.exe" +
                    "");
            driver = new ChromeDriver();
            driver.get(URL_login);
        }

    }


    @AfterClass
  /*  public void screenShot(ITestResult result){
        //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
        if(ITestResult.SUCCESS==result.getStatus()){
            try{
                // To create reference of TakesScreenshot
                TakesScreenshot screenshot=(TakesScreenshot)driver;
                // Call method to capture screenshot
                File src=screenshot.getScreenshotAs(OutputType.FILE);
                // Copy files to specific location
                // result.getName() will return name of test case so that screenshot name will be same as test case name
                FileUtils.copyFile(src, new File("C:\\"+result.getName()+".png"));
                System.out.println("Successfully captured a screenshot");
            }catch (Exception e){
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }
        driver.quit();
    }*/
    public void tearDown() {
        driver.quit();
        if (driver != null) {
            System.out.println("Closing browser");
            driver.quit();
        }
    }

}
