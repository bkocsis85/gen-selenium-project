package com.bkocsis.utils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WebDriverFactory {

    private static final ThreadLocal<WebDriverFactory> threadLocal = ThreadLocal.withInitial(WebDriverFactory::new);
    public static ArrayList<WebDriver> allDrivers = new ArrayList<>();

    WebDriver driver;

    public static WebDriver get() {
        return threadLocal.get().driver;
    }

    public static void set(WebDriver driver) {
        threadLocal.get().driver = driver;
        allDrivers.add(driver);
    }

    public static void remove(WebDriver driver) {
        threadLocal.remove();
        allDrivers.remove(driver);
    }
}
