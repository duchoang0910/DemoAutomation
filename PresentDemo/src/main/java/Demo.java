import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Demo {
    public static URL url;
    public static DesiredCapabilities caps;
    public static AndroidDriver<MobileElement> driver;

    /*1 — Functions that have the @BeforeSuite annotation will be run before every test suite run. Such a function can be
    used to setup the application into the right state/condition before the individual test cases are run.*/
    @BeforeSuite
    public void setupAppium() throws MalformedURLException {

//2 — We set the URL to the localhost where we will be running appium
        final String NEW_STRING = "http://127.0.0.1:4723/wd/hub";
        url = new URL(NEW_STRING);

// Install App
        File app = new File("C:Users\\tranh\\Downloads\\sample.apk");

//3 — Setup an object that will hold the Appium Capabilities
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SAMSUNG-SM-G930V");
        caps.setCapability(MobileCapabilityType.UDID, "025c26b2");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8");
//        caps.setCapability("app",app.getAbsolutePath());
        caps.setCapability("appPackage", "com.afollestad.materialdialogssample");
        caps.setCapability("appActivity", "com.afollestad.materialdialogssample.MainActivity");
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

/* 4 — Initialise the driver with the URL and Capabilities object.
This driver will be the main object used to interact with the device */
        driver = new AndroidDriver<MobileElement>(url, caps);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.resetApp();
        System.out.println("Application Started.......");
    }

    /* 5— Functions that have the @AfterSuite annotation will be run after every test suite run. These functions should be
    used to clean up any changes done on the device before the next test suite run. */
/*    @AfterSuite
    public void uninstallApp() throws InterruptedException {
        driver.removeApp("com.afollestad.materialdialogssample.active");
    }*/
  /*6 — Functions that start with @Test will be identified as TestNG tests. you can enable or disable a test in the test
   suite by toggling the value in (enabled=true). This test at the moment will just reset the application and no nothing else.*/
    @Test(enabled = true)
    public void testBasicAndButtons() throws InterruptedException {
        // Find the button BASIC (NO TITLE) and click it
        driver.findElementById("com.afollestad.materialdialogssample:id/basic_buttons").click();
        // Assert the presence of the popup title, AGREE and DISAGREE buttons
        Boolean isMessagePresent = !driver.findElementsById("com.afollestad.materialdialogssample:id/md_text_message").isEmpty();
        Boolean isDisagreePresent = !driver.findElementsById("com.afollestad.materialdialogssample:id/md_button_negative").isEmpty();
        Boolean isAgreePresent = !driver.findElementsById("com.afollestad.materialdialogssample:id/md_button_positive").isEmpty();

        Assert.assertTrue(isMessagePresent && isDisagreePresent && isAgreePresent);

        // Assert the contents of the popup title, AGREE and DISAGREE button
// Click on the AGREE button
        driver.findElementById("com.afollestad.materialdialogssample:id/md_button_positive").click();


    }

    @Test(enabled = true)
    public void testCheckBox() throws InterruptedException {
        driver.findElementById("com.afollestad.materialdialogssample:id/basic_checkbox_titled_buttons").click();
        driver.findElementById("com.afollestad.materialdialogssample:id/md_checkbox_prompt").click();
    }

    @Test(enabled = true)
    public void testTextBox() throws InterruptedException {
//        String element = driver.findElementById("com.afollestad.materialdialogssample:id/input");
//        driver.findElementById("com.afollestad.materialdialogssample:id/md_input_message").sendKeys("Hello World");
//        TouchActions action = new TouchActions(driver);
//        action.scroll(element, 10, 100);
//        action.perform();



    }
}
