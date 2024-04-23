package com.bkocsis.pages;

import com.bkocsis.utils.WebDriverFactory;
import lombok.NonNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoCheckoutStepOnePage {

    WebDriver driver = WebDriverFactory.get();
    protected static final Logger logger = LogManager.getLogger();

    @FindBy(id = "first-name")
    WebElement inputFirstName;
    @FindBy(id = "last-name")
    WebElement inputLastName;
    @FindBy(id = "postal-code")
    WebElement inputPostalCode;
    @FindBy(id = "continue")
    WebElement buttonContinue;

    public SauceDemoCheckoutStepOnePage() {
        PageFactory.initElements(driver, this);
    }

    public void fillCustomerForm(@NonNull String firstName, @NonNull String lastName, @NonNull String postalCode) {
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputPostalCode.sendKeys(postalCode);
        logger.info("Customer information is filled");
    }

    public void clickContinue() {
        buttonContinue.click();
        logger.info("Continue button is clicked");
    }
}
