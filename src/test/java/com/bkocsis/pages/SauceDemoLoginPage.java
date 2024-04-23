package com.bkocsis.pages;

import com.bkocsis.utils.WebDriverFactory;
import lombok.NonNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLoginPage {

    WebDriver driver = WebDriverFactory.get();
    protected static final Logger logger = LogManager.getLogger();

    @FindBy(id = "user-name")
    WebElement inputUserName;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy(id = "login-button")
    WebElement buttonLogin;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement textErrorMsg;

    public SauceDemoLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
        logger.info("Sauce demo login page is visited");
    }

    public void fillUserName(@NonNull String userName) {
        inputUserName.sendKeys(userName);
        logger.info("User name field is filled with: {}", userName);
    }

    public void fillPassword(@NonNull String password) {
        inputPassword.sendKeys(password);
        logger.info("Password field is filled with: {}", password);
    }

    public void clickLoginBtn() {
        buttonLogin.click();
        logger.info("Login button is clicked");
    }

    public String getErrorMsg() {
        return textErrorMsg.getText();
    }
}
