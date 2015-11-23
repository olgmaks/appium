package com.epam.control.engine;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Drivers {

    private static WebDriver driver;
    private static final long IMPLICITLY_WAIT_TIMEOUT = 20;
    private static final Object SYNC_ROOT = new Object();



    private Drivers() {
    }

    public static WebDriver get() {

        if (driver == null) {

            synchronized (SYNC_ROOT) {

                if (driver == null) {

                    File app = new File("src/main/resources/color-notes.apk");
                    DesiredCapabilities capabilities = new DesiredCapabilities();

                    capabilities.setCapability("deviceName", "Android Emulator");
                    capabilities.setCapability(CapabilityType.VERSION, "5.0.0");
                    capabilities.setCapability("app", app.getAbsolutePath());
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
                    capabilities.setCapability(CapabilityType.PLATFORM, "windows");
                    capabilities.setCapability("appPackage", "com.socialnmobile.dictapps.notepad.color.note");
                    capabilities.setCapability("appActivity", "com.socialnmobile.colornote.activity.Main");

                    try {

                        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

                        driver
                                .manage()
                                .timeouts()
                                .implicitlyWait(15, TimeUnit.SECONDS);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        return driver;
    }

    public static long getImplicitlyWaitTimeout() {
        return IMPLICITLY_WAIT_TIMEOUT;
    }

    public static void stop() {

        if (driver != null) {
            driver.quit();
        }

        driver = null;
    }

    public static void load(String path) {
        get().get(path);
    }

    public static void refresh() {
        get().navigate().refresh();
    }

    public static void alertAccept() {
        get().switchTo().alert().accept();
    }

    public static void alertDismiss() {
        get().switchTo().alert().dismiss();
    }

    public static String getAlertText() {
        return get().switchTo().alert().getText();
    }

    public static void previousPage() {
        get().navigate().back();
    }

    public static void forwardPage() {
        get().navigate().forward();
    }
}
