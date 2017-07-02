package ru.sqta.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.sqta.pft.addressbook.appManager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class TestBase {
    protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    public static boolean isAlertPresent(WebDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }



    @AfterMethod
    public void tearDown() {
        app.stop();
    }


}
