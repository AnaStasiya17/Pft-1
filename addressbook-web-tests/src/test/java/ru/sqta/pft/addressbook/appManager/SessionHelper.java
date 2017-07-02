package ru.sqta.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String userName, String password) {
        type(By.name("user"),userName);
        type(By.name("pass"),password);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
        //wd.findElement(By.cssSelector("html")).click();
       // wd.findElement(By.cssSelector("html")).click();

    }
}
