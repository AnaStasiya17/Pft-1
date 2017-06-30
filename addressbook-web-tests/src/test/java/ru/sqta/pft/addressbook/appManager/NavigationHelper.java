package ru.sqta.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void goToPageGroup() {
        click(By.linkText("groups"));
    }

    public void goToContactPage() {
        click(By.linkText("add new"));
    }

    public void goToHomePage() {
        click(By.linkText("home"));
    }
}
