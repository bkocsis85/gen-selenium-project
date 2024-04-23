package com.bkocsis.pages;

import com.bkocsis.utils.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoCheckoutStepTwoPage {

    WebDriver driver = WebDriverFactory.get();
    protected static final Logger logger = LogManager.getLogger();

    @FindBy(id = "finish")
    WebElement buttonFinish;

    public SauceDemoCheckoutStepTwoPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickFinish() {
        buttonFinish.click();
        logger.info("Finish button is clicked");
    }
}
