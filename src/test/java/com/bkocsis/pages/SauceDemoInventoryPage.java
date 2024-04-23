package com.bkocsis.pages;

import com.bkocsis.utils.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoInventoryPage {

    WebDriver driver = WebDriverFactory.get();
    protected static final Logger logger = LogManager.getLogger();

    @FindBy(id = "shopping_cart_container")
    WebElement linkCart;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement buttonAddBackpack;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement buttonAddFleeceJacket;
    @FindBy(xpath = "//div[@class = 'footer_copy']")
    WebElement textFooter;

    public SauceDemoInventoryPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickCart() {
        linkCart.click();
        logger.info("Cart icon is clicked");
    }

    public void addBackpack() {
        buttonAddBackpack.click();
        logger.info("Backpack is added to the cart");
    }

    public void addJacket() {
        buttonAddFleeceJacket.click();
        logger.info("Jacket is added to the cart");
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        logger.info("Page is scrolled to the bottom");
    }

    public String getNumberOfItemsInCart() {
        return linkCart.getText();
    }

    public String getFooterText() {
        return textFooter.getText();
    }
}
