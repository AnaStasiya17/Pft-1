package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;
import ru.sqta.pft.addressbook.model.Contacts;
import ru.sqta.pft.addressbook.model.GroupData;
import ru.sqta.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class DeleteContactFromGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupsPage();
            app.group().create(new GroupData().withName("test1"));
        }

        if (app.db().contacts().size() == 0) {
            Groups groups = app.db().groups();
            app.goTo().addNewPage();
            app.contact().create(new ContactData().withTestFirstName("name").withTestLastName("Lname").inGroup(groups.iterator().next()));
        }

        app.goTo().homePage();
    }

    @Test
    public void testDeleteContactFromGroup() {

        GroupData group = selectGroupToTest();
        Contacts groupContactsBefore = app.db().contactsInGroupByName(group.getName());

        ContactData contact = groupContactsBefore.iterator().next();
        Groups contactGroupsBefore = app.db().contactById(contact.getId()).getGroups();


        app.goTo().groupPage(group);
        app.contact().deleteContactFromGroup(contact);


        Contacts groupContactsAfter = app.db().contactsInGroupByName(group.getName());
        Groups contactGroupsAfter = app.db().contactById(contact.getId()).getGroups();

        assertEquals(contactGroupsAfter.size(), contactGroupsBefore.size() - 1);
        assertThat(contactGroupsAfter, equalTo(contactGroupsBefore.without(app.db().groupByName(group.getName()))));

        assertEquals(groupContactsAfter.size(), groupContactsBefore.size() - 1);
        assertThat(groupContactsAfter, equalTo(groupContactsBefore.without(app.db().contactById(contact.getId()))));

    }

    private GroupData selectGroupToTest() {
        Groups groups = app.db().groups();
        for (GroupData group : groups) {
            if (app.db().contactsInGroupByName(group.getName()).size() > 0) {
                return group;
            }
        }
        GroupData groupForTest = groups.iterator().next();
        Contacts contacts = app.db().contacts();
        app.contact().addContactToGroup(contacts.iterator().next(), groupForTest);
        app.goTo().homePage();
        return groupForTest;
    }

}