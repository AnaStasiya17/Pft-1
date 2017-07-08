package ru.sqta.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupDataContact;

import java.util.List;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class ContactDeleteTest extends TestBase {
    @Test(enabled = false)
    public void testModificationContact() {
        app.goTo().goToHomePage();
         if(!app.contact().isThereAContact()) {
             app.goTo().goToAddNewContactPage();
              app.contact().createContact( new GroupDataContact(
                      5, "bbb", "ccc",
                     "ddd", "eee", "LLC"), true);
            }
        List<GroupDataContact> before = app.contact().getContactList();
        app.contact().selectContact(before.size() - 1);
        app.contact().deleteContact();
        app.goTo().goToHomePage();
        List<GroupDataContact> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }

}

