package com.epam.control.pagetools;

import com.epam.control.engine.Drivers;
import com.epam.control.wraper.DriverElementDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Oleh_Maksymuk on 11/5/2015.
 */
public class PageTools {

    private static final long INTERVAL_BETWEEN_TIMEOUT_IN_MILLISECONDS = 1000;
    private static final long TIMEOUT_IN_SECONDS = 30;


    public static void initPageElements(Object page) {

        PageFactory.initElements(
                new DriverElementDecorator(
                        new DefaultElementLocatorFactory(
                                Drivers.get())), page);
    }

    public static void executeJS(String script) {
        JavascriptExecutor js = (JavascriptExecutor) Drivers.get();
        js.executeScript(script);
    }


    public static void closeBrowser() {
        Drivers.get();
    }


    public static class WaitForElementsByXpath {
        public WaitForElementsByXpath(String xpath) {
            new WebDriverWait(Drivers.get(),
                    TIMEOUT_IN_SECONDS,
                    INTERVAL_BETWEEN_TIMEOUT_IN_MILLISECONDS).until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
        }
    }

}
