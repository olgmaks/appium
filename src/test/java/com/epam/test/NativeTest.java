package com.epam.test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * Created by OLEG on 21.11.2015.
 */
public class NativeTest {

    private static WebDriver driver;


    @Test
    public void test() {

        WebElement el = driver.findElement(By.name("Animation"));
        assertEquals("Animation", el.getText());
        el = driver.findElement(By.className("android.widget.TextView"));

        assertEquals("API Demos", el.getText());
        el = driver.findElement(By.name("App"));
        el.click();
        List<WebElement> els = driver.findElements(By.className("android.widget.TextView"));
        assertEquals("Activity", els.get(2).getText());
    }


    @BeforeClass
    public static void before() throws MalformedURLException {


        File app = new File("src/main/resources/color-notes.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformVersion", "5.0.0");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.socialnmobile.dictapps.notepad.color.note");
        capabilities.setCapability("appActivity", "com.socialnmobile.colornote.activity.Main");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        try {
            Thread.sleep(2400000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterClass
    public static void after() {

        if (driver != null)
            driver.quit();

    }

}
