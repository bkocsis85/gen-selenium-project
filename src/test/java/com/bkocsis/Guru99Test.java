package com.bkocsis;

import com.bkocsis.pages.Guru99HomePage;
import com.bkocsis.pages.Guru99LiveSeleniumProjectPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Guru99Test extends BaseTest {

    public static final String PAGE_TITLE = "Selenium Live Project: FREE Real Time Project for Practice";

    @Test(description = "Verify iFrame link and tab handling")
    public void iFrameAndTabHandlingTest() {

        Guru99HomePage guru99HomePage = new Guru99HomePage();
        Guru99LiveSeleniumProjectPage seleniumProjectPage = new Guru99LiveSeleniumProjectPage();

        guru99HomePage.visitPage();
        guru99HomePage.acceptCookies();
        guru99HomePage.clickIFrame();

        assertEquals(seleniumProjectPage.getSeleniumProjectPageTitle(), PAGE_TITLE);

        seleniumProjectPage.closeTab();
        guru99HomePage.clickSeleniumLink();

        //I cannot find the wide red Join button on the page. Probably it has been already removed.
    }
}
