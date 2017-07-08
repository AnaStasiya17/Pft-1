package ru.sqta.pft.addressbook.tests;


import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupData;
import ru.sqta.pft.addressbook.model.GroupDataContact;

import java.util.Comparator;
import java.util.List;


public class CreateContactTest extends TestBase {

    @Test(enabled = false)
    public void createNewContact() {

        app.goTo().goToHomePage();
           List<GroupDataContact> before = app.contact().getContactList();
                app.goTo().goToAddNewContactPage();
                GroupDataContact contact = new GroupDataContact(
                 6, "First", "second",
                        "LastName", null, "test1");
                app.contact().createContact(contact, true);
                List<GroupDataContact> after = app.contact().getContactList();
                Assert.assertEquals(after.size(), before.size() + 1);
                contact.setId(after.stream().max(Comparator.comparingInt(GroupDataContact::getId)).get().getId());
                before.add(contact);
                Comparator<? super GroupDataContact> byId = Comparator.comparingInt(GroupDataContact::getId);
                before.sort(byId);
                after.sort(byId);
                Assert.assertEquals(before, after);
    }
}