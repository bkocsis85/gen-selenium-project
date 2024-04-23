package com.bkocsis.pages;

import com.bkocsis.utils.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineHTMLEditorPage {

    WebDriver driver = WebDriverFactory.get();
    protected static final Logger logger = LogManager.getLogger();

    @FindBy(xpath = "//button[contains(@data-cke-tooltip-text, 'Bold')]")
    WebElement buttonBold;
    @FindBy(xpath = "//button[contains(@data-cke-tooltip-text, 'Underline')]")
    WebElement buttonUnderline;
    @FindBy(xpath = "//div[@role='textbox']")
    WebElement inputEditor;

    public OnlineHTMLEditorPage() {
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        driver.get("https://onlinehtmleditor.dev/");
        logger.info("Online HTML Editor page is visited");
    }

    public void clickBoldBtn() {
        buttonBold.click();
        logger.info("Bold button is clicked");
    }

    public void clickUnderlineBtn() {
        buttonUnderline.click();
        logger.info("Underline button is clicked");
    }

    public void typeText(String text) {
        inputEditor.sendKeys(text);
        logger.info("Text '{}' is typed into the text field", text);
    }

    public String getText() {
        return inputEditor.getText().replaceAll("[\\p{Cf}]", "");
    }
}
