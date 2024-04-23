package com.bkocsis.pages;

import com.bkocsis.utils.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99HomePage {

    WebDriver driver = WebDriverFactory.get();
    protected static final Logger logger = LogManager.getLogger();

    @FindBy(xpath = "//li[contains(@class, 'item118')]")
    WebElement menuItemTesting;
    @FindBy(xpath = "//li[contains(@class, 'item121')]")
    WebElement linkSelenium;
    @FindBy(id = "save")
    WebElement buttonAcceptCookies;
    @FindBy(xpath = "html/body/a/img")
    WebElement linkSeleniumProject;

    public Guru99HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        driver.get("https://demo.guru99.com/test/guru99home/");
        logger.info("Page is visited");
    }

    public void clickSeleniumLink() {
        Actions action = new Actions(driver);
        action.moveToElement(menuItemTesting).perform();
        linkSelenium.click();
        logger.info("Selenium link is clicked in the Testing menu");
    }

    public void acceptCookies() {
        driver.switchTo().frame("gdpr-consent-notice");
        buttonAcceptCookies.click();
        driver.switchTo().defaultContent();
        logger.info("Accept Cookies button is clicked");
    }

    public void clickIFrame() {
        driver.switchTo().frame("a077aa5e");
        linkSeleniumProject.click();
        driver.switchTo().defaultContent();
        logger.info("iFrame image is clicked");
    }
}
