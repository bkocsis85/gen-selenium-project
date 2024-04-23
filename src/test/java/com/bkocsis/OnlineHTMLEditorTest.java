package com.bkocsis;

import com.bkocsis.pages.OnlineHTMLEditorPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OnlineHTMLEditorTest extends BaseTest {

    @Test(description = "Verify Rich Text Editor")
    public void textEditorTest() {

        OnlineHTMLEditorPage onlineHTMLEditor = new OnlineHTMLEditorPage();

        onlineHTMLEditor.visitPage();

        assertEquals(driver.getTitle(), "Free online HTML editor - onlinehtmleditor.dev");

        onlineHTMLEditor.clickBoldBtn();
        onlineHTMLEditor.typeText("Automation ");
        onlineHTMLEditor.clickBoldBtn();
        onlineHTMLEditor.clickUnderlineBtn();
        onlineHTMLEditor.typeText("Test");
        onlineHTMLEditor.clickUnderlineBtn();
        onlineHTMLEditor.typeText(" Example");

        assertEquals(onlineHTMLEditor.getText(), "Automation Test Example");
    }

}
