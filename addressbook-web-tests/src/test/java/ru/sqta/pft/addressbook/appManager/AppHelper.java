package ru.sqta.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.sqta.pft.addressbook.model.GroupData;
import ru.sqta.pft.addressbook.model.GroupDataContact;


/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class AppHelper extends HelperBase {
    public AppHelper(FirefoxDriver wd) {
        super(wd);

    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

    public void submitGroupCreate() {
        click(By.name("submit"));
    }

    public void enterFieldGroupCreate(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }


    public void initGroupCreate() {
        click(By.name("new"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void submitContact() {
        click(By.name("submit"));
    }

    public void enterFieldGroupCreate(GroupDataContact groupDataContact) {
        typeContact(By.name("firstname"), groupDataContact.getName());
        typeContact(By.name("middlename"), groupDataContact.getSecondName());
        typeContact(By.name("lastname"), groupDataContact.getLastName());
        typeContact(By.name("address"), groupDataContact.getAddress());
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitMofification() {
        click(By.name("update"));
    }

    public void editContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[8]/a/img"));
    }

    public void enterContact() {
        click(By.xpath("//div/div[4]/form[2]/table/tbody/tr[3]/td[1]/input"));
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

}
