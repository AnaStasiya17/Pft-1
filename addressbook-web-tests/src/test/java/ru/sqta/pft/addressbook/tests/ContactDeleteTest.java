package ru.sqta.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupDataContact;

import java.util.List;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class ContactDeleteTest extends TestBase {
    @Test
    public void testModificationContact() {
        app.getNavigationHelper().goToHomePage();
         if(!app.getAppHelper().isThereAContact()) {
             app.getNavigationHelper().goToAddNewContactPage();
              app.getAppHelper().createContact( new GroupDataContact(
                      5, "bbb", "ccc",
                     "ddd", "eee", "LLC"), true);
            }
        List<GroupDataContact> before = app.getAppHelper().getContactList();
        app.getAppHelper().selectContact(before.size() - 1);
        app.getAppHelper().deleteContact();
        app.getNavigationHelper().goToHomePage();
        List<GroupDataContact> after = app.getAppHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }

}

