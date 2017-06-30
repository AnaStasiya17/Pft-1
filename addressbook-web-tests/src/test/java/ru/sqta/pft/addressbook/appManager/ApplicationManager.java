package ru.sqta.pft.addressbook.appManager;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class ApplicationManager {
    FirefoxDriver wd;
    private SessionHelper sessionHelper;
    private  NavigationHelper navigationHelper;
    private AppHelper appHelper;

    public ApplicationManager() {
    }



    public void init() {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        appHelper = new AppHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public AppHelper getAppHelper() {
        return appHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
