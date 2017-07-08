package ru.sqta.pft.addressbook.appManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.sqta.pft.addressbook.model.GroupData;
import ru.sqta.pft.addressbook.model.GroupDataContact;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Анастасия Цыбулько on 08.07.2017.
 */
public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void submitContact() {

        click(By.xpath("//div[@id='content']/form/input[21]"));
        //click(By.name("submit"));
    }

    public void enterFieldContactCreate(GroupDataContact groupDataContact, boolean creationContact) {
        typeContact(By.name("firstname"), groupDataContact.getName());
        typeContact(By.name("middlename"), groupDataContact.getSecondName());
        typeContact(By.name("lastname"), groupDataContact.getLastName());
        typeContact(By.name("address"), groupDataContact.getAddress());
        if (creationContact) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupDataContact.getGroupContact());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void createContact(GroupDataContact groupDataContact, boolean creation) {
        enterFieldContactCreate(groupDataContact, creation);
        submitContact();
        returnHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void editContact(int index) {
        wd.findElements(By.xpath(".//td[8]")).get(index).click();
    }

    public void enterContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteContact() {
        click(By.xpath("//div/div[4]/form[2]/div[2]/input"));
        closeDialog();
    }

    private void closeDialog() {
        wd.switchTo().alert().accept();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupDataContact> getContactList() {
        List<GroupDataContact> contacts = new ArrayList<GroupDataContact>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[contains(@name,\"entry\")]"));
        for (WebElement element : elements) {
            String name = getFirstName(element);
            String lastName = getLastName(element);
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupDataContact contact = new GroupDataContact(id, name, null,
                    lastName, null, null);
            contacts.add(contact);
        }
        return contacts;
    }

    private String getLastName(WebElement element) {
        return element.findElement(By.xpath("./td[2]")).getText();
    }

    private String getFirstName(WebElement element) {
        return element.findElement(By.xpath("./td[3]")).getText();
    }
    public void returnHomePage() {
        click(By.linkText("home page"));
    }
    public void submitMofification() {
        click(By.name("update"));
    }

}
