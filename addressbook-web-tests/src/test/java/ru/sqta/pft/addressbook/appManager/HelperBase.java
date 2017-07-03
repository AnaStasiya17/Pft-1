package ru.sqta.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
                      wd.findElement(locator).clear();
                       wd.findElement(locator).sendKeys(text);
        }


    public void typeContact(By locatorContact, String text) {
        if (text != null) {
            String existingText = wd.findElement(locatorContact).getAttribute("value");
            if (!text.equals(existingText)) {

                wd.findElement(locatorContact).clear();
                wd.findElement(locatorContact).sendKeys(text);
            }
        }
    }


    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
            try {
                 wd.findElement(locator);
                  return  true;
                } catch (NoSuchElementException ex) {
                  return false;
                }
          }


}
