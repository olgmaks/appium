package com.epam.control.eagerlocator;

import com.epam.control.element.Button;
import com.epam.control.elementfactory.ElementFactory;
import com.epam.control.engine.Drivers;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Oleh_Maksymuk on 11/23/2015.
 */
public class Buttons {

    private static WebDriver webDriver = Drivers.get();

    private static Button locate (By by) {
       return  (Button) AbstractLocators.locate(Button.class, by);
    }

    public static Button byXpath(String xpath) {
        return locate(By.xpath(xpath));
    }


    public static Button byUIAutomator(String UIAutomator) {
        return locate(MobileBy.AndroidUIAutomator(UIAutomator));
    }



}
