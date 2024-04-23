package com.bkocsis.pages;

import com.bkocsis.utils.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Guru99LiveSeleniumProjectPage {

    WebDriver driver = WebDriverFactory.get();
    protected static final Logger logger = LogManager.getLogger();
    String mainWindow = driver.getWindowHandle();

    public String getSeleniumProjectPageTitle() {
        switchToTab();
        return driver.getTitle();
    }

    public void switchToTab() {

        for (String windowHandle : driver.getWindowHandles()) {
            if ( !mainWindow.contentEquals(windowHandle) ) {
                driver.switchTo().window(windowHandle);
                logger.info("New tab is selected");
                break;
            }
        }
    }

    public void closeTab() {
        driver.close();
        driver.switchTo().window(mainWindow);
        logger.info("Switched back to the main tab");
    }
}
