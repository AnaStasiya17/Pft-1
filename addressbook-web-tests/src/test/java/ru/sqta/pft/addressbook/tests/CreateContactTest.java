package ru.sqta.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupDataContact;

import java.util.Comparator;
import java.util.List;


public class CreateContactTest extends TestBase {

    @Test
    public void createNewContact() {

        app.getNavigationHelper().goToHomePage();
        List<GroupDataContact> before = app.getAppHelper().getContactList();
        app.getNavigationHelper().goToAddNewContactPage();
        GroupDataContact contact = new GroupDataContact(
                6, "First", "second",
                "LastName", null, "test1");
        app.getAppHelper().createContact(contact, true);
        List<GroupDataContact> after = app.getAppHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
        contact.setId(after.stream().max(Comparator.comparingInt(GroupDataContact::getId)).get().getId());
        before.add(contact);
        Comparator<? super GroupDataContact> byId = Comparator.comparingInt(GroupDataContact::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}