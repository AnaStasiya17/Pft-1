package ru.sqta.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.sqta.pft.addressbook.appManager.ApplicationManager;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {

        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }


}
