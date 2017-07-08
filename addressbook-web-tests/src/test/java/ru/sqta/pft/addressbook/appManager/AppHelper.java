package ru.sqta.pft.addressbook.appManager;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.sqta.pft.addressbook.model.GroupData;
import ru.sqta.pft.addressbook.model.GroupDataContact;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class AppHelper extends HelperBase {
    public AppHelper(WebDriver wd) {
        super(wd);

    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
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

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    private void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }


    public void deleteGroup() {
        click(By.name("delete"));
    }


    public void initGroupModification() {
        click(By.name("edit"));
    }


    public void create(GroupData group) {
        initGroupCreate();
        enterFieldGroupCreate(group);
        submitGroupCreate();
        returnToGroupPage();
    }
    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        enterFieldGroupCreate(group);
        submitMofification();
        returnToGroupPage();
    }
    public void delete(int index) {
         selectGroup(index);
            deleteGroup();
            returnToGroupPage();
          }
    public void delete(GroupData group) {
            selectGroupById(group.getId());
            deleteGroup();
            returnToGroupPage();
        }
    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }


    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }


    public void submitMofification() {
        click(By.name("update"));
    }

    public void initContactModification(int index) {
        wd.findElements(By.xpath(".//td[8]")).get(index).click();
    }

    public Set<GroupData> all() {
        Set<GroupData> groups = new HashSet<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }
}

