package com.epam.control.eagerlocator;

import com.epam.control.elementfactory.ElementFactory;
import com.epam.control.elementimpl.AbstractComponent;
import com.epam.control.engine.Drivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Oleh_Maksymuk on 11/23/2015.
 */
public class AbstractLocators {

    public static AbstractComponent locate (Class clazz, By by) {

        WebElement webElement = Drivers.get().findElement(by);

        return ElementFactory.getElement(clazz, webElement);
    }

}
