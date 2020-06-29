import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;


public class ZapPayDemo extends BaseTest {
    //    String submitBtn = "//div[@class=’btn btn-lg btn-primary btn-block’]";
String selectLogout = "user-name dropdown-indicator";
    @Test(priority = 1)
    public void testZapPayLoginBlank() throws InterruptedException {
        login("", "");
        Assert.assertEquals(driver.getCurrentUrl(), URL_login,"Pass roi nha");
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void testZapPayLoginBlankPassword() throws InterruptedException {
        login("duc.hoang@inapps.net", "");
        Assert.assertEquals(driver.getCurrentUrl(), URL_login,"Pass roi nha");
        Thread.sleep(3000);
    }
    @Test(priority = 3)
    public void testZapPayLoginBlankUsername() throws InterruptedException {
        login("", "123456");
        Assert.assertEquals(driver.getCurrentUrl(), URL_login,"Pass roi nha");
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void testZapPayLogin() throws InterruptedException {
        login("duc.hoang@inapps.net", "123456");
        Assert.assertEquals(driver.getCurrentUrl(), URL_dashBoard, "Pass roi nha");

        Thread.sleep(3000);
//        System.out.println(driver.getCurrentUrl());

        /*String strPageTitle = driver.getTitle();
        System.out.println("Page title: - "+strPageTitle);
        Assert.assertTrue(strPageTitle.equalsIgnoreCase("Zap-Pay"), "Page title doesn't match");*/
    }


}
