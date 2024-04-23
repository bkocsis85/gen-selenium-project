package com.bkocsis.pages;

import com.bkocsis.utils.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoCartPage {

    WebDriver driver = WebDriverFactory.get();
    protected static final Logger logger = LogManager.getLogger();

    @FindBy(id = "checkout")
    WebElement buttonCheckout;

    public SauceDemoCartPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickCheckout() {
        buttonCheckout.click();
        logger.info("Checkout button is clicked");
    }
}
