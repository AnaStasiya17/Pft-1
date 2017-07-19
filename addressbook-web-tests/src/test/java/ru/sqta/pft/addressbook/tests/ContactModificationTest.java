package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;
import ru.sqta.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Анастасия Цыбулько on 30.06.2017.
 */
public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withTestFirstName("testFirstName")
                    .withTestLastName("testLastName").withTestAddress("testAddress").withTestHome("testHome")
                    .withTestMobile("testMobile").withTestEmail("testEmail").withTestWork("testWork"));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();

        ContactData modifiedContact = before.iterator().next();

        ContactData contact = new ContactData().
                withId(modifiedContact.getId()).withTestFirstName("UpdFname").withTestLastName("UpdLname");
        app.contact().modify(contact);
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(app.db().contactById(modifiedContact.getId()))));
    }

}
