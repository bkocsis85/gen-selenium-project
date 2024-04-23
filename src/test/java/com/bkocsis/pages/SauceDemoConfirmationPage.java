package com.bkocsis.pages;

import com.bkocsis.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoConfirmationPage {

    WebDriver driver = WebDriverFactory.get();

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement textThankYou;

    public SauceDemoConfirmationPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isThankYouMsgDisplayed() {
        return textThankYou.isDisplayed();
    }

}
