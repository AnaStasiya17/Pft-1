package ru.sqta.pft.addressbook.tests;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ru.sqta.pft.addressbook.appManager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class TestBase {
    protected  static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);


    public static boolean isAlertPresent(WebDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }
}
